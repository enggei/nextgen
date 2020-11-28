package nextgen.actions;

public class GenerateSources extends nextgen.actions.TransactionAction {


   private final nextgen.model.STTemplate stTemplate;
   private final java.util.List<nextgen.model.STModel> stModels;

	public GenerateSources(nextgen.model.STTemplate stTemplate, java.util.List<nextgen.model.STModel> stModels) {
		super("As builder code");
		this.stTemplate = stTemplate;
		this.stModels = stModels;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final java.util.Set<String> imports = new java.util.LinkedHashSet<>();

      final String packageName = appModel().getSourceOutputPackage();
      final String className = "GenerateAll_" + stTemplate.getName();
      final String type = nextgen.utils.StringUtil.capitalize(stTemplate.getName());
      final nextgen.templates.java.ClassOrInterfaceType returnType = nextgen.templates.JavaPatterns.newClassOrInterfaceType("java.util", "List")
            .addTypeArguments(type);

      final nextgen.templates.java.BlockStmt blockStmt = nextgen.templates.JavaPatterns.newBlockStmt();
      final nextgen.templates.java.VariableDeclarationExpression listVariable = nextgen.templates.JavaPatterns
            .newFinalVariableDeclarationExpression(returnType, "list", "new java.util.ArrayList<>()");

      blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()
            .setExpression(listVariable));

      java.util.concurrent.atomic.AtomicInteger variableCount = new java.util.concurrent.atomic.AtomicInteger();
      for (nextgen.model.STModel stModel : stModels) {
         final String stModelName = nextgen.utils.STModelUtil.getSTModelName(stModel, "var_" + variableCount.incrementAndGet());
         final nextgen.templates.java.VariableDeclarationExpression variableDeclarationExpression = nextgen.templates.JavaPatterns
               .newFinalVariableDeclarationExpression(type, stModelName, appModel().stRenderer.renderGeneratorCode(stModel, imports));
         blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()
               .setExpression(variableDeclarationExpression));
      }

      variableCount = new java.util.concurrent.atomic.AtomicInteger();
      for (nextgen.model.STModel stModel : stModels) {
         final String stModelName = nextgen.utils.STModelUtil.getSTModelName(stModel, "var_" + variableCount.incrementAndGet());
         blockStmt.addStatements(nextgen.templates.JavaPatterns.newExpressionStmt()
               .setExpression(nextgen.templates.JavaPatterns.newMethodCallExpression()
                     .setScope("list")
                     .setName("add")
                     .addArguments(stModelName)));
      }

      blockStmt.addStatements(nextgen.templates.JavaPatterns.newReturnStmt().setExpression("list"));

      final nextgen.templates.java.ClassOrInterfaceDeclaration classOrInterfaceDeclaration = nextgen.templates.JavaPatterns.newClassOrInterfaceDeclaration()
            .setName(className)
            .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)
            .addMembers(nextgen.templates.JavaPatterns.newMethodDeclaration()
                  .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)
                  .addModifiers(nextgen.templates.java.Modifiers.STATIC)
                  .setName("generate")
                  .setType(returnType)
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