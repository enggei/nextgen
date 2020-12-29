package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class ReconcileDuplicateModels extends TransactionAction {


	public ReconcileDuplicateModels() {
		super("Merge Duplicates");
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("ReconcileDuplicateModels");

      appModel().reconcileDuplicateModels();
   }

}