package nextgen.actions;

public class GenerateSources extends TransactionAction {


   private final nextgen.st.domain.STTemplate stTemplate;
   private final java.util.List<nextgen.st.model.STModel> stModels;

	public GenerateSources(nextgen.st.domain.STTemplate stTemplate, java.util.List<nextgen.st.model.STModel> stModels) {
		super("As builder code");
		this.stTemplate = stTemplate;
		this.stModels = stModels;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("GenerateSources");
      final java.util.Set<String> imports = new java.util.LinkedHashSet<>();

      final String packageName = appModel().getSourceOutputPackage();
      final String className = "GenerateAll_" + stTemplate.getName();
      final String type = nextgen.utils.StringUtil.capitalize(stTemplate.getName());

      final nextgen.templates.java.BlockStmt blockStmt = nextgen.templates.JavaPatterns.newBlockStmt();

      java.util.concurrent.atomic.AtomicInteger variableCount = new java.util.concurrent.atomic.AtomicInteger();
      for (nextgen.st.model.STModel stModel : stModels) {
         final String stModelName = appModel().getSTModelName(stModel, "var_" + variableCount.incrementAndGet());
         final nextgen.templates.java.VariableDeclarationExpression variableDeclarationExpression = nextgen.templates.JavaPatterns
               .newFinalVariableDeclarationExpression(type, stModelName, appModel().stRenderer.renderGeneratorCode(stModel, imports));
         blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()
               .setExpression(variableDeclarationExpression));
      }

      // list variable
      final nextgen.templates.java.VariableDeclarationExpression listVariable = nextgen.templates.JavaPatterns
            .newFinalVariableDeclarationExpression(nextgen.templates.JavaPatterns.newClassOrInterfaceType("java.util", "List")
                  .addTypeArguments(type), "list", "new java.util.ArrayList<>()");
      blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()
            .setExpression(listVariable));

      variableCount = new java.util.concurrent.atomic.AtomicInteger();
      for (nextgen.st.model.STModel stModel : stModels) {
         final String stModelName = appModel().getSTModelName(stModel, "var_" + variableCount.incrementAndGet());
         blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()
               .setExpression(nextgen.templates.JavaPatterns.newMethodCallExpression()
                     .setScope("list")
                     .setName("add")
                     .addArguments(stModelName)));
      }

      final nextgen.templates.java.ClassOrInterfaceDeclaration classOrInterfaceDeclaration = nextgen.templates.JavaPatterns.newClassOrInterfaceDeclaration()
            .setName(className)
            .addMembers(nextgen.templates.JavaPatterns.newMainMethod()
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