package nextgen.swing;

import nextgen.events.STValueSelected;
import nextgen.model.STValue;
import nextgen.swing.forms.SearchForm;
import nextgen.swing.table.STValueTable;

public abstract class SearchReplaceEditor extends AbstractEditor {

   protected final STValueTable results = new STValueTable();
   protected final javax.swing.JTextField txtSearch = nextgen.swing.ComponentFactory.newJTextField(30);

   public SearchReplaceEditor() {

      final javax.swing.JButton btnSearch = nextgen.swing.ComponentFactory.newJButton(getSearchAction(txtSearch));
      final javax.swing.JTextField txtReplace = nextgen.swing.ComponentFactory.newJTextField(30);
      final javax.swing.JButton btnReplace = nextgen.swing.ComponentFactory.newJButton(getReplaceAction(txtSearch, txtReplace));
      final javax.swing.JScrollPane jScrollPane = nextgen.swing.ComponentFactory.newJScrollPane(results);
      jScrollPane.getVerticalScrollBar().setUnitIncrement(15);

      results.setSelectionListener(STValueSelected::post);

      add(new SearchForm()
            .setSearch(newLabel("Search"))
            .setSearch(txtSearch)
            .setSearch(btnSearch)
            .setReplace(newLabel("Replace with"))
            .setReplace(txtReplace)
            .setReplace(btnReplace)
            .setResult(jScrollPane), java.awt.BorderLayout.CENTER);

      txtSearch.addMouseListener(getSearchFieldMouseListener(txtSearch));
      txtReplace.addMouseListener(getSearchFieldMouseListener(txtReplace));
   }

   protected abstract java.util.stream.Stream<nextgen.model.STModel> getSTModels();

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
               final java.util.List<STValue> stValues = new java.util.ArrayList<>();
               getSTModels().forEach(stModel -> addSTValues(stModel, stValues));
               results.setContent(stValues);
            });
         }

         private void addSTValues(nextgen.model.STModel stModel, java.util.List<STValue> stValues) {

            stModel.getArgumentsSorted()
                  .map(nextgen.model.STArgument::getValue)
                  .filter(java.util.Objects::nonNull)
                  .filter(stValue -> stValue.getType() != null)
                  .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE))
                  .filter(nextgen.model.STValue::hasValue)
                  .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                  .forEach(stValues::add);

            stModel.getArgumentsSorted()
                  .forEach(stArgument -> stValues.addAll(stArgument.getKeyValues()
                        .map(nextgen.model.STArgumentKV::getValue)
                        .filter(java.util.Objects::nonNull)
                        .filter(stValue -> stValue.getType() != null)
                        .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE))
                        .filter(nextgen.model.STValue::hasValue)
                        .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                        .collect(java.util.stream.Collectors.toList())));

            stModel.getArgumentsSorted()
                  .forEach(stArgument -> stArgument.getKeyValues()
                        .map(nextgen.model.STArgumentKV::getValue)
                        .filter(java.util.Objects::nonNull)
                        .filter(stValue -> stValue.getType() != null)
                        .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
                        .filter(stValue -> stValue.getStModel() != null)
                        .forEach(stValue -> addSTValues(stValue.getStModel(), stValues)));

            stModel.getArgumentsSorted()
                  .map(nextgen.model.STArgument::getValue)
                  .filter(java.util.Objects::nonNull)
                  .filter(stValue -> stValue.getType() != null)
                  .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
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
               results.getContent().forEach(element -> {
                  final STValue stValue = element.model;
                  final String newValue = stValue.getValue().replace(txtSearch.getText(), txtReplace.getText());
                  stValue.setValue(newValue);
                  appModel().notifyIfLabel(stValue);
                  element.setValue(newValue);
               });
               results.refresh();
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
      results.clear();
   }
}