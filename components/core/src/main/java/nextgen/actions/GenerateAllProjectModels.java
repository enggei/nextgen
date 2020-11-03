package nextgen.actions;

public class GenerateAllProjectModels extends TransactionAction {


   private final nextgen.st.model.STProject project;

	public GenerateAllProjectModels(nextgen.st.model.STProject project) {
		super("Generate all");
		this.project = project;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("GenerateAllProjectModels");
      System.out.println("GenerateAllProjectModels");
      System.out.println("GenerateAllProjectModels");
      project.getModels().forEach(stModel ->
            stModel.getFiles().forEach(stFile -> {
               final String content = appModel().render(stModel);
               final String packageDeclaration = stFile.getPackageName().getValue();
               final String name = stFile.getName().getValue();
               final String filetype = stFile.getType().getValue();
               final java.io.File root = new java.io.File(stFile.getPath().getValue());
               nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);
            }));
   }
}