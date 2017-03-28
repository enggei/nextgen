package com.generator.generators.json;

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
import static com.generator.generators.json.JsonDomain.Entities.*;
import static com.generator.generators.json.JsonDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class JsonDomain implements IDomain {

   public enum Entities implements Label {
      Object, Array, Pair, Value, Document
   }

   public enum Relations implements RelationshipType {
      PAIR, MEMBER, ELEMENT, VALUE
   }

   public enum Properties {
      name, value, type
   }

   @Override
   public String getName() {
      return "Json";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case Object:
         	return newObjectPNode(node, editor);
         case Array:
         	return newArrayPNode(node, editor);
         case Pair:
         	return newPairPNode(node, editor);
         case Value:
         	return newValuePNode(node, editor);
         case Document:
         	return newDocumentPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported JsonDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newObjectPNode(Node node, NeoEditor editor) {
      return new ObjectPNode(node, editor);
   }

   protected static class ObjectPNode extends JsonDomainPNode {

      ObjectPNode(Node node, NeoEditor editor) {
         super(node, Entities.Object, "name", "#fc8d62", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newArrayPNode(Node node, NeoEditor editor) {
      return new ArrayPNode(node, editor);
   }

   protected static class ArrayPNode extends JsonDomainPNode {

      ArrayPNode(Node node, NeoEditor editor) {
         super(node, Entities.Array, "name", "#8da0cb", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newPairPNode(Node node, NeoEditor editor) {
      return new PairPNode(node, editor);
   }

   protected static class PairPNode extends JsonDomainPNode {

      PairPNode(Node node, NeoEditor editor) {
         super(node, Entities.Pair, "name", "#e78ac3", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newValuePNode(Node node, NeoEditor editor) {
      return new ValuePNode(node, editor);
   }

   protected static class ValuePNode extends JsonDomainPNode {

      ValuePNode(Node node, NeoEditor editor) {
         super(node, Entities.Value, JsonDomain.Properties.value.name(), "#a6d854", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newDocumentPNode(Node node, NeoEditor editor) {
      return new DocumentPNode(node, editor);
   }

   protected static class DocumentPNode extends JsonDomainPNode {

      DocumentPNode(Node node, NeoEditor editor) {
         super(node, Entities.Document, "name", "#66c2a5", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }


   private static class JsonDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final JsonDomain.Entities nodeType;

      JsonDomainPNode(Node node, JsonDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
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

	static class ObjectPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      ObjectPropertyEditor(Node node) {
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

	static class ArrayPropertyEditor extends SwingUtil.FormPanel {


	      ArrayPropertyEditor(Node node) {
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

	static class PairPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      PairPropertyEditor(Node node) {
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

	static class ValuePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _value = new JTextField();

	      ValuePropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
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
				getValue(node, "value", _value); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class DocumentPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JComboBox _type = new JComboBox();

	      DocumentPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("Type", 1, row);
	         add(_type, 3, row);
				setValue(_type, node, Properties.type.name(), new String[] { "Array","Object" });

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
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

   public static abstract class JsonDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node node) {
         if (node == null) return null;
		  if (BaseDomainVisitor.hasLabel(node, Object.name())) return visitObject(node);
		  if (BaseDomainVisitor.hasLabel(node, Array.name())) return visitArray(node);
		  if (BaseDomainVisitor.hasLabel(node, Pair.name())) return visitPair(node);
		  if (BaseDomainVisitor.hasLabel(node, Value.name())) return visitValue(node);
		  if (BaseDomainVisitor.hasLabel(node, Document.name())) return visitDocument(node);
         return null;
      }

		<T> T visitObject(Node node) {
         return null;
      }

		<T> T visitArray(Node node) {
         return null;
      }

		<T> T visitPair(Node node) {
         return null;
      }

		<T> T visitValue(Node node) {
         return null;
      }

		<T> T visitDocument(Node node) {
         return null;
      }

   }
}