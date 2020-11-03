package nextgen.actions;

public class DeleteSTArgument extends TransactionAction {


   private final nextgen.st.model.STArgument stArgument;
   private final javax.swing.JComponent owner;

	public DeleteSTArgument(nextgen.st.model.STArgument stArgument, javax.swing.JComponent owner) {
		super("Delete");
		this.stArgument = stArgument;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("DeleteSTArgument");
      confirm(owner, "Remove", unused ->
            stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {
               final String uuid = stArgument.getUuid();
               stModel.removeArguments(stArgument);
               stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(stModel, uuid);
            }));
   }
}