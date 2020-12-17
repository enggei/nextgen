package nextgen.actions;

public class SetArgumentFromClipboard extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;

	public SetArgumentFromClipboard(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter) {
		super("Set from Clipboard");
		this.stModel = stModel;
		this.stParameter = stParameter;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("SetArgumentFromClipboard" + " stModel" + " stParameter");

      appModel().setArgument(stModel, stParameter, nextgen.utils.SwingUtil.fromClipboard());
      if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
   }

}