package nextgen.actions;

public class DeleteEnum extends TransactionAction {


   private final nextgen.model.STEnum stEnum;
   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public DeleteEnum(nextgen.model.STEnum stEnum, nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Delete");
		this.stEnum = stEnum;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Delete", unused -> {
         stGroup.removeEnums(stEnum);
         nextgen.events.STEnumDeleted.post(stEnum.getUuid());
      });
   }

}