package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AsBuilderCode extends nextgen.actions.TransactionAction {

   private final STModel stModel;

	public AsBuilderCode(STModel stModel) {
		super("As builder code");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AsBuilderCode" + " stModel");

      final String packageName = appModel().getSourceOutputPackage();
      final String templateName = stModel.getStTemplate().getName();
      final String className = appModel().getSTModelName(stModel, templateName) + "Generator";

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

      compilationUnit.addImportDeclaration(nextgen.templates.java.JavaPatterns
            .newImportDeclaration(nextgen.swing.AppModel.getInstance().getOutputPackage() + "." + nextgen.utils.StringUtil.lowFirst(appModel().getSTGroup(stModel).getName()))
            .setIsAsterisk(true));

      toClipboard(blockStmt.toString());
      nextgen.st.STGenerator.writeJavaFile(compilationUnit, packageName, className, new java.io.File(nextgen.swing.AppModel.getInstance().getOutputPath()));
   }

}