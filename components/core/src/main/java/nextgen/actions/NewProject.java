package nextgen.actions;

public class NewProject extends TransactionAction {


   private final javax.swing.JComponent owner;

	public NewProject(javax.swing.JComponent owner) {
		super("New Project");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("NewProject");
      System.out.println("NewProject");
      System.out.println("NewProject");
      input(owner, "Name", s -> {
         final nextgen.st.model.STProject stProject = appModel().db.newSTProject(s);
         nextgen.events.NewSTProject.post(stProject);
      });
   }
}