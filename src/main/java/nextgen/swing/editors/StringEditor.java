package nextgen.swing.editors;

import static nextgen.swing.ComponentFactory.*;

public class StringEditor extends nextgen.swing.BaseEditor<String> {

   protected final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea = newRSyntaxTextArea();
   protected final org.fife.ui.autocomplete.DefaultCompletionProvider provider = new org.fife.ui.autocomplete.DefaultCompletionProvider();

   public StringEditor() {
      init();
   }

   public StringEditor(String model) {
      super(model);
      init();
   }

   protected void init() {

      com.jgoodies.binding.value.ValueModel onDomainAdapter = new com.jgoodies.binding.value.AbstractValueModel() {
         @Override
         public Object getValue() {
            return model;
         }

         @Override
         public void setValue(Object o) {
            model = o.toString();
         }
      };
      com.jgoodies.binding.adapter.Bindings.bind(textArea, onDomainAdapter);

      setLayout(new java.awt.BorderLayout());
      add(nextgen.swing.ComponentFactory.newRTextScrollPane(textArea), java.awt.BorderLayout.CENTER);

      textArea.getPopupMenu().removeAll();
      textArea.getPopupMenu().add(newAction("Replace with Clipboard", actionEvent -> replaceWithClipboard(textArea)));
      textArea.getPopupMenu().add(newAction("Append Clipboard", actionEvent -> appendFromClipboard(textArea)));
      textArea.getPopupMenu().add(newAction("Prepend Clipboard", actionEvent -> prependFromClipboard(textArea)));
      textArea.getPopupMenu().add(newAction("To Clipboard", actionEvent -> toClipboard(textArea)));
      textArea.getPopupMenu().add(newAction("Clear", actionEvent -> clear(textArea)));
      textArea.getPopupMenu().add(newAction("Goto top", actionEvent -> gotoTop(textArea)));
      textArea.getPopupMenu().add(newAction("Goto bottom", actionEvent -> gotoBottom(textArea)));
      textArea.getPopupMenu().add(newAction("Save", actionEvent -> appModel().doLaterInTransaction(tx -> tryToSave())));

      textArea.addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

      org.fife.ui.autocomplete.AutoCompletion ac = new org.fife.ui.autocomplete.AutoCompletion(provider);
      javax.swing.KeyStroke key = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_DOWN_MASK);
      ac.setTriggerKey(key);
      ac.install(textArea);

   }

   @Override
   public void setModel(String model) {
      super.setModel(model);

      textArea.setText(model);
      textArea.setCaretPosition(0);
   }
}