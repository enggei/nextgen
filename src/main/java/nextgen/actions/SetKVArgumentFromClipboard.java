package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetKVArgumentFromClipboard extends TransactionAction {

   private final STModel stModel;
   private final STArgument stArgument;
   private final STParameterKey stParameterKey;

	public SetKVArgumentFromClipboard(STModel stModel, STArgument stArgument, STParameterKey stParameterKey) {
		super("FROM");
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetKVArgumentFromClipboard" + " stModel" + " stArgument" + " stParameterKey");

      appModel().setArgumentKV(stModel, stArgument, stParameterKey, fromClipboard());
   }

}