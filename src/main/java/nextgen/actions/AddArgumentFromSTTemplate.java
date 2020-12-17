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
   	log.info("AddArgumentFromSTTemplate" + " stModel" + " stParameter" + " stTemplate");

      appModel().addArgument(stModel, stParameter, stTemplate);
   }

}