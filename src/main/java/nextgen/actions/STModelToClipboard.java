package nextgen.actions;

public class STModelToClipboard extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;

	public STModelToClipboard(nextgen.model.STModel stModel) {
		super("T-CP");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("STModelToClipboard" + " stModel");

      toClipboard(appModel().render(stModel));
   }

}