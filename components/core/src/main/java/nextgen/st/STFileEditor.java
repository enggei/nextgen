package nextgen.st;

public class STFileEditor extends AbstractEditor {

   final javax.swing.JTextField txtName;
   final javax.swing.JTextField txtPackage;
   final javax.swing.JTextField txtType;
   final javax.swing.JTextField txtPath;

   private final nextgen.st.model.STFile stFile;

   public STFileEditor(nextgen.st.model.STFile stFile) {

      txtName = newTextField(appModel().render(stFile.getName()), 45);
      txtPackage = newTextField(appModel().render(stFile.getPackageName()), 45);
      txtType = newTextField(appModel().render(stFile.getType()), 45);
      txtPath = newTextField(appModel().render(stFile.getPath()), 45);

      this.stFile = stFile;

      final java.awt.event.KeyListener editorKeyListener = getEditorKeyListener();
      txtName.addKeyListener(editorKeyListener);
      txtPackage.addKeyListener(editorKeyListener);
      txtType.addKeyListener(editorKeyListener);
      txtPackage.addKeyListener(editorKeyListener);

      final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(4, 2));
      inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

      inputPanel.add(new javax.swing.JLabel("Name"));
      inputPanel.add(txtName);

      inputPanel.add(new javax.swing.JLabel("Package"));
      inputPanel.add(txtPackage);

      inputPanel.add(new javax.swing.JLabel("Type"));
      inputPanel.add(txtType);

      inputPanel.add(new javax.swing.JLabel("Path"));
      inputPanel.add(txtPath);

      add(inputPanel, java.awt.BorderLayout.NORTH);
   }

   public nextgen.st.model.STFile getSTFile() {
      return stFile;
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
