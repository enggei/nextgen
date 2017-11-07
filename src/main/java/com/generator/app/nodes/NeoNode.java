package com.generator.app.nodes;

import com.generator.app.*;
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
import org.neo4j.graphdb.*;
import org.piccolo2d.PLayer;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PDragSequenceEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static com.generator.app.AppEvents.*;
import static com.generator.util.NeoUtil.*;

/**
 * Created 01.10.17.
 */
public class NeoNode extends PNode {

   private Workspace workspace;
   private Workspace.NodeCanvas nodeCanvas;
   private final PText delegate;
   private Color defaultNodeColor = Color.BLACK;

   public NeoNode(Workspace workspace, Workspace.NodeCanvas nodeCanvas, Node node, Point2D offset, PBasicInputEventHandler canvasInputListener, PLayer nodeLayer) {
      super();
      this.workspace = workspace;
      this.nodeCanvas = nodeCanvas;

      delegate = new PText(getNodeText(nodeCanvas.nodePaintStrategy, node));
      addChild(delegate);

      addAttribute("id", node.getId());
      addAttribute("node", node);

      for (org.neo4j.graphdb.Label label : node.getLabels()) {
         final Node colorNode = workspace.app.model.graph().findNode(AppMotif.Entities._Color, "label", label.name());
         if (colorNode == null) continue;
         final String color = getString(colorNode, AppMotif.Properties._color.name());
         defaultNodeColor = Color.decode(color);
         break;
      }
      if (defaultNodeColor == null) defaultNodeColor = Color.BLACK;

      setOffset(offset == null ? (node.hasProperty(AppMotif.Properties.x.name()) ? new Point2D.Double(getDouble(node, AppMotif.Properties.x.name()), getDouble(node, AppMotif.Properties.y.name())) : nodeCanvas.newRandomPosition()) : offset);

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
            workspace.app.events.firePropertyChange(NODE_HIGHLIGHTED, NeoNode.this);
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
            workspace.app.events.firePropertyChange(NODES_SELECTED, nodeCanvas.getSelectedNodes());
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
                  SwingUtilities.invokeLater(() -> workspace.app.events.firePropertyChange(NODES_CLOSED, Collections.singleton(NeoNode.this)));
                  break;


               case KeyEvent.VK_R:
                  SwingUtilities.invokeLater(() -> {

                     final Set<NeoNode> nodesToClose = new LinkedHashSet<>();
                     for (Object o : nodeLayer.getAllNodes()) {
                        if (o instanceof NeoNode && !((NeoNode) o).isSelected() && !NeoNode.this.equals(o))
                           nodesToClose.add((NeoNode) o);
                     }
                     workspace.app.events.firePropertyChange(NODES_CLOSED, nodesToClose);
                  });
                  break;

               case KeyEvent.VK_E:

                  if (event.isControlDown()) {
                     SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {

                           final Map<String, Set<AppEvents.NodeLoadEvent>> nodesByType = new TreeMap<>();
                           outgoing(node).forEach(relationship -> {
                              final Set<AppEvents.NodeLoadEvent> eventSet = nodesByType.computeIfAbsent(relationship.getType().name(), k -> new LinkedHashSet<>());
                              eventSet.add(new AppEvents.NodeLoadEvent(other(node, relationship), null));
                           });

                           if (nodesByType.size() == 1) {

                              for (Set<AppEvents.NodeLoadEvent> nodeLoadEvents : nodesByType.values())
                                 workspace.app.events.firePropertyChange(NODE_LOAD, nodeLoadEvents);

                           } else {
                              final JPopupMenu pop = new JPopupMenu();
                              for (Map.Entry<String, Set<NodeLoadEvent>> entry : nodesByType.entrySet()) {
                                 pop.add(new App.TransactionAction(entry.getKey(), workspace.app) {
                                    @Override
                                    protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                                       workspace.app.events.firePropertyChange(NODE_LOAD, entry.getValue());
                                    }
                                 });
                              }
                              pop.add(new App.TransactionAction("All", workspace.app) {
                                 @Override
                                 protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                                    for (Set<NodeLoadEvent> nodeLoadEvents : nodesByType.values()) {
                                       workspace.app.events.firePropertyChange(NODE_LOAD, nodeLoadEvents);
                                    }
                                 }
                              });

                              final Point2D position = workspace.app.getMousePosition();
                              pop.show(workspace.app, (int) position.getX(), (int) position.getY());
                           }
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showException(nodeCanvas, throwable);
                        }
                     }));

                  } else {

                     SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           final Set<NeoNode> nodes = new LinkedHashSet<>();
                           outgoing(node).forEach(relationship -> {
                              if (!workspace.layerRelations.containsKey(relationship.getId())) return;
                              final NeoNode target = (NeoNode) workspace.layerRelations.get(relationship.getId()).path.getAttribute("target");
                              target.select();
                              nodes.add(target);
                           });
                           workspace.app.events.firePropertyChange(NODES_SELECTED, nodes);
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showException(nodeCanvas, throwable);
                        }
                     }));
                  }
                  break;

               case KeyEvent.VK_D:

                  if (!event.isControlDown()) {

                     SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           final Set<NeoNode> nodes = new LinkedHashSet<>();
                           incoming(node).forEach(relationship -> {
                              if (!workspace.layerRelations.containsKey(relationship.getId())) return;
                              final NeoNode source = (NeoNode) workspace.layerRelations.get(relationship.getId()).path.getAttribute("source");
                              source.select();
                              nodes.add(source);
                           });
                           workspace.app.events.firePropertyChange(NODES_SELECTED, nodes);
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showException(nodeCanvas, throwable);
                        }
                     }));

                  } else {

                     SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           final Set<NodeLoadEvent> nodes = new LinkedHashSet<>();
                           incoming(node).forEach(relationship -> {
                              if (relationship.getType().name().equals(AppMotif.Relations._LAYOUT_MEMBER.name()))
                                 return;
                              nodes.add(new NodeLoadEvent(other(node, relationship), null));
                           });
                           workspace.app.events.firePropertyChange(NODE_LOAD, nodes);
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showException(nodeCanvas, throwable);
                        }
                     }));
                  }

                  break;

               case KeyEvent.VK_DELETE:

                  if (!event.isControlDown()) {

                     SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           if (SwingUtil.showConfirmDialog(workspace.app, "Delete " + getNameAndLabelsFrom(node) + " ?")) {
                              workspace.app.model.deleteNodes(Collections.singleton(node));
                           }
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showException(nodeCanvas, throwable);
                        }
                     }));
                  }

                  break;
            }
         }

         private void layoutTree(Configuration<NeoNode> configuration, boolean outgoing) {

            final Map<Long, NeoNode> nodesAndIds = new LinkedHashMap<>();
            for (NeoNode visibleNode : nodeCanvas.getAllNodes())
               nodesAndIds.put(visibleNode.id(), visibleNode);

            final Map<Long, NeoNode> parentsMap = new LinkedHashMap<>();
            final Map<Long, java.util.List<NeoNode>> childrensMap = new LinkedHashMap<>();

            workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
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
                     public java.util.List<NeoNode> getChildrenList(NeoNode neoNode) {
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
                  SwingUtil.showExceptionNoStack(workspace.app, throwable);
               }
            });
         }
      };

      nodeEventListener.getEventFilter().setMarksAcceptedEventsAsHandled(true);
      addInputEventListener(nodeEventListener);
   }

   public void setPaintStrategy(AppMotif.NodePaintStrategy nodePaintStrategy) {
      delegate.setText(getNodeText(nodePaintStrategy, getNode()));
   }

   private void onRightClick(PInputEvent event) {
      SwingUtilities.invokeLater(() -> workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            workspace.app.getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            final JPopupMenu pop = new JPopupMenu();

            final Set<NeoNode> selectedNodes = new LinkedHashSet<>();
            for (Object o : nodeCanvas.nodeLayer.getAllNodes())
               if (o instanceof NeoNode && ((NeoNode) o).isSelected() && !NeoNode.this.equals(o))
                  selectedNodes.add((NeoNode) o);

            // specialised node-types:
            for (Plugin plugin : workspace.app.plugins)
               plugin.handleNodeRightClick(pop, NeoNode.this, selectedNodes);

            // Basic graph-operations:
            pop.add(new JSeparator());
            final JMenu relationsMenu = new JMenu("Relations");
            final JMenu showAllRelationMenu = new JMenu("Show all ");
            final JMenu closeAll = new JMenu("Close all ");
            final JMenu selectAll = new JMenu("Select all ");
            final Set<String> relations = new TreeSet<>();
            outgoing(getNode()).forEach(relationship -> relations.add(relationship.getType().name()));

            for (String relation : relations) {
               showAllRelationMenu.add(new App.TransactionAction(relation, workspace.app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     final Set<NodeLoadEvent> nodes = new LinkedHashSet<>();
                     outgoing(getNode(), RelationshipType.withName(relation)).forEach(relationship -> nodes.add(new NodeLoadEvent(other(getNode(), relationship))));
                     workspace.app.events.firePropertyChange(NODE_LOAD, nodes);
                  }
               });

               closeAll.add(new App.TransactionAction(relation, workspace.app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     final Set<NeoNode> neoNodes = new LinkedHashSet<>();
                     outgoing(getNode(), RelationshipType.withName(relation)).forEach(relationship -> {
                        if (!workspace.app.workspace.layerNodes.containsKey(relationship.getEndNode().getId())) return;
                        neoNodes.add(workspace.app.workspace.layerNodes.get(relationship.getEndNode().getId()));
                     });

                     workspace.app.events.firePropertyChange(NODES_CLOSED, neoNodes);
                  }
               });

               selectAll.add(new App.TransactionAction(relation, workspace.app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     final Set<NeoNode> neoNodes = new LinkedHashSet<>();
                     outgoing(getNode(), RelationshipType.withName(relation)).forEach(relationship -> {
                        if (!workspace.app.workspace.layerNodes.containsKey(relationship.getEndNode().getId())) return;
                        final NeoNode node = workspace.app.workspace.layerNodes.get(relationship.getEndNode().getId());
                        node.select();
                        neoNodes.add(node);
                     });

                     workspace.app.events.firePropertyChange(NODES_SELECTED, neoNodes);
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
               pop.add(new App.TransactionAction("Add relationship", workspace.app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final Set<String> relationships = new LinkedHashSet<>();
                     workspace.app.model.graph().getAllRelationshipTypesInUse().forEach(relationshipType -> relationships.add(relationshipType.name()));
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

                     SwingUtil.showDialog(editor, workspace.app, "Add relationships", new SwingUtil.ConfirmAction() {
                        @Override
                        public void verifyAndCommit() throws Exception {
                           final String selected = (String) cboRelationships.getSelectedItem();

                           workspace.app.model.graph().doInTransaction(new NeoModel.Committer() {
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
                                 SwingUtil.showExceptionNoStack(workspace.app, throwable);
                              }
                           });
                        }
                     });
                  }
               });
            }
            pop.add(new App.TransactionAction("Set Node-property", workspace.app) {

               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String newProperty = SwingUtil.showInputDialog("[Property] [value]", nodeCanvas);
                  if (newProperty == null || newProperty.length() == 0) return;

                  final String property = newProperty.substring(0, newProperty.indexOf(" "));
                  final String value = newProperty.substring(newProperty.indexOf(" ") + 1);
                  getNode().setProperty(property, value);
                  workspace.app.events.firePropertyChange(NODE_CHANGED + getNode().getId(), property, value);
               }
            });
            pop.add(new App.TransactionAction("Select all " + getNameAndLabelsFrom(getNode()), workspace.app) {

               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  final String id = getNameAndLabelsFrom(getNode());
                  final Set<NeoNode> nodes = new LinkedHashSet<>();
                  for (NeoNode neoNode : nodeCanvas.getAllNodes()) {
                     if (!id.equals(getNameAndLabelsFrom(neoNode.getNode()))) continue;
                     neoNode.select();
                     nodes.add(neoNode);
                  }
                  workspace.app.events.firePropertyChange(NODES_SELECTED, nodes);

               }
            });
            pop.add(new AbstractAction("Retain") {
               @Override
               public void actionPerformed(ActionEvent e) {
                  SwingUtilities.invokeLater(() -> {
                     final Set<NeoNode> nodesToClose = new LinkedHashSet<>();
                     for (Object o : nodeCanvas.nodeLayer.getAllNodes()) {
                        if (o instanceof NeoNode && !((NeoNode) o).isSelected() && !NeoNode.this.equals(o))
                           nodesToClose.add((NeoNode) o);
                     }
                     workspace.app.events.firePropertyChange(NODES_CLOSED, nodesToClose);
                  });
               }
            });
            pop.add(new App.TransactionAction("Close", workspace.app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  workspace.app.events.firePropertyChange(NODES_CLOSED, Collections.singleton(NeoNode.this));
               }
            });
            pop.add(new App.TransactionAction("Delete", workspace.app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  if (SwingUtil.showConfirmDialog(workspace.app, "Delete " + getNameAndLabelsFrom(getNode()) + " ?")) {
                     workspace.app.model.deleteNodes(Collections.singleton(getNode()));

                  }
               }
            });
            pop.add(new App.TransactionAction("Export Branch", workspace.app) {

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
                  for (org.neo4j.graphdb.Label label : node.getLabels()) createNodeST.addLabelsValue(label);

                  for (String key : node.getPropertyKeys())
                     createNodeST.addPropertiesValue(neoGroup.newstringProperty().setName(key).setValue(node.getProperty(key)));
                  export.addNodesValue(createNodeST.toString());

                  final Set<Node> unvisitedNodes = new LinkedHashSet<>();
                  for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) {
                     final Node endNode = relationship.getEndNode();
                     if (!workspace.layerNodes.containsKey(endNode.getId())) continue;
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

            pop.addSeparator();
            pop.add(new App.TransactionAction("Show roots", workspace.app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Node node = getNode();

                  final Set<Node> visited = new LinkedHashSet<>();
                  final Set<Node> parents = new LinkedHashSet<>();
                  visitIncoming(node, visited, parents);

                  fireNodesLoaded(parents.toArray(new Node[parents.size()]));
               }

               private void fireNodesLoaded(Node... nodes) {
                  final Set<AppEvents.NodeLoadEvent> nodeEvents = new LinkedHashSet<>();
                  for (Node node : nodes) {
                     nodeEvents.add(new AppEvents.NodeLoadEvent(node, false));
                  }
                  workspace.app.events.firePropertyChange(NODE_LOAD, nodeEvents);
               }

               private void visitIncoming(Node node, Set<Node> visited, Set<Node> parents) {

                  visited.add(node);

                  final AtomicBoolean hasParents = new AtomicBoolean(false);
                  incoming(node).forEach(relationship -> {
                     final Node parent = other(node, relationship);
                     hasParents.set(true);
                     if (visited.contains(parent)) return;
                     visitIncoming(parent, visited, parents);
                  });

//                  if (!hasParents.get()) {
                     if (hasLabel(node, AppMotif.Entities._Layout)) return;
                     parents.add(node);
//                  }
               }
            });

            workspace.app.getRootPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            pop.show(nodeCanvas, (int) event.getCanvasPosition().getX(), (int) event.getCanvasPosition().getY());
         }

         @Override
         public void exception(Throwable throwable) {
            SwingUtil.showException(nodeCanvas, throwable);
         }
      }));
   }

   public Long id() {
      return Long.valueOf(getAttribute("id").toString());
   }

   public void setColor(Color color) {
      defaultNodeColor = color;
      setTextPaint(color);
   }

   private void setTextPaint(Color color) {
      delegate.setTextPaint(color);
   }

   public void highlight() {
      addAttribute("highlighted", Boolean.TRUE);
      setTextPaint(nodeCanvas.highlightedNodeColor);
   }

   public void unhighlight() {
      addAttribute("highlighted", Boolean.FALSE);
      setTextPaint(getBooleanAttribute("selected", false) ? nodeCanvas.selectedNodeColor : defaultNodeColor);
   }

   private void toggleSelect() {
      addAttribute("selected", !getBooleanAttribute("selected", false));
      setTextPaint(getBooleanAttribute("selected", false) ? nodeCanvas.selectedNodeColor : defaultNodeColor);
   }

   public void select() {
      addAttribute("selected", Boolean.TRUE);
      setTextPaint(nodeCanvas.selectedNodeColor);
   }

   public void unselect() {
      addAttribute("selected", Boolean.FALSE);
      setTextPaint(defaultNodeColor);
   }

   public boolean isSelected() {
      return getBooleanAttribute("selected", false);
   }

   public Node getNode() {
      return (Node) getAttribute("node");
   }

   @Override
   public boolean equals(Object obj) {
      return ((obj instanceof NeoNode)) && ((NeoNode) obj).getAttribute("id").equals(getAttribute("id"));
   }

   @Override
   public int hashCode() {
      return getAttribute("id").hashCode();
   }

   public static String getNodeText(AppMotif.NodePaintStrategy nodePaintStrategy, Node node) {
      switch (nodePaintStrategy) {
         case showNameAndLabels:
            return getNameAndLabelsFrom(node);
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
                  if (StringTemplatePlugin.isSTTemplate(instanceNode)) {
                     return StringTemplatePlugin.renderStatement(node, instanceNode);

                  }
               }
            }
      }

      return "?";
   }
}
