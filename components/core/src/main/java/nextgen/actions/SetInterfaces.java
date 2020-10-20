package nextgen.actions;

public class SetInterfaces extends TransactionAction {

   private final nextgen.st.domain.STTemplate stTemplate;
   private final javax.swing.JComponent owner;

	public SetInterfaces(nextgen.st.domain.STTemplate stTemplate, javax.swing.JComponent owner) {
		super("Set interfaces");
		this.stTemplate = stTemplate;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final java.util.List<javax.swing.JTextField> txtImplements = new java.util.ArrayList<>();
      stTemplate.getImplements().forEach(implement -> {
      	final javax.swing.JTextField textField = nextgen.utils.SwingUtil.newTextField(implement, 15);
      	txtImplements.add(textField);
      });
      txtImplements.add(nextgen.utils.SwingUtil.newTextField("", 15));
      txtImplements.add(nextgen.utils.SwingUtil.newTextField("", 15));

      final javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities
      		.getAncestorOfClass(javax.swing.JFrame.class, owner), "Edit interfaces", true);
      final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(txtImplements.size(), 1));
      contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
      for (javax.swing.JTextField txtImplement : txtImplements) {
      	contentPanel.add(txtImplement);
      }
      dialog.add(contentPanel, java.awt.BorderLayout.CENTER);

      final javax.swing.JButton btnSave = new javax.swing.JButton(nextgen.st.STAppPresentationModel.newAction("Save", actionEvent1 -> {

      	stTemplate.clearImplements();
      	for (javax.swing.JTextField txtImplement : txtImplements) {
      		final String trim = txtImplement.getText().trim();
      		if (trim.length() == 0) continue;
      		stTemplate.addImplements(trim);
      	}
      	appModel().setInterfaces(stTemplate);

      	javax.swing.SwingUtilities.invokeLater(dialog::dispose);
      }));

      nextgen.utils.SwingUtil.showDialog(owner, dialog, btnSave);
   }
}