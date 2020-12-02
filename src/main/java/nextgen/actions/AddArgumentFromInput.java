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
      input(owner, stParameter.getName(), inputValue -> {
         final nextgen.model.STValue stValue = appModel().db.newSTValue(inputValue);
         final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
         stModel.addArguments(stArgument);
         nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
      });
   }

}