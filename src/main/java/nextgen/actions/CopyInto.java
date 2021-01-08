package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class CopyInto extends TransactionAction {

   private final STModel thisModel;
   private final STModel otherModel;
   private final JComponent owner;

	public CopyInto(STModel thisModel, STModel otherModel, JComponent owner) {
		super("Copy from " + nextgen.swing.STAppPresentationModel.getSTModelName(otherModel, otherModel.getUuid()));
		this.thisModel = thisModel;
		this.otherModel = otherModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("CopyInto" + " thisModel" + " otherModel" + " owner");

      final String thisName = nextgen.swing.STAppPresentationModel.getSTModelName(thisModel, null);
      final String otherName = nextgen.swing.STAppPresentationModel.getSTModelName(otherModel, null);

      if (otherName != null && thisName == null)
         inputName(owner, otherName, s -> nextgen.swing.STAppPresentationModel.getSTParameters(thisModel)
               .filter(parameterArguments -> parameterArguments.parameter().getName().equals("name"))
               .findAny()
               .ifPresent(parameterArguments -> {
                  appModel().setArgument(thisModel, parameterArguments.parameter(), s);
                  appModel().copyInto(thisModel, otherModel);
                  appModel().replaceAllSTValues(thisModel, otherName, s);
               }));
      else
         appModel().copyInto(thisModel, otherModel);
   }

}