package nextgen.actions;

public class SetKVArgumentFromSTModel extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STArgument stArgument;
   private final nextgen.model.STParameterKey stParameterKey;
   private final nextgen.model.STModel value;

	public SetKVArgumentFromSTModel(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STModel value) {
		super("Set " + stParameterKey.getName() + " from STModel");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.value = value;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("SetKVArgumentFromSTModel" + " stModel" + " stArgument" + " stParameterKey" + " value");

      appModel().setArgumentKV(stModel, stArgument, stParameterKey, value);
   }

}