package nextgen.actions;

public class AddModelToProject extends TransactionAction {


   private final nextgen.st.model.STProject project;
   private final nextgen.st.model.STModel stModel;

	public AddModelToProject(nextgen.st.model.STProject project, nextgen.st.model.STModel stModel) {
		super("Add to Project");
		this.project = project;
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("AddModelToProject");
      project.addModels(stModel);
      nextgen.events.NewSTProjectSTModel.post(stModel, project, appModel().getSTTemplate(stModel));
   }
}