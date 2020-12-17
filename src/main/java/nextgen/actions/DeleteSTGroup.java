package nextgen.actions;

public class DeleteSTGroup extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public DeleteSTGroup(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Delete");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("DeleteSTGroup" + " stGroup" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stGroup));
   }

}