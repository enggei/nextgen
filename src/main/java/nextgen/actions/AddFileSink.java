package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class AddFileSink extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;

	public AddFileSink(nextgen.model.STModel stModel) {
		super("Add File Sink");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("AddFileSink" + " stModel");

      final java.util.Optional<nextgen.model.STProject> stProject = appModel().findSTProjectFor(stModel);

      final String name = appModel().getSTModelName(stModel, "");
      final String packageName = appModel().getSTModelPackage(stModel, "");
      final String root = stProject.isPresent() ? stProject.get().getRoot() : "";

      appModel().addFile(stModel, appModel().newSTFile(name, packageName, root, "java"));
   }

}