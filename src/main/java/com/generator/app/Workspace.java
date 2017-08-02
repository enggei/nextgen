package com.generator.app;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import com.google.common.util.concurrent.AtomicDouble;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.*;
import org.piccolo2d.PCanvas;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PDragSequenceEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PMouseWheelZoomEventHandler;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.getNameAndLabelsFrom;
import static com.generator.editors.NeoModel.getNameOrTypeFrom;

/**
 * Created 18.07.17.
 */
final class Workspace extends JPanel {

   private static final Random random = new Random(System.currentTimeMillis());

   final Map<Long, NodeCanvas.NeoNode> layerNodes = new LinkedHashMap<>();
   final Map<Long, NodeCanvas.NeoRelationship> layerRelations = new LinkedHashMap<>();

   private final App app;
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

   class NodeCanvas extends PCanvas {

      private final Color selectedNodeColor = Color.decode("#d95f0e");
      private final Color defaultRelationColor = Color.decode("#252525");
      private final Color highlightedNodeColor = Color.decode("#43a2ca");
      private AppMotif.RelationPaintStrategy relationPaintStrategy = app.model.getRelationPaintStrategy();
      private AppMotif.RelationPathStrategy relationPathStrategy = app.model.getRelationPathStrategy();
      private AppMotif.NodePaintStrategy nodePaintStrategy = app.model.getNodePaintStrategy();

      private final PLayer relationLayer = new PLayer();
      private final PLayer nodeLayer;

      NodeCanvas() {

         setBackground(Color.decode(app.model.getCurrentCanvasColor()));

         nodeLayer = getLayer();
         getCamera().addLayer(0, relationLayer);

         // install mouse wheel zoom event handler
         removeInputEventListener(getZoomEventHandler());
         final PMouseWheelZoomEventHandler mouseWheelZoomEventHandler = new PMouseWheelZoomEventHandler();
         mouseWheelZoomEventHandler.zoomAboutMouse();
         addInputEventListener(mouseWheelZoomEventHandler);

         final PBasicInputEventHandler canvasInputListener = new PBasicInputEventHandler() {

            private Point2D mousePosition;

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
                  SwingUtilities.invokeLater(() -> onRightClick(event));
               } else if (event.isLeftMouseButton()) {
                  SwingUtilities.invokeLater(() -> onLeftClick());
               }
            }

