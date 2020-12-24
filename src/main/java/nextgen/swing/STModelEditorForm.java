package nextgen.swing;

import nextgen.model.STModel;
import nextgen.model.STTemplate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class STModelEditorForm extends AbstractEditor {

   private final ResultsTableModel resultsModel = new ResultsTableModel();

   public STModelEditorForm() {

      final JTable results = nextgen.swing.ComponentFactory.newJTable(resultsModel);
      results.setIntercellSpacing(new Dimension(0, 5));
      results.setAutoCreateRowSorter(true);
      results.setShowGrid(false);
      results.setRowMargin(0);
      results.getColumnModel().getColumn(0).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer());
      results.getColumnModel().getColumn(1).setCellRenderer(new STValueElementRenderer());
      results.getColumnModel().getColumn(1).setCellEditor(new STValueElementEditor());

      final JScrollPane jScrollPane = nextgen.swing.ComponentFactory.newJScrollPane(results);
      jScrollPane.setBackground(UIManager.getColor("Panel.background"));
      jScrollPane.getVerticalScrollBar().setUnitIncrement(5);
      add(jScrollPane, BorderLayout.CENTER);
   }

   public void setModel(nextgen.model.STModel model) {
      SwingUtilities.invokeLater(() -> {
         resultsModel.clear();
         appModel().doInTransaction(transaction -> {
                  final java.util.List<STValueElement> stValues = new ArrayList<>();
                  addSTValues(model, stValues);
                  resultsModel.setResult(stValues);
               }
         );
      });
   }

   private void addSTValues(STModel model, java.util.List<STValueElement> stValues) {

      final STTemplate stTemplate = model.getStTemplate();

      appModel().getSingleEnumsOrPrimitiveParameters(stTemplate)
            .forEach(stParameter -> stValues.add(new nextgen.swing.STModelEditorForm.STValueElement(model, stTemplate, stParameter, appModel().getArgument(stParameter, model))));

      appModel().getSTModelValues(model)
            .forEach(stValue -> addSTValues(stValue.getStModel(), stValues));
   }

   public void reset() {
      SwingUtilities.invokeLater(resultsModel::clear);
   }

   final class STValueElement {

      private final String name;
      private final nextgen.model.STModel model;
      private final nextgen.model.STParameter stParameter;
      private final java.util.List<nextgen.model.STEnumValue> stEnumValues;

      public String[] enumStrings;

      private nextgen.model.STArgument argument;
      private String text;

      public STValueElement(nextgen.model.STModel model, nextgen.model.STTemplate stTemplate, nextgen.model.STParameter stParameter, nextgen.model.STArgument argument) {
         this.model = model;
         this.stParameter = stParameter;
         this.argument = argument;
         this.name = stTemplate.getName() + "." + stParameter.getName();
         this.text = argument == null ? "" : appModel().render(argument);

         final nextgen.model.STEnum stEnum = appModel().findSTEnumByArgumentType(stParameter);
         this.stEnumValues = (stEnum == null) ? java.util.Collections.emptyList() : stEnum.getValuesSorted().collect(java.util.stream.Collectors.toList());
         if (!this.stEnumValues.isEmpty()) {
            enumStrings = new String[stEnumValues.size()];
            for (int i = 0; i < stEnumValues.size(); i++)
               enumStrings[i] = stEnumValues.get(i).getName();
         }
      }

      public void setValue(Object object) {

         if (!stEnumValues.isEmpty()) {

            stEnumValues.stream()
                  .filter(stEnumValue -> stEnumValue.getName().equals(object))
                  .findAny()
                  .ifPresent(stEnumValue -> {

                     if (argument == null) {
                        final nextgen.model.STValue stValue = appModel().db.newSTValue(stEnumValue);
                        argument = appModel().db.newSTArgument(stParameter, stValue);
                        model.addArguments(argument);
                        nextgen.events.NewSTArgument.post(argument, model, stParameter, stValue);

                     } else {
                        argument.setValue(appModel().db.newSTValue(stEnumValue));
                        nextgen.events.STArgumentChanged.post(model, argument);
                     }

                     this.text = argument == null ? "" : appModel().render(argument);
                  });

            return;
         }

         final String value = object == null ? "" : object.toString().trim();

         if (argument == null) {
            if (value.length() == 0) return;

            final nextgen.model.STValue stValue = appModel().db.newSTValue(value);
            argument = appModel().db.newSTArgument(stParameter, stValue);
            model.addArguments(argument);
            nextgen.events.NewSTArgument.post(argument, model, stParameter, stValue);
            if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(model);

         } else {

            if (value.length() == 0) {
               final String argumentUuid = argument.getUuid();
               model.removeArguments(argument);
               argument.delete();
               argument = null;
               nextgen.events.STArgumentDeleted.post(model, argumentUuid);
               if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(model);
               return;
            }

            argument.setValue(appModel().db.newSTValue(value));
            nextgen.events.STArgumentChanged.post(model, argument);
            if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(model);
         }

         this.text = value;
      }

      @Override
      public String toString() {
         return text;
      }
   }

   private class ResultsTableModel extends javax.swing.table.AbstractTableModel {

      private final java.util.List<STValueElement> content = new ArrayList<>();

      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
         return columnIndex == 1;
      }

      @Override
      public String getColumnName(int column) {
         return column == 0 ? "Parameter" : "Value";
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
         return columnIndex == 0 ? String.class : STValueElement.class;
      }

      @Override
      public int findColumn(String columnName) {
         return columnName.equals("Parameter") ? 0 : 1;
      }

      @Override
      public int getRowCount() {
         return content.size();
      }

      @Override
      public int getColumnCount() {
         return 2;
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
         return columnIndex == 0 ? content.get(rowIndex).name : content.get(rowIndex);
      }

      @Override
      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         appModel().doInTransaction(transaction -> {
            content.get(rowIndex).setValue(aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
         });
      }

      private void clear() {
         content.clear();
         fireTableDataChanged();
      }

      private void setResult(java.util.List<STValueElement> result) {
         content.addAll(result);
         fireTableDataChanged();
      }
   }

   private final class STValueElementEditor extends AbstractCellEditor implements javax.swing.table.TableCellEditor {

      private final JComboBox<String> enumComponent;
      private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textComponent;

      private STValueElement element;

      STValueElementEditor() {

         this.enumComponent = new javax.swing.JComboBox<>();

         this.textComponent = nextgen.utils.SwingUtil.newRSyntaxTextArea(1, 40);
         this.textComponent.addKeyListener(getEditorKeyListener());

         org.fife.ui.rtextarea.RTextScrollPane scrollPane = new org.fife.ui.rtextarea.RTextScrollPane(textComponent);
         for (java.awt.event.MouseWheelListener mouseWheelListener : scrollPane.getMouseWheelListeners())
            scrollPane.removeMouseWheelListener(mouseWheelListener);

         addPopupActions(textComponent).
               add(newAction("Save", actionEvent -> tryToSave()));
      }

      private java.awt.event.KeyListener getEditorKeyListener() {
         return new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent keyEvent) {
               if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
                  tryToSave();
               }
            }
         };
      }

      private void tryToSave() {
         if (element != null) {
            appModel().doInTransaction(transaction -> {
               if (!element.stEnumValues.isEmpty()) {
                  element.setValue(enumComponent.getSelectedItem());
               } else {
                  element.setValue(textComponent.getText());
               }
            });
         }
      }

      @Override
      public Object getCellEditorValue() {
         if (!element.stEnumValues.isEmpty()) return enumComponent.getSelectedItem();
         return textComponent.getText();
      }

      @Override
      public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

         this.element = (STValueElement) value;

         if (!element.stEnumValues.isEmpty()) {
            enumComponent.setModel(new javax.swing.DefaultComboBoxModel<>(element.enumStrings));
            enumComponent.setSelectedItem(element.text);
            return enumComponent;
         }

         this.textComponent.setText(element.text);
         this.textComponent.setCaretPosition(0);
         return textComponent;
      }
   }

   private final class STValueElementRenderer extends org.fife.ui.rsyntaxtextarea.RSyntaxTextArea implements javax.swing.table.TableCellRenderer {

      STValueElementRenderer() {
         super(1, 40);
         nextgen.utils.SwingUtil.decorate(this);
         setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
      }

      @Override
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         setText(((STValueElement) value).text);
         setCaretPosition(0);
         return this;
      }
   }
}