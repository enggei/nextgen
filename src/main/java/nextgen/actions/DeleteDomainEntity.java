package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteDomainEntity extends TransactionAction {

   private final nextgen.model.DomainEntity domainEntity;
   private final JComponent owner;

	public DeleteDomainEntity(nextgen.model.DomainEntity domainEntity, JComponent owner) {
		super("DEL");
		this.domainEntity = domainEntity;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteDomainEntity" + " domainEntity" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(domainEntity));
   }

}