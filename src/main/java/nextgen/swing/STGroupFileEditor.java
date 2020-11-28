package nextgen.swing;

public class STGroupFileEditor extends AbstractEditor {

   final javax.swing.JTextField txtPackage;
   final javax.swing.JTextField txtPath;

   private final nextgen.model.STGroupFile stGroupFile;
   private String uuid;

   public STGroupFileEditor(nextgen.model.STGroupFile stGroupFile) {

      this.stGroupFile = stGroupFile;
      this.uuid = stGroupFile.getUuid();

      txtPackage = newTextField(stGroupFile.getPackageName(), 45);
      txtPath = newTextField(stGroupFile.getPath(), 45);

      final java.awt.event.KeyListener editorKeyListener = getEditorKeyListener();
      txtPackage.addKeyListener(editorKeyListener);
      txtPackage.addKeyListener(editorKeyListener);

      final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(4, 2));
      inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

      inputPanel.add(new javax.swing.JLabel("Package"));
      inputPanel.add(txtPackage);

      inputPanel.add(new javax.swing.JLabel("Path"));
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

      stGroupFile.setPackageName(packageName);
      stGroupFile.setPath(path);

      nextgen.events.STGroupFileChanged.post(stGroupFile);
   }

   public String getUuid() {
      return uuid;
   }
}