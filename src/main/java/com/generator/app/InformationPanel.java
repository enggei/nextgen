package com.generator.app;

import com.generator.editors.NeoModel;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.event.LabelEntry;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.editors.BaseDomainVisitor.*;

/**
 * Created 18.07.17.
 */
final class InformationPanel extends JPanel {

   private final App app;
   private final JTree informationTree;

   InformationPanel(App app) {
      super(new BorderLayout());
      this.app = app;

      informationTree = new JTree(new InformationNode("")) {{

         setRootVisible(true);

         setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
               final InformationNode nodeEntry = (InformationNode) value;
               return super.getTreeCellRendererComponent(tree, nodeEntry.label(), sel, expanded, leaf, row, hasFocus);
            }
         });

         addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               final TreePath selectionPath = ((JTree) e.getSource()).getSelectionPath();
               if (selectionPath == null) return;
               final InformationNode selectedNode = (InformationNode) selectionPath.getLastPathComponent();
               if (selectedNode == null) return;
               if (SwingUtilities.isRightMouseButton(e)) {
                  final JPopupMenu pop = new JPopupMenu();
                  selectedNode.addRightClickActions(pop, selectionPath, ((JTree) e.getSource()));
                  if (pop.getComponentCount() == 0) return;
                  SwingUtil.showPopup(pop, ((JTree) e.getSource()), e);
               }
            }
         });
      }};
      add(new JScrollPane(informationTree), BorderLayout.CENTER);

      app.events.addGraphNewListener(evt -> loadGraph(informationTree, (NeoModel) evt.getNewValue()));

      app.events.addNodesDeletedListener(evt -> {
         final Set<Long> nodesDeleted = (Set<Long>) evt.getNewValue();
         final DefaultTreeModel model = (DefaultTreeModel) (informationTree.getModel());
         final InformationNode root = (InformationNode) model.getRoot();
         SwingUtilities.invokeLater(() -> root.handleNodesDeleted(nodesDeleted));
      });
   }

   private void loadGraph(JTree informationTree, NeoModel graph) {
      app.model.graph().doInTransaction(new NeoModel.Committer() {

         @Override
         public void doAction(Transaction tx) throws Throwable {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            final InformationNode root = new DatabaseNode(graph);

            final InformationNode labels = new InformationNode("Labels");
            root.add(labels);
            app.model.graph().getGraphDb().getAllLabelsInUse().forEach(label -> labels.add(new LabelNode(label)));

            app.events.addLabelsAssignedListener(new AppEvents.EventsTransactionHandler<Set<LabelEntry>>(getClass(), app, app.model) {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  for (LabelEntry labelEntry : getValue()) {
                     final AtomicBoolean found = new AtomicBoolean(false);
                     for (int i = 0; i < labels.getChildCount(); i++) {
                        if (!(labels.getChildAt(i) instanceof InformationNode)) continue;
                        final InformationNode informationNode = (InformationNode) labels.getChildAt(i);
                        if (informationNode.label.equals(labelEntry.label().name())) {
                           found.set(true);
                           break;
                        }
                     }

                     if (!found.get()) labels.addChildNode(new LabelNode(labelEntry.label()), labels, informationTree);
                  }
               }
            });

            final InformationNode relationships = new InformationNode("Relationships");
            root.add(relationships);
            app.model.graph().getGraphDb().getAllRelationshipTypesInUse().forEach(relationshipType -> relationships.add(new RelationshipTypeNode(relationshipType)));

            final PropertyNode propertyNodes = new PropertyNode("Properties");
            root.add(propertyNodes);
            app.model.graph().getGraphDb().getAllPropertyKeys().forEach(propertyKey -> propertyNodes.add(new PropertyNode(propertyKey)));

            final InformationNode nodeIndices = new InformationNode("Node Indices");
            root.add(nodeIndices);
            for (String indexName : app.model.graph().getGraphDb().index().nodeIndexNames())
               nodeIndices.add(new NodeIndexNode(indexName));

            final InformationNode relationIndices = new InformationNode("Relationships Indices");
            root.add(relationIndices);
            for (String indexName : app.model.graph().getGraphDb().index().relationshipIndexNames())
               relationIndices.add(new RelationshipIndexNode(indexName));

            final InformationNode layouts = new InformationNode("Layouts");
            root.add(layouts);

            app.events.addNodesAddedListener(new AppEvents.EventsTransactionHandler<Set<Node>>(getClass(), app, app.model) {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  for (Node node : getValue()) {
                     if (hasLabel(node, AppMotif.Entities._Layout))
                        layouts.addChildNode(new LayoutNode(node), layouts, informationTree);
                  }
               }
            });

            app.model.graph().findNodes(AppMotif.Entities._Layout).forEachRemaining(node -> layouts.add(new LayoutNode(node)));

            final InformationNode domains = new InformationNode("Domains") {
               @Override
               void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
                  pop.add(new App.TransactionAction("New", app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        final String name = SwingUtil.showInputDialog("Domain name", InformationPanel.this);
                        if (name == null || name.length() == 0) return;

                        final Node existing = app.model.graph().getGraphDb().findNode(TemplateMotif.Entities._Domain, AppMotif.Properties.name.name(), name);
                        if (existing != null) {
                           SwingUtil.showMessage(name + " already exists", InformationPanel.this);
                           return;
                        }

                        final Node newNode = app.model.graph().newNode(TemplateMotif.Entities._Domain.name(), AppMotif.Properties.name.name(), name);
                        addChildNode(new DomainNode(newNode), selectionPath, source);
                        app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(newNode));
                     }
                  });
               }
            };
            root.add(domains);
            app.model.graph().findNodes(TemplateMotif.Entities._Domain).forEachRemaining(node -> domains.add(new DomainNode(node)));

            final InformationNode templates = new InformationNode("Templates") {
               @Override
               void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
                  pop.add(new App.TransactionAction("New TemplateGroup", app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        final String name = SwingUtil.showInputDialog("Group name", InformationPanel.this);
                        if (name == null || name.length() == 0) return;

                        final Node existing = app.model.graph().getGraphDb().findNode(TemplateMotif.Entities._STGroup, AppMotif.Properties.name.name(), name);
                        if (existing != null) {
                           SwingUtil.showMessage(name + " already exists", InformationPanel.this);
                           return;
                        }

                        final Node newNode = app.model.graph().newNode(TemplateMotif.Entities._STGroup.name(), AppMotif.Properties.name.name(), name);
                        addChildNode(new STTGemplateNode(newNode), selectionPath, source);
                        app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(newNode));
                     }
                  });
               }
            };
            root.add(templates);

            app.model.graph().findNodes(TemplateMotif.Entities._STGroup).forEachRemaining(node -> templates.add(new STTGemplateNode(node)));

            final InformationNode directories = new InformationNode("Directories") {
               @Override
               void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
                  pop.add(new App.TransactionAction("Add Directory", app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                        final File dir = SwingUtil.showOpenDir(app, app.model.getCurrentDatabaseDir());
                        if (dir == null) return;

                        final Node newNode = app.model.graph().newNode(ProjectMotif.Entities._Directory.name(), AppMotif.Properties.name.name(), dir.getName(), ProjectMotif.Properties._path.name(), dir.getPath());
                        addChildNode(new DirectoryNode(newNode), selectionPath, source);
                        app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(newNode));
                     }
                  });
               }
            };
            app.model.graph().findNodes(ProjectMotif.Entities._Directory).forEachRemaining(node -> directories.add(new DirectoryNode(node)));

            app.events.addNodesAddedListener(new AppEvents.EventsTransactionHandler<Set<Node>>(getClass(), app, app.model) {
               @Override
               public void doAction(Transaction tx) throws Throwable {
                  for (Node node : getValue()) {
                     if (hasLabel(node, ProjectMotif.Entities._Directory))
                        layouts.addChildNode(new DirectoryNode(node), layouts, informationTree);
                  }
               }
            });

            root.add(directories);

            informationTree.setModel(new DefaultTreeModel(root));
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
         }

         @Override
         public void exception(Throwable throwable) {
            SwingUtil.showException(InformationPanel.this, throwable);
         }
      });
   }

   private class InformationNode extends DefaultMutableTreeNode {

      protected String label = "";

      InformationNode(String label) {
         this.label = label;
      }

      public String label() {
         return label;
      }

      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {

      }

      void addChildNode(InformationNode treeNode, TreePath selectionPath, JTree source) {
         final MutableTreeNode currentNode = (MutableTreeNode) selectionPath.getLastPathComponent();
         final DefaultTreeModel dm = (DefaultTreeModel) source.getModel();
         dm.insertNodeInto(treeNode, currentNode, currentNode.getChildCount());
         source.expandPath(new TreePath(dm.getPathToRoot(treeNode.getParent())));
      }

      void addChildNode(InformationNode treeNode, MutableTreeNode currentNode, JTree source) {
         final DefaultTreeModel dm = (DefaultTreeModel) source.getModel();
         dm.insertNodeInto(treeNode, currentNode, currentNode.getChildCount());
         source.expandPath(new TreePath(dm.getPathToRoot(treeNode.getParent())));
      }

      void handleNodesDeleted(Set<Long> nodesDeleted) {
         if (getUserObject() instanceof Node && nodesDeleted.contains(((Node) getUserObject()).getId())) {
            final DefaultTreeModel model = (DefaultTreeModel) (informationTree.getModel());
            model.removeNodeFromParent(InformationNode.this);
         }

         for (int i = 0; i < getChildCount(); i++) {
            if (!(getChildAt(i) instanceof InformationNode)) continue;
            ((InformationNode) getChildAt(i)).handleNodesDeleted(nodesDeleted);
         }
      }
   }

   private final class DatabaseNode extends InformationNode {

      DatabaseNode(NeoModel graph) {
         super("Database");
         setUserObject(graph);
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Get all disconnected nodes", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
               app.model.graph().getGraphDb().getAllLabelsInUse().forEach(label -> app.model.graph().findNodes(label).forEachRemaining(node -> {
                  if (node.getRelationships().iterator().hasNext()) return;
                  nodes.add(new AppEvents.NodeLoadEvent(node));
               }));
               app.events.fireNodeLoad(nodes);
            }
         });
      }
   }

   private final class LabelNode extends InformationNode {
      LabelNode(org.neo4j.graphdb.Label label) {
         super(label.name());
         setUserObject(label);
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Show all", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {
               final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
               app.model.graph().findNodes(((org.neo4j.graphdb.Label) getUserObject())).forEachRemaining(node -> nodes.add(new AppEvents.NodeLoadEvent(node)));
               app.events.fireNodeLoad(nodes);
            }
         });

         pop.add(new App.TransactionAction("New", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {
               app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(app.model.graph().newNode((org.neo4j.graphdb.Label) getUserObject())));
            }
         });

         pop.add(new App.TransactionAction("Set color", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {
               Node colorNode = app.model.graph().getGraphDb().findNode(AppMotif.Entities._Color, "label", ((org.neo4j.graphdb.Label) getUserObject()).name());
               if (colorNode == null)
                  colorNode = app.model.graph().newNode(AppMotif.Entities._Color, "label", ((org.neo4j.graphdb.Label) getUserObject()).name(), AppMotif.Properties._color.name(), String.format("#%02x%02x%02x", Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue()));
               final String color = SwingUtil.showInputDialog("Color", InformationPanel.this, getString(colorNode, AppMotif.Properties._color.name()));
               if (color == null) return;
               colorNode.setProperty(AppMotif.Properties._color.name(), color);
               // old, just run to clean up
               app.model.graph().findNodes(((org.neo4j.graphdb.Label) getUserObject())).forEachRemaining(node -> node.removeProperty(AppMotif.Properties._color.name()));
               app.events.fireNodeColorChanged(((org.neo4j.graphdb.Label) getUserObject()).name(), Color.decode(color));
            }
         });
      }
   }

   private class RelationshipTypeNode extends InformationNode {
      RelationshipTypeNode(RelationshipType relationshipType) {
         super(relationshipType.name());
         setUserObject(relationshipType);
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Show all", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {
               final String existingType = ((RelationshipType) getUserObject()).name();
               app.model.graph().getGraphDb().getAllRelationships().forEach(relationship -> {
                  if (!relationship.getType().name().equals(existingType)) return;
                  app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(relationship.getStartNode()));
                  app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(relationship.getEndNode()));
               });
            }
         });

         pop.add(new App.TransactionAction("Change Type", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final String existingType = ((RelationshipType) getUserObject()).name();

               final Set<String> types = new TreeSet<>();
               app.model.graph().getGraphDb().getAllRelationshipTypes().forEach(relationshipType -> types.add(relationshipType.name()));
               final String newType = SwingUtil.showSelectDialog(InformationPanel.this, types, existingType);
               if (newType == null || newType.equals(existingType)) return;

               app.model.graph().getGraphDb().getAllRelationships().forEach(relationship -> {
                  if (!relationship.getType().name().equals(existingType)) return;

                  final Relationship newRelationship = relationship.getStartNode().createRelationshipTo(relationship.getEndNode(), RelationshipType.withName(newType));
                  for (String key : relationship.getPropertyKeys())
                     newRelationship.setProperty(key, relationship.getProperty(key));
                  relationship.delete();
               });
            }
         });
      }
   }

   private final class PropertyNode extends InformationNode {
      PropertyNode(String name) {
         super(name);
         setUserObject(name);
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Show all", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {
               final String property = ((String) getUserObject());
               final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
               for (Node node : app.model.graph().findNodesWithProperty(property))
                  nodes.add(new AppEvents.NodeLoadEvent(node));
               app.events.fireNodeLoad(nodes);
            }
         });

         pop.add(new App.TransactionAction("Change name", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final String existingProperty = ((String) getUserObject());

               final String newProperty = SwingUtil.showInputDialog("New property name", InformationPanel.this, existingProperty);
               if (newProperty == null || existingProperty.equals(newProperty)) return;

               for (Node node : app.model.graph().findNodesWithProperty(existingProperty))
                  node.setProperty(newProperty, node.removeProperty(existingProperty));
            }
         });
      }
   }

   private final class NodeIndexNode extends InformationNode {
      NodeIndexNode(String name) {
         super(name);
         setUserObject(name);
      }
   }

   private final class RelationshipIndexNode extends InformationNode {
      RelationshipIndexNode(String name) {
         super(name);
         setUserObject(name);
      }
   }

   private final class LayoutNode extends InformationNode {
      LayoutNode(Node node) {
         super(getString(node, AppMotif.Properties.name.name()));
         setUserObject(node);
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Show", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {
               SwingUtilities.invokeLater(() -> {
                  source.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                  app.model.graph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx) throws Throwable {
                        app.events.fireNodeLoad(AppMotif.getLayoutNodes((Node) getUserObject()));
                     }

                     @Override
                     public void exception(Throwable throwable) {
                        SwingUtil.showException(source, throwable);
                     }
                  });
                  source.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
               });
            }
         });

         pop.add(new App.TransactionAction("Delete ", app) {

            private final AtomicBoolean deleted = new AtomicBoolean(false);

            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {
               if (SwingUtil.showConfirmDialog(app, "Delete layout ?")) {
                  AppMotif.deleteLayout((Node) getUserObject());

                  deleted.set(true);
               }
            }

            @Override
            protected void onSuccess(ActionEvent e) {
               if (!deleted.get()) return;
               final DefaultTreeModel model = (DefaultTreeModel) (informationTree.getModel());
               model.removeNodeFromParent(LayoutNode.this);
               informationTree.setSelectionPath(selectionPath.getParentPath());
            }
         });
      }
   }

   private final class DomainNode extends InformationNode {
      DomainNode(Node node) {
         super(getString(node, AppMotif.Properties.name.name()));
         setUserObject(node);
         outgoing(node, TemplateMotif.Relations.ENTITY).forEach(relationship -> {
            final Node entityNode = other(node, relationship);
            final String entityName = getString(entityNode, AppMotif.Properties.name.name());
            add(new InformationNode(entityName) {
               @Override
               void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
                  pop.add(new App.TransactionAction("Show all " + entityName, app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) {
                        final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
                        app.model.graph().findNodes(org.neo4j.graphdb.Label.label(entityName)).forEachRemaining(instanceNode -> nodes.add(new AppEvents.NodeLoadEvent(instanceNode)));
                        app.events.fireNodeLoad(nodes);
                     }
                  });

                  pop.add(new App.TransactionAction("Delete", app) {

                     private final AtomicBoolean deleted = new AtomicBoolean(false);

                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) {
                        if (SwingUtil.showConfirmDialog(app, "Delete '" + label + "' ?")) {
                           entityNode.delete();
                           deleted.set(true);
                        }
                     }

                     @Override
                     protected void onSuccess(ActionEvent e) {
                        if (!deleted.get()) return;
                        final DefaultTreeModel model = (DefaultTreeModel) (informationTree.getModel());
                        model.removeNodeFromParent(DomainNode.this);
                        informationTree.setSelectionPath(selectionPath.getParentPath());
                     }
                  });
               }
            });
         });
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Show", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               app.events.fireNodeLoad(new AppEvents.NodeLoadEvent((Node) getUserObject()));
            }
         });

         pop.add(new App.TransactionAction("Add Entity", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Entity name", app);
               if (name == null || name.length() == 0) return;

               final Node node = (Node) getUserObject();

               final AtomicBoolean exists = new AtomicBoolean(false);
               outgoing(node, TemplateMotif.Relations.ENTITY).forEach(relationship -> {
                  if (name.equalsIgnoreCase(getOtherProperty(node, relationship, AppMotif.Properties.name.name()).toString()))
                     exists.set(true);
               });
               if (exists.get()) {
                  SwingUtil.showMessage(name + " already exists for domain", app);
                  return;
               }

               final Node newNode = app.model.graph().newNode(TemplateMotif.Entities._Entity, AppMotif.Properties.name.name(), name);
               node.createRelationshipTo(newNode, TemplateMotif.Relations.ENTITY);
               app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(newNode));
            }
         });

         pop.add(new App.TransactionAction("Delete", app) {

            private final AtomicBoolean deleted = new AtomicBoolean(false);

            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {
               if (SwingUtil.showConfirmDialog(app, "Delete domain '" + label + "' ?")) {
                  final Node node = (Node) getUserObject();
                  node.delete();
                  deleted.set(true);
               }
            }

            @Override
            protected void onSuccess(ActionEvent e) {
               if (!deleted.get()) return;
               final DefaultTreeModel model = (DefaultTreeModel) (informationTree.getModel());
               model.removeNodeFromParent(DomainNode.this);
               informationTree.setSelectionPath(selectionPath.getParentPath());
            }
         });
      }
   }

   private final class STTGemplateNode extends InformationNode {

      STTGemplateNode(Node node) {
         super(getString(node, AppMotif.Properties.name.name()));
         setUserObject(node);
         outgoing(node, TemplateMotif.Relations.STTEMPLATE).forEach(relationship -> add(new STTemplateNode(other(node, relationship))));
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Show Group", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               app.events.fireNodeLoad(new AppEvents.NodeLoadEvent((Node) getUserObject()));
            }
         });
         pop.add(new App.TransactionAction("Add template", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Template name", InformationPanel.this);
               if (name == null || name.length() == 0) return;

               final Node node = (Node) getUserObject();
               final AtomicBoolean exists = new AtomicBoolean(false);
               outgoing(node, TemplateMotif.Relations.ENTITY).forEach(relationship -> {
                  if (name.equalsIgnoreCase(getOtherProperty(node, relationship, AppMotif.Properties.name.name()).toString()))
                     exists.set(true);
               });
               if (exists.get()) {
                  SwingUtil.showMessage(name + " already exists for group ", InformationPanel.this);
                  return;
               }

               final Node newNode = app.model.graph().newNode(TemplateMotif.Entities._STTemplate, AppMotif.Properties.name.name(), name);
               node.createRelationshipTo(newNode, TemplateMotif.Relations.STTEMPLATE);
               addChildNode(new STTemplateNode(newNode), selectionPath, source);
               app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(newNode));
            }
         });
      }
   }

   private final class STTemplateNode extends InformationNode {

      STTemplateNode(Node node) {
         super(getString(node, AppMotif.Properties.name.name()));
         setUserObject(node);
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Preview template", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               SwingUtil.showTextResult("Template", get((Node) getUserObject(), TemplateMotif.Properties._text.name(), ""), app);
            }
         });
         pop.add(new App.TransactionAction("Show template", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               app.events.fireNodeLoad(new AppEvents.NodeLoadEvent((Node) getUserObject()));
            }
         });
         pop.add(new App.TransactionAction("New Instance", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final String name = SwingUtil.showInputDialog("Name", InformationPanel.this);
               if (name == null || name.length() == 0) return;
               app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(TemplateMotif.newTemplateInstance(app, (Node) getUserObject(), name)));
            }
         });
         pop.add(new App.TransactionAction("Show all instances", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               app.events.fireNodeLoad(TemplateMotif.getAllStatementsOfType(app, (Node) getUserObject()));
            }
         });
      }
   }

   private final class DirectoryNode extends InformationNode {
      DirectoryNode(Node node) {
         super(getString(node, AppMotif.Properties.name.name()));
         setUserObject(node);
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Show", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               app.events.fireNodeLoad(new AppEvents.NodeLoadEvent((Node)getUserObject()));
            }
         });
      }
   }
}