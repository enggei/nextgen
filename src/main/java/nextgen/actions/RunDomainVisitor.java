package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class RunDomainVisitor extends nextgen.actions.TransactionAction {

   private final nextgen.model.DomainVisitor visitor;
   private final JComponent owner;

	public RunDomainVisitor(nextgen.model.DomainVisitor visitor, JComponent owner) {
		super("Run");
		this.visitor = visitor;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("RunDomainVisitor" + " visitor" + " owner");

      try {
         final nextgen.templates.nextgen.TransactionAction source = asSource();
         final String className = source.getPackageName() + "." + source.getName().toString();
         final Class<?> aClass = net.openhft.compiler.CompilerUtils.CACHED_COMPILER.loadFromJava(className, source.toString());
         final nextgen.actions.TransactionAction action = (nextgen.actions.TransactionAction) aClass.getDeclaredConstructor(Domain.class, JComponent.class).newInstance(visitor.getIncomingDomain(), owner);
         action.actionPerformed(actionEvent);
      } catch (Throwable e) {
         throw new RuntimeException(e);
      }
   }

   private nextgen.templates.nextgen.TransactionAction asSource() {

         final java.util.concurrent.atomic.AtomicReference<nextgen.templates.nextgen.TransactionAction> reference = new java.util.concurrent.atomic.AtomicReference<>();

      final String packageName = appModel().getSourceOutputPackage() + "." + visitor.getName().toLowerCase();

      final nextgen.templates.nextgen.DomainVisitorInterface visitorInterface = nextgen.templates.nextgen.NextgenST.newDomainVisitorInterface();

      visitor.getOnDomain().forEach(visitorInterface::addOnDomain);
      visitor.getOnEntity().forEach(visitorInterface::addOnEntity);
      visitor.getOnRelation().forEach(visitorInterface::addOnRelation);
      visitor.getOnComplete().forEach(visitorInterface::addOnComplete);

      final nextgen.templates.nextgen.TransactionAction transactionAction = nextgen.templates.nextgen.NextgenST.newTransactionAction()
            .setPackageName(packageName)
            .setName(visitor.getName())
            .setTitle(visitor.getName())
            .addFields("domain", "nextgen.model.Domain")
            .addFields("owner", "javax.swing.JComponent")
            .addStatements(nextgen.templates.nextgen.NextgenST.newDomainVisitor())
            .addMethods(visitorInterface);

      visitor.getImports().forEach(transactionAction::addImports);

      final java.io.File file = new java.io.File(nextgen.swing.AppModel.getInstance().getOutputPath());
      nextgen.st.STGenerator.writeJavaFile(transactionAction, packageName, transactionAction.getName().toString(), file);

      transactionAction.setName(visitor.getName() + "_" + System.currentTimeMillis());
      reference.set(transactionAction);

      return reference.get();
   }
}