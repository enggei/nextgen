package com.generator.generators.mysql;

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
import static com.generator.generators.mysql.MysqlDomain.Entities.*;
import static com.generator.generators.mysql.MysqlDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class MysqlDomain implements IDomain {

   public enum Entities implements Label {
      column, database, table, key, TableOption, IndexKey, ForeignKey, UniqueKey
   }

   public enum Relations implements RelationshipType {
      TABLE, COLUMN, KEYS, TABLEOPTION, COLUMNS
   }

   public enum Properties {
      name, type, comment, nullable, defaultValue, onUpdate, autoIncrement, primaryKeyType, value, indexType, onDelete
   }

   @Override
   public String getName() {
      return "Mysql";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case column:
         	return newColumnPNode(node, editor);
         case database:
         	return newDatabasePNode(node, editor);
         case table:
         	return newTablePNode(node, editor);
         case key:
         	return newKeyPNode(node, editor);
         case TableOption:
         	return newTableOptionPNode(node, editor);
         case IndexKey:
         	return newIndexKeyPNode(node, editor);
         case ForeignKey:
         	return newForeignKeyPNode(node, editor);
         case UniqueKey:
         	return newUniqueKeyPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported MysqlDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newColumnPNode(Node node, NeoEditor editor) {
      return new ColumnPNode(node, editor);
   }

   protected static class ColumnPNode extends MysqlDomainPNode {

      ColumnPNode(Node node, NeoEditor editor) {
         super(node, Entities.column, "name", "#7bccc4", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newDatabasePNode(Node node, NeoEditor editor) {
      return new DatabasePNode(node, editor);
   }

   protected static class DatabasePNode extends MysqlDomainPNode {

      DatabasePNode(Node node, NeoEditor editor) {
         super(node, Entities.database, "name", "#2b8cbe", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newTablePNode(Node node, NeoEditor editor) {
      return new TablePNode(node, editor);
   }

   protected static class TablePNode extends MysqlDomainPNode {

      TablePNode(Node node, NeoEditor editor) {
         super(node, Entities.table, "name", "#bae4bc", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newKeyPNode(Node node, NeoEditor editor) {
      return new KeyPNode(node, editor);
   }

   protected static class KeyPNode extends MysqlDomainPNode {

      KeyPNode(Node node, NeoEditor editor) {
         super(node, Entities.key, "name", "", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newTableOptionPNode(Node node, NeoEditor editor) {
      return new TableOptionPNode(node, editor);
   }

   protected static class TableOptionPNode extends MysqlDomainPNode {

      TableOptionPNode(Node node, NeoEditor editor) {
         super(node, Entities.TableOption, "name", "", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newIndexKeyPNode(Node node, NeoEditor editor) {
      return new IndexKeyPNode(node, editor);
   }

   protected static class IndexKeyPNode extends MysqlDomainPNode {

      IndexKeyPNode(Node node, NeoEditor editor) {
         super(node, Entities.IndexKey, "name", "", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newForeignKeyPNode(Node node, NeoEditor editor) {
      return new ForeignKeyPNode(node, editor);
   }

   protected static class ForeignKeyPNode extends MysqlDomainPNode {

      ForeignKeyPNode(Node node, NeoEditor editor) {
         super(node, Entities.ForeignKey, "name", "", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newUniqueKeyPNode(Node node, NeoEditor editor) {
      return new UniqueKeyPNode(node, editor);
   }

   protected static class UniqueKeyPNode extends MysqlDomainPNode {

      UniqueKeyPNode(Node node, NeoEditor editor) {
         super(node, Entities.UniqueKey, "name", "", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }


   private static class MysqlDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final MysqlDomain.Entities nodeType;

      MysqlDomainPNode(Node node, MysqlDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
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

	static class columnPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _type = new JTextField();
			private final JTextField _comment = new JTextField();
			private final JCheckBox _nullable = new JCheckBox();
			private final JTextField _defaultValue = new JTextField();
			private final JTextField _onUpdate = new JTextField();
			private final JTextField _autoIncrement = new JTextField();

	      columnPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu");

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
	         addLabel("Comment", 1, row);
	         add(_comment, 3, row);
				setValue(_comment, node, Properties.comment.name(), new String[] { });

	         row += 2;
	         addLabel("Nullable", 1, row);
	         add(_nullable, 3, row);
				setValue(_nullable, node, Properties.nullable.name(), new String[] { });

	         row += 2;
	         addLabel("DefaultValue", 1, row);
	         add(_defaultValue, 3, row);
				setValue(_defaultValue, node, Properties.defaultValue.name(), new String[] { });

	         row += 2;
	         addLabel("OnUpdate", 1, row);
	         add(_onUpdate, 3, row);
				setValue(_onUpdate, node, Properties.onUpdate.name(), new String[] { });

	         row += 2;
	         addLabel("AutoIncrement", 1, row);
	         add(_autoIncrement, 3, row);
				setValue(_autoIncrement, node, Properties.autoIncrement.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

			private void setValue(JCheckBox component, Node node, String property, String[] values) {
	         component.setSelected(node.hasProperty(property) && getString(node, property).toLowerCase().startsWith("boo"));
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
				getValue(node, "comment", _comment); 
				getValue(node, "nullable", _nullable); 
				getValue(node, "defaultValue", _defaultValue); 
				getValue(node, "onUpdate", _onUpdate); 
				getValue(node, "autoIncrement", _autoIncrement); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }

	      private void getValue(Node node, String property, JCheckBox component) {
	         node.setProperty(property, component.isSelected() ? "true" : null);
	      }
	   }

	static class databasePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      databasePropertyEditor(Node node) {
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

	static class tablePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _primaryKeyType = new JTextField();

	      tablePropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("PrimaryKeyType", 1, row);
	         add(_primaryKeyType, 3, row);
				setValue(_primaryKeyType, node, Properties.primaryKeyType.name(), new String[] { });

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
				getValue(node, "primaryKeyType", _primaryKeyType); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class keyPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _type = new JTextField();

	      keyPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

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

	static class TableOptionPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _value = new JTextField();

	      TableOptionPropertyEditor(Node node) {
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

	static class IndexKeyPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _indexType = new JTextField();

	      IndexKeyPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("IndexType", 1, row);
	         add(_indexType, 3, row);
				setValue(_indexType, node, Properties.indexType.name(), new String[] { });

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
				getValue(node, "indexType", _indexType); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class ForeignKeyPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _onDelete = new JTextField();
			private final JTextField _onUpdate = new JTextField();

	      ForeignKeyPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("OnDelete", 1, row);
	         add(_onDelete, 3, row);
				setValue(_onDelete, node, Properties.onDelete.name(), new String[] { });

	         row += 2;
	         addLabel("OnUpdate", 1, row);
	         add(_onUpdate, 3, row);
				setValue(_onUpdate, node, Properties.onUpdate.name(), new String[] { });

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
				getValue(node, "onDelete", _onDelete); 
				getValue(node, "onUpdate", _onUpdate); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class UniqueKeyPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _indexType = new JTextField();

	      UniqueKeyPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("IndexType", 1, row);
	         add(_indexType, 3, row);
				setValue(_indexType, node, Properties.indexType.name(), new String[] { });

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
				getValue(node, "indexType", _indexType); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

   public static abstract class MysqlDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node node) {
         if (node == null) return null;
		  if (BaseDomainVisitor.hasLabel(node, column.name())) return visitColumn(node);
		  if (BaseDomainVisitor.hasLabel(node, database.name())) return visitDatabase(node);
		  if (BaseDomainVisitor.hasLabel(node, table.name())) return visitTable(node);
		  if (BaseDomainVisitor.hasLabel(node, key.name())) return visitKey(node);
		  if (BaseDomainVisitor.hasLabel(node, TableOption.name())) return visitTableOption(node);
		  if (BaseDomainVisitor.hasLabel(node, IndexKey.name())) return visitIndexKey(node);
		  if (BaseDomainVisitor.hasLabel(node, ForeignKey.name())) return visitForeignKey(node);
		  if (BaseDomainVisitor.hasLabel(node, UniqueKey.name())) return visitUniqueKey(node);
         return null;
      }

		<T> T visitColumn(Node node) {
         return null;
      }

		<T> T visitDatabase(Node node) {
         return null;
      }

		<T> T visitTable(Node node) {
         return null;
      }

		<T> T visitKey(Node node) {
         return null;
      }

		<T> T visitTableOption(Node node) {
         return null;
      }

		<T> T visitIndexKey(Node node) {
         return null;
      }

		<T> T visitForeignKey(Node node) {
         return null;
      }

		<T> T visitUniqueKey(Node node) {
         return null;
      }

   }
}