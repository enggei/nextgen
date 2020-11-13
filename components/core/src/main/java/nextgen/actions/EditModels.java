package nextgen.actions;

public class EditModels extends TransactionAction {


   private final nextgen.st.model.STTemplate stTemplate;

	public EditModels(nextgen.st.model.STTemplate stTemplate) {
		super("Edit");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().doLaterInTransaction(transaction1 -> {
         final nextgen.st.STModelGrid stModelGrid = appModel().getWorkspace().getModelGrid(stTemplate);
         appModel().getWorkspace().setSelectedComponent(stModelGrid);
         stModelGrid.requestFocusInWindow();   
      });
   }

}