package nextgen.actions;

import static nextgen.utils.SwingUtil.printStackTrace;

public abstract class TransactionAction extends javax.swing.AbstractAction {

   protected TransactionAction(String name) {
      super(name);
   }

   @Override
   public void actionPerformed(java.awt.event.ActionEvent e) {
      javax.swing.SwingUtilities.invokeLater(() -> appModel().doInTransaction(transaction -> actionPerformed(e, transaction)));
   }

   protected abstract void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction);

   protected nextgen.swing.STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
   }

   protected void confirm(javax.swing.JComponent owner, String description, java.util.function.Consumer<Void> onConfirm) {
      nextgen.utils.SwingUtil.confirm(owner, description).ifPresent(aBoolean -> onConfirm.accept(null));
   }

   protected void input(javax.swing.JComponent owner, String message, java.util.function.Consumer<String> consumer) {
      nextgen.utils.SwingUtil.showInputDialog(message, owner, inputValue -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(inputValue)));
   }

   protected void input(javax.swing.JComponent owner, String message, String defaultValue, java.util.function.Consumer<String> consumer) {
      nextgen.utils.SwingUtil.showInputDialog(message, owner, defaultValue, inputValue -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(inputValue)));
   }

   protected <T> void select(javax.swing.JComponent owner, java.util.Collection<T> values, java.util.function.Consumer<T> consumer) {
      nextgen.utils.SwingUtil.showSelectDialog("Select", owner, values, selected -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(selected)));
   }

   protected <T> void select(javax.swing.JComponent owner, java.util.Collection<T> values, T defaultValue, java.util.function.Consumer<T> consumer) {
      nextgen.utils.SwingUtil.showSelectDialog("Select", owner, values, defaultValue, selected -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(selected)));
   }

   protected void openFile(javax.swing.JComponent owner, java.util.function.Consumer<java.io.File> consumer) {
      nextgen.utils.SwingUtil.showOpenFile(owner, appModel().getLastDir()).ifPresent(consumer);
   }

   protected javax.swing.JDialog newDialog(javax.swing.JComponent owner, String title) {
      return new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities.getAncestorOfClass(javax.swing.JFrame.class, owner), title, true);
   }

   protected javax.swing.JTextField newTextField() {
      return newTextField("", 30);
   }

   protected javax.swing.JTextField newTextField(int columns) {
      return newTextField("", columns);
   }

   protected javax.swing.JTextField newTextField(String text, int columns) {
      return newTextField(text, columns, new String[0], -1);
   }

   protected javax.swing.JTextField newTextField(int columns, String[] options) {
      return newTextField("", columns, options, 0);
   }

   protected javax.swing.JTextField newTextField(String text, int columns, java.util.List<String> options, int startIndex) {
      return newTextField(text, columns, options.toArray(new String[options.size()]), startIndex);
   }

   protected javax.swing.JTextField newTextField(String text, int columns, String[] options, int startIndex) {
      return nextgen.utils.SwingUtil.newTextField(text, columns, options, startIndex);
   }

   protected javax.swing.JLabel newLabel(String name) {
      return new javax.swing.JLabel(name);
   }

   protected javax.swing.JButton newButton(String name, java.util.function.Consumer<org.neo4j.graphdb.Transaction> onClick) {
      return new javax.swing.JButton(appModel().newTransactionAction(name, onClick));
   }

   protected void showDialog(javax.swing.JComponent owner, javax.swing.JComponent component, String title, java.util.function.Consumer<javax.swing.JDialog> saveAction) {
      final javax.swing.JDialog dialog = newDialog(owner, title);
      dialog.add(component, java.awt.BorderLayout.CENTER);
      nextgen.utils.SwingUtil.showDialog(owner, dialog, newButton("Save", transaction -> saveAction.accept(dialog)));
   }

   protected void showTextResult(String title, String text, java.awt.Component parentComponent) {
      nextgen.utils.SwingUtil.showTextResult(title, text, parentComponent);
   }

   protected void showError(javax.swing.JComponent owner, Throwable throwable) {
      showError(owner, printStackTrace(throwable));
   }

   protected void showError(javax.swing.JComponent owner, String errors) {
      final javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.BorderLayout());
      final javax.swing.JTextArea textArea = new javax.swing.JTextArea(errors);
      textArea.setEditable(false);
      final javax.swing.JScrollPane content = new javax.swing.JScrollPane(textArea);
      final java.awt.Dimension dimension = new java.awt.Dimension(1024, 800);
      content.setMaximumSize(dimension);
      content.setPreferredSize(dimension);
      content.setMinimumSize(dimension);
      content.setSize(dimension);
      panel.add(content, java.awt.BorderLayout.CENTER);
      javax.swing.JOptionPane.showMessageDialog(owner, panel, "Errors", javax.swing.JOptionPane.ERROR_MESSAGE);
   }

   protected void close(javax.swing.JDialog dialog) {
      javax.swing.SwingUtilities.invokeLater(dialog::dispose);
   }

   protected void toClipboard(Object value) {
      nextgen.utils.SwingUtil.toClipboard(value.toString());
   }
}