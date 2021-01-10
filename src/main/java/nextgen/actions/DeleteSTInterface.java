package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteSTInterface extends nextgen.actions.TransactionAction {

   private final STInterface stInterface;
   private final STGroupModel stGroup;
   private final JComponent owner;

	public DeleteSTInterface(STInterface stInterface, STGroupModel stGroup, JComponent owner) {
		super("Delete");
		this.stInterface = stInterface;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteSTInterface" + " stInterface" + " stGroup" + " owner");

      confirm(owner, "Delete", unused -> appModel().detach(stInterface, stGroup));
   }

}