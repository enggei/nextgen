package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteSTFileFromSTModels extends nextgen.actions.TransactionAction {

   private final java.util.List<STModel> stModels;
   private final JComponent owner;

	public DeleteSTFileFromSTModels(java.util.List<STModel> stModels, JComponent owner) {
		super("Delete Filesinks");
		this.stModels = stModels;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteSTFileFromSTModels" + " stModels" + " owner");

      confirm(owner, "Delete", unused -> appModel().deleteSTFilesFrom(stModels));
   }

}