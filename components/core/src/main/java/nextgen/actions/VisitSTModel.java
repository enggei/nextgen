package nextgen.actions;

public class VisitSTModel extends TransactionAction {

   private final nextgen.st.model.STModel stModel;

	public VisitSTModel(nextgen.st.model.STModel stModel) {
		super("VisitSTModel");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      new nextgen.st.STVisitorTest(appModel()).visit(stModel);
   }
}