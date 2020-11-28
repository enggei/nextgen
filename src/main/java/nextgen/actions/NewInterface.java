package nextgen.actions;

public class NewInterface extends TransactionAction {


   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewInterface(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Interface");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "New Interface", s ->
      		nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
      			final nextgen.model.STInterface stInterface = appModel().db.newSTInterface().setName(s);
      			stGroup.addInterfaces(stInterface);
      			nextgen.events.NewSTInterface.post(stGroup, stInterface);
      		}));
   }

}