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
      appModel().doLaterInTransaction(transaction1 -> appModel().add(stModel, stParameter, nextgen.utils.SwingUtil.fromClipboard()));
   }
}