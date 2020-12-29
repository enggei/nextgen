package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class UndoDBTransaction extends nextgen.actions.TransactionAction {


	public UndoDBTransaction() {
		super("Undo");
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("UndoDBTransaction");

      appModel().chronicle.rollbackLast();
   }

}