package nextgen.actions;

public class AddArgumentFromInput extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public AddArgumentFromInput(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, javax.swing.JComponent owner) {
		super("Add from Input");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("AddArgumentFromInput" + " stModel" + " stParameter" + " owner");

      input(owner, stParameter.getName(), inputValue -> appModel().addArgument(stModel, stParameter, inputValue));
   }

}