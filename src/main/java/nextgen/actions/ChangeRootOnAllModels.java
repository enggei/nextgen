package nextgen.actions;

public class ChangeRootOnAllModels extends nextgen.actions.TransactionAction {


   private final nextgen.st.model.STProject stProject;
   private final javax.swing.JComponent owner;

   public ChangeRootOnAllModels(nextgen.st.model.STProject stProject, javax.swing.JComponent owner) {
      super("Change root");
      this.stProject = stProject;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "New Path", s -> {

         final nextgen.st.model.STValue newPath = appModel().newSTValue(s.trim());
         nextgen.utils.STModelUtil.aggregateModels(stProject)
               .forEach(stModel -> stModel.getFiles()
                     .forEach(stFile -> {
                        stFile.setPath(newPath);
                        nextgen.events.STFileChanged.post(stFile);
                     }));
      });
   }

}