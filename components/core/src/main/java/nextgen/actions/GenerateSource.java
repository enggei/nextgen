package nextgen.actions;

public class GenerateSource extends TransactionAction {

   private final nextgen.st.model.STModel stModel;

	public GenerateSource(nextgen.st.model.STModel stModel) {
		super("As builder code");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().generateSource(stModel);
   }
}