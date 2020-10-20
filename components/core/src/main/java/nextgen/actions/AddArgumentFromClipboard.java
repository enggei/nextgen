package nextgen.actions;

public class AddArgumentFromClipboard extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public AddArgumentFromClipboard(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, javax.swing.JComponent owner) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().doLaterInTransaction(transaction1 -> appModel().add(stModel, stParameter, nextgen.utils.SwingUtil.fromClipboard()));
   }
}