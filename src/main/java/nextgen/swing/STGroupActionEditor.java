package nextgen.swing;

import static nextgen.utils.SwingUtil.newRSyntaxTextArea;

public class STGroupActionEditor extends AbstractEditor {

   private final nextgen.model.STGroupAction model;
   private final String uuid;

   private final javax.swing.JTextField txtName = newTextField(30);
   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtStatements = newRSyntaxTextArea(20, 80);
   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtMethods = newRSyntaxTextArea(20, 80);
   private final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtImports = newRSyntaxTextArea(20, 80);

   public STGroupActionEditor(nextgen.model.STGroupAction model) {

      this.model = model;
      this.uuid = model.getUuid();

      txtStatements.setSyntaxEditingStyle("text/java");
      txtMethods.setSyntaxEditingStyle("text/java");
      txtImports.setSyntaxEditingStyle("text/java");

      txtName.setText(model.getName(""));
      txtStatements.setText(appModel().render(model.getStatements(),""));
      txtMethods.setText(appModel().render(model.getMethods(),""));
      txtImports.setText(appModel().render(model.getImports(),""));

      final java.awt.event.KeyListener editorKeyListener = getEditorKeyListener();
      txtName.addKeyListener(editorKeyListener);
      txtStatements.addKeyListener(editorKeyListener);
      txtMethods.addKeyListener(editorKeyListener);
      txtImports.addKeyListener(editorKeyListener);

      final javax.swing.JPanel namePanel = new javax.swing.JPanel(new java.awt.BorderLayout());
      namePanel.setBackground(javax.swing.UIManager.getColor("Panel.background"));
      namePanel.add(txtName, java.awt.BorderLayout.NORTH);

      addPopupActions(txtStatements).
            add(newAction("Save", actionEvent -> tryToSave()));;
      addPopupActions(txtMethods).
            add(newAction("Save", actionEvent -> tryToSave()));;
      addPopupActions(txtImports).
            add(newAction("Save", actionEvent -> tryToSave()));;

      final javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane();
      tabbedPane.add("Name", namePanel);
      tabbedPane.add("Statements", new org.fife.ui.rtextarea.RTextScrollPane(txtStatements));
      tabbedPane.add("Methods", new org.fife.ui.rtextarea.RTextScrollPane(txtMethods));
      tabbedPane.add("Imports", new org.fife.ui.rtextarea.RTextScrollPane(txtImports));
      add(tabbedPane, java.awt.BorderLayout.CENTER);
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
         model.setStatements(appModel().db.findOrCreateSTValueByValue(txtStatements.getText().trim()));
         model.setMethods(appModel().db.findOrCreateSTValueByValue(txtMethods.getText().trim()));
         model.setImports(appModel().db.findOrCreateSTValueByValue(txtImports.getText().trim()));
         nextgen.events.STGroupActionChanged.post(model);
      });
   }
}