package nextgen.actions;

public class AddFileSinkToGroup extends TransactionAction {


   private final nextgen.st.model.STGroupModel stGroup;

	public AddFileSinkToGroup(nextgen.st.model.STGroupModel stGroup) {
		super("Add File");
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.st.model.STGroupFile stGroupFile = appModel().db.newSTGroupFile()
            .setUuid(java.util.UUID.randomUUID().toString());
      stGroup.addFiles(stGroupFile);
      nextgen.events.NewSTGroupFile.post(stGroup, stGroupFile);
   }

}