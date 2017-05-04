package com.generator.generators.meta;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.meta.MetaDomain.Entities.*;
import static com.generator.generators.meta.MetaDomain.Relations.*;
import static com.generator.generators.templates.TemplateDomain.Entities.SingleValue;

/**
 * Created 18.03.17.
 */
public class MetaDomainImpl extends MetaDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {

      domainMenu.add(editor.newAddNodeAction(Domain, MetaDomain.Properties.name.name(), event));

      domainMenu.add(new NeoEditor.TransactionAction("Parse Domain", editor) {

         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final JTextArea textArea = new JTextArea(800, 600);
            textArea.setFont(new Font("Hack", Font.PLAIN, 10));
            SwingUtil.showTextInput("Json", textArea, editor.getCanvas(), () -> {

               final AtomicBoolean success = new AtomicBoolean(true);

               editor.getGraph().doInTransaction(new NeoModel.Committer() {
                  @Override
                  public void doAction(Transaction tx1) throws Throwable {

                     final JsonObject domain = new JsonObject(textArea.getText().trim());

                     final Node newDomain = graph.newNode(Domain);
                     newDomain.setProperty(Properties.name.name(), domain.getString("name"));
                     newDomain.setProperty(Properties.packageName.name(), domain.getString("packageName", ""));

                     final Map<String, Node> entitiesIndex = new LinkedHashMap<>();
                     for (Object element : domain.getJsonArray("entities", new JsonArray())) {
                        final JsonObject entity = (JsonObject) element;

                        final Node newEntity = editor.getGraph().newNode(Entity);
                        newEntity.setProperty(Properties.name.name(), entity.getString("name"));
                        newEntity.setProperty(Properties.color.name(), entity.getString("color", "#000000"));
                        newEntity.setProperty(Properties.root.name(), entity.getBoolean("root", false));
                        newEntity.setProperty(Properties.label.name(), entity.getString("label", "name"));
                        newDomain.createRelationshipTo(newEntity, Relations.ENTITY);

                        for (Object pElement : entity.getJsonArray("properties", new JsonArray())) {
                           final JsonObject property = (JsonObject) pElement;

                           final Node newProperty = editor.getGraph().newNode(Property);
                           newProperty.setProperty(Properties.name.name(), property.getString("name"));
                           newProperty.setProperty(Properties.type.name(), property.getString("type"));
                           if ("Enum".equals(property.getString("type"))) {
                              for (Object val : property.getJsonArray("values", new JsonArray())) {

                                 final Node newSingleValue = editor.getGraph().newNode(SingleValue);
                                 newSingleValue.setProperty(Properties.value.name(), val);

                                 final Relationship relationship = newProperty.createRelationshipTo(newSingleValue, ENUM_VALUE);
                                 relationship.setProperty("property", Properties.value.name());
                              }
                           }
                           newEntity.createRelationshipTo(newProperty, Relations.PROPERTY);
                        }

                        entitiesIndex.put(entity.getString("name"), newEntity);
                     }

                     for (Object element : domain.getJsonArray("relations", new JsonArray())) {
                        final JsonObject relation = (JsonObject) element;

                        final Node newRelation = editor.getGraph().newNode(Relation);
                        newRelation.setProperty(Properties.name.name(), relation.getString("name"));
                        newRelation.setProperty(Properties.cardinality.name(), relation.getString("cardinality"));
                        newDomain.createRelationshipTo(newRelation, Relations.RELATION);

                        for (Object srcElement : relation.getJsonArray("src", new JsonArray()))
                           entitiesIndex.get(srcElement + "").createRelationshipTo(newRelation, Relations.SRC);

                        for (Object dstElement : relation.getJsonArray("dst", new JsonArray()))
                           newRelation.createRelationshipTo(entitiesIndex.get(dstElement + ""), Relations.DST);
                     }

                     editor.show(NeoModel.uuidOf(newDomain), Domain.name()).setOffset(event);
                  }

                  @Override
                  public void exception(Throwable throwable) {
                     //SwingUtil.showException(editor.getCanvas(), throwable);
                     success.set(false);
                  }
               });

               if (!success.get()) throw new IllegalArgumentException("Invalid json content");
            });
         }
      });
   }

   @Override
   protected NeoPNode newDomainPNode(Node node, NeoEditor neoEditor) {
      return new DomainPNode(node, neoEditor) {

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(editor.newSetNodePropertyAction(Properties.name.name(), this));

            pop.add(new NeoEditor.TransactionAction("Add Entities", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final JTextField[] fields = new JTextField[5];

                  final StringBuilder rows = new StringBuilder();
                  for (int i = 0; i < fields.length; i++) {
                     if (i >= 1) rows.append(", 4dlu, ");
                     rows.append("pref");
                     fields[i] = new JTextField();
                  }

                  final SwingUtil.FormPanel component = new SwingUtil.FormPanel("150dlu", rows.toString().trim());
                  component.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                  int row = 1;
                  for (JTextField field : fields) {
                     component.add(field, 1, row);
                     row += 2;
                  }

                  SwingUtil.showApplyCloseDialog(component, editor.getCanvas(), "Entities", new SwingUtil.OnSave() {
                     @Override
                     public void verifyAndSave() throws Exception {
                        editor.doInTransaction(tx1 -> {
                           for (JTextField field : fields) {
                              final String name = field.getText().trim();
                              if (name.length() == 0) continue;

                              final Node newNode = editor.getGraph().newNode(Entity);
                              newNode.setProperty(Properties.name.name(), name);
                              node.createRelationshipTo(newNode, Relations.ENTITY);

                              editor.show(uuidOf(newNode), Entity.name()).
                                    setOffset(event);
                           }
                        });

                        for (JTextField field : fields)
                           field.setText("");
                     }
                  });
               }
            });

            pop.add(new NeoEditor.TransactionAction("Add Relations", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final JTextField[] fields = new JTextField[5];

                  final StringBuilder rows = new StringBuilder();
                  for (int i = 0; i < fields.length; i++) {
                     if (i >= 1) rows.append(", 4dlu, ");
                     rows.append("pref");
                     fields[i] = new JTextField();
                  }

                  final SwingUtil.FormPanel component = new SwingUtil.FormPanel("150dlu", rows.toString().trim());
                  component.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                  int row = 1;
                  for (JTextField field : fields) {
                     component.add(field, 1, row);
                     row += 2;
                  }

                  SwingUtil.showApplyCloseDialog(component, editor.getCanvas(), "Relations", new SwingUtil.OnSave() {
                     @Override
                     public void verifyAndSave() throws Exception {
                        editor.doInTransaction(tx1 -> {
                           for (JTextField field : fields) {
                              final String name = field.getText().trim();
                              if (name.length() == 0) continue;

                              final Node newNode = editor.getGraph().newNode(Relation);
                              newNode.setProperty(Properties.name.name(), name);
                              node.createRelationshipTo(newNode, Relations.RELATION);

                              editor.show(uuidOf(newNode), Relation.name()).
                                    setOffset(event);
                           }
                        });

                        for (JTextField field : fields)
                           field.setText("");
                     }
                  });
               }
            });

            pop.add(new NeoEditor.TransactionAction("Expand Relations", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  final Map<UUID, Label> pNodes = new LinkedHashMap<>();
                  outgoing(node, RELATION).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Relation));
                  editor.showAndLayout(pNodes, pNode);
               }
            });

            pop.add(editor.newSetNodePropertyAction(Properties.packageName.name(), this));
            pop.add(editor.newSetNodePropertyAction(Properties.root.name(), this));

            pop.add(new NeoEditor.TransactionAction("Render Domain", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final JsonObject domain = new MetaDomainVisitor() {

                     final JsonObject result = new JsonObject();

                     @Override
                     protected <T> T visitDomain(Node node) {

                        result.put(Properties.name.name(), BaseDomainVisitor.getString(node, Properties.name.name()));
                        result.put(Properties.packageName.name(), BaseDomainVisitor.getString(node, Properties.packageName.name()));

                        final JsonArray entities = new JsonArray();
                        result.put("entities", entities);
                        for (Relationship entityRelation : BaseDomainVisitor.outgoing(node, Relations.ENTITY))
                           entities.add((JsonObject) visitEntity(other(node, entityRelation)));

                        final JsonArray relations = new JsonArray();
                        result.put("relations", relations);
                        for (Relationship entityRelation : BaseDomainVisitor.outgoing(node, Relations.RELATION))
                           relations.add((JsonObject) visitRelation(other(node, entityRelation)));
                        return (T) result;
                     }

                     @Override
                     protected <T> T visitEntity(Node node) {
                        final JsonObject result = new JsonObject();
                        result.put("name", getString(node, "name"));
                        result.put("color", getString(node, "color"));
                        final boolean isRoot = "true".equals(getString(node, "root"));
                        if (isRoot) result.put("root", true);

                        final JsonArray properties = new JsonArray();
                        result.put("properties", properties);
                        for (Relationship propertyRelation : BaseDomainVisitor.outgoing(node, Relations.PROPERTY)) {
                           final JsonObject property = visitProperty(other(node, propertyRelation));
                           properties.add(property);
                        }

                        return (T) result;
                     }

                     @Override
                     protected <T> T visitRelation(Node node) {
                        final JsonObject result = new JsonObject();
                        result.put("name", getString(node, "name"));
                        result.put("cardinality", getString(node, "cardinality"));

                        final JsonArray src = new JsonArray();
                        result.put("src", src);
                        for (Relationship relation : BaseDomainVisitor.incoming(node, Relations.SRC))
                           src.add("" + BaseDomainVisitor.getOtherProperty(node, relation, "name"));

                        final JsonArray dst = new JsonArray();
                        result.put("dst", dst);
                        for (Relationship relation : BaseDomainVisitor.outgoing(node, Relations.DST))
                           dst.add("" + BaseDomainVisitor.getOtherProperty(node, relation, "name"));

                        return (T) result;
                     }

                     @Override
                     protected <T> T visitProperty(Node node) {
                        final JsonObject result = new JsonObject();
                        result.put("name", getString(node, "name"));
                        result.put("type", getString(node, "type"));
                        final boolean isLabel = "true".equals(getString(node, "label"));
                        if (isLabel) result.put("label", true);

                        if ("Enum".equals(getString(node, "type"))) {
                           final JsonArray values = new JsonArray();
                           result.put("values", values);
                           for (Relationship relationship : outgoing(node, ENUM_VALUE)) {
                              final Node other = other(node, relationship);
                              values.add("" + other.getProperty(getString(relationship, "property")));
                           }
                        }

                        return (T) result;
                     }
                  }.visit(node);

                  SwingUtil.toClipboard(domain.encode());
                  System.out.println(domain.encodePrettily());
               }
            });

            final String root = getString(node, Properties.root.name());

            if (root != null) {

               pop.add(new NeoEditor.TransactionAction("Generate interfaces", editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final MetaDomainGroup group = new MetaDomainGroup();

                     new MetaDomainVisitor() {

                        private MetaDomainGroup.EntityInterfaceST entityInterface;
                        private String packageName;

                        @Override
                        protected <T> T visitDomain(Node node) {

                           packageName = BaseDomainVisitor.getString(node, Properties.packageName.name()) + ".domain";

                           for (Relationship entityRelation : BaseDomainVisitor.outgoing(node, Relations.ENTITY))
                              visitEntity(other(node, entityRelation));

                           return null;
                        }

                        @Override
                        protected <T> T visitEntity(Node node) {

                           entityInterface = group.newEntityInterface().
                                 setEntity(getString(node, Properties.name.name())).
                                 setPackageName(packageName);

                           for (Relationship relationship : BaseDomainVisitor.outgoing(node, PROPERTY)) {
                              final Node propertyNode = other(node, relationship);
                              entityInterface.addPropertiesValue(getString(propertyNode, Properties.name.name()), getString(propertyNode, Properties.type.name()));
                           }

                           for (Relationship src : BaseDomainVisitor.outgoing(node, Relations.SRC)) {
                              final Node relation = other(node, src);
                              final String relationName = getString(relation, "name");

                              for (Relationship dst : BaseDomainVisitor.outgoing(relation, Relations.DST)) {
                                 final String relationType = getString(other(relation, dst), "name");
                                 entityInterface.addRelationsValue(relationName, relationType);
                              }
                           }

                           final GeneratedFile javaFile = GeneratedFile.newJavaFile(root, packageName, StringUtil.capitalize(getString(node, Properties.name.name())));
                           try {
                              javaFile.write(entityInterface);
                           } catch (IOException e1) {
                              SwingUtil.showException(editor.getCanvas(), e1);
                           }

                           return null;
                        }
                     }.visit(node);
                  }
               });

               pop.add(new NeoEditor.TransactionAction("Generate java", editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     final MetaDomainGroup group = new MetaDomainGroup();
                     SwingUtil.toClipboard(new GenerateJavaDomain(group).visit(node));
                  }
               });
            }
            super.showNodeActions(pop, event);
         }

         @Override
         public final void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            outgoing(node, ENTITY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Entity));
            editor.showAndLayout(pNodes, pNode);
         }
      };
   }

   @Override
   protected NeoPNode newEntityPNode(Node node, NeoEditor neoEditor) {
      return new EntityPNode(node, neoEditor) {

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(editor.newSetNodePropertyAction(Properties.name.name(), this));
            pop.add(editor.newSetNodePropertyAction(Properties.color.name(), this));
            pop.add(editor.newSetNodePropertyAction(Properties.root.name(), this, new String[]{"true", "false"}));

            pop.add(new NeoEditor.TransactionAction("Set label", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final Set<String> availableProperties = new TreeSet<>();
                  for (Relationship propertyRelation : BaseDomainVisitor.outgoing(node, Relations.PROPERTY))
                     availableProperties.add(getString(other(node, propertyRelation), "name"));

                  final String value = SwingUtil.showSelectDialog(editor.canvas, availableProperties);
                  if (value == null) return;

                  node.setProperty(Properties.label.name(), value);
                  updateView();
               }
            });

            pop.add(new NeoEditor.TransactionAction("Add Relation from", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String name = SwingUtil.showInputDialog("Name", editor.canvas);
                  if (name == null) return;

                  // Relation, Properties.name.name(), RELATION, this, event
                  final Node newNode = editor.getGraph().newNode(Relation);
                  newNode.setProperty(Properties.name.name(), name);

                  final Node domainNode = other(node, singleIncoming(node, ENTITY));
                  domainNode.createRelationshipTo(newNode, Relations.RELATION);
                  node.createRelationshipTo(newNode, Relations.SRC);

                  editor.show(uuidOf(newNode), Relation.name()).
                        setOffset(event);

                  updateView();
               }
            });

            pop.add(new NeoEditor.TransactionAction("Add Property", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final JTextField[] fields = new JTextField[5];

                  final StringBuilder rows = new StringBuilder();
                  for (int i = 0; i < fields.length; i++) {
                     if (i >= 1) rows.append(", 4dlu, ");
                     rows.append("pref");
                     fields[i] = new JTextField();
                  }

                  final SwingUtil.FormPanel component = new SwingUtil.FormPanel("150dlu", rows.toString().trim());
                  component.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                  int row = 1;
                  for (JTextField field : fields) {
                     component.add(field, 1, row);
                     row += 2;
                  }

                  SwingUtil.showApplyCloseDialog(component, editor.getCanvas(), "Properties", new SwingUtil.OnSave() {
                     @Override
                     public void verifyAndSave() throws Exception {
                        editor.doInTransaction(tx1 -> {
                           for (JTextField field : fields) {
                              final String name = field.getText().trim();
                              if (name.length() == 0) continue;

                              final String[] s = name.split(" ");
                              final Node newNode = editor.getGraph().newNode(Property);
                              newNode.setProperty(Properties.name.name(), s[0]);
                              newNode.setProperty(Properties.type.name(), s.length > 1 ? s[1] : "String");
                              node.createRelationshipTo(newNode, Relations.PROPERTY);

                              editor.show(uuidOf(newNode), Property.name()).
                                    setOffset(event);
                           }
                        });

                        for (JTextField field : fields)
                           field.setText("");
                     }
                  });
               }
            });

            super.showNodeActions(pop, event);
         }

         @Override
         public void showTargetActions(JPopupMenu pop, PInputEvent event) {

            final Iterator<NeoPNode> selectedNodes = editor.getSelectedNodes().iterator();

            final Set<NeoPNode> propertyNodes = new LinkedHashSet<>();
            final Set<NeoPNode> entityNodes = new LinkedHashSet<>();
            while (selectedNodes.hasNext()) {
               final NeoPNode next = selectedNodes.next();
               if (hasLabel(next.node, Property.name())) propertyNodes.add(next);
               if (hasLabel(next.node, Entity.name())) entityNodes.add(next);
            }

            if (!propertyNodes.isEmpty()) {
               pop.add(new NeoEditor.TransactionAction("Add " + (propertyNodes.size() == 1 ? "Property" : "Properties"), editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     for (NeoPNode propertyNode : propertyNodes)
                        editor.addRelation(node.createRelationshipTo(propertyNode.node, Relations.PROPERTY));
                     updateView();
                  }
               });
            }

            if (!entityNodes.isEmpty()) {
               pop.add(new NeoEditor.TransactionAction("New Relation", editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final String name = SwingUtil.showInputDialog(Properties.name.name(), editor.canvas);
                     if (Properties.name.name() != null && name == null) return;

                     final Node newNode = editor.getGraph().newNode(Relation);
                     newNode.setProperty(Properties.name.name(), name);
                     final Node domainNode = other(node, singleIncoming(node, ENTITY));
                     editor.addRelation(domainNode.createRelationshipTo(newNode, RELATION));
                     editor.addRelation(newNode.createRelationshipTo(node, Relations.DST));

                     editor.show(uuidOf(newNode), Relation.name()).
                           setOffset(event);

                     for (NeoPNode neoPNode : entityNodes)
                        editor.addRelation(newNode.createRelationshipTo(neoPNode.node, Relations.SRC));
                     updateView();
                  }
               });
            }

            SwingUtilities.invokeLater(editor.canvas::repaint);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            outgoing(node, Relations.PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Property));
            outgoing(node, Relations.SRC).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Relation));
            editor.showAndLayout(pNodes, pNode);
         }
      };
   }

   @Override
   protected NeoPNode newRelationPNode(Node node, NeoEditor editor) {
      return new RelationPNode(node, editor) {

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(editor.newSetNodePropertyAction(Properties.name.name(), this));
            pop.add(editor.newSetNodePropertyAction(Properties.cardinality.name(), this, new String[]{"ONE", "MANY"}));

            pop.add(new NeoEditor.TransactionAction("Add Property", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String name = SwingUtil.showInputDialog("Name", editor.canvas);
                  if (name == null) return;

                  final Node newNode = editor.getGraph().newNode(Property);
                  final String[] s = name.split(" ");
                  newNode.setProperty(Properties.name.name(), s[0]);
                  newNode.setProperty(Properties.type.name(), s.length > 1 ? s[1] : "String");
                  node.createRelationshipTo(newNode, Relations.PROPERTY);

                  editor.show(uuidOf(newNode), Property.name()).
                        setOffset(event);

                  updateView();
               }
            });

            for (Relationship relationship : incoming(node, SRC)) {
               final Node srcNode = other(node, relationship);
               pop.add(new NeoEditor.TransactionAction("Remove SRC " + getString(srcNode, Properties.name.name()), editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     relationship.delete();
                  }
               });
            }

            for (Relationship relationship : outgoing(node, DST)) {
               final Node dstNode = other(node, relationship);
               pop.add(new NeoEditor.TransactionAction("Remove DST " + getString(dstNode, Properties.name.name()), editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     relationship.delete();
                  }
               });
            }

            super.showNodeActions(pop, event);
         }

         @Override
         public void showTargetActions(JPopupMenu pop, PInputEvent event) {

            final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
            if (selectedNodes.isEmpty()) return;

            final Iterator<NeoPNode> nodes = selectedNodes.iterator();

            final Set<NeoPNode> validNodes = new LinkedHashSet<>();
            while (nodes.hasNext()) {
               final NeoPNode neoPNode = nodes.next();
               if (hasLabel(neoPNode.node, Entity.name())) validNodes.add(neoPNode);
            }

            if (!validNodes.isEmpty()) {
               pop.add(new NeoEditor.TransactionAction("Source", editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     for (NeoPNode neoPNode : validNodes) {
                        final Node otherNode = neoPNode.node;
                        if (BaseDomainVisitor.isRelated(otherNode, node, Relations.SRC)) continue;
                        final Relationship newRelation = otherNode.createRelationshipTo(node, Relations.SRC);
                        editor.addRelation(newRelation);
                     }
                     updateView();
                  }
               });

               pop.add(new NeoEditor.TransactionAction("Destination", editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     for (NeoPNode neoPNode : validNodes) {
                        final Node otherNode = neoPNode.node;
                        if (BaseDomainVisitor.isRelated(node, otherNode, Relations.DST)) continue;
                        final Relationship newRelation = node.createRelationshipTo(otherNode, Relations.DST);
                        editor.addRelation(newRelation);
                     }
                     updateView();
                  }
               });
            }

            SwingUtilities.invokeLater(editor.canvas::repaint);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            outgoing(node, Relations.DST).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Entity));
            outgoing(node, Relations.PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Property));
            editor.showAndLayout(pNodes, pNode);
         }
      };
   }

   @Override
   protected NeoPNode newPropertyPNode(Node node, NeoEditor neoEditor) {
      return new PropertyPNode(node, neoEditor) {

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(editor.newSetNodePropertyAction(Properties.name.name(), this));
            pop.add(editor.newSetNodePropertyAction(Properties.type.name(), this));

            pop.add(new NeoEditor.TransactionAction("Set Enum values", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String values = SwingUtil.showInputDialog("Values (separated by space)", editor.canvas);
                  if (values == null) return;

                  node.setProperty(Properties.type.name(), "Enum");

                  for (Relationship oldData : outgoing(node, ENUM_VALUE)) {
                     // todo: delete other node ?
                     System.out.println("delete other node ENUM_VALUE relation, if unnused");
                     oldData.delete();
                  }

                  for (String val : values.split(" ")) {
                     final Node newNode = editor.getGraph().newNode(SingleValue);
                     newNode.setProperty(Properties.value.name(), val);

                     final Relationship relationship = node.createRelationshipTo(newNode, ENUM_VALUE);
                     relationship.setProperty(Properties.property.name(), Properties.value.name());
                  }
                  updateView();
               }
            });

            editor.showDeleteOutgoingRelations(pop, node);

            super.showNodeActions(pop, event);
         }
      };
   }


   @Override
   public void deleteNode(Node node) throws NeoEditor.ReferenceException {
      // todo enforce constraints, by node, and override (like newDomainPNode)


      if (hasLabel(node, Property.name())) {

         final Set<Relationship> constraints = new LinkedHashSet<>();
         node.getRelationships(Direction.INCOMING).forEach(relationship -> {
            final Node otherNode = other(node, relationship);
            if (hasLabel(otherNode, NeoModel.TAG_LAYOUT)) return;

            constraints.add(relationship);
         });

         if (!constraints.isEmpty()) throw new NeoEditor.ReferenceException(node, constraints);

         node.getRelationships(Direction.INCOMING).forEach(Relationship::delete);

      } else if (hasLabel(node, Entity.name())) {


//         final Set<Relationship> constrained = new LinkedHashSet<>();
         node.getRelationships(Direction.INCOMING).forEach(new Consumer<Relationship>() {
            @Override
            public void accept(Relationship relationship) {
               if (relationship.isType(Relations.ENTITY) && hasLabel(other(node, relationship), Entities.Domain))
                  relationship.delete();
//               else constrained.add(relationship);
            }
         });

         outgoing(node, Relations.RELATION).forEach(new Consumer<Relationship>() {
            @Override
            public void accept(Relationship relationship) {
               relationship.delete();
            }
         });


      } else if (hasLabel(node, Relation.name())) {

         node.getRelationships().forEach(new Consumer<Relationship>() {
            @Override
            public void accept(Relationship relationship) {
               relationship.delete();
            }
         });
      }

      super.deleteNode(node);
   }
}