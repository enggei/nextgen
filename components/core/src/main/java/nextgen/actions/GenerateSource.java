package nextgen.actions;

public class GenerateSource extends TransactionAction {


   private final nextgen.st.model.STModel stModel;

	public GenerateSource(nextgen.st.model.STModel stModel) {
		super("As builder code");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("GenerateSource");
      System.out.println("GenerateSource");
      System.out.println("GenerateSource");
      final java.util.Set<String> imports = new java.util.LinkedHashSet<>();

      final String packageName = appModel().getSourceOutputPackage();
      final String templateName = appModel().getSTTemplate(stModel).getName();
      final String className = appModel().getSTModelName(stModel, templateName);
      final String variableName = nextgen.utils.StringUtil.lowFirst(templateName);

      final nextgen.templates.java.BlockStmt blockStmt = nextgen.templates.JavaPatterns.newBlockStmt();
      final nextgen.templates.java.VariableDeclarationExpression variableDeclarationExpression = nextgen.templates.JavaPatterns
            .newFinalVariableDeclarationExpression(templateName, variableName, appModel().stRenderer.renderGeneratorCode(stModel, imports));
      blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt().setExpression(variableDeclarationExpression));

      final nextgen.templates.java.ClassOrInterfaceDeclaration classOrInterfaceDeclaration = nextgen.templates.JavaPatterns.newClassOrInterfaceDeclaration()
            .setName(className)
            .addMembers(nextgen.templates.JavaPatterns.newMainMethod().setBlockStmt(blockStmt));

      final nextgen.templates.java.CompilationUnit compilationUnit = nextgen.templates.JavaPatterns.newCompilationUnit(packageName, classOrInterfaceDeclaration)
            .setImportDeclaration(imports.stream().map(s -> nextgen.templates.JavaPatterns.newImportDeclaration().setName(s).setIsAsterisk(true)).collect(java.util.stream.Collectors.toList()));

      nextgen.utils.SwingUtil.toClipboard(blockStmt.toString());

      nextgen.st.STGenerator.writeJavaFile(compilationUnit, packageName, className, new java.io.File(appModel().getOutputPath()));
   }
}