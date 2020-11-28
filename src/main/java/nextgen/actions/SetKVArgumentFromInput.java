package nextgen.actions;

public class SetKVArgumentFromInput extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.model.STArgument stArgument;
   private final nextgen.st.model.STParameterKey stParameterKey;
   private final javax.swing.JComponent owner;

	public SetKVArgumentFromInput(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument, nextgen.st.model.STParameterKey stParameterKey, javax.swing.JComponent owner) {
		super("Set " + stParameterKey.getName() + " from Input");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, stParameterKey.getName(), inputValue -> {
      	stArgument.getKeyValues()
      			.filter(existing -> existing.getStParameterKey().equals(stParameterKey))
      			.findFirst()
      			.ifPresent(existing -> {
      				stArgument.removeKeyValues(existing);
      				final String uuid = existing.getUuid();
      				existing.delete();
      				nextgen.events.KVDeleted.post(stModel, stArgument, uuid);
      			});

      	final nextgen.st.model.STValue stValue = appModel().db.newSTValue(inputValue);
      	final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV().setStParameterKey(stParameterKey).setValue(stValue);
      	stArgument.addKeyValues(stArgumentKV);

      	nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
      });
   }

}