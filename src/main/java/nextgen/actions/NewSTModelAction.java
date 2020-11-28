package nextgen.actions;

public class NewSTModelAction extends TransactionAction {


   private final nextgen.model.STTemplate stTemplate;

	public NewSTModelAction(nextgen.model.STTemplate stTemplate) {
		super("New instance");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.model.STModel stModel = appModel().db.newSTModel().setStTemplate(stTemplate);
      nextgen.events.NewSTModel.post(stModel, appModel().findSTGroup(stTemplate), stTemplate);
   }

}