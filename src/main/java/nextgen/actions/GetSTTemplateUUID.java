package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class GetSTTemplateUUID extends nextgen.actions.TransactionAction {

   private final nextgen.model.STTemplate stTemplate;

	public GetSTTemplateUUID(nextgen.model.STTemplate stTemplate) {
		super("Get UUID");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("GetSTTemplateUUID" + " stTemplate");

      toClipboard(stTemplate.getUuid());
   }

}