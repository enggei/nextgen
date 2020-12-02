package nextgen.actions;

public class GenerateSource extends nextgen.actions.TransactionAction {
   private final nextgen.model.STModel stModel;

	public GenerateSource(nextgen.model.STModel stModel) {
		super("As builder code");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String packageName = appModel().getSourceOutputPackage();
      final String templateName = stModel.getStTemplate().getName();
      final String className = nextgen.utils.STModelUtil.getSTModelName(stModel, templateName) + "Generator";

      final nextgen.templates.java.BlockStmt blockStmt = nextgen.templates.java.JavaPatterns.newBlockStmt()
            .addStatements(nextgen.templates.java.JavaPatterns.newReturnStmt().setExpression(appModel().stRenderer.renderGeneratorCode(stModel)));

      final nextgen.templates.java.ClassOrInterfaceDeclaration classOrInterfaceDeclaration = nextgen.templates.java.JavaPatterns.newClassOrInterfaceDeclaration()
            .setName(className)
            .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)
            .addMembers(nextgen.templates.java.JavaPatterns.newMethodDeclaration()
                  .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)
                  .addModifiers(nextgen.templates.java.Modifiers.STATIC)
                  .setName("generate")
                  .setType(templateName)
                  .setBlockStmt(blockStmt));

      final nextgen.templates.java.CompilationUnit compilationUnit = nextgen.templates.java.JavaPatterns.newCompilationUnit(packageName, classOrInterfaceDeclaration);
      nextgen.utils.SwingUtil.toClipboard(blockStmt.toString());
      nextgen.st.STGenerator.writeJavaFile(compilationUnit, packageName, className, new java.io.File(nextgen.swing.AppModel.getInstance().getOutputPath()));
   }

}