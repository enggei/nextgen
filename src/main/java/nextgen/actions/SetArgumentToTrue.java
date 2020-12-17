package nextgen.actions;

public class SetArgumentToTrue extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;

	public SetArgumentToTrue(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter) {
		super("Set to true");
		this.stModel = stModel;
		this.stParameter = stParameter;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("SetArgumentToTrue" + " stModel" + " stParameter");

      appModel().setArgument(stModel, stParameter, true);
   }

}