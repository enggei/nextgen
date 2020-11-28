package nextgen.actions;

public class GenerateSTGroupAndNeo extends TransactionAction {


   private final nextgen.model.STGroupModel stGroup;

	public GenerateSTGroupAndNeo(nextgen.model.STGroupModel stGroup) {
		super("Generate STGroup and Neo");
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().generateSTGroup(stGroup, true);
   }

}