package nextgen.actions;

public class RemoveArgument extends TransactionAction {

   private final Object argument;
   private final javax.swing.JComponent owner;

	public RemoveArgument(Object argument, javax.swing.JComponent owner) {
		super("Remove");
		this.argument = argument;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.confirm(owner, "Remove")
      							.ifPresent(aBoolean ->
      									appModel().doLaterInTransaction(t -> {
      										if (argument instanceof nextgen.st.model.STArgument)
      											appModel().remove((nextgen.st.model.STArgument) argument);
      										else if (argument instanceof nextgen.st.model.STArgumentKV)
      											appModel().remove((nextgen.st.model.STArgumentKV) argument);
      									}));
   }
}