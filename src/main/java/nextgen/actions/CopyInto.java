package nextgen.actions;

public class CopyInto extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel thisModel;
   private final nextgen.model.STModel otherModel;

	public CopyInto(nextgen.model.STModel thisModel, nextgen.model.STModel otherModel) {
		super("Copy from " + nextgen.swing.STAppPresentationModel.getSTModelName(otherModel, otherModel.getUuid()));
		this.thisModel = thisModel;
		this.otherModel = otherModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("CopyInto" + " thisModel" + " otherModel");

      appModel().copyInto(thisModel, otherModel);
   }

}