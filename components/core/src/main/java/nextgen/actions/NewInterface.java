package nextgen.actions;

public class NewInterface extends TransactionAction {

   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewInterface(nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Interface");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.getInputFromUser(owner, "Name").ifPresent(name ->
      				nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> {
      					appModel().addInterface(stGroup, name);
      				}));
   }
}