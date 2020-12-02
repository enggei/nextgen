package nextgen.actions;

public class ShowSTModelInCanvas extends nextgen.actions.TransactionAction {
   private final nextgen.model.STModel stModel;

	public ShowSTModelInCanvas(nextgen.model.STModel stModel) {
		super("Open in canvas");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.events.ShowSTModelInCanvas.post(stModel);
   }

}