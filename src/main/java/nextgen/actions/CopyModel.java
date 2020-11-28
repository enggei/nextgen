package nextgen.actions;

public class CopyModel extends TransactionAction {


   private final nextgen.model.STModel stModel;

	public CopyModel(nextgen.model.STModel stModel) {
		super("Copy Model");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      toClipboard("stmodel-" + stModel.getUuid());
   }

}