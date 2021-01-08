package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteDomainProperty extends TransactionAction {

   private final nextgen.model.DomainProperty domainProperty;
   private final JComponent owner;

	public DeleteDomainProperty(nextgen.model.DomainProperty domainProperty, JComponent owner) {
		super("DEL");
		this.domainProperty = domainProperty;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteDomainProperty" + " domainProperty" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(domainProperty));
   }

}