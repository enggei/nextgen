package nextgen.actions;

public class GenerateSource extends TransactionAction {


   private final nextgen.st.model.STModel stModel;

	public GenerateSource(nextgen.st.model.STModel stModel) {
		super("As builder code");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final java.util.Set<String> imports = new java.util.LinkedHashSet<>();

      final String packageName = appModel().getSourceOutputPackage();
      final String templateName = appModel().getSTTemplate(stModel).getName();
      final String className = nextgen.utils.STModelUtil.getSTModelName(stModel, templateName) + "Generator";

      final nextgen.templates.java.BlockStmt blockStmt = nextgen.templates.JavaPatterns.newBlockStmt()
            .addStatements(nextgen.templates.JavaPatterns.newReturnStmt().setExpression(appModel().stRenderer.renderGeneratorCode(stModel, imports)));

      final nextgen.templates.java.ClassOrInterfaceDeclaration classOrInterfaceDeclaration = nextgen.templates.JavaPatterns.newClassOrInterfaceDeclaration()
            .setName(className)
            .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)
            .addMembers(nextgen.templates.JavaPatterns.newMethodDeclaration()
                  .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)
                  .addModifiers(nextgen.templates.java.Modifiers.STATIC)
                  .setName("generate")
                  .setType(templateName)
                  .setBlockStmt(blockStmt));

      final nextgen.templates.java.CompilationUnit compilationUnit = nextgen.templates.JavaPatterns.newCompilationUnit(packageName, classOrInterfaceDeclaration)
            .setImportDeclaration(imports.stream()
                  .map(s -> nextgen.templates.JavaPatterns.newImportDeclaration()
                        .setName(s)
                        .setIsAsterisk(true))
                  .collect(java.util.stream.Collectors.toList()));

      nextgen.utils.SwingUtil.toClipboard(blockStmt.toString());

      nextgen.st.STGenerator.writeJavaFile(compilationUnit, packageName, className, new java.io.File(appModel().getOutputPath()));
   }

}