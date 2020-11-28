package nextgen.actions;

public class GenerateSTGroup extends nextgen.actions.TransactionAction {


   private final nextgen.model.STGroupModel stGroup;

	public GenerateSTGroup(nextgen.model.STGroupModel stGroup) {
		super("Generate STGroup");
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().generateSTGroup(stGroup, false);
   }

}