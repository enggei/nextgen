package nextgen.actions;

public class WriteSTModelToFile extends TransactionAction {

   private final nextgen.st.model.STModel stModel;

	public WriteSTModelToFile(nextgen.st.model.STModel stModel) {
		super("Visit");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().writeToFile(stModel);
   }
}