package nextgen.actions;

public class SetSTValueFromClipboard extends TransactionAction {

   private final nextgen.st.model.STValue stValue;

	public SetSTValueFromClipboard(nextgen.st.model.STValue stValue) {
		super("Set from Clipboard");
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().set(stValue, nextgen.utils.SwingUtil.fromClipboard());
   }
}