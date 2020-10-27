package nextgen.actions;

public class AddArgumentFromInput extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public AddArgumentFromInput(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, javax.swing.JComponent owner) {
		super("Add from Input");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, stParameter.getName(), inputValue -> {
         final nextgen.st.model.STValue stValue = appModel().db.newSTValue(inputValue);
         final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
         stModel.addArguments(stArgument);
         nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
      });
   }
}