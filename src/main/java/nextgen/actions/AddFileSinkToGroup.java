package nextgen.actions;

public class AddFileSinkToGroup extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupModel stGroup;

	public AddFileSinkToGroup(nextgen.model.STGroupModel stGroup) {
		super("Add File");
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("AddFileSinkToGroup" + " stGroup");

      appModel().addGroupFileTo(stGroup);
   }

}