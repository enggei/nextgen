package com.generator.app;

import com.generator.editors.NeoModel;
import com.generator.generators.templates.domain.TemplateEntities;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STErrorListener;
import org.stringtemplate.v4.STGroupString;
import org.stringtemplate.v4.misc.ErrorType;
import org.stringtemplate.v4.misc.STMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.getNameAndLabelsFrom;
import static com.generator.editors.NeoModel.getNameOrLabelFrom;

/**
 * Created 18.07.17.
 */
final class TemplateMotif {

   static Node newTemplateInstance(App app, Node templateNode, String name) {
      final Node newNode = app.model.graph().newNode(org.neo4j.graphdb.Label.label(getString(templateNode, AppMotif.Properties.name.name())), AppMotif.Properties.name.name(), name);
      templateNode.createRelationshipTo(newNode, TemplateMotif.Relations.TEMPLATE);
      TemplateMotif.tryToSetNameParameter(name, newNode, templateNode, app);
      return newNode;
   }

   static Set<AppEvents.NodeLoadEvent> getAllStatementsOfType(App app, Node templateNode) {
      final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
      outgoing((templateNode), TemplateMotif.Relations.TEMPLATE).forEach(relationship -> nodes.add(new AppEvents.NodeLoadEvent(other((templateNode), relationship))));
      return nodes;
   }

   enum Entities implements Label {
      _STGroup, _STTemplate, _Single, _List, _KeyValueList, _Value, _KeyValue,
      _Domain, _Entity
   }

   enum Properties {
      _text, _deprecated, _referenceProperty, _referenceType
   }

   enum Relations implements RelationshipType {
      TEMPLATE_PARAMETER, PARAMETER, STTEMPLATE, TEMPLATE, KEY_VALUE,
      ENTITY, PROPERTY
   }

   static String getLabelFor(TemplateEntities domainEntityType) {
      switch (domainEntityType) {
         case STRINGPROPERTY:
         case BOOLEANPROPERTY:
         case STATEMENTPROPERTY:
            return Entities._Single.name();
         case LISTPROPERTY:
            return Entities._List.name();
         default:
            return Entities._KeyValueList.name();
      }
   }

   enum ReferenceType {
      PROPERTY, STATEMENT
   }

