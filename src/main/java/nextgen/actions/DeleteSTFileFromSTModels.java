package nextgen.actions;

public class DeleteSTFileFromSTModels extends nextgen.actions.TransactionAction {

   private final java.util.List<nextgen.model.STModel> stModels;
   private final javax.swing.JComponent owner;

	public DeleteSTFileFromSTModels(java.util.List<nextgen.model.STModel> stModels, javax.swing.JComponent owner) {
		super("Delete Filesinks");
		this.stModels = stModels;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("DeleteSTFileFromSTModels" + " stModels" + " owner");

      confirm(owner, "Delete", unused -> appModel().deleteSTFilesFrom(stModels));
   }

}