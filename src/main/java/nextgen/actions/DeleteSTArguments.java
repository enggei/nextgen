package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class DeleteSTArguments extends nextgen.actions.TransactionAction {

   private final javax.swing.JComponent owner;
   private final nextgen.model.STParameter stParameter;
   private final nextgen.model.STModel stModel;

	public DeleteSTArguments(javax.swing.JComponent owner, nextgen.model.STParameter stParameter, nextgen.model.STModel stModel) {
		super("Delete All");
		this.owner = owner;
		this.stParameter = stParameter;
		this.stModel = stModel;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("DeleteSTArguments" + " owner" + " stParameter" + " stModel");

      confirm(owner, "Remove All", unused -> appModel().detach(stModel, stParameter));
   }

}