package nextgen.actions;

public class SetArgumentFromSTValue extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final nextgen.model.STValue stValue;

	public SetArgumentFromSTValue(String name, nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STValue stValue) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.stValue = stValue;
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

      final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);

      if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
   }

}