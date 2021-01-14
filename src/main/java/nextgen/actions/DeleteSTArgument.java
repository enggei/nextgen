package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteSTArgument extends nextgen.actions.TransactionAction {

   private final STArgument stArgument;
   private final JComponent owner;

	public DeleteSTArgument(STArgument stArgument, JComponent owner) {
		super("DEL");
		this.stArgument = stArgument;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteSTArgument" + " stArgument" + " owner");

      confirm(owner, "Remove", unused ->
            stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {
               final String uuid = stArgument.getUuid();
               stModel.removeArguments(stArgument);
               stArgument.getKeyValues().forEach(STArgumentKV::delete);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(uuid);
            }));
   }

}