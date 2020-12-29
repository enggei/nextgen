package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class NewAction extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupModel stGroup;
   private final javax.swing.JComponent owner;

	public NewAction(nextgen.model.STGroupModel stGroup, javax.swing.JComponent owner) {
		super("Add Action");
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("NewAction" + " stGroup" + " owner");

      input(owner, "New Action", s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> appModel().addSTAction(stGroup, name)));
   }

}