package nextgen.actions;

public class NewSTTemplate extends nextgen.actions.TransactionAction {


   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewSTTemplate(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Template");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Name", s -> nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
      	final nextgen.model.STTemplate stTemplate = appModel().db.newSTTemplate().setName(name).setText("");
      	stGroup.addTemplates(stTemplate);
      	nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);
      }));
   }

}