package nextgen.actions;

public class DeleteSTArgument extends nextgen.actions.TransactionAction {
   private final nextgen.model.STArgument stArgument;
   private final javax.swing.JComponent owner;

	public DeleteSTArgument(nextgen.model.STArgument stArgument, javax.swing.JComponent owner) {
		super("Delete");
		this.stArgument = stArgument;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Remove", unused ->
            stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {
               final String uuid = stArgument.getUuid();
               stModel.removeArguments(stArgument);
               stArgument.getKeyValues().forEach(nextgen.model.STArgumentKV::delete);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(stModel, uuid);
            }));
   }

}