package com.generator.app;

import com.generator.generators.cypher.CypherGroup;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.neo.NeoModel;
import com.generator.util.NeoUtil;
import com.generator.util.SwingUtil;
import org.abego.treelayout.Configuration;
import org.abego.treelayout.NodeExtentProvider;
import org.abego.treelayout.TreeForTreeLayout;
import org.abego.treelayout.TreeLayout;
import org.abego.treelayout.util.AbstractTreeForTreeLayout;
import org.abego.treelayout.util.DefaultConfiguration;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.piccolo2d.PCamera;
import org.piccolo2d.PCanvas;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PDragSequenceEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PInputEventFilter;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;
import org.piccolo2d.util.PBounds;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static com.generator.app.AppEvents.*;
import static com.generator.neo.NeoModel.Committer;
import static com.generator.util.NeoUtil.*;

/**
 * Created 18.07.17.
 */
public final class Workspace extends JPanel {

   private static final Random random = new Random(System.currentTimeMillis());

   private final Map<Long, NodeCanvas.NeoNode> layerNodes = new LinkedHashMap<>();
   private final Map<Long, NodeCanvas.NeoRelationship> layerRelations = new LinkedHashMap<>();

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

   public class NodeCanvas extends PCanvas {

      private final Color selectedNodeColor = Color.decode("#d95f0e");
      private final Color highlightedNodeColor = Color.decode("#43a2ca");
      private AppMotif.RelationPaintStrategy relationPaintStrategy = app.model.getRelationPaintStrategy();
      private AppMotif.RelationPathStrategy relationPathStrategy = app.model.getRelationPathStrategy();
      private AppMotif.NodePaintStrategy nodePaintStrategy = app.model.getNodePaintStrategy();

      private final PLayer relationLayer = new PLayer();
      private final PLayer nodeLayer;

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
                              final Set<NodeCanvas.NeoNode> selectedNodes = new LinkedHashSet<>();
                              for (Object o : nodeLayer.getAllNodes()) {
                                 if (o instanceof NodeCanvas.NeoNode) {
                                    final NodeCanvas.NeoNode neoNode = (NodeCanvas.NeoNode) o;
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
                                 app.events.firePropertyChange(NODES_SELECTED, selectedNodes);
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

                     final Set<NodeCanvas.NeoNode> selectedNodes = getSelectedNodes();
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
                                 for (NodeCanvas.NeoNode selectedNode : selectedNodes)
                                    nodes.add(selectedNode.getNode());

                                 final Set<Workspace.NodeCanvas.NeoNode> allNodes = nodeCanvas.getAllNodes();
                                 final Set<Node> visibleNodes = new LinkedHashSet<>();
                                 for (Workspace.NodeCanvas.NeoNode neoNode : allNodes)
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
                     if (o instanceof NodeCanvas.NeoNode)
                        ((NodeCanvas.NeoNode) o).unselect();
                  }
                  for (Object o : relationLayer.getAllNodes()) {
                     if (o instanceof PPath) {
                        final NodeCanvas.NeoRelationship neoRelationship = layerRelations.get(((PPath) o).getAttribute("id"));
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
                        final Set<NodeCanvas.NeoNode> selectedNodes = new LinkedHashSet<>();
                        for (Object o : nodeLayer.getAllNodes()) {
                           if (o instanceof NodeCanvas.NeoNode) {
                              final NodeCanvas.NeoNode neoNode = (NodeCanvas.NeoNode) o;
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
                              for (NodeCanvas.NeoNode selectedNode : getSelectedNodes()) {
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
                              for (NodeCanvas.NeoNode selectedNode : getSelectedNodes()) {
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
                        final Set<NodeCanvas.NeoNode> nodesToClose = new LinkedHashSet<>();
                        for (Object o : nodeLayer.getAllNodes()) {
                           if (o instanceof NodeCanvas.NeoNode && !((NodeCanvas.NeoNode) o).isSelected())
                              nodesToClose.add((NodeCanvas.NeoNode) o);
                        }
                        app.events.firePropertyChange(NODES_CLOSED, nodesToClose);
                     });
                     break;

                  case KeyEvent.VK_1:
                     SwingUtilities.invokeLater(() -> {
                        final Point2D startPosition = nodeCanvas.getCamera().localToView(nodeCanvas.getMousePosition());
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
                        final Point2D startPosition = nodeCanvas.getCamera().localToView(nodeCanvas.getMousePosition());
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
                        final NodeCanvas.NeoNode pNode = layerNodes.get(node.getId());
                        pNode.select();
                        if (nodeLoadEvent.centerOnScreen)
                           nodeCanvas.getCamera().animateViewToCenterBounds(pNode.getGlobalFullBounds(), false, 500);
                     });

                  } else {

                     final NodeCanvas.NeoNode newPNode = new NodeCanvas.NeoNode(node, nodeLoadEvent.position, canvasInputListener, nodeLayer);
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
                     final NodeCanvas.NeoRelationship nodeRelation = new NodeCanvas.NeoRelationship(relationship, layerNodes.get(relationship.getStartNode().getId()), layerNodes.get(relationship.getEndNode().getId()));
                     layerRelations.put(relationship.getId(), nodeRelation);
                     relationLayer.addChild(nodeRelation.path);
                  }
               }
            }
         });

