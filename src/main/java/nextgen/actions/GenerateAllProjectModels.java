package nextgen.actions;

public class GenerateAllProjectModels extends nextgen.actions.TransactionAction {

   private final nextgen.model.STProject project;

	public GenerateAllProjectModels(nextgen.model.STProject project) {
		super("Generate all");
		this.project = project;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("GenerateAllProjectModels" + " project");

      appModel().generateAll(project);
   }

}