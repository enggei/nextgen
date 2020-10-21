package nextgen.actions;

public class EditSTModel extends TransactionAction {

   private final nextgen.st.model.STModel stModel;

	public EditSTModel(nextgen.st.model.STModel stModel) {
		super("Edit");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      javax.swing.SwingUtilities.invokeLater(() -> appModel().doInTransaction(t -> appModel().getWorkspace().setSelectedComponent(appModel().getModelEditor(stModel))));
   }
}