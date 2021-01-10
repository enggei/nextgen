package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetArgumentToTrue extends nextgen.actions.TransactionAction {

   private final STModel stModel;
   private final STParameter stParameter;

	public SetArgumentToTrue(STModel stModel, STParameter stParameter) {
		super("Set to true");
		this.stModel = stModel;
		this.stParameter = stParameter;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetArgumentToTrue" + " stModel" + " stParameter");

      appModel().setArgument(stModel, stParameter, true);
   }

}