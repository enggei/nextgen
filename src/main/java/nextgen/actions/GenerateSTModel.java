package nextgen.actions;

public class GenerateSTModel extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;

	public GenerateSTModel(nextgen.model.STModel stModel) {
		super("Generate");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("GenerateSTModel" + " stModel");

      appModel().generateSTModel(stModel);
   }

}