package nextgen.actions;

public class ReconcileDuplicateModels extends nextgen.actions.TransactionAction {


	public ReconcileDuplicateModels() {
		super("Merge Duplicates");
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().reconcileDuplicateModels();
   }

}