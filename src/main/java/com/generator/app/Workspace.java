package com.generator.app;

import com.generator.app.nodes.NeoNode;
import com.generator.app.nodes.NeoRelationship;
import com.generator.neo.NeoModel;
import com.generator.util.ColorBrewerSelector;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.piccolo2d.PCamera;
import org.piccolo2d.PCanvas;
import org.piccolo2d.PLayer;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;
import org.piccolo2d.nodes.PPath;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import static com.generator.app.AppEvents.*;
import static com.generator.neo.NeoModel.Committer;
import static com.generator.util.NeoUtil.*;

/**
 * Created 18.07.17.
 */
public final class Workspace extends JPanel {

   public final Map<Long, NeoNode> layerNodes = new LinkedHashMap<>();
   public final Map<Long, NeoRelationship> layerRelations = new LinkedHashMap<>();

   public final App app;
   final NodeCanvas nodeCanvas;

   Workspace(App app) {
      super(new BorderLayout());
      this.app = app;
      this.nodeCanvas = new NodeCanvas();
      final NodeDetailPanel detailPanel = new NodeDetailPanel(app, this);

      final JScrollPane newLeftComponent = new JScrollPane(nodeCanvas);
      newLeftComponent.getViewport().setPreferredSize(app.model.getCanvasSize());
      newLeftComponent.getViewport().setSize(app.model.getCanvasSize());

      final JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, newLeftComponent, detailPanel);
      splitPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, pce -> SwingUtilities.invokeLater(() -> app.model.onWorkspaceSplitPaneMoved(((JSplitPane) pce.getSource()))));
      add(splitPane, BorderLayout.CENTER);
   }

   public class NodeCanvas extends PCanvas {

      public final Color selectedNodeColor = Color.decode("#d95f0e");
      public final Color highlightedNodeColor = Color.decode("#43a2ca");
      public AppMotif.RelationPaintStrategy relationPaintStrategy = app.model.getRelationPaintStrategy();
      public AppMotif.RelationPathStrategy relationPathStrategy = app.model.getRelationPathStrategy();
      public AppMotif.NodePaintStrategy nodePaintStrategy = app.model.getNodePaintStrategy();

      public final PLayer relationLayer = new PLayer();
      public final PLayer nodeLayer;

      private final Map<Long, PropertyChangeListener> nodeChangeListeners = new ConcurrentHashMap<>();

      private int currentNodeIndex = -1;

      NodeCanvas() {

         setBackground(Color.decode(app.model.getCanvasColor()));

         nodeLayer = getLayer();
         getCamera().addLayer(0, relationLayer);

         // install mouse wheel zoom event handler
         removeInputEventListener(getZoomEventHandler());
         addInputEventListener(new CanvasZoomHandler());

         final PBasicInputEventHandler canvasInputListener = new PBasicInputEventHandler() {

            @Override
            public void mouseEntered(PInputEvent event) {
               if (!this.equals(event.getInputManager().getKeyboardFocus())) {
                  event.getInputManager().setKeyboardFocus(this);
                  requestFocusInWindow();
               }
            }

            @Override
            public void mouseExited(PInputEvent event) {
               event.getInputManager().setKeyboardFocus(null);
            }

            @Override
            public void mouseClicked(PInputEvent event) {

               if (!this.equals(event.getInputManager().getKeyboardFocus()))
                  event.getInputManager().setKeyboardFocus(this);

               if (app.model.graph() == null) return;

               if (event.isRightMouseButton()) {
                  SwingUtilities.invokeLater(() -> showContextMenu(event));
               } else if (event.isLeftMouseButton()) {
                  clearSelection();

               }
            }

            private void showContextMenu(PInputEvent event) {
               final JPopupMenu pop = new JPopupMenu();

               Workspace.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

               app.model.graph().doInTransaction(new NeoModel.Committer() {
                  @Override
                  public void doAction(Transaction tx) throws Throwable {

                     pop.add(newNodeAction());

                     final JMenu pluginsMenu = getPluginsMenu();
                     if (pluginsMenu.getMenuComponents().length > 0) pop.add(pluginsMenu);

                     final JMenu selectAllMenu = getSelectAllMenu();
                     if (selectAllMenu.getMenuComponents().length > 0) pop.add(selectAllMenu);

                     addSelectedRelationsActions(pop);
                     addSelectedNodesActions(pop);
                     addLayoutMenu(pop);
                     pop.add(setCanvasBackgroundAction());


                     pop.add(centerNodesAction());

                  }

                  @Override
                  public void exception(Throwable throwable) {
                     SwingUtil.showException(NodeCanvas.this, throwable);
                  }
               });

               Workspace.this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
               pop.show(NodeCanvas.this, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
            }

            private void clearSelection() {
               SwingUtilities.invokeLater(() -> {
                  for (Object o : nodeLayer.getAllNodes()) {
                     if (o instanceof NeoNode)
                        ((NeoNode) o).unselect();
                  }
                  for (Object o : relationLayer.getAllNodes()) {
                     if (o instanceof PPath) {
                        final NeoRelationship neoRelationship = layerRelations.get(((PPath) o).getAttribute("id"));
                        neoRelationship.unselect();
                     }
                  }
                  app.events.firePropertyChange(NODES_SELECTED, Collections.emptySet());
                  app.events.firePropertyChange(RELATIONS_SELECTED, Collections.emptySet());
               });
            }

            @Override
            public void keyPressed(PInputEvent event) {
               switch (event.getKeyCode()) {

                  case KeyEvent.VK_Z:
                     SwingUtilities.invokeLater(() -> app.undoLastTransaction());
                     break;

                  case KeyEvent.VK_A:
                     selectAllNodes();
                     break;

                  case KeyEvent.VK_H:
                     showHelp(NodeCanvas.this);
                     break;

                  case KeyEvent.VK_W:
                     iterateNodes();
                     break;

                  case KeyEvent.VK_F:

                     if (!event.isControlDown()) break;
                     showSearch(app);
                     break;

                  case KeyEvent.VK_E:
                     expandSelectedNodes(event);
                     break;

                  case KeyEvent.VK_C:
                     SwingUtilities.invokeLater(() -> app.events.firePropertyChange(NODES_CLOSED, getSelectedNodes()));
                     break;

                  case KeyEvent.VK_I:
                     invertSelection();
                     break;

                  case KeyEvent.VK_V:
                     changeRelationPaintStrategy();
                     break;

                  case KeyEvent.VK_N:
                     changeNodePaintStrategy();
                     break;

                  case KeyEvent.VK_L:
                     changeRelationPathPaintStrategy();
                     break;

                  case KeyEvent.VK_R:
                     retainSelectedNodes();
                     break;

                  case KeyEvent.VK_1:
                     listSelectedNodesAtMousePosition();
                     break;
               }
            }

            @Override
            public void mouseMoved(PInputEvent event) {
               invalidate();
               repaint();
            }
         };

         addInputEventListener(canvasInputListener);

         app.events.addPropertyChangeListener(AppEvents.UNDO_LAST_DELETE, new TransactionalPropertyChangeListener<Object, App.AppModel.TransactionHistory>(app) {
            @Override
            protected void propertyChange(Object oldValue, App.AppModel.TransactionHistory history) {
               final Set<NodeLoadEvent> restored = new LinkedHashSet<>();
               for (Node node : history.restore())
                  restored.add(new NodeLoadEvent(node));
               app.events.firePropertyChange(NODE_LOAD, restored);
            }
         });

         app.events.addPropertyChangeListener(NODE_LOAD, new AppEvents.TransactionalPropertyChangeListener<Object, Set<AppEvents.NodeLoadEvent>>(getClass(), NodeCanvas.this, app) {

            @Override
            protected void propertyChange(Object oldValue, Set<AppEvents.NodeLoadEvent> nodes) {

               if (nodes.isEmpty()) return;

               for (AppEvents.NodeLoadEvent nodeLoadEvent : nodes) {
                  final Node node = nodeLoadEvent.node;

                  if (layerNodes.containsKey(node.getId())) {
                     SwingUtilities.invokeLater(() -> {
                        final NeoNode pNode = layerNodes.get(node.getId());
                        pNode.select();
                        if (nodeLoadEvent.centerOnScreen)
                           nodeCanvas.getCamera().animateViewToCenterBounds(pNode.getGlobalFullBounds(), false, 500);
                     });

                  } else {

                     final NeoNode newPNode = new NeoNode(Workspace.this, NodeCanvas.this, node, nodeLoadEvent.position, canvasInputListener, nodeLayer);
                     layerNodes.put(node.getId(), newPNode);
                     nodeLayer.addChild(newPNode);

                     nodeChangeListeners.put(node.getId(), new AppEvents.TransactionalPropertyChangeListener<Object, Object>(getClass(), NodeCanvas.this, app) {
                        @Override
                        protected void propertyChange(Object oldValue, Object newValue) {
                           newPNode.setPaintStrategy(nodePaintStrategy);
//                           newPNode.setText(getNodeText(nodePaintStrategy, node));
                        }
                     });
                     app.events.addPropertyChangeListener(NODE_CHANGED + node.getId(), nodeChangeListeners.get(node.getId()));

                     // link any existing nodes to the new node:
                     for (Relationship relationship : node.getRelationships(Direction.INCOMING)) {
                        if (layerNodes.containsKey(other(node, relationship).getId()) && !layerRelations.containsKey(relationship.getId())) {
                           final NeoNode source = layerNodes.get(other(node, relationship).getId());
                           final NeoRelationship nodeRelation = new NeoRelationship(Workspace.this, NodeCanvas.this, relationship, source, newPNode);
                           layerRelations.put(relationship.getId(), nodeRelation);
                           relationLayer.addChild(nodeRelation.path);
                        }
                     }

                     for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) {
                        if (layerNodes.containsKey(other(node, relationship).getId()) && !layerRelations.containsKey(relationship.getId())) {
                           final NeoNode target = layerNodes.get(other(node, relationship).getId());
                           final NeoRelationship nodeRelation = new NeoRelationship(Workspace.this, NodeCanvas.this, relationship, newPNode, target);
                           layerRelations.put(relationship.getId(), nodeRelation);
                           relationLayer.addChild(nodeRelation.path);
                        }
                     }
                     newPNode.select();
                     if (nodeLoadEvent.centerOnScreen)
                        nodeCanvas.getCamera().animateViewToCenterBounds(newPNode.getGlobalFullBounds(), false, 500);
                  }
               }

               app.events.firePropertyChange(NODES_SELECTED, getSelectedNodes());
            }
         });

         app.events.addPropertyChangeListener(RELATIONS_ADDED, new AppEvents.TransactionalPropertyChangeListener<Object, Set<Relationship>>(getClass(), NodeCanvas.this, app) {

            @Override
            protected void propertyChange(Object oldValue, Set<Relationship> relations) {
               for (Relationship relationship : relations) {
                  if (layerNodes.containsKey(relationship.getStartNode().getId()) && layerNodes.containsKey(relationship.getEndNode().getId()) && !layerRelations.containsKey(relationship.getId())) {
                     final NeoRelationship nodeRelation = new NeoRelationship(Workspace.this, NodeCanvas.this, relationship, layerNodes.get(relationship.getStartNode().getId()), layerNodes.get(relationship.getEndNode().getId()));
                     layerRelations.put(relationship.getId(), nodeRelation);
                     relationLayer.addChild(nodeRelation.path);
                  }
               }
            }
         });

         app.events.addPropertyChangeListener(AppEvents.NODES_CLOSED, evt -> {
            for (NeoNode neoNode : (Set<NeoNode>) evt.getNewValue()) {
               final NeoNode remove = layerNodes.remove(neoNode.id());
               if (remove == null) return;

               app.model.graph().doInTransaction(new NeoModel.Committer() {
                  @Override
                  public void doAction(Transaction tx) throws Throwable {
                     // save last position
                     final Rectangle2D rectangle2D = neoNode.getFullBoundsReference().getBounds2D();
                     remove.getNode().setProperty(AppMotif.Properties.x.name(), rectangle2D.getX());
                     remove.getNode().setProperty(AppMotif.Properties.y.name(), rectangle2D.getY());
                  }

                  @Override
                  public void exception(Throwable throwable) {
                     // ignore
                  }
               });

               app.events.removePropertyChangeListener(AppEvents.NODE_CHANGED + remove.id(), nodeChangeListeners.remove(remove.id()));

               nodeLayer.removeChild(remove);
            }
         });

         app.events.addPropertyChangeListener(RELATIONS_CLOSED, evt -> {
            for (NeoRelationship neoRelationship : (Set<NeoRelationship>) evt.getNewValue()) {
               final NeoRelationship remove = layerRelations.remove(neoRelationship.id());
               if (remove == null) return;
               relationLayer.removeChild(remove.path);
            }
         });

         app.events.addPropertyChangeListener(NODES_DELETED, evt -> {
            final Set<NeoNode> removedNodes = new LinkedHashSet<>();
            for (Long neoNode : (Set<Long>) evt.getNewValue()) {
               final NeoNode remove = layerNodes.remove(neoNode);
               if (remove == null) return;
               nodeLayer.removeChild(remove);
               removedNodes.add(remove);
            }
         });

         app.events.addPropertyChangeListener(RELATIONS_DELETED, evt -> {
            for (Long relationId : ((Set<Long>) evt.getNewValue())) {
               final NeoRelationship relationship = layerRelations.get(relationId);
               if (relationship == null) continue;
               relationship.removeFromCanvas();
            }
         });

         app.events.addPropertyChangeListener(RELATION_PAINTSTRATEGY_CHANGED, new AppEvents.TransactionalPropertyChangeListener<Object, AppMotif.RelationPaintStrategy>(NodeCanvas.class, NodeCanvas.this, app) {
            @Override
            protected void propertyChange(Object oldValue, AppMotif.RelationPaintStrategy newValue) {
               layerRelations.values().forEach(neoRelationshipPath -> neoRelationshipPath.setRelationPaintStrategy(newValue));
            }
         });

         app.events.addPropertyChangeListener(RELATION_PATHSTRATEGY_CHANGED, evt -> {
            relationPathStrategy = (AppMotif.RelationPathStrategy) evt.getNewValue();
            layerRelations.values().forEach(neoRelationshipPath -> neoRelationshipPath.setRelationPathStrategy());
            SwingUtilities.invokeLater(() -> {
               invalidate();
               repaint();
            });
         });

         app.events.addPropertyChangeListener(NODE_PAINTSTRATEGY_CHANGED, new AppEvents.TransactionalPropertyChangeListener<Object, AppMotif.NodePaintStrategy>(getClass(), NodeCanvas.this, app) {
            @Override
            protected void propertyChange(Object oldValue, AppMotif.NodePaintStrategy nodePaintStrategy) {
               layerNodes.values().forEach(neoNode -> neoNode.setPaintStrategy(nodePaintStrategy));
               SwingUtilities.invokeLater(() -> {
                  invalidate();
                  repaint();
               });
            }
         });

         app.events.addPropertyChangeListener(NODE_COLOR_CHANGED, new AppEvents.TransactionalPropertyChangeListener<String, Color>(getClass(), NodeCanvas.this, app) {
            @Override
            protected void propertyChange(String label, Color color) {
               for (NeoNode neoNode : layerNodes.values())
                  if (hasLabel(neoNode.getNode(), label))
                     neoNode.setColor(color);
               layerRelations.values().forEach(neoRelationshipPath -> neoRelationshipPath.setRelationPaintStrategy(relationPaintStrategy));
            }
         });

         app.events.addPropertyChangeListener(GRAPH_NEW, new AppEvents.TransactionalPropertyChangeListener<Object, Object>(getClass(), NodeCanvas.this, app) {
            @Override
            protected void propertyChange(Object oldValue, Object newValue) {
               relationLayer.removeAllChildren();
               nodeLayer.removeAllChildren();
               layerNodes.clear();
               layerRelations.clear();

               System.out.println("nodeChange listeners before " + nodeChangeListeners.size());
               for (Map.Entry<Long, PropertyChangeListener> entry : nodeChangeListeners.entrySet())
                  app.events.removePropertyChangeListener(AppEvents.NODE_CHANGED + entry.getKey(), entry.getValue());
               System.out.println("nodeChange listeners after");
               nodeChangeListeners.clear();

               final Node layoutNode = AppMotif.getLayoutNode(app, AppMotif.Properties._lastLayout.name());
               if (layoutNode == null) return;

               app.events.firePropertyChange(NODE_LOAD, AppMotif.getLayoutNodes(layoutNode));
            }
         });
      }

      private void addSelectedNodesActions(JPopupMenu pop) {
         final Set<NeoNode> selectedNodes = getSelectedNodes();
         if (!selectedNodes.isEmpty()) {
            pop.add(new App.TransactionAction("Close selected nodes", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  app.events.firePropertyChange(NODES_CLOSED, getSelectedNodes());
               }
            });

            pop.add(new App.TransactionAction("Delete selected nodes", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  if (SwingUtil.showConfirmDialog(app, "Delete " + selectedNodes.size() + " node" + (selectedNodes.size() == 1 ? "" : "s") + " and their relations ?")) {

                     final Set<Node> nodes = new LinkedHashSet<>();
                     for (NeoNode selectedNode : selectedNodes)
                        nodes.add(selectedNode.getNode());

                     final Set<NeoNode> allNodes = nodeCanvas.getAllNodes();
                     final Set<Node> visibleNodes = new LinkedHashSet<>();
                     for (NeoNode neoNode : allNodes)
                        visibleNodes.add(neoNode.getNode());

                     // check if there are dependent nodes in graph (which are not currently visible) which are dependent on the nodes to delete:
                     final Set<Node> dependentNodes = new LinkedHashSet<>();
                     for (Node node : nodes) {
                        incoming(node).forEach(relationship -> {
                           final Node other = NeoUtil.other(node, relationship);
                           if (visibleNodes.contains(other)) return;
                           if (hasLabel(other, AppMotif.Entities._Layout))
                              return; // ignore layout-relations
                           dependentNodes.add(other);
                        });
                     }

                     final StringBuilder out = new StringBuilder();
                     if (!dependentNodes.isEmpty())
                        for (Node dependentNode : dependentNodes)
                           out.append(NeoUtil.getNameAndLabelsFrom(dependentNode)).append("\n");
                     System.out.println(out);

                     if (dependentNodes.isEmpty() || SwingUtil.showConfirmDialog(app, "There are " + dependentNodes.size() + " nodes in graph which are dependent on nodes to delete. Are you sure you want to delete ?"))
                        app.model.deleteNodes(nodes);
                  }
               }
            });
         }
      }

      @NotNull
      private App.TransactionAction setCanvasBackgroundAction() {
         return new App.TransactionAction("Set background", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final ColorBrewerSelector editor = new ColorBrewerSelector();

               SwingUtil.showDialog(editor, app, "Select color", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {
                     final Color color = editor.getSelectedColor();
                     if (color == null) return;

                     app.model.setCanvasColor(String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue()));
                     SwingUtilities.invokeLater(() -> NodeCanvas.this.setBackground(color));
                  }
               });
            }
         };
      }

      @NotNull
      private App.TransactionAction centerNodesAction() {
         return new App.TransactionAction("Center Nodes", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Rectangle2D bounds2D = nodeCanvas.getCamera().getViewBounds().getBounds2D();

               double startX = bounds2D.getX();
               double startY = bounds2D.getY();

               final Random random = new Random(System.currentTimeMillis());
               for (NeoNode neoNode : getAllNodes()) {

                  final Point2D offset = neoNode.getOffset();
                  if (offset.getX() >= startX && offset.getX() <= (bounds2D.getWidth() + startX))
                     if (offset.getY() >= startY && offset.getY() <= (bounds2D.getWidth() + startY))
                        continue;


                  double nodeX = random.nextInt((int) bounds2D.getWidth()) + startX;
                  double nodeY = random.nextInt((int) bounds2D.getHeight()) + startY;
                  neoNode.setOffset(new Point2D.Double(nodeX, nodeY));
               }
            }
         };
      }

      private void addLayoutMenu(JPopupMenu pop) {
         if (nodeLayer.getAllNodes().size() > 0) {
            final JMenu saveLayout = new JMenu("Save Layout");
            saveLayout.add(new App.TransactionAction("Save...", app) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  final String layoutName = SwingUtil.showInputDialog("Layout name", NodeCanvas.this);
                  if (layoutName == null) return;

                  AppMotif.saveLayout(app, layoutName, getAllNodes());
               }
            });

            final Set<Node> layoutNodes = AppMotif.getAllLayouts(app);
            for (Node layoutNode : layoutNodes) {
               saveLayout.add(new App.TransactionAction(getString(layoutNode, AppMotif.Properties.name.name()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     AppMotif.saveLayout(layoutNode, getAllNodes());
                  }
               });
            }

            pop.add(saveLayout);
         }

         final JMenu loadLayouts = new JMenu("Load Layouts");
         AppMotif.getAllLayouts(app).forEach(layoutNode -> loadLayouts.add(new App.TransactionAction(getString(layoutNode, AppMotif.Properties.name.name()), app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx1) throws Exception {
               app.events.firePropertyChange(NODE_LOAD, AppMotif.getLayoutNodes(layoutNode));
            }
         }));
         pop.add(loadLayouts);
      }

      private void addSelectedRelationsActions(JPopupMenu pop) {
         final Set<NeoRelationship> selectedRelations = getSelectedRelations();
         if (selectedRelations.size() > 0) {
            pop.add(new App.TransactionAction("Reverse Direction on " + selectedRelations.size() + " relations", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (NeoRelationship selectedRelation : selectedRelations) {
                     final Relationship relationship = selectedRelation.getRelationship();
                     final Relationship newRelationship = relationship.getEndNode().createRelationshipTo(relationship.getStartNode(), relationship.getType());
                     for (String key : relationship.getPropertyKeys())
                        newRelationship.setProperty(key, relationship.getProperty(key));
                     relationship.delete();
                  }
               }
            });

            pop.add(new App.TransactionAction("Close selected relations", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  app.events.firePropertyChange(AppEvents.RELATIONS_CLOSED, getSelectedRelations());
               }
            });

            pop.add(new App.TransactionAction("Delete selected relations", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  if (SwingUtil.showConfirmDialog(app, "Delete " + selectedRelations.size() + " relation" + (selectedRelations.size() == 1 ? "" : "s") + " ?")) {
                     final Set<Relationship> relations = new LinkedHashSet<>();
                     for (NeoRelationship selectedRelation : selectedRelations)
                        relations.add(selectedRelation.getRelationship());
                     app.model.deleteRelations(relations);
                  }
               }
            });

            pop.add(new App.TransactionAction("Change Property name for selected relations", app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Set<String> existing = new LinkedHashSet<>();
                  for (NeoRelationship selectedRelation : selectedRelations) {
                     for (String property : selectedRelation.getRelationship().getPropertyKeys())
                        existing.add(property);
                  }

                  final JComboBox<String> cboExisting = new JComboBox<>(existing.toArray(new String[existing.size()]));
                  final JTextField txtNewProperty = new JTextField();

                  final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref,4dlu,pref");
                  editor.addLabel("Old Property", 1, 1);
                  editor.add(cboExisting, 3, 1);
                  editor.addLabel("New Property", 1, 3);
                  editor.add(txtNewProperty, 3, 3);
                  editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

                  SwingUtil.showDialog(editor, app, "New Property", new SwingUtil.ConfirmAction() {

                     @Override
                     public void verifyAndCommit() throws Exception {

                        final String newPropertyName = txtNewProperty.getText().trim();
                        final String existingPropertyName = (String) cboExisting.getSelectedItem();

                        app.model.graph().doInTransaction(new Committer() {
                           @Override
                           public void doAction(Transaction tx) throws Throwable {

                              for (NeoRelationship selectedRelation : selectedRelations) {
                                 final Relationship relationship = selectedRelation.getRelationship();
                                 if(relationship.hasProperty(existingPropertyName)) {
                                    relationship.setProperty(newPropertyName, relationship.getProperty(existingPropertyName));
                                    relationship.removeProperty(existingPropertyName);
                                 }
                              }
                           }

                           @Override
                           public void exception(Throwable throwable) {
                              SwingUtil.showExceptionNoStack(app, throwable);
                           }
                        });
                     }
                  });
               }
            });
         }
      }

      @NotNull
      private JMenu getSelectAllMenu() {
         final JMenu selectAllMenu = new JMenu("Select all..");
         selectAllMenu.add(new App.TransactionAction("Nodes on canvas", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               selectAllNodes();
            }
         });

         final Set<String> distinctLabels = new TreeSet<>();
         for (Object o : nodeLayer.getAllNodes()) {
            if (o instanceof NeoNode) {
               final NeoNode pNode = (NeoNode) o;
               for (Label label : pNode.getNode().getLabels()) {
                  if (distinctLabels.contains(label.name())) continue;
                  distinctLabels.add(label.name());
               }
            }
         }
         if (!distinctLabels.isEmpty()) {
            final JMenu selectAllNodesMenu = new JMenu("Nodes");
            for (String label : distinctLabels) {
               selectAllNodesMenu.add(new App.TransactionAction(label, app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) {
                     final Set<NeoNode> selectedNodes = new LinkedHashSet<>();
                     for (Object o : nodeLayer.getAllNodes()) {
                        if (o instanceof NeoNode && hasLabel(((NeoNode) o).getNode(), label)) {
                           final NeoNode neoNode = (NeoNode) o;
                           neoNode.select();
                           selectedNodes.add(neoNode);
                        }
                     }
                     app.events.firePropertyChange(NODES_SELECTED, selectedNodes);
                  }
               });
            }
            selectAllMenu.add(selectAllNodesMenu);
         }

         final Set<String> distinctRelationTypes = new TreeSet<>();
         for (NeoRelationship neoRelationship : layerRelations.values()) {
            if (distinctRelationTypes.contains(neoRelationship.getRelationship().getType().name()))
               continue;
            distinctRelationTypes.add(neoRelationship.getRelationship().getType().name());
         }
         if (!distinctRelationTypes.isEmpty()) {
            final JMenu selectAllRelationsMenu = new JMenu("Relations");
            for (String relationType : distinctRelationTypes) {
               selectAllRelationsMenu.add(new App.TransactionAction(relationType, app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) {
                     final Set<NeoRelationship> selectedRelations = new LinkedHashSet<>();
                     for (Object o : relationLayer.getAllNodes()) {
                        if (o instanceof PPath) {
                           final NeoRelationship neoRelationship = layerRelations.get(((PPath) o).getAttribute("id"));
                           if (neoRelationship.getRelationship().getType().name().equals(relationType)) {
                              neoRelationship.select();
                              selectedRelations.add(neoRelationship);
                           }
                        }
                     }
                     app.events.firePropertyChange(RELATIONS_SELECTED, selectedRelations);
                  }
               });
            }
            selectAllMenu.add(selectAllRelationsMenu);
         }
         return selectAllMenu;
      }

      private void listSelectedNodesAtMousePosition() {
         SwingUtilities.invokeLater(() -> {
            final Point2D startPosition = nodeCanvas.getCamera().localToView(nodeCanvas.getMousePosition());
            final Point2D currentPosition = new Point((int) startPosition.getX(), (int) startPosition.getY());
            int maxX = -1;

            for (NeoNode pNode : getSelectedNodes()) {
               pNode.setOffset(currentPosition);

               final int pNodeMaxX = (int) (pNode.getX() + pNode.getFullBoundsReference().getWidth() + pNode.getOffset().getX());
               if (maxX < pNodeMaxX) maxX = pNodeMaxX + 30;

               currentPosition.setLocation(currentPosition.getX(), currentPosition.getY() + pNode.getFullBoundsReference().getHeight());
               if (currentPosition.getY() >= getVisibleRect().getHeight() - 20)
                  currentPosition.setLocation(maxX, startPosition.getY());
            }
         });
      }

      private void retainSelectedNodes() {
         SwingUtilities.invokeLater(() -> {
            final Set<NeoNode> nodesToClose = new LinkedHashSet<>();
            for (Object o : nodeLayer.getAllNodes()) {
               if (o instanceof NeoNode && !((NeoNode) o).isSelected())
                  nodesToClose.add((NeoNode) o);
            }
            app.events.firePropertyChange(NODES_CLOSED, nodesToClose);
         });
      }

      private void changeRelationPathPaintStrategy() {
         final AppMotif.RelationPathStrategy existingPathStrategy = relationPathStrategy;
         switch (relationPathStrategy) {
            case straightLines:
               relationPathStrategy = AppMotif.RelationPathStrategy.rectangularLines;
               break;
            case rectangularLines:
               relationPathStrategy = AppMotif.RelationPathStrategy.bezierLines;
               break;
            case bezierLines:
               relationPathStrategy = AppMotif.RelationPathStrategy.quadLines;
               break;
            case quadLines:
               relationPathStrategy = AppMotif.RelationPathStrategy.straightLines;
               break;
         }
         app.events.firePropertyChange(RELATION_PATHSTRATEGY_CHANGED, existingPathStrategy, relationPathStrategy);
      }

      private void changeNodePaintStrategy() {
         final AppMotif.NodePaintStrategy existingNodePaintStrategy = nodePaintStrategy;
         switch (nodePaintStrategy) {
            case showNameAndLabels:
               nodePaintStrategy = AppMotif.NodePaintStrategy.showName;
               break;
            case showName:
               nodePaintStrategy = AppMotif.NodePaintStrategy.showLabels;
               break;
            case showLabels:
               nodePaintStrategy = AppMotif.NodePaintStrategy.showProperties;
               break;
            case showProperties:
               nodePaintStrategy = AppMotif.NodePaintStrategy.showValues;
               break;
            case showValues:
               nodePaintStrategy = AppMotif.NodePaintStrategy.showNameAndLabels;
               break;
         }
         app.events.firePropertyChange(NODE_PAINTSTRATEGY_CHANGED, existingNodePaintStrategy, nodePaintStrategy);
      }

      private void changeRelationPaintStrategy() {
         final AppMotif.RelationPaintStrategy existingRelationPaintStrategy = relationPaintStrategy;
         switch (relationPaintStrategy) {
            case showLines:
               relationPaintStrategy = AppMotif.RelationPaintStrategy.showLinesAndLabels;
               break;
            case showLinesAndLabels:
               relationPaintStrategy = AppMotif.RelationPaintStrategy.showNothing;
               break;
            case showNothing:
               relationPaintStrategy = AppMotif.RelationPaintStrategy.showLinesAndProperties;
               break;
            case showLinesAndProperties:
               relationPaintStrategy = AppMotif.RelationPaintStrategy.showLines;
               break;
         }
         app.events.firePropertyChange(RELATION_PAINTSTRATEGY_CHANGED, existingRelationPaintStrategy, relationPaintStrategy);
      }

      private void invertSelection() {
         SwingUtilities.invokeLater(() -> {
            final Set<NeoNode> selectedNodes = getSelectedNodes();
            final Set<NeoNode> newSelectedNodes = new LinkedHashSet<>();
            for (NeoNode neoNode : getAllNodes()) {
               if (selectedNodes.contains(neoNode)) {
                  neoNode.unselect();
                  continue;
               }
               neoNode.select();
               newSelectedNodes.add(neoNode);
            }
            app.events.firePropertyChange(NODES_SELECTED, Collections.emptySet());
            app.events.firePropertyChange(NODES_SELECTED, newSelectedNodes);
         });
      }

      private void expandSelectedNodes(PInputEvent event) {
         if (!event.isControlDown()) {
            SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  final Set<NeoNode> nodes = new LinkedHashSet<>();
                  for (NeoNode selectedNode : getSelectedNodes()) {
                     outgoing(selectedNode.getNode()).forEach(relationship -> {
                        if (!layerRelations.containsKey(relationship.getId())) return;
                        final NeoNode target = (NeoNode) layerRelations.get(relationship.getId()).path.getAttribute("target");
                        target.select();
                        nodes.add(target);
                     });
                  }
                  app.events.firePropertyChange(NODES_SELECTED, nodes);
               }

               @Override
               public void exception(Throwable throwable) {
                  SwingUtil.showException(NodeCanvas.this, throwable);
               }
            }));


         } else {

            SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  final Set<NodeLoadEvent> nodes = new LinkedHashSet<>();
                  for (NeoNode selectedNode : getSelectedNodes()) {
                     final Node node = selectedNode.getNode();
                     outgoing(node).forEach(relationship -> nodes.add(new NodeLoadEvent(other(node, relationship), null)));
                  }
                  app.events.firePropertyChange(NODE_LOAD, nodes);
               }

               @Override
               public void exception(Throwable throwable) {
                  SwingUtil.showException(NodeCanvas.this, throwable);
               }
            }));
         }
      }

      private void iterateNodes() {
         SwingUtilities.invokeLater(() -> {
            final Set<NeoNode> nodes = nodeCanvas.getAllNodes();
            if (nodes.isEmpty()) return;

            currentNodeIndex = currentNodeIndex == -1 ? 0 : currentNodeIndex;

            int index = 0;
            final Iterator<NeoNode> nodeIterator = nodes.iterator();
            NeoNode nodeToCenter = null;
            while (nodeIterator.hasNext()) {
               final NeoNode next = nodeIterator.next();
               if (index < currentNodeIndex) {
                  index++;
                  continue;
               }
               nodeToCenter = next;
               currentNodeIndex += 1;
               break;
            }
            if (nodeToCenter == null) {
               nodeToCenter = nodes.iterator().next();
               currentNodeIndex = 1;
            }

            nodeCanvas.getCamera().animateViewToCenterBounds(nodeToCenter.getGlobalFullBounds(), false, 500);
         });
      }

      private void selectAllNodes() {
         SwingUtilities.invokeLater(() -> {
            final Set<NeoNode> selectedNodes = new LinkedHashSet<>();
            for (Object o : nodeLayer.getAllNodes()) {
               if (o instanceof NeoNode) {
                  final NeoNode neoNode = (NeoNode) o;
                  neoNode.select();
                  selectedNodes.add(neoNode);
               }
            }
            app.events.firePropertyChange(NODES_SELECTED, selectedNodes);
         });
      }

      @NotNull
      public Point2D newRandomPosition() {
         return nodeCanvas.getCamera().getViewBounds().getCenter2D();
      }

      public Set<NeoNode> getSelectedNodes() {
         final Set<NeoNode> nodes = new LinkedHashSet<>();
         for (Object o : nodeLayer.getAllNodes()) {
            if (o instanceof NeoNode) {
               final NeoNode neoNode = (NeoNode) o;
               if (neoNode.isSelected()) nodes.add(neoNode);
            }
         }
         return nodes;
      }

      public Set<NeoRelationship> getSelectedRelations() {
         final Set<NeoRelationship> relations = new LinkedHashSet<>();
         for (Object o : relationLayer.getAllNodes()) {
            if (o instanceof PPath) {
               final NeoRelationship relationship = layerRelations.get(((PPath) o).getAttribute("id"));
               if (relationship.isSelected()) relations.add(relationship);
            }
         }
         return relations;
      }

      public Set<NeoNode> getAllNodes() {
         final Set<NeoNode> nodes = new LinkedHashSet<>();
         for (Object o : nodeLayer.getAllNodes())
            if (o instanceof NeoNode)
               nodes.add((NeoNode) o);
         return nodes;
      }

      Set<NeoRelationship> getAllRelations() {
         final Set<NeoRelationship> relations = new LinkedHashSet<>();
         for (Object o : relationLayer.getAllNodes())
            if (o instanceof PPath)
               relations.add(layerRelations.get(((PPath) o).getAttribute("id")));
         return relations;
      }
   }

   @NotNull
   private JMenu getPluginsMenu() {
      final JMenu pluginsMenu = new JMenu("Plugins");
      for (Plugin plugin : app.getPlugins()) {
         final JMenu pluginMenu = new JMenu(plugin.name);
         plugin.addActionsTo(pluginMenu);
         pluginsMenu.add(pluginMenu);
      }
      return pluginsMenu;
   }

   @NotNull
   private App.TransactionAction newNodeAction() {
      return new App.TransactionAction("New Node", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Set<String> existing = new TreeSet<>();
            app.model.graph().getAllLabelsInUse().forEach(label -> {
               existing.add(label.name());
            });

            final JComboBox<String> cboExisting = new JComboBox<>(existing.toArray(new String[existing.size()]));
            final JTextField txtNewLabel = new JTextField();
            final JTextField txtSearch = new JTextField();

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref,4dlu,pref,4dlu,pref");
            editor.addLabel("Label", 1, 1);
            editor.add(cboExisting, 3, 1);
            editor.addLabel("Search", 1, 3);
            editor.add(txtSearch, 3, 3);
            editor.addLabel("New Label", 1, 5);
            editor.add(txtNewLabel, 3, 5);
            editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

            txtSearch.addKeyListener(new KeyAdapter() {
               @Override
               public void keyReleased(KeyEvent e) {
                  SwingUtilities.invokeLater(new Runnable() {
                     @Override
                     public void run() {
                        final String s = txtSearch.getText().trim().toLowerCase();
                        for (String lbl : existing) {
                           if (lbl.toLowerCase().startsWith(s)) {
                              cboExisting.setSelectedItem(lbl);
                           }
                        }
                     }
                  });
               }
            });

            SwingUtil.showDialog(editor, app, "New Node", new SwingUtil.ConfirmAction() {

               @Override
               public void verifyAndCommit() throws Exception {

                  final String selectedLabel = txtNewLabel.getText().trim().length() == 0 ? (String) cboExisting.getSelectedItem() : txtNewLabel.getText().trim();

                  app.model.graph().doInTransaction(new Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        app.events.firePropertyChange(NODE_LOAD, Collections.singleton(new NodeLoadEvent(app.model.graph().newNode(Label.label(selectedLabel)))));
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }
      };
   }

   private void showHelp(NodeCanvas nodeCanvas) {
      SwingUtilities.invokeLater(() -> {
         String text = "A - select all visible nodes\n" +
               "E - expand selected nodes\n" +
               "C - close selected nodes\n" +
               "I - invert selected/selected nodes\n" +
               "V - toggle relation paint\n" +
               "N - toggle node paint\n" +
               "L - toggle relation lines\n" +
               "R - close all unselected nodes\n" +
               "W - iterate through nodes and center on screen\n" +
               "1 - layout selected nodes outgoing right\n" +
               "2 - layout selected nodes outgoing left\n" +
               "3 - layout selected nodes outgoing up\n" +
               "4 - layout selected nodes outgoing down\n" +
               "1 + Ctrl - layout selected nodes incoming right\n" +
               "2 - layout selected nodes incoming left\n" +
               "3 - layout selected nodes incoming up\n" +
               "4 - layout selected nodes incoming down\n" +
               "H - help" +
               "\n\nOn mouse over node\n" +
               "C - close node\n" +
               "R - keep node and all selected nodes and close unselected nodes\n" +
               "E + Ctrl - Open all outgoing relations from this node\n" +
               "E - Select all visible outgoing nodes from this node (does not open new nodes)\n" +
               "D + Ctrl - Open all incoming relations to this node\n" +
               "D - Select all visible incoming nodes to this node (does not open new nodes)\n" +
               "1 - layout outgoing nodes and relations in a horizontal-tree structure\n" +
               "";

         SwingUtil.showTextResult("Help", text, nodeCanvas, false);

      });
   }

   private static void showSearch(App app) {
      SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            final Set<String> labels = new LinkedHashSet<>();
            app.model.graph().getAllLabelsInUse().forEach(label -> labels.add(label.name()));
            final JComboBox<String> cboLabels = new JComboBox<>(labels.toArray(new String[labels.size()]));
            final JTextField txtLabelSearch = new JTextField();
            txtLabelSearch.addKeyListener(new KeyAdapter() {
               @Override
               public void keyReleased(KeyEvent e) {
                  SwingUtilities.invokeLater(() -> {
                     final String s = txtLabelSearch.getText().trim().toLowerCase();
                     for (String lbl : labels) {
                        if (lbl.toLowerCase().startsWith(s)) {
                           cboLabels.setSelectedItem(lbl);
                        }
                     }
                  });
               }
            });

            final Set<String> relationships = new LinkedHashSet<>();
            app.model.graph().getAllRelationshipTypesInUse().forEach(relationshipType -> relationships.add(relationshipType.name()));
            final JComboBox<String> cboRelationships = new JComboBox<>(relationships.toArray(new String[relationships.size()]));
            final JTextField txtRelationSearch = new JTextField();
            txtRelationSearch.addKeyListener(new KeyAdapter() {
               @Override
               public void keyReleased(KeyEvent e) {
                  SwingUtilities.invokeLater(() -> {
                     final String s = txtRelationSearch.getText().trim().toLowerCase();
                     for (String lbl : relationships) {
                        if (lbl.toLowerCase().startsWith(s)) {
                           cboRelationships.setSelectedItem(lbl);
                        }
                     }
                  });
               }
            });

            final Set<String> properties = new LinkedHashSet<>();
            app.model.graph().getAllPropertyKeys().forEach(new Consumer<String>() {
               @Override
               public void accept(String s) {
                  properties.add(s);
               }
            });
            final JComboBox<String> cboProperties = new JComboBox<>(properties.toArray(new String[properties.size()]));
            final JTextField txtPropertySearch = new JTextField();
            txtPropertySearch.addKeyListener(new KeyAdapter() {
               @Override
               public void keyReleased(KeyEvent e) {
                  SwingUtilities.invokeLater(() -> {
                     final String s = txtPropertySearch.getText().trim().toLowerCase();
                     for (String lbl : properties) {
                        if (lbl.toLowerCase().startsWith(s)) {
                           cboProperties.setSelectedItem(lbl);
                        }
                     }
                  });
               }
            });

            final JRadioButton radLabels = new JRadioButton("Label", true);
            final JRadioButton radRelationtypes = new JRadioButton("Relationtype");
            final ButtonGroup group = new ButtonGroup();
            group.add(radLabels);
            group.add(radRelationtypes);

            final JCheckBox chkProperty = new JCheckBox("Property");
            final JTextField txtValueSearch = new JTextField();

            final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow,4dlu,75dlu:grow,4dlu,75dlu:grow", "pref,4dlu,pref,4dlu,pref");
            editor.add(radLabels, 1, 1);
            editor.add(cboLabels, 3, 1);
            editor.add(txtLabelSearch, 5, 1);
            editor.add(radRelationtypes, 1, 3);
            editor.add(cboRelationships, 3, 3);
            editor.add(txtRelationSearch, 5, 3);
            editor.add(chkProperty, 1, 5);
            editor.add(cboProperties, 3, 5);
            editor.add(txtPropertySearch, 5, 5);
            editor.add(txtValueSearch, 7, 5);

            editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
            SwingUtil.showDialog(editor, app, "Search", new SwingUtil.ConfirmAction("Search") {
               @Override
               public void verifyAndCommit() throws Exception {
                  app.model.graph().doInTransaction(new Committer() {
                     @Override
                     public void doAction(Transaction tx1) throws Throwable {

                        final Set<NodeLoadEvent> nodes = new LinkedHashSet<>();

                        final String propertySearch = (String) cboProperties.getSelectedItem();
                        final String valueSearch = txtValueSearch.getText().trim();

                        if (radLabels.isSelected()) {

                           final String labelSearch = (String) cboLabels.getSelectedItem();
                           if (chkProperty.isSelected()) {
                              app.model.graph().findNodes(Label.label(labelSearch), propertySearch, valueSearch).forEachRemaining(node -> nodes.add(new NodeLoadEvent(node)));
                           } else {
                              app.model.graph().findNodes(Label.label(labelSearch)).forEachRemaining(node -> nodes.add(new NodeLoadEvent(node)));
                           }

                        } else if (radRelationtypes.isSelected()) {

                           final String relationSearch = (String) cboRelationships.getSelectedItem();
                           app.model.graph().getAllRelationships().forEach(relationship -> {
                              if (!relationship.getType().name().equals(relationSearch)) return;
                              if (chkProperty.isSelected() && !relationship.hasProperty(propertySearch) && !valueSearch.equals(relationship.getProperty(propertySearch)))
                                 return;
                              nodes.add(new NodeLoadEvent(relationship.getStartNode()));
                              nodes.add(new NodeLoadEvent(relationship.getEndNode()));
                           });

                        }

                        app.events.firePropertyChange(NODE_LOAD, nodes);
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            });
         }

         @Override
         public void exception(Throwable throwable) {
            SwingUtil.showExceptionNoStack(app, throwable);
         }
      }));
   }

   private static final class CanvasZoomHandler extends PBasicInputEventHandler {

      private double scaleFactor = 0.1d;
      private static final double minZomScale = 0.36d;
      private static final double maxZoomScale = 1.49d;

      CanvasZoomHandler() {
         super();
         final PInputEventFilter eventFilter = new PInputEventFilter();
         eventFilter.rejectAllEventTypes();
         eventFilter.setAcceptsMouseWheelRotated(true);
         setEventFilter(eventFilter);
      }

      public void mouseWheelRotated(final PInputEvent event) {

         final PCamera camera = event.getCamera();

         // max scale min and max:
         if ((camera.getViewScale() < minZomScale && event.getWheelRotation() < 0) || (camera.getViewScale() > maxZoomScale && event.getWheelRotation() > 0))
            return;

         double scale = 1.0d + event.getWheelRotation() * scaleFactor;
         final Point2D viewAboutPoint = event.getPosition();
         camera.scaleViewAboutPoint(scale, viewAboutPoint.getX(), viewAboutPoint.getY());
      }
   }
}