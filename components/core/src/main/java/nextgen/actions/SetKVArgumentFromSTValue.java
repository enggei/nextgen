package nextgen.actions;

public class SetKVArgumentFromSTValue extends TransactionAction {

   private final nextgen.st.model.STArgument stArgument;
   private final nextgen.st.domain.STParameterKey stParameterKey;
   private final nextgen.st.model.STValue value;

	public SetKVArgumentFromSTValue(String name, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STValue value) {
      super(name);
      this.stArgument = stArgument;
      this.stParameterKey = stParameterKey;
      this.value = value;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().doLaterInTransaction(transaction1 -> appModel().set(stArgument, stParameterKey, value));
   }
}