package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class ReplaceAllSTValues extends TransactionAction {

   private final STModel thisModel;
   private final JComponent owner;

	public ReplaceAllSTValues(STModel thisModel, JComponent owner) {
		super("Replace all Values");
		this.thisModel = thisModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("ReplaceAllSTValues" + " thisModel" + " owner");

      input(owner, "[old] [new]", s -> appModel().replaceAllSTValues(thisModel, s.split("[ ]")[0], s.split("[ ]")[1]));
   }

}