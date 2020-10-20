package nextgen.actions;

public class RemoveKVArgument extends TransactionAction {

   private final nextgen.st.model.STArgument argument;
   private final javax.swing.JComponent owner;

	public RemoveKVArgument(nextgen.st.model.STArgument argument, javax.swing.JComponent owner) {
		super("Remove");
		this.argument = argument;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.confirm(owner, "Delete ?").ifPresent(aBoolean -> appModel().remove(argument));
   }
}