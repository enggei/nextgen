package nextgen.actions;

public class SetArgumentFromSTModel extends nextgen.actions.TransactionAction {
   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final nextgen.model.STModel value;

	public SetArgumentFromSTModel(String name, nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STModel value) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.value = value;
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

            final nextgen.model.STValue stValue = appModel().db.newSTValue(value);
            final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
            stModel.addArguments(stArgument);
            nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }

}