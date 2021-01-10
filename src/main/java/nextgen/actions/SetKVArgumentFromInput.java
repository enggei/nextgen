package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetKVArgumentFromInput extends nextgen.actions.TransactionAction {

   private final STModel stModel;
   private final STArgument stArgument;
   private final STParameterKey stParameterKey;
   private final JComponent owner;

	public SetKVArgumentFromInput(STModel stModel, STArgument stArgument, STParameterKey stParameterKey, JComponent owner) {
		super("Set " + stParameterKey.getName() + " from Input");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetKVArgumentFromInput" + " stModel" + " stArgument" + " stParameterKey" + " owner");

      input(owner, stParameterKey.getName(), inputValue -> appModel().setArgumentKV(stModel, stArgument, stParameterKey, inputValue));
   }

}