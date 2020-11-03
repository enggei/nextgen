package nextgen.actions;

public class GenerateSTGroupAndNeo extends TransactionAction {


   private final nextgen.st.domain.STGroupModel stGroup;

	public GenerateSTGroupAndNeo(nextgen.st.domain.STGroupModel stGroup) {
		super("Generate STGroup and Neo");
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("GenerateSTGroupAndNeo");
      System.out.println("GenerateSTGroupAndNeo");
      System.out.println("GenerateSTGroupAndNeo");
      appModel().generateSTGroup(stGroup, true);
   }
}