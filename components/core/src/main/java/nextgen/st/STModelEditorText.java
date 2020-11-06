package nextgen.st;

import static nextgen.st.STAppPresentationModel.newAction;
import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STModelEditorText extends javax.swing.JPanel {

   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 80);
   private final org.fife.ui.rtextarea.RTextScrollPane editorComponent = new org.fife.ui.rtextarea.RTextScrollPane(txtEditor);
   private final javax.swing.Action toClipboardAction = newAction("Copy to Clipboard", actionEvent -> toClipboard());

   private nextgen.st.model.STModel stModel;

   public STModelEditorText() {
      super(new java.awt.BorderLayout());

      setBackground(javax.swing.UIManager.getColor("Panel.background"));

      txtEditor.setEditable(false);
      txtEditor.addKeyListener(getEditorKeyListener());

      final javax.swing.JPopupMenu pop = txtEditor.getPopupMenu();
      pop.addSeparator();
      pop.addSeparator();
      pop.add(toClipboardAction);

      add(editorComponent, java.awt.BorderLayout.CENTER);
   }

   private STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
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

   private java.awt.event.KeyListener getEditorKeyListener() {
      return new java.awt.event.KeyAdapter() {
         @Override
         public void keyPressed(java.awt.event.KeyEvent keyEvent) {
            if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
//               tryToSave();
            }
         }
      };
   }
}