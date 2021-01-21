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

      new Thread(() -> {
      	appModel().doInTransaction(tx -> {
      		try {
      			final nextgen.st.STBuilder source = asSource();
      			final String className = source.getPackageName() + "." + source.getName();
      			final Class<?> aClass = net.openhft.compiler.CompilerUtils.CACHED_COMPILER.loadFromJava(className, source.toString());
      			final nextgen.actions.TransactionAction action = (nextgen.actions.TransactionAction) aClass.getDeclaredConstructor(Domain.class, JComponent.class).newInstance(visitor.getIncomingVisitorsDomain().findFirst().get(), owner);
      			action.actionPerformed(actionEvent);
      		} catch (Throwable e) {
      			throw new RuntimeException(e);
      		}
      	});
      }).start();
   }

   private nextgen.st.STBuilder asSource() {

   	final String packageName = appModel().getSourceOutputPackage() + "." + visitor.getName().toLowerCase();

   	nextgen.st.STBuilder domainVisitor = new nextgen.st.STBuilder("95c75764-2aff-4b56-b1db-fa2ffac11872");
   	domainVisitor.add("onDomain", visitor.getOnDomain());
   	domainVisitor.add("onEntity", visitor.getOnEntity());
   	domainVisitor.add("onRelation", visitor.getOnRelation());
   	domainVisitor.add("onComplete", visitor.getOnComplete());

   	domainVisitor.add("onEntityEntity", visitor.getOnEntityEntity());
   	domainVisitor.add("onEnumEntity", visitor.getOnEnumEntity());
   	domainVisitor.add("onPrimitiveEntity", visitor.getOnPrimitiveEntity());

   	domainVisitor.add("onOneEntityRelation", visitor.getOnOneEntityRelation());
   	domainVisitor.add("onOneEnumRelation", visitor.getOnOneEnumRelation());
   	domainVisitor.add("onOnePrimitiveRelation", visitor.getOnOnePrimitiveRelation());

   	domainVisitor.add("onManyEntityRelation", visitor.getOnManyEntityRelation());
   	domainVisitor.add("onManyEnumRelation", visitor.getOnManyEnumRelation());
   	domainVisitor.add("onManyPrimitiveRelation", visitor.getOnManyPrimitiveRelation());

   	domainVisitor.add("onOptionalEntityRelation", visitor.getOnOptionalEntityRelation());
   	domainVisitor.add("onOptionalEnumRelation", visitor.getOnOptionalEnumRelation());
   	domainVisitor.add("onOptionalPrimitiveRelation", visitor.getOnOptionalPrimitiveRelation());

   	nextgen.st.STBuilder transactionAction = new nextgen.st.STBuilder("54b49221-8a58-44a5-9ba6-2a75cbe9357f");
   	transactionAction.add("imports", "static nextgen.utils.StringUtil.*");
   	transactionAction.add("imports", "nextgen.st.*");
   	transactionAction.add("packageName", packageName);
   	transactionAction.add("name", visitor.getName());
   	transactionAction.add("title", visitor.getName());
   	transactionAction.add("fields", "name", "domain", "type", "nextgen.model.Domain");
   	transactionAction.add("fields", "name", "owner", "type", "javax.swing.JComponent");
   	transactionAction.add("statements", new nextgen.st.STBuilder("6032fd32-e00e-4f73-b7b7-8a9fe6444514"));
   	transactionAction.add("methods", domainVisitor);

   	// write to tmp- package (for debugging etc)
   	transactionAction.writeJavaFile(nextgen.swing.AppModel.getInstance().getOutputPath());

   	// change name, so compiler will use fresh code (and not cached)
   	transactionAction.add("name", visitor.getName() + "_" + System.currentTimeMillis());

   	return transactionAction;
   }
}