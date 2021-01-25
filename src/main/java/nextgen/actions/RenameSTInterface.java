package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class RenameSTInterface extends nextgen.actions.TransactionAction {
	private final STInterface stInterface;
	private final STGroupModel stGroup;
	private final JComponent owner;

	public RenameSTInterface(STInterface stInterface, STGroupModel stGroup, JComponent owner) {
		super("Rename");
		this.stInterface = stInterface;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("RenameSTInterface" + " stInterface" + " stGroup" + " owner");

      inputName(owner, stInterface.getName(), s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
         stInterface.setName(name);
         nextgen.events.STInterfaceChanged.post(stInterface);
      }));
   }

}