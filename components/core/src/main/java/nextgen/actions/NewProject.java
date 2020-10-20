package nextgen.actions;

public class NewProject extends TransactionAction {

   private final javax.swing.JComponent owner;

	public NewProject(javax.swing.JComponent owner) {
		super("New Project");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      nextgen.utils.SwingUtil.getInputFromUser(owner, "Name").ifPresent(name -> appModel().doLaterInTransaction(t -> appModel().newSTProject(name)));
   }
}