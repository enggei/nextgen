package nextgen.actions;

public class AddFileSink extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;

	public AddFileSink(nextgen.model.STModel stModel) {
		super("Add File Sink");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final java.util.Optional<nextgen.model.STProject> stProject = nextgen.utils.STModelUtil.findSTProjectFor(stModel);

      final String name = nextgen.utils.STModelUtil.getSTModelName(stModel, "");
      final String packageName = nextgen.utils.STModelUtil.getSTModelPackage(stModel, "");
      final String root = stProject.isPresent() ? stProject.get().getRoot() : "";

      final nextgen.model.STFile stFile = appModel().db.newSTFile()
            .setName(appModel().db.newSTValue(name))
            .setType(appModel().db.findOrCreateSTValueByValue("java"))
            .setPath(appModel().db.newSTValue(root))
            .setPackageName(appModel().db.newSTValue(packageName));

      stModel.addFiles(stFile);
      nextgen.events.NewFileSink.post(stModel, stFile);
   }

}