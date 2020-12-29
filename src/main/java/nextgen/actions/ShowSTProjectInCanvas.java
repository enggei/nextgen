package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class ShowSTProjectInCanvas extends nextgen.actions.TransactionAction {

   private final nextgen.model.STProject stProject;

	public ShowSTProjectInCanvas(nextgen.model.STProject stProject) {
		super("Open in canvas");
		this.stProject = stProject;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("ShowSTProjectInCanvas" + " stProject");

      nextgen.events.ShowSTProjectInCanvas.post(stProject);
   }

}