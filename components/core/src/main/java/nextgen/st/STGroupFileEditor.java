package nextgen.st;

public class STGroupFileEditor extends AbstractEditor {

   final javax.swing.JTextField txtPackage;
   final javax.swing.JTextField txtPath;

   private final nextgen.st.model.STGroupFile stGroupFile;

   public STGroupFileEditor(nextgen.st.model.STGroupFile stGroupFile) {
      this.stGroupFile = stGroupFile;

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

   public nextgen.st.model.STGroupFile getSTGroupFile() {
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
}