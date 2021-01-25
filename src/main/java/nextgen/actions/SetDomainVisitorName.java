package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetDomainVisitorName extends nextgen.actions.TransactionAction {
	private final DomainVisitor domainVisitor;
	private final JComponent owner;

	public SetDomainVisitorName(DomainVisitor domainVisitor, JComponent owner) {
		super("Set Name");
		this.domainVisitor = domainVisitor;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetDomainVisitorName" + " domainVisitor" + " owner");

      input(owner, "Set Name", s -> appModel().setName(domainVisitor, s));
   }

}