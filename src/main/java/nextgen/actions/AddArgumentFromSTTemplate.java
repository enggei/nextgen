package nextgen.actions;

public class AddArgumentFromSTTemplate extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final nextgen.model.STTemplate stTemplate;

	public AddArgumentFromSTTemplate(String name, nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STTemplate stTemplate) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.stTemplate = stTemplate;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.model.STModel value = appModel().db.newSTModel().setStTemplate(stTemplate);

      final nextgen.model.STValue stValue = appModel().db.newSTValue(value);
      final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }

}