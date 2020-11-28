package nextgen.swing;

import static nextgen.utils.SwingUtil.confirm;
import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STValueEditor extends AbstractEditor {

   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtEditor = newRSyntaxTextArea(20, 80);
   private final org.fife.ui.rtextarea.RTextScrollPane editorComponent = new org.fife.ui.rtextarea.RTextScrollPane(txtEditor);
   private final javax.swing.Action saveAction = newAction("Save", actionEvent -> tryToSave());
   private final javax.swing.Action replaceWithClipboardAction = newAction("Replace with Clipboard", actionEvent -> replaceWithClipboard());
   private final javax.swing.Action prependFromClipboardAction = newAction("Prepend from Clipboard", actionEvent -> prependFromClipboard());
   private final javax.swing.Action appendFromClipboardAction = newAction("Append from Clipboard", actionEvent -> appendFromClipboard());
   private final javax.swing.Action selectLineAction = newAction("Select Line", actionEvent -> selectLine());
   private final javax.swing.Action toClipboardAction = newAction("Copy to Clipboard", actionEvent -> toClipboard());

   private nextgen.st.model.STValue stValue;
   private String uuid;

   public STValueEditor() {

      txtEditor.setEditable(false);
      txtEditor.addKeyListener(getEditorKeyListener());

      final javax.swing.JPopupMenu pop = txtEditor.getPopupMenu();
      pop.addSeparator();
      pop.add(saveAction);
      pop.add(replaceWithClipboardAction);
      pop.add(appendFromClipboardAction);
      pop.add(prependFromClipboardAction);
      pop.addSeparator();
      pop.add(selectLineAction);
      pop.add(toClipboardAction);

      add(editorComponent, java.awt.BorderLayout.CENTER);
   }

   @org.greenrobot.eventbus.Subscribe()
   public void onModelNavigatorSTValueTreeNodeClicked(nextgen.events.ModelNavigatorSTValueTreeNodeClicked event) {
      setSTValue(event.stValue);
   }

   public void setSTValue(nextgen.st.model.STValue stValue) {
      this.stValue = stValue;
      this.uuid = stValue.getUuid();
      txtEditor.setText(appModel().render(stValue));
      txtEditor.setCaretPosition(0);
      txtEditor.setEditable(stValue.getType().equals(nextgen.st.model.STValueType.PRIMITIVE));
   }

   private void replaceWithClipboard() {
      if (!txtEditor.isEditable()) return;
      txtEditor.setText(nextgen.utils.SwingUtil.fromClipboard().trim());
      txtEditor.setCaretPosition(0);
      tryToSave();
   }

   private void prependFromClipboard() {
      if (!txtEditor.isEditable()) return;
      txtEditor.setText(nextgen.utils.SwingUtil.fromClipboard().trim() + txtEditor.getText());
      txtEditor.setCaretPosition(0);
      tryToSave();
   }

   private void appendFromClipboard() {
      if (!txtEditor.isEditable()) return;
      txtEditor.append(nextgen.utils.SwingUtil.fromClipboard().trim());
      txtEditor.setCaretPosition(0);
      tryToSave();
   }

   private void selectLine() {
      final int startOffsetOfCurrentLine = txtEditor.getLineStartOffsetOfCurrentLine();
      final int endOffsetOfCurrentLine = txtEditor.getLineEndOffsetOfCurrentLine();
      try {
         final String line = txtEditor.getText(startOffsetOfCurrentLine, endOffsetOfCurrentLine - startOffsetOfCurrentLine).trim();
         System.out.println(line);
         nextgen.utils.SwingUtil.toClipboard(line);
      } catch (javax.swing.text.BadLocationException ignored) {

      }
   }

   private void toClipboard() {
      nextgen.utils.SwingUtil.toClipboard(txtEditor.getText().trim());
   }

   @Override
   protected void tryToSave() {
      if (stValue == null) return;
      appModel().doInTransaction(transaction -> {
         if (!stValue.getType().equals(nextgen.st.model.STValueType.PRIMITIVE)) return;
         stValue.setValue(txtEditor.getText().trim());
         nextgen.events.STValueChanged.post(stValue);
      });
   }

   public String getUuid() {
      return this.uuid;
   }
}