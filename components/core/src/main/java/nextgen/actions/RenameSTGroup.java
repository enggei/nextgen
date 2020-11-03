package nextgen.actions;

public class RenameSTGroup extends TransactionAction {


   private final nextgen.st.domain.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public RenameSTGroup(nextgen.st.domain.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Rename");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("RenameSTGroup");
      System.out.println("RenameSTGroup");
      System.out.println("RenameSTGroup");
      input(owner, "Name", stGroup.getName(), s -> {
      	nextgen.st.STAppPresentationModel.isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
      		stGroup.setName(name);
      		nextgen.events.STGroupNameChanged.post(stGroup);
      	});
      });
   }
}