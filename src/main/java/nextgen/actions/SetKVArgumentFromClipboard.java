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
   	System.out.println("SetKVArgumentFromClipboard" + " stModel" + " stArgument" + " stParameterKey");

      appModel().setArgumentKV(stModel, stArgument, stParameterKey, nextgen.utils.SwingUtil.fromClipboard());
   }

}