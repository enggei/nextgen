package nextgen.actions;

public class NewSTModelAction extends TransactionAction {


   private final nextgen.st.domain.STTemplate stTemplate;

	public NewSTModelAction(nextgen.st.domain.STTemplate stTemplate) {
		super("New instance");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("NewSTModelAction");
      System.out.println("NewSTModelAction");
      System.out.println("NewSTModel");
      final nextgen.st.model.STModel stModel = appModel().newSTModel(stTemplate);
      nextgen.events.NewSTModel.post(stModel, appModel().findSTGroup(stTemplate), stTemplate);
   }
}