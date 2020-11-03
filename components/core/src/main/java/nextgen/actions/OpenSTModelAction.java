package nextgen.actions;

public class OpenSTModelAction extends TransactionAction {


   private final nextgen.st.model.STModel stModel;

	public OpenSTModelAction(nextgen.st.model.STModel stModel) {
		super("Open");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("OpenSTModelAction");
      System.out.println("OpenSTModelAction");
      System.out.println("OpenSTModel");
      nextgen.events.OpenSTModel.post(stModel);
   }
}