package nextgen.actions;

public class AddFileSink extends TransactionAction {


   private final nextgen.st.model.STModel stModel;

	public AddFileSink(nextgen.st.model.STModel stModel) {
		super("Add File Sink");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String name = appModel().getSTModelName(stModel, "");
      final String packageName = appModel().getSTModelPackage(stModel, "");
      final nextgen.st.model.STFile stFile = appModel().newSTFile(name, "java", "", packageName);
      stModel.addFiles(stFile);
      nextgen.events.NewFileSink.post(stModel, stFile);
   }

}