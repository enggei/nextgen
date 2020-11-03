package nextgen.actions;

public class DeleteSTTemplate extends TransactionAction {


   private final nextgen.st.domain.STTemplate stTemplate;
   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public DeleteSTTemplate(nextgen.st.domain.STTemplate stTemplate, nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Delete");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("DeleteSTTemplate");
      System.out.println("DeleteSTTemplate");
      System.out.println("DeleteSTTemplate");
      confirm(owner, "Delete", unused -> {
         stGroup.removeTemplates(stTemplate);
         nextgen.events.STTemplateDeleted.post(stTemplate.getUuid());
      });
   }
}