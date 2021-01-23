package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class NewSTGroup extends nextgen.actions.TransactionAction {

   private final JComponent owner;

	public NewSTGroup(JComponent owner) {
		super("New STGroup");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("NewSTGroupAction" + " owner");

      input(owner, "Name", name -> {

         final STGroupModel existing = appModel().findSTGroupModelByName(name);
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