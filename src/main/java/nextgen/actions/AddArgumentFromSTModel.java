package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddArgumentFromSTModel extends TransactionAction {

   private final STModel stModel;
   private final STParameter stParameter;
   private final STModel value;

	public AddArgumentFromSTModel(String name, STModel stModel, STParameter stParameter, STModel value) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.value = value;
   }

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddArgumentFromSTModel" + " stModel" + " stParameter" + " value");

      appModel().addArgument(stModel, stParameter, value);
   }

}