package nextgen.actions;

public class AddModelToProject extends TransactionAction {


   private final nextgen.st.model.STProject project;
   private final nextgen.st.model.STModel stModel;

	public AddModelToProject(String name, nextgen.st.model.STProject project, nextgen.st.model.STModel stModel) {
      super(name);
      this.project = project;
      this.stModel = stModel;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      project.addModels(stModel);
      nextgen.events.NewSTProjectSTModel.post(stModel, project);
   }
}