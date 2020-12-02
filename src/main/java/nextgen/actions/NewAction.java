package nextgen.actions;

public class NewAction extends nextgen.actions.TransactionAction {
   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewAction(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Add Action");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "New Action", s ->
      		nextgen.utils.STModelUtil.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
      			final nextgen.model.STGroupAction stGroupAction = appModel().db.newSTGroupAction().setName(name);
      			stGroup.addActions(stGroupAction);
      			nextgen.events.NewSTAction.post(stGroupAction, stGroup);
      		}));
   }

}