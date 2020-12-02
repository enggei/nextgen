package nextgen.swing;

import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STModelEditorText extends AbstractEditor {

   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 80);
   private final org.fife.ui.rtextarea.RTextScrollPane editorComponent = new org.fife.ui.rtextarea.RTextScrollPane(txtEditor);
   private final javax.swing.Action toClipboardAction = newAction("Copy to Clipboard", actionEvent -> toClipboard());

   private nextgen.model.STModel stModel;

   public STModelEditorText() {

      txtEditor.setEditable(false);
      txtEditor.addKeyListener(getEditorKeyListener());


      final javax.swing.JPopupMenu pop = txtEditor.getPopupMenu();
      pop.add(toClipboardAction);

      add(editorComponent, java.awt.BorderLayout.CENTER);
   }

   public void setStModel(nextgen.model.STModel stModel) {
      this.stModel = stModel;
      txtEditor.setText(appModel().render(stModel));
      txtEditor.setCaretPosition(0);
      txtEditor.setEditable(false);
      txtEditor.setSyntaxEditingStyle(nextgen.utils.STModelUtil.getSTGroup(stModel).getLanguage("text/plain"));
   }

   private void toClipboard() {
      nextgen.utils.SwingUtil.toClipboard(txtEditor.getText().trim());
   }

}