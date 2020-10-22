package nextgen.actions;

public class AddArgumentFromClipboard extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;

	public AddArgumentFromClipboard(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final nextgen.st.model.STValue stValue = appModel().db.newSTValue(nextgen.utils.SwingUtil.fromClipboard());
      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }
}