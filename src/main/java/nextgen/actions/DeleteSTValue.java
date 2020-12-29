package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class DeleteSTValue extends nextgen.actions.TransactionAction {

   private final nextgen.model.STValue stValue;
   private final javax.swing.JComponent owner;

	public DeleteSTValue(nextgen.model.STValue stValue, javax.swing.JComponent owner) {
		super("DEL");
		this.stValue = stValue;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("DeleteSTValue" + " stValue" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stValue));
   }

}