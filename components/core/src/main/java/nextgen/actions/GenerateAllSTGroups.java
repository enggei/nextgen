package nextgen.actions;

public class GenerateAllSTGroups extends TransactionAction {



	public GenerateAllSTGroups() {
		super("Generate all");
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("GenerateAllSTGroups");
      System.out.println("GenerateAllSTGroups");
      System.out.println("GenerateAllSTGroups");
      appModel().getSTGroups().forEach(stGroupModel -> appModel().generateSTGroup(stGroupModel, false));
   }
}