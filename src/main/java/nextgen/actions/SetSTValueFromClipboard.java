package nextgen.actions;

public class SetSTValueFromClipboard extends nextgen.actions.TransactionAction {

   private final nextgen.model.STValue stValue;

	public SetSTValueFromClipboard(nextgen.model.STValue stValue) {
		super("Set from Clipboard");
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("SetSTValueFromClipboard" + " stValue");

      appModel().setValue(stValue, fromClipboard());
   }

}