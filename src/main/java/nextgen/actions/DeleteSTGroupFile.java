package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteSTGroupFile extends TransactionAction {

   private final STGroupFile stgroupFile;
   private final JComponent owner;

	public DeleteSTGroupFile(STGroupFile stgroupFile, JComponent owner) {
		super("Delete");
		this.stgroupFile = stgroupFile;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteSTGroupFile" + " stgroupFile" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stgroupFile));
   }

}