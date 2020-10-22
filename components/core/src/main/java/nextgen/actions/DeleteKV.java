package nextgen.actions;

public class DeleteKV extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.model.STArgument stArgument;
   private final nextgen.st.model.STArgumentKV argumentKV;
   private final javax.swing.JComponent owner;

	public DeleteKV(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument, nextgen.st.model.STArgumentKV argumentKV, javax.swing.JComponent owner) {
		super("Remove");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.argumentKV = argumentKV;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Delete", unused ->
            argumentKV.getIncomingKeyValuesSTArgument().findFirst().ifPresent(stArgument -> {
               final String uuid = argumentKV.getUuid();
               stArgument.removeKeyValues(argumentKV);
               nextgen.events.KVDeleted.post(stModel, stArgument, uuid);
            }));
   }
}