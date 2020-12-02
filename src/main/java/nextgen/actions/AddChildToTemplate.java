package nextgen.actions;

public class AddChildToTemplate extends nextgen.actions.TransactionAction {
   private final nextgen.model.STTemplate stTemplate;
   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public AddChildToTemplate(nextgen.model.STTemplate stTemplate, nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Add Child template");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Name", s -> nextgen.utils.STModelUtil.isValidTemplateName(owner, stGroup, s)
      		.ifPresent(name -> {
      			final nextgen.model.STTemplate newTemplate = appModel().db.newSTTemplate().setName(name).setText("");
      			stTemplate.addChildren(newTemplate);
      			nextgen.events.NewSTTemplateChild.post(newTemplate, stTemplate);
      		}));
   }

}