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
      TemplateGroup, TemplateStatement, SingleTemplateParameter, StatementTemplateParameter, ListTemplateParameter, KeyValueTemplateParameter, Statement, SingleValue, KeyValueSet, Reference
   }

   public enum Relations implements RelationshipType {
      TEMPLATE_GROUP, TEMPLATE_PARAMETER, IMPORT, TEMPLATE_STATEMENT, STATEMENT_PARAMETER, REFERENCE
   }

   public enum Properties {
      delimiter, packageName, text, statementLabel, name, keys, value, reference, relationType
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
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
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
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
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
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
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
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
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
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
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
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
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
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
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
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
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
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
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
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }


   private static class TemplateDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      final Color defaultColor;
      private final String property;
      private final TemplateDomain.Entities nodeType;

      TemplateDomainPNode(Node node, TemplateDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
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

	static class TemplateGroupPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _delimiter = new JTextField();
			private final JTextField _packageName = new JTextField();

	      TemplateGroupPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Delimiter", 1, row);
	         add(_delimiter, 3, row);
				setValue(_delimiter, node, Properties.delimiter.name(), new String[] { });

	         row += 2;
	         addLabel("PackageName", 1, row);
	         add(_packageName, 3, row);
				setValue(_packageName, node, Properties.packageName.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "delimiter", _delimiter); 
				getValue(node, "packageName", _packageName); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class TemplateStatementPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _text = new JTextField();
			private final JTextField _statementLabel = new JTextField();

	      TemplateStatementPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Text", 1, row);
	         add(_text, 3, row);
				setValue(_text, node, Properties.text.name(), new String[] { });

	         row += 2;
	         addLabel("StatementLabel", 1, row);
	         add(_statementLabel, 3, row);
				setValue(_statementLabel, node, Properties.statementLabel.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "text", _text); 
				getValue(node, "statementLabel", _statementLabel); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class SingleTemplateParameterPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      SingleTemplateParameterPropertyEditor(Node node) {
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

	static class StatementTemplateParameterPropertyEditor extends SwingUtil.FormPanel {


	      StatementTemplateParameterPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "");

	         int row = -1;
	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
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

	static class ListTemplateParameterPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      ListTemplateParameterPropertyEditor(Node node) {
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

	static class KeyValueTemplateParameterPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _keys = new JTextField();

	      KeyValueTemplateParameterPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("Keys", 1, row);
	         add(_keys, 3, row);
				setValue(_keys, node, Properties.keys.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "name", _name); 
				getValue(node, "keys", _keys); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class StatementPropertyEditor extends SwingUtil.FormPanel {


	      StatementPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "");

	         int row = -1;
	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
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

	static class SingleValuePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _value = new JTextField();

	      SingleValuePropertyEditor(Node node) {
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

	static class KeyValueSetPropertyEditor extends SwingUtil.FormPanel {


	      KeyValueSetPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "");

	         int row = -1;
	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
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

	static class ReferencePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _reference = new JTextField();
			private final JTextField _relationType = new JTextField();

	      ReferencePropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Reference", 1, row);
	         add(_reference, 3, row);
				setValue(_reference, node, Properties.reference.name(), new String[] { });

	         row += 2;
	         addLabel("RelationType", 1, row);
	         add(_relationType, 3, row);
				setValue(_relationType, node, Properties.relationType.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "reference", _reference); 
				getValue(node, "relationType", _relationType); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

   public static abstract class TemplateDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node node) {
         if (node == null) return null;
		  if (BaseDomainVisitor.hasLabel(node, TemplateGroup.name())) return visitTemplateGroup(node);
		  if (BaseDomainVisitor.hasLabel(node, TemplateStatement.name())) return visitTemplateStatement(node);
		  if (BaseDomainVisitor.hasLabel(node, SingleTemplateParameter.name())) return visitSingleTemplateParameter(node);
		  if (BaseDomainVisitor.hasLabel(node, StatementTemplateParameter.name())) return visitStatementTemplateParameter(node);
		  if (BaseDomainVisitor.hasLabel(node, ListTemplateParameter.name())) return visitListTemplateParameter(node);
		  if (BaseDomainVisitor.hasLabel(node, KeyValueTemplateParameter.name())) return visitKeyValueTemplateParameter(node);
		  if (BaseDomainVisitor.hasLabel(node, Statement.name())) return visitStatement(node);
		  if (BaseDomainVisitor.hasLabel(node, SingleValue.name())) return visitSingleValue(node);
		  if (BaseDomainVisitor.hasLabel(node, KeyValueSet.name())) return visitKeyValueSet(node);
		  if (BaseDomainVisitor.hasLabel(node, Reference.name())) return visitReference(node);
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

   }
}