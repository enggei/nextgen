package nextgen.actions;

public class WriteAllSTModelsToFile extends nextgen.actions.TransactionAction {


   private final java.util.List<nextgen.model.STModel> stModels;

	public WriteAllSTModelsToFile(java.util.List<nextgen.model.STModel> stModels) {
		super("Generate All");
		this.stModels = stModels;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      for (nextgen.model.STModel stModel : stModels) {
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

}