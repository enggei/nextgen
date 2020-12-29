package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class CopyInto extends TransactionAction {

   private final STModel thisModel;
   private final STModel otherModel;

	public CopyInto(STModel thisModel, STModel otherModel) {
		super("Copy from " + nextgen.swing.STAppPresentationModel.getSTModelName(otherModel, otherModel.getUuid()));
		this.thisModel = thisModel;
		this.otherModel = otherModel;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("CopyInto" + " thisModel" + " otherModel");

      appModel().copyInto(thisModel, otherModel);
   }

}