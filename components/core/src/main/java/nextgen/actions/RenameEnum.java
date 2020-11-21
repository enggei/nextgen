package nextgen.actions;

public class RenameEnum extends TransactionAction {


   private final nextgen.st.model.STEnum stEnum;
   private final nextgen.st.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public RenameEnum(nextgen.st.model.STEnum stEnum, nextgen.st.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Rename");
		this.stEnum = stEnum;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "Name", stEnum.getName(), s -> nextgen.swing.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
      	stEnum.setName(name);
      	nextgen.events.STEnumNameChanged.post(stGroup, stEnum);
      }));
   }

}