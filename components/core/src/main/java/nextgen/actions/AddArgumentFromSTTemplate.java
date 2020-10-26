package nextgen.actions;

public class AddArgumentFromSTTemplate extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final nextgen.st.domain.STTemplate stTemplate;

	public AddArgumentFromSTTemplate(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.domain.STTemplate stTemplate) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.stTemplate = stTemplate;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.st.model.STModel value = appModel().newSTModel(stTemplate);

      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);
      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);

   }
}