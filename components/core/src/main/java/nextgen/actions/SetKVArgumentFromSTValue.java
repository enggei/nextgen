package nextgen.actions;

public class SetKVArgumentFromSTValue extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.model.STArgument stArgument;
   private final nextgen.st.domain.STParameterKey stParameterKey;
   private final nextgen.st.model.STValue stValue;

	public SetKVArgumentFromSTValue(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey, nextgen.st.model.STValue stValue) {
		super("Set " + stParameterKey.getName() + " from STValue");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("SetKVArgumentFromSTValue");
      stArgument.getKeyValues()
            .filter(existing -> existing.getStParameterKey().equals(stParameterKey.getUuid()))
            .findFirst()
            .ifPresent(existing -> {
               stArgument.removeKeyValues(existing);
               final String uuid = existing.getUuid();
               existing.delete();
               nextgen.events.KVDeleted.post(stModel, stArgument, uuid);
            });

      final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);

      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
   }
}