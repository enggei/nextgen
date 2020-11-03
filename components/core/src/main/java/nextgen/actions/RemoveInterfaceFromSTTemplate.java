package nextgen.actions;

public class RemoveInterfaceFromSTTemplate extends TransactionAction {


   private final nextgen.st.domain.STGroupModel stGroup;
   private final nextgen.st.domain.STTemplate stTemplate;
   private final String interfaceName;
   private final javax.swing.JComponent owner;

	public RemoveInterfaceFromSTTemplate(String name, nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate stTemplate, String interfaceName, javax.swing.JComponent owner) {
      super(name);
      this.stGroup = stGroup;
      this.stTemplate = stTemplate;
      this.interfaceName = interfaceName;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("RemoveInterfaceFromSTTemplate");
      System.out.println("RemoveInterfaceFromSTTemplate");
      System.out.println("RemoveInterfaceFromSTTemplate");
      confirm(owner, "Remove", unused -> {
         stTemplate.removeImplements(interfaceName);
         nextgen.events.STTemplateInterfaceRemoved.post(stGroup, stTemplate, interfaceName);
      });
   }
}