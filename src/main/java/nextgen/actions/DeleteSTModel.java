package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteSTModel extends nextgen.actions.TransactionAction {

   private final STModel stModel;
   private final JComponent owner;

	public DeleteSTModel(STModel stModel, JComponent owner) {
		super("Delete");
		this.stModel = stModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteSTModel" + " stModel" + " owner");

      confirm(owner, "Delete", unused -> appModel().delete(stModel));
   }

}