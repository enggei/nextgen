package nextgen.actions;

public class RenameSTInterface extends TransactionAction {


   private final nextgen.model.STInterface stInterface;
   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public RenameSTInterface(nextgen.model.STInterface stInterface, nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Rename");
		this.stInterface = stInterface;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Name", stInterface.getName(), s -> nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
         stInterface.setName(name);
         nextgen.events.STInterfaceNameChanged.post(stGroup, stInterface);
      }));
   }

}