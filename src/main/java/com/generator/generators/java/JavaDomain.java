package com.generator.generators.java;

import com.generator.domain.IDomain;
import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.getNameOrLabelFrom;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.java.JavaDomain.Entities.*;
import static com.generator.generators.java.JavaDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class JavaDomain implements IDomain {

   public enum Entities implements Label {
      Package, Class, Field, Method, Interface, Constructor, JavaStatement, Generator
   }

   public enum Relations implements RelationshipType {
      FIELD, MEMBER, METHOD, PARENT, TYPE, RETURNVALUE, PARAMETER, CONSTRUCTOR, INNERCLASS, IMPLEMENTS, STATEMENTS, EXTENDS, GENERATE
   }

   public enum Properties {
      name, scope, content, root
   }

   @Override
   public String getName() {
      return "Java";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case Package:
         	return newPackagePNode(node, editor);
         case Class:
         	return newClassPNode(node, editor);
         case Field:
         	return newFieldPNode(node, editor);
         case Method:
         	return newMethodPNode(node, editor);
         case Interface:
         	return newInterfacePNode(node, editor);
         case Constructor:
         	return newConstructorPNode(node, editor);
         case JavaStatement:
         	return newJavaStatementPNode(node, editor);
         case Generator:
         	return newGeneratorPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported JavaDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
   }

	@Override
   public void deleteNode(Node node) throws NeoEditor.ReferenceException {
      // todo enforce constraints
      final Set<Relationship> constraints = new LinkedHashSet<>();

      final Consumer<Relationship> constraintVisitor = relationship -> {
         if (NeoEditor.isAppRelated(relationship)) return;
         constraints.add(relationship);
      };

      //if (node.hasLabel(ContextProperty)) {
         //node.getRelationships(INCOMING, PROPERTY).forEach(Relationship::delete);
         //node.getRelationships(INCOMING, FROM).forEach(Relationship::delete);
      //}

      // delete from layouts:
      NeoEditor.removeFromLayouts(node);

      node.delete();
   }

   protected NeoPNode newPackagePNode(Node node, NeoEditor editor) {
         return new PackagePNode(node, editor);
      }

   protected static class PackagePNode extends JavaDomainPNode {

      PackagePNode(Node node, NeoEditor editor) {
         super(node, Entities.Package, "name", "#66c2a5", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showPackagePropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.name.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.Package, Relations.PARENT, this, event));
   		pop.add(editor.newAddNodeAction(Entities.Class, Relations.MEMBER, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();
         final Map<String, Set<Node>> incoming = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.Package)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Package.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.Package)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.Package.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.Package.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Package.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.PARENT, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.PARENT);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.MEMBER, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.MEMBER);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         // incoming
         if (incoming.containsKey(Entities.Package.name())) {
            final Set<Node> nodes = incoming.get(Entities.Package.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.PARENT, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.PARENT);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		outgoing(node, Relations.PARENT).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Package));
   		outgoing(node, Relations.MEMBER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.PARENT).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Package));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newClassPNode(Node node, NeoEditor editor) {
         return new ClassPNode(node, editor);
      }

   protected static class ClassPNode extends JavaDomainPNode {

      ClassPNode(Node node, NeoEditor editor) {
         super(node, Entities.Class, "name", "#fc8d62", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showClassPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.scope.name(), this));
   		pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.name.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.Class, Relations.EXTENDS, this, event));
   		pop.add(editor.newAddNodeAction(Entities.Interface, Relations.IMPLEMENTS, this, event));
   		pop.add(editor.newAddNodeAction(Entities.Class, Relations.INNERCLASS, this, event));
   		pop.add(editor.newAddNodeAction(Entities.Constructor, Relations.CONSTRUCTOR, this, event));
   		pop.add(editor.newAddNodeAction(Entities.Method, Relations.METHOD, this, event));
   		pop.add(editor.newAddNodeAction(Entities.Field, Relations.FIELD, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();
         final Map<String, Set<Node>> incoming = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Interface)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Interface.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Constructor)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Constructor.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Method)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Method.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Field)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Field.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.Method)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.Method.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Method)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.Method.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Field)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.Field.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Package)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.Package.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.EXTENDS, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.EXTENDS);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.Interface.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Interface.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.IMPLEMENTS, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.IMPLEMENTS);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.INNERCLASS, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.INNERCLASS);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.Constructor.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Constructor.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.CONSTRUCTOR, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.CONSTRUCTOR);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.Method.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Method.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.METHOD, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.METHOD);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.Field.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Field.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.FIELD, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.FIELD);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         // incoming
         if (incoming.containsKey(Entities.Method.name())) {
            final Set<Node> nodes = incoming.get(Entities.Method.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.PARAMETER, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.PARAMETER);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (incoming.containsKey(Entities.Method.name())) {
            final Set<Node> nodes = incoming.get(Entities.Method.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.RETURNVALUE, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.RETURNVALUE);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (incoming.containsKey(Entities.Field.name())) {
            final Set<Node> nodes = incoming.get(Entities.Field.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.TYPE, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.TYPE);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (incoming.containsKey(Entities.Package.name())) {
            final Set<Node> nodes = incoming.get(Entities.Package.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.MEMBER, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.MEMBER);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		outgoing(node, Relations.EXTENDS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
   		outgoing(node, Relations.IMPLEMENTS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Interface));
   		outgoing(node, Relations.INNERCLASS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
   		outgoing(node, Relations.CONSTRUCTOR).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Constructor));
   		outgoing(node, Relations.METHOD).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Method));
   		outgoing(node, Relations.FIELD).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Field));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Method));
   		incoming(node, Relations.RETURNVALUE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Method));
   		incoming(node, Relations.TYPE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Field));
   		incoming(node, Relations.MEMBER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Package));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newFieldPNode(Node node, NeoEditor editor) {
         return new FieldPNode(node, editor);
      }

   protected static class FieldPNode extends JavaDomainPNode {

      FieldPNode(Node node, NeoEditor editor) {
         super(node, Entities.Field, "name", "#8da0cb", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showFieldPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.scope.name(), this));
   		pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.name.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.Class, Relations.TYPE, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();
         final Map<String, Set<Node>> incoming = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.TYPE, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.TYPE);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         // incoming
         if (incoming.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = incoming.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.FIELD, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.FIELD);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		outgoing(node, Relations.TYPE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.FIELD).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newMethodPNode(Node node, NeoEditor editor) {
         return new MethodPNode(node, editor);
      }

   protected static class MethodPNode extends JavaDomainPNode {

      MethodPNode(Node node, NeoEditor editor) {
         super(node, Entities.Method, "name", "#e78ac3", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showMethodPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.scope.name(), this));
   		pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.name.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.JavaStatement, Relations.STATEMENTS, this, event));
   		pop.add(editor.newAddNodeAction(Entities.Class, Relations.PARAMETER, this, event));
   		pop.add(editor.newAddNodeAction(Entities.Class, Relations.RETURNVALUE, this, event));

   		for (Relationship relationship : outgoing(node, Relations.PARAMETER)) {
               pop.add(new NeoEditor.TransactionAction("Edit " + relationship.getType() + "' -> '" + NeoModel.getNameOrLabelFrom(other(node, relationship)) + "'", editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     showParameterPropertyEditor(relationship, editor, event);
                  }
            	});
            }


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();
         final Map<String, Set<Node>> incoming = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.JavaStatement)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.JavaStatement.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.JavaStatement.name())) {
            final Set<Node> nodes = outgoing.get(Entities.JavaStatement.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.STATEMENTS, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.STATEMENTS);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.PARAMETER, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.PARAMETER);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.RETURNVALUE, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.RETURNVALUE);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         // incoming
         if (incoming.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = incoming.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.METHOD, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.METHOD);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		outgoing(node, Relations.STATEMENTS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.JavaStatement));
   		outgoing(node, Relations.PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
   		outgoing(node, Relations.RETURNVALUE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.METHOD).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newInterfacePNode(Node node, NeoEditor editor) {
         return new InterfacePNode(node, editor);
      }

   protected static class InterfacePNode extends JavaDomainPNode {

      InterfacePNode(Node node, NeoEditor editor) {
         super(node, Entities.Interface, "name", "#a6d854", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showInterfacePropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.name.name(), this));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> incoming = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // incoming
            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // incoming
         if (incoming.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = incoming.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.IMPLEMENTS, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.IMPLEMENTS);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.IMPLEMENTS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newConstructorPNode(Node node, NeoEditor editor) {
         return new ConstructorPNode(node, editor);
      }

   protected static class ConstructorPNode extends JavaDomainPNode {

      ConstructorPNode(Node node, NeoEditor editor) {
         super(node, Entities.Constructor, "name", "#ffd92f", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(editor.newAddNodeAction(Entities.Class, Relations.PARAMETER, this, event));
   		pop.add(editor.newAddNodeAction(Entities.JavaStatement, Relations.STATEMENTS, this, event));

   		for (Relationship relationship : outgoing(node, Relations.PARAMETER)) {
               pop.add(new NeoEditor.TransactionAction("Edit " + relationship.getType() + "' -> '" + NeoModel.getNameOrLabelFrom(other(node, relationship)) + "'", editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     showParameterPropertyEditor(relationship, editor, event);
                  }
            	});
            }


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();
         final Map<String, Set<Node>> incoming = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.JavaStatement)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.JavaStatement.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.PARAMETER, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.PARAMETER);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.JavaStatement.name())) {
            final Set<Node> nodes = outgoing.get(Entities.JavaStatement.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.STATEMENTS, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.STATEMENTS);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         // incoming
         if (incoming.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = incoming.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.CONSTRUCTOR, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.CONSTRUCTOR);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		outgoing(node, Relations.PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
   		outgoing(node, Relations.STATEMENTS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.JavaStatement));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.CONSTRUCTOR).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newJavaStatementPNode(Node node, NeoEditor editor) {
         return new JavaStatementPNode(node, editor);
      }

   protected static class JavaStatementPNode extends JavaDomainPNode {

      JavaStatementPNode(Node node, NeoEditor editor) {
         super(node, Entities.JavaStatement, "name", "#e5c494", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showJavaStatementPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.content.name(), this));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;


         selectedNodes.forEach(selectedNode -> {
         });

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newGeneratorPNode(Node node, NeoEditor editor) {
         return new GeneratorPNode(node, editor);
      }

   protected static class GeneratorPNode extends JavaDomainPNode {

      GeneratorPNode(Node node, NeoEditor editor) {
         super(node, Entities.Generator, "name", "#b3b3b3", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showGeneratorPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(JavaDomain.Properties.root.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.Package, Relations.GENERATE, this, event));
   		pop.add(editor.newAddNodeAction(Entities.Class, Relations.GENERATE, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.Package)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Package.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Class)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Class.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.Package.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Package.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.GENERATE, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.GENERATE);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.Class.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Class.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.GENERATE, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.GENERATE);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		outgoing(node, Relations.GENERATE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Package));
   		outgoing(node, Relations.GENERATE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Class));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }


   private static class JavaDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final JavaDomain.Entities nodeType;

      JavaDomainPNode(Node node, JavaDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
         super(node, new PText(node.hasProperty(property) ? node.getProperty(property).toString() : getNameOrLabelFrom(node)), nodeType.name(), editor);
         this.defaultColor = Color.decode(defaultColor);
         this.property = property;
         this.nodeType = nodeType;
         pNode.setTextPaint(this.defaultColor);
         pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }

      @Override
      public String getNodeType() {
         return nodeType.name();
      }

      @Override
      public void expand() {

      }

      @Override
      public void showDependents() {

      }

      @Override
      public void keyPressed(PInputEvent event) {
         super.keyPressed(event);
      }

      @Override
      public void updateView() {
         if (property == null) System.out.println("override updateView: property not set");
			pNode.setText(property == null ? "?" : node.hasProperty(property) ? node.getProperty(property).toString() : getNameOrLabelFrom(node));
      }

      @Override
      public void onSelect() {
         pNode.setTextPaint(selectedColor);
      }

      @Override
      public void onUnselect() {
         pNode.setTextPaint(defaultColor);
      }

      @Override
      public void onStartHighlight() {
         pNode.setTextPaint(Color.ORANGE);
      }

      @Override
      public void onEndHighlight() {
         pNode.setTextPaint(selected.get() ? selectedColor : defaultColor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         editor.showDeleteOutgoingRelations(pop, node);

         pop.add(new NeoEditor.TransactionAction("Select all " + nodeType, editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               editor.getAllNodes().forEach(neoPNode -> {
                  if (neoPNode.getNodeType().equals(nodeType.name()) && !neoPNode.selected.get())
                     neoPNode.select();
               });
            }
         });
         pop.add(new NeoEditor.TransactionAction("Hide all " + nodeType, editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Set<UUID> hide = new LinkedHashSet<>();
               editor.getAllNodes().forEach(pNode -> {
                  if (pNode.getNodeType().equals(nodeType.name())) hide.add(pNode.uuid);
               });
               hide.forEach(editor::removeNodeFromCanvas);
            }
         });

         pop.add(retainNode());
         pop.add(hideNode());
         pop.add(deleteNode());
      }
   }

	static class PackagePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      PackagePropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, PropertyContainer container, String property, String[] values) {
	         component.setText(container.hasProperty(property) ? getString(container, property) : "");
	      }

			private void setValue(JCheckBox component, PropertyContainer container, String property, String[] values) {
	         component.setSelected(container.hasProperty(property) ? getString(container, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, PropertyContainer container, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = container.hasProperty(property) ? getString(container, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(PropertyContainer container) throws Exception {
				getValue(container, "name", _name); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showPackagePropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final PackagePropertyEditor form = new PackagePropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Package", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class ClassPropertyEditor extends SwingUtil.FormPanel {

			private final JComboBox _scope = new JComboBox();
			private final JTextField _name = new JTextField();

	      ClassPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Scope", 1, row);
	         add(_scope, 3, row);
				setValue(_scope, container, Properties.scope.name(), new String[] { "package","private","protected","public" });

	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, PropertyContainer container, String property, String[] values) {
	         component.setText(container.hasProperty(property) ? getString(container, property) : "");
	      }

			private void setValue(JCheckBox component, PropertyContainer container, String property, String[] values) {
	         component.setSelected(container.hasProperty(property) ? getString(container, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, PropertyContainer container, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = container.hasProperty(property) ? getString(container, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(PropertyContainer container) throws Exception {
				getValue(container, "scope", _scope); 
				getValue(container, "name", _name); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showClassPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final ClassPropertyEditor form = new ClassPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Class", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class FieldPropertyEditor extends SwingUtil.FormPanel {

			private final JComboBox _scope = new JComboBox();
			private final JTextField _name = new JTextField();

	      FieldPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Scope", 1, row);
	         add(_scope, 3, row);
				setValue(_scope, container, Properties.scope.name(), new String[] { "package","private","protected","public" });

	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, PropertyContainer container, String property, String[] values) {
	         component.setText(container.hasProperty(property) ? getString(container, property) : "");
	      }

			private void setValue(JCheckBox component, PropertyContainer container, String property, String[] values) {
	         component.setSelected(container.hasProperty(property) ? getString(container, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, PropertyContainer container, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = container.hasProperty(property) ? getString(container, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(PropertyContainer container) throws Exception {
				getValue(container, "scope", _scope); 
				getValue(container, "name", _name); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showFieldPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final FieldPropertyEditor form = new FieldPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Field", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class MethodPropertyEditor extends SwingUtil.FormPanel {

			private final JComboBox _scope = new JComboBox();
			private final JTextField _name = new JTextField();

	      MethodPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Scope", 1, row);
	         add(_scope, 3, row);
				setValue(_scope, container, Properties.scope.name(), new String[] { "package","private","protected","public" });

	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, PropertyContainer container, String property, String[] values) {
	         component.setText(container.hasProperty(property) ? getString(container, property) : "");
	      }

			private void setValue(JCheckBox component, PropertyContainer container, String property, String[] values) {
	         component.setSelected(container.hasProperty(property) ? getString(container, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, PropertyContainer container, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = container.hasProperty(property) ? getString(container, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(PropertyContainer container) throws Exception {
				getValue(container, "scope", _scope); 
				getValue(container, "name", _name); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showMethodPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final MethodPropertyEditor form = new MethodPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Method", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class InterfacePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      InterfacePropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, PropertyContainer container, String property, String[] values) {
	         component.setText(container.hasProperty(property) ? getString(container, property) : "");
	      }

			private void setValue(JCheckBox component, PropertyContainer container, String property, String[] values) {
	         component.setSelected(container.hasProperty(property) ? getString(container, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, PropertyContainer container, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = container.hasProperty(property) ? getString(container, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(PropertyContainer container) throws Exception {
				getValue(container, "name", _name); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showInterfacePropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final InterfacePropertyEditor form = new InterfacePropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Interface", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}



	static class JavaStatementPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _content = new JTextField();

	      JavaStatementPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Content", 1, row);
	         add(_content, 3, row);
				setValue(_content, container, Properties.content.name(), new String[] { });

	      }

			private void setValue(JTextField component, PropertyContainer container, String property, String[] values) {
	         component.setText(container.hasProperty(property) ? getString(container, property) : "");
	      }

			private void setValue(JCheckBox component, PropertyContainer container, String property, String[] values) {
	         component.setSelected(container.hasProperty(property) ? getString(container, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, PropertyContainer container, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = container.hasProperty(property) ? getString(container, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(PropertyContainer container) throws Exception {
				getValue(container, "content", _content); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showJavaStatementPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final JavaStatementPropertyEditor form = new JavaStatementPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "JavaStatement", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class GeneratorPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _root = new JTextField();
			private final JTextField _name = new JTextField();

	      GeneratorPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Root", 1, row);
	         add(_root, 3, row);
				setValue(_root, container, Properties.root.name(), new String[] { });

	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, PropertyContainer container, String property, String[] values) {
	         component.setText(container.hasProperty(property) ? getString(container, property) : "");
	      }

			private void setValue(JCheckBox component, PropertyContainer container, String property, String[] values) {
	         component.setSelected(container.hasProperty(property) ? getString(container, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, PropertyContainer container, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = container.hasProperty(property) ? getString(container, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(PropertyContainer container) throws Exception {
				getValue(container, "root", _root); 
				getValue(container, "name", _name); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showGeneratorPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final GeneratorPropertyEditor form = new GeneratorPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Generator", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class ParameterPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      ParameterPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, PropertyContainer container, String property, String[] values) {
	         component.setText(container.hasProperty(property) ? getString(container, property) : "");
	      }

			private void setValue(JCheckBox component, PropertyContainer container, String property, String[] values) {
	         component.setSelected(container.hasProperty(property) ? getString(container, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, PropertyContainer container, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = container.hasProperty(property) ? getString(container, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(PropertyContainer container) throws Exception {
				getValue(container, "name", _name); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showParameterPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final ParameterPropertyEditor form = new ParameterPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "parameter", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}













   public static abstract class JavaDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node n) {
         if (n == null) return null;
		  if (BaseDomainVisitor.hasLabel(n, Package.name())) return visitPackage(n);
		  if (BaseDomainVisitor.hasLabel(n, Class.name())) return visitClass(n);
		  if (BaseDomainVisitor.hasLabel(n, Field.name())) return visitField(n);
		  if (BaseDomainVisitor.hasLabel(n, Method.name())) return visitMethod(n);
		  if (BaseDomainVisitor.hasLabel(n, Interface.name())) return visitInterface(n);
		  if (BaseDomainVisitor.hasLabel(n, Constructor.name())) return visitConstructor(n);
		  if (BaseDomainVisitor.hasLabel(n, JavaStatement.name())) return visitJavaStatement(n);
		  if (BaseDomainVisitor.hasLabel(n, Generator.name())) return visitGenerator(n);
         return null;
      }

		<T> T visitPackage(Node node) {
         return null;
      }

		<T> T visitClass(Node node) {
         return null;
      }

		<T> T visitField(Node node) {
         return null;
      }

		<T> T visitMethod(Node node) {
         return null;
      }

		<T> T visitInterface(Node node) {
         return null;
      }

		<T> T visitConstructor(Node node) {
         return null;
      }

		<T> T visitJavaStatement(Node node) {
         return null;
      }

		<T> T visitGenerator(Node node) {
         return null;
      }

   }
}