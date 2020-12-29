package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddFileSinkToGroup extends TransactionAction {

   private final STGroupModel stGroup;

	public AddFileSinkToGroup(STGroupModel stGroup) {
		super("Add File");
		this.stGroup = stGroup;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddFileSinkToGroup" + " stGroup");

      appModel().addSTGroupFile(stGroup);
   }

}