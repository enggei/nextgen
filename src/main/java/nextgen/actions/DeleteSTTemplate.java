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
      confirm(owner, "Delete", unused -> {
      	final String uuid = stTemplate.getUuid();
      	stTemplate.delete();
      	nextgen.events.STTemplateDeleted.post(uuid);
      });
   }

}