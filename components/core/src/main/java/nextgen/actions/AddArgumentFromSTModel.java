package nextgen.actions;

public class AddArgumentFromSTModel extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final nextgen.st.model.STModel value;

	public AddArgumentFromSTModel(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, nextgen.st.model.STModel value) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.value = value;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("AddArgumentFromSTModel");
      System.out.println("AddArgumentFromSTModel");
      System.out.println("AddArgumentFromSTModel");
      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);
      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }
}