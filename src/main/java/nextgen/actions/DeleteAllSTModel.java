package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteAllSTModel extends nextgen.actions.TransactionAction {
	private final java.util.List<nextgen.model.STModel> models;
	private final JComponent owner;

	public DeleteAllSTModel(java.util.List<nextgen.model.STModel> models, JComponent owner) {
		super("Delete");
		this.models = models;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteAllSTModel" + " models" + " owner");

      confirm(owner, "Delete " + models.size() + " models", unused -> appModel().delete(models));
   }

}