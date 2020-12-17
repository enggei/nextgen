package nextgen.actions;

public class SetKVArgumentFromSTValue extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STArgument stArgument;
   private final nextgen.model.STParameterKey stParameterKey;
   private final nextgen.model.STValue stValue;

	public SetKVArgumentFromSTValue(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, nextgen.model.STValue stValue) {
		super("Set " + stParameterKey.getName() + " from STValue");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("SetKVArgumentFromSTValue" + " stModel" + " stArgument" + " stParameterKey" + " stValue");

      appModel().setArgumentKV(stModel, stArgument, stParameterKey, stValue);
   }

}