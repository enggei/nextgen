package nextgen.actions;

public class SetArgumentFromSTModelUuid extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final String uuid;

	public SetArgumentFromSTModelUuid(String name, nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, String uuid) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.uuid = uuid;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      stModel.getArgumentsSorted()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
            .findAny()
            .ifPresent(stArgument -> {
               final String uuid = stArgument.getUuid();
               stModel.removeArguments(stArgument);
               stArgument.getKeyValues().forEach(nextgen.model.STArgumentKV::delete);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(stModel, uuid);
            });

      final nextgen.model.STValue stValue = appModel().db.newSTValue(appModel().db.cloneSTModel(uuid));
      final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }

}