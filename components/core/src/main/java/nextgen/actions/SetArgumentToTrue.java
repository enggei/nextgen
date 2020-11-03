package nextgen.actions;

public class SetArgumentToTrue extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;

	public SetArgumentToTrue(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter) {
		super("Set to true");
		this.stModel = stModel;
		this.stParameter = stParameter;
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
               nextgen.events.STArgumentDeleted.post(stModel, uuid);
            });

      final nextgen.st.model.STValue stValue = appModel().db.newSTValue("true");
      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }
}