package nextgen.actions;

public class NewEnum extends TransactionAction {

   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewEnum(nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Enum");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.getInputFromUser(owner, "Name").ifPresent(name ->
      				nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, name).ifPresent(s -> {
      					appModel().addEnum(stGroup, name);
      				}));
   }
}