   static void onRightClick(JPopupMenu pop, Workspace.NodeCanvas.NeoNode node, Set<Workspace.NodeCanvas.NeoNode> selectedNodes, App app) {

      if (hasLabel(node.getNode(), TemplateMotif.Entities._STTemplate)) {
         handle_STTemplate(pop, node, app);

      } else if (hasLabel(node.getNode(), TemplateMotif.Entities._STGroup)) {
         handle_STGroup(pop, node, app);

      } else if (hasLabel(node.getNode(), TemplateMotif.Entities._KeyValue)) {
         handle_KeyValue(pop, node, selectedNodes, app);

      } else if (hasLabel(node.getNode(), TemplateMotif.Entities._Value)) {
         handle_Value(pop, node, selectedNodes, app);

      } else if (hasLabel(node.getNode(), Entities._Domain)) {
         handle_Domain(pop, node, selectedNodes, app);

      } else if (hasLabel(node.getNode(), Entities._Entity)) {
         handle_Entity(pop, node, selectedNodes, app);
      }

      node.getNode().getLabels().forEach(thisLabel -> app.model.graph().findNodes(TemplateMotif.Entities._STTemplate, AppMotif.Properties.name.name(), thisLabel.name()).forEachRemaining(thisTemplate -> {
         for (Workspace.NodeCanvas.NeoNode selectedNode : selectedNodes) {
            selectedNode.getNode().getLabels().forEach(label -> app.model.graph().findNodes(TemplateMotif.Entities._STTemplate, AppMotif.Properties.name.name(), label.name()).forEachRemaining(templateNode -> {
               final JMenu domainMenu = new JMenu(getNameAndLabelsFrom(selectedNode.getNode()));

               // show parameters-action
               outgoing(templateNode, TemplateMotif.Relations.TEMPLATE_PARAMETER).forEach(relationship -> {
                  final Node parameterNode = other(templateNode, relationship);
                  final String parameterName = getString(parameterNode, AppMotif.Properties.name.name());
                  // do not use if its deprecated
                  if (parameterNode.hasProperty(TemplateMotif.Properties._deprecated.name()))
                     return;

                  if (hasLabel(parameterNode, TemplateMotif.Entities._Single)) {
                     if (!isRelated(selectedNode.getNode(), node.getNode(), RelationshipType.withName(parameterName))) {
                        domainMenu.add(new App.TransactionAction("Set " + parameterName + " -> " + NeoModel.getNameOrLabelFrom(node.getNode()), app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {
                              // remove any existing
                              outgoing(selectedNode.getNode(), RelationshipType.withName(parameterName)).forEach(oldValueRelation -> {
                                 final Node oldValueNode = other(selectedNode.getNode(), oldValueRelation);
                                 oldValueRelation.delete();
                                 AppMotif.tryToDeleteValueNode(oldValueNode);
                              });

                              newStatementReference(selectedNode.getNode(), node.getNode(), parameterName, thisLabel, app);
                           }
                        });
                     }

                  } else if (hasLabel(parameterNode, TemplateMotif.Entities._List)) {
                     if (!isRelated(selectedNode.getNode(), node.getNode(), RelationshipType.withName(parameterName))) {
                        domainMenu.add(new App.TransactionAction("Add " + parameterName + " -> " + NeoModel.getNameOrLabelFrom(node.getNode()), app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {
                              newStatementReference(selectedNode.getNode(), node.getNode(), parameterName, thisLabel, app);
                           }
                        });
                     }

                  } else if (hasLabel(parameterNode, TemplateMotif.Entities._KeyValueList)) {

                     final java.util.List<String> keys = new ArrayList<>();
                     parameterNode.getPropertyKeys().forEach(s -> {
                        if (s.startsWith("key_")) keys.add(getString(parameterNode, s));
                     });

                     final JMenu keyValueMenu = new JMenu(parameterName);
                     for (String key : keys) {
                        if (!isRelated(selectedNode.getNode(), node.getNode(), RelationshipType.withName(key))) {
                           keyValueMenu.add(new App.TransactionAction("Add " + parameterName + "." + key + " -> " + NeoModel.getNameOrLabelFrom(node.getNode()), app) {
                              @Override
                              protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {
                                 final Node keyValueNode = app.model.graph().getGraphDb().createNode(TemplateMotif.Entities._KeyValue);
                                 keyValueNode.setProperty(AppMotif.Properties.name.name(), parameterName);
                                 selectedNode.getNode().createRelationshipTo(keyValueNode, RelationshipType.withName(parameterName));
                                 parameterNode.createRelationshipTo(keyValueNode, Relations.KEY_VALUE);
                                 app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(keyValueNode));

                                 final Relationship valueRelation = keyValueNode.createRelationshipTo(node.getNode(), RelationshipType.withName(key));
                                 valueRelation.setProperty(TemplateMotif.Properties._referenceType.name(), TemplateMotif.ReferenceType.STATEMENT.name());
                                 valueRelation.setProperty(TemplateMotif.Properties._referenceProperty.name(), thisLabel.name());
                                 app.events.fireNodeChanged(selectedNode.getNode().getId(), null, selectedNode.getNode());
                              }
                           });
                        }
                     }
                     domainMenu.add(keyValueMenu);
                  }
               });
               if (domainMenu.getMenuComponents().length > 0) pop.add(domainMenu);
            }));
         }
      }));
   }

   private static void newStatementReference(Node source, Node statement, String parameterName, Label referenceProperty, App app) {
      final Relationship valueRelation = source.createRelationshipTo(statement, RelationshipType.withName(parameterName));
      valueRelation.setProperty(Properties._referenceType.name(), ReferenceType.STATEMENT.name());
      valueRelation.setProperty(Properties._referenceProperty.name(), referenceProperty.name());
      app.events.fireNodeChanged(source.getId());
   }

   private static void handle_Entity(JPopupMenu pop, Workspace.NodeCanvas.NeoNode node, Set<Workspace.NodeCanvas.NeoNode> selectedNodes, App app) {

      pop.add(new App.TransactionAction("Single value", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String newValue = SwingUtil.showInputDialog("[Name] [value]", app.workspace);
            if (newValue == null || newValue.split("[ ]").length != 2) return;

            final String[] split = newValue.split("[ ]");
            final Node newNode = app.model.graph().newNode(Entities._Value, AppMotif.Properties.name.name(), StringUtil.printRest(1, split, " "));
            node.getNode().createRelationshipTo(newNode, RelationshipType.withName(newValue.split("[ ]")[0]));
            app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(newNode));
         }
      });

      pop.add(new App.TransactionAction("Key value", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JPanel editor = new JPanel(null);
            editor.setLayout(new BoxLayout(editor, BoxLayout.PAGE_AXIS));

            final JTextField txtName = new JTextField();
            final SwingUtil.FormPanel namePanel = new SwingUtil.FormPanel("50dlu,4dlu,75dlu:grow", "pref");
            namePanel.addLabel("Name", 1, 1);
            namePanel.add(txtName, 3, 1);
            editor.add(namePanel);

            final JTextField[] txtKeys = new JTextField[5];
            final JTextField[] txtValues = new JTextField[5];
            for (int i = 0; i < 5; i++) {
               final SwingUtil.FormPanel row = new SwingUtil.FormPanel("50dlu,4dlu,75dlu:grow,4dlu,75dlu:grow", "pref");
               row.addLabel("Key / Value" + (i + 1), 1, 1);
               row.add(txtKeys[i] = new JTextField(30), 3, 1);
               row.add(txtValues[i] = new JTextField(30), 5, 1);
               editor.add(row);
            }
            editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

            SwingUtil.showDialog(editor, app, "Entities", () -> app.model.graph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx14) throws Throwable {

                  final Map<String, String> keyValues = new TreeMap<>();
                  for (int i = 0; i < txtValues.length; i++) {
                     if (txtKeys[i].getText().trim().length() == 0 || txtValues[i].getText().trim().length() == 0)
                        continue;
                     keyValues.put(txtKeys[i].getText().trim(), txtValues[i].getText().trim());
                  }

                  if (keyValues.size() == 0) throw new IllegalStateException("Must have some key-values");
                  if (txtName.getText().trim().length() == 0) throw new IllegalStateException("Name is required");

                  final Node keyValueNode = app.model.graph().newNode(Entities._KeyValue, AppMotif.Properties.name.name(), txtName.getText().trim());
                  for (Map.Entry<String, String> entry : keyValues.entrySet()) {
                     keyValueNode.setProperty("key_" + entry.getKey(), entry.getKey());

                     final Node valueNode = app.model.graph().newNode(Entities._Value, AppMotif.Properties.name.name(), entry.getValue());
                     final Relationship valueRelation = keyValueNode.createRelationshipTo(valueNode, RelationshipType.withName(entry.getKey()));
                     valueRelation.setProperty(TemplateMotif.Properties._referenceType.name(), ReferenceType.PROPERTY.name());
                     valueRelation.setProperty(TemplateMotif.Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                  }
                  node.getNode().createRelationshipTo(keyValueNode, RelationshipType.withName(txtName.getText().trim()));
                  app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(keyValueNode));
               }

               @Override
               public void exception(Throwable throwable) {
                  SwingUtil.showException(editor, throwable);
               }
            }));
         }
      });
   }

   private static void handle_Domain(JPopupMenu pop, Workspace.NodeCanvas.NeoNode node, Set<Workspace.NodeCanvas.NeoNode> selectedNodes, App app) {
      pop.add(new App.TransactionAction("Add Entity", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Entity name", app);
            if (name == null || name.length() == 0) return;

            final AtomicBoolean exists = new AtomicBoolean(false);
            outgoing(node.getNode(), Relations.ENTITY).forEach(relationship -> {
               if (name.equalsIgnoreCase(getOtherProperty(node.getNode(), relationship, AppMotif.Properties.name.name()).toString()))
                  exists.set(true);
            });
            if (exists.get()) {
               SwingUtil.showMessage(name + " already exists for domain", app);
               return;
            }

            final Node newNode = app.model.graph().newNode(Entities._Entity, AppMotif.Properties.name.name(), name);
            node.getNode().createRelationshipTo(newNode, Relations.ENTITY);
            app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(newNode));
         }
      });
   }

   private static void handle_Value(JPopupMenu pop, Workspace.NodeCanvas.NeoNode node, Set<Workspace.NodeCanvas.NeoNode> selectedNodes, App app) {
      pop.add(new App.TransactionAction("Set value", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) {

            final String oldValue = getString(node.getNode(), AppMotif.Properties.name.name());

            final String newValue = SwingUtil.showInputDialog("New value", app, oldValue);
            if (newValue == null || newValue.equals(oldValue)) return;

            node.getNode().setProperty(AppMotif.Properties.name.name(), newValue);
            app.events.fireNodeChanged(node.getNode().getId(), AppMotif.Properties.name.name(), newValue);
         }
      });

      for (Workspace.NodeCanvas.NeoNode selectedNode : selectedNodes) {
         selectedNode.getNode().getLabels().forEach(label -> app.model.graph().findNodes(Entities._STTemplate, AppMotif.Properties.name.name(), label.name()).forEachRemaining(templateNode -> {
            final JMenu domainMenu = new JMenu(getNameAndLabelsFrom(selectedNode.getNode()));

            // show parameters-action
            outgoing(templateNode, Relations.TEMPLATE_PARAMETER).forEach(relationship -> {
               final Node parameterNode = other(templateNode, relationship);
               final String parameterName = getString(parameterNode, AppMotif.Properties.name.name());
               // do not use if its deprecated
               if (parameterNode.hasProperty(Properties._deprecated.name()))
                  return;

               if (hasLabel(parameterNode, Entities._Single)) {
                  if (!isRelated(selectedNode.getNode(), node.getNode(), RelationshipType.withName(parameterName))) {
                     domainMenu.add(new App.TransactionAction("Set " + parameterName + " -> " + NeoModel.getNameOrLabelFrom(node.getNode()), app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {

                           // remove any existing
                           outgoing(selectedNode.getNode(), RelationshipType.withName(parameterName)).forEach(oldValueRelation -> {
                              final Node oldValueNode = other(selectedNode.getNode(), oldValueRelation);
                              oldValueRelation.delete();
                              AppMotif.tryToDeleteValueNode(oldValueNode);
                           });

                           final Relationship valueRelation = selectedNode.getNode().createRelationshipTo(node.getNode(), RelationshipType.withName(parameterName));
                           valueRelation.setProperty(Properties._referenceType.name(), ReferenceType.PROPERTY.name());
                           valueRelation.setProperty(Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                           app.events.fireNodeChanged(selectedNode.getNode().getId());
                        }
                     });
                  }

               } else if (hasLabel(parameterNode, Entities._List)) {
                  if (!isRelated(selectedNode.getNode(), node.getNode(), RelationshipType.withName(parameterName))) {
                     domainMenu.add(new App.TransactionAction("Add " + parameterName + " -> " + NeoModel.getNameOrLabelFrom(node.getNode()), app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {
                           final Relationship valueRelation = selectedNode.getNode().createRelationshipTo(node.getNode(), RelationshipType.withName(parameterName));
                           valueRelation.setProperty(Properties._referenceType.name(), ReferenceType.PROPERTY.name());
                           valueRelation.setProperty(Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                           app.events.fireNodeChanged(selectedNode.getNode().getId());
                        }
                     });
                  }

               } else if (hasLabel(parameterNode, Entities._KeyValueList)) {

                  final java.util.List<String> keys = new ArrayList<>();
                  parameterNode.getPropertyKeys().forEach(s -> {
                     if (s.startsWith("key_")) keys.add(getString(parameterNode, s));
                  });

                  final JMenu keyValueMenu = new JMenu(parameterName);
                  for (String key : keys) {
                     if (!isRelated(selectedNode.getNode(), node.getNode(), RelationshipType.withName(key))) {
                        keyValueMenu.add(new App.TransactionAction("Add " + parameterName + "." + key + " -> " + NeoModel.getNameOrLabelFrom(node.getNode()), app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {
                              final Node keyValueNode = app.model.graph().getGraphDb().createNode(Entities._KeyValue);
                              parameterNode.createRelationshipTo(keyValueNode, Relations.KEY_VALUE);
                              keyValueNode.setProperty(AppMotif.Properties.name.name(), parameterName);
                              selectedNode.getNode().createRelationshipTo(keyValueNode, RelationshipType.withName(parameterName));
                              app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(keyValueNode));

                              final Relationship valueRelation = keyValueNode.createRelationshipTo(node.getNode(), RelationshipType.withName(key));
                              valueRelation.setProperty(Properties._referenceType.name(), ReferenceType.PROPERTY.name());
                              valueRelation.setProperty(Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                              app.events.fireNodeChanged(selectedNode.getNode().getId(), null, selectedNode.getNode());
                           }
                        });
                     }
                  }
                  domainMenu.add(keyValueMenu);
               }
            });
            if (domainMenu.getMenuComponents().length > 0) pop.add(domainMenu);
         }));
      }
   }

   private static void handle_KeyValue(JPopupMenu pop, Workspace.NodeCanvas.NeoNode node, Set<Workspace.NodeCanvas.NeoNode> selectedNodes, App app) {

      final Relationship keyValueRelation = singleIncoming(node.getNode(), Relations.KEY_VALUE);
      final Node keyValueTemplateParameter = other(node.getNode(), keyValueRelation);

      if (keyValueTemplateParameter != null) {
         pop.add(new App.TransactionAction("Edit", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final List<String> myKeys = new ArrayList<>();
               for (String propertyKey : keyValueTemplateParameter.getPropertyKeys())
                  if (propertyKey.startsWith("key_")) myKeys.add(propertyKey.substring(4));

               final JPanel editor = new JPanel(null);
               editor.setLayout(new BoxLayout(editor, BoxLayout.PAGE_AXIS));
               final JTextField[] txtValues = new JTextField[myKeys.size()];
               final Map<String, Relationship> existingRelations = new LinkedHashMap<>();
               for (int i = 0; i < myKeys.size(); i++) {
                  final SwingUtil.FormPanel row = new SwingUtil.FormPanel("50dlu,4dlu,75dlu:grow", "pref");
                  row.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                  row.addLabel(myKeys.get(i), 1, 1);
                  row.add(txtValues[i] = new JTextField(30), 3, 1);

                  final Relationship existingRelation = singleOutgoing(node.getNode(), RelationshipType.withName(myKeys.get(i)));
                  existingRelations.put(myKeys.get(i), existingRelation);

                  if (existingRelation != null) {
                     if (ReferenceType.PROPERTY.name().equals(existingRelation.getProperty(Properties._referenceType.name()))) {
                        txtValues[i].setText(getString(other(node.getNode(), existingRelation), getString(existingRelation, Properties._referenceProperty.name())));
                     } else if (ReferenceType.STATEMENT.name().equals(existingRelation.getProperty(Properties._referenceType.name()))) {
                        txtValues[i].setText(getNameAndLabelsFrom(other(node.getNode(), existingRelation)));
                     }
                  }

                  editor.add(row);
               }

               SwingUtil.showDialog(editor, app, "Edit", new SwingUtil.OnSave() {
                  @Override
                  public void verifyAndSave() throws Exception {
                     app.model.graph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {

                           for (int i = 0; i < txtValues.length; i++) {
                              final String text = txtValues[i].getText().trim();
                              final String key = myKeys.get(i);

                              final Relationship existingRelation = existingRelations.get(key);
                              if (existingRelation != null) {
                                 if (ReferenceType.PROPERTY.name().equals(existingRelation.getProperty(Properties._referenceType.name()))) {
                                    if (text.equals(getString(other(node.getNode(), existingRelation), getString(existingRelation, Properties._referenceProperty.name()))))
                                       continue;
                                 } else if (ReferenceType.STATEMENT.name().equals(existingRelation.getProperty(Properties._referenceType.name()))) {
                                    if (text.equals(getNameAndLabelsFrom(other(node.getNode(), existingRelation))))
                                       continue;
                                 }
                              }

                              if (existingRelation != null) {
                                 if (ReferenceType.PROPERTY.name().equals(existingRelation.getProperty(Properties._referenceType.name()))) {
                                    final Node oldValueNode = other(node.getNode(), existingRelation);
                                    existingRelation.delete();
                                    AppMotif.tryToDeleteValueNode(oldValueNode);
                                 } else {
                                    existingRelation.delete();
                                 }
                              }

                              if (text.trim().length() == 0) continue;

                              final Node valueNode = app.model.graph().getGraphDb().createNode(Entities._Value);
                              valueNode.setProperty(AppMotif.Properties.name.name(), text);
                              app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(valueNode));

                              final Relationship valueRelation = node.getNode().createRelationshipTo(valueNode, RelationshipType.withName(key));
                              valueRelation.setProperty(Properties._referenceType.name(), ReferenceType.PROPERTY.name());
                              valueRelation.setProperty(Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                           }

                           app.events.fireNodeChanged(node.getNode().getId(), null, node.getNode());
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showException(editor, throwable);
                        }
                     });
                  }
               });
            }
         });
      }

      final List<String> existingKeyValues = new ArrayList<>();
      outgoing(node.getNode()).forEach(relationship -> existingKeyValues.add(relationship.getType().name()));

      for (Workspace.NodeCanvas.NeoNode selectedNode : selectedNodes) {
         selectedNode.getNode().getLabels().forEach(label -> app.model.graph().findNodes(Entities._STTemplate, AppMotif.Properties.name.name(), label.name()).forEachRemaining(templateNode -> {
            final JMenu domainMenu = new JMenu(getString(templateNode, AppMotif.Properties.name.name()));

            // show parameters-action
            outgoing(templateNode, Relations.TEMPLATE_PARAMETER).forEach(relationship -> {
               final Node parameterNode = other(templateNode, relationship);
               final String parameterName = getString(parameterNode, AppMotif.Properties.name.name());
               // do not use if its deprecated
               if (parameterNode.hasProperty(Properties._deprecated.name()))
                  return;

               if (hasLabel(parameterNode, Entities._KeyValueList) && !isRelated(selectedNode.getNode(), node.getNode(), RelationshipType.withName(parameterName))) {
                  final java.util.List<String> parameterKeys = new ArrayList<>();
                  parameterNode.getPropertyKeys().forEach(s -> {
                     if (s.startsWith("key_"))
                        parameterKeys.add(getString(parameterNode, s));
                  });

                  if (parameterKeys.containsAll(existingKeyValues)) {
                     domainMenu.add(new App.TransactionAction("Add " + NeoModel.getNameOrLabelFrom(selectedNode.getNode()) + " -> " + NeoModel.getNameOrLabelFrom(node.getNode()), app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {
                           selectedNode.getNode().createRelationshipTo(node.getNode(), RelationshipType.withName(parameterName));
                           app.events.fireNodeChanged(selectedNode.getNode().getId(), null, selectedNode.getNode());
                        }
                     });

                  } else {

                     // allow to map partial-key value list
                     domainMenu.add(new App.TransactionAction("Merge " + NeoModel.getNameOrLabelFrom(selectedNode.getNode()) + " " + parameterName + " -> " + NeoModel.getNameOrLabelFrom(node.getNode()), app) {
                        @Override
                        protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {

                           final JPanel editor = new JPanel(null);
                           editor.setLayout(new BoxLayout(editor, BoxLayout.PAGE_AXIS));
                           final JTextField[] txtNames = new JTextField[parameterKeys.size()];
                           final JComboBox<String>[] cboProperties = new JComboBox[parameterKeys.size()];
                           final JCheckBox[] chkUseProperties = new JCheckBox[parameterKeys.size()];
                           for (int i = 0; i < parameterKeys.size(); i++) {
                              final SwingUtil.FormPanel row = new SwingUtil.FormPanel("50dlu,4dlu,75dlu:grow,4dlu,50dlu:grow,4dlu,100dlu:grow", "pref");
                              row.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                              row.addLabel(parameterKeys.get(i), 1, 1);
                              row.add(txtNames[i] = new JTextField(30), 3, 1);
                              row.add(cboProperties[i] = new JComboBox(existingKeyValues.toArray()), 5, 1);
                              row.add(chkUseProperties[i] = new JCheckBox("Use properties", true), 7, 1);
                              editor.add(row);

                              int finalI = i;
                              txtNames[i].addKeyListener(new KeyAdapter() {
                                 @Override
                                 public void keyReleased(KeyEvent e) {
                                    chkUseProperties[finalI].setSelected(txtNames[finalI].getText().trim().length() == 0);
                                 }
                              });
                           }

                           SwingUtil.showDialog(editor, app, parameterName, new SwingUtil.OnSave() {
                              @Override
                              public void verifyAndSave() throws Exception {
                                 app.model.graph().doInTransaction(new NeoModel.Committer() {
                                    @Override
                                    public void doAction(Transaction tx) throws Throwable {
                                       final Map<String, String> newValues = new TreeMap<>();
                                       final Map<String, Boolean> useReference = new TreeMap<>();
                                       for (int i = 0; i < txtNames.length; i++) {
                                          final String newValue = txtNames[i].getText().trim();
                                          newValues.put(parameterKeys.get(i), newValue.trim());
                                          useReference.put(parameterKeys.get(i), chkUseProperties[i].isSelected());
                                       }
                                       if (newValues.isEmpty()) return;

                                       final Node keyValueNode = app.model.graph().getGraphDb().createNode(Entities._KeyValue);
                                       keyValueNode.setProperty(AppMotif.Properties.name.name(), parameterName);
                                       parameterNode.createRelationshipTo(keyValueNode, Relations.KEY_VALUE);
                                       selectedNode.getNode().createRelationshipTo(keyValueNode, RelationshipType.withName(parameterName));
                                       app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(keyValueNode));

                                       for (Map.Entry<String, String> kvEntry : newValues.entrySet()) {
                                          if (useReference.get(kvEntry.getKey())) {

                                             final Relationship existingRelation = singleOutgoing(node.getNode(), RelationshipType.withName(kvEntry.getKey()));
                                             final Node valueNode = other(node.getNode(), existingRelation);

                                             final Relationship valueRelation = keyValueNode.createRelationshipTo(valueNode, RelationshipType.withName(kvEntry.getKey()));
                                             for (String k : existingRelation.getPropertyKeys())
                                                valueRelation.setProperty(k, existingRelation.getProperty(k));
                                          } else {
                                             final Node valueNode = app.model.graph().getGraphDb().createNode(Entities._Value);
                                             valueNode.setProperty(AppMotif.Properties.name.name(), kvEntry.getValue());
                                             app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(valueNode));

                                             final Relationship valueRelation = keyValueNode.createRelationshipTo(valueNode, RelationshipType.withName(kvEntry.getKey()));
                                             valueRelation.setProperty(Properties._referenceType.name(), ReferenceType.PROPERTY.name());
                                             valueRelation.setProperty(Properties._referenceProperty.name(), AppMotif.Properties.name.name());
                                          }
                                       }

                                       app.events.fireNodeChanged(node.getNode().getId(), null, node.getNode());
                                    }

                                    @Override
                                    public void exception(Throwable throwable) {
                                       SwingUtil.showException(editor, throwable);
                                    }
                                 });
                              }
                           });
                        }
                     });
                  }
               }
            });
            if (domainMenu.getMenuComponents().length > 0) pop.add(domainMenu);
         }));
      }
   }

   private static void handle_STGroup(JPopupMenu pop, Workspace.NodeCanvas.NeoNode node, App app) {
      pop.add(new App.TransactionAction("Add template", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Template name", app);
            if (name == null || name.length() == 0) return;

            final AtomicBoolean exists = new AtomicBoolean(false);
            outgoing(node.getNode(), Relations.STTEMPLATE).forEach(relationship -> {
               if (name.equalsIgnoreCase(getOtherProperty(node.getNode(), relationship, AppMotif.Properties.name.name()).toString()))
                  exists.set(true);
            });
            if (exists.get()) {
               SwingUtil.showMessage(name + " already exists for group ", app);
               return;
            }

            final Node newNode = app.model.graph().newNode(Entities._STTemplate, AppMotif.Properties.name.name(), name);
            node.getNode().createRelationshipTo(newNode, Relations.STTEMPLATE);
            app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(newNode));
         }
      });
   }

   private static void handle_STTemplate(JPopupMenu pop, Workspace.NodeCanvas.NeoNode node, App app) {
      pop.add(new App.TransactionAction("New " + getNameOrLabelFrom(node.getNode()) + " instance", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) {

            final String name = SwingUtil.showInputDialog("Statement name", app);
            if (name == null || name.length() == 0) return;

            final Node newNode = app.model.graph().newNode(Label.label(getString(node.getNode(), AppMotif.Properties.name.name())), AppMotif.Properties.name.name(), name);
            node.getNode().createRelationshipTo(newNode, Relations.TEMPLATE);
            tryToSetNameParameter(name, newNode, node.getNode(), app);

            app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(newNode));
         }
      });

      pop.add(new App.TransactionAction("Show all", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) {
            app.events.fireNodeLoad(TemplateMotif.getAllStatementsOfType(app, node.getNode()));
         }
      });
   }

   static void tryToSetNameParameter(String name, Node newNode, Node templateNode, App app) {
      outgoing(templateNode, Relations.TEMPLATE_PARAMETER).forEach(relationship -> {
         final Node parameterNode = other(templateNode, relationship);
         final String parameterName = getString(parameterNode, AppMotif.Properties.name.name());
         if (parameterNode.hasProperty(Properties._deprecated.name()))
            return;

         if (hasLabel(parameterNode, Entities._Single) && AppMotif.Properties.name.name().equals(getString(parameterNode, AppMotif.Properties.name.name()))) {
            final Node valueNode = app.model.graph().getGraphDb().createNode(Entities._Value);
            valueNode.setProperty(AppMotif.Properties.name.name(), name);
            app.events.fireNodeLoad(new AppEvents.NodeLoadEvent(valueNode));
            final Relationship valueRelation = newNode.createRelationshipTo(valueNode, RelationshipType.withName(parameterName));
            valueRelation.setProperty(Properties._referenceType.name(), ReferenceType.PROPERTY.name());
            valueRelation.setProperty(Properties._referenceProperty.name(), AppMotif.Properties.name.name());
         }
      });
   }

   static String getValue(Node node, String parameterName) {
      // todo assumes value-nodes here, add statement
      final Relationship parameterRelation = singleOutgoing(node, RelationshipType.withName(parameterName));
      if (parameterRelation == null) return "";
      switch (ReferenceType.valueOf(getString(parameterRelation, Properties._referenceType.name()))) {
         case PROPERTY:
            return getString(other(node, parameterRelation), getString(parameterRelation, Properties._referenceProperty.name()));
      }
      return "";
   }

   static String render(Node node, Node templateNode, NeoModel graph) {

      // eom() and gt() are templates that will be available to all templates by default (they are bugfixes from StringTemplate)
      final STGroupString group = new STGroupString("wrapper", "eom() ::= <<}>>\ngt() ::= <<> >>", '~', '~');
      group.registerRenderer(String.class, new DefaultAttributeRenderer());
      group.setListener(new STErrorListener() {
         @Override
         public void compileTimeError(STMessage stMessage) {
            System.out.println(stMessage.toString());
         }

         @Override
         public void runTimeError(STMessage msg) {
            if (msg.error == ErrorType.NO_SUCH_ATTRIBUTE) return;
            System.out.println(msg.toString());
         }

         @Override
         public void IOError(STMessage stMessage) {
            System.out.println(stMessage.toString());
         }

         @Override
         public void internalError(STMessage stMessage) {
            System.out.println(stMessage.toString());
         }
      });

      final ST template = new ST(group, getString(templateNode, Properties._text.name()));

      outgoing(templateNode, Relations.TEMPLATE_PARAMETER).forEach(relationship -> {
         final Node parameterNode = other(templateNode, relationship);
         final String parameterName = getString(parameterNode, AppMotif.Properties.name.name());
         // do not use if its deprecated
         if (parameterNode.hasProperty(Properties._deprecated.name())) return;

         if (hasLabel(parameterNode, Entities._Single)) {

            final Relationship valueRelation = singleOutgoing(node, RelationshipType.withName(parameterName));
            if (valueRelation == null) return;

            switch (ReferenceType.valueOf(getString(valueRelation, Properties._referenceType.name()))) {
               case PROPERTY:
                  template.add(parameterName, getString(other(node, valueRelation), getString(valueRelation, Properties._referenceProperty.name())));
                  break;
               case STATEMENT:
                  graph.findNodes(Entities._STTemplate, AppMotif.Properties.name.name(), getString(valueRelation, Properties._referenceProperty.name())).forEachRemaining(renderTemplate -> template.add(parameterName, render(other(node, valueRelation), renderTemplate, graph)));
                  break;
            }

         } else if (hasLabel(parameterNode, Entities._List)) {
            outgoing(node, RelationshipType.withName(parameterName)).forEach(valueRelation -> {
               switch (ReferenceType.valueOf(getString(valueRelation, Properties._referenceType.name()))) {
                  case PROPERTY:
                     template.add(parameterName, getString(other(node, valueRelation), getString(valueRelation, Properties._referenceProperty.name())));
                     break;
                  case STATEMENT:
                     graph.findNodes(Entities._STTemplate, AppMotif.Properties.name.name(), getString(valueRelation, Properties._referenceProperty.name())).forEachRemaining(renderTemplate -> template.add(parameterName, render(other(node, valueRelation), renderTemplate, graph)));
                     break;
               }
            });

         } else if (hasLabel(parameterNode, Entities._KeyValueList)) {

            final java.util.List<String> keys = new ArrayList<>();
            parameterNode.getPropertyKeys().forEach(s -> {
               if (s.startsWith("key_")) keys.add(getString(parameterNode, s));
            });

            outgoing(node, RelationshipType.withName(parameterName)).forEach(keyValueRelation -> {

               final Node keyValueNode = other(node, keyValueRelation);

               final Map<String, String> aggrValues = new LinkedHashMap<>();
               final StringBuilder aggr = new StringBuilder(parameterName + ".{");
               boolean first = true;
               for (String key : keys) {
                  final Relationship valueRelation = singleOutgoing(keyValueNode, RelationshipType.withName(key));
                  if (valueRelation == null) continue;

                  if (!first) aggr.append(",");
                  first = false;
                  aggr.append(key);

                  if (!valueRelation.hasProperty(Properties._referenceType.name()))
                     throw new IllegalStateException(getString(parameterNode, AppMotif.Properties.name.name()) + " missing " + Properties._referenceType.name());
                  if (!valueRelation.hasProperty(Properties._referenceProperty.name()))
                     throw new IllegalStateException(getString(parameterNode, AppMotif.Properties.name.name()) + " missing " + Properties._referenceProperty.name());

                  switch (ReferenceType.valueOf(getString(valueRelation, Properties._referenceType.name()))) {
                     case PROPERTY:
                        aggrValues.put(key, getString(other(keyValueNode, valueRelation), getString(valueRelation, Properties._referenceProperty.name())));
                        break;
                     case STATEMENT:
                        graph.findNodes(Entities._STTemplate, AppMotif.Properties.name.name(), getString(valueRelation, Properties._referenceProperty.name())).forEachRemaining(renderTemplate -> aggrValues.put(key, getString(other(keyValueNode, valueRelation), render(other(keyValueNode, valueRelation), renderTemplate, graph))));
                        break;
                  }
               }

               final Object[] values = new Object[aggrValues.keySet().size()];
               int index = 0;
               for (String key : aggrValues.keySet())
                  values[index++] = aggrValues.get(key);
               aggr.append("}");
               if (values.length > 0)
                  template.addAggr(aggr.toString(), values);
            });
         }
      });

      return template.render();
   }

   private enum FormatCode {
      capitalize, toUpper, lowFirst, toLower, humpToCap, camelHump, splitCamelHump, packageToPath
   }

   private static final class DefaultAttributeRenderer implements org.stringtemplate.v4.AttributeRenderer {

      @Override
      public String toString(Object o, String formatString, Locale locale) {

         final String text = o.toString();

         if (formatString == null) return text;

         switch (FormatCode.valueOf(formatString)) {
            case capitalize:
               return capitalize(text);
            case toUpper:
               return toUpper(text);
            case lowFirst:
               return lowFirst(text);
            case toLower:
               return text.toLowerCase();
            case humpToCap:
               return humpToCap(text);
            case camelHump:
               return camelHump(text);
            case splitCamelHump:
               return splitCamelHump(text);
            case packageToPath:
               return packageToPath((text));
            default:
               return o.toString();
         }
      }

      private String capitalize(String string) {
         if (string == null || string.length() == 0) return "";
         return Character.toUpperCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
      }

      private String lowFirst(String string) {
         if (string == null || string.length() == 0) return "";
         return Character.toLowerCase(string.charAt(0)) + (string.length() > 1 ? string.substring(1) : "");
      }

      private String toUpper(String text) {
         return text.toUpperCase();
      }

      private String humpToCap(String text) {
         final char[] chars = text.toCharArray();
         final StringBuilder out = new StringBuilder();
         boolean first = true;
         for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!first && Character.isUpperCase(aChar) && (i < chars.length - 2 && Character.isLowerCase(chars[i + 1]))) {
               out.append("_");
            }
            first = false;
            out.append(Character.toUpperCase(aChar));
         }
         return out.toString();
      }

      private String camelHump(String text) {
         final char[] chars = text.toCharArray();
         final StringBuilder out = new StringBuilder();
         boolean capitalize = true;
         for (char aChar : chars) {
            if (Character.isWhitespace(aChar)) {
               capitalize = true;
               continue;
            }
            out.append(capitalize ? Character.toUpperCase(aChar) : aChar);
            capitalize = false;
         }
         return out.toString();
      }

      private String splitCamelHump(String text) {
         final char[] chars = text.toCharArray();
         final StringBuilder out = new StringBuilder();
         boolean first = true;
         for (char aChar : chars) {
            if (Character.isUpperCase(aChar)) out.append(" ");
            out.append(first ? Character.toUpperCase(aChar) : Character.toLowerCase(aChar));
            first = false;
         }
         return out.toString();
      }

      private String packageToPath(String packageName) {
         return (packageName == null ? "" : (packageName.replaceAll("[.]", "/") + File.separator));
      }
   }
}
