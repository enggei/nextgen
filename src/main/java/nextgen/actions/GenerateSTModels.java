package nextgen.actions;

public class GenerateSTModels extends nextgen.actions.TransactionAction {

   private final java.util.List<nextgen.model.STModel> stModels;

	public GenerateSTModels(java.util.List<nextgen.model.STModel> stModels) {
		super("Generate All");
		this.stModels = stModels;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("GenerateSTModels" + " stModels");

      stModels.forEach(stModel -> appModel().generateSTModel(stModel));
   }

}