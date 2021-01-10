package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class ImportSTTemplate extends nextgen.actions.TransactionAction {

   private final STGroupModel stGroup;
   private final JComponent owner;

	public ImportSTTemplate(STGroupModel stGroup, JComponent owner) {
		super("Import from stg-file");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("ImportSTTemplate" + " stGroup" + " owner");

      openFile(owner, file -> {
         appModel().setLastDir(file.getParentFile());
         appModel().doLaterInTransaction(t -> {
            final String fileName = file.getName();
            final String name = fileName.substring(0, fileName.indexOf("."));
            final STTemplate stTemplate = appModel().newSTTemplate(name, nextgen.utils.FileUtil.readIntact(file));
            stGroup.addTemplates(stTemplate);
            nextgen.events.NewSTGroupTemplate.post(stTemplate, stGroup);
         });
      });
   }

}