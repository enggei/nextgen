package com.generator.generators.javareflection;

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
import static com.generator.generators.javareflection.JavaBuilderDomain.Entities.*;
import static com.generator.generators.javareflection.JavaBuilderDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class JavaBuilderDomain implements IDomain {

   public enum Entities implements Label {
      CLASS, PACKAGE, METHOD, INSTANCE, FIELD, CONSTRUCTOR, PARAMETER, INTERFACE, ENUM
   }

   public enum Relations implements RelationshipType {
      PARENT, PACKAGE, CONSTRUCTOR, PARAMETER, METHOD, INSTANCE_TYPE, INSTANCE_INITIALIZE, RETURN_TYPE, INTERFACE, FIELD, TYPE
   }

   public enum Properties {
      name, modifiers
   }

   @Override
   public String getName() {
      return "JavaBuilder";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case CLASS:
         	return newCLASSPNode(node, editor);
         case PACKAGE:
         	return newPACKAGEPNode(node, editor);
         case METHOD:
         	return newMETHODPNode(node, editor);
         case INSTANCE:
         	return newINSTANCEPNode(node, editor);
         case FIELD:
         	return newFIELDPNode(node, editor);
         case CONSTRUCTOR:
         	return newCONSTRUCTORPNode(node, editor);
         case PARAMETER:
         	return newPARAMETERPNode(node, editor);
         case INTERFACE:
         	return newINTERFACEPNode(node, editor);
         case ENUM:
         	return newENUMPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported JavaBuilderDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newCLASSPNode(Node node, NeoEditor editor) {
         return new CLASSPNode(node, editor);
      }

   protected static class CLASSPNode extends JavaBuilderDomainPNode {

      CLASSPNode(Node node, NeoEditor editor) {
         super(node, Entities.CLASS, "name", "#d8daeb", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showCLASSPropertyEditor(CLASSPNode.this, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(JavaBuilderDomain.Properties.name.name(), this));
   		pop.add(editor.newSetNodePropertyAction(JavaBuilderDomain.Properties.modifiers.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.METHOD, Relations.METHOD, this, event));
   		pop.add(editor.newAddNodeAction(Entities.FIELD, Relations.FIELD, this, event));
   		pop.add(editor.newAddNodeAction(Entities.CONSTRUCTOR, Relations.CONSTRUCTOR, this, event));
   		pop.add(editor.newAddNodeAction(Entities.PACKAGE, Relations.PACKAGE, this, event));

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
            if (selectedNode.node.hasLabel(Entities.METHOD)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.METHOD.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.FIELD)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.FIELD.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.CONSTRUCTOR)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.CONSTRUCTOR.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.PACKAGE)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.PACKAGE.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.PARAMETER)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.PARAMETER.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.FIELD)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.FIELD.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.METHOD.name())) {
            final Set<Node> nodes = outgoing.get(Entities.METHOD.name());
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

         if (outgoing.containsKey(Entities.FIELD.name())) {
            final Set<Node> nodes = outgoing.get(Entities.FIELD.name());
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

         if (outgoing.containsKey(Entities.CONSTRUCTOR.name())) {
            final Set<Node> nodes = outgoing.get(Entities.CONSTRUCTOR.name());
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

         if (outgoing.containsKey(Entities.PACKAGE.name())) {
            final Set<Node> nodes = outgoing.get(Entities.PACKAGE.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.PACKAGE, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.PACKAGE);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         // incoming
         if (incoming.containsKey(Entities.PARAMETER.name())) {
            final Set<Node> nodes = incoming.get(Entities.PARAMETER.name());
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

         if (incoming.containsKey(Entities.FIELD.name())) {
            final Set<Node> nodes = incoming.get(Entities.FIELD.name());
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

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		outgoing(node, Relations.METHOD).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.METHOD));
   		outgoing(node, Relations.FIELD).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.FIELD));
   		outgoing(node, Relations.CONSTRUCTOR).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.CONSTRUCTOR));
   		outgoing(node, Relations.PACKAGE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.PACKAGE));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.TYPE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.PARAMETER));
   		incoming(node, Relations.TYPE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.FIELD));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newPACKAGEPNode(Node node, NeoEditor editor) {
         return new PACKAGEPNode(node, editor);
      }

   protected static class PACKAGEPNode extends JavaBuilderDomainPNode {

      PACKAGEPNode(Node node, NeoEditor editor) {
         super(node, Entities.PACKAGE, "name", "#7f3b08", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(editor.newAddNodeAction(Entities.PACKAGE, Relations.PARENT, this, event));

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
            if (selectedNode.node.hasLabel(Entities.PACKAGE)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.PACKAGE.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.PACKAGE)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.PACKAGE.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.CLASS)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.CLASS.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.PACKAGE.name())) {
            final Set<Node> nodes = outgoing.get(Entities.PACKAGE.name());
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

         // incoming
         if (incoming.containsKey(Entities.PACKAGE.name())) {
            final Set<Node> nodes = incoming.get(Entities.PACKAGE.name());
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

         if (incoming.containsKey(Entities.CLASS.name())) {
            final Set<Node> nodes = incoming.get(Entities.CLASS.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.PACKAGE, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.PACKAGE);
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
   		outgoing(node, Relations.PARENT).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.PACKAGE));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.PARENT).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.PACKAGE));
   		incoming(node, Relations.PACKAGE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.CLASS));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newMETHODPNode(Node node, NeoEditor editor) {
         return new METHODPNode(node, editor);
      }

   protected static class METHODPNode extends JavaBuilderDomainPNode {

      METHODPNode(Node node, NeoEditor editor) {
         super(node, Entities.METHOD, "name", "#b2abd2", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showMETHODPropertyEditor(METHODPNode.this, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(JavaBuilderDomain.Properties.modifiers.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.PARAMETER, Relations.PARAMETER, this, event));

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
            if (selectedNode.node.hasLabel(Entities.PARAMETER)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.PARAMETER.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.CLASS)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.CLASS.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.INTERFACE)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.INTERFACE.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.PARAMETER.name())) {
            final Set<Node> nodes = outgoing.get(Entities.PARAMETER.name());
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

         // incoming
         if (incoming.containsKey(Entities.CLASS.name())) {
            final Set<Node> nodes = incoming.get(Entities.CLASS.name());
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

         if (incoming.containsKey(Entities.INTERFACE.name())) {
            final Set<Node> nodes = incoming.get(Entities.INTERFACE.name());
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
   		outgoing(node, Relations.PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.PARAMETER));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.METHOD).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.CLASS));
   		incoming(node, Relations.METHOD).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.INTERFACE));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newINSTANCEPNode(Node node, NeoEditor editor) {
         return new INSTANCEPNode(node, editor);
      }

   protected static class INSTANCEPNode extends JavaBuilderDomainPNode {

      INSTANCEPNode(Node node, NeoEditor editor) {
         super(node, Entities.INSTANCE, "name", "#542788", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {

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

   protected NeoPNode newFIELDPNode(Node node, NeoEditor editor) {
         return new FIELDPNode(node, editor);
      }

   protected static class FIELDPNode extends JavaBuilderDomainPNode {

      FIELDPNode(Node node, NeoEditor editor) {
         super(node, Entities.FIELD, "name", "#10AA33", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(editor.newAddNodeAction(Entities.CLASS, Relations.TYPE, this, event));

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
            if (selectedNode.node.hasLabel(Entities.CLASS)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.CLASS.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.CLASS)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.CLASS.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.CLASS.name())) {
            final Set<Node> nodes = outgoing.get(Entities.CLASS.name());
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
         if (incoming.containsKey(Entities.CLASS.name())) {
            final Set<Node> nodes = incoming.get(Entities.CLASS.name());
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
   		outgoing(node, Relations.TYPE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.CLASS));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.FIELD).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.CLASS));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newCONSTRUCTORPNode(Node node, NeoEditor editor) {
         return new CONSTRUCTORPNode(node, editor);
      }

   protected static class CONSTRUCTORPNode extends JavaBuilderDomainPNode {

      CONSTRUCTORPNode(Node node, NeoEditor editor) {
         super(node, Entities.CONSTRUCTOR, "name", "#4040bb", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(editor.newAddNodeAction(Entities.PARAMETER, Relations.PARAMETER, this, event));

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
            if (selectedNode.node.hasLabel(Entities.PARAMETER)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.PARAMETER.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.CLASS)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.CLASS.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.PARAMETER.name())) {
            final Set<Node> nodes = outgoing.get(Entities.PARAMETER.name());
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

         // incoming
         if (incoming.containsKey(Entities.CLASS.name())) {
            final Set<Node> nodes = incoming.get(Entities.CLASS.name());
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
   		outgoing(node, Relations.PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.PARAMETER));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.CONSTRUCTOR).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.CLASS));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newPARAMETERPNode(Node node, NeoEditor editor) {
         return new PARAMETERPNode(node, editor);
      }

   protected static class PARAMETERPNode extends JavaBuilderDomainPNode {

      PARAMETERPNode(Node node, NeoEditor editor) {
         super(node, Entities.PARAMETER, "name", "#4040CC", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(editor.newAddNodeAction(Entities.CLASS, Relations.TYPE, this, event));

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
            if (selectedNode.node.hasLabel(Entities.CLASS)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.CLASS.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            // incoming
            if (selectedNode.node.hasLabel(Entities.CONSTRUCTOR)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.CONSTRUCTOR.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.METHOD)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.METHOD.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.CLASS.name())) {
            final Set<Node> nodes = outgoing.get(Entities.CLASS.name());
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
         if (incoming.containsKey(Entities.CONSTRUCTOR.name())) {
            final Set<Node> nodes = incoming.get(Entities.CONSTRUCTOR.name());
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

         if (incoming.containsKey(Entities.METHOD.name())) {
            final Set<Node> nodes = incoming.get(Entities.METHOD.name());
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

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		outgoing(node, Relations.TYPE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.CLASS));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();

         incoming(node,Relations.PARAMETER).forEach(relationship -> {
            if(relationship.hasProperty(Entities.CONSTRUCTOR.name())) pNodes.put(uuidOf(other(node,relationship)),Entities.CONSTRUCTOR);
            else if(relationship.hasProperty(Entities.CONSTRUCTOR.name())) pNodes.put(uuidOf(other(node, relationship)), Entities.METHOD);
         });

   		incoming(node, Relations.PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.CONSTRUCTOR));
   		incoming(node, Relations.PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.METHOD));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newINTERFACEPNode(Node node, NeoEditor editor) {
         return new INTERFACEPNode(node, editor);
      }

   protected static class INTERFACEPNode extends JavaBuilderDomainPNode {

      INTERFACEPNode(Node node, NeoEditor editor) {
         super(node, Entities.INTERFACE, "name", "#d8da00", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(editor.newAddNodeAction(Entities.METHOD, Relations.METHOD, this, event));

   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.METHOD)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.METHOD.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.METHOD.name())) {
            final Set<Node> nodes = outgoing.get(Entities.METHOD.name());
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

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		outgoing(node, Relations.METHOD).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.METHOD));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newENUMPNode(Node node, NeoEditor editor) {
         return new ENUMPNode(node, editor);
      }

   protected static class ENUMPNode extends JavaBuilderDomainPNode {

      ENUMPNode(Node node, NeoEditor editor) {
         super(node, Entities.ENUM, "name", "#d800eb", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {

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


   private static class JavaBuilderDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      protected final Color defaultColor;
      private final String property;
      private final JavaBuilderDomain.Entities nodeType;

      JavaBuilderDomainPNode(Node node, JavaBuilderDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
         super(node, new PText(node.hasProperty(property) ? node.getProperty(property).toString() : getNameOrLabelFrom(node)), nodeType.name(), editor);
         this.defaultColor = defaultColor==null || defaultColor.length()==0 ? Color.BLACK : Color.decode(defaultColor);
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

	static class CLASSPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _modifiers = new JTextField();

	      CLASSPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("Modifiers", 1, row);
	         add(_modifiers, 3, row);
				setValue(_modifiers, container, Properties.modifiers.name(), new String[] { });

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
				getValue(container, "modifiers", _modifiers);
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showCLASSPropertyEditor(CLASSPNode pNode, NeoEditor editor, PInputEvent event) {
	   final CLASSPropertyEditor form = new CLASSPropertyEditor(pNode.node);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "CLASS", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(pNode.node);
				pNode.updateView();
	      });
	   });
	}



	static class METHODPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _modifiers = new JTextField();

	      METHODPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Modifiers", 1, row);
	         add(_modifiers, 3, row);
				setValue(_modifiers, container, Properties.modifiers.name(), new String[] { });

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
				getValue(container, "modifiers", _modifiers);
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showMETHODPropertyEditor(METHODPNode pNode, NeoEditor editor, PInputEvent event) {
	   final METHODPropertyEditor form = new METHODPropertyEditor(pNode.node);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "METHOD", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(pNode.node);
				pNode.updateView();
	      });
	   });
	}













	static class PACKAGEPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      PACKAGEPropertyEditor(PropertyContainer container) {
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

	static void showPACKAGEPropertyEditor(PACKAGEPNode pNode, NeoEditor editor, PInputEvent event) {
	   final PACKAGEPropertyEditor form = new PACKAGEPropertyEditor(pNode.node);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "PACKAGE", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(pNode.node);
				pNode.updateView();
	      });
	   });
	}



















   public static abstract class JavaBuilderDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node n) {
         if (n == null) return null;
		  if (BaseDomainVisitor.hasLabel(n, Entities.CLASS.name())) return visitCLASS(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.PACKAGE.name())) return visitPACKAGE(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.METHOD.name())) return visitMETHOD(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.INSTANCE.name())) return visitINSTANCE(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.FIELD.name())) return visitFIELD(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.CONSTRUCTOR.name())) return visitCONSTRUCTOR(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.PARAMETER.name())) return visitPARAMETER(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.INTERFACE.name())) return visitINTERFACE(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.ENUM.name())) return visitENUM(n);
         return null;
      }

		<T> T visitCLASS(Node node) {
         return null;
      }

		<T> T visitPACKAGE(Node node) {
         return null;
      }

		<T> T visitMETHOD(Node node) {
         return null;
      }

		<T> T visitINSTANCE(Node node) {
         return null;
      }

		<T> T visitFIELD(Node node) {
         return null;
      }

		<T> T visitCONSTRUCTOR(Node node) {
         return null;
      }

		<T> T visitPARAMETER(Node node) {
         return null;
      }

		<T> T visitINTERFACE(Node node) {
         return null;
      }

		<T> T visitENUM(Node node) {
         return null;
      }

   }
}