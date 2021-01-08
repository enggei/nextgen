package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class STValueToClipboard extends TransactionAction {

   private final STValue stValue;

	public STValueToClipboard(STValue stValue) {
		super("");
		setIcon("cb-set");
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("STValueToClipboard" + " stValue");

      toClipboard(appModel().render(stValue));
   }

}