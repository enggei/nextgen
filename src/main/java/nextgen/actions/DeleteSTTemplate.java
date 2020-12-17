package nextgen.actions;

public class DeleteSTTemplate extends nextgen.actions.TransactionAction {

   private final nextgen.model.STTemplate stTemplate;
   private final javax.swing.JComponent owner;

	public DeleteSTTemplate(nextgen.model.STTemplate stTemplate, javax.swing.JComponent owner) {
		super("Delete");
		this.stTemplate = stTemplate;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("DeleteSTTemplate" + " stTemplate" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stTemplate));
   }

}