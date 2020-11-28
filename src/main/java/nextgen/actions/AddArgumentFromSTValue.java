package nextgen.actions;

public class AddArgumentFromSTValue extends nextgen.actions.TransactionAction {


   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final nextgen.model.STValue stValue;

	public AddArgumentFromSTValue(String name, nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STValue stValue) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.stValue = stValue;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }

}