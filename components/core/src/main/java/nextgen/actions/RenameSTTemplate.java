package nextgen.actions;

public class RenameSTTemplate extends TransactionAction {

   private final nextgen.st.domain.STTemplate stTemplate;
   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public RenameSTTemplate(nextgen.st.domain.STTemplate stTemplate, nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Rename");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.getInputFromUser(owner, "Name").ifPresent(name ->
                  nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> appModel().setName(stTemplate, name)));
   }
}