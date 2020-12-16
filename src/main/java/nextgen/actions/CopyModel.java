package nextgen.actions;

public class CopyModel extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;

	public CopyModel(nextgen.model.STModel stModel) {
		super("Copy Model");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.model.STTemplate stTemplate = stModel.getStTemplate();
      final nextgen.model.STModel copy = appModel().db.newSTModel().setStTemplate(stTemplate);
      new CopyInto(copy, stModel).actionPerformed(actionEvent, transaction);

      final java.util.Optional<nextgen.model.STProject> stProject = stModel.getIncomingModelsSTProject().findAny();
      if (stProject.isPresent()) {
         stProject.get().addModels(copy);
         nextgen.events.NewSTProjectSTModel.post(copy, stProject.get(), stTemplate);
      } else
         nextgen.events.NewSTModel.post(copy, nextgen.utils.STModelUtil.getSTGroup(stTemplate), stTemplate);
   }

}