package nextgen.actions;

public class SetArgumentFromSTTemplate extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final nextgen.model.STTemplate stTemplate;

	public SetArgumentFromSTTemplate(String name, nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, nextgen.model.STTemplate stTemplate) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.stTemplate = stTemplate;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("SetArgumentFromSTTemplate" + " stModel" + " stParameter" + " stTemplate");

      appModel().setArgument(stModel, stParameter, stTemplate);
   }

}