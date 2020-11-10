package nextgen.st;

public class STFileEditor extends javax.swing.JPanel {

   final javax.swing.JTextField txtName = new javax.swing.JTextField( 45);
   final javax.swing.JTextField txtPackage = new javax.swing.JTextField( 45);
   final javax.swing.JTextField txtType = new javax.swing.JTextField(45);
   final javax.swing.JTextField txtPath = new javax.swing.JTextField( 45);

   private final nextgen.st.model.STFile stFile;

   public STFileEditor(nextgen.st.model.STFile stFile) {
      super(new java.awt.BorderLayout());
      setBackground(javax.swing.UIManager.getColor("Panel.background"));
      this.stFile = stFile;

      txtName.setText(appModel().render(stFile.getName()));
      txtPackage.setText(appModel().render(stFile.getPackageName()));
      txtType.setText(appModel().render(stFile.getType()));
      txtPath.setText(appModel().render(stFile.getPath()));

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

   protected nextgen.st.STAppPresentationModel appModel() {
      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
   }

   private java.awt.event.KeyListener getEditorKeyListener() {
      return new java.awt.event.KeyAdapter() {
         @Override
         public void keyPressed(java.awt.event.KeyEvent keyEvent) {
            if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
               tryToSave();
            }
         }
      };
   }

   private void tryToSave() {
      appModel().doInTransaction(transaction -> {
         final String name = txtName.getText().trim();
         final String packageName = txtPackage.getText().trim();
         final String type = txtType.getText().trim();
         final String path = txtPath.getText().trim();

         stFile.setName(appModel().db.findOrCreateSTValueByValue(name));
         stFile.setPackageName(appModel().db.findOrCreateSTValueByValue(packageName));
         stFile.setType(appModel().db.findOrCreateSTValueByValue(type));
         stFile.setPath(appModel().db.findOrCreateSTValueByValue(path));

         nextgen.events.STFileChanged.post(stFile);
      });
   }
}
