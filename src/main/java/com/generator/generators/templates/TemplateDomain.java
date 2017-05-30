package com.generator.generators.templates;

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
import static com.generator.generators.templates.TemplateDomain.Entities.*;
import static com.generator.generators.templates.TemplateDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class TemplateDomain implements IDomain {

   public enum Entities implements Label {
      TemplateGroup, TemplateStatement, SingleTemplateParameter, StatementTemplateParameter, ListTemplateParameter, KeyValueTemplateParameter, Statement, SingleValue, KeyValueSet, Reference, Directory
   }

   public enum Relations implements RelationshipType {
      TEMPLATE_GROUP, TEMPLATE_PARAMETER, IMPORT, TEMPLATE_STATEMENT, STATEMENT_PARAMETER, REFERENCE
   }

   public enum Properties {
      delimiter, packageName, root, text, name, statementLabel, keys, value, reference, relationType
   }

   @Override
   public String getName() {
      return "Template";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case TemplateGroup:
         	return newTemplateGroupPNode(node, editor);
         case TemplateStatement:
         	return newTemplateStatementPNode(node, editor);
         case SingleTemplateParameter:
         	return newSingleTemplateParameterPNode(node, editor);
         case StatementTemplateParameter:
         	return newStatementTemplateParameterPNode(node, editor);
         case ListTemplateParameter:
         	return newListTemplateParameterPNode(node, editor);
         case KeyValueTemplateParameter:
         	return newKeyValueTemplateParameterPNode(node, editor);
         case Statement:
         	return newStatementPNode(node, editor);
         case SingleValue:
         	return newSingleValuePNode(node, editor);
         case KeyValueSet:
         	return newKeyValueSetPNode(node, editor);
         case Reference:
         	return newReferencePNode(node, editor);
         case Directory:
         	return newDirectoryPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported TemplateDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newTemplateGroupPNode(Node node, NeoEditor editor) {
         return new TemplateGroupPNode(node, editor);
      }

   protected static class TemplateGroupPNode extends TemplateDomainPNode {

      TemplateGroupPNode(Node node, NeoEditor editor) {
         super(node, Entities.TemplateGroup, "name", "#b15928", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showTemplateGroupPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(TemplateDomain.Properties.delimiter.name(), this));
   		pop.add(editor.newSetNodePropertyAction(TemplateDomain.Properties.packageName.name(), this));
   		pop.add(editor.newSetNodePropertyAction(TemplateDomain.Properties.root.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.TemplateGroup, Relations.IMPORT, this, event));
   		pop.add(editor.newAddNodeAction(Entities.TemplateGroup, Relations.TEMPLATE_GROUP, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.TemplateGroup)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.TemplateGroup.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.TemplateGroup)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.TemplateGroup.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.TemplateGroup.name())) {
            final Set<Node> nodes = outgoing.get(Entities.TemplateGroup.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.IMPORT, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.IMPORT);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.TemplateGroup.name())) {
            final Set<Node> nodes = outgoing.get(Entities.TemplateGroup.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.TEMPLATE_GROUP, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.TEMPLATE_GROUP);
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
   		outgoing(node, Relations.IMPORT).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.TemplateGroup));
   		outgoing(node, Relations.TEMPLATE_GROUP).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.TemplateGroup));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newTemplateStatementPNode(Node node, NeoEditor editor) {
         return new TemplateStatementPNode(node, editor);
      }

   protected static class TemplateStatementPNode extends TemplateDomainPNode {

      TemplateStatementPNode(Node node, NeoEditor editor) {
         super(node, Entities.TemplateStatement, "name", "#b2df8a", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showTemplateStatementPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(TemplateDomain.Properties.text.name(), this));
   		pop.add(editor.newSetNodePropertyAction(TemplateDomain.Properties.name.name(), this));
   		pop.add(editor.newSetNodePropertyAction(TemplateDomain.Properties.statementLabel.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.TemplateGroup, Relations.TEMPLATE_GROUP, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.TemplateGroup)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.TemplateGroup.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.TemplateGroup.name())) {
            final Set<Node> nodes = outgoing.get(Entities.TemplateGroup.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.TEMPLATE_GROUP, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.TEMPLATE_GROUP);
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
   		outgoing(node, Relations.TEMPLATE_GROUP).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.TemplateGroup));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newSingleTemplateParameterPNode(Node node, NeoEditor editor) {
         return new SingleTemplateParameterPNode(node, editor);
      }

   protected static class SingleTemplateParameterPNode extends TemplateDomainPNode {

      SingleTemplateParameterPNode(Node node, NeoEditor editor) {
         super(node, Entities.SingleTemplateParameter, "name", "#33a02c", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(editor.newAddNodeAction(Entities.TemplateStatement, Relations.TEMPLATE_PARAMETER, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.TemplateStatement)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.TemplateStatement.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.TemplateStatement.name())) {
            final Set<Node> nodes = outgoing.get(Entities.TemplateStatement.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.TEMPLATE_PARAMETER, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.TEMPLATE_PARAMETER);
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
   		outgoing(node, Relations.TEMPLATE_PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.TemplateStatement));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newStatementTemplateParameterPNode(Node node, NeoEditor editor) {
         return new StatementTemplateParameterPNode(node, editor);
      }

   protected static class StatementTemplateParameterPNode extends TemplateDomainPNode {

      StatementTemplateParameterPNode(Node node, NeoEditor editor) {
         super(node, Entities.StatementTemplateParameter, "name", "#fb9a99", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(editor.newAddNodeAction(Entities.TemplateStatement, Relations.TEMPLATE_PARAMETER, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.TemplateStatement)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.TemplateStatement.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.TemplateStatement.name())) {
            final Set<Node> nodes = outgoing.get(Entities.TemplateStatement.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.TEMPLATE_PARAMETER, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.TEMPLATE_PARAMETER);
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
   		outgoing(node, Relations.TEMPLATE_PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.TemplateStatement));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newListTemplateParameterPNode(Node node, NeoEditor editor) {
         return new ListTemplateParameterPNode(node, editor);
      }

   protected static class ListTemplateParameterPNode extends TemplateDomainPNode {

      ListTemplateParameterPNode(Node node, NeoEditor editor) {
         super(node, Entities.ListTemplateParameter, "name", "#ff7f00", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(editor.newAddNodeAction(Entities.TemplateStatement, Relations.TEMPLATE_PARAMETER, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.TemplateStatement)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.TemplateStatement.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.TemplateStatement.name())) {
            final Set<Node> nodes = outgoing.get(Entities.TemplateStatement.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.TEMPLATE_PARAMETER, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.TEMPLATE_PARAMETER);
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
   		outgoing(node, Relations.TEMPLATE_PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.TemplateStatement));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newKeyValueTemplateParameterPNode(Node node, NeoEditor editor) {
         return new KeyValueTemplateParameterPNode(node, editor);
      }

   protected static class KeyValueTemplateParameterPNode extends TemplateDomainPNode {

      KeyValueTemplateParameterPNode(Node node, NeoEditor editor) {
         super(node, Entities.KeyValueTemplateParameter, "name", "#6a3d9a", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showKeyValueTemplateParameterPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(TemplateDomain.Properties.keys.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.TemplateStatement, Relations.TEMPLATE_PARAMETER, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.TemplateStatement)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.TemplateStatement.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.TemplateStatement.name())) {
            final Set<Node> nodes = outgoing.get(Entities.TemplateStatement.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.TEMPLATE_PARAMETER, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.TEMPLATE_PARAMETER);
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
   		outgoing(node, Relations.TEMPLATE_PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.TemplateStatement));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newStatementPNode(Node node, NeoEditor editor) {
         return new StatementPNode(node, editor);
      }

   protected static class StatementPNode extends TemplateDomainPNode {

      StatementPNode(Node node, NeoEditor editor) {
         super(node, Entities.Statement, "name", "#cab2d6", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(editor.newAddNodeAction(Entities.TemplateStatement, Relations.TEMPLATE_STATEMENT, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.TemplateStatement)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.TemplateStatement.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.TemplateStatement.name())) {
            final Set<Node> nodes = outgoing.get(Entities.TemplateStatement.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.TEMPLATE_STATEMENT, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.TEMPLATE_STATEMENT);
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
   		outgoing(node, Relations.TEMPLATE_STATEMENT).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.TemplateStatement));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newSingleValuePNode(Node node, NeoEditor editor) {
         return new SingleValuePNode(node, editor);
      }

   protected static class SingleValuePNode extends TemplateDomainPNode {

      SingleValuePNode(Node node, NeoEditor editor) {
         super(node, Entities.SingleValue, "name", "#fdbf6f", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showSingleValuePropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(TemplateDomain.Properties.value.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.TemplateStatement, Relations.STATEMENT_PARAMETER, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.TemplateStatement)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.TemplateStatement.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.TemplateStatement.name())) {
            final Set<Node> nodes = outgoing.get(Entities.TemplateStatement.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.STATEMENT_PARAMETER, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.STATEMENT_PARAMETER);
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
   		outgoing(node, Relations.STATEMENT_PARAMETER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.TemplateStatement));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newKeyValueSetPNode(Node node, NeoEditor editor) {
         return new KeyValueSetPNode(node, editor);
      }

   protected static class KeyValueSetPNode extends TemplateDomainPNode {

      KeyValueSetPNode(Node node, NeoEditor editor) {
         super(node, Entities.KeyValueSet, "name", "#a6cee3", editor);
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

   protected NeoPNode newReferencePNode(Node node, NeoEditor editor) {
         return new ReferencePNode(node, editor);
      }

   protected static class ReferencePNode extends TemplateDomainPNode {

      ReferencePNode(Node node, NeoEditor editor) {
         super(node, Entities.Reference, "name", "#1f78b4", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showReferencePropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(TemplateDomain.Properties.reference.name(), this));
   		pop.add(editor.newSetNodePropertyAction(TemplateDomain.Properties.relationType.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.SingleValue, Relations.REFERENCE, this, event));
   		pop.add(editor.newAddNodeAction(Entities.KeyValueSet, Relations.REFERENCE, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.SingleValue)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.SingleValue.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.KeyValueSet)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.KeyValueSet.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.SingleValue.name())) {
            final Set<Node> nodes = outgoing.get(Entities.SingleValue.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.REFERENCE, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.REFERENCE);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.KeyValueSet.name())) {
            final Set<Node> nodes = outgoing.get(Entities.KeyValueSet.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.REFERENCE, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.REFERENCE);
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
   		outgoing(node, Relations.REFERENCE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.SingleValue));
   		outgoing(node, Relations.REFERENCE).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.KeyValueSet));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newDirectoryPNode(Node node, NeoEditor editor) {
         return new DirectoryPNode(node, editor);
      }

   protected static class DirectoryPNode extends TemplateDomainPNode {

      DirectoryPNode(Node node, NeoEditor editor) {
         super(node, Entities.Directory, "name", "#000000", editor);
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


   private static class TemplateDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      protected final Color defaultColor;
      private final String property;
      private final TemplateDomain.Entities nodeType;

      TemplateDomainPNode(Node node, TemplateDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
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

	static class TemplateGroupPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _delimiter = new JTextField();
			private final JTextField _packageName = new JTextField();
			private final JTextField _root = new JTextField();

	      TemplateGroupPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Delimiter", 1, row);
	         add(_delimiter, 3, row);
				setValue(_delimiter, container, Properties.delimiter.name(), new String[] { });

	         row += 2;
	         addLabel("PackageName", 1, row);
	         add(_packageName, 3, row);
				setValue(_packageName, container, Properties.packageName.name(), new String[] { });

	         row += 2;
	         addLabel("Root", 1, row);
	         add(_root, 3, row);
				setValue(_root, container, Properties.root.name(), new String[] { });

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
				getValue(container, "delimiter", _delimiter); 
				getValue(container, "packageName", _packageName); 
				getValue(container, "root", _root); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showTemplateGroupPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final TemplateGroupPropertyEditor form = new TemplateGroupPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "TemplateGroup", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class TemplateStatementPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _text = new JTextField();
			private final JTextField _name = new JTextField();
			private final JTextField _statementLabel = new JTextField();

	      TemplateStatementPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Text", 1, row);
	         add(_text, 3, row);
				setValue(_text, container, Properties.text.name(), new String[] { });

	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("StatementLabel", 1, row);
	         add(_statementLabel, 3, row);
				setValue(_statementLabel, container, Properties.statementLabel.name(), new String[] { });

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
				getValue(container, "text", _text); 
				getValue(container, "name", _name); 
				getValue(container, "statementLabel", _statementLabel); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showTemplateStatementPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final TemplateStatementPropertyEditor form = new TemplateStatementPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "TemplateStatement", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}







	static class KeyValueTemplateParameterPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _keys = new JTextField();

	      KeyValueTemplateParameterPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Keys", 1, row);
	         add(_keys, 3, row);
				setValue(_keys, container, Properties.keys.name(), new String[] { });

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
				getValue(container, "keys", _keys); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showKeyValueTemplateParameterPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final KeyValueTemplateParameterPropertyEditor form = new KeyValueTemplateParameterPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "KeyValueTemplateParameter", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}



	static class SingleValuePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _value = new JTextField();

	      SingleValuePropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Value", 1, row);
	         add(_value, 3, row);
				setValue(_value, container, Properties.value.name(), new String[] { });

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
				getValue(container, "value", _value); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showSingleValuePropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final SingleValuePropertyEditor form = new SingleValuePropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "SingleValue", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}



	static class ReferencePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _reference = new JTextField();
			private final JTextField _relationType = new JTextField();

	      ReferencePropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Reference", 1, row);
	         add(_reference, 3, row);
				setValue(_reference, container, Properties.reference.name(), new String[] { });

	         row += 2;
	         addLabel("RelationType", 1, row);
	         add(_relationType, 3, row);
				setValue(_relationType, container, Properties.relationType.name(), new String[] { });

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
				getValue(container, "reference", _reference); 
				getValue(container, "relationType", _relationType); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showReferencePropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final ReferencePropertyEditor form = new ReferencePropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Reference", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}




   public static abstract class TemplateDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node n) {
         if (n == null) return null;
		  if (BaseDomainVisitor.hasLabel(n, Entities.TemplateGroup.name())) return visitTemplateGroup(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.TemplateStatement.name())) return visitTemplateStatement(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.SingleTemplateParameter.name())) return visitSingleTemplateParameter(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.StatementTemplateParameter.name())) return visitStatementTemplateParameter(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.ListTemplateParameter.name())) return visitListTemplateParameter(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.KeyValueTemplateParameter.name())) return visitKeyValueTemplateParameter(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.Statement.name())) return visitStatement(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.SingleValue.name())) return visitSingleValue(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.KeyValueSet.name())) return visitKeyValueSet(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.Reference.name())) return visitReference(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.Directory.name())) return visitDirectory(n);
         return null;
      }

		<T> T visitTemplateGroup(Node node) {
         return null;
      }

		<T> T visitTemplateStatement(Node node) {
         return null;
      }

		<T> T visitSingleTemplateParameter(Node node) {
         return null;
      }

		<T> T visitStatementTemplateParameter(Node node) {
         return null;
      }

		<T> T visitListTemplateParameter(Node node) {
         return null;
      }

		<T> T visitKeyValueTemplateParameter(Node node) {
         return null;
      }

		<T> T visitStatement(Node node) {
         return null;
      }

		<T> T visitSingleValue(Node node) {
         return null;
      }

		<T> T visitKeyValueSet(Node node) {
         return null;
      }

		<T> T visitReference(Node node) {
         return null;
      }

		<T> T visitDirectory(Node node) {
         return null;
      }

   }
}