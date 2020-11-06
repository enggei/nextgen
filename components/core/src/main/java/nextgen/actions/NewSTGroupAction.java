package nextgen.actions;

public class NewSTGroupAction extends TransactionAction {


   private final javax.swing.JComponent owner;

	public NewSTGroupAction(javax.swing.JComponent owner) {
		super("New STGroup");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Name", name -> {
      	
      	final java.util.Optional<nextgen.st.domain.STGroupModel> existing = appModel().findSTGroup(name);
      	if (existing.isPresent()) {
      		nextgen.utils.SwingUtil.showMessage(name + " group already exists in this directory", owner);
      		return;
      	}

      	if (!javax.lang.model.SourceVersion.isIdentifier(name)) {
      		nextgen.utils.SwingUtil.showMessage(name + " is a reserved java keyword", owner);
      		return;
      	}

      	final nextgen.st.domain.STGroupModel stGroupModel = appModel().newSTGroupModel(name);
      	nextgen.events.NewSTGroup.post(stGroupModel);
      });
   }
}