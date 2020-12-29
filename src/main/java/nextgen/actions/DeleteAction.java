package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteAction extends TransactionAction {

   private final STGroupAction stAction;
   private final JComponent owner;
   private final STGroupModel stGroup;

	public DeleteAction(STGroupAction stAction, JComponent owner, STGroupModel stGroup) {
		super("Delete");
		this.stAction = stAction;
		this.owner = owner;
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteAction" + " stAction" + " owner" + " stGroup");

      confirm(owner, "Delete", unused -> appModel().delete(stAction));
   }

}