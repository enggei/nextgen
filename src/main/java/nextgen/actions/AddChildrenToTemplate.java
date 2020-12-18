package nextgen.actions;

public class AddChildrenToTemplate extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupModel stGroup;
   private final nextgen.model.STTemplate stTemplate;
   private final java.util.Set<nextgen.model.STTemplate> children;
   private final javax.swing.JComponent owner;

	public AddChildrenToTemplate(String name, nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate, java.util.Set<nextgen.model.STTemplate> children, javax.swing.JComponent owner) {
      super(name);
      this.stGroup = stGroup;
      this.stTemplate = stTemplate;
      this.children = children;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("AddChildrenToTemplate" + " stGroup" + " stTemplate" + " children" + " owner");

      confirm(owner, "Sure to move", unused -> {
         appModel().aggregateTemplates(stGroup).forEach(stGroupTemplate -> {
            for (nextgen.model.STTemplate child : children) {
               stGroupTemplate.removeChildren(child);
            }
         });

         for (nextgen.model.STTemplate child : children)
            stTemplate.addChildren(child);

         nextgen.events.STTemplateChildrenAdded.post(stGroup, stTemplate, children);   
      });
   }

}