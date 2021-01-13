package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;

import org.stringtemplate.v4.*;

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
         final nextgen.model.STModel source = asSource();
         final String className = nextgen.swing.STAppPresentationModel.getSTModelPackage(source) + "." + nextgen.swing.STAppPresentationModel.getSTModelName(source);
         final Class<?> aClass = net.openhft.compiler.CompilerUtils.CACHED_COMPILER.loadFromJava(className, appModel().render(source));
         final nextgen.actions.TransactionAction action = (nextgen.actions.TransactionAction) aClass.getDeclaredConstructor(Domain.class, JComponent.class).newInstance(visitor.getIncomingVisitorsDomain().findFirst().get(), owner);
         action.actionPerformed(actionEvent);
      } catch (Throwable e) {
         throw new RuntimeException(e);
      }
   }

   private nextgen.model.STModel asSource() {
   	
   	final String packageName = appModel().getSourceOutputPackage() + "." + visitor.getName().toLowerCase();
   	
   	nextgen.model.STTemplate domainVisitor = appModel().db.findSTTemplateByUuid("95c75764-2aff-4b56-b1db-fa2ffac11872");
   	final nextgen.model.STModel visitorInterface = appModel().newSTModel(domainVisitor);
   	
   	appModel().addArgument(visitorInterface, "onDomain", visitor.getOnDomain());
   	appModel().addArgument(visitorInterface, "onEntity", visitor.getOnEntity());
   	appModel().addArgument(visitorInterface, "onRelation", visitor.getOnRelation());
   	appModel().addArgument(visitorInterface, "onComplete", visitor.getOnComplete());
   	
   	visitor.getTemplatesSorted().forEach(stTemplate -> appModel().addKVArgument(visitorInterface, "templates", "name", stTemplate.getName(), "uuid", stTemplate.getUuid()));
   	
   	nextgen.model.STModel transactionAction = appModel().newSTModel(appModel().db.findSTTemplateByUuid("54b49221-8a58-44a5-9ba6-2a75cbe9357f"));
   	appModel().setArgument(transactionAction, "packageName", packageName);
   	appModel().setArgument(transactionAction, "name", visitor.getName());
   	appModel().setArgument(transactionAction, "title", visitor.getName());
   	appModel().addKVArgument(transactionAction, "fields", "name", "domain", "type", "nextgen.model.Domain");
   	appModel().addKVArgument(transactionAction, "fields", "name", "owner", "type", "javax.swing.JComponent");
   	appModel().addArgument(transactionAction, "statements", appModel().render(appModel().newSTModel(appModel().db.findSTTemplateByUuid("6032fd32-e00e-4f73-b7b7-8a9fe6444514"))));
   	appModel().addArgument(transactionAction, "methods", appModel().render(visitorInterface));
   	
//   	visitor.getImports().forEach(s -> appModel().addArgument(transactionAction, "imports", s));
   	
   	final java.io.File file = new java.io.File(nextgen.swing.AppModel.getInstance().getOutputPath());
   	nextgen.st.STGenerator.writeJavaFile(appModel().render(transactionAction), packageName, nextgen.swing.STAppPresentationModel.getSTModelName(transactionAction), file);
   	
   	appModel().setArgument(transactionAction, "name", visitor.getName() + "_" + System.currentTimeMillis());
   	
   	return transactionAction;
   }
}