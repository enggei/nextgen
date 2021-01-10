package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddArgumentFromSTValue extends nextgen.actions.TransactionAction {

   private final STModel stModel;
   private final STParameter stParameter;
   private final STValue stValue;

	public AddArgumentFromSTValue(String name, STModel stModel, STParameter stParameter, STValue stValue) {
      super(name);
      this.stModel = stModel;
      this.stParameter = stParameter;
      this.stValue = stValue;
   }

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddArgumentFromSTValue" + " stModel" + " stParameter" + " stValue");

      appModel().addArgument(stModel, stParameter, stValue);
   }

}