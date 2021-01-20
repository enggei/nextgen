package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteDomainVisitor extends nextgen.actions.TransactionAction {

   private final nextgen.model.DomainVisitor domainVisitor;
   private final JComponent owner;

	public DeleteDomainVisitor(nextgen.model.DomainVisitor domainVisitor, JComponent owner) {
		super("DEL");
		this.domainVisitor = domainVisitor;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteDomainVisitor" + " domainVisitor" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(domainVisitor));
   }

}