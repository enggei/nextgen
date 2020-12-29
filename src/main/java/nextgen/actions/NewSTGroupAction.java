package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class NewSTGroupAction extends nextgen.actions.TransactionAction {

   private final javax.swing.JComponent owner;

	public NewSTGroupAction(javax.swing.JComponent owner) {
		super("New STGroup");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("NewSTGroupAction" + " owner");

      input(owner, "Name", name -> {

         final nextgen.model.STGroupModel existing = appModel().findSTGroupModelByName(name);
         if (existing != null) {
            nextgen.utils.SwingUtil.showMessage(name + " group already exists in this directory", owner);
            return;
         }

         if (!javax.lang.model.SourceVersion.isIdentifier(name)) {
            nextgen.utils.SwingUtil.showMessage(name + " is a reserved java keyword", owner);
            return;
         }

         appModel().newSTGroupModel(name);
      });
   }

}