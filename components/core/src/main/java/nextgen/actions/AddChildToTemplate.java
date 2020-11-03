package nextgen.actions;

public class AddChildToTemplate extends TransactionAction {


   private final nextgen.st.domain.STTemplate stTemplate;
   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public AddChildToTemplate(nextgen.st.domain.STTemplate stTemplate, nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Add Child template");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Name", s -> nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s)
            .ifPresent(name -> {
               final nextgen.st.domain.STTemplate newTemplate = nextgen.st.domain.STJsonFactory.newSTTemplate().setName(name).setText("");
               stTemplate.addChildren(newTemplate);
               nextgen.events.NewSTTemplateChild.post(newTemplate, stTemplate);
            }));
   }
}