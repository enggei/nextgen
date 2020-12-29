package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetKVArgumentFromSTValue extends TransactionAction {

   private final STModel stModel;
   private final STArgument stArgument;
   private final STParameterKey stParameterKey;
   private final STValue stValue;

	public SetKVArgumentFromSTValue(STModel stModel, STArgument stArgument, STParameterKey stParameterKey, STValue stValue) {
		super("Set " + stParameterKey.getName() + " from STValue");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetKVArgumentFromSTValue" + " stModel" + " stArgument" + " stParameterKey" + " stValue");

      appModel().setArgumentKV(stModel, stArgument, stParameterKey, stValue);
   }

}