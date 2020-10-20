package nextgen.actions;

public class GenerateAllProjectModels extends TransactionAction {

   private final nextgen.st.model.STProject project;

	public GenerateAllProjectModels(nextgen.st.model.STProject project) {
		super("Generate all");
		this.project = project;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().writeToFile(project);
   }
}