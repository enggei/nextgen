package nextgen.actions;

public class OpenModel extends TransactionAction {

   private final nextgen.st.model.STModel stModel;

	public OpenModel(nextgen.st.model.STModel stModel) {
		super("Open");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.events.OpenSTModel.post(stModel);
   }
}