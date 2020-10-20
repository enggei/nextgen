package nextgen.actions;

public class AddTemplateModelToProject extends TransactionAction {

   private final nextgen.st.domain.STTemplate stTemplate;
   private final nextgen.st.model.STProject project;
   private final javax.swing.JComponent owner;

	public AddTemplateModelToProject(String name, nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STProject project, javax.swing.JComponent owner) {
      super(name);
      this.stTemplate = stTemplate;
      this.project = project;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      appModel().newSTModel(stTemplate, project);
   }
}