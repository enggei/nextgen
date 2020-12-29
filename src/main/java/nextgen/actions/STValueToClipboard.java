package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class STValueToClipboard extends nextgen.actions.TransactionAction {

   private final nextgen.model.STValue stValue;

	public STValueToClipboard(nextgen.model.STValue stValue) {
		super("T-CP");
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("STValueToClipboard" + " stValue");

      toClipboard(appModel().render(stValue));
   }

}