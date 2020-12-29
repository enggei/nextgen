package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class ShowSTProjectInCanvas extends TransactionAction {

   private final STProject stProject;

	public ShowSTProjectInCanvas(STProject stProject) {
		super("Open in canvas");
		this.stProject = stProject;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("ShowSTProjectInCanvas" + " stProject");

      nextgen.events.ShowSTProjectInCanvas.post(stProject);
   }

}