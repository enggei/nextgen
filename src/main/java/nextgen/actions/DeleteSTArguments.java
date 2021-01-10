package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class DeleteSTArguments extends nextgen.actions.TransactionAction {

   private final JComponent owner;
   private final STParameter stParameter;
   private final STModel stModel;

	public DeleteSTArguments(JComponent owner, STParameter stParameter, STModel stModel) {
		super("Delete All");
		this.owner = owner;
		this.stParameter = stParameter;
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("DeleteSTArguments" + " owner" + " stParameter" + " stModel");

      confirm(owner, "Remove All", unused -> appModel().detach(stModel, stParameter));
   }

}