package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AsBuilderCodes extends nextgen.actions.TransactionAction {

   private final STTemplate stTemplate;
   private final java.util.List<STModel> stModels;

	public AsBuilderCodes(STTemplate stTemplate, java.util.List<STModel> stModels) {
		super("As builder code");
		this.stTemplate = stTemplate;
		this.stModels = stModels;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AsBuilderCodes" + " stTemplate" + " stModels");

      final String packageName = appModel().getSourceOutputPackage();
      final String className = "GenerateAll_" + stTemplate.getName();
      final String type = nextgen.utils.StringUtil.capitalize(stTemplate.getName());
      final nextgen.templates.java.ClassOrInterfaceType returnType = nextgen.templates.java.JavaPatterns.newClassOrInterfaceType("java.util", "List")
            .addTypeArguments(type);

      final nextgen.templates.java.BlockStmt blockStmt = nextgen.templates.java.JavaPatterns.newBlockStmt();
      final nextgen.templates.java.VariableDeclarationExpression listVariable = nextgen.templates.java.JavaPatterns
            .newFinalVariableDeclarationExpression(returnType, "list", "new java.util.ArrayList<>()");

      blockStmt.addStatements(nextgen.templates.java.JavaPatterns.newExpressionStmt()
            .setExpression(listVariable));

      java.util.concurrent.atomic.AtomicInteger variableCount = new java.util.concurrent.atomic.AtomicInteger();
      for (STModel stModel : stModels) {
         final String stModelName = appModel().getSTModelName(stModel, "var_" + variableCount.incrementAndGet());
         final nextgen.templates.java.VariableDeclarationExpression variableDeclarationExpression = nextgen.templates.java.JavaPatterns
               .newFinalVariableDeclarationExpression(type, stModelName, appModel().stRenderer.renderGeneratorCode(stModel));
         blockStmt.addStatements(nextgen.templates.java.JavaPatterns.newExpressionStmt()
               .setExpression(variableDeclarationExpression));
      }

      variableCount = new java.util.concurrent.atomic.AtomicInteger();
      for (STModel stModel : stModels) {
         final String stModelName = appModel().getSTModelName(stModel, "var_" + variableCount.incrementAndGet());
         blockStmt.addStatements(nextgen.templates.java.JavaPatterns.newExpressionStmt()
               .setExpression(nextgen.templates.java.JavaPatterns.newMethodCallExpression()
                     .setScope("list")
                     .setName("add")
                     .addArguments(stModelName)));
      }

      blockStmt.addStatements(nextgen.templates.java.JavaPatterns.newReturnStmt().setExpression("list"));

      final nextgen.templates.java.ClassOrInterfaceDeclaration classOrInterfaceDeclaration = nextgen.templates.java.JavaPatterns.newClassOrInterfaceDeclaration()
            .setName(className)
            .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)
            .addMembers(nextgen.templates.java.JavaPatterns.newMethodDeclaration()
                  .addModifiers(nextgen.templates.java.Modifiers.PUBLIC)
                  .addModifiers(nextgen.templates.java.Modifiers.STATIC)
                  .setName("generate")
                  .setType(returnType)
                  .setBlockStmt(blockStmt));

      final nextgen.templates.java.CompilationUnit compilationUnit = nextgen.templates.java.JavaPatterns.newCompilationUnit(packageName, classOrInterfaceDeclaration);

      compilationUnit.addImportDeclaration(nextgen.templates.java.JavaPatterns
            .newImportDeclaration(nextgen.swing.AppModel.getInstance().getOutputPackage() + "." + nextgen.utils.StringUtil.lowFirst(appModel().getSTGroup(stTemplate).getName()))
            .setIsAsterisk(true));

      toClipboard(blockStmt.toString());
      nextgen.st.STGenerator.writeJavaFile(compilationUnit, packageName, className, new java.io.File(nextgen.swing.AppModel.getInstance().getOutputPath()));
   }

}