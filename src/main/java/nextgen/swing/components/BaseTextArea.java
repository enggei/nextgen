package nextgen.swing.components;

import org.fife.ui.autocomplete.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate;

import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class BaseTextArea extends RSyntaxTextArea {

   protected DefaultCompletionProvider provider = new DefaultCompletionProvider();

   public BaseTextArea() {
      decorate();
      register();
   }

   public BaseTextArea(String text) {
      super(text);
      decorate();
      assignActions();
      register();
   }

   private void decorate() {

      javax.swing.InputMap im = getInputMap();
      im.put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK), "Duplicate");
      im.put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_DOWN_MASK), "DeleteLine");

      javax.swing.ActionMap am = getActionMap();
      am.put("Duplicate", newAction("Duplicate", actionEvent -> duplicateLine()));
      am.put("DeleteLine", newAction("DeleteLine", actionEvent -> deleteLine()));

      nextgen.swing.ComponentFactory.decorate(this);
      setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.DARK_GRAY));
   }

   private void register() {
      org.fife.ui.autocomplete.AutoCompletion ac = new org.fife.ui.autocomplete.AutoCompletion(provider);
      javax.swing.KeyStroke key = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_DOWN_MASK);
      ac.setTriggerKey(key);
      ac.install(this);
   }

   protected void assignActions() {

      getPopupMenu().removeAll();

      getPopupMenu().add(newAction("Replace with Clipboard", actionEvent -> replaceWithClipboard()));
      getPopupMenu().add(newAction("Append from Clipboard", actionEvent -> appendFromClipboard()));
      getPopupMenu().add(newAction("Prepend from Clipboard", actionEvent -> prependFromClipboard()));
      getPopupMenu().addSeparator();

      getPopupMenu().add(newAction("To Clipboard", actionEvent -> toClipboard()));
      getPopupMenu().addSeparator();

      getPopupMenu().add(newAction("Duplicate", actionEvent -> duplicateLine()));
      getPopupMenu().addSeparator();

      getPopupMenu().add(newAction("Delete Line", actionEvent -> deleteLine()));
      getPopupMenu().add(newAction("Clear", actionEvent -> clear()));
      getPopupMenu().add(newAction("Goto top", actionEvent -> gotoTop()));
      getPopupMenu().add(newAction("Goto bottom", actionEvent -> gotoBottom()));
      getPopupMenu().addSeparator();
   }

   protected void clear() {
      setText("");
   }

   protected void gotoTop() {
      setCaretPosition(0);
   }

   protected void gotoBottom() {
      setCaretPosition(getText().length());
   }

   protected javax.swing.Action newAction(String name, Consumer<ActionEvent> consumer) {
      return new javax.swing.AbstractAction(name) {
         @Override
         public void actionPerformed(ActionEvent e) {
            consumer.accept(e);
         }
      };
   }

   protected void replaceWithClipboard() {
      if (!isEditable()) return;
      if (getSelectedText() != null) {
         final int selectionStart = getSelectionStart();
         replaceRange(nextgen.utils.SwingUtil.fromClipboard().trim(), selectionStart, getSelectionEnd());
      } else {
         setText(nextgen.utils.SwingUtil.fromClipboard().trim());
         setCaretPosition(0);
      }
   }

   protected void appendFromClipboard() {
      if (!isEditable()) return;
      append(nextgen.utils.SwingUtil.fromClipboard().trim());
      setCaretPosition(0);
   }

   protected void prependFromClipboard() {
      if (!isEditable()) return;
      setText(nextgen.utils.SwingUtil.fromClipboard().trim() + getText());
      setCaretPosition(0);
   }

   protected void toClipboard() {
      if (getSelectedText() != null)
         nextgen.utils.SwingUtil.toClipboard(getSelectedText().trim());
      else
         nextgen.utils.SwingUtil.toClipboard(getText().trim());
   }

   protected void removeSelectedTextIfAny() {
      if (getSelectedText() != null) {
         final int selectionStart = getSelectionStart();
         replaceRange("", selectionStart, getSelectionEnd());
         setCaretPosition(selectionStart);
      }
   }

   protected void duplicateLine() {
      javax.swing.SwingUtilities.invokeLater(() -> {
         final int start = getLineStartOffsetOfCurrentLine();
         final int end = getLineEndOffsetOfCurrentLine();
         final String line = getText().substring(start, end);
         insert(line, end);
      });
   }

   protected void deleteLine() {
      javax.swing.SwingUtilities.invokeLater(() -> {
         final int start = getLineStartOffsetOfCurrentLine();
         final int end = getLineEndOffsetOfCurrentLine();
         final String line = getText().substring(start, end);
         replaceRange("", start, end);
         setCaretPosition(start);
      });
   }

   public void addCodeTemplate(String replacementText, String before, String after) {
      addCodeTemplate(false, replacementText, before, after);
   }

   public void addCodeTemplate(boolean addToPop, String replacementText, String before, String after) {

      provider.addCompletion(new BasicCompletion(provider, replacementText));
      getCodeTemplateManager().addTemplate(new StaticCodeTemplate(replacementText, before, after));

      if (addToPop)
         getPopupMenu().add(newAction(replacementText, actionEvent -> {
            append("\n" + before + after);
            setCaretPosition(getText().length() - (after.length()));
         }));
   }
}