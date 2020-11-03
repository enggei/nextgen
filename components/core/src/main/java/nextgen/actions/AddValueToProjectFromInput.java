package nextgen.actions;

public class AddValueToProjectFromInput extends TransactionAction {


   private final nextgen.st.model.STProject project;
   private final javax.swing.JComponent owner;

	public AddValueToProjectFromInput(nextgen.st.model.STProject project, javax.swing.JComponent owner) {
		super("Add New Value to Project");
		this.project = project;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "New Value", value -> {
         final nextgen.st.model.STValue stValue = appModel().newSTValue(value);
         project.addValues(stValue);
         nextgen.events.NewSTProjectSTValue.post(stValue, project);
      });
   }
}