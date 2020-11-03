package nextgen.actions;

public class CopyModel extends TransactionAction {


   private final nextgen.st.model.STModel stModel;

	public CopyModel(nextgen.st.model.STModel stModel) {
		super("Copy Model");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("CopyModel");
      System.out.println("CopyModel");
      System.out.println("CopyModel");
      toClipboard("stmodel-" + stModel.getUuid());
   }
}