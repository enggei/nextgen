package nextgen.swing;

public class AbstractEditor extends javax.swing.JPanel {

   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AbstractEditor.class);

   public AbstractEditor() {
      super(new java.awt.BorderLayout());
      setBackground(javax.swing.UIManager.getColor("Panel.background"));
   }

   public String title() {
      return "Editor";
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
      return nextgen.utils.SwingUtil.newTextField(text, columns, options, startIndex);
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

   protected javax.swing.JPopupMenu addPopupActions(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      final javax.swing.JPopupMenu pop = textArea.getPopupMenu();
      pop.addSeparator();
      pop.add(newAction("Replace with Clipboard", actionEvent -> replaceWithClipboard(textArea)));
      pop.add(newAction("Append from Clipboard", actionEvent -> appendFromClipboard(textArea)));
      pop.add(newAction("Prepend from Clipboard", actionEvent -> prependFromClipboard(textArea)));
      pop.add(newAction("Select from Clipboard", actionEvent -> selectFromClipboard(textArea)));
      pop.addSeparator();
      pop.add(newAction("Select Line", actionEvent -> selectLine(textArea)));
      pop.add(newAction("To Clipboard", actionEvent -> toClipboard(textArea)));
      return pop;
   }

   protected void replaceWithClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      if (!textArea.isEditable()) return;
      textArea.setText(nextgen.utils.SwingUtil.fromClipboard().trim());
      textArea.setCaretPosition(0);
      tryToSave();
   }

   protected void selectFromClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      if (!textArea.isEditable()) return;

      appModel().doLaterInTransaction(transaction -> {
         nextgen.utils.SwingUtil.selectFromClipboard(textArea, o -> {
            textArea.setText(o.toString().trim());
            textArea.setCaretPosition(0);
            tryToSave();
         });
      });
   }

   protected void prependFromClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      if (!textArea.isEditable()) return;
      textArea.setText(nextgen.utils.SwingUtil.fromClipboard().trim() + textArea.getText());
      textArea.setCaretPosition(0);
      tryToSave();
   }

   protected void appendFromClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      if (!textArea.isEditable()) return;
      textArea.append(nextgen.utils.SwingUtil.fromClipboard().trim());
      textArea.setCaretPosition(0);
      tryToSave();
   }

   protected void selectLine(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      final int startOffsetOfCurrentLine = textArea.getLineStartOffsetOfCurrentLine();
      final int endOffsetOfCurrentLine = textArea.getLineEndOffsetOfCurrentLine();
      try {
         final String line = textArea.getText(startOffsetOfCurrentLine, endOffsetOfCurrentLine - startOffsetOfCurrentLine).trim();
         log.info(line);
         nextgen.utils.SwingUtil.toClipboard(line);
      } catch (javax.swing.text.BadLocationException ignored) {

      }
   }

   protected void toClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      nextgen.utils.SwingUtil.toClipboard(textArea.getText().trim());
   }
}
