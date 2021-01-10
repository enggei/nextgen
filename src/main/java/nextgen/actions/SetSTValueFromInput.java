package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetSTValueFromInput extends nextgen.actions.TransactionAction {

   private final STValue stValue;
   private final JComponent owner;

	public SetSTValueFromInput(STValue stValue, JComponent owner) {
		super("Set from Input");
		this.stValue = stValue;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetSTValueFromInput" + " stValue" + " owner");

      input(owner, "Set Value", value -> appModel().setValue(stValue, value));
   }

}