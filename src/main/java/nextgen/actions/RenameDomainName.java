package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class RenameDomainName extends nextgen.actions.TransactionAction {

   private final Domain domain;
   private final JComponent owner;

	public RenameDomainName(Domain domain, JComponent owner) {
		super("Set from Input");
		this.domain = domain;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetDomainName" + " domain" + " owner");

      input(owner, "Set Name", s -> appModel().setName(domain, s));
   }

}