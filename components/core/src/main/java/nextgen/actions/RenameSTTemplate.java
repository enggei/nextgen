package nextgen.actions;

public class RenameSTTemplate extends TransactionAction {


   private final nextgen.st.model.STTemplate stTemplate;
   private final nextgen.st.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public RenameSTTemplate(nextgen.st.model.STTemplate stTemplate, nextgen.st.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Rename");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Name", stTemplate.getName(), s -> nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
         stTemplate.setName(name);
         nextgen.events.STTemplateNameChanged.post(stGroup, stTemplate);
      }));
   }

}