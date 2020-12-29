package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class SetSTValueFromInput extends nextgen.actions.TransactionAction {

   private final nextgen.model.STValue stValue;
   private final javax.swing.JComponent owner;

	public SetSTValueFromInput(nextgen.model.STValue stValue, javax.swing.JComponent owner) {
		super("Set from Input");
		this.stValue = stValue;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("SetSTValueFromInput" + " stValue" + " owner");

      input(owner, "Set Value", value -> appModel().setValue(stValue, value));
   }

}