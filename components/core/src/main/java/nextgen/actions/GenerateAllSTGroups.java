package nextgen.actions;

public class GenerateAllSTGroups extends TransactionAction {


	public GenerateAllSTGroups() {
		super("Generate all");
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().generateAllGroups();
   }
}