package nextgen.actions;

public class NewInterface extends TransactionAction {


   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewInterface(nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Interface");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "New Interface", s ->
            nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
               final nextgen.st.domain.STInterface stInterface = appModel().newSTInterface(name);
               stGroup.addInterfaces(stInterface);
               nextgen.events.NewSTInterface.post(stGroup, stInterface);
            }));
   }

}