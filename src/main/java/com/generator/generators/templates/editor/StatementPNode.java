package com.generator.generators.templates.editor;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.*;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateLabels.*;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.STATEMENT_PARAMETER;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.TEMPLATE_STATEMENT;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 10.01.17.
 */
class StatementPNode extends NeoPNode<PNode> {

   private final Node templateStatement;

   private final Color selectedColor = Color.RED;
   private final Color defaultColor;

   private final PText nodeName;

   StatementPNode(Node node, Node templateStatement, NeoEditor editor) {
      super(node, PPath.createRectangle(0, 0, 75, 65), Statement.name(), editor);

      this.defaultColor = new Color(Integer.valueOf("5, 112, 176".split(", ")[0]), Integer.valueOf("5, 112, 176".split(", ")[1]), Integer.valueOf("5, 112, 176".split(", ")[2]));

      this.nodeName = new PText();
      this.nodeName.setOffset(5, 5);
      this.nodeName.setFont(new Font("Hack", Font.PLAIN, 11));
      this.nodeName.setTextPaint(selected.get() ? selectedColor : this.defaultColor);
      this.pNode.addChild(nodeName);

      // getString(templateStatement, TemplateDomain.TemplateProperties.name.name())
      this.templateStatement = templateStatement;
      updateView();
   }

   @Override
   public String getNodeType() {
      return Statement.name();
   }

