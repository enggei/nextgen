package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddFileSink extends TransactionAction {

   private final STModel stModel;

	public AddFileSink(STModel stModel) {
		super("Add File Sink");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddFileSink" + " stModel");

      final java.util.Optional<STProject> stProject = appModel().findSTProjectFor(stModel);

      final String name = appModel().getSTModelName(stModel, "");
      final String packageName = appModel().getSTModelPackage(stModel, "");
      final String root = stProject.isPresent() ? stProject.get().getRoot() : "";

      appModel().addFile(stModel, appModel().newSTFile(name, packageName, root, "java"));
   }

}