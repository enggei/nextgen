package com.generator.app;

import com.generator.neo.NeoModel;
import com.generator.util.ColorBrewerSelector;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.event.LabelEntry;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.app.AppEvents.*;
import static com.generator.util.NeoUtil.*;

/**
 * Created 18.07.17.
 */
final class InformationPanel extends JPanel {

   private final App app;
   private final JTree informationTree;
   private LabelsNode labels;
   private InformationNode layouts;
   private RelationsNode relationships;

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

      app.events.addPropertyChangeListener(GRAPH_NEW, new TransactionalPropertyChangeListener(getClass(), InformationPanel.this, app) {

         @Override
         protected void propertyChange(Object oldValue, Object newValue) {
            loadGraph(informationTree);
         }
      });

      app.events.addPropertyChangeListener(NODES_DELETED, evt -> {
         final Set<Long> nodesDeleted = (Set<Long>) evt.getNewValue();
         final DefaultTreeModel model = (DefaultTreeModel) (informationTree.getModel());
         final InformationNode root = (InformationNode) model.getRoot();
         SwingUtilities.invokeLater(() -> root.handleNodesDeleted(nodesDeleted));
      });

      app.events.addPropertyChangeListener(LABELS_ASSIGNED, new AppEvents.TransactionalPropertyChangeListener<Object, Set<LabelEntry>>(getClass(), app, app) {
         @Override
         protected void propertyChange(Object oldValue, Set<LabelEntry> nodes) {
            for (LabelEntry labelEntry : nodes) {
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

      app.events.addPropertyChangeListener(NODES_ADDED, new AppEvents.TransactionalPropertyChangeListener<Object, Set<Node>>(getClass(), app, app) {
         @Override
         protected void propertyChange(Object oldValue, Set<Node> nodes) {
            for (Node node : nodes) {
               if (hasLabel(node, AppMotif.Entities._Layout))
                  layouts.addChildNode(new LayoutNode(node), layouts, informationTree);
            }
         }
      });

      app.events.addPropertyChangeListener(RELATIONS_ADDED, new AppEvents.TransactionalPropertyChangeListener<Object, Set<Relationship>>(getClass(), app, app) {

         @Override
         protected void propertyChange(Object oldValue, Set<Relationship> relations) {
            for (Relationship relationship : relations) {
               final AtomicBoolean found = new AtomicBoolean(false);
               for (int i = 0; i < relationships.getChildCount(); i++) {
                  if (!(relationships.getChildAt(i) instanceof RelationshipTypeNode)) continue;
                  final RelationshipTypeNode informationNode = (RelationshipTypeNode) relationships.getChildAt(i);
                  if (informationNode.label.equals(relationship.getType().name())) {
                     found.set(true);
                     break;
                  }
               }

               if (!found.get())
                  relationships.addChildNode(new RelationshipTypeNode(relationship.getType()), relationships, informationTree);
            }
         }
      });
   }

   private void loadGraph(JTree informationTree) {
      app.model.graph().doInTransaction(new NeoModel.Committer() {

         @Override
         public void doAction(Transaction tx) throws Throwable {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            final InformationNode root = new DatabaseNode();

            labels = new LabelsNode();
            root.add(labels);
            final Set<String> sorted = new TreeSet<>();
            app.model.graph().getAllLabelsInUse().forEach(label -> sorted.add(label.name()));
            for (String label : sorted) labels.add(new LabelNode(Label.label(label)));

            relationships = new RelationsNode();
            root.add(relationships);
            final Set<String> sortedRelations = new TreeSet<>();
            app.model.graph().getAllRelationshipTypesInUse().forEach(relationshipType -> sortedRelations.add(relationshipType.name()));
            for (String sortedRelation : sortedRelations)
               relationships.add(new RelationshipTypeNode(RelationshipType.withName(sortedRelation)));

            final PropertyNode propertyNodes = new PropertyNode("Properties");
            root.add(propertyNodes);
            app.model.graph().getAllPropertyKeys().forEach(propertyKey -> propertyNodes.add(new PropertyNode(propertyKey)));

            final InformationNode nodeIndices = new InformationNode("Node Indices");
            root.add(nodeIndices);
            for (String indexName : app.model.graph().index().nodeIndexNames())
               nodeIndices.add(new NodeIndexNode(indexName));

            final InformationNode relationIndices = new InformationNode("Relationships Indices");
            root.add(relationIndices);
            for (String indexName : app.model.graph().index().relationshipIndexNames())
               relationIndices.add(new RelationshipIndexNode(indexName));

            layouts = new InformationNode("Layouts");
            root.add(layouts);
            app.model.graph().findNodes(AppMotif.Entities._Layout).forEachRemaining(node -> layouts.add(new LayoutNode(node)));

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

      DatabaseNode() {
         super("Database");
         setUserObject("Database");
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Show all disconnected nodes", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
               app.model.graph().getAllLabelsInUse().forEach(label -> app.model.graph().findNodes(label).forEachRemaining(node -> {
                  if (node.getRelationships().iterator().hasNext()) return;
                  nodes.add(new NodeLoadEvent(node));
               }));
               app.events.firePropertyChange(NODE_LOAD, nodes);
            }
         });

         pop.add(new App.TransactionAction("Show all distinct motifs", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               // todo: move this to neoModel
               final Map<Label, Motif> structureMap = new LinkedHashMap<>();

               app.model.graph().getAllLabelsInUse().forEach(label -> app.model.graph().findNodes(label).forEachRemaining(node -> {
                  final Motif structure = structureMap.computeIfAbsent(label, Motif::new);
                  outgoing(node).forEach(relationship -> {
                     final Node dstNode = other(node, relationship);
                     for (Label dstLabel : dstNode.getLabels()) {
                        structure.dst.add(dstLabel);
                        final Set<RelationshipType> typeSet = structure.relationTypes.computeIfAbsent(dstLabel, k -> new LinkedHashSet<>());
                        typeSet.add(relationship.getType());
                     }
                  });
               }));

               final StringBuilder out = new StringBuilder(structureMap.size() + " unique motifs:\n\n");
               for (Map.Entry<Label, Motif> structureEntry : structureMap.entrySet())
                  out.append(structureEntry.getValue());
               SwingUtil.showTextResult("Structures", out.toString(), app);
            }

            final class Motif {

               private final Label src;
               private final Set<Label> dst = new LinkedHashSet<>();
               private Map<Label, Set<RelationshipType>> relationTypes = new LinkedHashMap<>();

               Motif(Label src) {
                  this.src = src;
               }

               @Override
               public String toString() {
                  final StringBuilder out = new StringBuilder();
                  for (Label dstLabel : dst) {
                     final Set<RelationshipType> types = relationTypes.get(dstLabel);
                     for (RelationshipType type : types) {
                        out.append(src).append(" -> [").append(type).append("] -> ").append(dstLabel).append("\n");
                        out.append("(").append(src).append(")").append("(a)-[r:TYPE1|TYPE2]->(b)").append(dstLabel).append("\n");
                     }
                  }
                  if (dst.isEmpty()) out.append(src);
                  out.append("\n");
                  return out.toString();
               }
            }

         });
      }
   }

   private class LabelsNode extends InformationNode {
      LabelsNode() {
         super("Labels");
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {

         pop.add(new App.TransactionAction("Change Labels", app) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Set<String> existing = new TreeSet<>();
               final Set<String> replacements = new TreeSet<>();
               app.model.graph().getAllLabelsInUse().forEach(label -> {
                  existing.add(label.name());
                  replacements.add(label.name());
               });

               final JComboBox<String> cboExisting = new JComboBox<>(existing.toArray(new String[existing.size()]));
               final JComboBox<String> cboReplacements = new JComboBox<>(replacements.toArray(new String[replacements.size()]));
               final JTextField txtNewLabel = new JTextField();

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref,4dlu,pref,4dlu,pref");
               editor.addLabel("Existing", 1, 1);
               editor.add(cboExisting, 3, 1);
               editor.addLabel("Replacement", 1, 3);
               editor.add(cboReplacements, 3, 3);
               editor.addLabel("New Label", 1, 5);
               editor.add(txtNewLabel, 3, 5);
               editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

               SwingUtil.showDialog(editor, app, "Change Label", new SwingUtil.OnSave() {
                  @Override
                  public void verifyAndSave() throws Exception {

                     final Label toBeReplaced = Label.label((String) cboExisting.getSelectedItem());
                     final Label replacement = Label.label(txtNewLabel.getText().trim().length() == 0 ? (String) cboReplacements.getSelectedItem() : txtNewLabel.getText().trim());
                     if (toBeReplaced.name().equals(replacement.name())) return;

                     app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           final Set<Long> updatedNodes = new LinkedHashSet<>();
                           app.model.graph().findNodes(toBeReplaced).forEachRemaining(node -> {
                              node.removeLabel(toBeReplaced);
                              node.addLabel(replacement);
                              updatedNodes.add(node.getId());
                           });
                           app.events.firePropertyChange(NODE_CHANGED + updatedNodes);
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

   private final class LabelNode extends InformationNode {
      LabelNode(Label label) {
         super(label.name());
         setUserObject(label);
      }

      @Override
      void addRightClickActions(JPopupMenu pop, TreePath selectionPath, JTree source) {
         pop.add(new App.TransactionAction("Show all", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {
               final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
               app.model.graph().findNodes(((Label) getUserObject())).forEachRemaining(node -> nodes.add(new NodeLoadEvent(node)));
               app.events.firePropertyChange(NODE_LOAD, nodes);
            }
         });

         pop.add(new App.TransactionAction("New", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {
               app.events.firePropertyChange(NODE_LOAD, new NodeLoadEvent(app.model.graph().newNode((Label) getUserObject())));
            }
         });

         pop.add(new App.TransactionAction("Change", app) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Set<String> replacements = new TreeSet<>();
               app.model.graph().getAllLabelsInUse().forEach(label -> {
                  replacements.add(label.name());
               });

               final JComboBox<String> cboReplacements = new JComboBox<>(replacements.toArray(new String[replacements.size()]));
               final JTextField txtNewLabel = new JTextField();

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref,4dlu,pref");
               editor.addLabel("Replacement", 1, 1);
               editor.add(cboReplacements, 3, 1);
               editor.addLabel("New Label", 1, 3);
               editor.add(txtNewLabel, 3, 3);
               editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

               SwingUtil.showDialog(editor, app, "Change Label", new SwingUtil.OnSave() {
                  @Override
                  public void verifyAndSave() throws Exception {

                     final Label toBeReplaced = (Label) getUserObject();
                     final Label replacement = Label.label(txtNewLabel.getText().trim().length() == 0 ? (String) cboReplacements.getSelectedItem() : txtNewLabel.getText().trim());

                     app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           final Set<Long> updatedNodes = new LinkedHashSet<>();
                           app.model.graph().findNodes(toBeReplaced).forEachRemaining(node -> {
                              node.removeLabel(toBeReplaced);
                              node.addLabel(replacement);
                              updatedNodes.add(node.getId());
                           });

                           for (Long node : updatedNodes)
                              app.events.firePropertyChange(NODE_CHANGED + node, null, node);
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

         pop.add(new App.TransactionAction("Set color", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {

               final ColorBrewerSelector editor = new ColorBrewerSelector();

               SwingUtil.showDialog(editor, app, "Select color", new SwingUtil.OnSave() {
                  @Override
                  public void verifyAndSave() throws Exception {
                     final Color color = editor.getSelectedColor();
                     if (color == null) return;

                     app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           Node colorNode = app.model.graph().findNode(AppMotif.Entities._Color, "label", ((Label) getUserObject()).name());
                           if (colorNode == null)
                              colorNode = app.model.graph().newNode(AppMotif.Entities._Color, "label", ((Label) getUserObject()).name(), AppMotif.Properties._color.name(), String.format("#%02x%02x%02x", Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue()));
                           final String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                           colorNode.setProperty(AppMotif.Properties._color.name(), hex);
                           app.events.firePropertyChange(NODE_COLOR_CHANGED, ((Label) getUserObject()).name(), color);
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

   private class RelationsNode extends InformationNode {

      RelationsNode() {
         super("Relationships");

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
               final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
               final String existingType = ((RelationshipType) getUserObject()).name();
               app.model.graph().getAllRelationships().forEach(relationship -> {
                  if (!relationship.getType().name().equals(existingType)) return;
                  nodes.add(new NodeLoadEvent(relationship.getStartNode()));
                  nodes.add(new NodeLoadEvent(relationship.getEndNode()));
               });
               app.events.firePropertyChange(NODE_LOAD, nodes);
            }
         });

         pop.add(new App.TransactionAction("Change Type", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final String existingType = ((RelationshipType) getUserObject()).name();

               final Set<String> types = new TreeSet<>();
               app.model.graph().getAllRelationshipTypes().forEach(relationshipType -> types.add(relationshipType.name()));
               final String newType = SwingUtil.showSelectDialog(InformationPanel.this, types, existingType);
               if (newType == null || newType.equals(existingType)) return;

               app.model.graph().getAllRelationships().forEach(relationship -> {
                  if (!relationship.getType().name().equals(existingType)) return;

                  final Relationship newRelationship = relationship.getStartNode().createRelationshipTo(relationship.getEndNode(), RelationshipType.withName(newType));
                  for (String key : relationship.getPropertyKeys())
                     newRelationship.setProperty(key, relationship.getProperty(key));
                  relationship.delete();
               });
            }
         });

         pop.add(new App.TransactionAction("Set color", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {

               final ColorBrewerSelector editor = new ColorBrewerSelector();

               SwingUtil.showDialog(editor, app, "Select color", new SwingUtil.OnSave() {
                  @Override
                  public void verifyAndSave() throws Exception {
                     final Color color = editor.getSelectedColor();
                     if (color == null) return;

                     app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {
                           Node colorNode = app.model.graph().findNode(AppMotif.Entities._Color, "relation", ((RelationshipType) getUserObject()).name());
                           if (colorNode == null)
                              colorNode = app.model.graph().newNode(AppMotif.Entities._Color, "relation", ((RelationshipType) getUserObject()).name(), AppMotif.Properties._color.name(), String.format("#%02x%02x%02x", Color.BLACK.getRed(), Color.BLACK.getGreen(), Color.BLACK.getBlue()));
                           final String hex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                           colorNode.setProperty(AppMotif.Properties._color.name(), hex);
                           app.events.firePropertyChange(RELATION_COLOR_CHANGED, ((RelationshipType) getUserObject()).name(), color);
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
                  nodes.add(new NodeLoadEvent(node));
               app.events.firePropertyChange(NODE_LOAD, nodes);
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

               app.model.graph().getAllRelationships().forEach(relationship -> {
                  if (!relationship.hasProperty(existingProperty)) return;
                  relationship.setProperty(newProperty, relationship.removeProperty(existingProperty));
               });
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
                        app.events.firePropertyChange(NODE_LOAD, AppMotif.getLayoutNodes((Node) getUserObject()));
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
                  app.model.deleteNodes(Collections.singleton((Node) getUserObject()));
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


}
