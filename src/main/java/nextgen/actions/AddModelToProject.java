package nextgen.actions;

public class AddModelToProject extends nextgen.actions.TransactionAction {

   private final nextgen.model.STProject project;
   private final nextgen.model.STModel stModel;

	public AddModelToProject(nextgen.model.STProject project, nextgen.model.STModel stModel) {
		super("Add to Project");
		this.project = project;
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("AddModelToProject" + " project" + " stModel");

      appModel().addSTModel(project, stModel);
   }

}