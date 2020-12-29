package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class CopyTemplate extends nextgen.actions.TransactionAction {

   private final nextgen.model.STTemplate stTemplate;

	public CopyTemplate(nextgen.model.STTemplate stTemplate) {
		super("Copy");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("CopyTemplate" + " stTemplate");

      toClipboard(stTemplate.getText());
   }

}