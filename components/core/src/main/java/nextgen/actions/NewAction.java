package nextgen.actions;

public class NewAction extends TransactionAction {


   private final nextgen.st.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewAction(nextgen.st.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Add Action");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "New Action", s ->
      		nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
      			final nextgen.st.model.STGroupAction stGroupAction = appModel().db.newSTGroupAction().setName(s);
      			stGroup.addActions(stGroupAction);
      			nextgen.events.NewSTAction.post(stGroupAction, stGroup);
      		}));
   }

}