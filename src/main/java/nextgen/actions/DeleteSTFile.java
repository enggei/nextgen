package nextgen.actions;

public class DeleteSTFile extends TransactionAction {


   private final nextgen.model.STFile stFile;
   private final javax.swing.JComponent owner;

	public DeleteSTFile(nextgen.model.STFile stFile, javax.swing.JComponent owner) {
		super("Delete");
		this.stFile = stFile;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Delete", unused -> {
         final String uuid = stFile.getUuid();
         final nextgen.model.STFile found = appModel().db.findSTFileByUuid(uuid);
         if (found != null) appModel().db.delete(found.getNode());
         nextgen.events.STFileDeleted.post(uuid);
      });
   }

}