package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class NewSTModel extends nextgen.actions.TransactionAction {

   private final STTemplate stTemplate;

	public NewSTModel(STTemplate stTemplate) {
		super("New instance");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("NewSTModelAction" + " stTemplate");

      final STModel stModel = appModel().newSTModel(stTemplate);
      nextgen.events.NewSTModel.post(stModel, appModel().getSTGroup(stTemplate), stTemplate);
   }

}