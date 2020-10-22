package nextgen.actions;

public class AddTemplateModelToProject extends TransactionAction {

   private final nextgen.st.domain.STTemplate stTemplate;
   private final nextgen.st.model.STProject project;

	public AddTemplateModelToProject(String name, nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STProject project) {
      super(name);
      this.stTemplate = stTemplate;
      this.project = project;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.st.model.STModel stModel = appModel().newSTModel(stTemplate);
      project.addModels(stModel);
      nextgen.events.NewSTProjectSTModel.post(stModel, project);
   }
}