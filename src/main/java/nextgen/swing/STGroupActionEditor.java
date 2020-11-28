package nextgen.swing;

import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STGroupActionEditor extends AbstractEditor {

   private final nextgen.model.STGroupAction model;
   private final String uuid;

   private final javax.swing.JTextField txtName = newTextField(30);
   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtStatements = newRSyntaxTextArea(20, 80);
   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtMethods = newRSyntaxTextArea(20, 80);

   public STGroupActionEditor(nextgen.model.STGroupAction model) {

      this.model = model;
      this.uuid = model.getUuid();

      txtName.setText(model.getName(""));
      txtStatements.setText(appModel().render(model.getStatements(),""));
      txtMethods.setText(appModel().render(model.getMethods(),""));

      final java.awt.event.KeyListener editorKeyListener = getEditorKeyListener();
      txtName.addKeyListener(editorKeyListener);
      txtStatements.addKeyListener(editorKeyListener);
      txtMethods.addKeyListener(editorKeyListener);

      final javax.swing.JPanel namePanel = new javax.swing.JPanel(new java.awt.BorderLayout());
      namePanel.setBackground(javax.swing.UIManager.getColor("Panel.background"));
      namePanel.add(txtName, java.awt.BorderLayout.NORTH);

      addPopupActions(txtStatements);
      addPopupActions(txtMethods);

      final javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane();
      tabbedPane.add("Name", namePanel);
      tabbedPane.add("Statements", new org.fife.ui.rtextarea.RTextScrollPane(txtStatements));
      tabbedPane.add("Methods", new org.fife.ui.rtextarea.RTextScrollPane(txtMethods));
      add(tabbedPane, java.awt.BorderLayout.CENTER);
   }

   public void addPopupActions(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      final javax.swing.JPopupMenu pop = textArea.getPopupMenu();
      pop.addSeparator();
      pop.add(newAction("Save", actionEvent -> tryToSave()));
      pop.add(newAction("Replace with Clipboard", actionEvent -> replaceWithClipboard(textArea)));
      pop.add(newAction("Append from Clipboard", actionEvent -> appendFromClipboard(textArea)));
      pop.add(newAction("Prepend from Clipboard", actionEvent -> prependFromClipboard(textArea)));
      pop.addSeparator();
      pop.add(newAction("Select Line", actionEvent -> selectLine(textArea)));
      pop.add(newAction("Copy to Clipboard", actionEvent -> toClipboard(textArea)));
   }

   public nextgen.model.STGroupAction getModel() {
      return model;
   }

   public String getUuid() {
      return uuid;
   }

   @Override
   protected void tryToSave() {
      appModel().doInTransaction(transaction -> {
         model.setName(txtName.getText().trim());
         model.setStatements(appModel().newSTValue(txtStatements.getText().trim()));
         model.setMethods(appModel().newSTValue(txtMethods.getText().trim()));
         nextgen.events.STGroupActionChanged.post(model);
      });
   }

   private void replaceWithClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      textArea.setText(nextgen.utils.SwingUtil.fromClipboard().trim());
      textArea.setCaretPosition(0);
      tryToSave();
   }

   private void prependFromClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      textArea.setText(nextgen.utils.SwingUtil.fromClipboard().trim() + textArea.getText());
      textArea.setCaretPosition(0);
      tryToSave();
   }

   private void appendFromClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      textArea.append(nextgen.utils.SwingUtil.fromClipboard().trim());
      textArea.setCaretPosition(0);
      tryToSave();
   }

   private void selectLine(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      final int startOffsetOfCurrentLine = textArea.getLineStartOffsetOfCurrentLine();
      final int endOffsetOfCurrentLine = textArea.getLineEndOffsetOfCurrentLine();
      try {
         final String line = textArea.getText(startOffsetOfCurrentLine, endOffsetOfCurrentLine - startOffsetOfCurrentLine).trim();
         System.out.println(line);
         nextgen.utils.SwingUtil.toClipboard(line);
      } catch (javax.swing.text.BadLocationException ignored) {

      }
   }

   private void toClipboard(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      nextgen.utils.SwingUtil.toClipboard(textArea.getText().trim());
   }
}