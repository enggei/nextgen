package nextgen.actions;

public class SetKVArgumentFromSTModel extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.model.STArgument stArgument;
   private final nextgen.st.domain.STParameterKey stParameterKey;
   private final nextgen.st.model.STModel value;

	public SetKVArgumentFromSTModel(String name, nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STModel value) {
      super(name);
      this.stModel = stModel;
      this.stArgument = stArgument;
      this.stParameterKey = stParameterKey;
      this.value = value;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      stArgument.getKeyValues()
            .filter(existing -> existing.getStParameterKey().equals(stParameterKey.getUuid()))
            .findFirst()
            .ifPresent(existing -> {
               stArgument.removeKeyValues(existing);
               final String uuid = existing.getUuid();
               existing.delete();
               nextgen.events.KVDeleted.post(stModel, stArgument, uuid);
            });

      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);
      final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);

      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stValue);
   }
}