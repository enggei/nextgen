package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class GenerateSTModels extends TransactionAction {

   private final java.util.List<STModel> stModels;

	public GenerateSTModels(java.util.List<STModel> stModels) {
		super("Generate All");
		this.stModels = stModels;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("GenerateSTModels" + " stModels");

      stModels.forEach(stModel -> appModel().generateSTModel(stModel));
   }

}