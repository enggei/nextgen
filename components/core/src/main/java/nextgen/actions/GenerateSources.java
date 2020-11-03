package nextgen.actions;

public class GenerateSources extends TransactionAction {


   private final nextgen.st.domain.STTemplate stTemplate;
   private final java.util.List<nextgen.st.model.STModel> stModels;

	public GenerateSources(nextgen.st.domain.STTemplate stTemplate, java.util.List<nextgen.st.model.STModel> stModels) {
		super("As builder code");
		this.stTemplate = stTemplate;
		this.stModels = stModels;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   }
}