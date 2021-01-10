package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class RenameSTGroup extends nextgen.actions.TransactionAction {

   private final STGroupModel stGroup;
   private final JComponent owner;

	public RenameSTGroup(STGroupModel stGroup, JComponent owner) {
		super("Rename");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("RenameSTGroup" + " stGroup" + " owner");

      inputName(owner, stGroup.getName(), s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
         stGroup.setName(name);
         nextgen.events.STGroupNameChanged.post(stGroup);
      }));
   }

}