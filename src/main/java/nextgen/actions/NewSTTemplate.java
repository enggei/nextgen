package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class NewSTTemplate extends nextgen.actions.TransactionAction {

   private final STGroupModel stGroup;
   private final JComponent owner;

	public NewSTTemplate(STGroupModel stGroup, JComponent owner) {
		super("New Template");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("NewSTTemplate" + " stGroup" + " owner");

      input(owner, "Name", s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> appModel().addTemplate(stGroup, name, "")));
   }

}