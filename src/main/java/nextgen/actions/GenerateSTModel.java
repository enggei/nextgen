package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class GenerateSTModel extends TransactionAction {

   private final STModel stModel;

	public GenerateSTModel(STModel stModel) {
		super("Generate");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("GenerateSTModel" + " stModel");

      appModel().generateSTModel(stModel);
   }

}