package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class WriteSTFile extends TransactionAction {

   private final STFile stFile;

	public WriteSTFile(STFile stFile) {
		super("Generate");
		setIcon("gen");
		this.stFile = stFile;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("WriteSTFile" + " stFile");

      stFile.getIncomingFilesSTModel().forEach(stModel -> {
         final String content = appModel().render(stModel);
         final String packageDeclaration = stFile.getPackageName()==null ? "" : stFile.getPackageName().getValue();
         final String name = stFile.getName().getValue();
         final String filetype = stFile.getType().getValue();
         final java.io.File root = new java.io.File(stFile.getPath().getValue());
         nextgen.st.STGenerator.writeToFile(content, packageDeclaration, name, filetype, root);
      });
   }

}