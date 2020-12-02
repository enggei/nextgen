package nextgen.actions;

public class SetArgumentFromInput extends nextgen.actions.TransactionAction {
   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public SetArgumentFromInput(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, javax.swing.JComponent owner) {
		super("Set from Input");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, stParameter.getName(), inputValue -> {
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
         
         final nextgen.model.STValue stValue = appModel().db.newSTValue(inputValue);
         final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
         stModel.addArguments(stArgument);
         nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
         if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
      });
   }

}