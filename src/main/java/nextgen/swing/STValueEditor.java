package nextgen.swing;

public class STValueEditor extends AbstractEditor {

   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtEditor = nextgen.utils.SwingUtil.newRSyntaxTextArea(20, 80);
   private final STValueEditorForm stValueEditorForm = new STValueEditorForm();

   private nextgen.model.STValue stValue;
   private String uuid;

   public STValueEditor() {

      txtEditor.setEditable(false);
      txtEditor.addKeyListener(getEditorKeyListener());

      addPopupActions(txtEditor).
            add(newAction("Save", actionEvent -> tryToSave()));;

      final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
      editors.add("Editor", new org.fife.ui.rtextarea.RTextScrollPane(txtEditor));
      editors.add("Values", stValueEditorForm);
      add(editors, java.awt.BorderLayout.CENTER);
   }

   public void setSTValue(nextgen.model.STValue stValue) {
      this.stValue = stValue;
      this.uuid = stValue.getUuid();
      stValueEditorForm.setModel(stValue);
      txtEditor.setText(appModel().render(stValue));
      txtEditor.setCaretPosition(0);
      txtEditor.setEditable(stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE));
   }

   @Override
   protected void tryToSave() {
      if (stValue == null) return;

      appModel().doInTransaction(transaction -> {
         if (!stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE)) return;
         stValue.setValue(txtEditor.getText().trim());

         nextgen.events.STValueChanged.post(stValue);

         stValue.getIncomingValueSTArgument().findFirst().ifPresent(stArgument -> stArgument.getIncomingArgumentsSTModel().findAny().ifPresent(stModel -> {
            final nextgen.model.STParameter stParameter = stArgument.getStParameter();
            if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
         }));
      });
   }

   public String getUuid() {
      return this.uuid;
   }
}