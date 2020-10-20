package nextgen.actions;

public class NewTemplateChild extends TransactionAction {

   private final nextgen.st.domain.STTemplate stTemplate;
   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewTemplateChild(nextgen.st.domain.STTemplate stTemplate, nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Add Child template");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.getInputFromUser(owner, "Name")
                                   .ifPresent(candidateName -> nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, candidateName)
                                                                                                .ifPresent(name -> appModel().newSTTemplate(candidateName, stTemplate)));
   }
}