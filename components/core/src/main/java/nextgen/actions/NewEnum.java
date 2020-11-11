package nextgen.actions;

public class NewEnum extends TransactionAction {


   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewEnum(nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Enum");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "New Enum", s ->
            nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
               final nextgen.st.domain.STEnum stEnum = appModel().newSTEnum(name);
               stGroup.addEnums(stEnum);
               nextgen.events.NewSTEnum.post(stGroup, stEnum);
            }));
   }

}