package com.generator.app;

import com.generator.app.nodes.NeoNode;
import com.generator.app.nodes.NeoRelationship;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.neo.NeoModel;
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

import static com.generator.app.AppEvents.*;
import static com.generator.neo.NeoModel.Committer;
import static com.generator.util.NeoUtil.*;

/**
 * Created 18.07.17.
 */
public final class Workspace extends JPanel {

   private static final Random random = new Random(System.currentTimeMillis());

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

         setBackground(Color.decode(app.model.getCurrentCanvasColor()));

         nodeLayer = getLayer();
         getCamera().addLayer(0, relationLayer);

         // install mouse wheel zoom event handler
         removeInputEventListener(getZoomEventHandler());
         final CanvasZoomHandler mouseWheelZoomEventHandler = new CanvasZoomHandler();
         mouseWheelZoomEventHandler.zoomAboutMouse();
         addInputEventListener(mouseWheelZoomEventHandler);

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

                     pop.add(new App.TransactionAction("New Node", app) {
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

                           SwingUtil.showDialog(editor, app, "New Node", new SwingUtil.OnSave() {
                              @Override
                              public void verifyAndSave() throws Exception {

                                 final String selectedLabel = txtNewLabel.getText().trim().length() == 0 ? (String) cboExisting.getSelectedItem() : txtNewLabel.getText().trim();

                                 app.model.graph().doInTransaction(new NeoModel.Committer() {
                                    @Override
                                    public void doAction(Transaction tx) throws Throwable {
                                       app.events.firePropertyChange(NODE_LOAD, Collections.singleton(new AppEvents.NodeLoadEvent(app.model.graph().newNode(Label.label(selectedLabel)))));
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

                     final JMenu pluginsMenu = new JMenu("Plugins");
                     for (Plugin plugin : app.getPlugins()) {
                        final JMenu pluginMenu = new JMenu(plugin.name);
                        plugin.addActionsTo(pluginMenu);
                        pluginsMenu.add(pluginMenu);
                     }
                     if (pluginsMenu.getMenuComponents().length > 0) pop.add(pluginsMenu);

                     final JMenu selectAllMenu = new JMenu("Select all..");

                     selectAllMenu.add(new App.TransactionAction("Nodes on canvas", app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
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
                     });

                     final Set<String> distinctLabels = new TreeSet<>();
                     for (Object o : nodeLayer.getAllNodes()) {
                        if (o instanceof NeoNode) {
                           final NeoNode pNode = (NeoNode) o;
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

//                                 if (layerNodes.containsKey(newRelationship.getStartNode().getId()) && layerNodes.containsKey(newRelationship.getEndNode().getId())) {
//                                    final NodeCanvas.NeoNode source = layerNodes.get(newRelationship.getStartNode().getId());
//                                    final NodeCanvas.NeoNode destination = layerNodes.get(newRelationship.getEndNode().getId());
//                                    final NodeCanvas.NeoRelationship nodeRelation = new NodeCanvas.NeoRelationship(newRelationship, source, destination);
//                                    layerRelations.put(newRelationship.getId(), nodeRelation);
//                                    relationLayer.addChild(nodeRelation.path);
//                                 }
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
                           app.events.firePropertyChange(NODE_LOAD, AppMotif.getLayoutNodes(layoutNode));
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
                                       dependentNodes.add(other);
                                    });
                                 }

                                 if (dependentNodes.isEmpty() || SwingUtil.showConfirmDialog(app, "There are " + dependentNodes.size() + " nodes in graph which are dependent on nodes to delete. Are you sure you want to delete ?"))
                                    app.model.deleteNodes(nodes);
                              }
                           }
                        });
                     }

                     //todo this should be refactored to use cypher-params (for escaping of content, performance etc)
//                     pop.add(new App.TransactionAction("Import from clipboard", app) {
//                        @Override
//                        public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//                           final JTextArea textArea = new JTextArea("");
//
//                           SwingUtil.showTextInput("Cypher-import", textArea, nodeCanvas, () -> {
//                              final String query = textArea.getText().trim();
//                              if (query.length() == 0) return;
//                              final Result result = app.model.graph().query(query);
//
//                              SwingUtil.showMessage(result.resultAsString(), app);
//                           });
//                        }
//                     });
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
                     SwingUtilities.invokeLater(() -> {
                        app.undoLastTransaction();
                     });
                     break;

                  case KeyEvent.VK_A:
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
                              "W - iterate through nodes and center on screen\n" +
                              "1 - layout selected nodes vertical\n" +
                              "2 - layout selected nodes horizontal\n" +
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

                        SwingUtil.showTextResult("Help", text, NodeCanvas.this, false);

                     });
                     break;

