package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class WriteSTGroupAction extends TransactionAction {

   private final STGroupAction action;

	public WriteSTGroupAction(STGroupAction action) {
		super("Generate Source");
		this.action = action;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("WriteSTGroupAction" + " action");

      action.getIncomingActionsSTGroupModel().findAny().ifPresent(stGroupModel -> {
         final String packageName = appModel().getSourceOutputPackage() + "." + stGroupModel.getName().toLowerCase();
         final String imports = appModel().render(action.getImports());

         final nextgen.templates.nextgen.TransactionAction transactionAction = nextgen.templates.nextgen.NextgenST.newTransactionAction()
               .setPackageName(packageName)
               .setName(action.getName())
               .setTitle(action.getName())
               .addFields("owner", "JComponent")
               .setImports(imports == null ? new Object[0] : imports.split("\n"))
               .addStatements(action.getStatements() == null ? new Object[0] : appModel().render(action.getStatements()))
               .addMethods(action.getMethods() == null ? new Object[0] : appModel().render(action.getMethods()));

         final java.io.File file = new java.io.File(nextgen.swing.AppModel.getInstance().getOutputPath());
         nextgen.st.STGenerator.writeJavaFile(transactionAction, packageName, transactionAction.getName().toString(), file);
      });
   }

}