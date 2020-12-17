package nextgen.actions;

public class SetArgumentFromSTModel extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final nextgen.model.STModel value;

	public SetArgumentFromSTModel(String name, nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STModel value) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.value = value;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("SetArgumentFromSTModel" + " stModel" + " stParameter" + " value");

      appModel().setArgument(stModel, stParameter, value);
   }

}