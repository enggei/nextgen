package nextgen.actions;

public class RenameEnum extends TransactionAction {


   private final nextgen.st.domain.STEnum stEnum;
   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public RenameEnum(nextgen.st.domain.STEnum stEnum, nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Rename");
		this.stEnum = stEnum;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("RenameEnum");
      input(owner, "Name", stEnum.getName(), s -> {
         nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
            stEnum.setName(name);
            nextgen.events.STEnumNameChanged.post(stGroup, stEnum);
         });
      });
   }
}