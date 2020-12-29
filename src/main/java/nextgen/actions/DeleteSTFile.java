package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteSTFile extends TransactionAction {

   private final STFile stFile;
   private final JComponent owner;

	public DeleteSTFile(STFile stFile, JComponent owner) {
		super("Delete");
		this.stFile = stFile;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteSTFile" + " stFile" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stFile));
   }

}