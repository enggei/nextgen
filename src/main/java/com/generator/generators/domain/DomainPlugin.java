package com.generator.generators.domain;

import com.generator.app.*;
import com.generator.generators.project.ProjectPlugin;
import com.generator.util.NeoUtil;
import com.generator.neo.NeoModel;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.generators.stringtemplate.domain.GeneratedFile;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.generators.project.ProjectPlugin.getFile;
import static com.generator.util.NeoUtil.*;
import static com.generator.util.NeoUtil.getNameAndLabelsFrom;
import static com.generator.util.NeoUtil.relate;
import static com.generator.generators.project.ProjectPlugin.renderToFile;

/**
 * Created 06.08.17.
 */
public class DomainPlugin extends Plugin {

   public enum Entities implements Label {
      Domain, Entity, Property, Relation, Value
   }

   public enum Properties {
      relationCardinality
   }

   public enum Relations implements RelationshipType {
      ENTITY, INSTANCE, SRC, DST
   }

   public enum RelationCardinality {
      SINGLE, LIST
   }

   public DomainPlugin(App app) {
      super(app, "Domain");
   }

   public DomainPlugin(App app, String name) {
      super(app, name);
   }

   @Override
   protected Label[] getLabels() {
      return Entities.values();
   }

   @Override
   protected void addActionsTo(JMenu menu) {
      menu.add(new App.TransactionAction("New Domain", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final String name = SwingUtil.showInputDialog("Domain name", app);
            if (name == null || name.length() == 0) return;

            final Node existing = getGraph().findNode(Entities.Domain, AppMotif.Properties.name.name(), name);
            if (existing != null) {
               SwingUtil.showMessage(name + " already exists", app);
               return;
            }

            fireNodesLoaded(getGraph().newNode(Entities.Domain, AppMotif.Properties.name.name(), name));
         }
      });
   }

   @Override
   protected void handleNodeRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode neoNode, Set<Workspace.NodeCanvas.NeoNode> selectedNodes) {

      final Node node = neoNode.getNode();

      if (hasLabel(node, Entities.Domain)) {

         pop.add(new App.TransactionAction("Add Entity", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Entity name", app);
               if (name == null || name.length() == 0) return;

               final AtomicBoolean exists = new AtomicBoolean(false);
               outgoing(node, Relations.ENTITY).forEach(relationship -> {
                  if (name.equalsIgnoreCase(getOtherProperty(node, relationship, AppMotif.Properties.name.name()).toString()))
                     exists.set(true);
               });
               if (exists.get()) {
                  SwingUtil.showMessage(name + " already exists for domain", app);
                  return;
               }

               final Node newNode = getGraph().newNode(Entities.Entity, AppMotif.Properties.name.name(), name);
               node.createRelationshipTo(newNode, Relations.ENTITY);
               fireNodesLoaded(newNode);
            }
         });

         incoming(neoNode.getNode(), ProjectPlugin.Relations.RENDERER).forEach(rendererRelationship -> pop.add(new App.TransactionAction("Render Domain visitor", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               renderDomainVisitor(rendererRelationship, node);
            }
         }));

      } else if (hasLabel(node, Entities.Entity)) {

         pop.add(new App.TransactionAction("New " + getString(node, AppMotif.Properties.name.name()) + " instance", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Node newNode = getGraph().newNode(Label.label(getString(node, AppMotif.Properties.name.name())));
               node.createRelationshipTo(newNode, Relations.INSTANCE);
               fireNodesLoaded(newNode);
            }
         });

         pop.add(new App.TransactionAction("Add Property", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Property name", app);
               if (name == null || name.length() == 0) return;

               final AtomicBoolean exists = new AtomicBoolean(false);
               new EntityRelationVisitor() {
                  @Override
                  public void onSingle(Node relationNode, Node dstNode) {
                     if (name.equals(getString(relationNode, AppMotif.Properties.name.name()))) exists.set(true);
                  }

                  @Override
                  public void onList(Node relationNode, Node dstNode) {
                     if (name.equals(getString(relationNode, AppMotif.Properties.name.name()))) exists.set(true);
                  }
               }.visit(node);

               if (exists.get()) {
                  SwingUtil.showMessage(name + " already has a property named " + name, app);
                  return;
               }

               final Node newPropertyNode = getGraph().newNode(Entities.Property, AppMotif.Properties.name.name(), name);
               fireNodesLoaded(newPropertyNode, newEntityRelation(node, name, RelationCardinality.SINGLE, newPropertyNode));
            }
         });

         pop.add(new App.TransactionAction("Add Entity-relation", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final JTextField txtName = new JTextField();
               final JComboBox<RelationCardinality> cboCardinality = new JComboBox<>(RelationCardinality.values());
               final JTextField txtEntityName = new JTextField();

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref, 4dlu, pref, 4dlu, pref");
               editor.addLabel("Relation name", 1, 1);
               editor.add(txtName, 3, 1);
               editor.addLabel("Cardinality", 1, 3);
               editor.add(cboCardinality, 3, 3);
               editor.addLabel("Entity Name", 1, 5);
               editor.add(txtEntityName, 3, 5);
               editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

               SwingUtil.showDialog(editor, app, "New Relation", () -> getGraph().doInTransaction(new NeoModel.Committer() {
                  @Override
                  public void doAction(Transaction tx14) throws Throwable {

                     final String name = StringUtil.toUpper(txtName.getText().trim());
                     final RelationCardinality relationCardinality = RelationCardinality.valueOf(cboCardinality.getSelectedItem().toString());

                     if (name.length() == 0)
                        throw new IllegalStateException("Relation Name is required");
                     if (txtEntityName.getText().trim().length() == 0)
                        throw new IllegalStateException("Entity must have a name");

                     final Node newEntityNode = getGraph().newNode(Entities.Entity, AppMotif.Properties.name.name(), txtEntityName.getText().trim());
                     fireNodesLoaded(newEntityNode, newEntityRelation(node, name, relationCardinality, newEntityNode));
                  }

                  @Override
                  public void exception(Throwable throwable) {
                     SwingUtil.showException(editor, throwable);
                  }
               }));
            }
         });

         if (selectedNodes.size() <= 20) {

            for (Workspace.NodeCanvas.NeoNode selectedNode : selectedNodes) {
               if (hasLabel(selectedNode.getNode(), Entities.Entity)) {

                  pop.add(new App.TransactionAction("Add Relation " + getNameAndLabelsFrom(selectedNode.getNode()) + " -> " + getNameAndLabelsFrom(node), app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        final JTextField txtName = new JTextField();
                        final JComboBox<RelationCardinality> cboCardinality = new JComboBox<>(RelationCardinality.values());

                        final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref, 4dlu, pref");
                        editor.addLabel("Relation name", 1, 1);
                        editor.add(txtName, 3, 1);
                        editor.addLabel("Cardinality", 1, 3);
                        editor.add(cboCardinality, 3, 3);

                        SwingUtil.showDialog(editor, app, "Add Relation " + getNameAndLabelsFrom(selectedNode.getNode()) + " -> " + getNameAndLabelsFrom(node), () -> getGraph().doInTransaction(new NeoModel.Committer() {
                           @Override
                           public void doAction(Transaction tx14) throws Throwable {

                              final String name = StringUtil.toUpper(txtName.getText().trim());
                              final RelationCardinality relationCardinality = RelationCardinality.valueOf(cboCardinality.getSelectedItem().toString());

                              if (name.length() == 0)
                                 throw new IllegalStateException("Relation Name is required");

                              fireNodesLoaded(newEntityRelation(selectedNode.getNode(), name, relationCardinality, node));
                           }

                           @Override
                           public void exception(Throwable throwable) {
                              SwingUtil.showException(editor, throwable);
                           }
                        }));
                     }
                  });

               } else if (hasLabel(selectedNode.getNode(), Entities.Relation)) {
                  pop.add(new App.TransactionAction("Add " + getNameAndLabelsFrom(selectedNode.getNode()) + " -> DST ->" + getNameAndLabelsFrom(node), app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                        // remove old DST
                        System.out.println("removing existing DST");
                        outgoing(selectedNode.getNode(), Relations.DST).forEach(Relationship::delete);

                        relate(selectedNode.getNode(), node, Relations.DST);
                     }
                  });
               }
            }
         }

      } else if (hasLabel(node, Entities.Relation)) {
         pop.add(new App.TransactionAction("Change cardinality", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final RelationCardinality existing = RelationCardinality.valueOf(getString(node, Properties.relationCardinality.name()));
               final RelationCardinality relationCardinality = SwingUtil.showSelectDialog(app, RelationCardinality.values(), existing);
               if (relationCardinality == null || existing.equals(relationCardinality)) return;

               node.setProperty(Properties.relationCardinality.name(), relationCardinality.name());

               fireNodeChanged(neoNode, Properties.relationCardinality.name(), relationCardinality);
            }
         });

      } else if (hasLabel(node, DomainPlugin.Entities.Value)) {

         pop.add(new App.TransactionAction("Set value", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) {

               final String oldValue = getString(node, AppMotif.Properties.name.name());

               final String newValue = SwingUtil.showInputDialog("New value", app, oldValue);
               if (newValue == null || newValue.equals(oldValue)) return;

               node.setProperty(AppMotif.Properties.name.name(), newValue);
               fireNodeChanged(neoNode, AppMotif.Properties.name.name(), newValue);
            }
         });
      }

      incoming(node, DomainPlugin.Relations.INSTANCE).forEach(instanceRelation -> {

         final Node instanceNode = other(node, instanceRelation);

         if (hasLabel(instanceNode, Entities.Entity)) {

            if (hasLabel(instanceNode, StringTemplatePlugin.Entities.STTemplate)) {
               incoming(node, ProjectPlugin.Relations.RENDERER).forEach(rendererRelationship -> {
                  final Node directoryNode = other(neoNode.getNode(), rendererRelationship);
                  if (directoryNode != null) {
                     final File directory = ProjectPlugin.getFile(directoryNode);
                     if (directory != null && directory.exists()) {
                        pop.add(new App.TransactionAction("Render to " + DomainMotif.getPropertyValue(directoryNode, AppMotif.Properties.name.name()), app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                              final String content = StringTemplatePlugin.renderStatement(node, other(node, singleIncoming(node, Relations.INSTANCE)));
                              renderToFile(rendererRelationship, node, content, other(node, rendererRelationship), app);
                           }
                        });
                     }
                  }
               });
            }

            final JMenu referenceMenu = new JMenu(getNameAndLabelsFrom(instanceNode));

            final Map<String, Node> singlePropertyMap = new TreeMap<>();
            final Map<String, Node> singleEntityMap = new TreeMap<>();
            final Map<String, Map<String, Set<Node>>> groupAssign = new TreeMap<>();

            new EntityRelationVisitor() {

               @Override
               public void onSingle(Node relationNode, Node dstNode) {
                  final String parameterName = getString(relationNode, AppMotif.Properties.name.name());

                  if (hasLabel(dstNode, Entities.Property)) {
                     singlePropertyMap.put(parameterName, dstNode);

                  } else {
                     singleEntityMap.put(parameterName, dstNode);
                  }

                  if (selectedNodes.size() == 1) {
                     final Workspace.NodeCanvas.NeoNode selectedNode = selectedNodes.iterator().next();

                     final String dstType = getString(dstNode, AppMotif.Properties.name.name());
                     if (!isRelated(node, selectedNode.getNode(), RelationshipType.withName(parameterName)) && ((hasLabel(dstNode, Entities.Property) && hasLabel(selectedNode.getNode(), Entities.Value)) || hasLabel(selectedNode.getNode(), dstType))) {
                        referenceMenu.add(new App.TransactionAction("Set " + parameterName + " -> " + getNameAndLabelsFrom(selectedNode.getNode()), app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {

                              // remove any existing one
                              outgoing(node, RelationshipType.withName(parameterName)).forEach(oldValueRelation -> {
                                 final Node oldValueNode = other(node, oldValueRelation);
                                 oldValueRelation.delete();
                                 AppMotif.tryToDeleteValueNode(oldValueNode);
                              });

                              relate(node, selectedNode.getNode(), RelationshipType.withName(parameterName));
                           }
                        });
                     }
                  }
               }

               @Override
               public void onList(Node relationNode, Node dstNode) {

                  final String parameterName = getString(relationNode, AppMotif.Properties.name.name());
                  final String dstType = getString(dstNode, AppMotif.Properties.name.name());

                  groupAssign.put(parameterName, new LinkedHashMap<>());

                  referenceMenu.add(new App.TransactionAction("Add " + parameterName + " (" + dstType + ")", app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {

                        if (hasLabel(dstNode, Entities.Property)) {
                           final String value = SwingUtil.showInputDialog("Value", app);
                           if (value == null || value.trim().length() == 0) return;

                           final Set<Node> newNodes = new LinkedHashSet<>();
                           final Node newDstNode = newValueNode(value.trim());
                           relate(node, newDstNode, RelationshipType.withName(parameterName));
                           newNodes.add(newDstNode);
                           fireNodesLoaded(newNodes);

                        } else {

                           showNewEntityDialog(parameterName, dstNode, node);
                        }
                     }
                  });

                  for (Workspace.NodeCanvas.NeoNode selectedNode : selectedNodes) {

//                     final boolean isProperty = hasLabel(dstNode, Entities.Property) && hasLabel(selectedNode.getNode(), Entities.Value);

                     if (!isRelated(node, selectedNode.getNode(), RelationshipType.withName(parameterName))) {

                        if (hasLabel(selectedNode.getNode(), dstType)) {
                           final Map<String, Set<Node>> map = groupAssign.get(parameterName);
                           map.computeIfAbsent(Entities.Entity.name(), k -> new LinkedHashSet<>());
                           map.get(Entities.Entity.name()).add(selectedNode.getNode());
                        } else if (hasLabel(dstNode, Entities.Property)) {
                           final Map<String, Set<Node>> map = groupAssign.get(parameterName);
                           map.computeIfAbsent(Entities.Property.name(), k -> new LinkedHashSet<>());
                           map.get(Entities.Property.name()).add(selectedNode.getNode());
                        }
                     }
                  }
               }
            }.visit(instanceNode);

            if (!groupAssign.isEmpty()) {
               for (Map.Entry<String, Map<String, Set<Node>>> groupEntry : groupAssign.entrySet()) {
                  for (Map.Entry<String, Set<Node>> entry : groupEntry.getValue().entrySet()) {
                     referenceMenu.add(new App.TransactionAction("Add " + groupEntry.getKey() + " -> " + (entry.getValue().size() == 1 ? getNameAndLabelsFrom(entry.getValue().iterator().next()) : (groupAssign.size() + " nodes")), app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                           for (Node selectedNode : entry.getValue())
                              relate(node, selectedNode, RelationshipType.withName(groupEntry.getKey()));
                        }
                     });
                  }
               }
            }

            if (!singlePropertyMap.isEmpty()) {

               referenceMenu.add(new App.TransactionAction("Set Properties", app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     final Map<String, JTextField> fields = new TreeMap<>();
                     final StringBuilder rows = new StringBuilder();
                     boolean first = true;
                     for (Map.Entry<String, Node> propertyEntry : singlePropertyMap.entrySet()) {
                        if (!first) rows.append(",4dlu,");
                        rows.append("pref");
                        fields.put(propertyEntry.getKey(), new JTextField());
                        first = false;
                     }

                     final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu:grow,4dlu,75dlu:grow", rows.toString().trim());
                     int row = 1;
                     for (Map.Entry<String, JTextField> fieldEntry : fields.entrySet()) {
                        editor.addLabel(fieldEntry.getKey(), 1, row);
                        editor.add(fieldEntry.getValue(), 3, row);
                        row += 2;
                     }
                     editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

                     SwingUtil.showDialog(editor, app, "Set Properties", new SwingUtil.OnSave() {
                        @Override
                        public void verifyAndSave() throws Exception {
                           getGraph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {

                                 for (Map.Entry<String, JTextField> fieldEntry : fields.entrySet()) {
                                    final String value = fieldEntry.getValue().getText().trim();
                                    if (value.trim().length() == 0) continue;

                                    // remove any existing one
                                    outgoing(node, RelationshipType.withName(fieldEntry.getKey())).forEach(oldValueRelation -> {
                                       final Node oldValueNode = other(node, oldValueRelation);
                                       oldValueRelation.delete();
                                       AppMotif.tryToDeleteValueNode(oldValueNode);
                                    });

                                    // try to find existing node with same value, and if exists, use this and add link to it
                                    final Node existingNode = getGraph().findNode(Entities.Value, AppMotif.Properties.name.name(), value);
                                    final Node newDstNode = existingNode == null ? newValueNode(value) : existingNode;
                                    relate(node, newDstNode, RelationshipType.withName(fieldEntry.getKey()));
                                    fireNodesLoaded(newDstNode);
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

            if (!singleEntityMap.isEmpty()) {
               for (Map.Entry<String, Node> entry : singleEntityMap.entrySet()) {
                  // Entities.Entity node
                  referenceMenu.add(new App.TransactionAction("Set " + entry.getKey(), app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {

                        // remove any existing one
                        outgoing(node, RelationshipType.withName(entry.getKey())).forEach(oldValueRelation -> {
                           final Node oldValueNode = other(node, oldValueRelation);
                           oldValueRelation.delete();
                           AppMotif.tryToDeleteValueNode(oldValueNode);
                        });

                        showNewEntityDialog(entry.getKey(), entry.getValue(), node);
                     }
                  });
               }
            }

            referenceMenu.add(new App.TransactionAction("Show Entity " + getNameAndLabelsFrom(instanceNode), app) {
               @Override
               protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  fireNodesLoaded(instanceNode);
               }
            });

            pop.add(referenceMenu);
         }
      });
   }

   private void showNewEntityDialog(String parameterName, Node instanceNode, Node ownerNode) {
      // get Entity.Property for entity, and show dialog
      final Map<String, Node> entityPropertiesMap = new TreeMap<>();

      new EntityRelationVisitor() {

         @Override
         public void onSingle(Node relationNode, Node dstNode) {
            final String parameterName = getString(relationNode, AppMotif.Properties.name.name());
            if (hasLabel(dstNode, Entities.Property))
               entityPropertiesMap.put(parameterName, dstNode);
         }

         @Override
         public void onList(Node relationNode, Node dstNode) {

         }
      }.visit(instanceNode);


      final Map<String, JTextField> fields = new TreeMap<>();
      final StringBuilder rows = new StringBuilder();
      boolean first = true;
      for (Map.Entry<String, Node> propertyEntry : entityPropertiesMap.entrySet()) {
         if (!first) rows.append(",4dlu,");
         rows.append("pref");
         fields.put(propertyEntry.getKey(), new JTextField());
         first = false;
      }

      final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu:grow,4dlu,75dlu:grow", rows.toString().trim());
      int row = 1;
      for (Map.Entry<String, JTextField> fieldEntry : fields.entrySet()) {
         editor.addLabel(fieldEntry.getKey(), 1, row);
         editor.add(fieldEntry.getValue(), 3, row);
         row += 2;
      }
      editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

      SwingUtil.showDialog(editor, app, "New " + getNameAndLabelsFrom(instanceNode), new SwingUtil.OnSave() {
         @Override
         public void verifyAndSave() throws Exception {
            getGraph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {

                  Node newEntityNode = null;
                  for (Map.Entry<String, JTextField> fieldEntry : fields.entrySet()) {
                     final String value = fieldEntry.getValue().getText().trim();
                     if (value.trim().length() == 0) continue;

                     if (newEntityNode == null) {
                        newEntityNode = newInstanceNode(getString(instanceNode, AppMotif.Properties.name.name()), instanceNode);
                        relate(ownerNode, newEntityNode, RelationshipType.withName(parameterName));
                     }

                     // try to find existing node with same value, and if exists, use this and add link to it
                     final Node existingValueNode = getGraph().findNode(Entities.Value, AppMotif.Properties.name.name(), value);
                     final Node newPropertyNode = existingValueNode == null ? newValueNode(value) : existingValueNode;
                     relate(newEntityNode, newPropertyNode, RelationshipType.withName(fieldEntry.getKey()));
                  }
                  if (newEntityNode != null) fireNodesLoaded(newEntityNode);
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
   public void showEditorFor(Workspace.NodeCanvas.NeoNode neoNode, JTabbedPane tabbedPane) {

   }


   public static void renderDomainVisitor(Relationship rendererRelationship, Node node) {
      final String packageName = getString(rendererRelationship, "package");
      final String groupName = getString(node, AppMotif.Properties.name.name()) + "Visitor";
      final File targetDir = getFile(other(node, rendererRelationship));

      final Set<Node> visitedNodes = new LinkedHashSet<>();
      final Map<String, NeoVisitorGroup.entityVisitST> visitorMethods = new LinkedHashMap<>();

      final NeoVisitorGroup visitorGroup = new NeoVisitorGroup();

      for (Relationship relationship : outgoing(node, Relations.ENTITY))
         visitEntityNode(visitorMethods, visitedNodes, visitorGroup, other(node, relationship));

      final NeoVisitorGroup.DomainVisitorST domainVisitorST = visitorGroup.newDomainVisitor().
            setName(groupName).
            setPackageName(packageName);

      for (Map.Entry<String, NeoVisitorGroup.entityVisitST> visitSTEntry : visitorMethods.entrySet())
         domainVisitorST.addEntitiesValue(visitSTEntry.getKey(), visitSTEntry.getValue());

      try {
         GeneratedFile.newJavaFile(targetDir.getAbsolutePath(), packageName, groupName).write(domainVisitorST);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   private static void visitEntityNode(Map<String, NeoVisitorGroup.entityVisitST> visitorMethods, Set<Node> visitedNodes, NeoVisitorGroup visitorGroup, Node entityNode) {

      if (visitedNodes.contains(entityNode)) return;
      visitedNodes.add(entityNode);

      final String entityName = getString(entityNode, AppMotif.Properties.name.name());

      final NeoVisitorGroup.entityVisitST newEntityVisitorST = visitorGroup.newentityVisit().
            setName(entityName);

      for (Relationship srcRelation : outgoing(entityNode, Relations.SRC)) {
         final Node relationNode = other(entityNode, srcRelation);
         newEntityVisitorST.addOutgoingValue(getString(relationNode, AppMotif.Properties.name.name()));

         for (Relationship dstRelation : outgoing(relationNode, Relations.DST)) {
            final Node dstNode = other(relationNode, dstRelation);
            visitEntityNode(visitorMethods, visitedNodes, visitorGroup, dstNode);
         }
      }

      final NeoVisitorGroup.entityVisitST existingVisitorST = visitorMethods.get(entityName);
      if (existingVisitorST == null) {
         visitorMethods.put(entityName, newEntityVisitorST);
         return;
      }

      // add any new outgoings:
      for (Object newOutgoing : newEntityVisitorST.getOutgoingValues()) {
         if (existingVisitorST.getOutgoingValues().contains(newOutgoing)) continue;
         existingVisitorST.addOutgoingValue(newOutgoing);
      }
   }

   // todo make these static in DomainMotif


   protected void newEntityProperty(Node srcEntity, String name) {
      newEntityRelation(srcEntity, name, RelationCardinality.SINGLE, getGraph().findOrCreate(Entities.Property, AppMotif.Properties.name.name(), name));
   }

   protected Node newEntityRelation(Node srcEntity, String name, RelationCardinality relationCardinality, Node... dstEntities) {
      return DomainMotif.newEntityRelation(getGraph(), srcEntity, name, relationCardinality, dstEntities);
   }

   protected Node newValueNode(String value) {
      return getGraph().newNode(Entities.Value, AppMotif.Properties.name.name(), value);
   }

   private Node newInstanceNode(String label, Node referenceNode) {
      final Node newNode = getGraph().newNode(Label.label(label));
      referenceNode.createRelationshipTo(newNode, Relations.INSTANCE);
      return newNode;
   }

   public abstract static class EntityRelationVisitor {

      public abstract void onSingle(Node relationNode, Node dstNode);

      public abstract void onList(Node relationNode, Node dstNode);

      public void visit(Node entityNode) {
         outgoing(entityNode, Relations.SRC).forEach(srcRelation -> {
            final Node relationNode = other(entityNode, srcRelation);
            outgoing(relationNode, Relations.DST).forEach(relationship -> {
               final Node destinationEntityNode = other(relationNode, relationship);

               switch (RelationCardinality.valueOf(getString(relationNode, Properties.relationCardinality.name()))) {
                  case SINGLE:
                     onSingle(relationNode, destinationEntityNode);
                     break;
                  case LIST:
                     onList(relationNode, destinationEntityNode);
                     break;
               }
            });
         });
      }
   }

   public static abstract class DomainVisitor {

      final Set<Node> visited = new LinkedHashSet<>();

      public void visit(Node node) {
         if (node == null) return;
         if (NeoUtil.hasLabel(node, Entities.Domain.name())) visitDomain(node);
         if (NeoUtil.hasLabel(node, Entities.Entity.name())) visitEntity(node);
         if (NeoUtil.hasLabel(node, Entities.Relation.name())) visitRelation(node);
         if (NeoUtil.hasLabel(node, Entities.Property.name())) visitProperty(node);
      }

      void visitDomain(Node node) {
         if (visited.contains(node)) return;
         visited.add(node);
         outgoing(node, Relations.ENTITY).forEach(relationship -> visit(other(node, relationship)));
      }

      void visitEntity(Node node) {
         if (visited.contains(node)) return;
         visited.add(node);
         outgoing(node, Relations.SRC).forEach(relationship -> visit(other(node, relationship)));
      }

      void visitRelation(Node node) {
         if (visited.contains(node)) return;
         visited.add(node);
         outgoing(node, Relations.DST).forEach(relationship -> visit(other(node, relationship)));
      }

      void visitProperty(Node node) {
         if (visited.contains(node)) return;
         visited.add(node);
      }
   }
}