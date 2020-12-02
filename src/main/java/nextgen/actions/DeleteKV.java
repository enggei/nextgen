package nextgen.actions;

public class DeleteKV extends nextgen.actions.TransactionAction {

   private final nextgen.model.STArgumentKV argumentKV;
   private final javax.swing.JComponent owner;

	public DeleteKV(nextgen.model.STArgumentKV argumentKV, javax.swing.JComponent owner) {
		super("Remove");
		this.argumentKV = argumentKV;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Delete", unused ->
            argumentKV.getIncomingKeyValuesSTArgument()
                  .findFirst()
                  .ifPresent(stArgument -> stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {
                     final String uuid = argumentKV.getUuid();
                     stArgument.removeKeyValues(argumentKV);
                     nextgen.events.KVDeleted.post(stModel, stArgument, uuid);
                  })));
   }

}