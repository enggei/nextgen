package nextgen.st;

import static nextgen.st.STAppPresentationModel.newAction;
import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STValueEditor extends javax.swing.JPanel {

   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 80);
   private final org.fife.ui.rtextarea.RTextScrollPane editorComponent = new org.fife.ui.rtextarea.RTextScrollPane(txtEditor);
   private final javax.swing.Action saveAction = newAction("Save", actionEvent -> tryToSave());
   private final javax.swing.Action replaceWithClipboardAction = newAction("Replace with Clipboard", actionEvent -> replaceWithClipboard());
   private final javax.swing.Action prependFromClipboardAction = newAction("Prepend from Clipboard", actionEvent -> prependFromClipboard());
   private final javax.swing.Action appendFromClipboardAction = newAction("Append from Clipboard", actionEvent -> appendFromClipboard());
   private final javax.swing.Action toClipboardAction = newAction("Copy to Clipboard", actionEvent -> toClipboard());

   private nextgen.st.model.STValue stValue;
   private String uuid;

   public STValueEditor() {
      super(new java.awt.BorderLayout());

      setBackground(javax.swing.UIManager.getColor("Panel.background"));

      txtEditor.setEditable(false);
      txtEditor.addKeyListener(getEditorKeyListener());

      final javax.swing.JPopupMenu pop = txtEditor.getPopupMenu();
      pop.addSeparator();
      pop.add(saveAction);
      pop.add(replaceWithClipboardAction);
      pop.add(appendFromClipboardAction);
      pop.add(prependFromClipboardAction);
      pop.addSeparator();
      pop.add(toClipboardAction);

      add(editorComponent, java.awt.BorderLayout.CENTER);
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onModelNavigatorSTValueTreeNodeClicked(nextgen.events.ModelNavigatorSTValueTreeNodeClicked event) {
      setSTValue(event.stValue);
   }

   private STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance()
            .getSTAppPresentationModel();
   }

   public void setSTValue(nextgen.st.model.STValue stValue) {
      this.stValue = stValue;
      this.uuid = stValue.getUuid();
      txtEditor.setText(appModel().render(stValue));
      txtEditor.setCaretPosition(0);
      txtEditor.setEditable(stValue.getType()
            .equals(nextgen.st.model.STValueType.PRIMITIVE));
   }

   private void replaceWithClipboard() {
      if (!txtEditor.isEditable()) return;
      txtEditor.setText(nextgen.utils.SwingUtil.fromClipboard()
            .trim());
      txtEditor.setCaretPosition(0);
      tryToSave();
   }

   private void prependFromClipboard() {
      if (!txtEditor.isEditable()) return;
      txtEditor.setText(nextgen.utils.SwingUtil.fromClipboard()
            .trim() + txtEditor.getText());
      txtEditor.setCaretPosition(0);
      tryToSave();
   }

   private void appendFromClipboard() {
      if (!txtEditor.isEditable()) return;
      txtEditor.append(nextgen.utils.SwingUtil.fromClipboard()
            .trim());
      txtEditor.setCaretPosition(0);
      tryToSave();
   }

   private void toClipboard() {
      nextgen.utils.SwingUtil.toClipboard(txtEditor.getText()
            .trim());
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

   void tryToSave() {
      if (stValue == null) return;
      appModel().doLaterInTransaction(transaction -> {
         if (!stValue.getType()
               .equals(nextgen.st.model.STValueType.PRIMITIVE)) return;
         stValue.setValue(txtEditor.getText()
               .trim());
         nextgen.events.STValueChanged.post(stValue);
      });
   }

   public String getUuid() {
      return this.uuid;
   }
}