package nextgen.actions;

public class SetInterfaces extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupModel stGroup;
   private final nextgen.model.STTemplate stTemplate;
   private final javax.swing.JComponent owner;

	public SetInterfaces(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate, javax.swing.JComponent owner) {
		super("Set interfaces");
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("SetInterfaces" + " stGroup" + " stTemplate" + " owner");

      final java.util.List<javax.swing.JTextField> txtImplements = new java.util.ArrayList<>();
      stTemplate.getImplements().forEach(implement -> {
         final javax.swing.JTextField textField = newTextField(implement, 15);
         txtImplements.add(textField);
      });
      txtImplements.add(newTextField("", 15));
      txtImplements.add(newTextField("", 15));

      final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(txtImplements.size(), 1));
      contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
      for (javax.swing.JTextField txtImplement : txtImplements)
         contentPanel.add(txtImplement);

      showDialog(owner, contentPanel, "Edit", jDialog -> {
         stTemplate.removeAllImplements();
         for (javax.swing.JTextField txtImplement : txtImplements) {
            final String trim = txtImplement.getText().trim();
            if (trim.length() == 0) continue;
            stTemplate.addImplements(trim);
         }

         nextgen.events.STTemplateInterfacesChanged.post(stGroup, stTemplate);
         javax.swing.SwingUtilities.invokeLater(jDialog::dispose);
      });
   }

}