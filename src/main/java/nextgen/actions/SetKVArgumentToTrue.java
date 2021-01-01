package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetKVArgumentToTrue extends TransactionAction {

   private final STModel stModel;
   private final STArgumentKV stArgumentKV;

	public SetKVArgumentToTrue(STModel stModel, STArgumentKV stArgumentKV) {
		super("Set to true");
		this.stModel = stModel;
		this.stArgumentKV = stArgumentKV;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetKVArgumentToTrue" + " stModel" + " stArgumentKV");

      appModel().updateSTArgument(stModel, stArgumentKV, "true");
   }

}