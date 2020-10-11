package nextgen.st;

import nextgen.st.domain.STParameterType;
import nextgen.st.domain.STTemplate;
import nextgen.st.model.STArgument;
import nextgen.st.model.STModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

import static nextgen.st.STAppPresentationModel.newAction;

public class STModelEditorForm extends JPanel {

   private final ResultsTableModel resultsModel = new ResultsTableModel();

   public STModelEditorForm() {
      super(new BorderLayout());
      setBackground(UIManager.getColor("Panel.background"));

      final JTable results = new JTable(resultsModel);
      results.setIntercellSpacing(new Dimension(0, 5));
      results.setShowGrid(false);
      results.setRowMargin(0);
      results.setRowHeight(150);
      results.getColumnModel().getColumn(0).setCellRenderer(new javax.swing.table.DefaultTableCellRenderer());
      results.getColumnModel().getColumn(1).setCellRenderer(new STValueElementRenderer());
      results.getColumnModel().getColumn(1).setCellEditor(new STValueElementEditor());

      final JScrollPane jScrollPane = new JScrollPane(results);
      jScrollPane.setBackground(UIManager.getColor("Panel.background"));
      jScrollPane.getVerticalScrollBar().setUnitIncrement(5);
      add(jScrollPane, BorderLayout.CENTER);
   }

   public void setModel(nextgen.st.model.STModel model) {
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

      final STTemplate stTemplate = appModel().db.getSTTemplate(model);

      stTemplate.getParameters()
            .filter(stParameter -> stParameter.getType().equals(STParameterType.SINGLE))
            .filter(stParameter -> stParameter.getArgumentType().equals("String") || stParameter.getArgumentType().equals("Object"))
            .forEach(stParameter -> {

               final Optional<STArgument> argument = model.getArguments()
                     .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                     .findFirst();

               stValues.add(new STValueElement(model, stTemplate, stParameter, argument.orElse(null)));
            });

      model.getArguments()
            .filter(stArgument -> stArgument.getValue() != null)
            .map(STArgument::getValue)
            .filter(stValue -> stValue.getType() != null)
            .filter(stValue -> stValue.getType().equals(nextgen.st.model.STValueType.STMODEL))
            .filter(stValue -> stValue.getStModel() != null)
            .forEach(stValue -> addSTValues(stValue.getStModel(), stValues));
   }

   private STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
   }


   private final class STValueElement {

      private final String name;
      private final nextgen.st.model.STModel model;
      private final nextgen.st.domain.STParameter stParameter;

      private nextgen.st.model.STArgument argument;
      private String text;

      public STValueElement(nextgen.st.model.STModel model, nextgen.st.domain.STTemplate stTemplate, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STArgument argument) {
         this.model = model;
         this.stParameter = stParameter;
         this.argument = argument;
         this.name = stTemplate.getName() + "." + stParameter.getName();
         this.text = argument == null ? "" : appModel().render(argument);
      }

      public void setValue(String s) {
         if (argument == null) {
            model.addArguments(argument = appModel().newSTArgument(stParameter, appModel().newSTValue(s)));
         } else {
            final nextgen.st.model.STValue value = argument.getValue();
            if (value == null) argument.setValue(appModel().newSTValue(s));
            else argument.getValue().setValue(s);
         }

         this.text = s;
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
         return column == 0 ? "Name" : "Value";
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
         return columnIndex == 0 ? String.class : STValueElement.class;
      }

      @Override
      public int findColumn(String columnName) {
         return columnName.equals("Name") ? 0 : 1;
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
            final STValueElement stValueElement = content.get(rowIndex);
            stValueElement.setValue(aValue.toString().trim());
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

      private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea component;
      private final org.fife.ui.rtextarea.RTextScrollPane scrollPane;
      private STValueElement element;

      STValueElementEditor() {
         this.component = nextgen.utils.SwingUtil.newRSyntaxTextArea(2, 40);
         this.component.addKeyListener(getEditorKeyListener());
         this.scrollPane = new org.fife.ui.rtextarea.RTextScrollPane(component);
         for (java.awt.event.MouseWheelListener mouseWheelListener : scrollPane.getMouseWheelListeners())
            scrollPane.removeMouseWheelListener(mouseWheelListener);

         final JPopupMenu pop = component.getPopupMenu();
         pop.addSeparator();
         pop.add(newAction("Save", actionEvent -> tryToSave()));
         pop.add(newAction("Append From Clipboard", actionEvent -> {
            if (!component.isEditable()) return;
            component.append(nextgen.utils.SwingUtil.fromClipboard().trim());
            component.setCaretPosition(0);
            tryToSave();
         }));
         pop.add(newAction("Clear", actionEvent -> {
            if (!component.isEditable()) return;
            component.append("");
            component.setCaretPosition(0);
            tryToSave();
         }));
         pop.add(newAction("Prepend From Clipboard", actionEvent -> {
            if (!component.isEditable()) return;
            component.setText(nextgen.utils.SwingUtil.fromClipboard().trim() + component.getText());
            component.setCaretPosition(0);
            tryToSave();
         }));
         pop.addSeparator();
         pop.add(newAction("To Clipboard", actionEvent -> nextgen.utils.SwingUtil.toClipboard(component.getText().trim())));
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
            System.out.println("tryToSave : ");
            appModel().doInTransaction(transaction -> element.setValue(component.getText()));
         }
      }

      @Override
      public Object getCellEditorValue() {
         return component.getText();
      }

      @Override
      public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
         this.element = (STValueElement) value;
         this.component.setText(element.text);
         this.component.setCaretPosition(0);
         return scrollPane;
      }
   }

   private final class STValueElementRenderer extends org.fife.ui.rsyntaxtextarea.RSyntaxTextArea implements javax.swing.table.TableCellRenderer {

      STValueElementRenderer() {
         super(2, 40);
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