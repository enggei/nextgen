package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class CopyFilePathToClipboard extends nextgen.actions.TransactionAction {

   private final nextgen.model.STFile stFile;

	public CopyFilePathToClipboard(nextgen.model.STFile stFile) {
		super("Copy path to Clipboard");
		this.stFile = stFile;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("CopyFilePathToClipboard" + " stFile");

      final nextgen.model.STValue path = stFile.getPath();
      final nextgen.model.STValue packageName = stFile.getPackageName();
      final nextgen.model.STValue name = stFile.getName();
      final nextgen.model.STValue type = stFile.getType();
      final String file = appModel().render(path) + java.io.File.separator + nextgen.st.STGenerator.packageToPath(appModel().render(packageName)) + java.io.File.separator + appModel().render(name) + "." + appModel().render(type);

      toClipboard(file);
   }

}