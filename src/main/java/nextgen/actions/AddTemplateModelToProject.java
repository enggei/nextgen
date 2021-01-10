package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddTemplateModelToProject extends nextgen.actions.TransactionAction {

   private final STTemplate stTemplate;
   private final STProject project;

	public AddTemplateModelToProject(String name, STTemplate stTemplate, STProject project) {
      super(name);
      this.stTemplate = stTemplate;
      this.project = project;
   }

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddTemplateModelToProject" + " stTemplate" + " project");

      appModel().addSTModel(project, stTemplate);
   }

}