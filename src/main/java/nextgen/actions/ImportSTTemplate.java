package nextgen.actions;

public class ImportSTTemplate extends nextgen.actions.TransactionAction {


   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public ImportSTTemplate(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Import from stg-file");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      openFile(owner, file -> {
      	appModel().setLastDir(file.getParentFile());
      	appModel().doLaterInTransaction(t -> {
      		final String fileName = file.getName();
      		final String name = fileName.substring(0, fileName.indexOf("."));
      		final nextgen.model.STTemplate stTemplate = appModel().db.newSTTemplate()
                  .setName(name)
                  .setText(nextgen.utils.FileUtil.readIntact(file));
            stGroup.addTemplates(stTemplate);
      		nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);
      	});
      });
   }

}