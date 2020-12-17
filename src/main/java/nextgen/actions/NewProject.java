package nextgen.actions;

public class NewProject extends nextgen.actions.TransactionAction {

   private final javax.swing.JComponent owner;

	public NewProject(javax.swing.JComponent owner) {
		super("New Project");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	System.out.println("NewProject" + " owner");

      input(owner, "Name", s -> appModel().newSTProject(s));
   }

}