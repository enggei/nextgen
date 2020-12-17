package nextgen.actions;

public class SetKVArgumentFromInput extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STArgument stArgument;
   private final nextgen.model.STParameterKey stParameterKey;
   private final javax.swing.JComponent owner;

	public SetKVArgumentFromInput(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, javax.swing.JComponent owner) {
		super("Set " + stParameterKey.getName() + " from Input");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("SetKVArgumentFromInput" + " stModel" + " stArgument" + " stParameterKey" + " owner");

      input(owner, stParameterKey.getName(), inputValue -> appModel().setArgumentKV(stModel, stArgument, stParameterKey, inputValue));
   }

}