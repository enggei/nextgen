package nextgen.actions;

public class NewInstance extends TransactionAction {

   private final nextgen.st.domain.STTemplate stTemplate;

	public NewInstance(String name, nextgen.st.domain.STTemplate stTemplate) {
      super(name);
      this.stTemplate = stTemplate;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().newSTModel(stTemplate);
   }
}