package nextgen.actions;

public class RunAction extends nextgen.actions.TransactionAction {

   private static final java.util.Map<String, String> actions = new java.util.LinkedHashMap<>();
   private static final java.util.Map<String, String> actionNames = new java.util.LinkedHashMap<>();

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

      final String packageName = "tmp.actions";

      final nextgen.templates.nextgen.TransactionAction transactionAction = nextgen.templates.nextgen.NextgenST.newTransactionAction()
            .setPackageName(packageName)
            .setTitle(action.getName())
            .addFields("owner", "javax.swing.JComponent")
            .addStatements(appModel().render(action.getStatements()))
            .addMethods(appModel().render(action.getMethods()));

      final String current = transactionAction.toString();

      if (!actions.containsKey(action.getUuid()) || !actions.get(action.getUuid()).equals(current)) {
         transactionAction.setName(action.getName() + "_" + System.currentTimeMillis());
         actions.put(action.getUuid(), current);
         actionNames.put(action.getUuid(), transactionAction.getName().toString());
         
         final java.io.File file = new java.io.File(appModel().getOutputPath());
         nextgen.st.STGenerator.writeJavaFile(transactionAction, packageName, transactionAction.getName().toString(), file);
         file.deleteOnExit();
      } else {
         transactionAction.setName(actionNames.get(action.getUuid()));
      }

      return transactionAction;
   }
}