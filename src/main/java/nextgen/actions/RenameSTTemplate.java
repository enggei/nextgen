package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class RenameSTTemplate extends nextgen.actions.TransactionAction {

   private final nextgen.model.STTemplate stTemplate;
   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public RenameSTTemplate(nextgen.model.STTemplate stTemplate, nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Rename");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("RenameSTTemplate" + " stTemplate" + " stGroup" + " owner");

      inputName(owner, stTemplate.getName(), s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> {
         stTemplate.setName(name);
         nextgen.events.STTemplateNameChanged.post(stGroup, stTemplate);
      }));
   }

}