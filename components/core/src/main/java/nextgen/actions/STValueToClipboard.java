package nextgen.actions;

public class STValueToClipboard extends TransactionAction {

   private final nextgen.st.model.STValue stValue;

	public STValueToClipboard(nextgen.st.model.STValue stValue) {
		super("To Clipboard");
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().doLaterInTransaction(t -> nextgen.utils.SwingUtil.toClipboard(appModel().render(stValue)));
   }
}