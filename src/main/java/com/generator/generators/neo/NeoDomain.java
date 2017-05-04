package com.generator.generators.neo;

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
import static com.generator.generators.neo.NeoDomain.Entities.*;
import static com.generator.generators.neo.NeoDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class NeoDomain implements IDomain {

   public enum Entities implements Label {
      Database, node, relation, property, label, _layout
   }

   public enum Relations implements RelationshipType {
      PROPERTY, NODES, LABEL, RELATIONS
   }

   public enum Properties {
      path, name, label, type, value
   }

   @Override
   public String getName() {
      return "Neo";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case Database:
         	return newDatabasePNode(node, editor);
         case node:
         	return newNodePNode(node, editor);
         case relation:
         	return newRelationPNode(node, editor);
         case property:
         	return newPropertyPNode(node, editor);
         case label:
         	return newLabelPNode(node, editor);
         case _layout:
         	return new_layoutPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported NeoDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newDatabasePNode(Node node, NeoEditor editor) {
         return new DatabasePNode(node, editor);
      }

      protected static class DatabasePNode extends NeoDomainPNode {

         DatabasePNode(Node node, NeoEditor editor) {
            super(node, Entities.Database, "name", "#7fc97f", editor);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   			outgoing(node, Relations.RELATIONS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.relation));
   			outgoing(node, Relations.NODES).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.node));
            editor.showAndLayout(pNodes, pNode);
         }

   		@Override
         public void showDependents() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            editor.showAndLayout(pNodes, pNode);
         }
      }

   protected NeoPNode newNodePNode(Node node, NeoEditor editor) {
         return new NodePNode(node, editor);
      }

      protected static class NodePNode extends NeoDomainPNode {

         NodePNode(Node node, NeoEditor editor) {
            super(node, Entities.node, "name", "#a6cee3", editor);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   			outgoing(node, Relations.PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.property));
   			outgoing(node, Relations.LABEL).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.label));
            editor.showAndLayout(pNodes, pNode);
         }

   		@Override
         public void showDependents() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   			incoming(node, Relations.NODES).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Database));
            editor.showAndLayout(pNodes, pNode);
         }
      }

   protected NeoPNode newRelationPNode(Node node, NeoEditor editor) {
         return new RelationPNode(node, editor);
      }

      protected static class RelationPNode extends NeoDomainPNode {

         RelationPNode(Node node, NeoEditor editor) {
            super(node, Entities.relation, "name", "#33a02c", editor);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   			outgoing(node, Relations.PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.property));
            editor.showAndLayout(pNodes, pNode);
         }

   		@Override
         public void showDependents() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   			incoming(node, Relations.RELATIONS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Database));
            editor.showAndLayout(pNodes, pNode);
         }
      }

   protected NeoPNode newPropertyPNode(Node node, NeoEditor editor) {
         return new PropertyPNode(node, editor);
      }

      protected static class PropertyPNode extends NeoDomainPNode {

         PropertyPNode(Node node, NeoEditor editor) {
            super(node, Entities.property, "name", "#b2df8a", editor);
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

   protected NeoPNode newLabelPNode(Node node, NeoEditor editor) {
         return new LabelPNode(node, editor);
      }

      protected static class LabelPNode extends NeoDomainPNode {

         LabelPNode(Node node, NeoEditor editor) {
            super(node, Entities.label, "name", "#1f78b4", editor);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            editor.showAndLayout(pNodes, pNode);
         }

   		@Override
         public void showDependents() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   			incoming(node, Relations.LABEL).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.node));
            editor.showAndLayout(pNodes, pNode);
         }
      }

   protected NeoPNode new_layoutPNode(Node node, NeoEditor editor) {
         return new _layoutPNode(node, editor);
      }

      protected static class _layoutPNode extends NeoDomainPNode {

         _layoutPNode(Node node, NeoEditor editor) {
            super(node, Entities._layout, "name", "#beaed4", editor);
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


   private static class NeoDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final NeoDomain.Entities nodeType;

      NeoDomainPNode(Node node, NeoDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
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
         pNode.setText(property == null ? "?" : node.getProperty(property).toString());
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

	static class DatabasePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _path = new JTextField();
			private final JTextField _name = new JTextField();

	      DatabasePropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Path", 1, row);
	         add(_path, 3, row);
				setValue(_path, node, Properties.path.name(), new String[] { });

	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

			private void setValue(JCheckBox component, Node node, String property, String[] values) {
	         component.setSelected(node.hasProperty(property) ? getString(node, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "path", _path); 
				getValue(node, "name", _name); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class nodePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _label = new JTextField();

	      nodePropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Label", 1, row);
	         add(_label, 3, row);
				setValue(_label, node, Properties.label.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

			private void setValue(JCheckBox component, Node node, String property, String[] values) {
	         component.setSelected(node.hasProperty(property) ? getString(node, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "label", _label); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class relationPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _type = new JTextField();

	      relationPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Type", 1, row);
	         add(_type, 3, row);
				setValue(_type, node, Properties.type.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

			private void setValue(JCheckBox component, Node node, String property, String[] values) {
	         component.setSelected(node.hasProperty(property) ? getString(node, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "type", _type); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class propertyPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _value = new JTextField();

	      propertyPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("Value", 1, row);
	         add(_value, 3, row);
				setValue(_value, node, Properties.value.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

			private void setValue(JCheckBox component, Node node, String property, String[] values) {
	         component.setSelected(node.hasProperty(property) ? getString(node, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "name", _name); 
				getValue(node, "value", _value); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class labelPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      labelPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

			private void setValue(JCheckBox component, Node node, String property, String[] values) {
	         component.setSelected(node.hasProperty(property) ? getString(node, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "name", _name); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class _layoutPropertyEditor extends SwingUtil.FormPanel {


	      _layoutPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "");

	         int row = -1;
	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

			private void setValue(JCheckBox component, Node node, String property, String[] values) {
	         component.setSelected(node.hasProperty(property) ? getString(node, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

   public static abstract class NeoDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node n) {
         if (n == null) return null;
		  if (BaseDomainVisitor.hasLabel(n, Database.name())) return visitDatabase(n);
		  if (BaseDomainVisitor.hasLabel(n, node.name())) return visitNode(n);
		  if (BaseDomainVisitor.hasLabel(n, relation.name())) return visitRelation(n);
		  if (BaseDomainVisitor.hasLabel(n, property.name())) return visitProperty(n);
		  if (BaseDomainVisitor.hasLabel(n, label.name())) return visitLabel(n);
		  if (BaseDomainVisitor.hasLabel(n, _layout.name())) return visit_layout(n);
         return null;
      }

		<T> T visitDatabase(Node node) {
         return null;
      }

		<T> T visitNode(Node node) {
         return null;
      }

		<T> T visitRelation(Node node) {
         return null;
      }

		<T> T visitProperty(Node node) {
         return null;
      }

		<T> T visitLabel(Node node) {
         return null;
      }

		<T> T visit_layout(Node node) {
         return null;
      }

   }
}