         app.events.addPropertyChangeListener(AppEvents.NODES_CLOSED, evt -> {
            for (NodeCanvas.NeoNode neoNode : (Set<NodeCanvas.NeoNode>) evt.getNewValue()) {
               final NodeCanvas.NeoNode remove = layerNodes.remove(neoNode.id());
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
            final Set<NodeCanvas.NeoNode> removedNodes = new LinkedHashSet<>();
            for (Long neoNode : (Set<Long>) evt.getNewValue()) {
               final NodeCanvas.NeoNode remove = layerNodes.remove(neoNode);
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
               for (NodeCanvas.NeoNode neoNode : layerNodes.values())
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
      private Point2D newRandomPosition() {

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

      public class NeoNode extends PNode {

         private final PText delegate;
         private Color defaultNodeColor = Color.BLACK;

         NeoNode(Node node, Point2D offset, PBasicInputEventHandler canvasInputListener, PLayer nodeLayer) {
            super();

            delegate = new PText(getNodeText(nodePaintStrategy, node));
            addChild(delegate);

            addAttribute("id", node.getId());
            addAttribute("node", node);

            for (org.neo4j.graphdb.Label label : node.getLabels()) {
               final Node colorNode = app.model.graph().findNode(AppMotif.Entities._Color, "label", label.name());
               if (colorNode == null) continue;
               final String color = getString(colorNode, AppMotif.Properties._color.name());
               defaultNodeColor = Color.decode(color);
               break;
            }
            if (defaultNodeColor == null) defaultNodeColor = Color.BLACK;

            setOffset(offset == null ? (node.hasProperty(AppMotif.Properties.x.name()) ? new Point2D.Double(getDouble(node, AppMotif.Properties.x.name()), getDouble(node, AppMotif.Properties.y.name())) : newRandomPosition()) : offset);

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
                  app.events.firePropertyChange(NODE_HIGHLIGHTED, NodeCanvas.NeoNode.this);
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
                  app.events.firePropertyChange(NODES_SELECTED, getSelectedNodes());
               }

               private void onMiddleClick(PInputEvent event) {

               }

               @Override
               public void keyPressed(PInputEvent event) {
                  switch (event.getKeyCode()) {

                     case KeyEvent.VK_1:
                        SwingUtilities.invokeLater(() -> {
                           layoutTree(new DefaultConfiguration<>(50, 15, Configuration.Location.Left), !event.isControlDown());
                        });
                        break;

                     case KeyEvent.VK_2:
                        SwingUtilities.invokeLater(() -> {
                           layoutTree(new DefaultConfiguration<>(50, 15, Configuration.Location.Right), !event.isControlDown());
                        });
                        break;

                     case KeyEvent.VK_3:
                        SwingUtilities.invokeLater(() -> {
                           layoutTree(new DefaultConfiguration<>(50, 15, Configuration.Location.Bottom), !event.isControlDown());
                        });
                        break;

                     case KeyEvent.VK_4:
                        SwingUtilities.invokeLater(() -> {
                           layoutTree(new DefaultConfiguration<>(50, 15, Configuration.Location.Top), !event.isControlDown());
                        });
                        break;


                     case KeyEvent.VK_C:
                        SwingUtilities.invokeLater(() -> app.events.firePropertyChange(NODES_CLOSED, Collections.singleton(NodeCanvas.NeoNode.this)));
                        break;


                     case KeyEvent.VK_R:
                        SwingUtilities.invokeLater(() -> {

                           final Set<NodeCanvas.NeoNode> nodesToClose = new LinkedHashSet<>();
                           for (Object o : nodeLayer.getAllNodes()) {
                              if (o instanceof NodeCanvas.NeoNode && !((NodeCanvas.NeoNode) o).isSelected() && !NodeCanvas.NeoNode.this.equals(o))
                                 nodesToClose.add((NodeCanvas.NeoNode) o);
                           }
                           app.events.firePropertyChange(NODES_CLOSED, nodesToClose);
                        });
                        break;

                     case KeyEvent.VK_E:

                        if (event.isControlDown()) {
                           SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {

                                 final Map<String, Set<AppEvents.NodeLoadEvent>> nodesByType = new TreeMap<>();
                                 outgoing(node).forEach(relationship -> {
                                    final Set<AppEvents.NodeLoadEvent> eventSet = nodesByType.computeIfAbsent(relationship.getType().name(), k -> new LinkedHashSet<>());
                                    eventSet.add(new AppEvents.NodeLoadEvent(other(node, relationship), null));
                                 });

                                 if (nodesByType.size() == 1) {

                                    for (Set<AppEvents.NodeLoadEvent> nodeLoadEvents : nodesByType.values())
                                       app.events.firePropertyChange(NODE_LOAD, nodeLoadEvents);

                                 } else {
                                    final JPopupMenu pop = new JPopupMenu();
                                    for (Map.Entry<String, Set<AppEvents.NodeLoadEvent>> entry : nodesByType.entrySet()) {
                                       pop.add(new App.TransactionAction(entry.getKey(), app) {
                                          @Override
                                          protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                                             app.events.firePropertyChange(NODE_LOAD, entry.getValue());
                                          }
                                       });
                                    }
                                    pop.add(new App.TransactionAction("All", app) {
                                       @Override
                                       protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                                          for (Set<AppEvents.NodeLoadEvent> nodeLoadEvents : nodesByType.values()) {
                                             app.events.firePropertyChange(NODE_LOAD, nodeLoadEvents);
                                          }
                                       }
                                    });

                                    final Point2D position = app.getMousePosition();
                                    pop.show(app, (int) position.getX(), (int) position.getY());
                                 }
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
                                 final Set<NeoNode> nodes = new LinkedHashSet<>();
                                 outgoing(node).forEach(relationship -> {
                                    if (!layerRelations.containsKey(relationship.getId())) return;
                                    final NeoNode target = (NeoNode) layerRelations.get(relationship.getId()).path.getAttribute("target");
                                    target.select();
                                    nodes.add(target);
                                 });
                                 app.events.firePropertyChange(NODES_SELECTED, nodes);
                              }

                              @Override
                              public void exception(Throwable throwable) {
                                 SwingUtil.showException(NodeCanvas.this, throwable);
                              }
                           }));
                        }
                        break;

                     case KeyEvent.VK_D:

                        if (!event.isControlDown()) {

                           SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {
                                 final Set<NeoNode> nodes = new LinkedHashSet<>();
                                 incoming(node).forEach(relationship -> {
                                    if (!layerRelations.containsKey(relationship.getId())) return;
                                    final NeoNode source = (NeoNode) layerRelations.get(relationship.getId()).path.getAttribute("source");
                                    source.select();
                                    nodes.add(source);
                                 });
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
                                 incoming(node).forEach(relationship -> {
                                    if (relationship.getType().name().equals(AppMotif.Relations._LAYOUT_MEMBER.name()))
                                       return;
                                    nodes.add(new AppEvents.NodeLoadEvent(other(node, relationship), null));
                                 });
                                 app.events.firePropertyChange(NODE_LOAD, nodes);
                              }

                              @Override
                              public void exception(Throwable throwable) {
                                 SwingUtil.showException(NodeCanvas.this, throwable);
                              }
                           }));
                        }

