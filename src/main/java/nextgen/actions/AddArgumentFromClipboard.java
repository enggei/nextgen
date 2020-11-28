package nextgen.actions;

public class AddArgumentFromClipboard extends TransactionAction {


   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;

	public AddArgumentFromClipboard(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter) {
		super("Add from Clipboard");
		this.stModel = stModel;
		this.stParameter = stParameter;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());
      final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }

}