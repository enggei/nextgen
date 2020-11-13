package nextgen.actions;

public class SetArgumentFromSTValue extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.model.STParameter stParameter;
   private final nextgen.st.model.STValue stValue;

	public SetArgumentFromSTValue(String name, nextgen.st.model.STModel stModel, nextgen.st.model.STParameter stParameter, nextgen.st.model.STValue stValue) {
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
               stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(stModel, uuid);
            });

      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);

      if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
   }

}