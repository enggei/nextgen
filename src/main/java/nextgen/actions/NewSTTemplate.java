package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class NewSTTemplate extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewSTTemplate(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("New Template");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("NewSTTemplate" + " stGroup" + " owner");

      input(owner, "Name", s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> appModel().addTemplate(stGroup, name, "")));
   }

}