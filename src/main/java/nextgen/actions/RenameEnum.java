package nextgen.actions;

public class RenameEnum extends nextgen.actions.TransactionAction {

   private final nextgen.model.STEnum stEnum;
   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public RenameEnum(nextgen.model.STEnum stEnum, nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Rename");
		this.stEnum = stEnum;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("RenameEnum" + " stEnum" + " stGroup" + " owner");

      input(owner, "Name", stEnum.getName(), s -> nextgen.utils.STModelUtil.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
      	stEnum.setName(name);
      	nextgen.events.STEnumNameChanged.post(stGroup, stEnum);
      }));
   }

}