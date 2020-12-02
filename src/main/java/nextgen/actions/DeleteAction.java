package nextgen.actions;

public class DeleteAction extends nextgen.actions.TransactionAction {
   private final nextgen.model.STGroupAction stAction;
   private final javax.swing.JComponent owner;
   private final nextgen.model.STGroupModel stGroup;

	public DeleteAction(nextgen.model.STGroupAction stAction, javax.swing.JComponent owner, nextgen.model.STGroupModel stGroup) {
		super("Delete");
		this.stAction = stAction;
		this.owner = owner;
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Delete", unused -> {
      		stGroup.removeActions(stAction);
      		nextgen.events.STGroupActionDeleted.post(stAction.getUuid());
      	});
   }

}