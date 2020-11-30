package nextgen.actions;

public class WriteSTFile extends nextgen.actions.TransactionAction {


   private final nextgen.model.STFile stFile;

	public WriteSTFile(nextgen.model.STFile stFile) {
		super("Generate");
		this.stFile = stFile;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      stFile.getIncomingFilesSTModel().forEach(stModel -> {
         final String content = appModel().render(stModel);
         final String packageDeclaration = stFile.getPackageName().getValue();
         final String name = stFile.getName().getValue();
         final String filetype = stFile.getType().getValue();
         final java.io.File root = new java.io.File(stFile.getPath().getValue());
         nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);
      });
   }

}