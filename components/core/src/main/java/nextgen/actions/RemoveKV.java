package nextgen.actions;

public class RemoveKV extends TransactionAction {

   private final nextgen.st.model.STArgumentKV argumentKV;
   private final javax.swing.JComponent owner;

	public RemoveKV(nextgen.st.model.STArgumentKV argumentKV, javax.swing.JComponent owner) {
		super("Remove");
		this.argumentKV = argumentKV;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.confirm(owner, "Delete ?").ifPresent(aBoolean -> appModel().remove(argumentKV));
   }
}