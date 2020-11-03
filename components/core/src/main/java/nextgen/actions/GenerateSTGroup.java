package nextgen.actions;

public class GenerateSTGroup extends TransactionAction {


   private final nextgen.st.domain.STGroupModel stGroup;

	public GenerateSTGroup(nextgen.st.domain.STGroupModel stGroup) {
		super("Generate STGroup");
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("GenerateSTGroup");
      appModel().generateSTGroup(stGroup, false);
   }
}