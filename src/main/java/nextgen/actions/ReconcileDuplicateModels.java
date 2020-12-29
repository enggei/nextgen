package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class ReconcileDuplicateModels extends nextgen.actions.TransactionAction {


	public ReconcileDuplicateModels() {
		super("Merge Duplicates");
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("ReconcileDuplicateModels");

      appModel().reconcileDuplicateModels();
   }

}