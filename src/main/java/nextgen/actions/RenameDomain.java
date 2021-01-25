package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class RenameDomain extends nextgen.actions.TransactionAction {
	private final Domain domain;
	private final JComponent owner;

	public RenameDomain(Domain domain, JComponent owner) {
		super("Set name");
		this.domain = domain;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("RenameDomain" + " domain" + " owner");

      input(owner, "Set Name", s -> appModel().setName(domain, s));
   }

}