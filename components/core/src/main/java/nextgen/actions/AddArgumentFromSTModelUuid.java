package nextgen.actions;

public class AddArgumentFromSTModelUuid extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final String uuid;

	public AddArgumentFromSTModelUuid(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, String uuid) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.uuid = uuid;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("AddArgumentFromSTModelUuid");
      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(appModel().db.cloneSTModel(uuid));
      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }
}