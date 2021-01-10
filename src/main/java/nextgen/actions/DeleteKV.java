package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteKV extends nextgen.actions.TransactionAction {

   private final STArgumentKV argumentKV;
   private final JComponent owner;

	public DeleteKV(STArgumentKV argumentKV, JComponent owner) {
		super("DEL");
		this.argumentKV = argumentKV;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteKV" + " argumentKV" + " owner");

      confirm(owner, "Delete", unused ->
            argumentKV.getIncomingKeyValuesSTArgument()
                  .findFirst()
                  .ifPresent(stArgument -> stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {
                     final String uuid = argumentKV.getUuid();
                     stArgument.removeKeyValues(argumentKV);
                     nextgen.events.KVDeleted.post(stModel, stArgument, uuid);
                  })));
   }

}