package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class ShowSTModelInCanvas extends nextgen.actions.TransactionAction {

   private final STModel stModel;

	public ShowSTModelInCanvas(STModel stModel) {
		super("Open in canvas");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("ShowSTModelInCanvas" + " stModel");

      nextgen.events.ShowSTModelInCanvas.post(stModel);
   }

}