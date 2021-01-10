package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddModelToProject extends nextgen.actions.TransactionAction {

   private final STProject project;
   private final STModel stModel;

	public AddModelToProject(STProject project, STModel stModel) {
		super("Add to Project");
		this.project = project;
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddModelToProject" + " project" + " stModel");

      appModel().addSTModel(project, stModel);
   }

}