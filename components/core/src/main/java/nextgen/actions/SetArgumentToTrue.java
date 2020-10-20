package nextgen.actions;

public class SetArgumentToTrue extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;

	public SetArgumentToTrue(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().doLaterInTransaction(transaction1 -> appModel().set(stModel, stParameter, "TRUE"));
   }
}