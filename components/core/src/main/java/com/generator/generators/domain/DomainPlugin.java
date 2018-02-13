package com.generator.generators.domain;

import com.generator.ProjectConstants;
import com.generator.app.App;
import com.generator.app.AppMotif;
import com.generator.app.nodes.NeoNode;
import com.generator.generators.project.ProjectPlugin;
import com.generator.generators.stringtemplate.GeneratedFile;
import com.generator.generators.stringtemplate.StringTemplatePlugin;
import com.generator.neo.NeoModel;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;
import com.generator.util.Triple;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static com.generator.app.DomainMotif.*;
import static com.generator.generators.project.ProjectPlugin.*;
import static com.generator.util.NeoUtil.*;

/**
 * Created 06.08.17.
 */
public class DomainPlugin extends DomainDomainPlugin {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainPlugin.class);

   public enum RelationCardinality {
      SINGLE, LIST
   }

   public DomainPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Domain);
      addShowMenu(menu, Entities.Visitor);

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

            fireNodesLoaded(newDomain(name, null));
         }
      });
   }

   @Override
   protected void handleDomain(JPopupMenu pop, NeoNode domainNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Add Entity", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Entity name", app);
            if (name == null || name.length() == 0) return;

            final AtomicBoolean exists = new AtomicBoolean(false);
            new DomainVisitor<Void>(true) {
               @Override
               public void visitEntity(Node node) {
                  if (name.equals(getNameProperty(node))) exists.set(true);
                  super.visitEntity(node);
               }
            }.visit(domainNode.getNode());

            if (exists.get()) {
               SwingUtil.showMessage(name + " already exists for domain", app);
               return;
            }

            final Node newNode = newEntity(name);
            relateENTITY(domainNode.getNode(), newNode);
            fireNodesLoaded(newNode);
         }
      });

      pop.add(new App.TransactionAction("Expand Domain", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Set<Node> nodes = new LinkedHashSet<>();

            new DomainVisitor<Void>(true) {
               @Override
               public void visitDomain(Node node) {
                  super.visitDomain(node);
               }

               @Override
               public void visitEntity(Node node) {
                  nodes.add(node);
                  super.visitEntity(node);
               }

               @Override
               public void visitRelation(Node node) {
                  nodes.add(node);
                  super.visitRelation(node);
               }

               @Override
               public void visitProperty(Node node) {
                  nodes.add(node);
                  super.visitProperty(node);
               }
            }.visit(domainNode.getNode());

            fireNodesLoaded(nodes);
         }
      });

      pop.add(new App.TransactionAction("Create Plugin", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            if (!hasPackageNameProperty(domainNode.getNode())) {
               final String packageName = SwingUtil.showInputDialog("Package", app);
               if (packageName == null || packageName.length() == 0) return;
               setPackageNameProperty(domainNode.getNode(), packageName);
            }

            final String className = getNameProperty(domainNode.getNode()) + "DomainPlugin";

            final DomainPluginGroup domainPluginGroup = new DomainPluginGroup();
            final DomainPluginGroup.DomainPluginST domainPluginST = domainPluginGroup.newDomainPlugin().
                  setPackageName(getPackageNameProperty(domainNode.getNode())).
                  setName(className).
                  setTitle(getNameProperty(domainNode.getNode()));

            final Set<String> domainRelations = new LinkedHashSet<>();
            final Set<String> domainProperties = new LinkedHashSet<>();
            final Map<String, Set<String>> entityProperties = new LinkedHashMap<>();
            final Set<Relation> relations = new LinkedHashSet<>();
            new DomainVisitor<Object>(true) {

               @Override
               public void visitDomain(Node node) {
                  outgoingENTITY(node, (entityRelation, entity) -> {
                     domainRelations.add(getNameProperty(entity, "").toUpperCase());
                     domainPluginST.addRootRelationsValue(getNameProperty(entity));
                  });
                  super.visitDomain(node);
               }

               @Override
               public void visitEntity(Node node) {
                  if (!entityProperties.containsKey(getNameProperty(node)))
                     entityProperties.put(getNameProperty(node), new LinkedHashSet<>());

                  // get properties and entity-relations
                  outgoingSRC(node, (src, relationNode) -> outgoingDST(relationNode, (dst, dstNode) -> {
                     if (isProperty(dstNode)) {
                        entityProperties.get(getNameProperty(node)).add(getNameProperty(dstNode));
                     } else {
                        relations.add(new Relation(node, dstNode, getNameProperty(relationNode), getRelationCardinalityProperty(relationNode)));
                     }
                  }));

                  super.visitEntity(node);
               }

               @Override
               public void visitRelation(Node node) {

                  domainRelations.add(getNameProperty(node, "").toUpperCase());

                  // relation can be either to a Property or Entity
//                  final AtomicBoolean isProperty = new AtomicBoolean(false);
//                  outgoingDST(node, (relationship, dstNode) -> {
//                     if (isProperty(dstNode)) isProperty.set(true);
//                  });

                  // if Entity (not Property), add relation
//                  if (!isProperty.get()) {
//                     domainRelations.add(getNameProperty(node, "").toUpperCase());

                  // add entity-relations
//                     final LinkedHashMap<Node, String> relation = new LinkedHashMap<>();
//                     relation.put(node, getNameProperty(singleOutgoingDST(node)));
//
//                     incomingSRC(node, (relationship, srcNode) -> entityRelations.get(getNameProperty(srcNode)).add(relation));
//                     entityRelations.get(getNameProperty(singleIncomingSRC(node))).add(relation);
//                  }
                  super.visitRelation(node);
               }

               @Override
               public void visitProperty(Node node) {
                  domainProperties.add(getNameProperty(node));
                  super.visitProperty(node);
               }
            }.visitDomain(domainNode.getNode());

            for (String name : domainRelations) domainPluginST.addRelationsValue(name);
            for (String name : domainProperties) domainPluginST.addPropertiesValue(name);

            for (Map.Entry<String, Set<String>> entry : entityProperties.entrySet()) {

               final DomainPluginGroup.EntityMethodsST entityMethodsST = domainPluginGroup.newEntityMethods().
                     setName(entry.getKey());

               for (String propertyName : entry.getValue()) {
                  domainPluginST.addEntityPropertiesValue(entry.getKey(), propertyName);
                  entityMethodsST.addPropertiesValue(propertyName);
               }

               domainPluginST.addEntitiesValue(entityMethodsST, entry.getKey());
            }

            for (Relation relation : relations) {
               domainPluginST.addEntityRelationsValue(relation.cardinality, getNameProperty(relation.dst), relation.name, getNameProperty(relation.src));
            }

            GeneratedFile.newJavaFile(ProjectConstants.MAIN_ROOT, domainPluginST.getPackageName(), className).write(domainPluginST);
         }

         class Relation {
            private final Node src;
            private final Node dst;
            private final String name;
            private final String cardinality;

            public Relation(Node src, Node dst, String name, String cardinality) {
               this.src = src;
               this.dst = dst;
               this.name = name;
               this.cardinality = cardinality;
            }

            @Override
            public boolean equals(Object o) {
               if (this == o) return true;
               if (o == null || getClass() != o.getClass()) return false;

               Relation relation = (Relation) o;

               if (!src.equals(relation.src)) return false;
               if (!dst.equals(relation.dst)) return false;
               return name.equals(relation.name);
            }

            @Override
            public int hashCode() {
               int result = src.hashCode();
               result = 31 * result + dst.hashCode();
               result = 31 * result + name.hashCode();
               return result;
            }

            @Override
            public String toString() {
               return src + " " + name + " " + dst + " " + cardinality;
            }
         }
      });

      pop.add(new App.TransactionAction("Create Vertx classes", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            if (!hasPackageNameProperty(domainNode.getNode())) {
               final String packageName = SwingUtil.showInputDialog("Package", app);
               if (packageName == null || packageName.length() == 0) return;
               setPackageNameProperty(domainNode.getNode(), packageName);
            }

            final String verticleName = getNameProperty(domainNode.getNode()) + "DomainVerticle";
            final String facadeName = getNameProperty(domainNode.getNode()) + "Facade";

            final DomainPluginGroup domainPluginGroup = new DomainPluginGroup();

            final DomainPluginGroup.DomainVerticleFacadeST domainVerticleFacadeST = domainPluginGroup.newDomainVerticleFacade().
                  setPackage(getPackageNameProperty(domainNode.getNode())).
                  setName(facadeName).
                  setDomain(getNameProperty(domainNode.getNode()));

            final DomainPluginGroup.DomainVerticleST domainVerticleST = domainPluginGroup.newDomainVerticle().
                  setPackage(getPackageNameProperty(domainNode.getNode())).
                  setName(verticleName).
                  setDomain(getNameProperty(domainNode.getNode()));

            final Map<String, Set<String>> entityProperties = new LinkedHashMap<>();
            final Map<String, Map<String, String>> entityRelations = new LinkedHashMap<>();
            new DomainVisitor<Object>(true) {

               @Override
               public void visitEntity(Node node) {
                  if (!entityProperties.containsKey(getNameProperty(node)))
                     entityProperties.put(getNameProperty(node), new LinkedHashSet<>());

                  if (!entityRelations.containsKey(getNameProperty(node)))
                     entityRelations.put(getNameProperty(node), new LinkedHashMap<>());

                  outgoingSRC(node, (src, relationNode) -> outgoingDST(relationNode, (dst, dstNode) -> {
                     if (isProperty(dstNode))
                        entityProperties.get(getNameProperty(node)).add(getNameProperty(dstNode));
                  }));

                  super.visitEntity(node);
               }

               @Override
               public void visitRelation(Node node) {

                  // relation can be either to a Property or Entity
                  final AtomicBoolean isProperty = new AtomicBoolean(false);
                  outgoingDST(node, (relationship, dstNode) -> {
                     if (isProperty(dstNode)) isProperty.set(true);
                  });

                  // if Entity (not Property), add relation
                  if (!isProperty.get()) {
                     incomingSRC(node, (relationship, srcNode) -> entityRelations.get(getNameProperty(srcNode)).put(getNameProperty(node), getNameProperty(singleOutgoingDST(node))));
//                     entityRelations.get(getNameProperty(singleIncomingSRC(node))).put(getNameProperty(node), getNameProperty(singleOutgoingDST(node)));
                  }

                  super.visitRelation(node);
               }

               @Override
               public void visitVisitor(Node node) {
                  domainVerticleST.addVisitorsValue(getNameProperty(node), getVisitorClassProperty(node));
                  super.visitVisitor(node);
               }
            }.visitDomain(domainNode.getNode());

            for (Map.Entry<String, Set<String>> entry : entityProperties.entrySet()) {

               final DomainPluginGroup.EntityMessageHandlerST entityMessageHandlerST = domainPluginGroup.newEntityMessageHandler().
                     setLabel(entry.getKey());

               final DomainPluginGroup.DomainFacadeEntityMessagesST domainFacadeEntityMessagesST = domainPluginGroup.newDomainFacadeEntityMessages().
                     setLabel(entry.getKey());

               for (String propertyName : entry.getValue()) {
                  entityMessageHandlerST.addPropertiesValue(propertyName, propertyName.startsWith("is") ? "Boolean" : "String");
                  domainFacadeEntityMessagesST.addPropertiesValue(propertyName, propertyName.startsWith("is") ? "Boolean" : "String");
               }

               domainVerticleST.addEntitiesValue(entry.getKey(), entityMessageHandlerST);
               domainVerticleFacadeST.addEntitiesValue(domainFacadeEntityMessagesST);
            }

            for (Map.Entry<String, Map<String, String>> relationEntry : entityRelations.entrySet()) {
               for (Map.Entry<String, String> rel : relationEntry.getValue().entrySet()) {
                  domainVerticleST.addRelateEntitiesValue(rel.getValue(), relationEntry.getKey(), rel.getKey().toUpperCase());
                  domainVerticleFacadeST.addRelationsValue(rel.getValue(), rel.getKey().toUpperCase(), relationEntry.getKey());
               }
            }

            GeneratedFile.newJavaFile(ProjectConstants.MAIN_ROOT, domainVerticleST.getPackage(), verticleName).write(domainVerticleST);
            GeneratedFile.newJavaFile(ProjectConstants.MAIN_ROOT, domainVerticleFacadeST.getPackage(), facadeName).write(domainVerticleFacadeST);
         }
      });

      ProjectPlugin.incomingRENDERER(domainNode.getNode(), (relationship, other) -> pop.add(new App.TransactionAction("Render Domain visitor", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            renderDomainVisitor(relationship, domainNode.getNode());
         }
      }));
   }

   @Override
   protected void handleEntity(JPopupMenu pop, NeoNode entityNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("New " + getNameProperty(entityNode.getNode()) + " instance", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            final Node newNode = getGraph().newNode(Label.label(getNameProperty(entityNode.getNode())));
            relateINSTANCE(entityNode.getNode(), newNode);
            fireNodesLoaded(newNode);
         }
      });

      incomingVISITOR(entityNode.getNode(), (visitorRelation, visitorNode) -> pop.add(new App.TransactionAction("Visit with " + getNameProperty(visitorNode), app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            try {
               final DomainVisitor visitor = (DomainVisitor) Class.forName(getVisitorClassProperty(visitorNode)).
                     getConstructor(Node.class, App.class).
                     newInstance(visitorNode, app);
               visitor.visit(entityNode.getNode());
            } catch (Exception ex) {
               SwingUtil.showException(ex, app);
            }
         }
      }));

      pop.add(new App.TransactionAction("Add Property", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Property name", app);
            if (name == null || name.length() == 0) return;

            final AtomicBoolean exists = new AtomicBoolean(false);
            new EntityRelationVisitor() {
               @Override
               public void onSingle(Node relationNode, Node dstNode) {
                  if (name.equals(getNameProperty(relationNode))) exists.set(true);
               }

               @Override
               public void onList(Node relationNode, Node dstNode) {
                  if (name.equals(getNameProperty(relationNode))) exists.set(true);
               }
            }.visit(entityNode.getNode());

            if (exists.get()) {
               SwingUtil.showMessage(getNameProperty(entityNode.getNode()) + " already has a property named " + name, app);
               return;
            }

            final Node newPropertyNode = newProperty(name);
            fireNodesLoaded(newPropertyNode, newDomainEntityRelation(getGraph(), entityNode.getNode(), name, RelationCardinality.SINGLE, newPropertyNode));
         }
      });

      pop.add(new App.TransactionAction("Add Properties", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String properties = SwingUtil.showInputDialog("Properties", app);
            if (properties == null || properties.length() == 0) return;

            final String[] names = properties.split(" ");
            for (String name : names) {

               final AtomicBoolean exists = new AtomicBoolean(false);
               new EntityRelationVisitor() {
                  @Override
                  public void onSingle(Node relationNode, Node dstNode) {
                     if (name.equals(getNameProperty(relationNode))) exists.set(true);
                  }

                  @Override
                  public void onList(Node relationNode, Node dstNode) {
                     if (name.equals(getNameProperty(relationNode))) exists.set(true);
                  }
               }.visit(entityNode.getNode());

               if (exists.get())
                  continue;

               final Node newPropertyNode = newProperty(name);
               fireNodesLoaded(newPropertyNode, newDomainEntityRelation(getGraph(), entityNode.getNode(), name, RelationCardinality.SINGLE, newPropertyNode));
            }
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

            SwingUtil.showDialog(editor, app, "New Relation", new SwingUtil.ConfirmAction() {
               @Override
               public void verifyAndCommit() throws Exception {
                  getGraph().doInTransaction(new NeoModel.Committer() {
                     @Override
                     public void doAction(Transaction tx14) throws Throwable {

                        final String name = StringUtil.toUpper(txtName.getText().trim());
                        final RelationCardinality relationCardinality = RelationCardinality.valueOf(cboCardinality.getSelectedItem().toString());

                        if (name.length() == 0)
                           throw new IllegalStateException("Relation Name is required");
                        if (txtEntityName.getText().trim().length() == 0)
                           throw new IllegalStateException("Entity must have a name");

                        final Node newEntityNode = newEntity(txtEntityName.getText().trim());
                        fireNodesLoaded(newEntityNode, newDomainEntityRelation(getGraph(), entityNode.getNode(), name, relationCardinality, newEntityNode));
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

      if (selectedNodes.size() <= 20) {
         for (NeoNode selectedNode : selectedNodes) {
            if (isEntity(selectedNode.getNode())) {

               pop.add(new App.TransactionAction("Add Relation " + getNameAndLabelsFrom(selectedNode.getNode()) + " -> " + getNameAndLabelsFrom(entityNode.getNode()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final JTextField txtName = new JTextField();
                     final JComboBox<RelationCardinality> cboCardinality = new JComboBox<>(RelationCardinality.values());

                     final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu,4dlu,75dlu:grow", "pref, 4dlu, pref");
                     editor.addLabel("Relation name", 1, 1);
                     editor.add(txtName, 3, 1);
                     editor.addLabel("Cardinality", 1, 3);
                     editor.add(cboCardinality, 3, 3);

                     SwingUtil.showDialog(editor, app, "Add Relation " + getNameAndLabelsFrom(selectedNode.getNode()) + " -> " + getNameAndLabelsFrom(entityNode.getNode()), new SwingUtil.ConfirmAction() {
                        @Override
                        public void verifyAndCommit() throws Exception {
                           getGraph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx14) throws Throwable {

                                 final String name = StringUtil.toUpper(txtName.getText().trim());
                                 final RelationCardinality relationCardinality = RelationCardinality.valueOf(cboCardinality.getSelectedItem().toString());

                                 if (name.length() == 0)
                                    throw new IllegalStateException("Relation Name is required");

                                 fireNodesLoaded(newDomainEntityRelation(getGraph(), selectedNode.getNode(), name, relationCardinality, entityNode.getNode()));
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

            } else if (isRelation(selectedNode.getNode())) {
               pop.add(new App.TransactionAction("Set " + getNameAndLabelsFrom(selectedNode.getNode()) + " -> DST ->" + getNameAndLabelsFrom(entityNode.getNode()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     // remove old DST
                     log.info("removing existing DST");
                     outgoingDST(selectedNode.getNode(), (relationship, other) -> relationship.delete());
                     relateDST(selectedNode.getNode(), entityNode.getNode());
                  }
               });
            }
         }
      }
   }

   @Override
   protected void handleRelation(JPopupMenu pop, NeoNode relationNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Add Property", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Property name", app);
            if (name == null || name.length() == 0) return;

            final AtomicBoolean exists = new AtomicBoolean(false);
            new EntityRelationVisitor() {
               @Override
               public void onSingle(Node relationNode, Node dstNode) {
                  if (name.equals(getNameProperty(relationNode))) exists.set(true);
               }

               @Override
               public void onList(Node relationNode, Node dstNode) {
                  if (name.equals(getNameProperty(relationNode))) exists.set(true);
               }
            }.visit(relationNode.getNode());

            if (exists.get()) {
               SwingUtil.showMessage(getNameProperty(relationNode.getNode()) + " already has a property named " + name, app);
               return;
            }

            final Node newPropertyNode = newProperty(name);
            fireNodesLoaded(newPropertyNode, newDomainEntityRelation(getGraph(), relationNode.getNode(), name, RelationCardinality.SINGLE, newPropertyNode));
         }
      });

      if (selectedNodes.size() <= 20) {
         for (NeoNode selectedNode : selectedNodes) {
            if (isEntity(selectedNode.getNode())) {
               pop.add(new App.TransactionAction("Set " + getNameAndLabelsFrom(selectedNode.getNode()) + " -> src ->" + getNameAndLabelsFrom(relationNode.getNode()), app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     // remove old SRC
                     log.info("testing multiple SRC removing existing SRC");
                     //incomingSRC(relationNode.getNode(), (relationship, other) -> relationship.delete());
                     relateSRC(selectedNode.getNode(), relationNode.getNode());
                  }
               });
            }
         }
      }

      pop.add(new App.TransactionAction("Change cardinality", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final RelationCardinality existing = RelationCardinality.valueOf(getRelationCardinalityProperty(relationNode.getNode()));
            final RelationCardinality relationCardinality = SwingUtil.showSelectDialog(app, RelationCardinality.values(), existing);
            if (relationCardinality == null || existing.equals(relationCardinality)) return;

            setRelationCardinalityProperty(relationNode.getNode(), relationCardinality.name());

            fireNodeChanged(relationNode, Properties.relationCardinality.name(), relationCardinality);
         }
      });
   }

   @Override
   protected void handleValue(JPopupMenu pop, NeoNode valueNode, Set<NeoNode> selectedNodes) {

      pop.add(new App.TransactionAction("Set value", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) {

            final String oldValue = valueNode.getNode().hasProperty(AppMotif.Properties.name.name()) ? (String) valueNode.getNode().getProperty(AppMotif.Properties.name.name()) : "";

            final String newValue = SwingUtil.showInputDialog("New value", app, oldValue);
            if (newValue == null || newValue.equals(oldValue)) return;

            valueNode.getNode().setProperty(AppMotif.Properties.name.name(), newValue);
            fireNodeChanged(valueNode.getNode());
         }
      });
   }

   @Override
   protected void handleVisitor(JPopupMenu pop, NeoNode visitorNode, Set<NeoNode> selectedNodes) {

      outgoingVISITOR(visitorNode.getNode(), (relationship, nodeToVisit) -> pop.add(new App.TransactionAction("Visit " + getNameOrLabelFrom(nodeToVisit), app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            try {
               final DomainVisitor visitor = (DomainVisitor) Class.forName(getVisitorClassProperty(visitorNode.getNode())).
                     getConstructor(Node.class, App.class).
                     newInstance(visitorNode.getNode(), app);
               visitor.visit(nodeToVisit);
            } catch (Exception ex) {
               SwingUtil.showException(ex, app);
            }
         }
      }));
   }

   @Override
   public void handleNodeRightClick(JPopupMenu pop, NeoNode neoNode, Set<NeoNode> selectedNodes) {

      super.handleNodeRightClick(pop, neoNode, selectedNodes);

      if (StringTemplatePlugin.isSTTemplate(neoNode.getNode())) {

         pop.add(new App.TransactionAction("New " + getNameProperty(neoNode.getNode()) + " instance", app) {
            @Override
            protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Node newNode = getGraph().newNode(Label.label(getNameProperty(neoNode.getNode())));
               relateINSTANCE(neoNode.getNode(), newNode);
               fireNodesLoaded(newNode);
            }
         });
      }

      showEntityActions(pop, neoNode, selectedNodes);
   }

   public void showEntityActions(JPopupMenu pop, NeoNode templateNeoNode, Set<NeoNode> selectedNodes) {

      incomingINSTANCE(templateNeoNode.getNode(), (instanceRelation, instanceNode) -> {

         if (isEntity(instanceNode) || StringTemplatePlugin.isSTTemplate(instanceNode)) {

            if (StringTemplatePlugin.isSTTemplate(instanceNode)) {

               incomingRENDERER(templateNeoNode.getNode(), (rendererRelationship, directoryNode) -> {
                  if (directoryNode != null) {
                     final File directory = ProjectPlugin.getFile(directoryNode);
                     if (directory != null && directory.exists()) {
                        pop.add(new App.TransactionAction("Render to " + getString(directoryNode, ProjectPlugin.Properties.path.name()), app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                              final String content = StringTemplatePlugin.renderStatement(templateNeoNode.getNode(), other(templateNeoNode.getNode(), singleIncoming(templateNeoNode.getNode(), Relations.INSTANCE)));
                              renderToFile(rendererRelationship, templateNeoNode.getNode(), content, other(templateNeoNode.getNode(), rendererRelationship));
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

                  if (isProperty(dstNode))
                     singlePropertyMap.put(parameterName, dstNode);
                  else
                     singleEntityMap.put(parameterName, dstNode);

                  if (selectedNodes.size() == 1) {
                     final NeoNode selectedNode = selectedNodes.iterator().next();

                     final String dstType = getNameProperty(dstNode);
                     if (!isRelated(templateNeoNode.getNode(), selectedNode.getNode(), RelationshipType.withName(parameterName)) && ((isProperty(dstNode) && isValue(selectedNode.getNode())) || hasLabel(selectedNode.getNode(), dstType))) {
                        referenceMenu.add(new App.TransactionAction("Set " + parameterName + " -> " + getNameAndLabelsFrom(selectedNode.getNode()), app) {
                           @Override
                           protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {
                              // remove any existing one
                              outgoing(templateNeoNode.getNode(), RelationshipType.withName(parameterName)).forEach(oldValueRelation -> {
                                 final Node oldValueNode = other(templateNeoNode.getNode(), oldValueRelation);
                                 oldValueRelation.delete();
                                 AppMotif.tryToDeleteValueNode(oldValueNode);
                              });

                              relate(templateNeoNode.getNode(), selectedNode.getNode(), RelationshipType.withName(parameterName));
                           }
                        });
                     }
                  }
               }

               @Override
               public void onList(Node relationNode, Node dstNode) {

                  final String parameterName = getNameProperty(relationNode);
                  final String dstType = getNameProperty(dstNode);

                  groupAssign.put(parameterName, new LinkedHashMap<>());

                  referenceMenu.add(new App.TransactionAction("Add " + parameterName + " (" + dstType + ")", app) {
                     @Override
                     protected void actionPerformed(ActionEvent e, Transaction tx12) throws Exception {

                        if (isProperty(dstNode)) {

                           final JTextField[] txtValues = new JTextField[5];

                           final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("100dlu,4dlu,100dlu", "pref,4dlu,pref,4dlu,pref,4dlu,pref,4dlu,pref");
                           editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

                           int row = 1;
                           for (int i = 0; i < txtValues.length; i++) {
                              editor.addLabel("Value " + (i + 1), 1, row);
                              editor.add(txtValues[i] = new JTextField(), 3, row);
                              row += 2;
                           }

                           SwingUtil.showDialog(editor, app, "Values", new SwingUtil.ConfirmAction() {
                              @Override
                              public void verifyAndCommit() throws Exception {

                                 getGraph().doInTransaction(new NeoModel.Committer() {
                                    @Override
                                    public void doAction(Transaction tx) throws Throwable {
                                       final Set<Node> newNodes = new LinkedHashSet<>();
                                       for (JTextField txtValue : txtValues) {
                                          final String value = txtValue.getText().trim();
                                          if (value.length() == 0) continue;
                                          final Node newDstNode = newValueNode(getGraph(), value.trim());
                                          relate(templateNeoNode.getNode(), newDstNode, RelationshipType.withName(parameterName));
                                          newNodes.add(newDstNode);
                                       }
                                       if (newNodes.isEmpty()) return;

                                       fireNodesLoaded(newNodes);
                                    }

                                    @Override
                                    public void exception(Throwable throwable) {
                                       SwingUtil.showExceptionNoStack(app, throwable);
                                    }
                                 });
                              }
                           });

                        } else {

                           showNewEntityDialog(parameterName, dstNode, templateNeoNode.getNode());
                        }
                     }
                  });

                  for (NeoNode selectedNode : selectedNodes) {
                     if (!isRelated(templateNeoNode.getNode(), selectedNode.getNode(), RelationshipType.withName(parameterName))) {
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
                              relate(templateNeoNode.getNode(), selectedNode, RelationshipType.withName(groupEntry.getKey()));
                        }
                     });
                  }
               }
            }

            if (!singlePropertyMap.isEmpty()) {

               referenceMenu.add(new App.TransactionAction("Set Properties", app) {
                  @Override
                  protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     final Map<String, JComponent> fields = new TreeMap<>();
                     final StringBuilder rows = new StringBuilder();
                     boolean first = true;
                     for (Map.Entry<String, Node> propertyEntry : singlePropertyMap.entrySet()) {
                        if (!first) rows.append(",4dlu,");
                        rows.append("pref");

                        final Set<String> enumValues = new LinkedHashSet<>();
                        outgoingENUMERATED(propertyEntry.getValue(), (relationship, enumNode) -> enumValues.add(getValueProperty(enumNode)));
                        final Node existing = other(templateNeoNode.getNode(), singleOutgoing(templateNeoNode.getNode(), RelationshipType.withName(propertyEntry.getKey())));
                        fields.put(propertyEntry.getKey(), isBooleanProperty(propertyEntry.getValue()) ? new JCheckBox("", "true".equals(getNameProperty(existing, "false"))) : (enumValues.isEmpty() ? new JTextField(getNameProperty(existing, "")) : SwingUtil.newComboBox(enumValues, getNameProperty(existing))));
                        first = false;
                     }

                     final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu:grow,4dlu,75dlu:grow", rows.toString().trim());
                     int row = 1;
                     for (Map.Entry<String, JComponent> fieldEntry : fields.entrySet()) {
                        editor.addLabel(fieldEntry.getKey(), 1, row);
                        editor.add(fieldEntry.getValue(), 3, row);
                        row += 2;
                     }
                     editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

                     SwingUtil.showDialog(editor, app, "Set Properties", new SwingUtil.ConfirmAction() {
                        @Override
                        public void verifyAndCommit() throws Exception {
                           getGraph().doInTransaction(new NeoModel.Committer() {
                              @Override
                              public void doAction(Transaction tx) throws Throwable {

                                 for (Map.Entry<String, JComponent> fieldEntry : fields.entrySet()) {

                                    final JComponent component = fieldEntry.getValue();
                                    final String value = getValueFrom(component);

                                    // update existing one, if changed
                                    final AtomicBoolean foundAndUpdated = new AtomicBoolean(false);
                                    outgoing(templateNeoNode.getNode(), RelationshipType.withName(fieldEntry.getKey())).forEach(oldValueRelation -> {
                                       final Node oldValueNode = other(templateNeoNode.getNode(), oldValueRelation);

                                       // if value is unchanged
                                       if (value != null && (has(oldValueNode, AppMotif.Properties.name.name()) && value.equals(getString(oldValueNode, AppMotif.Properties.name.name())))) {
                                          foundAndUpdated.set(true);
                                          return;
                                       }

                                       // if value==null delete existing node
                                       if (value == null) {
                                          oldValueRelation.delete();
                                          tryToDeleteNode(oldValueNode, false);
                                          foundAndUpdated.set(true);
                                          return;
                                       }

                                       // update node with new value
                                       oldValueNode.setProperty(AppMotif.Properties.name.name(), value);
                                       fireNodeChanged(oldValueNode);
                                       foundAndUpdated.set(true);
                                    });

                                    if (foundAndUpdated.get()) continue;

                                    final Node existingNode = getGraph().newNode(Entities.Value, AppMotif.Properties.name.name(), value);
                                    final Node newDstNode = existingNode == null ? newValueNode(getGraph(), value) : existingNode;
                                    relate(templateNeoNode.getNode(), newDstNode, RelationshipType.withName(fieldEntry.getKey()));
                                    fireNodesLoaded(newDstNode);
                                 }
                              }

                              private String getValueFrom(JComponent component) {
                                 if (component instanceof JCheckBox)
                                    return ((JCheckBox) component).isSelected() ? "true" : "false";
                                 else if (component instanceof JComboBox)
                                    return ((JComboBox) component).getSelectedItem() == null ? null : ((JComboBox) component).getSelectedItem().toString();
                                 else if (component instanceof JTextField) {
                                    final String trim = ((JTextField) component).getText().trim();
                                    return trim.length() == 0 ? null : trim;
                                 }
                                 return null;
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
                        outgoing(templateNeoNode.getNode(), RelationshipType.withName(entry.getKey())).forEach(oldValueRelation -> {
                           final Node oldValueNode = other(templateNeoNode.getNode(), oldValueRelation);
                           oldValueRelation.delete();
                           AppMotif.tryToDeleteValueNode(oldValueNode);
                        });

                        showNewEntityDialog(entry.getKey(), entry.getValue(), templateNeoNode.getNode());
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
            if (isProperty(dstNode))
               entityPropertiesMap.put(parameterName, dstNode);
         }

         @Override
         public void onList(Node relationNode, Node dstNode) {

         }
      }.visit(instanceNode);


      if (entityPropertiesMap.isEmpty()) {
         final Node newEntityNode = newInstanceNode(getGraph(), instanceNode);
         relate(ownerNode, newEntityNode, RelationshipType.withName(parameterName));
         fireNodesLoaded(newEntityNode);
         return;
      }

      final Map<String, JComponent> fields = new TreeMap<>();
      final StringBuilder rows = new StringBuilder();
      boolean first = true;
      for (Map.Entry<String, Node> propertyEntry : entityPropertiesMap.entrySet()) {
         if (!first) rows.append(",4dlu,");
         rows.append("pref");
         fields.put(propertyEntry.getKey(), isBooleanProperty(propertyEntry.getValue()) ? new JCheckBox() : new JTextField());
         first = false;
      }

      final SwingUtil.FormPanel editor = new SwingUtil.FormPanel("75dlu:grow,4dlu,75dlu:grow", rows.toString().trim());
      int row = 1;
      for (Map.Entry<String, JComponent> fieldEntry : fields.entrySet()) {
         editor.addLabel(fieldEntry.getKey(), 1, row);
         editor.add(fieldEntry.getValue(), 3, row);
         row += 2;
      }
      editor.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

      SwingUtil.showDialog(editor, app, "New " + getNameAndLabelsFrom(instanceNode), new SwingUtil.ConfirmAction() {
         @Override
         public void verifyAndCommit() throws Exception {
            getGraph().doInTransaction(new NeoModel.Committer() {
               @Override
               public void doAction(Transaction tx) throws Throwable {

                  final Node newEntityNode = newInstanceNode(getGraph(), instanceNode);
                  ;
                  relate(ownerNode, newEntityNode, RelationshipType.withName(parameterName));

                  for (Map.Entry<String, JComponent> fieldEntry : fields.entrySet()) {

                     final String value = isBooleanProperty(entityPropertiesMap.get(fieldEntry.getKey())) ? ((JCheckBox) fieldEntry.getValue()).isSelected() ? "true" : "" : ((JTextField) fieldEntry.getValue()).getText().trim();
                     if (value.trim().length() == 0) continue;

                     // try to find existing node with same value, and if exists, use this and add link to it
                     final Node existingValueNode = getGraph().newNode(Entities.Value, AppMotif.Properties.name.name(), value);
                     final Node newPropertyNode = existingValueNode == null ? newValueNode(getGraph(), value) : existingValueNode;
                     relate(newEntityNode, newPropertyNode, RelationshipType.withName(fieldEntry.getKey()));
                  }

                  fireNodesLoaded(newEntityNode);
               }

               @Override
               public void exception(Throwable throwable) {
                  SwingUtil.showExceptionNoStack(app, throwable);
               }
            });
         }
      });
   }

   private static boolean isBooleanProperty(Node node) {
      final String propertyName = getNameProperty(node).toString().toLowerCase();
      return propertyName.startsWith("is") || propertyName.startsWith("has");
   }

   @Override
   protected JComponent newVisitorEditor(NeoNode visitorNode) {
      final JTabbedPane rendererPanels = new JTabbedPane();
      outgoingVISITOR(visitorNode.getNode(), (visitorRelation, other) -> rendererPanels.add(getNameOrLabelFrom(visitorNode.getNode()), new VisitorRenderPanel(visitorNode, visitorRelation)));
      return rendererPanels;
   }

   public static void renderDomainVisitor(Relationship rendererRelationship, Node node) {
      final String packageName = getPackageNameProperty(rendererRelationship);
      final String groupName = getNameProperty(node) + "Visitor";
      final File targetDir = getFile(other(node, rendererRelationship));

      final Set<Node> visitedNodes = new LinkedHashSet<>();
      final Map<String, NeoVisitorGroup.entityVisitST> visitorMethods = new LinkedHashMap<>();

      final NeoVisitorGroup visitorGroup = new NeoVisitorGroup();

      outgoingENTITY(node, (relationship, other) -> visitEntityNode(visitorMethods, visitedNodes, visitorGroup, other));

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

   private final class VisitorRenderPanel extends JPanel {
      VisitorRenderPanel(NeoNode visitorNode, Relationship visitorRelation) {
         super(new BorderLayout());

         final JTextArea txtEditor = new JTextArea(25, 85);
         txtEditor.setFont(com.generator.app.AppMotif.getDefaultFont());
         txtEditor.setTabSize(3);
         txtEditor.setEditable(false);

         final Node nodeToVisit = other(visitorNode.getNode(), visitorRelation);

         try {
            final DomainVisitor visitor = (DomainVisitor) Class.forName(getVisitorClassProperty(visitorNode.getNode())).
                  getConstructor(Node.class, App.class).
                  newInstance(visitorNode.getNode(), app);
            visitor.visit(nodeToVisit);
            txtEditor.setText(visitor.getResult().toString());
            txtEditor.setCaretPosition(0);
         } catch (Exception ex) {
            txtEditor.setText(SwingUtil.printStackTrace(ex));
            txtEditor.setCaretPosition(0);
         }

         add(new JScrollPane(txtEditor), BorderLayout.CENTER);
      }
   }

   private static void visitEntityNode(Map<String, NeoVisitorGroup.entityVisitST> visitorMethods, Set<Node> visitedNodes, NeoVisitorGroup visitorGroup, Node entityNode) {

      if (visitedNodes.contains(entityNode)) return;
      visitedNodes.add(entityNode);

      final String entityName = getNameProperty(entityNode);

      final NeoVisitorGroup.entityVisitST newEntityVisitorST = visitorGroup.newentityVisit().
            setName(entityName);

      outgoingSRC(entityNode, (srcRelation, relationNode) -> {
         newEntityVisitorST.addOutgoingValue(getNameProperty(relationNode));
         outgoingDST(relationNode, (dstRelation, dstNode) -> visitEntityNode(visitorMethods, visitedNodes, visitorGroup, dstNode));
      });

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

   public abstract static class EntityRelationVisitor {

      public abstract void onSingle(Node relationNode, Node dstNode);

      public abstract void onList(Node relationNode, Node dstNode);

      public void visit(Node entityNode) {

         outgoingSRC(entityNode, (srcRelation, relationNode) -> outgoingDST(relationNode, (relationship, destinationEntityNode) -> {
            switch (RelationCardinality.valueOf(getRelationCardinalityProperty(relationNode))) {
               case SINGLE:
                  onSingle(relationNode, destinationEntityNode);
                  break;
               case LIST:
                  onList(relationNode, destinationEntityNode);
                  break;
            }
         }));
      }
   }
}