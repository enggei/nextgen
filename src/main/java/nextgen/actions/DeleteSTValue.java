package nextgen.actions;

public class DeleteSTValue extends TransactionAction {


   private final nextgen.model.STValue stValue;
   private final javax.swing.JComponent owner;

	public DeleteSTValue(nextgen.model.STValue stValue, javax.swing.JComponent owner) {
		super("Delete");
		this.stValue = stValue;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Delete", unused -> {
         final String uuid = stValue.getUuid();
         final nextgen.model.STValue found = appModel().db.findSTValueByUuid(uuid);
         if (found != null) appModel().db.delete(found.getNode());
         nextgen.events.STValueDeleted.post(uuid);
      });
   }

}