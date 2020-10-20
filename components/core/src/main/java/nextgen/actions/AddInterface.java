package nextgen.actions;

public class AddInterface extends TransactionAction {

   private final java.util.Set<nextgen.st.domain.STTemplate> children;
   private final javax.swing.JComponent owner;

	public AddInterface(String name, java.util.Set<nextgen.st.domain.STTemplate> children, javax.swing.JComponent owner) {
      super(name);
      this.children = children;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final javax.swing.JTextField txtImplements = new javax.swing.JTextField("", 15);

      final javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities
      		.getAncestorOfClass(javax.swing.JFrame.class, owner), "Edit interfaces", true);
      final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(1, 1));
      contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
      contentPanel.add(txtImplements);
      dialog.add(contentPanel, java.awt.BorderLayout.CENTER);

      final javax.swing.JButton btnSave = new javax.swing.JButton(nextgen.st.STAppPresentationModel.newAction("Save", actionEvent1 -> {
      	final String interfaceName = txtImplements.getText().trim();
      	appModel().addInterface(children, interfaceName);
      	javax.swing.SwingUtilities.invokeLater(dialog::dispose);
      }));

      nextgen.utils.SwingUtil.showDialog(owner, dialog, btnSave);
   }
}