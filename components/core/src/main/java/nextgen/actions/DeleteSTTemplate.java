package nextgen.actions;

public class DeleteSTTemplate extends TransactionAction {


   private final nextgen.st.model.STTemplate stTemplate;
   private final nextgen.st.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public DeleteSTTemplate(nextgen.st.model.STTemplate stTemplate, nextgen.st.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Delete");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
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