package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class CopyModel extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;

	public CopyModel(nextgen.model.STModel stModel) {
		super("Copy Model");
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("CopyModel" + " stModel");

      appModel().copy(stModel);
   }

}