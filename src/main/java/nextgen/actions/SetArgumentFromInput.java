package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetArgumentFromInput extends nextgen.actions.TransactionAction {

   private final STModel stModel;
   private final STParameter stParameter;
   private final JComponent owner;

	public SetArgumentFromInput(STModel stModel, STParameter stParameter, JComponent owner) {
		super("Set from Input");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetArgumentFromInput" + " stModel" + " stParameter" + " owner");

      input(owner, stParameter.getName(), inputValue -> appModel().setArgument(stModel, stParameter, inputValue));
      if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
   }

}