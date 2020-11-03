package nextgen.actions;

public class EditModels extends TransactionAction {


   private final nextgen.st.domain.STTemplate stTemplate;

	public EditModels(nextgen.st.domain.STTemplate stTemplate) {
		super("Edit");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("EditModels");
      appModel().doLaterInTransaction(transaction1 -> {
         final nextgen.st.STModelGrid stModelGrid = appModel().getWorkspace().getModelGrid(stTemplate);
         appModel().getWorkspace().setSelectedComponent(stModelGrid);
         stModelGrid.requestFocusInWindow();   
      });
   }
}