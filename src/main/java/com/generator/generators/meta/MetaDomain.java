package com.generator.generators.meta;

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
import static com.generator.generators.meta.MetaDomain.Entities.*;
import static com.generator.generators.meta.MetaDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class MetaDomain implements IDomain {

   public enum Entities implements Label {
      Domain, Entity, Relation, Property
   }

   public enum Relations implements RelationshipType {
      ENTITY, PROPERTY, RELATION, SRC, DST, ENUM_VALUE
   }

   public enum Properties {
      name, packageName, color, root, label, cardinality, property, type, value
   }

   @Override
   public String getName() {
      return "Meta";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case Domain:
         	return newDomainPNode(node, editor);
         case Entity:
         	return newEntityPNode(node, editor);
         case Relation:
         	return newRelationPNode(node, editor);
         case Property:
         	return newPropertyPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported MetaDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newDomainPNode(Node node, NeoEditor editor) {
      return new DomainPNode(node, editor);
   }

   protected static class DomainPNode extends MetaDomainPNode {

      DomainPNode(Node node, NeoEditor editor) {
         super(node, Entities.Domain, "name", "#a6611a", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newEntityPNode(Node node, NeoEditor editor) {
      return new EntityPNode(node, editor);
   }

   protected static class EntityPNode extends MetaDomainPNode {

      EntityPNode(Node node, NeoEditor editor) {
         super(node, Entities.Entity, "name", "#dfc27d", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newRelationPNode(Node node, NeoEditor editor) {
      return new RelationPNode(node, editor);
   }

   protected static class RelationPNode extends MetaDomainPNode {

      RelationPNode(Node node, NeoEditor editor) {
         super(node, Entities.Relation, "name", "#80cdc1", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newPropertyPNode(Node node, NeoEditor editor) {
      return new PropertyPNode(node, editor);
   }

   protected static class PropertyPNode extends MetaDomainPNode {

      PropertyPNode(Node node, NeoEditor editor) {
         super(node, Entities.Property, "name", "#018571", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }


   private static class MetaDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final MetaDomain.Entities nodeType;

      MetaDomainPNode(Node node, MetaDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
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

	static class DomainPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _packageName = new JTextField();

	      DomainPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("PackageName", 1, row);
	         add(_packageName, 3, row);
				setValue(_packageName, node, Properties.packageName.name(), new String[] { });

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
				getValue(node, "packageName", _packageName); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class EntityPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _color = new JTextField();
			private final JTextField _root = new JTextField();
			private final JTextField _label = new JTextField();

	      EntityPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("Color", 1, row);
	         add(_color, 3, row);
				setValue(_color, node, Properties.color.name(), new String[] { });

	         row += 2;
	         addLabel("Root", 1, row);
	         add(_root, 3, row);
				setValue(_root, node, Properties.root.name(), new String[] { });

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
				getValue(node, "name", _name); 
				getValue(node, "color", _color); 
				getValue(node, "root", _root); 
				getValue(node, "label", _label); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class RelationPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JComboBox _cardinality = new JComboBox();
			private final JTextField _property = new JTextField();

	      RelationPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("Cardinality", 1, row);
	         add(_cardinality, 3, row);
				setValue(_cardinality, node, Properties.cardinality.name(), new String[] { "MANY","ONE" });

	         row += 2;
	         addLabel("Property", 1, row);
	         add(_property, 3, row);
				setValue(_property, node, Properties.property.name(), new String[] { });

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
				getValue(node, "cardinality", _cardinality); 
				getValue(node, "property", _property); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class PropertyPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _type = new JTextField();
			private final JTextField _value = new JTextField();

	      PropertyPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("Type", 1, row);
	         add(_type, 3, row);
				setValue(_type, node, Properties.type.name(), new String[] { });

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
				getValue(node, "type", _type); 
				getValue(node, "value", _value); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

   public static abstract class MetaDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node node) {
         if (node == null) return null;
		  if (BaseDomainVisitor.hasLabel(node, Domain.name())) return visitDomain(node);
		  if (BaseDomainVisitor.hasLabel(node, Entity.name())) return visitEntity(node);
		  if (BaseDomainVisitor.hasLabel(node, Relation.name())) return visitRelation(node);
		  if (BaseDomainVisitor.hasLabel(node, Property.name())) return visitProperty(node);
         return null;
      }

		<T> T visitDomain(Node node) {
         return null;
      }

		<T> T visitEntity(Node node) {
         return null;
      }

		<T> T visitRelation(Node node) {
         return null;
      }

		<T> T visitProperty(Node node) {
         return null;
      }

   }
}