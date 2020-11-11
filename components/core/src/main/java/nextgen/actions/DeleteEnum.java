package nextgen.actions;

public class DeleteEnum extends TransactionAction {


   private final nextgen.st.domain.STEnum stEnum;
   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public DeleteEnum(nextgen.st.domain.STEnum stEnum, nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
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