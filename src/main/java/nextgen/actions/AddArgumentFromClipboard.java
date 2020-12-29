package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class AddArgumentFromClipboard extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;

	public AddArgumentFromClipboard(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter) {
		super("Add from Clipboard");
		this.stModel = stModel;
		this.stParameter = stParameter;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("AddArgumentFromClipboard" + " stModel" + " stParameter");

      appModel().addArgument(stModel, stParameter, fromClipboard());
   }

}