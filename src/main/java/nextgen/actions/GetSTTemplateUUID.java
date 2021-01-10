package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class GetSTTemplateUUID extends nextgen.actions.TransactionAction {

   private final STTemplate stTemplate;

	public GetSTTemplateUUID(STTemplate stTemplate) {
		super("Get UUID");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("GetSTTemplateUUID" + " stTemplate");

      toClipboard(stTemplate.getUuid());
   }

}