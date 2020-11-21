package nextgen.swing;

public class AbstractEditor extends javax.swing.JPanel {

   public AbstractEditor() {
      super(new java.awt.BorderLayout());
      setBackground(javax.swing.UIManager.getColor("Panel.background"));
   }

   protected nextgen.swing.STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
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

   protected java.awt.event.KeyListener getEditorKeyListener() {
      return new java.awt.event.KeyAdapter() {
         @Override
         public void keyPressed(java.awt.event.KeyEvent keyEvent) {
            if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
               appModel().doLaterInTransaction(transaction -> {
                  tryToSave();
               });
            }
         }
      };
   }

   protected javax.swing.Action newAction(String name, java.util.function.Consumer<java.awt.event.ActionEvent> consumer) {
      return new javax.swing.AbstractAction(name) {
         @Override
         public void actionPerformed(java.awt.event.ActionEvent e) {
            consumer.accept(e);
         }
      };
   }

   protected void tryToSave() {
   }
}
