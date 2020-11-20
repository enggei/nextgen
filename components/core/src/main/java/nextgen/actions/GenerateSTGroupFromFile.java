package nextgen.actions;

public class GenerateSTGroupFromFile extends TransactionAction {


   private final nextgen.st.model.STGroupModel stGroup;
   private final nextgen.st.model.STGroupFile stGroupFile;

	public GenerateSTGroupFromFile(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STGroupFile stGroupFile) {
		super("Generate");
		this.stGroup = stGroup;
		this.stGroupFile = stGroupFile;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().generateSTGroupFromFile(stGroup, stGroupFile);
   }

}