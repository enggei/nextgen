package nextgen.actions;

public class WriteAllSTModelsToFile extends nextgen.actions.TransactionAction {


   private final java.util.List<nextgen.model.STModel> stModels;

	public WriteAllSTModelsToFile(java.util.List<nextgen.model.STModel> stModels) {
		super("Generate All");
		this.stModels = stModels;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      for (nextgen.model.STModel stModel : stModels) new WriteSTModelToFile(stModel).actionPerformed(actionEvent, transaction);
   }

}