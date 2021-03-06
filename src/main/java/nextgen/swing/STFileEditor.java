package nextgen.swing;

public class STFileEditor extends AbstractEditor {

   final javax.swing.JTextField txtName;
   final javax.swing.JTextField txtPackage;
   final javax.swing.JTextField txtType;
   final javax.swing.JTextField txtPath;

   private final nextgen.model.STFile stFile;
   private String uuid;

   public STFileEditor(nextgen.model.STFile stFile) {

      txtName = newTextField(appModel().render(stFile.getName()), 45);
      txtPackage = newTextField(appModel().render(stFile.getPackageName()), 45);
      txtType = newTextField(appModel().render(stFile.getType()), 45);
      txtPath = newTextField(appModel().render(stFile.getPath()), 45);

      this.stFile = stFile;
      this.uuid = stFile.getUuid();

      final java.awt.event.KeyListener editorKeyListener = getEditorKeyListener();
      txtName.addKeyListener(editorKeyListener);
      txtPackage.addKeyListener(editorKeyListener);
      txtType.addKeyListener(editorKeyListener);
      txtPath.addKeyListener(editorKeyListener);

      add(newGridPanel(4, 2)
            .appendLabel("Name").append(txtName)
            .appendLabel("Package").append(txtPackage)
            .appendLabel("Type").append(txtType)
            .appendLabel("Path").append(txtPath), java.awt.BorderLayout.CENTER);
   }

   public nextgen.model.STFile getModel() {
      return stFile;
   }

   public String getUuid() {
      return uuid;
   }

   @Override
   protected void tryToSave() {
      final String name = txtName.getText().trim();
      final String packageName = txtPackage.getText().trim();
      final String type = txtType.getText().trim();
      final String path = txtPath.getText().trim();

      stFile.setName(appModel().db.findOrCreateSTValueByValue(name));
      stFile.setPackageName(appModel().db.findOrCreateSTValueByValue(packageName));
      stFile.setType(appModel().db.findOrCreateSTValueByValue(type));
      stFile.setPath(appModel().db.findOrCreateSTValueByValue(path));

      nextgen.events.STFileChanged.post(stFile);
   }
}
