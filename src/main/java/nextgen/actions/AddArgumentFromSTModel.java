package nextgen.actions;

public class AddArgumentFromSTModel extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.model.STParameter stParameter;
   private final nextgen.st.model.STModel value;

	public AddArgumentFromSTModel(String name, nextgen.st.model.STModel stModel, nextgen.st.model.STParameter stParameter, nextgen.st.model.STModel value) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.value = value;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(appModel().db.cloneSTModel(value.getUuid()));
      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }

}