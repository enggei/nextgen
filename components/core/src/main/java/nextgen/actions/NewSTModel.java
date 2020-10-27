package nextgen.actions;

public class NewSTModel extends TransactionAction {


   private final nextgen.st.domain.STTemplate stTemplate;

	public NewSTModel(nextgen.st.domain.STTemplate stTemplate) {
		super("New instance");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().newSTModel(stTemplate);
   }
}