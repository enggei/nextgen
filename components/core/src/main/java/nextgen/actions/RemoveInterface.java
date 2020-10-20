package nextgen.actions;

public class RemoveInterface extends TransactionAction {

   private final String interfaceName;
   private final nextgen.st.domain.STTemplate stTemplate;
   private final javax.swing.JComponent owner;

	public RemoveInterface(String name, String interfaceName, nextgen.st.domain.STTemplate stTemplate, javax.swing.JComponent owner) {
      super(name);
      this.interfaceName = interfaceName;
      this.stTemplate = stTemplate;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().removeInterface(stTemplate, interfaceName);
   }
}