                        break;
                  }
               }

               private void layoutTree(Configuration<NeoNode> configuration, boolean outgoing) {

                  final Map<Long, NeoNode> nodesAndIds = new LinkedHashMap<>();
                  for (NeoNode selectedNode : nodeCanvas.getAllNodes())
                     nodesAndIds.put(selectedNode.id(), selectedNode);

                  final Map<Long, NeoNode> parentsMap = new LinkedHashMap<>();
                  final Map<Long, List<NeoNode>> childrensMap = new LinkedHashMap<>();

                  app.model.graph().doInTransaction(new Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {

                        // recursively traverse from root, finding all visible-children and populate parentsMap and childrensMap:
                        visit(new LinkedHashSet<>(), NeoNode.this, outgoing);

                        final TreeForTreeLayout<NeoNode> tree = new AbstractTreeForTreeLayout<NeoNode>(NeoNode.this) {
                           @Override
                           public NeoNode getParent(NeoNode neoNode) {
                              return parentsMap.get(neoNode.id());
                           }

                           @Override
                           public List<NeoNode> getChildrenList(NeoNode neoNode) {
                              return childrensMap.get(neoNode.id());
                           }
                        };

                        final NodeExtentProvider<NeoNode> nodeExtendProvider = new NodeExtentProvider<NeoNode>() {
                           @Override
                           public double getWidth(NeoNode neoNode) {
                              return neoNode.getFullBounds().getWidth();
                           }

                           @Override
                           public double getHeight(NeoNode neoNode) {
                              return neoNode.getFullBounds().getHeight();
                           }
                        };


                        final TreeLayout<NeoNode> layout = new TreeLayout<>(tree, nodeExtendProvider, configuration);

                        // apply coordination-translation
                        final Point2D rootLocation = getOffset();
                        final Map<NeoNode, Rectangle2D.Double> nodeBounds = layout.getNodeBounds();
                        final Rectangle2D.Double rootBounds = nodeBounds.get(NeoNode.this);
                        final double dX = rootLocation.getX() - rootBounds.getCenterX();
                        final double dY = rootLocation.getY() - rootBounds.getCenterY();
                        for (Map.Entry<NeoNode, Rectangle2D.Double> nodeBound : nodeBounds.entrySet()) {
                           final double centerX = nodeBound.getValue().getCenterX() + dX;
                           final double centerY = nodeBound.getValue().getCenterY() + dY;
                           nodeBound.getKey().setOffset(centerX, centerY);
                        }
                     }

                     private void visit(Set<NeoNode> visitedChildren, NeoNode root, boolean outgoing) {
                        childrensMap.put(root.id(), new ArrayList<>());

                        final Set<Long> childrenToVisit = new LinkedHashSet<>();
                        if (outgoing) {
                           outgoing(root.getNode()).forEach(relationship -> {
                              final Node childNode = other(root.getNode(), relationship);
                              final long childId = childNode.getId();
                              // if child is visible, and not already visited, add to root
                              if (nodesAndIds.containsKey(childId) && !visitedChildren.contains(nodesAndIds.get(childId))) {
                                 visitedChildren.add(nodesAndIds.get(childId));
                                 parentsMap.put(childId, root);
                                 childrensMap.get(root.id()).add(nodesAndIds.get(childId));
                                 childrenToVisit.add(childId);
                              }
                           });
                        } else {
                           incoming(root.getNode()).forEach(relationship -> {
                              final Node childNode = other(root.getNode(), relationship);
                              final long childId = childNode.getId();
                              // if child is visible, and not already visited, add to root
                              if (nodesAndIds.containsKey(childId) && !visitedChildren.contains(nodesAndIds.get(childId))) {
                                 visitedChildren.add(nodesAndIds.get(childId));
                                 parentsMap.put(childId, root);
                                 childrensMap.get(root.id()).add(nodesAndIds.get(childId));
                                 childrenToVisit.add(childId);
                              }
                           });
                        }

                        // recursively visit added children:
                        for (Long childNode : childrenToVisit)
                           visit(visitedChildren, nodesAndIds.get(childNode), outgoing);
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showExceptionNoStack(app, throwable);
                     }
                  });
               }
            };

            nodeEventListener.getEventFilter().setMarksAcceptedEventsAsHandled(true);
            addInputEventListener(nodeEventListener);
         }

         void setPaintStrategy(AppMotif.NodePaintStrategy nodePaintStrategy) {
            delegate.setText(getNodeText(nodePaintStrategy, getNode()));
         }

         private void onRightClick(PInputEvent event) {
            SwingUtilities.invokeLater(() -> app.model.graph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  app.getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                  final JPopupMenu pop = new JPopupMenu();

                  final Set<NodeCanvas.NeoNode> selectedNodes = new LinkedHashSet<>();
                  for (Object o : nodeLayer.getAllNodes())
                     if (o instanceof NodeCanvas.NeoNode && ((NodeCanvas.NeoNode) o).isSelected() && !NodeCanvas.NeoNode.this.equals(o))
                        selectedNodes.add((NodeCanvas.NeoNode) o);

                  // specialised node-types:
                  for (Plugin plugin : app.plugins)
                     plugin.handleNodeRightClick(pop, NodeCanvas.NeoNode.this, selectedNodes);

                  // Basic graph-operations:
                  pop.add(new JSeparator());
                  final JMenu relationsMenu = new JMenu("Relations");
                  final JMenu showAllRelationMenu = new JMenu("Show all ");
                  final JMenu closeAll = new JMenu("Close all ");
                  final JMenu selectAll = new JMenu("Select all ");
                  final Set<String> relations = new TreeSet<>();
                  outgoing(getNode()).forEach(relationship -> relations.add(relationship.getType().name()));

                  for (String relation : relations) {
                     showAllRelationMenu.add(new App.TransactionAction(relation, app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                           final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
                           outgoing(getNode(), RelationshipType.withName(relation)).forEach(relationship -> nodes.add(new AppEvents.NodeLoadEvent(other(getNode(), relationship))));
                           app.events.firePropertyChange(NODE_LOAD, nodes);
                        }
                     });

                     closeAll.add(new App.TransactionAction(relation, app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                           final Set<NeoNode> neoNodes = new LinkedHashSet<>();
                           outgoing(getNode(), RelationshipType.withName(relation)).forEach(relationship -> {
                              if (!app.workspace.layerNodes.containsKey(relationship.getEndNode().getId())) return;
                              neoNodes.add(app.workspace.layerNodes.get(relationship.getEndNode().getId()));
                           });

                           app.events.firePropertyChange(NODES_CLOSED, neoNodes);
                        }
                     });

                     selectAll.add(new App.TransactionAction(relation, app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                           final Set<NeoNode> neoNodes = new LinkedHashSet<>();
                           outgoing(getNode(), RelationshipType.withName(relation)).forEach(relationship -> {
                              if (!app.workspace.layerNodes.containsKey(relationship.getEndNode().getId())) return;
                              final NeoNode node = app.workspace.layerNodes.get(relationship.getEndNode().getId());
                              node.select();
                              neoNodes.add(node);
                           });

                           app.events.firePropertyChange(NODES_SELECTED, neoNodes);
                        }
                     });
                  }
                  if (showAllRelationMenu.getMenuComponents().length > 0) {
                     relationsMenu.add(showAllRelationMenu);
                     relationsMenu.add(selectAll);
                     relationsMenu.add(closeAll);
                  }
                  if (relationsMenu.getMenuComponents().length > 0) pop.add(relationsMenu);

                  pop.add(new JSeparator());
                  if (!selectedNodes.isEmpty()) {
                     pop.add(new App.TransactionAction("Add relationship", app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                           final Set<String> relationships = new LinkedHashSet<>();
                           app.model.graph().getAllRelationshipTypesInUse().forEach(relationshipType -> relationships.add(relationshipType.name()));
                           final JComboBox<String> cboRelationships = new JComboBox<>(relationships.toArray(new String[relationships.size()]));

                           final JRadioButton radOneToMany = new JRadioButton();
                           final JRadioButton radManyToOne = new JRadioButton("", true);
                           final ButtonGroup group = new ButtonGroup();
                           group.add(radOneToMany);
                           group.add(radManyToOne);

                           final JTextField txtSearch = new JTextField();
                           txtSearch.addKeyListener(new KeyAdapter() {
                              @Override
                              public void keyReleased(KeyEvent e) {
                                 SwingUtilities.invokeLater(() -> {
                                    final String s = txtSearch.getText().trim().toLowerCase();
                                    for (String lbl : relationships) {
                                       if (lbl.toLowerCase().startsWith(s)) {
                                          cboRelationships.setSelectedItem(lbl);
                                       }
                                    }
                                 });
                              }
                           });


                           final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref,4dlu,pref,4dlu,pref,4dlu,pref");
                           editor.addLabel("Relationship", 1, 1);
                           editor.add(cboRelationships, 3, 1);
                           editor.addLabel("Search", 1, 3);
                           editor.add(txtSearch, 3, 3);
                           editor.addLabel("this -> " + selectedNodes.size(), 1, 5);
                           editor.add(radOneToMany, 3, 5);
                           editor.addLabel(selectedNodes.size() + " -> this", 1, 7);
                           editor.add(radManyToOne, 3, 7);

                           editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

                           SwingUtil.showDialog(editor, app, "Add relationships", () -> {

                              final String selected = (String) cboRelationships.getSelectedItem();

                              app.model.graph().doInTransaction(new Committer() {
                                 @Override
                                 public void doAction(Transaction tx1) throws Throwable {
                                    for (NeoNode selectedNode : selectedNodes) {
                                       if (radOneToMany.isSelected() && NeoUtil.isRelated(getNode(), selectedNode.getNode(), RelationshipType.withName(selected)))
                                          continue;
                                       else if (radManyToOne.isSelected() && NeoUtil.isRelated(selectedNode.getNode(), getNode(), RelationshipType.withName(selected)))
                                          continue;

                                       if (radOneToMany.isSelected())
                                          getNode().createRelationshipTo(selectedNode.getNode(), RelationshipType.withName(selected));
                                       if (radManyToOne.isSelected())
                                          selectedNode.getNode().createRelationshipTo(getNode(), RelationshipType.withName(selected));
                                    }
                                 }

                                 @Override
                                 public void exception(Throwable throwable) {
                                    SwingUtil.showExceptionNoStack(app, throwable);
                                 }
                              });
                           });
                        }
                     });
                  }
                  pop.add(new App.TransactionAction("Set Node-property", app) {

                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        final String newProperty = SwingUtil.showInputDialog("[Property] [value]", NodeCanvas.this);
                        if (newProperty == null || newProperty.split("[ ]").length != 2) return;

                        final String property = newProperty.split("[ ]")[0];
                        final String value = newProperty.split("[ ]")[1];
                        getNode().setProperty(property, value);
                        app.events.firePropertyChange(NODE_CHANGED + getNode().getId(), property, value);
                     }
                  });
                  pop.add(new App.TransactionAction("Select all " + getNameAndLabelsFrom(getNode()), app) {

                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        final String id = getNameAndLabelsFrom(getNode());
                        final Set<NodeCanvas.NeoNode> nodes = new LinkedHashSet<>();
                        for (NeoNode neoNode : nodeCanvas.getAllNodes()) {
                           if (!id.equals(getNameAndLabelsFrom(neoNode.getNode()))) continue;
                           neoNode.select();
                           nodes.add(neoNode);
                        }
                        app.events.firePropertyChange(NODES_SELECTED, nodes);

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
                           app.events.firePropertyChange(NODES_CLOSED, nodesToClose);
                        });
                     }
                  });
                  pop.add(new App.TransactionAction("Close", app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        app.events.firePropertyChange(NODES_CLOSED, Collections.singleton(NodeCanvas.NeoNode.this));
                     }
                  });
                  pop.add(new App.TransactionAction("Delete", app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        if (SwingUtil.showConfirmDialog(app, "Delete " + getNameAndLabelsFrom(getNode()) + " ?")) {
                           app.model.deleteNodes(Collections.singleton(getNode()));

                        }
                     }
                  });
                  pop.add(new App.TransactionAction("Export Branch", app) {

                     // to avoid escaping etc in cypher, just use parameters from
                     // http://neo4j.com/docs/developer-manual/current/cypher/syntax/parameters/

                     /***
                      *
                      * 3.2.4.7. Setting all properties on a node

                      Note that this will replace all the current properties.

                      Parameters.
                      todo export like this
                      {
                      "props" : {
                      "name" : "Andres",
                      "position" : "Developer"
                      }
                      }

                      todo import using data above, and _uuid:
                      Query.

                      MATCH (n:Person)
                      WHERE n.name='Michaela'
                      SET n = $props
                      *
                      */


                     final CypherGroup cypherGroup = new CypherGroup();

                     @Override
                     public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        final CypherGroup.createNodesST createNodesST = cypherGroup.newcreateNodes();

                        final LinkedHashSet<Relationship> relationships = new LinkedHashSet<>();
                        exportNode(createNodesST, cypherGroup, getNode(), new LinkedHashSet<>(), relationships);

                        // add relations at end, using node-uuids:
                        final CypherGroup.createRelationshipsST createRelationshipsST = cypherGroup.newcreateRelationships();
                        for (Relationship relationship : relationships) {
                           final Object src = relationship.getStartNode().getProperty(TAG_UUID).toString().replaceAll("-", "_");
                           final Object dst = relationship.getEndNode().getProperty(TAG_UUID).toString().replaceAll("-", "_");
                           final CypherGroup.createRelationshipST createRelationshipST = cypherGroup.newcreateRelationship().
                                 setSrc(src).
                                 setType(relationship.getType().name()).
                                 setDst(dst);

                           for (String key : relationship.getPropertyKeys())
                              createRelationshipST.addPropertiesValue(cypherGroup.newstringProperty().setName(key).setValue(relationship.getProperty(key)));
                           createRelationshipsST.addRelationshipsValue(createRelationshipST.toString());
                        }

                        SwingUtil.showTextResult("Export", createNodesST + (relationships.isEmpty() ? "" : ("\n" + createRelationshipsST)), nodeCanvas);
                     }

                     // todo consider creating a clone version of this
                     private void exportNode(CypherGroup.createNodesST export, CypherGroup neoGroup, Node node, Set<Node> visitedNodes, Set<Relationship> relationships) {

                        if (visitedNodes.contains(node)) return;
                        visitedNodes.add(node);

                        final Object id = node.getProperty(TAG_UUID).toString().replaceAll("-", "_");
                        final CypherGroup.createNodeST createNodeST = neoGroup.newcreateNode().
                              setId(id);
                        for (Label label : node.getLabels()) createNodeST.addLabelsValue(label);

                        for (String key : node.getPropertyKeys())
                           createNodeST.addPropertiesValue(neoGroup.newstringProperty().setName(key).setValue(node.getProperty(key)));
                        export.addNodesValue(createNodeST.toString());

                        final Set<Node> unvisitedNodes = new LinkedHashSet<>();
                        for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) {
                           final Node endNode = relationship.getEndNode();
                           if (!layerNodes.containsKey(endNode.getId())) continue;
                           if (relationships.contains(relationship)) continue;
                           relationships.add(relationship);

                           if (!visitedNodes.contains(endNode)) unvisitedNodes.add(endNode);
                        }

                        for (Node unvisitedNode : unvisitedNodes) {
                           if (visitedNodes.contains(unvisitedNode)) continue;
                           exportNode(export, neoGroup, unvisitedNode, visitedNodes, relationships);
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

         Long id() {
            return Long.valueOf(getAttribute("id").toString());
         }

         void setColor(Color color) {
            defaultNodeColor = color;
            setTextPaint(color);
         }

         private void setTextPaint(Color color) {
            delegate.setTextPaint(color);
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

         public Node getNode() {
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
         private Paint defaultColor = Color.decode("#252525");
         private Paint currentPaint = defaultColor;
         private PText pText;

         NeoRelationship(Relationship relationship, NodeCanvas.NeoNode source, NodeCanvas.NeoNode target) {
            pText = new PText();
            path = PPath.createLine(source.getFullBoundsReference().getCenter2D().getX(), source.getFullBoundsReference().getCenter2D().getY(), target.getFullBoundsReference().getCenter2D().getX(), target.getFullBoundsReference().getCenter2D().getY());

            final Node colorNode = app.model.graph().findNode(AppMotif.Entities._Color, "relation", relationship.getType().name());
            if (colorNode != null)
               defaultColor = Color.decode(getString(colorNode, AppMotif.Properties._color.name()));
            path.setStrokePaint(defaultColor);
            path.addAttribute("id", relationship.getId());
            path.addAttribute("relationship", relationship);
            path.addAttribute("source", source);
            path.addAttribute("target", target);
            source.addPropertyChangeListener(this);
            target.addPropertyChangeListener(this);

            switch (relationPaintStrategy) {
               case showLinesAndLabels:
                  this.pText.setText(relationship.getType().name());
                  path.addChild(this.pText);
                  break;
               case showLinesAndProperties:
                  this.pText.setText(propertiesFor(relationship));
                  path.addChild(this.pText);
                  break;
            }

            updatePath(source, target);


            final PBasicInputEventHandler relationEventListener = new PBasicInputEventHandler() {
               @Override
               public void mouseEntered(PInputEvent event) {
                  currentPaint = highlightedNodeColor;
                  repaintRelation();
                  app.events.firePropertyChange(RELATION_HIGHLIGHTED, NodeCanvas.NeoRelationship.this);
               }

               @Override
               public void mouseExited(PInputEvent event) {
                  currentPaint = path.getBooleanAttribute("selected", false) ? selectedNodeColor : defaultColor;
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

                              final String existingType = relationship.getType().name();

                              final Set<String> relationships = new LinkedHashSet<>();
                              app.model.graph().getAllRelationshipTypesInUse().forEach(relationshipType -> relationships.add(relationshipType.name()));
                              final JComboBox<String> cboRelationships = new JComboBox<>(relationships.toArray(new String[relationships.size()]));
                              cboRelationships.setSelectedItem(existingType);

                              final JRadioButton radOneToMany = new JRadioButton();
                              final JRadioButton radManyToOne = new JRadioButton("", true);
                              final ButtonGroup group = new ButtonGroup();
                              group.add(radOneToMany);
                              group.add(radManyToOne);

                              final JTextField txtSearch = new JTextField();
                              txtSearch.addKeyListener(new KeyAdapter() {
                                 @Override
                                 public void keyReleased(KeyEvent e) {
                                    SwingUtilities.invokeLater(() -> {
                                       final String s = txtSearch.getText().trim().toLowerCase();
                                       for (String lbl : relationships) {
                                          if (lbl.toLowerCase().startsWith(s)) {
                                             cboRelationships.setSelectedItem(lbl);
                                          }
                                       }
                                    });
                                 }
                              });

                              final JTextField txtNew = new JTextField();

                              final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref,4dlu,pref,4dlu,pref");
                              editor.addLabel("Relationship", 1, 1);
                              editor.add(cboRelationships, 3, 1);
                              editor.addLabel("Search", 1, 3);
                              editor.add(txtSearch, 3, 3);
                              editor.addLabel("New", 1, 5);
                              editor.add(txtNew, 3, 5);
                              editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

                              SwingUtil.showDialog(editor, app, "Change type", () -> {

                                 final String newType = txtNew.getText().trim().length() == 0 ? (String) cboRelationships.getSelectedItem() : txtNew.getText().trim().toUpperCase();

                                 app.model.graph().doInTransaction(new Committer() {
                                    @Override
                                    public void doAction(Transaction tx1) throws Throwable {
                                       final Relationship newRelationship = relationship.getStartNode().createRelationshipTo(relationship.getEndNode(), RelationshipType.withName(newType));
                                       for (String key : relationship.getPropertyKeys())
                                          newRelationship.setProperty(key, relationship.getProperty(key));
                                       relationship.delete();
                                    }

                                    @Override
                                    public void exception(Throwable throwable) {
                                       SwingUtil.showExceptionNoStack(app, throwable);
                                    }
                                 });
                              });
                           }
                        });

                        pop.add(new App.TransactionAction("Reverse Direction", app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                              final Relationship newRelationship = relationship.getEndNode().createRelationshipTo(relationship.getStartNode(), relationship.getType());
                              for (String key : relationship.getPropertyKeys())
                                 newRelationship.setProperty(key, relationship.getProperty(key));
                              relationship.delete();
                           }
                        });

                        pop.add(new App.TransactionAction("Set Property", app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                              final String propertyValue = SwingUtil.showInputDialog("Property Name and value", NodeCanvas.this);
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
                                 app.model.deleteRelations(Collections.singleton(relationship));
                              }
                              app.events.firePropertyChange(NODE_CHANGED + startNode);
                              app.events.firePropertyChange(NODE_CHANGED + endNode);
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
                  app.events.firePropertyChange(RELATIONS_SELECTED, getSelectedRelations());
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
            currentPaint = path.getBooleanAttribute("selected", false) ? selectedNodeColor : defaultColor;
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }

         void toggleSelect() {
            path.addAttribute("selected", !path.getBooleanAttribute("selected", false));
            currentPaint = path.getBooleanAttribute("selected", false) ? selectedNodeColor : defaultColor;
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }

         void select() {
            path.addAttribute("selected", Boolean.TRUE);
            currentPaint = selectedNodeColor;
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }

         void unselect() {
            path.addAttribute("selected", Boolean.FALSE);
            currentPaint = defaultColor;
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }


         boolean isSelected() {
            return path.getBooleanAttribute("selected", false);
         }

         Relationship getRelationship() {
            return (Relationship) path.getAttribute("relationship");
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
                  path.removeChild(pText);
                  this.pText.setText(getRelationship().getType().name());
                  path.addChild(this.pText);
                  break;
               case showNothing:
                  path.removeChild(pText);
                  break;
               case showLinesAndProperties:
                  path.removeChild(pText);
                  this.pText.setText(propertiesFor(getRelationship()));
                  path.addChild(this.pText);
                  break;
            }

            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }

         void setRelationPathStrategy() {
            updatePath(((NodeCanvas.NeoNode) path.getAttribute("source")), (NodeCanvas.NeoNode) path.getAttribute("target"));
         }

         void removeFromCanvas() {
            ((NodeCanvas.NeoNode) path.getAttribute("source")).removePropertyChangeListener(NeoRelationship.this);
            ((NodeCanvas.NeoNode) path.getAttribute("target")).removePropertyChangeListener(NeoRelationship.this);
            layerRelations.remove(Long.valueOf(path.getAttribute("id").toString()));
            relationLayer.removeChild(path);
         }
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

   private static String getNodeText(AppMotif.NodePaintStrategy nodePaintStrategy, Node node) {
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
