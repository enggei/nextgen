package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteEnum extends nextgen.actions.TransactionAction {

   private final STEnum stEnum;
   private final STGroupModel stGroup;
   private final JComponent owner;

	public DeleteEnum(STEnum stEnum, STGroupModel stGroup, JComponent owner) {
		super("Delete");
		this.stEnum = stEnum;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteEnum" + " stEnum" + " stGroup" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stEnum));
   }

}