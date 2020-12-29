package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetKVArgumentFromSTModel extends TransactionAction {

   private final STModel stModel;
   private final STArgument stArgument;
   private final STParameterKey stParameterKey;
   private final STModel value;

	public SetKVArgumentFromSTModel(STModel stModel, STArgument stArgument, STParameterKey stParameterKey, STModel value) {
		super("Set " + stParameterKey.getName() + " from STModel");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.value = value;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetKVArgumentFromSTModel" + " stModel" + " stArgument" + " stParameterKey" + " value");

      appModel().setArgumentKV(stModel, stArgument, stParameterKey, value);
   }

}