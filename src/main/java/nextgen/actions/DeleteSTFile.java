package nextgen.actions;

public class DeleteSTFile extends nextgen.actions.TransactionAction {

   private final nextgen.model.STFile stFile;
   private final javax.swing.JComponent owner;

	public DeleteSTFile(nextgen.model.STFile stFile, javax.swing.JComponent owner) {
		super("Delete");
		this.stFile = stFile;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("DeleteSTFile" + " stFile" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stFile));
   }

}