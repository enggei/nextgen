package nextgen.actions;

public class SetArgumentFromSTModelUuid extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final String uuid;

	public SetArgumentFromSTModelUuid(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, String uuid) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.uuid = uuid;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().doLaterInTransaction(transaction1 -> appModel().set(stModel, stParameter, appModel().db.cloneSTModel(uuid)));
   }
}