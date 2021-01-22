package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class NewDomainAction extends nextgen.actions.TransactionAction {

   private final JComponent owner;

	public NewDomainAction(JComponent owner) {
		super("New Domain");
      this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
      log.info("NewDomainAction" + " owner");

      input(owner, "Name", name -> {

         appModel().newDomain(name);
      });
   }

}