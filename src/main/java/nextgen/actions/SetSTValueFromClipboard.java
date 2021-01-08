package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetSTValueFromClipboard extends TransactionAction {

   private final STValue stValue;

	public SetSTValueFromClipboard(STValue stValue) {
		super("");
		setIcon("cb-get");
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetSTValueFromClipboard" + " stValue");

      appModel().setValue(stValue, fromClipboard());
   }

}