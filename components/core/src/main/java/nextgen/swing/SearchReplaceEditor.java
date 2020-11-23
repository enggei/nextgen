package nextgen.swing;

public abstract class SearchReplaceEditor extends AbstractEditor {

   private final javax.swing.JTable results;

   protected final javax.swing.JTextField txtSearch = new javax.swing.JTextField(30);
   protected final ResultsTableModel resultsModel;

   public SearchReplaceEditor() {

      this.resultsModel = new ResultsTableModel();

      final javax.swing.JPanel searchPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

      final javax.swing.JButton btnSearch = new javax.swing.JButton(getSearchAction(txtSearch));
      searchPanel.setBackground(javax.swing.UIManager.getColor("Panel.background"));
      searchPanel.add(new javax.swing.JLabel("Search"));
      searchPanel.add(txtSearch);
      searchPanel.add(btnSearch);
      txtSearch.addMouseListener(getSearchFieldMouseListener(txtSearch));

      final javax.swing.JPanel replacePanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
      final javax.swing.JTextField txtReplace = new javax.swing.JTextField(30);
      final javax.swing.JButton btnReplace = new javax.swing.JButton(getReplaceAction(txtSearch, txtReplace));
      replacePanel.setBackground(javax.swing.UIManager.getColor("Panel.background"));
      replacePanel.add(new javax.swing.JLabel("Replace with"));
      replacePanel.add(txtReplace);
      replacePanel.add(btnReplace);
      txtReplace.addMouseListener(getSearchFieldMouseListener(txtReplace));

      final javax.swing.JPanel north = new javax.swing.JPanel(new java.awt.GridLayout(2, 1));
      north.add(searchPanel);
      north.add(replacePanel);
      add(north, java.awt.BorderLayout.NORTH);

      results = new javax.swing.JTable(resultsModel);
      results.setIntercellSpacing(new java.awt.Dimension(0, 5));
      results.setShowGrid(false);
      results.setRowMargin(0);
      results.setRowHeight(150);
      results.getColumn("Result").setCellRenderer(new STValueElementRenderer());
      results.getColumn("Result").setCellEditor(new STValueElementEditor());

      final javax.swing.JScrollPane jScrollPane = new javax.swing.JScrollPane(results);
      jScrollPane.setBackground(javax.swing.UIManager.getColor("Panel.background"));
      jScrollPane.getVerticalScrollBar().setUnitIncrement(5);
      add(jScrollPane, java.awt.BorderLayout.CENTER);
   }

   protected abstract java.util.stream.Stream<nextgen.st.model.STModel> getSTModels();

   private java.awt.event.MouseListener getSearchFieldMouseListener(javax.swing.JTextField txtSearch) {
      return new java.awt.event.MouseAdapter() {
         @Override
         public void mouseClicked(java.awt.event.MouseEvent e) {
            if (javax.swing.SwingUtilities.isRightMouseButton(e)) {
               final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();
               pop.add(new javax.swing.AbstractAction("From clipboard") {
                  @Override
                  public void actionPerformed(java.awt.event.ActionEvent ae) {
                     txtSearch.setText(nextgen.utils.SwingUtil.fromClipboard().trim());
                  }
               });
               nextgen.utils.SwingUtil.showPopup(pop, txtSearch, e);
            }
         }
      };
   }

   protected javax.swing.Action getSearchAction(javax.swing.JTextField txtSearch) {
      return new javax.swing.AbstractAction("Search") {

         @Override
         public void actionPerformed(java.awt.event.ActionEvent e) {
            appModel().doLaterInTransaction(transaction -> {
               reset();
               final java.util.List<STValueElement> stValues = new java.util.ArrayList<>();
               getSTModels().forEach(stModel -> addSTValues(stModel, stValues));
               resultsModel.setResult(stValues);
            });
         }

         private void addSTValues(nextgen.st.model.STModel stModel, java.util.List<STValueElement> stValues) {
            stValues.addAll(stModel.getArguments()
                  .filter(stArgument -> stArgument.getValue() != null)
                  .map(nextgen.st.model.STArgument::getValue)
                  .filter(stValue -> stValue.getType() != null)
                  .filter(stValue -> stValue.getType().equals(nextgen.st.model.STValueType.PRIMITIVE))
                  .filter(nextgen.st.model.STValue::hasValue)
                  .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                  .map(STValueElement::new)
                  .collect(java.util.stream.Collectors.toList()));

            stModel.getArguments()
                  .forEach(stArgument -> stValues.addAll(stArgument.getKeyValues()
                        .filter(stArgumentKV -> stArgumentKV.getValue() != null)
                        .map(nextgen.st.model.STArgumentKV::getValue)
                        .filter(stValue -> stValue.getType() != null)
                        .filter(stValue -> stValue.getType().equals(nextgen.st.model.STValueType.PRIMITIVE))
                        .filter(nextgen.st.model.STValue::hasValue)
                        .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                        .map(STValueElement::new)
                        .collect(java.util.stream.Collectors.toList())));

            stModel.getArguments()
                  .filter(stArgument -> stArgument.getValue() != null)
                  .map(nextgen.st.model.STArgument::getValue)
                  .filter(stValue -> stValue.getType() != null)
                  .filter(stValue -> stValue.getType().equals(nextgen.st.model.STValueType.STMODEL))
                  .filter(stValue -> stValue.getStModel() != null)
                  .forEach(stValue -> addSTValues(stValue.getStModel(), stValues));
         }
      };
   }

