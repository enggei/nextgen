package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddArgumentFromSTTemplate extends nextgen.actions.TransactionAction {

   private final STModel stModel;
   private final STParameter stParameter;
   private final STTemplate stTemplate;

	public AddArgumentFromSTTemplate(String name, STModel stModel, STParameter stParameter, STTemplate stTemplate) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.stTemplate = stTemplate;
   }

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddArgumentFromSTTemplate" + " stModel" + " stParameter" + " stTemplate");

      appModel().addArgument(stModel, stParameter, stTemplate);
   }

}