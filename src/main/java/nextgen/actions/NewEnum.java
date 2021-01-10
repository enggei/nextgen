package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class NewEnum extends nextgen.actions.TransactionAction {

   private final STGroupModel stGroup;
   private final JComponent owner;

	public NewEnum(STGroupModel stGroup, JComponent owner) {
		super("New Enum");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("NewEnum" + " stGroup" + " owner");

      input(owner, "New Enum", s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> appModel().addSTEnum(stGroup, name)));
   }

}