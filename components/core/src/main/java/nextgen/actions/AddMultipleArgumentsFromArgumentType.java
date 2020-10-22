package nextgen.actions;

public class AddMultipleArgumentsFromArgumentType extends TransactionAction {

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public AddMultipleArgumentsFromArgumentType(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, javax.swing.JComponent owner) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   }
}