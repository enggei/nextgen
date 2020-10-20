package nextgen.actions;

public class DeleteSTValue extends TransactionAction {

   private final nextgen.st.model.STValue stValue;
   private final javax.swing.JComponent owner;

	public DeleteSTValue(nextgen.st.model.STValue stValue, javax.swing.JComponent owner) {
		super("Delete");
		this.stValue = stValue;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.confirm(owner, "Delete").ifPresent(aBoolean -> appModel().doLaterInTransaction(t -> appModel().delete(stValue)));
   }
}