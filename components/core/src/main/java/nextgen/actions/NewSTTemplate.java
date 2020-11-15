package nextgen.actions;

public class NewSTTemplate extends TransactionAction {


   private final nextgen.st.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewSTTemplate(nextgen.st.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Template");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Name", s -> nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
      	final nextgen.st.model.STTemplate stTemplate = appModel().db.newSTTemplate().setName(name).setText("");
      	stGroup.addTemplates(stTemplate);
      	nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);
      }));
   }

}