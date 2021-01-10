package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetArgumentKVFromSTTemplate extends nextgen.actions.TransactionAction {

   private final STModel stModel;
   private final STTemplate stTemplate;
   private final STParameterKey stParameterKey;
   private final STArgument stArgument;

	public SetArgumentKVFromSTTemplate(String name, STModel stModel, STTemplate stTemplate, STParameterKey stParameterKey, STArgument stArgument) {
      super(name);
      this.stModel = stModel;
      this.stTemplate = stTemplate;
      this.stParameterKey = stParameterKey;
      this.stArgument = stArgument;
   }

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetArgumentKVFromSTTemplate" + " stModel" + " stTemplate" + " stParameterKey" + " stArgument");

      appModel().setArgumentKV(stModel, stArgument,stParameterKey, stTemplate);
   }

}