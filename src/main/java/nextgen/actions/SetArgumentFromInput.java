package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class SetArgumentFromInput extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public SetArgumentFromInput(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, javax.swing.JComponent owner) {
		super("Set from Input");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("SetArgumentFromInput" + " stModel" + " stParameter" + " owner");

      input(owner, stParameter.getName(), inputValue -> appModel().setArgument(stModel, stParameter, inputValue));
      if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
   }

}