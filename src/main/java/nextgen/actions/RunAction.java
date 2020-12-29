package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class RunAction extends TransactionAction {

   private final STGroupAction action;
   private final JComponent owner;

	public RunAction(STGroupAction action, JComponent owner) {
		super("Run");
		this.action = action;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("RunAction" + " action" + " owner");

      try {
         final nextgen.templates.nextgen.TransactionAction source = asSource();
         final String className = source.getPackageName() + "." + source.getName().toString();
         final Class<?> aClass = net.openhft.compiler.CompilerUtils.CACHED_COMPILER.loadFromJava(className, source.toString());
         final nextgen.actions.TransactionAction action = (nextgen.actions.TransactionAction) aClass.getDeclaredConstructor(JComponent.class).newInstance(owner);
         action.actionPerformed(actionEvent);
      } catch (Throwable e) {
         throw new RuntimeException(e);
      }
   }

   private nextgen.templates.nextgen.TransactionAction asSource() {

      final java.util.concurrent.atomic.AtomicReference<nextgen.templates.nextgen.TransactionAction> reference = new java.util.concurrent.atomic.AtomicReference<>();

      action.getIncomingActionsSTGroupModel().findAny().ifPresent(stGroupModel -> {
         final String packageName = appModel().getSourceOutputPackage() + "." + stGroupModel.getName().toLowerCase();
         final String imports = appModel().render(action.getImports());

         final nextgen.templates.nextgen.TransactionAction transactionAction = nextgen.templates.nextgen.NextgenST.newTransactionAction()
               .setPackageName(packageName)
               .setName(action.getName())
               .setTitle(action.getName())
               .addFields("owner", "JComponent")
               .setImports(imports == null ? new Object[0] : imports.split("\n"))
               .addStatements(appModel().render(action.getStatements()))
               .addMethods(appModel().render(action.getMethods()));

         final java.io.File file = new java.io.File(nextgen.swing.AppModel.getInstance().getOutputPath());
         nextgen.st.STGenerator.writeJavaFile(transactionAction, packageName, transactionAction.getName().toString(), file);

         transactionAction.setName(action.getName() + "_" + System.currentTimeMillis());
         reference.set(transactionAction);
      });

      return reference.get();
   }
}