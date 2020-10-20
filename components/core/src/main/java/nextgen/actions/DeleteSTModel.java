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
      nextgen.utils.SwingUtil.confirm(owner, "Delete").ifPresent(aBoolean -> appModel().doLaterInTransaction(t -> appModel().delete(stModel)));
   }
}