   @Override
   public void updateView() {

      final String property = getString(templateStatement, TemplateDomain.TemplateProperties.statementLabel.name());
      if (property == null) {
         nodeName.setText(getString(templateStatement, TemplateDomain.TemplateProperties.name.name()));
         return;
      }

      new StatementVisitor() {

         String label = null;

         @Override
         protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
            if (property.equals(name))
               nodeName.setText(label = TemplateDomain.renderReferenceNode(referenceNode, referenceNodeType));
         }

         @Override
         protected void onStatementEnd() {
            if (label == null)
               nodeName.setText(getString(templateStatement, TemplateDomain.TemplateProperties.name.name()));
         }
      }.visitStatement(node);
   }

   @Override
   public void expand() {

      final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

      new StatementVisitor() {

         @Override
         protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
            pNodes.put(uuidOf(referenceNode), referenceNodeType);
         }

         @Override
         protected void onListValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
            pNodes.put(uuidOf(referenceNode), referenceNodeType);
         }

         @Override
         protected void onStartKeyValueSet(String name, Node keyValueNode) {
            pNodes.put(uuidOf(keyValueNode), KeyValueSet);
         }
      }.visitStatement(node);

      editor.showAndLayout(pNodes, pNode);
   }

   @Override
   public void showDependents() {

      final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

      for (Relationship relationship : node.getRelationships(INCOMING)) {
         if (NeoEditor.isAppRelated(relationship)) continue;
         final Node other = other(node, relationship);
         if (hasLabel(other, TemplateDomain.TemplateLabels.Directory.name()))
            pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.Directory);
         else
            System.out.println(other.getLabels().iterator().next());
      }

      // also show TemplateStatement (makes logic sense)
      final Relationship relationship = singleOutgoing(node, TEMPLATE_STATEMENT);
      pNodes.put(uuidOf(other(node, relationship)), TemplateDomain.TemplateLabels.TemplateStatement);

      editor.showAndLayout(pNodes, pNode);
   }

   @Override
   public void onSelect() {
      nodeName.setTextPaint(Color.WHITE);
      pNode.setPaint(selectedColor);
   }

   @Override
   public void onUnselect() {
      nodeName.setTextPaint(defaultColor);
      pNode.setPaint(Color.WHITE);
   }

   @Override
   public void onStartHighlight() {
      nodeName.setTextPaint(Color.ORANGE);
      pNode.setPaint(defaultColor);
   }

   @Override
   public void onEndHighlight() {
      nodeName.setTextPaint(selected.get() ? selectedColor : defaultColor);
      pNode.setPaint(selected.get() ? defaultColor : Color.WHITE);
   }

   @Override
   public void showNodeActions(JPopupMenu pop, PInputEvent event) {

      final JMenu setMenu = new JMenu("Set");
      final JMenu addMenu = new JMenu("Add");
      final AtomicBoolean hasEditableParameters = new AtomicBoolean(false);
      new TemplateGroupVisitor() {
         @Override
         protected void onSingleTemplateParameter(String name, Node templateParameter) {

            // check if templateParameter has parameterNode.createRelationshipTo(templateStatement, TemplateDomain.TemplateRelations.STATEMENT_PARAMETER)
            final Relationship statementParameterRelation = BaseDomainVisitor.singleOutgoing(templateParameter, STATEMENT_PARAMETER);
            if (statementParameterRelation != null)
               return;

            setMenu.add(new SetSingleValue(name, event, templateParameter));
            hasEditableParameters.set(true);
         }

         @Override
         protected void onListTemplateParameter(String name, Node templateParameter) {
            addMenu.add(new AddListValues(name, templateParameter));
         }

         @Override
         protected void onKeyValueTemplateParameter(String name, String keys, Node templateParameter) {
            addMenu.add(new AddKeyValueSets(name, event, templateParameter));
         }
      }.visitTemplateStatement(templateStatement);

      final JMenu removeMenu = new JMenu("Remove");
      new StatementVisitor() {

         @Override
         protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
            removeMenu.add(new DetachReference(name, referenceNode, referenceNodeType));
         }

         @Override
         protected void onListValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
            removeMenu.add(new DetachReference(name, referenceNode, referenceNodeType));
         }
      }.visitStatement(node);

      if (addMenu.getMenuComponentCount() > 0) pop.add(addMenu);
      if (setMenu.getMenuComponentCount() > 0) pop.add(setMenu);
      if (removeMenu.getMenuComponentCount() > 0) pop.add(removeMenu);

      if (hasEditableParameters.get())
         pop.add(new Edit(event));

      pop.add(new RenderToClipboard());
      pop.add(new ShowTemplate(event));

      super.showNodeActions(pop, event);
   }

   @Override
   public void showTargetActions(JPopupMenu pop, PInputEvent event) {

      final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();

      if (selectedNodes.size() != 1) return;

      new TemplateGroupVisitor() {
         @Override
         protected void onSingleTemplateParameter(String name, Node templateParameter) {
            final Node selectedNode = selectedNodes.iterator().next().node;

            // check if templateParameter has parameterNode.createRelationshipTo(templateStatement, TemplateDomain.TemplateRelations.STATEMENT_PARAMETER)
            final Relationship statementParameterRelation = BaseDomainVisitor.singleOutgoing(templateParameter, STATEMENT_PARAMETER);
            if (statementParameterRelation != null) {
               if (!selectedNode.hasLabel(Statement))
                  return;  // if not a statement, disallow selected node for this parameter

               final Node templateStatementNode = other(templateParameter, statementParameterRelation);
               final Node selectedTemplateStatementNode = other(selectedNode, BaseDomainVisitor.singleOutgoing(selectedNode, TEMPLATE_STATEMENT));
               if (templateStatementNode.equals(selectedTemplateStatementNode))
                  pop.add(new SetSingleReference(name, templateParameter, selectedNode));
               return;
            }

            if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue))
               pop.add(new SetSingleReference(name, templateParameter, selectedNode));
         }

         @Override
         protected void onListTemplateParameter(String name, Node templateParameter) {
            final Node selectedNode = selectedNodes.iterator().next().node;
            if (selectedNode.hasLabel(Statement) || selectedNode.hasLabel(SingleValue))
               pop.add(new AddListReference(name, templateParameter, selectedNode));
         }
      }.visitTemplateStatement(templateStatement);
   }

   @Override
   public void renderTo(JTextComponent textArea) {
      editor.doInTransaction(tx -> {
         textArea.setText(TemplateDomain.render(node));
         textArea.setCaretPosition(0);
      });
   }

   private class SetSingleValue extends NeoEditor.TransactionAction {
      private final PInputEvent event;
      private final Node templateParameter;

      SetSingleValue(String name, PInputEvent event, Node templateParameter) {
         super("Set " + name, editor.getGraph(), editor.canvas);
         this.event = event;
         this.templateParameter = templateParameter;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final String newValue = SwingUtil.showInputDialog("Value", editor.canvas);
         if (newValue == null) return;

         final Node newSingleValue = TemplateDomain.newSingleValue(editor.getGraph(), newValue);
         TemplateDomain.setSingleReference(newSingleValue, node, RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name())), editor);
         // no need for editor.addRelation, as show-method will ensure its visible
         editor.
               show(uuidOf(newSingleValue), SingleValue.name()).
               setOffset(event);
      }
   }

   private class AddListValues extends NeoEditor.TransactionAction {
      private final Node templateParameter;

      AddListValues(String name, Node templateParameter) {
         super(name, editor.getGraph(), editor.canvas);
         this.templateParameter = templateParameter;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final String newValues = SwingUtil.showInputDialog("Value (for multiple values, separate by space)", editor.canvas);
         if (newValues == null) return;

         final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();
         for (String newValue : newValues.split(" ")) {

            final Node newListValue = TemplateDomain.newSingleValue(editor.getGraph(), newValue);
            TemplateDomain.addNodeReference(newListValue, node, RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name())));
            // no need for editor.addRelation, as show-method will ensure its visible
            pNodes.put(uuidOf(newListValue), SingleValue);
         }

         editor.showAndLayout(pNodes, pNode);
      }
   }

   private class DetachReference extends NeoEditor.TransactionAction {

      private final Node referencedNode;

      DetachReference(String name, Node referencedNode, TemplateDomain.TemplateLabels nodeType) {
         super("Remove " + name + " : " + TemplateDomain.renderReferenceNode(referencedNode, nodeType), editor.getGraph(), editor.canvas);
         this.referencedNode = referencedNode;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final AtomicBoolean nodeDetached = new AtomicBoolean(false);
         node.getRelationships(Direction.OUTGOING).forEach(relationship -> {
            if (other(node, relationship).equals(referencedNode)) {
               relationship.delete();
               nodeDetached.set(true);
            }
         });

         if (nodeDetached.get()) {
            try {
               TemplateDomain.deleteNode(referencedNode);
            } catch (NeoEditor.ReferenceException e1) {
               System.out.println("detached node " + uuidOf(referencedNode) + " is constrained. Not deleted.");
            }
         }
      }
   }

   private class AddKeyValueSets extends NeoEditor.TransactionAction {
      private final PInputEvent event;
      private final Node templateParameter;

      AddKeyValueSets(String name, PInputEvent event, Node templateParameter) {
         super(name, editor.getGraph(), editor.canvas);
         this.event = event;
         this.templateParameter = templateParameter;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final String[] keys = getString(templateParameter, TemplateDomain.TemplateProperties.keys.name()).split(" ");
         final java.util.List<Map<String, String>> valueMap = new ArrayList<>(8);
         for (int i = 0; i < 8; i++) valueMap.add(new LinkedHashMap<>());

         final JTable tblValues = new JTable(new AbstractTableModel() {
            @Override
            public int getRowCount() {
               return valueMap.size();
            }

            @Override
            public int getColumnCount() {
               return keys.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
               return valueMap.get(rowIndex).get(keys[columnIndex]);
            }

            @Override
            public String getColumnName(int column) {
               return keys[column];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
               return true;
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
               valueMap.get(rowIndex).put(keys[columnIndex], aValue == null ? null : aValue.toString().trim());
               fireTableCellUpdated(rowIndex, columnIndex);
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
               return String.class;
            }
         });

         final JPanel contentPanel = new JPanel(new BorderLayout());
         contentPanel.add(new JLabel("Add " + getString(templateParameter, TemplateDomain.TemplateProperties.name.name())));
         contentPanel.add(new JScrollPane(tblValues), BorderLayout.CENTER);
         contentPanel.setPreferredSize(new Dimension(640, 320));
         SwingUtil.showDialog(contentPanel, editor.canvas, "", () -> editor.doInTransaction(tx1 -> {

            final Set<UUID> newKeyValueSets = new LinkedHashSet<>();
            for (Map<String, String> map : valueMap) {

               final Map<String, String> validMap = new LinkedHashMap<>();
               for (String key : keys) {
                  final String value = map.get(key);
                  if (value == null || value.trim().length() == 0) continue;
                  validMap.put(key, value.trim());
               }
               if (validMap.isEmpty()) continue;

               final Node newKeyValueSet = TemplateDomain.newKeyValueSet(editor.getGraph(), node, templateParameter);
               for (Map.Entry<String, String> entry : validMap.entrySet())
                  TemplateDomain.setSingleReference(TemplateDomain.newSingleValue(editor.getGraph(), entry.getValue()), newKeyValueSet, RelationshipType.withName(entry.getKey()), editor);
               newKeyValueSets.add(uuidOf(newKeyValueSet));
            }

            for (UUID newKeyValueSet : newKeyValueSets) {
               editor.
                     show(newKeyValueSet, KeyValueSet.name()).
                     setOffset(event);
            }

            updateView();
         }));
      }
   }

   private class Edit extends NeoEditor.TransactionAction {

      private final PInputEvent event;

      public Edit(PInputEvent event) {
         super("Edit", editor.getGraph(), editor.canvas);
         this.event = event;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final Node templateStatement = other(node, singleOutgoing(node, TEMPLATE_STATEMENT));

         final Map<String, JTextField> singleValues = new LinkedHashMap<>();
         final Map<String, String> existingValues = new LinkedHashMap<>();
         final Map<String, Node> templateParameters = new LinkedHashMap<>();
         final StringBuilder rows = new StringBuilder();
         final AtomicInteger i = new AtomicInteger(0);
         new TemplateGroupVisitor() {
            @Override
            protected void onSingleTemplateParameter(String name, Node templateParameter) {
               if (TemplateDomain.isStatementParameter(templateParameter)) return;
               if (i.get() >= 1) rows.append(", 4dlu, ");
               rows.append("pref");
               singleValues.put(name, new JTextField());
               existingValues.put(name, "");
               templateParameters.put(name, templateParameter);
               i.incrementAndGet();
            }
         }.visitTemplateStatement(templateStatement);

         final SwingUtil.FormPanel form = new SwingUtil.FormPanel("50dlu, 4dlu, 150dlu:grow", rows.toString().trim());
         form.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
         new StatementVisitor() {
            @Override
            protected void onSingleValue(String name, Node referenceNode, TemplateDomain.TemplateLabels referenceNodeType) {
               // do not render statements (not editable through editor)
               if (TemplateDomain.TemplateLabels.Statement.equals(referenceNodeType)) return;
               final String value = TemplateDomain.renderReferenceNode(referenceNode, referenceNodeType);
               singleValues.get(name).setText(value);
               existingValues.put(name, value);
            }
         }.visitStatement(node);

         int row = 1;
         for (String key : singleValues.keySet()) {
            form.addLabel(key, 1, row);
            form.add(singleValues.get(key), 3, row);
            row += 2;
         }

         SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Statement", () -> editor.doInTransaction(tx1 -> {
            for (String singleValueName : singleValues.keySet()) {
               final String newValue = singleValues.get(singleValueName).getText();
               if (!newValue.equals(existingValues.get(singleValueName))) {

                  final Node newSingleValue = TemplateDomain.newSingleValue(editor.getGraph(), newValue);
                  TemplateDomain.setSingleReference(newSingleValue, node, RelationshipType.withName(get(templateParameters.get(singleValueName), TemplateDomain.TemplateProperties.name.name())), editor);
                  // no need for editor.addRelation, as show-method will ensure its visible
                  editor.
                        show(uuidOf(newSingleValue), SingleValue.name()).
                        setOffset(event);
               }
            }
         }));
      }
   }

   private class ShowTemplate extends NeoEditor.TransactionAction {
      private final PInputEvent event;

      ShowTemplate(PInputEvent event) {
         super("Show Template", editor.getGraph(), editor.canvas);
         this.event = event;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
         final Relationship relationship = singleOutgoing(node, TEMPLATE_STATEMENT);
         editor.
               show(uuidOf(other(node, relationship)), TemplateStatement.name()).
               setOffset(event);
      }
   }

   private class RenderToClipboard extends NeoEditor.TransactionAction {

      RenderToClipboard() {
         super("Copy to clipboard", editor.getGraph(), editor.canvas);
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
         SwingUtil.toClipboard(TemplateDomain.render(node));
      }
   }

   private class SetSingleReference extends NeoEditor.TransactionAction {
      private final Node templateParameter;
      private final Node selectedNode;

      SetSingleReference(String name, Node templateParameter, Node selectedNode) {
         super("Set " + name, editor.getGraph(), editor.canvas);
         this.templateParameter = templateParameter;
         this.selectedNode = selectedNode;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
         editor.addRelation(TemplateDomain.setSingleReference(selectedNode, node, RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name())), editor));
         updateView();
      }
   }

   private class AddListReference extends NeoEditor.TransactionAction {
      private final Node templateParameter;
      private final Node selectedNode;

      AddListReference(String name, Node templateParameter, Node selectedNode) {
         super("Add " + name, editor.getGraph(), editor.canvas);
         this.templateParameter = templateParameter;
         this.selectedNode = selectedNode;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
         editor.addRelation(TemplateDomain.addNodeReference(selectedNode, node, RelationshipType.withName(get(templateParameter, TemplateDomain.TemplateProperties.name.name()))));
         editor.clearMousePosition();
      }
   }
}
