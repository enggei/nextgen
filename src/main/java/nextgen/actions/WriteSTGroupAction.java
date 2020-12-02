package nextgen.actions;

public class WriteSTGroupAction extends nextgen.actions.TransactionAction {
   private final nextgen.model.STGroupAction action;

	public WriteSTGroupAction(nextgen.model.STGroupAction action) {
		super("Generate Source");
		this.action = action;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
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
      });
   }

}