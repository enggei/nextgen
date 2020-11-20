package nextgen.actions;

public class DeleteSTGroup extends TransactionAction {


   private final nextgen.st.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public DeleteSTGroup(nextgen.st.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Delete");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Delete", unused -> {
         final String uuid = stGroup.getUuid();
         stGroup.delete();
         nextgen.events.STGroupDeleted.post(uuid);
      });
   }

}