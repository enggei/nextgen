package nextgen.actions;

public class AddChildrenToTemplate extends TransactionAction {


   private final nextgen.st.domain.STGroupModel stGroup;
   private final nextgen.st.domain.STTemplate stTemplate;
   private final java.util.Set<nextgen.st.domain.STTemplate> children;
   private final javax.swing.JComponent owner;

	public AddChildrenToTemplate(String name, nextgen.st.domain.STGroupModel stGroup, nextgen.st.domain.STTemplate stTemplate, java.util.Set<nextgen.st.domain.STTemplate> children, javax.swing.JComponent owner) {
      super(name);
      this.stGroup = stGroup;
      this.stTemplate = stTemplate;
      this.children = children;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      System.out.println("AddChildrenToTemplate");
      System.out.println("AddChildrenToTemplate");
      System.out.println("AddChildrenToTemplate");
      confirm(owner, "Sure to move", unused -> {
         appModel().aggregateTemplates(stGroup).forEach(stGroupTemplate -> {
            for (nextgen.st.domain.STTemplate child : children) {
               stGroupTemplate.removeChildren(child);
            }
         });

         for (nextgen.st.domain.STTemplate child : children)
            stTemplate.addChildren(child);

         nextgen.events.STTemplateChildrenAdded.post(stGroup, stTemplate, children);   
      });
   }
}