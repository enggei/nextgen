package nextgen.actions;

public class NewSTGroupAction extends nextgen.actions.TransactionAction {


   private final javax.swing.JComponent owner;

	public NewSTGroupAction(javax.swing.JComponent owner) {
		super("New STGroup");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Name", name -> {

         final nextgen.model.STGroupModel existing = appModel().db.findSTGroupModelByName(name);
         if (existing != null) {
            nextgen.utils.SwingUtil.showMessage(name + " group already exists in this directory", owner);
            return;
         }

         if (!javax.lang.model.SourceVersion.isIdentifier(name)) {
            nextgen.utils.SwingUtil.showMessage(name + " is a reserved java keyword", owner);
            return;
         }

         final nextgen.model.STGroupModel stGroupModel = appModel().db.newSTGroupModel()
               .setName(name)
               .setDelimiter(nextgen.st.STGenerator.DELIMITER);
         nextgen.events.NewSTGroup.post(stGroupModel);
      });
   }

}