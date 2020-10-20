package nextgen.actions;

public class AddArgumentFromSTValue extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final nextgen.st.model.STValue value;

	public AddArgumentFromSTValue(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STValue value) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.value = value;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().doLaterInTransaction(transaction1 -> appModel().add(stModel, stParameter, value));
   }
}