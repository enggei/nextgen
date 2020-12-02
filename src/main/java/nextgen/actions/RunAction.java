package nextgen.actions;

public class RunAction extends nextgen.actions.TransactionAction {
   private final nextgen.model.STGroupAction action;
   private final javax.swing.JComponent owner;

	public RunAction(nextgen.model.STGroupAction action, javax.swing.JComponent owner) {
		super("Run");
		this.action = action;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      try {
         final nextgen.templates.nextgen.TransactionAction source = asSource();
         final String className = source.getPackageName() + "." + source.getName().toString();
         final Class<?> aClass = net.openhft.compiler.CompilerUtils.CACHED_COMPILER.loadFromJava(className, source.toString());
         final nextgen.actions.TransactionAction action = (nextgen.actions.TransactionAction) aClass.getDeclaredConstructor(javax.swing.JComponent.class).newInstance(owner);
         action.actionPerformed(actionEvent);
      } catch (Throwable e) {
         throw new RuntimeException(e);
      }
   }

   private nextgen.templates.nextgen.TransactionAction asSource() {

      final java.util.concurrent.atomic.AtomicReference<nextgen.templates.nextgen.TransactionAction> reference = new java.util.concurrent.atomic.AtomicReference<>();

      action.getIncomingActionsSTGroupModel().findAny().ifPresent(stGroupModel -> {
         final String packageName = appModel().getSourceOutputPackage() + "." + stGroupModel.getName().toLowerCase();

         final nextgen.templates.nextgen.TransactionAction transactionAction = nextgen.templates.nextgen.NextgenST.newTransactionAction()
               .setPackageName(packageName)
               .setName(action.getName())
               .setTitle(action.getName())
               .addFields("owner", "javax.swing.JComponent")
               .setImports(appModel().render(action.getImports()).split("\n"))
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