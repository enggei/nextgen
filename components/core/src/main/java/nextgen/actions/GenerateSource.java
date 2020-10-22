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

      final String packageName = "tmp";
      final String className = appModel().getSTModelName(stModel, "Tmp");
      final nextgen.templates.java.MethodCallExpression expression = appModel().stRenderer.renderGeneratorCode(stModel, imports);

      nextgen.st.STGenerator.writeJavaFile(nextgen.templates.JavaPatterns.newCompilationUnit()
            .setPackageDeclaration(nextgen.templates.JavaPatterns.newPackageDeclaration(packageName))
            .setImportDeclaration(imports.stream().map(s ->
                  nextgen.templates.JavaPatterns.newImportDeclaration().setName(s).setIsAsterisk(true)).collect(java.util.stream.Collectors.toList()))
            .addTypes(nextgen.templates.JavaPatterns.newClassOrInterfaceDeclaration()
                  .setName(className)
                  .addMembers(nextgen.templates.JavaPatterns.newMethodDeclaration()
                        .addModifiers("public")
                        .addModifiers("static")
                        .setName("main")
                        .addParameters(nextgen.templates.JavaPatterns.newParameter()
                              .setType(nextgen.templates.JavaPatterns.newClassOrInterfaceType()
                                    .addNames("String")
                                    .setIsArrayType(true))
                              .setName("args"))
                        .setBlockStmt(nextgen.templates.JavaPatterns.newBlockStmt()
                              .addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()
                                    .setExpression(expression))))), packageName, className, new java.io.File("./components/core/src/main/java"));
   }
}