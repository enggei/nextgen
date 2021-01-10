package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteSTGroup extends nextgen.actions.TransactionAction {

   private final STGroupModel stGroup;
   private final JComponent owner;

	public DeleteSTGroup(STGroupModel stGroup, JComponent owner) {
		super("Delete");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteSTGroup" + " stGroup" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stGroup));
   }

}