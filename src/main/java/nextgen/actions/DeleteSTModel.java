package nextgen.actions;

public class DeleteSTModel extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final javax.swing.JComponent owner;

	public DeleteSTModel(nextgen.model.STModel stModel, javax.swing.JComponent owner) {
		super("Delete");
		this.stModel = stModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("DeleteSTModel" + " stModel" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stModel));
   }

}