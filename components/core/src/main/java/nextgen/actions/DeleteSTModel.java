package nextgen.actions;

public class DeleteSTModel extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final javax.swing.JComponent owner;

	public DeleteSTModel(nextgen.st.model.STModel stModel, javax.swing.JComponent owner) {
		super("Delete");
		this.stModel = stModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Delete", unused -> {
         final String uuid = stModel.getUuid();
         final nextgen.st.model.STValue found = appModel().db.findSTValueByUuid(uuid);
         if (found != null) appModel().db.delete(found.getNode());
         nextgen.events.STModelDeleted.post(uuid);
      });
   }
}