package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class GenerateAllSTGroups extends nextgen.actions.TransactionAction {

   private final JComponent owner;

	public GenerateAllSTGroups(JComponent owner) {
		super("Generate all");
		setIcon("gen");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("GenerateAllSTGroups" + " owner");

      appModel().getAllSTGroups().forEach(stGroupModel -> new GenerateSTGroup(owner, stGroupModel).actionPerformed(actionEvent, transaction));
   }

}