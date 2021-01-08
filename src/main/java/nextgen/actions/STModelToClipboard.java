package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class STModelToClipboard extends TransactionAction {

   private final STModel stModel;

	public STModelToClipboard(STModel stModel) {
		super("");
		setIcon("cb-set");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("STModelToClipboard" + " stModel");

      toClipboard(appModel().render(stModel));
   }

}