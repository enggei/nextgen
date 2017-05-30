package com.generator.generators.easyFlow;

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
import static com.generator.generators.easyFlow.EasyFlowDomain.Entities.*;
import static com.generator.generators.easyFlow.EasyFlowDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class EasyFlowDomain implements IDomain {

   public enum Entities implements Label {
      Flow, ContextProperty, State, Event
   }

   public enum Relations implements RelationshipType {
      FROM, ON, FINISH, PROPERTY, TO
   }

   public enum Properties {
      name, packageName, root, extending, modifier, comment, type, value
   }

   @Override
   public String getName() {
      return "EasyFlow";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case Flow:
         	return newFlowPNode(node, editor);
         case ContextProperty:
         	return newContextPropertyPNode(node, editor);
         case State:
         	return newStatePNode(node, editor);
         case Event:
         	return newEventPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported EasyFlowDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newFlowPNode(Node node, NeoEditor editor) {
         return new FlowPNode(node, editor);
      }

   protected static class FlowPNode extends EasyFlowDomainPNode {

      FlowPNode(Node node, NeoEditor editor) {
         super(node, Entities.Flow, "name", "#7b3294", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showFlowPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.name.name(), this));
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.packageName.name(), this));
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.root.name(), this));
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.extending.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.ContextProperty, Relations.PROPERTY, this, event));
   		pop.add(editor.newAddNodeAction(Entities.State, Relations.FROM, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.ContextProperty)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.ContextProperty.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.State)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.State.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.ContextProperty.name())) {
            final Set<Node> nodes = outgoing.get(Entities.ContextProperty.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.PROPERTY, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.PROPERTY);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.State.name())) {
            final Set<Node> nodes = outgoing.get(Entities.State.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.FROM, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.FROM);
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
   		outgoing(node, Relations.PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
   		outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newContextPropertyPNode(Node node, NeoEditor editor) {
         return new ContextPropertyPNode(node, editor);
      }

   protected static class ContextPropertyPNode extends EasyFlowDomainPNode {

      ContextPropertyPNode(Node node, NeoEditor editor) {
         super(node, Entities.ContextProperty, "name", "#008837", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showContextPropertyPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.name.name(), this));
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.modifier.name(), this));
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.comment.name(), this));
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.type.name(), this));
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.value.name(), this));


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

   protected NeoPNode newStatePNode(Node node, NeoEditor editor) {
         return new StatePNode(node, editor);
      }

   protected static class StatePNode extends EasyFlowDomainPNode {

      StatePNode(Node node, NeoEditor editor) {
         super(node, Entities.State, "name", "#c2a5cf", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showStatePropertyEditor(StatePNode.this, editor, event);
   				updateView();
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.name.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.Event, Relations.ON, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.Event)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Event.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.Event.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Event.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.ON, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.ON);
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
   		outgoing(node, Relations.ON).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Event));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newEventPNode(Node node, NeoEditor editor) {
         return new EventPNode(node, editor);
      }

   protected static class EventPNode extends EasyFlowDomainPNode {

      EventPNode(Node node, NeoEditor editor) {
         super(node, Entities.Event, "name", "#a6dba0", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showEventPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(EasyFlowDomain.Properties.name.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.State, Relations.FINISH, this, event));
   		pop.add(editor.newAddNodeAction(Entities.State, Relations.TO, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.State)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.State.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.State)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.State.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.State.name())) {
            final Set<Node> nodes = outgoing.get(Entities.State.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.FINISH, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.FINISH);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.State.name())) {
            final Set<Node> nodes = outgoing.get(Entities.State.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.TO, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.TO);
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
   		outgoing(node, Relations.FINISH).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
   		outgoing(node, Relations.TO).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }


   private static class EasyFlowDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final EasyFlowDomain.Entities nodeType;

      EasyFlowDomainPNode(Node node, EasyFlowDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
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

	static class FlowPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _packageName = new JTextField();
			private final JTextField _root = new JTextField();
			private final JTextField _extending = new JTextField();

	      FlowPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("PackageName", 1, row);
	         add(_packageName, 3, row);
				setValue(_packageName, container, Properties.packageName.name(), new String[] { });

	         row += 2;
	         addLabel("Root", 1, row);
	         add(_root, 3, row);
				setValue(_root, container, Properties.root.name(), new String[] { });

	         row += 2;
	         addLabel("Extending", 1, row);
	         add(_extending, 3, row);
				setValue(_extending, container, Properties.extending.name(), new String[] { });

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
				getValue(container, "packageName", _packageName); 
				getValue(container, "root", _root); 
				getValue(container, "extending", _extending); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showFlowPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final FlowPropertyEditor form = new FlowPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Flow", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class ContextPropertyPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _modifier = new JTextField();
			private final JTextField _comment = new JTextField();
			private final JTextField _type = new JTextField();
			private final JTextField _value = new JTextField();

	      ContextPropertyPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("Modifier", 1, row);
	         add(_modifier, 3, row);
				setValue(_modifier, container, Properties.modifier.name(), new String[] { });

	         row += 2;
	         addLabel("Comment", 1, row);
	         add(_comment, 3, row);
				setValue(_comment, container, Properties.comment.name(), new String[] { });

	         row += 2;
	         addLabel("Type", 1, row);
	         add(_type, 3, row);
				setValue(_type, container, Properties.type.name(), new String[] { });

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
				getValue(container, "name", _name); 
				getValue(container, "modifier", _modifier); 
				getValue(container, "comment", _comment); 
				getValue(container, "type", _type); 
				getValue(container, "value", _value); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showContextPropertyPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final ContextPropertyPropertyEditor form = new ContextPropertyPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "ContextProperty", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class StatePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      StatePropertyEditor(PropertyContainer container) {
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

	static void showStatePropertyEditor(StatePNode pNode, NeoEditor editor, PInputEvent event) {
	   final StatePropertyEditor form = new StatePropertyEditor(pNode.node);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "State", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(pNode.node);
	         pNode.updateView();
	      });
	   });
	}

	static class EventPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      EventPropertyEditor(PropertyContainer container) {
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

	static void showEventPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final EventPropertyEditor form = new EventPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Event", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}


   public static abstract class EasyFlowDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node n) {
         if (n == null) return null;
		  if (BaseDomainVisitor.hasLabel(n, Flow.name())) return visitFlow(n);
		  if (BaseDomainVisitor.hasLabel(n, ContextProperty.name())) return visitContextProperty(n);
		  if (BaseDomainVisitor.hasLabel(n, State.name())) return visitState(n);
		  if (BaseDomainVisitor.hasLabel(n, Event.name())) return visitEvent(n);
         return null;
      }

		<T> T visitFlow(Node node) {
         return null;
      }

		<T> T visitContextProperty(Node node) {
         return null;
      }

		<T> T visitState(Node node) {
         return null;
      }

		<T> T visitEvent(Node node) {
         return null;
      }

   }
}