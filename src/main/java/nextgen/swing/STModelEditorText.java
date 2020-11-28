package nextgen.swing;

import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STModelEditorText extends AbstractEditor {

   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 80);
   private final org.fife.ui.rtextarea.RTextScrollPane editorComponent = new org.fife.ui.rtextarea.RTextScrollPane(txtEditor);
   private final javax.swing.Action toClipboardAction = newAction("Copy to Clipboard", actionEvent -> toClipboard());

   private nextgen.st.model.STModel stModel;

   public STModelEditorText() {

      txtEditor.setEditable(false);
      txtEditor.addKeyListener(getEditorKeyListener());

      final javax.swing.JPopupMenu pop = txtEditor.getPopupMenu();
      pop.addSeparator();
      pop.addSeparator();
      pop.add(toClipboardAction);

      add(editorComponent, java.awt.BorderLayout.CENTER);
   }

   public void setStModel(nextgen.st.model.STModel stModel) {
      this.stModel = stModel;
      txtEditor.setText(appModel().render(stModel));
      txtEditor.setCaretPosition(0);
      txtEditor.setEditable(false);
   }

   private void toClipboard() {
      nextgen.utils.SwingUtil.toClipboard(txtEditor.getText().trim());
   }

}