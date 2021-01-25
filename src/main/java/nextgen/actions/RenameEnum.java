package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class RenameEnum extends nextgen.actions.TransactionAction {
	private final STEnum stEnum;
	private final STGroupModel stGroup;
	private final JComponent owner;

	public RenameEnum(STEnum stEnum, STGroupModel stGroup, JComponent owner) {
		super("Rename");
		this.stEnum = stEnum;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("RenameEnum" + " stEnum" + " stGroup" + " owner");

      inputName(owner, stEnum.getName(), s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
      	stEnum.setName(name);
      	nextgen.events.STEnumChanged.post(stEnum);
      }));
   }

}