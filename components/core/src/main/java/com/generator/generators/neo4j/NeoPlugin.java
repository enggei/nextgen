package com.generator.generators.neo4j;

import com.generator.app.App;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.jgoodies.JGoodiesGroup;
import com.generator.util.*;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created 29.04.18.
 */
public class NeoPlugin extends Neo4jDomainPlugin {

//   public enum Cardinality {
//      ONE_TO_ONE, ONE_TO_MANY, MANY_TO_ONE, MANY_TO_MANY
//   }

   public NeoPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.NeoDomain);

      menu.add(new App.TransactionAction("New Domain", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            fireNodesLoaded(newNeoDomain(null, name, null, null));
         }
      });
   }

   @Override
   protected void handleNeoDomain(JPopupMenu pop, NeoNode neoDomainNode, Set<NeoNode> selectedNodes) {

      if (hasPackageNameProperty(neoDomainNode.getNode()) && hasRootProperty(neoDomainNode.getNode())) {
         pop.add(new App.TransactionAction("Generate Domain and Cypher", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String packageName = getPackageNameProperty(neoDomainNode.getNode());
               final String root = getRootProperty(neoDomainNode.getNode());
               final String name = getNameProperty(neoDomainNode.getNode());
               final String description = getDescriptionProperty(neoDomainNode.getNode());

               final NeoDomainGenerator domain = new NeoDomainGenerator(name, description);

               new NeoDomainVisitor() {
                  @Override
                  protected void visitNeoRelation(NeoDomainGenerator.NeoRelation neoRelation, NeoDomainGenerator.NeoEntity src, NeoDomainGenerator.NeoEntity dst) {
                     domain.add(neoRelation);
                  }

                  @Override
                  protected void visitNeoEntity(NeoDomainGenerator.NeoEntity neoEntity) {
                     domain.add(neoEntity);
                  }
               }.visit(neoDomainNode.getNode());

               GeneratedFile.newJavaFile(root, packageName, name).write(domain.toDomain(packageName));
               GeneratedFile.newJavaFile(root, packageName, name + "Cypher").write(domain.toCypherDomain(packageName));
            }
         });

         pop.add(new App.TransactionAction("Generate Pojos", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String packageName = getPackageNameProperty(neoDomainNode.getNode());
               final String root = getRootProperty(neoDomainNode.getNode());
               final String name = getNameProperty(neoDomainNode.getNode());
               final String description = getDescriptionProperty(neoDomainNode.getNode());

               final NeoDomainGenerator domain = new NeoDomainGenerator(name, description);

               new NeoDomainVisitor() {
                  @Override
                  protected void visitNeoRelation(NeoDomainGenerator.NeoRelation neoRelation, NeoDomainGenerator.NeoEntity src, NeoDomainGenerator.NeoEntity dst) {
                     domain.add(neoRelation);
                  }

                  @Override
                  protected void visitNeoEntity(NeoDomainGenerator.NeoEntity neoEntity) {
                     domain.add(neoEntity);
                  }
               }.visit(neoDomainNode.getNode());

               GeneratedFile.newJavaFile(root, packageName, name + "Pojos").write(domain.toPojos(packageName));
            }
         });

         pop.add(new App.TransactionAction("Generate Verticle", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String packageName = getPackageNameProperty(neoDomainNode.getNode());
               final String root = getRootProperty(neoDomainNode.getNode());
               final String name = getNameProperty(neoDomainNode.getNode());
               final String description = getDescriptionProperty(neoDomainNode.getNode());

               final NeoDomainGenerator domain = new NeoDomainGenerator(name, description);

               new NeoDomainVisitor() {
                  @Override
                  protected void visitNeoRelation(NeoDomainGenerator.NeoRelation neoRelation, NeoDomainGenerator.NeoEntity src, NeoDomainGenerator.NeoEntity dst) {
                     domain.add(neoRelation);
                  }

                  @Override
                  protected void visitNeoEntity(NeoDomainGenerator.NeoEntity neoEntity) {
                     domain.add(neoEntity);
                  }

                  @Override
                  protected void visitNeoFunction(NeoDomainGenerator.NeoFunction neoFunction) {
                     domain.add(neoFunction);
                  }
               }.visit(neoDomainNode.getNode());

               GeneratedFile.newJavaFile(root, packageName, name + "Verticle").write(domain.toVerticle(packageName));
            }
         });

         pop.add(new App.TransactionAction("Generate Swing", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String packageName = getPackageNameProperty(neoDomainNode.getNode());
               final String root = getRootProperty(neoDomainNode.getNode());
               final String name = getNameProperty(neoDomainNode.getNode());
               final String description = getDescriptionProperty(neoDomainNode.getNode());

               final NeoDomainGenerator domain = new NeoDomainGenerator(name, description);

               new NeoDomainVisitor() {
                  @Override
                  protected void visitNeoRelation(NeoDomainGenerator.NeoRelation neoRelation, NeoDomainGenerator.NeoEntity src, NeoDomainGenerator.NeoEntity dst) {
                     domain.add(neoRelation);
                  }

                  @Override
                  protected void visitNeoEntity(NeoDomainGenerator.NeoEntity neoEntity) {
                     domain.add(neoEntity);
                  }
               }.visit(neoDomainNode.getNode());

               GeneratedFile.newJavaFile(root, packageName, name + "Pojos").write(domain.toPojos(packageName));
            }
         });
      }
   }

   @Override
   protected void handleNeoEntity(JPopupMenu pop, NeoNode neoEntityNode, Set<NeoNode> selectedNodes) {
      super.handleNeoEntity(pop, neoEntityNode, selectedNodes);

      if (selectedNodes.isEmpty()) {

         pop.add(new App.TransactionAction("Add Relation to", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final SwingUtil.FormPanel formPanel = new SwingUtil.FormPanel("50dlu,4dlu,75dlu", "pref,4dlu,pref,4dlu,pref");

               final JTextField txtRelation = new JTextField();
               final JComboBox<Cardinality> cboCardinality = new JComboBox<>(Cardinality.values());
               final JTextField txtEntityName = new JTextField();

               formPanel.addLabel("Relation name", 1, 1);
               formPanel.add(txtRelation, 3, 1);
               formPanel.addLabel("Cardinality", 1, 3);
               formPanel.add(cboCardinality, 3, 3);
               formPanel.addLabel("Entity name", 1, 5);
               formPanel.add(txtEntityName, 3, 5);

               SwingUtil.showDialog(formPanel, app, "New relation", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {
                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx) throws Throwable {

                           final String entityName = txtEntityName.getText().trim();
                           final String relationName = txtRelation.getText().trim().toUpperCase();
                           final Cardinality cardinality = (Cardinality) cboCardinality.getSelectedItem();

                           if (entityName.length() == 0 || relationName.length() == 0)
                              throw new IllegalArgumentException("Must have entity and relation name");

                           final Node domainNode = singleIncomingENTITIES(neoEntityNode.getNode());

                           final Single<Node> entityNode = new Single<>();
                           outgoingENTITIES(domainNode, (relationship, node) -> {
                              if (getNameProperty(node, "").equals(entityName)) {
                                 entityNode.setValue(node);
                              }
                           });

                           if (!entityNode.hasValue()) {
                              final Node neoEntity = newNeoEntity(entityName);
                              relateENTITIES(domainNode, neoEntity);
                              entityNode.setValue(neoEntity);
                           }

                           final Node neoRelation = newNeoRelation(relationName, cardinality.name());
                           relateRELATIONS(domainNode, neoRelation);
                           relateSRC(neoRelation, neoEntityNode.getNode());
                           relateDST(neoRelation, entityNode.getValue());

                           fireNodesLoaded(neoRelation, entityNode.getValue());
                        }

                        @Override
                        public void exception(Throwable throwable) {
                           SwingUtil.showException(app, throwable);
                        }
                     });
                  }
               });
            }
         });

         pop.add(new App.TransactionAction("Add NeoProperties", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Set<Map<String, JComponent>> propertyMap = new LinkedHashSet<>();
               final JGoodiesGroup.layoutST rows = new JGoodiesGroup().newlayout();
               final JGoodiesGroup.layoutST columns = new JGoodiesGroup().newlayout();
               for (int i = 0; i < 5; i++) {
                  final Map<String, JComponent> componentMap = new LinkedHashMap<>();

                  componentMap.put("name", new JTextField());
                  if (i == 0) columns.addElementsValue("50dlu").addElementsValue("4dlu").addElementsValue("50dlu");

                  componentMap.put("required", new JCheckBox("Required"));
                  if (i == 0)
                     columns.addElementsValue("4dlu").addElementsValue("50dlu").addElementsValue("4dlu").addElementsValue("10dlu");

                  componentMap.put("unique", new JCheckBox("Unique"));
                  if (i == 0)
                     columns.addElementsValue("4dlu").addElementsValue("50dlu").addElementsValue("4dlu").addElementsValue("10dlu");

                  componentMap.put("type", new JComboBox<>(NeoDomainGenerator.NeoPropertyType.values()));
                  if (i == 0)
                     columns.addElementsValue("4dlu").addElementsValue("50dlu").addElementsValue("4dlu").addElementsValue("75dlu");

                  componentMap.put("enums", new JTextField());
                  if (i == 0)
                     columns.addElementsValue("4dlu").addElementsValue("50dlu").addElementsValue("4dlu").addElementsValue("50dlu");

                  propertyMap.add(componentMap);

                  if (i > 0) rows.addElementsValue("4dlu");
                  rows.addElementsValue("pref");
               }

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel(columns.toString(), rows.toString());
               int row = 1;
               for (Map<String, JComponent> componentMap : propertyMap) {
                  editor.addLabel("Name", 1, row);
                  editor.add(componentMap.get("name"), 3, row);
                  editor.addLabel("Required", 5, row);
                  editor.add(componentMap.get("required"), 7, row);
                  editor.addLabel("Unique", 9, row);
                  editor.add(componentMap.get("unique"), 11, row);
                  editor.addLabel("Type", 13, row);
                  editor.add(componentMap.get("type"), 15, row);
                  editor.addLabel("Enums", 17, row);
                  editor.add(componentMap.get("enums"), 19, row);
                  row += 2;
               }
               editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

               SwingUtil.showDialog(editor, app, "New NeoProperties", new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {
                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx14) throws Throwable {

                           final Set<Node> nodes = new LinkedHashSet<>();
                           for (Map<String, JComponent> map : propertyMap) {
                              final String name = ((JTextField) map.get("name")).getText();
                              final Boolean required = ((JCheckBox) map.get("required")).isSelected();
                              final Boolean unique = ((JCheckBox) map.get("unique")).isSelected();
                              final NeoDomainGenerator.NeoPropertyType type = (NeoDomainGenerator.NeoPropertyType) ((JComboBox) map.get("type")).getSelectedItem();
                              final String enums = ((JTextField) map.get("enums")).getText().trim();

                              if (name.trim().length() == 0) continue;

                              if (NeoDomainGenerator.NeoPropertyType.Enum.equals(type))
                                 if (enums.length() == 0)
                                    throw new IllegalArgumentException("Enum type must have enum values");

                              final Node newNeoProperty = newNeoProperty(required, type.name(), name, unique);
                              for (String s : enums.split(" ")) {
                                 if (s.trim().length() == 0) continue;
                                 relatePROPERTYENUMS(newNeoProperty, newPropertyEnum(s));
                              }

                              relateENTITY_PROPERTIES(neoEntityNode.getNode(), newNeoProperty);
                              nodes.add(newNeoProperty);
                           }

                           fireNodesLoaded(nodes);
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

      } else if (selectedNodes.size() == 1 && isNeoEntity(selectedNodes.iterator().next().getNode())) {

         final NeoNode dstNeoEntity = selectedNodes.iterator().next();

         pop.add(new App.TransactionAction("Relate " + getNameProperty(neoEntityNode.getNode()) + " -> " + getNameProperty(dstNeoEntity.getNode()), app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final JTextField txtName = new JTextField();
               final JComboBox<NeoDomainGenerator.Cardinality> cboCardinality = new JComboBox<>(NeoDomainGenerator.Cardinality.values());

               final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref, 4dlu, pref");
               editor.addLabel("Relation name", 1, 1);
               editor.add(txtName, 3, 1);
               editor.addLabel("Cardinality", 1, 3);
               editor.add(cboCardinality, 3, 3);

               SwingUtil.showDialog(editor, app, "Relate " + getNameProperty(neoEntityNode.getNode()) + " -> " + getNameProperty(dstNeoEntity.getNode()), new SwingUtil.ConfirmAction() {
                  @Override
                  public void verifyAndCommit() throws Exception {
                     getGraph().doInTransaction(new NeoModel.Committer() {
                        @Override
                        public void doAction(Transaction tx14) throws Throwable {

                           final String name = StringUtil.toUpper(txtName.getText().trim());
                           final NeoDomainGenerator.Cardinality relationCardinality = NeoDomainGenerator.Cardinality.valueOf(cboCardinality.getSelectedItem().toString());

                           if (name.length() == 0)
                              throw new IllegalStateException("Relation Name is required");

                           final Node neoRelation = newNeoRelation(getGraph(), name, relationCardinality.name());
                           relateRELATIONS(singleIncomingENTITIES(neoEntityNode.getNode()), neoRelation);
                           relateSRC(neoRelation, neoEntityNode.getNode());
                           relateDST(neoRelation, dstNeoEntity.getNode());

                           fireNodesLoaded(neoRelation);
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

   @Override
   protected void handleNeoProperty(JPopupMenu pop, NeoNode neoPropertyNode, Set<NeoNode> selectedNodes) {
      super.handleNeoProperty(pop, neoPropertyNode, selectedNodes);

      if (selectedNodes.isEmpty() && NeoDomainGenerator.NeoPropertyType.Enum.name().equals(getTypeProperty(neoPropertyNode.getNode(), ""))) {
         pop.add(new App.TransactionAction("Add Enum-values", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String s = SwingUtil.showInputDialog("Separate enums by space", app);
               if (s == null || s.trim().length() == 0) return;

               final String[] enums = s.trim().toUpperCase().split("[ ]");
               if (enums.length == 0) return;

               final Map<String, Node> existingEnums = new LinkedHashMap<>();
               outgoingPROPERTYENUMS(neoPropertyNode.getNode(), (relationship, enumNode) -> existingEnums.put(getNameProperty(enumNode), enumNode));

               final Set<Node> addedEnums = new LinkedHashSet<>();
               for (String newenum : enums) {
                  if (existingEnums.containsKey(newenum)) continue;
                  final Node newPropertyEnum = newPropertyEnum(newenum);
                  relatePROPERTYENUMS(neoPropertyNode.getNode(), newPropertyEnum);
                  addedEnums.add(newPropertyEnum);
               }

               fireNodesLoaded(addedEnums);
            }
         });
      }
   }

   @Override
   protected JComponent newNeoDomainEditor(NeoNode neoDomainNode) {
      return new DomainPanel(neoDomainNode);
   }

   private class DomainPanel extends JPanel {
      DomainPanel(NeoNode neoNode) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea();
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);
         txtEditor.setEditable(false);
         txtEditor.setText(domainToString(neoNode.getNode()));
         txtEditor.setCaretPosition(0);

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }

   public static String domainToString(Node domainNode) {
      final StringBuilder out = new StringBuilder();

      out.append("Domain: ").append(getNameProperty(domainNode, "")).append("\n");

      final Map<Node, Set<String>> domainProperties = new LinkedHashMap<>();

      final Set<Node> visitedEntities = new LinkedHashSet<>();
      outgoingENTITIES(domainNode, new NeoUtil.RelationConsumer() {
         @Override
         public void accept(Relationship relationship, Node entityNode) {
            visitEntity(entityNode);
         }

         public void visitEntity(Node entityNode) {

            if (visitedEntities.contains(entityNode)) return;
            visitedEntities.add(entityNode);

            out.append("\n\n\t").append(getNameProperty(entityNode, ""));


            final AtomicBoolean first = new AtomicBoolean(true);
            outgoingENTITY_PROPERTIES(entityNode, (relationship, propertyNode) -> {
               out.append(first.get() ? " (" : ", ").append(getNameProperty(propertyNode, ""));
               first.set(false);

               domainProperties.put(propertyNode, new TreeSet<>());
               outgoingPROPERTYENUMS(propertyNode, (relationship14, propertyEnumNode) -> domainProperties.get(propertyNode).add(getNameProperty(propertyEnumNode, "?")));

            });
            if (!first.get()) out.append(")");

            incomingSRC(entityNode, (relationship, relationNode) -> {

               out.append("\n\t\t").append(getCardinalityProperty(relationNode).toString()).append(" ").append(getNameProperty(relationNode, ""));

               first.set(true);
               outgoingRELATION_PROPERTIES(relationNode, (relationship12, propertyNode) -> {
                  out.append(first.get() ? " (" : ", ").append(getNameProperty(propertyNode, ""));
                  first.set(false);

                  domainProperties.put(propertyNode, new TreeSet<>());
                  outgoingPROPERTYENUMS(propertyNode, (relationship13, propertyEnumNode) -> domainProperties.get(propertyNode).add(getNameProperty(propertyEnumNode, "?")));
               });
               if (!first.get()) out.append(")");

               outgoingDST(relationNode, (relationship1, dstNode) -> {
                  out.append(" ").append(getNameProperty(dstNode, ""));
               });
            });
         }
      });

      out.append("\n");

      for (Map.Entry<Node, Set<String>> entry : domainProperties.entrySet()) {
         if (entry.getValue().isEmpty()) continue;

         out.append("\n\t").append(getNameProperty(entry.getKey(), "?"));

         boolean firstEnum = true;
         for (String enumName : entry.getValue()) {
            out.append(firstEnum ? " [ '" : "', '").append(enumName);
            firstEnum = false;
         }
         out.append("' ]");
      }

      return out.toString();
   }

   public static abstract class NeoDomainVisitor {

      public void visit(Node domainNode) {

         final Map<String, NeoDomainGenerator.NeoEntity> entityMap = new LinkedHashMap<>();

         outgoingENTITIES(domainNode, (entityRelation, entityNode) -> {

            final NeoDomainGenerator.NeoEntity neoEntity = new NeoDomainGenerator.NeoEntity(getNameProperty(entityNode, "NULL"));
            entityMap.put(getNameProperty(entityNode, "NULL"), neoEntity);

            outgoingENTITY_PROPERTIES(entityNode, (propertyRelation, propertyNode) -> {
               final NeoDomainGenerator.NeoProperty neoProperty = new NeoDomainGenerator.NeoProperty(getNameProperty(propertyNode), getIsRequiredProperty(propertyNode, Boolean.FALSE), getIsUniqueProperty(propertyNode, Boolean.FALSE), NeoDomainGenerator.NeoPropertyType.valueOf(getTypeProperty(propertyNode, "")));
               outgoingPROPERTYENUMS(propertyNode, (enumRelation, propertyEnumNode) -> neoProperty.addEnumValue(getNameProperty(propertyEnumNode)));
               neoEntity.add(neoProperty);
            });

            visitNeoEntity(neoEntity);
         });

         outgoingRELATIONS(domainNode, (relationRelation, relationNode) -> {

            final Node srcNode = singleOutgoingSRC(relationNode);
            if (srcNode == null) return;
            final Node dstNode = singleOutgoingDST(relationNode);
            if (dstNode == null) return;

            final NeoDomainGenerator.NeoRelation neoRelation = new NeoDomainGenerator.NeoRelation(getNameProperty(relationNode), getNameProperty(srcNode), getNameProperty(dstNode), NeoDomainGenerator.Cardinality.valueOf(getCardinalityProperty(relationNode)));

            outgoingRELATION_PROPERTIES(relationNode, (propertyRelation, propertyNode) -> {
               final NeoDomainGenerator.NeoProperty neoProperty = new NeoDomainGenerator.NeoProperty(getNameProperty(propertyNode), getIsRequiredProperty(propertyNode, Boolean.FALSE), getIsUniqueProperty(propertyNode, Boolean.FALSE), NeoDomainGenerator.NeoPropertyType.valueOf(getTypeProperty(propertyNode, "")));
               outgoingPROPERTYENUMS(propertyNode, (enumRelation, propertyEnumNode) -> neoProperty.addEnumValue(getNameProperty(propertyEnumNode)));
               neoRelation.add(neoProperty);
               neoRelation.add(neoProperty);
            });

            visitNeoRelation(neoRelation, entityMap.get(getNameProperty(srcNode, "NULL")), entityMap.get(getNameProperty(dstNode, "NULL")));
         });

         outgoingFUNCTIONS(domainNode, (entityRelation, functionNode) -> {

            final NeoDomainGenerator.NeoFunction neoFunction = new NeoDomainGenerator.NeoFunction(getNameProperty(functionNode, "NULL"));

            outgoingENTITY_PROPERTIES(functionNode, (propertyRelation, propertyNode) -> {
               final NeoDomainGenerator.NeoProperty neoProperty = new NeoDomainGenerator.NeoProperty(getNameProperty(propertyNode), getIsRequiredProperty(propertyNode, Boolean.FALSE), getIsUniqueProperty(propertyNode, Boolean.FALSE), NeoDomainGenerator.NeoPropertyType.valueOf(getTypeProperty(propertyNode, "")));
               outgoingPROPERTYENUMS(propertyNode, (enumRelation, propertyEnumNode) -> neoProperty.addEnumValue(getNameProperty(propertyEnumNode)));
               neoFunction.add(neoProperty);
            });

            visitNeoFunction(neoFunction);
         });
      }

      protected void visitNeoRelation(NeoDomainGenerator.NeoRelation neoRelation, NeoDomainGenerator.NeoEntity src, NeoDomainGenerator.NeoEntity dst) {

      }

      protected void visitNeoEntity(NeoDomainGenerator.NeoEntity neoEntity) {

      }

      protected void visitNeoFunction(NeoDomainGenerator.NeoFunction neoFunction) {

      }
   }
}