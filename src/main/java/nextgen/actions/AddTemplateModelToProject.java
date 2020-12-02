package nextgen.actions;

public class AddTemplateModelToProject extends nextgen.actions.TransactionAction {

   private final nextgen.model.STTemplate stTemplate;
   private final nextgen.model.STProject project;

	public AddTemplateModelToProject(String name, nextgen.model.STTemplate stTemplate, nextgen.model.STProject project) {
      super(name);
      this.stTemplate = stTemplate;
      this.project = project;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.model.STModel stModel = appModel().db.newSTModel().setStTemplate(stTemplate);
      project.addModels(stModel);
      nextgen.events.NewSTProjectSTModel.post(stModel, project, stTemplate);
   }

}