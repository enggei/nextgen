package nextgen.actions;

public class DeleteSTInterface extends nextgen.actions.TransactionAction {
   private final nextgen.model.STInterface stInterface;
   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public DeleteSTInterface(nextgen.model.STInterface stInterface, nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Delete");
		this.stInterface = stInterface;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Delete", unused -> {
         stGroup.removeInterfaces(stInterface);
         nextgen.events.STInterfaceDeleted.post(stInterface.getUuid());   
      });
   }

}