package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteSTValue extends nextgen.actions.TransactionAction {

   private final STValue stValue;
   private final JComponent owner;

	public DeleteSTValue(STValue stValue, JComponent owner) {
		super("DEL");
		this.stValue = stValue;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteSTValue" + " stValue" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stValue));
   }

}