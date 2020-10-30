package nextgen.actions;

public class AddArgumentFromSTValue extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final nextgen.st.model.STValue value;

	public AddArgumentFromSTValue(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue value) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.value = value;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, value);
      stModel.addArguments(stArgument);
      nextgen.events.STModelChanged.post(stModel);
   }
}