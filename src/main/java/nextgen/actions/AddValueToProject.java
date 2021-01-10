package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddValueToProject extends nextgen.actions.TransactionAction {

   private final STProject project;
   private final STValue stValue;

	public AddValueToProject(STProject project, STValue stValue) {
		super("Add to Project");
		this.project = project;
		this.stValue = stValue;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddValueToProject" + " project" + " stValue");

      project.addValues(stValue);
      nextgen.events.NewSTProjectSTValue.post(stValue, project);
   }

}