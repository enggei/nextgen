package nextgen.actions;

public class RenameSTTemplate extends nextgen.actions.TransactionAction {


   private final nextgen.model.STTemplate stTemplate;
   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public RenameSTTemplate(nextgen.model.STTemplate stTemplate, nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Rename");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Name", stTemplate.getName(), s -> nextgen.utils.STModelUtil.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
         stTemplate.setName(name);
         nextgen.events.STTemplateNameChanged.post(stGroup, stTemplate);
      }));
   }

}