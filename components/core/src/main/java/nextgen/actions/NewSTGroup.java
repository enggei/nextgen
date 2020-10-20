package nextgen.actions;

public class NewSTGroup extends TransactionAction {

   private final javax.swing.JComponent owner;

	public NewSTGroup(javax.swing.JComponent owner) {
		super("New STGroup");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.getInputFromUser(owner, "Name").ifPresent(name -> {

      	final java.util.Optional<nextgen.st.domain.STGroupModel> existing = appModel().findSTGroup(name);
      	if (existing.isPresent()) {
      		nextgen.utils.SwingUtil.showMessage(name + " group already exists in this directory", owner);
      		return;
      	}

      	if (!javax.lang.model.SourceVersion.isIdentifier(name)) {
      		nextgen.utils.SwingUtil.showMessage(name + " is a reserved java keyword", owner);
      		return;
      	}

      	appModel().newSTGroupModel(name);
      });
   }
}