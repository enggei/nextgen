package nextgen.actions;

public class AddFileSink extends TransactionAction {


   private final nextgen.model.STModel stModel;

	public AddFileSink(nextgen.model.STModel stModel) {
		super("Add File Sink");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String name = nextgen.utils.STModelUtil.getSTModelName(stModel, "");
      final String packageName = nextgen.utils.STModelUtil.getSTModelPackage(stModel, "");
      final nextgen.model.STFile stFile = appModel().db.newSTFile()
                  .setName(appModel().newSTValue(name))
                  .setType(appModel().db.findOrCreateSTValueByValue("java"))
                  .setPath(appModel().newSTValue(""))
                  .setPackageName(appModel().newSTValue(packageName));
      stModel.addFiles(stFile);
      nextgen.events.NewFileSink.post(stModel, stFile);
   }

}