package nextgen.actions;

public class RemoveInterfaceFromSTTemplate extends nextgen.actions.TransactionAction {


   private final nextgen.model.STGroupModel stGroup;
   private final nextgen.model.STTemplate stTemplate;
   private final String interfaceName;
   private final javax.swing.JComponent owner;

	public RemoveInterfaceFromSTTemplate(String name, nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate, String interfaceName, javax.swing.JComponent owner) {
      super(name);
      this.stGroup = stGroup;
      this.stTemplate = stTemplate;
      this.interfaceName = interfaceName;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Remove", unused -> {
         stTemplate.removeImplements(interfaceName);
         nextgen.events.STTemplateInterfaceRemoved.post(stGroup, stTemplate, interfaceName);
      });
   }

}