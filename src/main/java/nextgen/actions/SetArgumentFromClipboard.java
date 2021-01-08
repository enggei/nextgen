package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetArgumentFromClipboard extends TransactionAction {

   private final STModel stModel;
   private final STParameter stParameter;

	public SetArgumentFromClipboard(STModel stModel, STParameter stParameter) {
		super("");
		setIcon("cb-get");
		this.stModel = stModel;
		this.stParameter = stParameter;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetArgumentFromClipboard" + " stModel" + " stParameter");

      appModel().setArgument(stModel, stParameter, fromClipboard());
      if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
   }

}