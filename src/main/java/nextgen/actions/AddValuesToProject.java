package nextgen.actions;

public class AddValuesToProject extends nextgen.actions.TransactionAction {

   private final nextgen.model.STProject project;
   private final javax.swing.JComponent owner;

	public AddValuesToProject(nextgen.model.STProject project, javax.swing.JComponent owner) {
		super("Add Multiple Values");
		this.project = project;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("AddValuesToProject" + " project" + " owner");

      final java.util.List<javax.swing.JTextField> fields = new java.util.ArrayList<>();
      for (int i = 0; i < 10; i++) {
         fields.add(newTextField(30));
      }

      final javax.swing.JPanel inputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(fields.size(), 1));
      inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (javax.swing.JTextField field : fields) {
         inputPanel.add(field);
      }

      showDialog(owner, inputPanel, "Values", jDialog -> {

         for (javax.swing.JTextField field : fields) {
            final String value = field.getText().trim();
            if(value.length()==0) continue;
            appModel().addSTValue(project, value);
         }

         close(jDialog);
      });
   }

}