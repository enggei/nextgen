package nextgen.actions;

public class SetKVArgumentFromClipboard extends nextgen.actions.TransactionAction {
   private final nextgen.model.STModel stModel;
   private final nextgen.model.STArgument stArgument;
   private final nextgen.model.STParameterKey stParameterKey;

	public SetKVArgumentFromClipboard(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey) {
		super("Set " + stParameterKey.getName() + " from Clipboard");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      stArgument.getKeyValues()
            .filter(existing -> existing.getStParameterKey().equals(stParameterKey))
            .findFirst()
            .ifPresent(existing -> {
               stArgument.removeKeyValues(existing);
               final String uuid = existing.getUuid();
               existing.delete();
               nextgen.events.KVDeleted.post(stModel, stArgument, uuid);
            });

      final nextgen.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());
      final nextgen.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV().setStParameterKey(stParameterKey).setValue(stValue);
      stArgument.addKeyValues(stArgumentKV);

      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
   }

}