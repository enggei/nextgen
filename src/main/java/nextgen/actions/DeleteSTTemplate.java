package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteSTTemplate extends nextgen.actions.TransactionAction {

   private final STTemplate stTemplate;
   private final JComponent owner;

	public DeleteSTTemplate(STTemplate stTemplate, JComponent owner) {
		super("Delete");
		this.stTemplate = stTemplate;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteSTTemplate" + " stTemplate" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stTemplate));
   }

}