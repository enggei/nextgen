package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class GenerateAllSTGroups extends nextgen.actions.TransactionAction {

   private final javax.swing.JComponent owner;

	public GenerateAllSTGroups(javax.swing.JComponent owner) {
		super("Generate all");
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("GenerateAllSTGroups" + " owner");

      appModel().getAllSTGroups().forEach(stGroupModel -> new GenerateSTGroup(owner, stGroupModel).actionPerformed(actionEvent, transaction));
   }

}