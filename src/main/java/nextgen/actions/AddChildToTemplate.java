package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddChildToTemplate extends nextgen.actions.TransactionAction {

   private final STTemplate stTemplate;
   private final STGroupModel stGroup;
   private final JComponent owner;

	public AddChildToTemplate(STTemplate stTemplate, STGroupModel stGroup, JComponent owner) {
		super("Add Child template");
		this.stTemplate = stTemplate;
		this.stGroup = stGroup;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddChildToTemplate" + " stTemplate" + " stGroup" + " owner");

      input(owner, "Name", s -> appModel().isValidTemplateName(owner, stGroup, s).ifPresent(name -> appModel().addChild(stTemplate, name)));
   }

}