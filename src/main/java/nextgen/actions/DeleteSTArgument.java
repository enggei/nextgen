package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class DeleteSTArgument extends nextgen.actions.TransactionAction {

   private final nextgen.model.STArgument stArgument;
   private final javax.swing.JComponent owner;

	public DeleteSTArgument(nextgen.model.STArgument stArgument, javax.swing.JComponent owner) {
		super("DEL");
		this.stArgument = stArgument;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("DeleteSTArgument" + " stArgument" + " owner");

      confirm(owner, "Remove", unused ->
            stArgument.getIncomingArgumentsSTModel().findFirst().ifPresent(stModel -> {
               final String uuid = stArgument.getUuid();
               stModel.removeArguments(stArgument);
               stArgument.getKeyValues().forEach(nextgen.model.STArgumentKV::delete);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(stModel, uuid);
            }));
   }

}