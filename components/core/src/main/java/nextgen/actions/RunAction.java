package nextgen.actions;

public class RunAction extends nextgen.actions.TransactionAction {


   private final nextgen.st.model.STGroupAction action;
   private final javax.swing.JComponent owner;

	public RunAction(nextgen.st.model.STGroupAction action, javax.swing.JComponent owner) {
		super("Run");
		this.action = action;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String packageName = "tmp.actions";
      final String currentClassName = action.getName() + "_" + System.currentTimeMillis();
      final String className = packageName + "." + currentClassName;

      try {
         final Class<?> workClass = net.openhft.compiler.CompilerUtils.CACHED_COMPILER.loadFromJava(className, asSource(packageName, currentClassName));
         final nextgen.actions.TransactionAction transactionAction = (nextgen.actions.TransactionAction) workClass.getDeclaredConstructor(javax.swing.JComponent.class).newInstance(owner);
         transactionAction.actionPerformed(actionEvent);
      } catch (Throwable e) {
         throw new RuntimeException(e);
      }
   }

   private String asSource(String packageName, String currentClassName) {

      final nextgen.templates.nextgen.TransactionAction transactionAction = nextgen.templates.nextgen.NextgenST.newTransactionAction()
            .setPackageName(packageName)
            .setName(currentClassName)
            .setTitle(action.getName())
            .addFields("owner", "javax.swing.JComponent")
            .addStatements(action.getStatements())
            .addMethods(action.getMethods());

   	final java.io.File file = new java.io.File(appModel().getOutputPath());
      nextgen.st.STGenerator.writeJavaFile(transactionAction, packageName, currentClassName, file);
      file.deleteOnExit();

      return transactionAction.toString();
   }
}