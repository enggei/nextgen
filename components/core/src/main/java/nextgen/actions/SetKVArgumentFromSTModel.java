package nextgen.actions;

public class SetKVArgumentFromSTModel extends TransactionAction {

   private final nextgen.st.model.STArgument stArgument;
   private final nextgen.st.domain.STParameterKey stParameterKey;
   private final nextgen.st.model.STModel stModel;

	public SetKVArgumentFromSTModel(String name, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STModel stModel) {
      super(name);
      this.stArgument = stArgument;
      this.stParameterKey = stParameterKey;
      this.stModel = stModel;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().doLaterInTransaction(transaction1 -> appModel().set(stArgument, stParameterKey, stModel));
   }
}