            private void onRightClick(PInputEvent event) {
               final JPopupMenu pop = new JPopupMenu();

               Workspace.this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

               app.model.graph().doInTransaction(new NeoModel.Committer() {
                  @Override
                  public void doAction(Transaction tx) throws Throwable {

                     final JMenu selectAllMenu = new JMenu("Select all..");

                     selectAllMenu.add(new App.TransactionAction("Nodes on canvas", app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                           SwingUtilities.invokeLater(() -> {
                              final Set<NodeCanvas.NeoNode> selectedNodes = new LinkedHashSet<>();
                              for (Object o : nodeLayer.getAllNodes()) {
                                 if (o instanceof NodeCanvas.NeoNode) {
                                    final NodeCanvas.NeoNode neoNode = (NodeCanvas.NeoNode) o;
                                    neoNode.select();
                                    selectedNodes.add(neoNode);
                                 }
                              }
                              app.events.fireNodesSelected(selectedNodes);
                           });
                        }
                     });

                     final Set<String> distinctLabels = new TreeSet<>();
                     for (Object o : nodeLayer.getAllNodes()) {
                        if (o instanceof NodeCanvas.NeoNode) {
                           final NodeCanvas.NeoNode pNode = (NodeCanvas.NeoNode) o;
                           for (org.neo4j.graphdb.Label label : pNode.getNode().getLabels()) {
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
                                 final Set<NodeCanvas.NeoNode> selectedNodes = new LinkedHashSet<>();
                                 for (Object o : nodeLayer.getAllNodes()) {
                                    if (o instanceof NodeCanvas.NeoNode && hasLabel(((NodeCanvas.NeoNode) o).getNode(), label)) {
                                       final NodeCanvas.NeoNode neoNode = (NodeCanvas.NeoNode) o;
                                       neoNode.select();
                                       selectedNodes.add(neoNode);
                                    }
                                 }
                                 app.events.fireNodesSelected(selectedNodes);
                              }
                           });
                        }
                        selectAllMenu.add(selectAllNodesMenu);
                     }

                     final Set<String> distinctRelationTypes = new TreeSet<>();
                     for (NodeCanvas.NeoRelationship neoRelationship : layerRelations.values()) {
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
                                 final Set<NodeCanvas.NeoRelationship> selectedRelations = new LinkedHashSet<>();
                                 for (Object o : relationLayer.getAllNodes()) {
                                    if (o instanceof PPath) {
                                       final NodeCanvas.NeoRelationship neoRelationship = layerRelations.get(((PPath) o).getAttribute("id"));
                                       if (neoRelationship.getRelationship().getType().name().equals(relationType)) {
                                          neoRelationship.select();
                                          selectedRelations.add(neoRelationship);
                                       }
                                    }
                                 }
                                 app.events.fireRelationsSelected(selectedRelations);
                              }
                           });
                        }
                        selectAllMenu.add(selectAllRelationsMenu);
                     }

                     if (!distinctLabels.isEmpty() || !distinctRelationTypes.isEmpty())
                        pop.add(selectAllMenu);

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

                                 if (layerNodes.containsKey(newRelationship.getStartNode().getId()) && layerNodes.containsKey(newRelationship.getEndNode().getId())) {
                                    final NodeCanvas.NeoNode source = layerNodes.get(newRelationship.getStartNode().getId());
                                    final NodeCanvas.NeoNode destination = layerNodes.get(newRelationship.getEndNode().getId());
                                    final NodeCanvas.NeoRelationship nodeRelation = new NodeCanvas.NeoRelationship(newRelationship, source, destination);
                                    layerRelations.put(newRelationship.getId(), nodeRelation);
                                    relationLayer.addChild(nodeRelation.path);
                                 }
                                 relationship.delete();
                              }
                           }
                        });

                        pop.add(new App.TransactionAction("Close selected relations", app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                              app.events.fireRelationsClosed(getSelectedRelations());
                           }
                        });

                        pop.add(new App.TransactionAction("Delete selected relations", app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                              if (SwingUtil.showConfirmDialog(app, "Delete " + selectedRelations.size() + " relation" + (selectedRelations.size() == 1 ? "" : "s") + " ?")) {
                                 for (NeoRelationship selectedRelation : selectedRelations)
                                    selectedRelation.getRelationship().delete();
                              }
                           }
                        });
                     }

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
                           app.events.fireNodeLoad(AppMotif.getLayoutNodes(layoutNode));
                        }
                     }));
                     pop.add(loadLayouts);

                     pop.add(new App.TransactionAction("Set background", app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                           final String color = SwingUtil.showInputDialog("Background", NodeCanvas.this, app.model.getCurrentCanvasColor());
                           if (color == null) return;
                           app.model.setCanvasColor(color);
                           SwingUtilities.invokeLater(() -> NodeCanvas.this.setBackground(Color.decode(color)));
                        }
                     });

                     final Set<NodeCanvas.NeoNode> selectedNodes = getSelectedNodes();
                     if (!selectedNodes.isEmpty()) {
                        pop.add(new App.TransactionAction("Close selected nodes", app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                              app.events.fireNodesClosed(getSelectedNodes());
                           }
                        });

                        pop.add(new App.TransactionAction("Delete selected nodes", app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                              if (SwingUtil.showConfirmDialog(app, "Delete " + selectedNodes.size() + " node" + (selectedNodes.size() == 1 ? "" : "s") + " and their relations ?")) {

                                 for (NodeCanvas.NeoNode selectedNode : selectedNodes)
                                    selectedNode.getNode().getRelationships().forEach(Relationship::delete);

                                 for (NodeCanvas.NeoNode selectedNode : selectedNodes)
                                    selectedNode.getNode().delete();
                              }
                           }
                        });
                     }
                  }

                  @Override
                  public void exception(Throwable throwable) {
                     SwingUtil.showException(NodeCanvas.this, throwable);
                  }
               });

               Workspace.this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
               pop.show(NodeCanvas.this, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
            }

            private void onLeftClick() {
               SwingUtilities.invokeLater(() -> {
                  for (Object o : nodeLayer.getAllNodes()) {
                     if (o instanceof NodeCanvas.NeoNode)
                        ((NodeCanvas.NeoNode) o).unselect();
                  }
                  for (Object o : relationLayer.getAllNodes()) {
                     if (o instanceof PPath) {
                        final NodeCanvas.NeoRelationship neoRelationship = layerRelations.get(((PPath) o).getAttribute("id"));
                        neoRelationship.unselect();
                     }
                  }
                  app.events.fireNodesSelected(Collections.emptySet());
                  app.events.fireRelationsSelected(Collections.emptySet());
               });
            }


            @Override
            public void keyPressed(PInputEvent event) {
               switch (event.getKeyCode()) {
                  case KeyEvent.VK_A:
                     SwingUtilities.invokeLater(() -> {
                        final Set<NodeCanvas.NeoNode> selectedNodes = new LinkedHashSet<>();
                        for (Object o : nodeLayer.getAllNodes()) {
                           if (o instanceof NodeCanvas.NeoNode) {
                              final NodeCanvas.NeoNode neoNode = (NodeCanvas.NeoNode) o;
                              neoNode.select();
                              selectedNodes.add(neoNode);
                           }
                        }
                        app.events.fireNodesSelected(selectedNodes);
                     });
                     break;

                  case KeyEvent.VK_H:
                     SwingUtilities.invokeLater(() -> {
                        String text = "A - select all visible nodes\n" +
                              "E - expand selected nodes\n" +
                              "C - close selected nodes\n" +
                              "I - invert selected/selected nodes\n" +
                              "V - toggle relation paint\n" +
                              "N - toggle node paint\n" +
                              "L - toggle relation lines\n" +
                              "R - close all unselected nodes\n" +
                              "1 - layout selected nodes vertical\n" +
                              "2 - layout selected nodes horizontal\n" +
                              "H - help" +
                              "\n\nOn mouse over node\n" +
                              "C - close node\n" +
                              "R - keep node and all selected nodes and close unselected nodes\n" +
                              "E - expand node. Opens all outgoing relations from this node\n" +
                              "D - Opens all incoming relations to this node\n" +
                              "D - Opens all incoming relations to this node\n" +
                              "1 - layout outgoing nodes and relations in a horizontal-tree structure\n" +
                              "";

                        SwingUtil.showTextResult("Help", text, NodeCanvas.this);

                     });
                     break;

                  case KeyEvent.VK_E:
                     SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
                           for (NodeCanvas.NeoNode selectedNode : getSelectedNodes()) {
                              final Node node = selectedNode.getNode();
                              outgoing(node).forEach(relationship -> nodes.add(new AppEvents.NodeLoadEvent(other(node, relationship), null)));
                              app.events.fireNodeLoad(nodes);
                           }
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showException(NodeCanvas.this, throwable);
                        }
                     }));
                     break;

                  case KeyEvent.VK_C:
                     SwingUtilities.invokeLater(() -> app.events.fireNodesClosed(getSelectedNodes()));
                     break;

                  case KeyEvent.VK_I:
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
                        app.events.fireNodesSelected(Collections.emptySet());
                        app.events.fireNodesSelected(newSelectedNodes);
                     });
                     break;

                  case KeyEvent.VK_V:
                     final AppMotif.RelationPaintStrategy existingRelationPaintStrategy = relationPaintStrategy;
                     switch (relationPaintStrategy) {
                        case showLines:
                           relationPaintStrategy = AppMotif.RelationPaintStrategy.showLinesAndLabels;
                           break;
                        case showLinesAndLabels:
                           relationPaintStrategy = AppMotif.RelationPaintStrategy.showNothing;
                           break;
                        case showNothing:
                           relationPaintStrategy = AppMotif.RelationPaintStrategy.showLines;
                           break;
                     }
                     app.events.firePaintStrategyChanged(existingRelationPaintStrategy, relationPaintStrategy);
                     break;

                  case KeyEvent.VK_N:
                     final AppMotif.NodePaintStrategy existingNodePaintStrategy = nodePaintStrategy;
                     switch (nodePaintStrategy) {
                        case showNameAndLabels:
                           nodePaintStrategy = AppMotif.NodePaintStrategy.showName;
                           break;
                        case showName:
                           nodePaintStrategy = AppMotif.NodePaintStrategy.showLabels;
                           break;
                        case showLabels:
                           nodePaintStrategy = AppMotif.NodePaintStrategy.showNameAndLabels;
                           break;
                     }
                     app.events.fireNodePaintStrategyChanged(existingNodePaintStrategy, nodePaintStrategy);
                     break;

                  case KeyEvent.VK_L:
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
                     app.events.fireRelationPathStrategyChanged(existingPathStrategy, relationPathStrategy);
                     break;

                  case KeyEvent.VK_R:
                     SwingUtilities.invokeLater(() -> {
                        final Set<NodeCanvas.NeoNode> nodesToClose = new LinkedHashSet<>();
                        for (Object o : nodeLayer.getAllNodes()) {
                           if (o instanceof NodeCanvas.NeoNode && !((NodeCanvas.NeoNode) o).isSelected())
                              nodesToClose.add((NodeCanvas.NeoNode) o);
                        }
                        app.events.fireNodesClosed(nodesToClose);
                     });
                     break;

                  case KeyEvent.VK_1:
                     SwingUtilities.invokeLater(() -> {
                        final Point2D startPosition = mousePosition == null ? new Point(10, 10) : mousePosition;
                        final Point2D currentPosition = new Point((int) startPosition.getX(), (int) startPosition.getY());
                        int maxX = -1;

                        for (NodeCanvas.NeoNode pNode : getSelectedNodes()) {
                           pNode.setOffset(currentPosition);

                           final int pNodeMaxX = (int) (pNode.getX() + pNode.getFullBoundsReference().getWidth() + pNode.getOffset().getX());
                           if (maxX < pNodeMaxX) maxX = pNodeMaxX + 30;

                           currentPosition.setLocation(currentPosition.getX(), currentPosition.getY() + pNode.getFullBoundsReference().getHeight());
                           if (currentPosition.getY() >= getVisibleRect().getHeight() - 20)
                              currentPosition.setLocation(maxX, startPosition.getY());
                        }
                     });
                     break;

                  case KeyEvent.VK_2:
                     SwingUtilities.invokeLater(() -> {
                        final Point2D startPosition = mousePosition == null ? new Point(10, 10) : mousePosition;
                        final Point2D currentPosition = new Point((int) startPosition.getX(), (int) startPosition.getY());
                        int maxY = -1;
                        for (NodeCanvas.NeoNode pNode : getSelectedNodes()) {
                           pNode.setOffset(currentPosition);

                           final int pNodeMaxY = (int) (pNode.getY() + pNode.getFullBoundsReference().getHeight() + pNode.getOffset().getY());
                           if (maxY < pNodeMaxY) maxY = pNodeMaxY + 10;

                           currentPosition.setLocation(currentPosition.getX() + pNode.getFullBoundsReference().getWidth(), currentPosition.getY());
                           if (currentPosition.getX() >= getVisibleRect().getWidth() - 10)
                              currentPosition.setLocation(startPosition.getX(), maxY);
                        }
                     });
                     break;
               }
            }

            @Override
            public void mouseMoved(PInputEvent event) {
               mousePosition = event.getCanvasPosition();
               invalidate();
               repaint();
            }
         };
         addInputEventListener(canvasInputListener);

         app.events.addNodesLoadListener(new AppEvents.EventsTransactionHandler(getClass(), NodeCanvas.this, app.model) {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final Set<AppEvents.NodeLoadEvent> nodes = (Set<AppEvents.NodeLoadEvent>) evt.getNewValue();
               for (AppEvents.NodeLoadEvent nodeLoadEvent : nodes) {
                  final Node node = nodeLoadEvent.node;

                  if (layerNodes.containsKey(node.getId())) {
                     SwingUtilities.invokeLater(() -> {
                        final NodeCanvas.NeoNode pNode = layerNodes.get(node.getId());
                        pNode.select();
                     });

                  } else {

                     final NodeCanvas.NeoNode newPNode = new NodeCanvas.NeoNode(node, nodeLoadEvent.position, canvasInputListener, nodeLayer);
                     layerNodes.put(node.getId(), newPNode);
                     nodeLayer.addChild(newPNode);

                     // link any existing nodes to the new node:
                     for (Relationship relationship : node.getRelationships(Direction.INCOMING)) {
                        if (layerNodes.containsKey(other(node, relationship).getId()) && !layerRelations.containsKey(relationship.getId())) {
                           final NodeCanvas.NeoNode source = layerNodes.get(other(node, relationship).getId());
                           final NodeCanvas.NeoRelationship nodeRelation = new NodeCanvas.NeoRelationship(relationship, source, newPNode);
                           layerRelations.put(relationship.getId(), nodeRelation);
                           relationLayer.addChild(nodeRelation.path);
                        }
                     }

                     for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) {
                        if (layerNodes.containsKey(other(node, relationship).getId()) && !layerRelations.containsKey(relationship.getId())) {
                           final NodeCanvas.NeoNode target = layerNodes.get(other(node, relationship).getId());
                           final NodeCanvas.NeoRelationship nodeRelation = new NodeCanvas.NeoRelationship(relationship, newPNode, target);
                           layerRelations.put(relationship.getId(), nodeRelation);
                           relationLayer.addChild(nodeRelation.path);
                        }
                     }
                     newPNode.select();
                  }
               }

               app.events.fireNodesSelected(getSelectedNodes());
            }
         });

         app.events.addRelationsAddedListener(new AppEvents.EventsTransactionHandler(getClass(), NodeCanvas.this, app.model) {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final Set<Relationship> relations = (Set<Relationship>) evt.getNewValue();
               for (Relationship relationship : relations) {
                  if (layerNodes.containsKey(relationship.getStartNode().getId()) && layerNodes.containsKey(relationship.getEndNode().getId())) {
                     final NodeCanvas.NeoRelationship nodeRelation = new NodeCanvas.NeoRelationship(relationship, layerNodes.get(relationship.getStartNode().getId()), layerNodes.get(relationship.getEndNode().getId()));
                     layerRelations.put(relationship.getId(), nodeRelation);
                     relationLayer.addChild(nodeRelation.path);
                  }
               }
            }
         });

         app.events.addNodesClosedListener(evt -> {
            for (NodeCanvas.NeoNode neoNode : (Set<NodeCanvas.NeoNode>) evt.getNewValue()) {
               final NodeCanvas.NeoNode remove = layerNodes.remove(neoNode.id());
               if (remove == null) return;

               app.model.graph().doInTransaction(new NeoModel.Committer() {
                  @Override
                  public void doAction(Transaction tx) throws Throwable {
                     // save last position
                     final Rectangle2D rectangle2D = neoNode.getFullBoundsReference().getBounds2D();
                     remove.getNode().setProperty(AppMotif.Properties._x.name(), rectangle2D.getX());
                     remove.getNode().setProperty(AppMotif.Properties._y.name(), rectangle2D.getY());
                  }

                  @Override
                  public void exception(Throwable throwable) {
                     // ignore
                  }
               });

               nodeLayer.removeChild(remove);
            }
         });

         app.events.addRelationsClosedListener(evt -> {
            for (NeoRelationship neoRelationship : (Set<NeoRelationship>) evt.getNewValue()) {
               final NeoRelationship remove = layerRelations.remove(neoRelationship.id());
               if (remove == null) return;
               relationLayer.removeChild(remove.path);
            }
         });

         app.events.addNodesDeletedListener(evt -> {
            final Set<NodeCanvas.NeoNode> removedNodes = new LinkedHashSet<>();
            for (Long neoNode : (Set<Long>) evt.getNewValue()) {
               final NodeCanvas.NeoNode remove = layerNodes.remove(neoNode);
               if (remove == null) return;
               nodeLayer.removeChild(remove);
               removedNodes.add(remove);
            }
            System.out.println("todo: check if this is necessary, other components should listen for nodes-deleted, and not get it from canvas");
            SwingUtilities.invokeLater(() -> app.events.fireNodesClosed(removedNodes));
         });

         app.events.addRelationPaintStrategyChangedListener(evt -> {
            relationPaintStrategy = (AppMotif.RelationPaintStrategy) evt.getNewValue();
            layerRelations.values().forEach(neoRelationshipPath -> neoRelationshipPath.setRelationPaintStrategy(relationPaintStrategy));
         });

         app.events.addRelationPathStrategyChangedListener(evt -> {
            relationPathStrategy = (AppMotif.RelationPathStrategy) evt.getNewValue();
            layerRelations.values().forEach(neoRelationshipPath -> neoRelationshipPath.setRelationPathStrategy());
            SwingUtilities.invokeLater(() -> {
               invalidate();
               repaint();
            });
         });

         app.events.addNodePaintStrategyChangedListener(new AppEvents.EventsTransactionHandler(getClass(), NodeCanvas.this, app.model) {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               nodePaintStrategy = (AppMotif.NodePaintStrategy) evt.getNewValue();
               layerNodes.values().forEach(neoNode -> neoNode.setText(getNodeText(nodePaintStrategy, neoNode.getNode())));
               SwingUtilities.invokeLater(() -> {
                  invalidate();
                  repaint();
               });
            }
         });

         app.events.addNodeColorChangedListener(new AppEvents.EventsTransactionHandler(getClass(), NodeCanvas.this, app.model) {
            @Override
            public void doAction(Transaction tx) throws Throwable {
               final String label = (String) evt.getOldValue();
               final Color color = (Color) evt.getNewValue();
               for (NodeCanvas.NeoNode neoNode : layerNodes.values())
                  if (hasLabel(neoNode.getNode(), label))
                     neoNode.setColor(color);
               layerRelations.values().forEach(neoRelationshipPath -> neoRelationshipPath.setRelationPaintStrategy(relationPaintStrategy));
            }
         });

         app.events.addGraphNewListener(evt -> {

            relationLayer.removeAllChildren();
            nodeLayer.removeAllChildren();
            layerNodes.clear();
            layerRelations.clear();

            SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {

                  final Node layoutNode = AppMotif.getLayoutNode(app, AppMotif.Properties._lastLayout.name());
                  if (layoutNode == null) return;

                  app.events.fireNodeLoad(AppMotif.getLayoutNodes(layoutNode));
               }

               @Override
               public void exception(Throwable throwable) {
                  throwable.printStackTrace();
               }
            }));
         });
      }

      @Override
      public void paint(Graphics graphics) {
         final Graphics2D g2 = (Graphics2D) graphics;
         for (Map.Entry<RenderingHints.Key, Object> entry : app.model.getRenderingHints().entrySet())
            g2.setRenderingHint(entry.getKey(), entry.getValue());
         super.paint(graphics);
      }

      Set<NodeCanvas.NeoNode> getSelectedNodes() {
         final Set<NodeCanvas.NeoNode> nodes = new LinkedHashSet<>();
         for (Object o : nodeLayer.getAllNodes()) {
            if (o instanceof NodeCanvas.NeoNode) {
               final NodeCanvas.NeoNode neoNode = (NodeCanvas.NeoNode) o;
               if (neoNode.isSelected()) nodes.add(neoNode);
            }
         }
         return nodes;
      }

      Set<NodeCanvas.NeoRelationship> getSelectedRelations() {
         final Set<NodeCanvas.NeoRelationship> relations = new LinkedHashSet<>();
         for (Object o : relationLayer.getAllNodes()) {
            if (o instanceof PPath) {
               final NodeCanvas.NeoRelationship relationship = layerRelations.get(((PPath) o).getAttribute("id"));
               if (relationship.isSelected()) relations.add(relationship);
            }
         }
         return relations;
      }

      Set<NodeCanvas.NeoNode> getAllNodes() {
         final Set<NodeCanvas.NeoNode> nodes = new LinkedHashSet<>();
         for (Object o : nodeLayer.getAllNodes())
            if (o instanceof Workspace.NodeCanvas.NeoNode)
               nodes.add((NeoNode) o);
         return nodes;
      }

      Set<NodeCanvas.NeoRelationship> getAllRelations() {
         final Set<NodeCanvas.NeoRelationship> relations = new LinkedHashSet<>();
         for (Object o : relationLayer.getAllNodes())
            if (o instanceof PPath)
               relations.add(layerRelations.get(((PPath) o).getAttribute("id")));
         return relations;
      }

      class NeoNode extends PText {

         private Color defaultNodeColor = Color.BLACK;

         NeoNode(Node node, Point2D offset, PBasicInputEventHandler canvasInputListener, PLayer nodeLayer) {
            super(getNodeText(nodePaintStrategy, node));
            addAttribute("id", node.getId());
            addAttribute("node", node);

            Color nodeColor = null;
            for (org.neo4j.graphdb.Label label : node.getLabels()) {
               final Node colorNode = app.model.graph().getGraphDb().findNode(AppMotif.Entities._Color, "label", label.name());
               if (colorNode == null) continue;
               if (nodeColor == null) {
                  final String color = getString(colorNode, AppMotif.Properties._color.name());
                  nodeColor = color == null ? Color.BLACK : Color.decode(color);
                  continue;
               }
               nodeColor = blend(nodeColor, Color.decode(getString(node, AppMotif.Properties._color.name())));
            }
            defaultNodeColor = nodeColor == null ? Color.BLACK : nodeColor;

            setOffset(offset == null ? (node.hasProperty(AppMotif.Properties._x.name()) ? new Point2D.Double(getDouble(node, AppMotif.Properties._x.name()), getDouble(node, AppMotif.Properties._y.name())) : new Point2D.Double(random.nextInt(100), random.nextInt(100))) : offset);

            final PBasicInputEventHandler nodeEventListener = new PDragSequenceEventHandler() {
               @Override
               protected final void startDrag(PInputEvent event) {
                  super.startDrag(event);
               }

               @Override
               protected final void drag(PInputEvent event) {
                  super.drag(event);
                  translate(event.getDelta().width, event.getDelta().height);
               }

               @Override
               protected final void endDrag(PInputEvent event) {
                  super.endDrag(event);
               }

               @Override
               protected final boolean shouldStartDragInteraction(PInputEvent event) {
                  return super.shouldStartDragInteraction(event);
               }

               @Override
               public void mouseEntered(PInputEvent event) {
                  event.getInputManager().setKeyboardFocus(this);
                  highlight();
                  app.events.fireNodeHighlighted(NodeCanvas.NeoNode.this);
               }

               @Override
               public void mouseExited(PInputEvent event) {
                  event.getInputManager().setKeyboardFocus(canvasInputListener);
                  unhighlight();
               }

               @Override
               public void mouseClicked(PInputEvent event) {
                  if (event.isRightMouseButton()) {
                     SwingUtilities.invokeLater(() -> onRightClick(event));
                  } else if (event.isLeftMouseButton()) {
                     SwingUtilities.invokeLater(() -> onLeftClick(event));
                  } else if (event.isMiddleMouseButton()) {
                     SwingUtilities.invokeLater(() -> onMiddleClick(event));
                  }
               }

               private void onLeftClick(PInputEvent event) {
                  toggleSelect();
                  app.events.fireNodesSelected(getSelectedNodes());
               }

               private void onMiddleClick(PInputEvent event) {

               }

               @Override
               public void keyPressed(PInputEvent event) {
                  switch (event.getKeyCode()) {

                     case KeyEvent.VK_1:
                        SwingUtilities.invokeLater(() -> {
                           final Map<Long, Workspace.NodeCanvas.NeoNode> nodesAndIds = new LinkedHashMap<>();
                           for (Workspace.NodeCanvas.NeoNode selectedNode : nodeCanvas.getAllNodes()) {
                              if (id().equals(selectedNode.id())) continue;
                              nodesAndIds.put(selectedNode.id(), selectedNode);
                           }

                           app.model.graph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {
                                 new LayoutNode("", NeoNode.this, nodesAndIds).layout(getOffset());
                              }

                              @Override
                              public void exception(Throwable throwable) {
                                 SwingUtil.showExceptionNoStack(app, throwable);
                              }
                           });
                        });
                        break;


                     case KeyEvent.VK_C:
                        SwingUtilities.invokeLater(() -> app.events.fireNodesClosed(Collections.singleton(NodeCanvas.NeoNode.this)));
                        break;

                     case KeyEvent.VK_R:
                        SwingUtilities.invokeLater(() -> {

                           final Set<NodeCanvas.NeoNode> nodesToClose = new LinkedHashSet<>();
                           for (Object o : nodeLayer.getAllNodes()) {
                              if (o instanceof NodeCanvas.NeoNode && !((NodeCanvas.NeoNode) o).isSelected() && !NodeCanvas.NeoNode.this.equals(o))
                                 nodesToClose.add((NodeCanvas.NeoNode) o);
                           }
                           app.events.fireNodesClosed(nodesToClose);
                        });
                        break;

                     case KeyEvent.VK_E:

                        if(event.isControlDown()) {

                           SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {
                                 final Set<NeoNode> nodes = new LinkedHashSet<>();
                                 outgoing(node).forEach(relationship -> {
                                    if(!layerRelations.containsKey(relationship.getId())) return;
                                    nodes.add((NeoNode)layerRelations.get(relationship.getId()).path.getAttribute("target"));
                                 });
                                 app.events.fireNodesSelected(nodes);
                              }

                              @Override
                              public void exception(Throwable throwable) {
                                 SwingUtil.showException(NodeCanvas.this, throwable);
                              }
                           }));

                        } else {

                           SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {
                                 final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
                                 outgoing(node).forEach(relationship -> nodes.add(new AppEvents.NodeLoadEvent(other(node, relationship), null)));
                                 app.events.fireNodeLoad(nodes);
                              }

                              @Override
                              public void exception(Throwable throwable) {
                                 SwingUtil.showException(NodeCanvas.this, throwable);
                              }
                           }));
                        }
                        break;

                     case KeyEvent.VK_D:
                        SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                           @Override
                           public void doAction(Transaction tx) throws Throwable {
                              final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
                              incoming(node).forEach(relationship -> {
                                 if (relationship.getType().name().equals(AppMotif.Relations._LAYOUT_MEMBER.name()))
                                    return;
                                 nodes.add(new AppEvents.NodeLoadEvent(other(node, relationship), null));
                              });
                              app.events.fireNodeLoad(nodes);
                           }

                           @Override
                           public void exception(Throwable throwable) {
                              SwingUtil.showException(NodeCanvas.this, throwable);
                           }
                        }));
                        break;
                  }
               }
            };

            nodeEventListener.getEventFilter().setMarksAcceptedEventsAsHandled(true);
            addInputEventListener(nodeEventListener);

            app.events.addNodeChangedListener(node.getId(), new AppEvents.EventsTransactionHandler(getClass(), NodeCanvas.this, app.model) {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  final String propertyName = (String) evt.getOldValue();
                  if (AppMotif.Properties.name.name().equals(propertyName))
                     setText(getNodeText(nodePaintStrategy, getNode()));
               }
            });
         }

         final class LayoutNode {

            private final Workspace.NodeCanvas.NeoNode neoNode;
            private final Set<LayoutNode> children = new LinkedHashSet<>();
            private Double totalHeight;

            LayoutNode(String delim, Workspace.NodeCanvas.NeoNode neoNode, Map<Long, Workspace.NodeCanvas.NeoNode> nodesAndIds) {
               this.neoNode = neoNode;

               final AtomicDouble childrenHeight = new AtomicDouble(0);
               outgoing(neoNode.getNode()).forEach(relationship -> {
                  final long id = other(neoNode.getNode(), relationship).getId();
                  if (nodesAndIds.keySet().contains(id)) {
                     final LayoutNode childNode = new LayoutNode(delim + "\t", nodesAndIds.remove(id), nodesAndIds);
                     children.add(childNode);
                     childrenHeight.addAndGet(childNode.totalHeight);
                  }
               });

               if (childrenHeight.get() == 0) totalHeight = neoNode.getFullBounds().getHeight() + 15;
               else totalHeight = childrenHeight.get();
            }

            public void layout(Point2D startPosition) {
               neoNode.setOffset(startPosition);
               double x = startPosition.getX() + neoNode.getFullBounds().getWidth() + 75;
               double y = children.size() == 1 ? startPosition.getY() : (startPosition.getY() - ((totalHeight / 2d)));
               for (LayoutNode child : children) {
                  child.layout(new Point2D.Double(x, y));
                  y += (totalHeight / children.size());
               }
            }
         }

         private void onRightClick(PInputEvent event) {
            SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  app.getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                  final JPopupMenu pop = new JPopupMenu();

                  final Set<NodeCanvas.NeoNode> selectedNodes = new LinkedHashSet<>();
                  for (Object o : nodeLayer.getAllNodes()) {
                     if (o instanceof NodeCanvas.NeoNode && ((NodeCanvas.NeoNode) o).isSelected() && !NodeCanvas.NeoNode.this.equals(o))
                        selectedNodes.add((NodeCanvas.NeoNode) o);
                  }

                  TemplateMotif.onRightClick(pop, NodeCanvas.NeoNode.this, selectedNodes, app);
                  ProjectMotif.onRightClick(pop, NodeCanvas.NeoNode.this, selectedNodes, app);

                  getNode().getLabels().forEach(label -> app.model.graph().findNodes(TemplateMotif.Entities._STTemplate, AppMotif.Properties.name.name(), label.name()).forEachRemaining(templateNode -> {
                     final JMenu assignMenu = new JMenu(getNameAndLabelsFrom(getNode()));
                     final JMenu expandMenu = new JMenu("Show...");

                     // show parameters-action
                     outgoing(templateNode, TemplateMotif.Relations.TEMPLATE_PARAMETER).forEach(relationship -> {
                        final Node parameterNode = other(templateNode, relationship);
                        final String parameterName = getString(parameterNode, AppMotif.Properties.name.name());
                        // do not use if its deprecated
                        if (parameterNode.hasProperty(TemplateMotif.Properties._deprecated.name())) return;

                        if (hasLabel(parameterNode, TemplateMotif.Entities._Single)) {

                           // single-parameter
                           assignMenu.add(new App.TransactionAction("Set " + parameterName, app) {
                              @Override
                              protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {
                                 final String newValue = SwingUtil.showInputDialog(parameterName, NodeCanvas.this);
                                 if (newValue == null) return;

                                 // remove any existing one
                                 outgoing(getNode(), RelationshipType.withName(parameterName)).forEach(oldValueRelation -> {
                                    final Node oldValueNode = other(getNode(), oldValueRelation);
                                    oldValueRelation.delete();
                                    AppMotif.tryToDeleteValueNode(oldValueNode);
                                 });
                                 if (newValue.trim().length() == 0) return; // empty-string

                                 final Node valueNode = app.model.graph().getGraphDb().createNode(TemplateMotif.Entities._Value);
                                 valueNode.setProperty(AppMotif.Properties.name.name(), newValue);
                                 app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(valueNode));
                                 final Relationship valueRelation = getNode().createRelationshipTo(valueNode, RelationshipType.withName(parameterName));
                                 valueRelation.setProperty(TemplateMotif.Properties._referenceType.name(), TemplateMotif.ReferenceType.PROPERTY.name());
                                 valueRelation.setProperty(TemplateMotif.Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                                 app.events.fireNodeChanged(getNode().getId(), parameterName, newValue);
                              }
                           });

                           if (hasOutgoing(getNode(), RelationshipType.withName(parameterName))) {
                              expandMenu.add(new App.TransactionAction("Show " + RelationshipType.withName(parameterName), app) {
                                 @Override
                                 protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                                    app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(other(getNode(), singleOutgoing(getNode(), RelationshipType.withName(parameterName)))));
                                 }
                              });
                           }


                        } else if (hasLabel(parameterNode, TemplateMotif.Entities._List)) {
                           // list-parameter
                           assignMenu.add(new App.TransactionAction("Add " + parameterName, app) {
                              @Override
                              protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {

                                 final JTextField txtValue = new JTextField();

                                 final JRadioButton radSingleElement = new JRadioButton("Single element", true);
                                 final JRadioButton radSplit = new JRadioButton("Split by space");
                                 final ButtonGroup group = new ButtonGroup();
                                 group.add(radSingleElement);
                                 group.add(radSplit);

                                 final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,100dlu", "pref,4dlu,pref,4dlu,pref");
                                 editor.addLabel("Value", 1, 1);
                                 editor.add(txtValue, 3, 1);
                                 editor.add(radSingleElement, 3, 3);
                                 editor.add(radSplit, 3, 5);

                                 editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

                                 SwingUtil.showDialog(editor, app, "Add " + parameterName, () -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                                    @Override
                                    public void doAction(Transaction tx) throws Throwable {
                                       final String newElements = txtValue.getText().trim();
                                       if (newElements.length() == 0) return;

                                       if (radSingleElement.isSelected()) {
                                          final Node valueNode = app.model.graph().getGraphDb().createNode(TemplateMotif.Entities._Value);
                                          valueNode.setProperty(AppMotif.Properties.name.name(), StringUtil.trimSpacesIn(newElements));
                                          app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(valueNode));

                                          final Relationship valueRelation = getNode().createRelationshipTo(valueNode, RelationshipType.withName(parameterName));
                                          valueRelation.setProperty(TemplateMotif.Properties._referenceType.name(), TemplateMotif.ReferenceType.PROPERTY.name());
                                          valueRelation.setProperty(TemplateMotif.Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                                          app.events.fireNodeChanged(getNode().getId(), null, getNode());

                                       } else if (radSplit.isSelected()) {
                                          final String[] newValues = newElements.split("[ ]");
                                          for (String newValue : newValues) {
                                             final Node valueNode = app.model.graph().getGraphDb().createNode(TemplateMotif.Entities._Value);
                                             valueNode.setProperty(AppMotif.Properties.name.name(), newValue);
                                             app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(valueNode));

                                             final Relationship valueRelation = getNode().createRelationshipTo(valueNode, RelationshipType.withName(parameterName));
                                             valueRelation.setProperty(TemplateMotif.Properties._referenceType.name(), TemplateMotif.ReferenceType.PROPERTY.name());
                                             valueRelation.setProperty(TemplateMotif.Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                                             app.events.fireNodeChanged(getNode().getId(), null, getNode());
                                          }
                                       }
                                    }

                                    @Override
                                    public void exception(Throwable throwable) {
                                       SwingUtil.showException(editor, throwable);

                                    }
                                 }));
                              }
                           });

                           if (hasOutgoing(getNode(), RelationshipType.withName(parameterName))) {
                              expandMenu.add(new App.TransactionAction("Show " + RelationshipType.withName(parameterName), app) {
                                 @Override
                                 protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                                    final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
                                    outgoing(getNode(), RelationshipType.withName(parameterName)).forEach(relationship1 -> nodes.add(new AppEvents.NodeLoadEvent(other(getNode(), relationship1))));
                                    app.events.fireNodeLoad(nodes);
                                 }
                              });
                           }

                        } else if (hasLabel(parameterNode, TemplateMotif.Entities._KeyValueList)) {



                           // key-value parameter with values
                           assignMenu.add(new App.TransactionAction("Add " + parameterName, app) {
                              @Override
                              protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {
                                 final java.util.List<String> keys = new ArrayList<>();
                                 parameterNode.getPropertyKeys().forEach(s -> {
                                    if (s.startsWith("key_")) keys.add(getString(parameterNode, s));
                                 });

//                                 final JTextField[] txtNames = new JTextField[keys.size()];
                                 final Map<Integer, Map<Integer, JTextField>> txtNames = new LinkedHashMap<>();
                                 final int tabs = 5;
                                 final JTabbedPane tab = new JTabbedPane();
                                 tab.setPreferredSize(new Dimension(600,150));
                                 for (int j = 0; j < tabs; j++) {
                                    final JPanel editor = new JPanel(null);
                                    editor.setLayout(new BoxLayout(editor, BoxLayout.PAGE_AXIS));

                                    txtNames.put(j, new LinkedHashMap<>());
                                    for (int i = 0; i < keys.size(); i++) {
                                       final SwingUtil.FormPanel row = new SwingUtil.FormPanel("50dlu,4dlu,150dlu:grow", "pref");
                                       row.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                                       row.addLabel(keys.get(i), 1, 1);
                                       txtNames.get(j).put(i, new JTextField(30));
                                       row.add(txtNames.get(j).get(i), 3, 1);
                                       editor.add(row);
                                    }
                                    tab.add("KeyValue " + (j + 1), editor);
                                 }

                                 SwingUtil.showDialog(tab, NodeCanvas.this, parameterName, () -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                                    @Override
                                    public void doAction(Transaction tx14) throws Throwable {

                                       for (int j = 0; j < tabs; j++) {
                                          final Map<Integer, JTextField> formFields = txtNames.get(j);
                                          final Map<String, String> newValues = new TreeMap<>();
                                          for (int i = 0; i < formFields.size(); i++) {
                                             final String newValue = formFields.get(i).getText().trim();
                                             if (newValue.trim().length() == 0) continue;
                                             newValues.put(keys.get(i), newValue.trim());
                                          }
                                          if (newValues.isEmpty()) return;

                                          final Node keyValueNode = app.model.graph().getGraphDb().createNode(TemplateMotif.Entities._KeyValue);
                                          keyValueNode.setProperty(AppMotif.Properties.name.name(), parameterName);
                                          parameterNode.createRelationshipTo(keyValueNode, TemplateMotif.Relations.KEY_VALUE);
                                          getNode().createRelationshipTo(keyValueNode, RelationshipType.withName(parameterName));
                                          app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(keyValueNode));

                                          for (Map.Entry<String, String> kvEntry : newValues.entrySet()) {
                                             if (kvEntry.getValue().length() == 0) continue;

                                             final Node valueNode = app.model.graph().getGraphDb().createNode(TemplateMotif.Entities._Value);
                                             valueNode.setProperty(AppMotif.Properties.name.name(), kvEntry.getValue());
                                             app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(valueNode));

                                             final Relationship valueRelation = keyValueNode.createRelationshipTo(valueNode, RelationshipType.withName(kvEntry.getKey()));
                                             valueRelation.setProperty(TemplateMotif.Properties._referenceType.name(), TemplateMotif.ReferenceType.PROPERTY.name());
                                             valueRelation.setProperty(TemplateMotif.Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                                          }
                                       }

                                       app.events.fireNodeChanged(getNode().getId(), null, getNode());
                                    }

                                    @Override
                                    public void exception(Throwable throwable) {
                                       SwingUtil.showException(tab, throwable);
                                    }
                                 }));
                              }
                           });

                           assignMenu.add(new App.TransactionAction("Add empty " + parameterName, app) {
                              @Override
                              protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                                 final Node keyValueNode = app.model.graph().getGraphDb().createNode(TemplateMotif.Entities._KeyValue);
                                 keyValueNode.setProperty(AppMotif.Properties.name.name(), parameterName);
                                 parameterNode.createRelationshipTo(keyValueNode, TemplateMotif.Relations.KEY_VALUE);
                                 getNode().createRelationshipTo(keyValueNode, RelationshipType.withName(parameterName));
                                 app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(keyValueNode));
                              }
                           });

                           if (hasOutgoing(getNode(), RelationshipType.withName(parameterName))) {
                              expandMenu.add(new App.TransactionAction("Show " + RelationshipType.withName(parameterName), app) {
                                 @Override
                                 protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                                    final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
                                    outgoing(getNode(), RelationshipType.withName(parameterName)).forEach(relationship1 -> nodes.add(new AppEvents.NodeLoadEvent(other(getNode(), relationship1))));
                                    app.events.fireNodeLoad(nodes);
                                 }
                              });
                           }
                        }
                     });

                     assignMenu.add(new JSeparator());
                     if (expandMenu.getMenuComponents().length > 0)
                        assignMenu.add(expandMenu);

                     assignMenu.add(new App.TransactionAction("Show template", app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                           app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(templateNode));
                        }
                     });

                     pop.add(assignMenu);
                  }));

                  pop.add(new JSeparator());

                  pop.add(new App.TransactionAction("Layout", app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        final Map<Long, Workspace.NodeCanvas.NeoNode> nodesAndIds = new LinkedHashMap<>();
                        for (Workspace.NodeCanvas.NeoNode selectedNode : selectedNodes) {
                           if (id().equals(selectedNode.id())) continue;
                           nodesAndIds.put(selectedNode.id(), selectedNode);
                        }
                        new LayoutNode("", NeoNode.this, nodesAndIds).layout(getOffset());
                     }
                  });

                  pop.add(new JSeparator());

                  if (!selectedNodes.isEmpty()) {
                     pop.add(new App.TransactionAction("Add relationship", app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                           final Set<String> relationships = new LinkedHashSet<>();
                           app.model.graph().getGraphDb().getAllRelationshipTypesInUse().forEach(relationshipType -> relationships.add(relationshipType.name()));
                           final String selected = SwingUtil.showSelectDialog(app, relationships);
                           if (selected == null) return;

                           for (Workspace.NodeCanvas.NeoNode sourceNode : selectedNodes) {
                              if (BaseDomainVisitor.isRelated(sourceNode.getNode(), getNode(), RelationshipType.withName(selected)))
                                 continue;
                              sourceNode.getNode().createRelationshipTo(getNode(), RelationshipType.withName(selected));
                           }
                        }
                     });
                  }

                  pop.add(new AbstractAction("SetProperty") {
                     @Override
                     public void actionPerformed(ActionEvent e) {

                        final String newProperty = SwingUtil.showInputDialog("[Property] [value]", NodeCanvas.this);
                        if (newProperty == null || newProperty.split("[ ]").length != 2) return;

                        final String property = newProperty.split("[ ]")[0];
                        final String value = newProperty.split("[ ]")[1];
                        getNode().setProperty(property, value);
                        app.events.fireNodeChanged(getNode().getId(), property, value);
                     }
                  });

                  pop.add(new AbstractAction("Retain") {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        SwingUtilities.invokeLater(() -> {
                           final Set<NodeCanvas.NeoNode> nodesToClose = new LinkedHashSet<>();
                           for (Object o : nodeLayer.getAllNodes()) {
                              if (o instanceof NodeCanvas.NeoNode && !((NodeCanvas.NeoNode) o).isSelected() && !NodeCanvas.NeoNode.this.equals(o))
                                 nodesToClose.add((NodeCanvas.NeoNode) o);
                           }
                           app.events.fireNodesClosed(nodesToClose);
                        });
                     }
                  });

                  pop.add(new App.TransactionAction("Close", app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        app.events.fireNodesClosed(Collections.singleton(NodeCanvas.NeoNode.this));
                     }
                  });

                  pop.add(new App.TransactionAction("Delete", app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        if (SwingUtil.showConfirmDialog(app, "Delete " + getNameAndLabelsFrom(getNode()) + " ?")) {
                           incoming(getNode()).forEach(Relationship::delete);
                           outgoing(getNode()).forEach(Relationship::delete);
                           getNode().delete();
                        }
                     }
                  });

                  app.getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                  pop.show(NodeCanvas.this, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
               }

               @Override
               public void exception(Throwable throwable) {
                  SwingUtil.showException(NodeCanvas.this, throwable);
               }
            }));
         }

         private Color blend(Color c1, Color c2) {
            float iRatio = .5f;

            int i1 = c1.getRGB();
            int i2 = c2.getRGB();

            int a1 = (i1 >> 24 & 0xff);
            int r1 = ((i1 & 0xff0000) >> 16);
            int g1 = ((i1 & 0xff00) >> 8);
            int b1 = (i1 & 0xff);

            int a2 = (i2 >> 24 & 0xff);
            int r2 = ((i2 & 0xff0000) >> 16);
            int g2 = ((i2 & 0xff00) >> 8);
            int b2 = (i2 & 0xff);

            int a = (int) ((a1 * iRatio) + (a2 * .5f));
            int r = (int) ((r1 * iRatio) + (r2 * .5f));
            int g = (int) ((g1 * iRatio) + (g2 * .5f));
            int b = (int) ((b1 * iRatio) + (b2 * .5f));

            return new Color(a << 24 | r << 16 | g << 8 | b);
         }

         Long id() {
            return Long.valueOf(getAttribute("id").toString());
         }

         void setColor(Color color) {
            defaultNodeColor = color;
            setTextPaint(color);
         }

         void highlight() {
            addAttribute("highlighted", Boolean.TRUE);
            setTextPaint(highlightedNodeColor);
         }

         void unhighlight() {
            addAttribute("highlighted", Boolean.FALSE);
            setTextPaint(getBooleanAttribute("selected", false) ? selectedNodeColor : defaultNodeColor);
         }

         void toggleSelect() {
            addAttribute("selected", !getBooleanAttribute("selected", false));
            setTextPaint(getBooleanAttribute("selected", false) ? selectedNodeColor : defaultNodeColor);
         }

         void select() {
            addAttribute("selected", Boolean.TRUE);
            setTextPaint(selectedNodeColor);
         }

         void unselect() {
            addAttribute("selected", Boolean.FALSE);
            setTextPaint(defaultNodeColor);
         }

         boolean isSelected() {
            return getBooleanAttribute("selected", false);
         }

         Node getNode() {
            return (Node) getAttribute("node");
         }

         @Override
         public boolean equals(Object obj) {
            return ((obj instanceof NodeCanvas.NeoNode)) && ((NodeCanvas.NeoNode) obj).getAttribute("id").equals(getAttribute("id"));
         }

         @Override
         public int hashCode() {
            return getAttribute("id").hashCode();
         }
      }


      class NeoRelationship implements PropertyChangeListener {

         final PPath path;
         private Paint currentPaint = defaultRelationColor;
         private PText pText;

         NeoRelationship(Relationship relationship, NodeCanvas.NeoNode source, NodeCanvas.NeoNode target) {
            pText = new PText(relationship.getType().name());
            path = PPath.createLine(source.getFullBoundsReference().getCenter2D().getX(), source.getFullBoundsReference().getCenter2D().getY(), target.getFullBoundsReference().getCenter2D().getX(), target.getFullBoundsReference().getCenter2D().getY());
            path.setStrokePaint(currentPaint);
            path.addAttribute("id", relationship.getId());
            path.addAttribute("relationship", relationship);
            path.addAttribute("source", source);
            path.addAttribute("target", target);
            source.addPropertyChangeListener(this);
            target.addPropertyChangeListener(this);

            switch (relationPaintStrategy) {
               case showLinesAndLabels:
                  path.addChild(this.pText);
                  break;
            }

            updatePath(source, target);

            app.events.addRelationsDeletedListener(evt -> {
               final Set<Long> relationsDeleted = (Set<Long>) evt.getNewValue();
               if (relationsDeleted.contains(Long.valueOf(path.getAttribute("id").toString())))
                  SwingUtilities.invokeLater(NodeCanvas.NeoRelationship.this::removeFromCanvas);
            });

            final PBasicInputEventHandler relationEventListener = new PBasicInputEventHandler() {
               @Override
               public void mouseEntered(PInputEvent event) {
                  currentPaint = highlightedNodeColor;
                  repaintRelation();
                  app.events.fireRelationHighlighted(NodeCanvas.NeoRelationship.this);
               }

               @Override
               public void mouseExited(PInputEvent event) {
                  currentPaint = path.getBooleanAttribute("selected", false) ? selectedNodeColor : defaultRelationColor;
                  repaintRelation();
               }

               @Override
               public void mouseClicked(PInputEvent event) {
                  if (event.isRightMouseButton()) {
                     SwingUtilities.invokeLater(() -> onRightClick(event));
                  } else if (event.isLeftMouseButton()) {
                     SwingUtilities.invokeLater(() -> onLeftClick());
                  }
               }

               private void onRightClick(PInputEvent event) {
                  SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {

                        final JPopupMenu pop = new JPopupMenu();

                        pop.add(new App.TransactionAction("Change Type", app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                              final Set<String> types = new TreeSet<>();
                              app.model.graph().getGraphDb().getAllRelationshipTypes().forEach(relationshipType -> types.add(relationshipType.name()));
                              final String newType = SwingUtil.showSelectDialog(NodeCanvas.this, types, relationship.getType().name());
                              if (newType == null || newType.equals(relationship.getType().name())) return;
                              final Relationship newRelationship = relationship.getStartNode().createRelationshipTo(relationship.getEndNode(), RelationshipType.withName(newType));
                              for (String key : relationship.getPropertyKeys())
                                 newRelationship.setProperty(key, relationship.getProperty(key));

                              if (layerNodes.containsKey(newRelationship.getStartNode().getId()) && layerNodes.containsKey(newRelationship.getEndNode().getId())) {
                                 final NodeCanvas.NeoNode source = layerNodes.get(newRelationship.getStartNode().getId());
                                 final NodeCanvas.NeoNode destination = layerNodes.get(newRelationship.getEndNode().getId());
                                 final NodeCanvas.NeoRelationship nodeRelation = new NodeCanvas.NeoRelationship(newRelationship, source, destination);
                                 layerRelations.put(newRelationship.getId(), nodeRelation);
                                 relationLayer.addChild(nodeRelation.path);
                              }
                              relationship.delete();
                           }
                        });

                        pop.add(new App.TransactionAction("Reverse Direction", app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                              final Relationship newRelationship = relationship.getEndNode().createRelationshipTo(relationship.getStartNode(), relationship.getType());
                              for (String key : relationship.getPropertyKeys())
                                 newRelationship.setProperty(key, relationship.getProperty(key));

                              if (layerNodes.containsKey(newRelationship.getStartNode().getId()) && layerNodes.containsKey(newRelationship.getEndNode().getId())) {
                                 final NodeCanvas.NeoNode source = layerNodes.get(newRelationship.getStartNode().getId());
                                 final NodeCanvas.NeoNode destination = layerNodes.get(newRelationship.getEndNode().getId());
                                 final NodeCanvas.NeoRelationship nodeRelation = new NodeCanvas.NeoRelationship(newRelationship, source, destination);
                                 layerRelations.put(newRelationship.getId(), nodeRelation);
                                 relationLayer.addChild(nodeRelation.path);
                              }
                              relationship.delete();
                           }
                        });

                        pop.add(new App.TransactionAction("Set Property", app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                              final String propertyValue = SwingUtil.showInputDialog("Property Value", NodeCanvas.this);
                              if (propertyValue == null || propertyValue.trim().length() == 0 || propertyValue.trim().split("[ ]").length != 2)
                                 return;

                              relationship.setProperty(propertyValue.trim().split("[ ]")[0], propertyValue.trim().split("[ ]")[1]);
                           }
                        });

                        pop.add(new App.TransactionAction("Delete", app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                              final Long startNode = relationship.getStartNode().getId();
                              final Long endNode = relationship.getEndNode().getId();
                              if (SwingUtil.showConfirmDialog(app, "Delete " + getNameOrTypeFrom(relationship) + " ?")) {
                                 final NodeCanvas.NeoRelationship remove = layerRelations.remove(relationship.getId());
                                 if (remove != null) relationLayer.removeChild(path);
                                 relationship.delete();
                              }
                              app.events.fireNodeChanged(startNode);
                              app.events.fireNodeChanged(endNode);
                           }
                        });

                        pop.show(NodeCanvas.this, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showException(NodeCanvas.this, throwable);
                     }
                  }));
               }

               private void onLeftClick() {
                  toggleSelect();
                  app.events.fireRelationsSelected(getSelectedRelations());
               }
            };
            relationEventListener.getEventFilter().setMarksAcceptedEventsAsHandled(true);
            path.addInputEventListener(relationEventListener);
         }

         @Override
         public void propertyChange(PropertyChangeEvent evt) {

            switch (evt.getPropertyName()) {
               case PNode.PROPERTY_FULL_BOUNDS:
               case PNode.PROPERTY_TRANSFORM:
                  SwingUtilities.invokeLater(() -> updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target")));
                  break;

               case PNode.PROPERTY_PARENT:
                  if (evt.getOldValue() != null) SwingUtilities.invokeLater(this::removeFromCanvas);
                  break;
            }
         }

         Long id() {
            return Long.valueOf(path.getAttribute("id").toString());
         }

         void highlight() {
            path.addAttribute("highlighted", Boolean.TRUE);
            currentPaint = highlightedNodeColor;
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }

         void unhighlight() {
            path.addAttribute("highlighted", Boolean.FALSE);
            currentPaint = path.getBooleanAttribute("selected", false) ? selectedNodeColor : defaultRelationColor;
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }

         void toggleSelect() {
            path.addAttribute("selected", !path.getBooleanAttribute("selected", false));
            currentPaint = path.getBooleanAttribute("selected", false) ? selectedNodeColor : defaultRelationColor;
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }

         void select() {
            path.addAttribute("selected", Boolean.TRUE);
            currentPaint = selectedNodeColor;
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }

         void unselect() {
            path.addAttribute("selected", Boolean.FALSE);
            currentPaint = defaultRelationColor;
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }



         boolean isSelected() {
            return path.getBooleanAttribute("selected", false);
         }

         Relationship getRelationship() {
            return (Relationship) path.getAttribute("relationship");
         }

         private void removeFromCanvas() {
            ((NodeCanvas.NeoNode) path.getAttribute("source")).removePropertyChangeListener(NodeCanvas.NeoRelationship.this);
            ((NodeCanvas.NeoNode) path.getAttribute("target")).removePropertyChangeListener(NodeCanvas.NeoRelationship.this);
            layerRelations.remove(Long.valueOf(path.getAttribute("id").toString()));
            relationLayer.removeChild(path);
         }

         private void updatePath(NodeCanvas.NeoNode source, NodeCanvas.NeoNode target) {
            final PBounds src = source.getFullBoundsReference();
            final PBounds dst = target.getFullBoundsReference();

            final boolean horizontalOverlap = !(src.getMaxX() < dst.getMinX() || src.getMinX() > dst.getMaxX());

            final Point2D.Double startCenterBottom = p(src.getCenterX(), src.getMaxY());
            final Point2D.Double endCenterTop = p(dst.getCenterX(), dst.getMinY());

            final Point2D.Double startCenterTop = p(src.getCenterX(), src.getMinY());
            final Point2D.Double endCenterBottom = p(dst.getCenterX(), dst.getMaxY());

            if (src.getCenterX() < dst.getCenterX()) {

               final Point2D.Double startRightCenter = p(src.getMaxX(), src.getCenterY());
               final Point2D.Double endRightCenter = p(dst.getMinX(), dst.getCenterY());

               if (src.getCenterY() < dst.getCenterY()) {
                  // top-left
                  if (!horizontalOverlap) {
                     Point2D.Double ctrl1 = new Point2D.Double(startRightCenter.getX() + ((endRightCenter.getX() - startRightCenter.getX()) / 2), startRightCenter.getY());
                     Point2D.Double ctrl2 = new Point2D.Double(endRightCenter.getX() + ((startRightCenter.getX() - endRightCenter.getX()) / 2), endRightCenter.getY());
                     drawPath(startRightCenter, endRightCenter, ctrl1, ctrl2);
                  } else {
                     Point2D.Double ctrl1 = new Point2D.Double(startCenterBottom.getX(), startCenterBottom.getY() + ((endCenterTop.getY() - startCenterBottom.getY()) / 2));
                     Point2D.Double ctrl2 = new Point2D.Double(endCenterTop.getX(), endCenterTop.getY() + ((startCenterBottom.getY() - endCenterTop.getY()) / 2));
                     drawPath(startCenterBottom, endCenterTop, ctrl1, ctrl2);
                  }
               } else {
                  // bottom-left
                  if (!horizontalOverlap) {
                     Point2D.Double ctrl1 = new Point2D.Double(startRightCenter.getX() + ((endRightCenter.getX() - startRightCenter.getX()) / 2), startRightCenter.getY());
                     Point2D.Double ctrl2 = new Point2D.Double(endRightCenter.getX() + ((startRightCenter.getX() - endRightCenter.getX()) / 2), endRightCenter.getY());
                     drawPath(startRightCenter, endRightCenter, ctrl1, ctrl2);
                  } else {
                     Point2D.Double ctrl1 = new Point2D.Double(startCenterTop.getX(), startCenterTop.getY() - ((startCenterTop.getY() - endCenterBottom.getY()) / 2));
                     Point2D.Double ctrl2 = new Point2D.Double(endCenterBottom.getX(), endCenterBottom.getY() - ((endCenterBottom.getY() - startCenterTop.getY()) / 2));
                     drawPath(startCenterTop, endCenterBottom, ctrl1, ctrl2);
                  }
               }

            } else {

               final Point2D.Double startLeftCenter = p(src.getMinX(), src.getCenterY());
               final Point2D.Double endLeftCenter = p(dst.getMaxX(), dst.getCenterY());

               if (src.getCenterY() < dst.getCenterY()) {
                  // top-right
                  if (!horizontalOverlap) {
                     Point2D.Double ctrl1 = new Point2D.Double(startLeftCenter.getX() - ((startLeftCenter.getX() - endLeftCenter.getX()) / 2), startLeftCenter.getY());
                     Point2D.Double ctrl2 = new Point2D.Double(endLeftCenter.getX() - ((endLeftCenter.getX() - startLeftCenter.getX()) / 2), endLeftCenter.getY());
                     drawPath(startLeftCenter, endLeftCenter, ctrl1, ctrl2);
                  } else {
                     Point2D.Double ctrl1 = new Point2D.Double(startCenterBottom.getX(), startCenterBottom.getY() + ((endCenterTop.getY() - startCenterBottom.getY()) / 2));
                     Point2D.Double ctrl2 = new Point2D.Double(endCenterTop.getX(), endCenterTop.getY() + ((startCenterBottom.getY() - endCenterTop.getY()) / 2));
                     drawPath(startCenterBottom, endCenterTop, ctrl1, ctrl2);
                  }
               } else {
                  // bottom-right
                  if (!horizontalOverlap) {
                     Point2D.Double ctrl1 = new Point2D.Double(startLeftCenter.getX() - ((startLeftCenter.getX() - endLeftCenter.getX()) / 2), startLeftCenter.getY());
                     Point2D.Double ctrl2 = new Point2D.Double(endLeftCenter.getX() - ((endLeftCenter.getX() - startLeftCenter.getX()) / 2), endLeftCenter.getY());
                     drawPath(startLeftCenter, endLeftCenter, ctrl1, ctrl2);
                  } else {
                     Point2D.Double ctrl1 = new Point2D.Double(startCenterTop.getX(), startCenterTop.getY() - ((startCenterTop.getY() - endCenterBottom.getY()) / 2));
                     Point2D.Double ctrl2 = new Point2D.Double(endCenterBottom.getX(), endCenterBottom.getY() - ((endCenterBottom.getY() - startCenterTop.getY()) / 2));
                     drawPath(startCenterTop, endCenterBottom, ctrl1, ctrl2);
                  }
               }
            }
         }

         private Point2D.Double p(double x, double y) {
            return new Point2D.Double(x, y);
         }

         private void drawPath(Point2D start, Point2D end, Point2D ctrl1, Point2D ctrl2) {
            switch (relationPathStrategy) {
               case straightLines:
                  drawStraightPath(start, end);
                  break;
               case rectangularLines:
                  drawRectangularLinesPath(start, end, ctrl1, ctrl2);
                  break;
               case bezierLines:
                  drawBezierPath(start, end, ctrl1, ctrl2);
                  break;
               case quadLines:
                  drawQuad(start, end, ctrl1, ctrl2);
                  break;
            }
         }

         private void drawStraightPath(Point2D start, Point2D end) {
            path.reset();
            if (!AppMotif.RelationPaintStrategy.showNothing.equals(relationPaintStrategy)) {
               path.setStrokePaint(currentPaint);

               path.moveTo(start.getX(), start.getY());
               path.lineTo(end.getX(), end.getY());
               pText.setTextPaint(currentPaint);
               pText.setOffset(path.getBounds().getCenter2D());

               // arrow
               final int ARR_SIZE = 4;
               final double dx = end.getX() - start.getX();
               final double dy = end.getY() - start.getY();
               final double angle = Math.atan2(dy, dx);
               final int len = (int) (Math.sqrt(dx * dx + dy * dy) - 10);
               final AffineTransform at = AffineTransform.getTranslateInstance(start.getX(), start.getY());
               at.concatenate(AffineTransform.getRotateInstance(angle));
               path.append(new Polygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len}, new int[]{0, -ARR_SIZE, ARR_SIZE, 0}, 4).getPathIterator(at), false);
            }

            repaintRelation();
         }

         private void drawRectangularLinesPath(Point2D start, Point2D end, Point2D ctrl1, Point2D ctrl2) {

            path.reset();
            if (!AppMotif.RelationPaintStrategy.showNothing.equals(relationPaintStrategy)) {
               path.setStrokePaint(currentPaint);

               path.moveTo(start.getX(), start.getY());
               path.lineTo(ctrl1.getX(), ctrl1.getY());
               path.moveTo(ctrl1.getX(), ctrl1.getY());
               path.lineTo(ctrl2.getX(), ctrl2.getY());
               path.moveTo(ctrl2.getX(), ctrl2.getY());
               path.lineTo(end.getX(), end.getY());

               pText.setTextPaint(currentPaint);
               pText.setOffset(path.getBounds().getCenter2D());
            }

            repaintRelation();
         }

         private void drawBezierPath(Point2D start, Point2D end, Point2D ctrl1, Point2D ctrl2) {

            path.reset();
            if (!AppMotif.RelationPaintStrategy.showNothing.equals(relationPaintStrategy)) {
               path.setStrokePaint(currentPaint);

               path.moveTo(start.getX(), start.getY());
               path.curveTo(ctrl1.getX(), ctrl1.getY(), ctrl2.getX(), ctrl2.getY(), end.getX(), end.getY());
               path.moveTo(end.getX(), end.getY());
               path.closePath();

               pText.setTextPaint(currentPaint);
               pText.setOffset(path.getBounds().getCenter2D());
            }

            repaintRelation();
         }

         private void drawQuad(Point2D start, Point2D end, Point2D ctrl1, Point2D ctrl2) {

            path.reset();
            if (!AppMotif.RelationPaintStrategy.showNothing.equals(relationPaintStrategy)) {
               path.setStrokePaint(currentPaint);

               path.moveTo(start.getX(), start.getY());
               path.quadTo(ctrl1.getX(), ctrl1.getY(), end.getX(), end.getY());
               path.moveTo(end.getX(), end.getY());
               path.closePath();

               pText.setTextPaint(currentPaint);
               pText.setOffset(path.getBounds().getCenter2D());
            }

            repaintRelation();
         }

         private void repaintRelation() {
            SwingUtilities.invokeLater(() -> {
               path.setPaintInvalid(true);
               path.validateFullPaint();
            });
         }

         void setRelationPaintStrategy(AppMotif.RelationPaintStrategy type) {
            switch (type) {
               case showLines:
                  path.removeChild(pText);
                  break;
               case showLinesAndLabels:
                  path.addChild(this.pText);
                  break;
               case showNothing:
                  path.removeChild(pText);
                  break;
            }

            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }

         void setRelationPathStrategy() {
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }
      }
   }

   private static String getNodeText(AppMotif.NodePaintStrategy nodePaintStrategy, Node node) {
      switch (nodePaintStrategy) {
         case showNameAndLabels:
            return getNameAndLabelsFrom(node);
         case showName:
            return getString(node, AppMotif.Properties.name.name());
         case showLabels:
            return labelsFor(node);
      }
      return "?";
   }
}
