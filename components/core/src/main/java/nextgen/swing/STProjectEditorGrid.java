package nextgen.swing;

public class STProjectEditorGrid extends AbstractEditor {

   private final nextgen.swing.STProjectEditorGrid.ResultsTableModel resultsModel;
   private final String uuid;
   private final nextgen.st.model.STProject model;

   public STProjectEditorGrid(nextgen.st.model.STProject model) {

      this.model = model;
      this.uuid = model.getUuid();
      this.resultsModel = new nextgen.swing.STProjectEditorGrid.ResultsTableModel();

      final javax.swing.JPanel searchPanel = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
      final javax.swing.JTextField txtSearch = new javax.swing.JTextField(30);
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

      final javax.swing.JTable results = new javax.swing.JTable(resultsModel);
      results.setIntercellSpacing(new java.awt.Dimension(0, 5));
      results.setShowGrid(false);
      results.setRowMargin(0);
      results.setRowHeight(150);
      results.getColumn("Result").setCellRenderer(new nextgen.swing.STProjectEditorGrid.STValueElementRenderer());
      results.getColumn("Result").setCellEditor(new nextgen.swing.STProjectEditorGrid.STValueElementEditor());

      final javax.swing.JScrollPane jScrollPane = new javax.swing.JScrollPane(results);
      jScrollPane.setBackground(javax.swing.UIManager.getColor("Panel.background"));
      jScrollPane.getVerticalScrollBar().setUnitIncrement(5);
      add(jScrollPane, java.awt.BorderLayout.CENTER);
   }

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

   private javax.swing.Action getSearchAction(javax.swing.JTextField txtSearch) {
      return new javax.swing.AbstractAction("Search") {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent e) {
            javax.swing.SwingUtilities.invokeLater(() -> {
               resultsModel.clear();
               appModel().doInTransaction(transaction -> {
                        final java.util.List<nextgen.swing.STProjectEditorGrid.STValueElement> stValues = new java.util.ArrayList<>();
                        nextgen.utils.STModelUtil.aggregateModels(model).forEach(stModel -> addSTValues(stModel, stValues));
                        resultsModel.setResult(stValues);
                     }
               );
            });
         }

         public void addSTValues(nextgen.st.model.STModel stModel, java.util.List<nextgen.swing.STProjectEditorGrid.STValueElement> stValues) {
            stValues.addAll(stModel.getArguments()
                  .filter(stArgument -> stArgument.getValue() != null)
                  .map(nextgen.st.model.STArgument::getValue)
                  .filter(stValue -> stValue.getType() != null)
                  .filter(stValue -> stValue.getType().equals(nextgen.st.model.STValueType.PRIMITIVE))
                  .filter(nextgen.st.model.STValue::hasValue)
                  .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                  .map(nextgen.swing.STProjectEditorGrid.STValueElement::new)
                  .collect(java.util.stream.Collectors.toList()));

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

   public void reset() {
      javax.swing.SwingUtilities.invokeLater(resultsModel::clear);
   }

   public nextgen.st.model.STProject getModel() {
      return model;
   }

   public String getUuid() {
      return uuid;
   }

   private final class STValueElement {

      private final nextgen.st.model.STValue stValue;
      private String text;

      private STValueElement(nextgen.st.model.STValue stValue) {
         this.stValue = stValue;
         this.text = appModel().render(stValue);
      }

      @Override
      public String toString() {
         return text;
      }
   }

   private class ResultsTableModel extends javax.swing.table.AbstractTableModel {

      private final java.util.List<nextgen.swing.STProjectEditorGrid.STValueElement> content = new java.util.ArrayList<>();

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
         return nextgen.swing.STProjectEditorGrid.STValueElement.class;
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
         appModel().doInTransaction(transaction -> {
            final nextgen.swing.STProjectEditorGrid.STValueElement stValueElement = content.get(rowIndex);
            stValueElement.text = aValue.toString().trim();
            stValueElement.stValue.setValue(stValueElement.text);
            fireTableCellUpdated(rowIndex, columnIndex);
         });
      }

      private void clear() {
         content.clear();
         fireTableDataChanged();
      }

      private void setResult(java.util.List<nextgen.swing.STProjectEditorGrid.STValueElement> result) {
         content.addAll(result);
         fireTableDataChanged();
      }
   }

   private final class STValueElementEditor extends javax.swing.AbstractCellEditor implements javax.swing.table.TableCellEditor {

      private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea component;
      private final org.fife.ui.rtextarea.RTextScrollPane scrollPane;
      private nextgen.swing.STProjectEditorGrid.STValueElement element;

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
         this.element = (nextgen.swing.STProjectEditorGrid.STValueElement) value;
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
         setText(((nextgen.swing.STProjectEditorGrid.STValueElement) value).text);
         setCaretPosition(0);
         return this;
      }
   }
}