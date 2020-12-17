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
   	log.info("AddArgumentFromSTValue" + " stModel" + " stParameter" + " stValue");

      appModel().addArgument(stModel, stParameter, stValue);
   }

}