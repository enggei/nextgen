package nextgen.actions;

public class EditSTModel extends TransactionAction {


   private final nextgen.st.model.STModel stModel;

	public EditSTModel(nextgen.st.model.STModel stModel) {
		super("Edit");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("EditSTModel");
      System.out.println("EditSTModel");
      System.out.println("EditSTModel");
      appModel().doLaterInTransaction(transaction1 -> appModel().getWorkspace().setSelectedComponent(appModel().getModelEditor(stModel)));
   }
}