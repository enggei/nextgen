package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class CopyTemplate extends TransactionAction {

   private final STTemplate stTemplate;

	public CopyTemplate(STTemplate stTemplate) {
		super("Copy");
		this.stTemplate = stTemplate;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("CopyTemplate" + " stTemplate");

      toClipboard(stTemplate.getText());
   }

}