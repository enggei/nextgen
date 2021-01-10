package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class NewAction extends nextgen.actions.TransactionAction {

   private final STGroupModel stGroup;
   private final JComponent owner;

	public NewAction(STGroupModel stGroup, JComponent owner) {
		super("Add Action");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("NewAction" + " stGroup" + " owner");

      input(owner, "New Action", s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> appModel().addSTAction(stGroup, name)));
   }

}