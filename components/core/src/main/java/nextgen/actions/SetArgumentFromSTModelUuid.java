package nextgen.actions;

public class SetArgumentFromSTModelUuid extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final String uuid;

	public SetArgumentFromSTModelUuid(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, String uuid) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.uuid = uuid;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      stModel.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
            .findAny()
            .ifPresent(stArgument -> {
               final String uuid = stArgument.getUuid();
               stModel.removeArguments(stArgument);
               stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(stModel, uuid);;
            });

      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(appModel().db.cloneSTModel(uuid));
      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }
}