                  case KeyEvent.VK_W:
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
                     break;

                  case KeyEvent.VK_F:

                     if (!event.isControlDown()) break;

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
                           app.model.graph().getAllPropertyKeys().forEach(properties::add);
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

                           SwingUtil.showDialog(editor, app, "Search", () -> {

                              app.model.graph().doInTransaction(new Committer() {
                                 @Override
                                 public void doAction(Transaction tx1) throws Throwable {

                                    final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();

                                    final String propertySearch = (String) cboProperties.getSelectedItem();
                                    final String valueSearch = txtValueSearch.getText().trim();

                                    if (radLabels.isSelected()) {

                                       final String labelSearch = (String) cboLabels.getSelectedItem();
                                       if (chkProperty.isSelected()) {
                                          app.model.graph().findNodes(Label.label(labelSearch), propertySearch, valueSearch).forEachRemaining(node -> nodes.add(new AppEvents.NodeLoadEvent(node)));
                                       } else {
                                          app.model.graph().findNodes(Label.label(labelSearch)).forEachRemaining(node -> nodes.add(new AppEvents.NodeLoadEvent(node)));
                                       }

                                    } else if (radRelationtypes.isSelected()) {

                                       final String relationSearch = (String) cboRelationships.getSelectedItem();
                                       app.model.graph().getAllRelationships().forEach(relationship -> {
                                          if (!relationship.getType().name().equals(relationSearch)) return;
                                          if (chkProperty.isSelected() && !relationship.hasProperty(propertySearch) && !valueSearch.equals(relationship.getProperty(propertySearch)))
                                             return;
                                          nodes.add(new AppEvents.NodeLoadEvent(relationship.getStartNode()));
                                          nodes.add(new AppEvents.NodeLoadEvent(relationship.getEndNode()));
                                       });

                                    }

                                    app.events.firePropertyChange(NODE_LOAD, nodes);
                                 }

                                 @Override
                                 public void exception(Throwable throwable) {
                                    SwingUtil.showExceptionNoStack(app, throwable);
                                 }
                              });
                           });
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showExceptionNoStack(app, throwable);
                        }
                     }));
                     break;

                  case KeyEvent.VK_E:

                     if (!event.isControlDown()) {
                        SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
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

                        SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                           @Override
                           public void doAction(Transaction tx) throws Throwable {
                              final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
                              for (NeoNode selectedNode : getSelectedNodes()) {
                                 final Node node = selectedNode.getNode();
                                 outgoing(node).forEach(relationship -> nodes.add(new AppEvents.NodeLoadEvent(other(node, relationship), null)));
                              }
                              app.events.firePropertyChange(NODE_LOAD, nodes);
                           }

                           @Override
                           public void exception(Throwable throwable) {
                              SwingUtil.showException(NodeCanvas.this, throwable);
                           }
                        }));
                     }

                     break;

                  case KeyEvent.VK_C:
                     SwingUtilities.invokeLater(() -> app.events.firePropertyChange(NODES_CLOSED, getSelectedNodes()));
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
                        app.events.firePropertyChange(NODES_SELECTED, Collections.emptySet());
                        app.events.firePropertyChange(NODES_SELECTED, newSelectedNodes);
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
                           relationPaintStrategy = AppMotif.RelationPaintStrategy.showLinesAndProperties;
                           break;
                        case showLinesAndProperties:
                           relationPaintStrategy = AppMotif.RelationPaintStrategy.showLines;
                           break;
                     }
                     app.events.firePropertyChange(RELATION_PAINTSTRATEGY_CHANGED, existingRelationPaintStrategy, relationPaintStrategy);
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
                     app.events.firePropertyChange(RELATION_PATHSTRATEGY_CHANGED, existingPathStrategy, relationPathStrategy);
                     break;

                  case KeyEvent.VK_R:
                     SwingUtilities.invokeLater(() -> {
                        final Set<NeoNode> nodesToClose = new LinkedHashSet<>();
                        for (Object o : nodeLayer.getAllNodes()) {
                           if (o instanceof NeoNode && !((NeoNode) o).isSelected())
                              nodesToClose.add((NeoNode) o);
                        }
                        app.events.firePropertyChange(NODES_CLOSED, nodesToClose);
                     });
                     break;

                  case KeyEvent.VK_1:
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
                     break;

                  case KeyEvent.VK_2:
                     SwingUtilities.invokeLater(() -> {
                        final Point2D startPosition = nodeCanvas.getCamera().localToView(nodeCanvas.getMousePosition());
                        final Point2D currentPosition = new Point((int) startPosition.getX(), (int) startPosition.getY());
                        int maxY = -1;
                        for (NeoNode pNode : getSelectedNodes()) {
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

      @NotNull
      public Point2D newRandomPosition() {

         final Point mousePosition = NodeCanvas.this.getMousePosition();
         System.out.println("mousePosition = " + mousePosition);

         System.out.println("getBounds() = " + getBounds());
         System.out.println("getCamera().getViewBounds() = " + getCamera().getViewBounds());
         System.out.println("getCamera().getFullBounds() = " + getCamera().getFullBounds());
         System.out.println("getCamera().getUnionOfLayerFullBounds() = " + getCamera().getUnionOfLayerFullBounds());
         System.out.println("getCamera().getFullBoundsReference() = " + getCamera().getFullBoundsReference());
         System.out.println("getCamera().getBoundsReference() = " + getCamera().getBoundsReference());
         System.out.println("getCamera().getGlobalBounds() = " + getCamera().getGlobalBounds());
         System.out.println("getCamera().getGlobalFullBounds() = " + getCamera().getGlobalFullBounds());


         /*
         *
            mousePosition = java.awt.Point[x=445,y=693]
            getBounds() = java.awt.Rectangle[x=0,y=0,width=1173,height=993]
            getCamera().getViewBounds() = PBounds[x=-3877.1215068783063,y=-3526.739733684169,width=1609.0534979423867,height=1362.139917695473]
            getCamera().getFullBounds() = PBounds[x=0.0,y=0.0,width=1173.0,height=993.0]
            getCamera().getUnionOfLayerFullBounds() = PBounds[x=-3751.4834371371794,y=-3470.2029259909928,width=1740.1707611166407,height=1111.4448238225987]
            getCamera().getFullBoundsReference() = PBounds[x=0.0,y=0.0,width=1173.0,height=993.0]
            getCamera().getBoundsReference() = PBounds[x=0.0,y=0.0,width=1173.0,height=993.0]
            getCamera().getGlobalBounds() = PBounds[x=0.0,y=0.0,width=1173.0,height=993.0]
            getCamera().getGlobalFullBounds() = PBounds[x=0.0,y=0.0,width=1173.0,height=993.0]
         * */


         // Point2D.Double[-3072.594757907113, -2845.6697748364327]
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

   private static final class CanvasZoomHandler extends PBasicInputEventHandler {

      static final double DEFAULT_SCALE_FACTOR = 0.1d;
      private double scaleFactor = DEFAULT_SCALE_FACTOR;

      private ZoomMode zoomMode = ZoomMode.ZOOM_ABOUT_CANVAS_CENTER;

      CanvasZoomHandler() {
         super();
         PInputEventFilter eventFilter = new PInputEventFilter();
         eventFilter.rejectAllEventTypes();
         eventFilter.setAcceptsMouseWheelRotated(true);
         setEventFilter(eventFilter);
      }

      double getScaleFactor() {
         return scaleFactor;
      }

      void setScaleFactor(final double scaleFactor) {
         this.scaleFactor = scaleFactor;
      }

      void zoomAboutMouse() {
         zoomMode = ZoomMode.ZOOM_ABOUT_MOUSE;
      }

      public void zoomAboutCanvasCenter() {
         zoomMode = ZoomMode.ZOOM_ABOUT_CANVAS_CENTER;
      }

      public void zoomAboutViewCenter() {
         zoomMode = ZoomMode.ZOOM_ABOUT_VIEW_CENTER;
      }

      ZoomMode getZoomMode() {
         return zoomMode;
      }

      public void mouseWheelRotated(final PInputEvent event) {

         PCamera camera = event.getCamera();

         // max scale min and max:
         if ((camera.getViewScale() < 0.36d && event.getWheelRotation() < 0) || (camera.getViewScale() > 1.49d && event.getWheelRotation() > 0))
            return;

         double scale = 1.0d + event.getWheelRotation() * scaleFactor;
         Point2D viewAboutPoint = getViewAboutPoint(event);
         camera.scaleViewAboutPoint(scale, viewAboutPoint.getX(), viewAboutPoint.getY());
      }

      private Point2D getViewAboutPoint(final PInputEvent event) {
         switch (zoomMode) {
            case ZOOM_ABOUT_MOUSE:
               return event.getPosition();
            case ZOOM_ABOUT_CANVAS_CENTER:
               Rectangle canvasBounds = ((PCanvas) event.getComponent()).getBounds();
               Point2D canvasCenter = new Point2D.Double(canvasBounds.getCenterX(), canvasBounds.getCenterY());
               event.getPath().canvasToLocal(canvasCenter, event.getCamera());
               return event.getCamera().localToView(canvasCenter);
            case ZOOM_ABOUT_VIEW_CENTER:
               return event.getCamera().getBoundsReference().getCenter2D();
         }
         throw new IllegalArgumentException("illegal zoom mode " + zoomMode);
      }

      enum ZoomMode {
         ZOOM_ABOUT_MOUSE, ZOOM_ABOUT_CANVAS_CENTER, ZOOM_ABOUT_VIEW_CENTER;
      }
   }

   public static String getNodeText(AppMotif.NodePaintStrategy nodePaintStrategy, Node node) {
      switch (nodePaintStrategy) {
         case showNameAndLabels:
            return getNameAndLabelsFrom(node) + " (" + node.getId() + ")";
         case showName:
            return getString(node, AppMotif.Properties.name.name(), "()");
         case showLabels:
            return labelsFor(node);
         case showProperties:
            final StringBuilder out = new StringBuilder();
            boolean first = true;
            for (String key : node.getPropertyKeys()) {
               if (AppMotif.Properties.x.name().equals(key)) continue;
               if (AppMotif.Properties.y.name().equals(key)) continue;
               if (AppMotif.Properties._color.name().equals(key)) continue;
               if (AppMotif.Properties._lastLayout.name().equals(key)) continue;
               if (TAG_UUID.equals(key)) continue;
               if (!first) out.append(", ");
               out.append(key).append(": '").append(node.getProperty(key)).append("'");
               first = false;
            }
            return out.toString();
         case showValues:

            if (hasLabel(node, DomainPlugin.Entities.Value)) {
               return getString(node, AppMotif.Properties.name.name(), "()");
            } else {

               for (Relationship instanceRelation : incoming(node, DomainPlugin.Relations.INSTANCE)) {
                  final Node instanceNode = other(node, instanceRelation);
                  if (hasLabel(instanceNode, StringTemplatePlugin.Entities.STTemplate)) {
                     return StringTemplatePlugin.renderStatement(node, instanceNode);

                  }
               }
            }
      }

      return "?";
   }

}
