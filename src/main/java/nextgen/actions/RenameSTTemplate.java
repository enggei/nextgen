package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class RenameSTTemplate extends nextgen.actions.TransactionAction {
	private final STTemplate stTemplate;
	private final STGroupModel stGroup;
	private final JComponent owner;

	public RenameSTTemplate(STTemplate stTemplate, STGroupModel stGroup, JComponent owner) {
		super("Rename");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("RenameSTTemplate" + " stTemplate" + " stGroup" + " owner");

      inputName(owner, stTemplate.getName(), s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
         stTemplate.setName(name);
         nextgen.events.STTemplateChanged.post(stTemplate);
      }));
   }

}