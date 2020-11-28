package nextgen.actions;

public class STValueToClipboard extends nextgen.actions.TransactionAction {


   private final nextgen.model.STValue stValue;

	public STValueToClipboard(nextgen.model.STValue stValue) {
		super("To Clipboard");
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.toClipboard(appModel().render(stValue));
   }

}