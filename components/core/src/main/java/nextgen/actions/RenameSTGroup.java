package nextgen.actions;

public class RenameSTGroup extends TransactionAction {

   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public RenameSTGroup(nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Rename");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.getInputFromUser(owner, "Name").ifPresent(name ->
      				nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> {
      					appModel().setName(stGroup, name);
      				}));
   }
}