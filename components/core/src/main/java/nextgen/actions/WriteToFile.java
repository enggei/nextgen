package nextgen.actions;

public class WriteToFile extends TransactionAction {

   private final nextgen.st.model.STModel stModel;

	public WriteToFile(nextgen.st.model.STModel stModel) {
		super("Generate");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().writeToFile(stModel);
   }
}