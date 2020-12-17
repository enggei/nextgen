package nextgen.actions;

public class AddValueToProject extends nextgen.actions.TransactionAction {

   private final nextgen.model.STProject project;
   private final nextgen.model.STValue stValue;

	public AddValueToProject(nextgen.model.STProject project, nextgen.model.STValue stValue) {
		super("Add to Project");
		this.project = project;
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("AddValueToProject" + " project" + " stValue");

      project.addValues(stValue);
      nextgen.events.NewSTProjectSTValue.post(stValue, project);
   }

}