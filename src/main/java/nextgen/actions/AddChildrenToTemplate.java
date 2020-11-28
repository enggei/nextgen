package nextgen.actions;

public class AddChildrenToTemplate extends TransactionAction {


   private final nextgen.st.model.STGroupModel stGroup;
   private final nextgen.st.model.STTemplate stTemplate;
   private final java.util.Set<nextgen.st.model.STTemplate> children;
   private final javax.swing.JComponent owner;

	public AddChildrenToTemplate(String name, nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STTemplate stTemplate, java.util.Set<nextgen.st.model.STTemplate> children, javax.swing.JComponent owner) {
      super(name);
      this.stGroup = stGroup;
      this.stTemplate = stTemplate;
      this.children = children;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      confirm(owner, "Sure to move", unused -> {
         nextgen.utils.STModelUtil.aggregateTemplates(stGroup).forEach(stGroupTemplate -> {
            for (nextgen.st.model.STTemplate child : children) {
               stGroupTemplate.removeChildren(child);
            }
         });

         for (nextgen.st.model.STTemplate child : children)
            stTemplate.addChildren(child);

         nextgen.events.STTemplateChildrenAdded.post(stGroup, stTemplate, children);   
      });
   }

}