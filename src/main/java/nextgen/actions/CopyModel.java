package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class CopyModel extends TransactionAction {

   private final STModel stModel;

	public CopyModel(STModel stModel) {
		super("Copy Model");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("CopyModel" + " stModel");

      appModel().copy(stModel);
   }

}