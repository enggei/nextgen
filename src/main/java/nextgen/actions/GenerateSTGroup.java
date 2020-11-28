package nextgen.actions;

public class GenerateSTGroup extends TransactionAction {


   private final nextgen.st.model.STGroupModel stGroup;

	public GenerateSTGroup(nextgen.st.model.STGroupModel stGroup) {
		super("Generate STGroup");
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().generateSTGroup(stGroup, false);
   }

}