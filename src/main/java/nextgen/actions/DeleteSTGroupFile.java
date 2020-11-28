package nextgen.actions;

public class DeleteSTGroupFile extends nextgen.actions.TransactionAction {


   private final nextgen.model.STGroupFile stgroupFile;
   private final javax.swing.JComponent owner;

	public DeleteSTGroupFile(nextgen.model.STGroupFile stgroupFile, javax.swing.JComponent owner) {
		super("Delete");
		this.stgroupFile = stgroupFile;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Delete", unused -> {
      	final String uuid = stgroupFile.getUuid();
      	stgroupFile.delete();
      	nextgen.events.STGroupFileDeleted.post(uuid);
      });
   }

}