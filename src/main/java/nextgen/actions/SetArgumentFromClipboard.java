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
      stModel.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
            .findAny()
            .ifPresent(stArgument -> {
               final String uuid = stArgument.getUuid();
               stModel.removeArguments(stArgument);
               stArgument.getKeyValues().forEach(nextgen.model.STArgumentKV::delete);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(stModel, uuid);
            });

      final nextgen.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());
      final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);

      if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
   }

}