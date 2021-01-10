package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class NewInterface extends nextgen.actions.TransactionAction {

   private final STGroupModel stGroup;
   private final JComponent owner;

	public NewInterface(STGroupModel stGroup, JComponent owner) {
		super("New Interface");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("NewInterface" + " stGroup" + " owner");

      input(owner, "New Interface", s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> appModel().addInterface(stGroup, name)));
   }

}