   private javax.swing.Action getReplaceAction(javax.swing.JTextField txtSearch, javax.swing.JTextField txtReplace) {
      return new javax.swing.AbstractAction("Replace") {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent e) {
            javax.swing.SwingUtilities.invokeLater(() -> appModel().doInTransaction(transaction -> {
               resultsModel.content.forEach(stValueElement -> {
                  final String replaceAll = stValueElement.text.replace(txtSearch.getText(), txtReplace.getText());
                  stValueElement.stValue.setValue(replaceAll);
                  stValueElement.text = appModel().render(stValueElement.stValue);
               });
               resultsModel.fireTableDataChanged();
            }));
         }
      };
   }

   protected void reset() {
      javax.swing.CellEditor cellEditor = results.getCellEditor();
      if (cellEditor != null)
         if (cellEditor.getCellEditorValue() != null)
            cellEditor.stopCellEditing();
         else
            cellEditor.cancelCellEditing();
      resultsModel.clear();
   }

   protected final class STValueElement {

      private final nextgen.st.model.STValue stValue;
      private String text;

      protected STValueElement(nextgen.st.model.STValue stValue) {
         this.stValue = stValue;
         this.text = appModel().render(stValue);
      }

      @Override
      public String toString() {
         return text;
      }
   }

   protected class ResultsTableModel extends javax.swing.table.AbstractTableModel {

      private final java.util.List<STValueElement> content = new java.util.ArrayList<>();

      @Override
      public boolean isCellEditable(int rowIndex, int columnIndex) {
         return !content.isEmpty();
      }

      @Override
      public String getColumnName(int column) {
         return "Result";
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
         return STValueElement.class;
      }

      @Override
      public int findColumn(String columnName) {
         return 0;
      }

      @Override
      public int getRowCount() {
         return content.size();
      }

      @Override
      public int getColumnCount() {
         return 1;
      }

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
         return content.get(rowIndex);
      }

      @Override
      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         if (content.isEmpty()) return;
         appModel().doInTransaction(transaction -> {
            final STValueElement stValueElement = content.get(rowIndex);
            stValueElement.text = aValue.toString().trim();
            stValueElement.stValue.setValue(stValueElement.text);
            fireTableCellUpdated(rowIndex, columnIndex);
         });
      }

      protected void clear() {
         content.clear();
         fireTableDataChanged();
      }

      protected void setResult(java.util.List<STValueElement> result) {
         content.addAll(result);
         fireTableDataChanged();
      }
   }

   private final class STValueElementEditor extends javax.swing.AbstractCellEditor implements javax.swing.table.TableCellEditor {

      private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea component;
      private final org.fife.ui.rtextarea.RTextScrollPane scrollPane;
      private STValueElement element;

      STValueElementEditor() {
         this.component = nextgen.utils.SwingUtil.newRSyntaxTextArea(5, 40);
         this.component.addKeyListener(getEditorKeyListener());
         this.scrollPane = new org.fife.ui.rtextarea.RTextScrollPane(component);
         for (java.awt.event.MouseWheelListener mouseWheelListener : scrollPane.getMouseWheelListeners())
            scrollPane.removeMouseWheelListener(mouseWheelListener);

         final javax.swing.JPopupMenu pop = component.getPopupMenu();
         pop.addSeparator();
         pop.add(newAction("Save", actionEvent -> tryToSave()));
         pop.add(newAction("Append From Clipboard", actionEvent -> {
            if (!component.isEditable()) return;
            component.append(nextgen.utils.SwingUtil.fromClipboard().trim());
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
            appModel().doInTransaction(transaction -> element.stValue.setValue(component.getText()));
         }
      }

      @Override
      public Object getCellEditorValue() {
         return component.getText();
      }

      @Override
      public java.awt.Component getTableCellEditorComponent(javax.swing.JTable table, Object value, boolean isSelected, int row, int column) {
         this.element = (STValueElement) value;
         this.component.setText(element.text);
         this.component.setCaretPosition(0);
         return scrollPane;
      }
   }

   private final class STValueElementRenderer extends org.fife.ui.rsyntaxtextarea.RSyntaxTextArea implements javax.swing.table.TableCellRenderer {

      STValueElementRenderer() {
         super(5, 40);
         nextgen.utils.SwingUtil.decorate(this);
         setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.LIGHT_GRAY));
      }

      @Override
      public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
         setText(((STValueElement) value).text);
         setCaretPosition(0);
         return this;
      }
   }
}