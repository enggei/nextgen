package nextgen.actions;

public class VisitModel extends TransactionAction {

   private final nextgen.st.model.STModel stModel;

	public VisitModel(nextgen.st.model.STModel stModel) {
		super("Visit");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      new nextgen.st.STVisitorTest(appModel()).visit(stModel);
   }
}