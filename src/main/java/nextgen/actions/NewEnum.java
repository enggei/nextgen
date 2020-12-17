package nextgen.actions;

public class NewEnum extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewEnum(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Enum");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("NewEnum" + " stGroup" + " owner");

      input(owner, "New Enum", s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> appModel().newSTEnum(name)));
   }

}