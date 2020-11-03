package nextgen.actions;

public class AddValueToProject extends TransactionAction {


   private final nextgen.st.model.STProject project;
   private final nextgen.st.model.STValue stValue;

	public AddValueToProject(nextgen.st.model.STProject project, nextgen.st.model.STValue stValue) {
		super("Add to Project");
		this.project = project;
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("AddValueToProject");
      project.addValues(stValue);
      nextgen.events.NewSTProjectSTValue.post(stValue, project);
   }
}