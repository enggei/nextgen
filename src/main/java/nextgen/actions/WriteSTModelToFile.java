package nextgen.actions;

public class WriteSTModelToFile extends nextgen.actions.TransactionAction {


   private final nextgen.model.STModel stModel;

	public WriteSTModelToFile(nextgen.model.STModel stModel) {
		super("Generate");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      stModel.getFiles().forEach(stFile -> {
         final String content = appModel().render(stModel);
         final String packageDeclaration = stFile.getPackageName().getValue();
         final String name = stFile.getName().getValue();
         final String filetype = stFile.getType().getValue();
         final java.io.File root = new java.io.File(stFile.getPath().getValue());
         nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);
      });
   }

}