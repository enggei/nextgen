package nextgen.actions;

public class NewInterface extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewInterface(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Interface");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("NewInterface" + " stGroup" + " owner");

      input(owner, "New Interface", s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> appModel().addInterface(stGroup, name)));
   }

}