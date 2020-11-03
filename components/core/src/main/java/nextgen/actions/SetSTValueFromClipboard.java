package nextgen.actions;

public class SetSTValueFromClipboard extends TransactionAction {


   private final nextgen.st.model.STValue stValue;

	public SetSTValueFromClipboard(nextgen.st.model.STValue stValue) {
		super("Set from Clipboard");
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("SetSTValueFromClipboard");
      System.out.println("SetSTValueFromClipboard");
      System.out.println("SetSTValueFromClipboard");
      stValue.removeStModel();
      stValue.setValue(nextgen.utils.SwingUtil.fromClipboard());
      stValue.setType(nextgen.st.model.STValueType.PRIMITIVE);
      nextgen.events.STValueChanged.post(stValue);
   }
}