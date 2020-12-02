package nextgen.actions;

public class SetSTProjectRoot extends nextgen.actions.TransactionAction {

   private final nextgen.model.STProject stProject;
   private final javax.swing.JComponent owner;

	public SetSTProjectRoot(nextgen.model.STProject stProject, javax.swing.JComponent owner) {
		super("Change root");
		this.stProject = stProject;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      input(owner, "New Root", s -> {

      	stProject.setRoot(s);
      	
         final nextgen.model.STValue newPath = appModel().db.newSTValue(s.trim());
         nextgen.utils.STModelUtil.aggregateModels(stProject)
               .forEach(stModel -> stModel.getFiles()
                     .forEach(stFile -> {
                        stFile.setPath(newPath);
                        nextgen.events.STFileChanged.post(stFile);
                     }));
      });
   }

}