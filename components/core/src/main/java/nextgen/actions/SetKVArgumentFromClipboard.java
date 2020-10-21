package nextgen.actions;

public class SetKVArgumentFromClipboard extends TransactionAction {

   private final nextgen.st.model.STArgument stArgument;
   private final nextgen.st.domain.STParameterKey stParameterKey;

	public SetKVArgumentFromClipboard(String name, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey) {
      super(name);
      this.stArgument = stArgument;
      this.stParameterKey = stParameterKey;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().doLaterInTransaction(transaction1 -> appModel().set(stArgument, stParameterKey, nextgen.utils.SwingUtil.fromClipboard()));
   }
}