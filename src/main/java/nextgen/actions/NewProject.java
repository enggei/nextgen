package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class NewProject extends TransactionAction {

   private final JComponent owner;

	public NewProject(JComponent owner) {
		super("New Project");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("NewProject" + " owner");

      input(owner, "Name", s -> appModel().newSTProject(s));
   }

}