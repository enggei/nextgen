package nextgen.actions;

public abstract class TransactionAction extends javax.swing.AbstractAction {

   protected TransactionAction(String name) {
      super(name);
   }

   @Override
   public void actionPerformed(java.awt.event.ActionEvent e) {
      javax.swing.SwingUtilities.invokeLater(() -> appModel().doInTransaction(transaction -> actionPerformed(e, transaction)));
   }

   protected abstract void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction);

   protected nextgen.st.STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance()
            .getSTAppPresentationModel();
   }

   protected void confirm(javax.swing.JComponent owner, String description, java.util.function.Consumer<Void> onConfirm) {
      nextgen.utils.SwingUtil.confirm(owner, description)
            .ifPresent(aBoolean -> onConfirm.accept(null));
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
      nextgen.utils.SwingUtil.showOpenFile(owner, appModel().getLastDir()).ifPresent(file -> consumer.accept(file));
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
      final javax.swing.JTextField textField = new javax.swing.JTextField(text, columns);

      textField.addMouseListener(new java.awt.event.MouseAdapter() {

         final java.util.concurrent.atomic.AtomicInteger index = new java.util.concurrent.atomic.AtomicInteger(startIndex);

         @Override
         public void mouseClicked(java.awt.event.MouseEvent e) {

            if (javax.swing.SwingUtilities.isRightMouseButton(e)) {

               final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();
               pop.add(new javax.swing.AbstractAction("Set from Clipboard") {
                  @Override
                  public void actionPerformed(java.awt.event.ActionEvent actionEvent) {
                     javax.swing.SwingUtilities.invokeLater(() -> textField.setText(nextgen.utils.SwingUtil.fromClipboard().trim()));
                  }
               });
               pop.show(textField, e.getX(), e.getY());

            } else if (options != null && options.length > 0) {
               textField.setText(options[index.incrementAndGet() % options.length]);

            } else {
               javax.swing.SwingUtilities.invokeLater(() -> textField.setText(nextgen.utils.SwingUtil.fromClipboard().trim()));
            }
         }
      });

      return textField;
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

   protected void close(javax.swing.JDialog dialog) {
      javax.swing.SwingUtilities.invokeLater(dialog::dispose);
   }

   protected void toClipboard(Object value) {
      nextgen.utils.SwingUtil.toClipboard(value.toString());
   }
}