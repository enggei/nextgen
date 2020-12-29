package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class WriteSTGroupAction extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupAction action;

	public WriteSTGroupAction(nextgen.model.STGroupAction action) {
		super("Generate Source");
		this.action = action;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("WriteSTGroupAction" + " action");

      action.getIncomingActionsSTGroupModel().findAny().ifPresent(stGroupModel -> {
         final String packageName = appModel().getSourceOutputPackage() + "." + stGroupModel.getName().toLowerCase();
         final String imports = appModel().render(action.getImports());

         final nextgen.templates.nextgen.TransactionAction transactionAction = nextgen.templates.nextgen.NextgenST.newTransactionAction()
               .setPackageName(packageName)
               .setName(action.getName())
               .setTitle(action.getName())
               .addFields("owner", "javax.swing.JComponent")
               .setImports(imports == null ? new Object[0] : imports.split("\n"))
               .addStatements(action.getStatements() == null ? new Object[0] : appModel().render(action.getStatements()))
               .addMethods(action.getMethods() == null ? new Object[0] : appModel().render(action.getMethods()));

         final java.io.File file = new java.io.File(nextgen.swing.AppModel.getInstance().getOutputPath());
         nextgen.st.STGenerator.writeJavaFile(transactionAction, packageName, transactionAction.getName().toString(), file);
      });
   }

}