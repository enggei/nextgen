package nextgen.actions;

public class NewSTModelAction extends TransactionAction {


   private final nextgen.st.model.STTemplate stTemplate;

	public NewSTModelAction(nextgen.st.model.STTemplate stTemplate) {
		super("New instance");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.st.model.STModel stModel = appModel().db.newSTModel().setStTemplate(stTemplate);
      nextgen.events.NewSTModel.post(stModel, appModel().findSTGroup(stTemplate), stTemplate);
   }

}