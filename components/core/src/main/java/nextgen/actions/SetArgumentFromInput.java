package nextgen.actions;

public class SetArgumentFromInput extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public SetArgumentFromInput(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, javax.swing.JComponent owner) {
		super("Set from Input");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, stParameter.getName(), inputValue -> {
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
         
         final nextgen.st.model.STValue stValue = appModel().db.newSTValue(inputValue);
         final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
         stModel.addArguments(stArgument);
         nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
      });
   }
}