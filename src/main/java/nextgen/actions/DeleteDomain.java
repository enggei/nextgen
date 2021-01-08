package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteDomain extends TransactionAction {

   private final nextgen.model.Domain domain;
   private final JComponent owner;

	public DeleteDomain(nextgen.model.Domain domain, JComponent owner) {
		super("DEL");
		this.domain = domain;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteDomain" + " domain" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(domain));
   }

}