package nextgen.swing;

public class STGroupFileEditor extends AbstractEditor {

   final javax.swing.JTextField txtPackage;
   final javax.swing.JTextField txtPath;

   private final nextgen.model.STGroupFile stGroupFile;
   private String uuid;

   public STGroupFileEditor(nextgen.model.STGroupFile stGroupFile) {

      this.stGroupFile = stGroupFile;
      this.uuid = stGroupFile.getUuid();

      txtPackage = newTextField(appModel().render(stGroupFile.getPackageName()), 45);
      txtPath = newTextField(appModel().render(stGroupFile.getPath()), 45);

      final java.awt.event.KeyListener editorKeyListener = getEditorKeyListener();
      txtPackage.addKeyListener(editorKeyListener);
      txtPath.addKeyListener(editorKeyListener);

      final javax.swing.JPanel inputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(4, 2));
      inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

      inputPanel.add(nextgen.swing.ComponentFactory.newJLabel("Package"));
      inputPanel.add(txtPackage);

      inputPanel.add(nextgen.swing.ComponentFactory.newJLabel("Path"));
      inputPanel.add(txtPath);

      add(inputPanel, java.awt.BorderLayout.NORTH);
   }

   public nextgen.model.STGroupFile getModel() {
      return stGroupFile;
   }

   @Override
   protected void tryToSave() {
      final String packageName = txtPackage.getText().trim();
      final String path = txtPath.getText().trim();

      stGroupFile.setPackageName(appModel().db.findOrCreateSTValueByValue(packageName));
      stGroupFile.setPath(appModel().db.findOrCreateSTValueByValue(path));

      nextgen.events.STGroupFileChanged.post(stGroupFile);
   }

   public String getUuid() {
      return uuid;
   }
}