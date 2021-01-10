package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteDomainRelation extends nextgen.actions.TransactionAction {

   private final nextgen.model.DomainRelation domainRelation;
   private final JComponent owner;

	public DeleteDomainRelation(nextgen.model.DomainRelation domainRelation, JComponent owner) {
		super("DEL");
		this.domainRelation = domainRelation;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteDomainRelation" + " domainRelation" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(domainRelation));
   }

}