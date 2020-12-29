package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddArgumentFromArgumentType extends TransactionAction {

   private final STModel stModel;
   private final STParameter stParameter;
   private final JComponent owner;

	public AddArgumentFromArgumentType(STModel stModel, STParameter stParameter, JComponent owner) {
		super("ADD");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddArgumentFromArgumentType" + " stModel" + " stParameter" + " owner");

      final String argumentType = stParameter.getArgumentType();

      final boolean argumentIsDefault = argumentType.equals("Object") || argumentType.equals("String");
      if (argumentIsDefault) {
         final java.util.Optional<STTemplate> stTemplate = appModel().findFirstTemplateInArguments(stModel, stParameter);
         if (stTemplate.isPresent())
            appModel().addArgument(stModel, stParameter, appModel().newSTValue(stTemplate.get()));
         else
            input(owner, "New value", s -> appModel().addArgument(stModel, stParameter, s));
         return;
      }

      final STGroupModel stGroupModel = appModel().getSTGroup(stModel);
      final java.util.Optional<STTemplate> stTemplate = appModel().findSTTemplateFromArgumentType(argumentType, stGroupModel);
      if (stTemplate.isPresent()) {

         final java.util.List<STModel> stModelList = appModel().getModelsFor(stTemplate.get());
         if (stModelList.isEmpty())
            appModel().addArgument(stModel, stParameter, appModel().newSTValue(stTemplate.get()));
         else
            showEditor(owner, getSelectOrAddSTModelValue(stTemplate.get(), stModelList), (dialog, model) -> {
               appModel().addArgument(stModel, stParameter, model);
               dialog.dispose();
            });
         return;
      }

      final java.util.Set<STTemplate> stTemplatesWithInterface = appModel().findSTTemplatesWithInterface(argumentType, stGroupModel);
      if (stTemplatesWithInterface.isEmpty()) {

         final STEnum stEnum = appModel().findSTEnumByName(argumentType, stGroupModel);
         if (stEnum == null)
            input(owner, "New value", s -> appModel().addArgument(stModel, stParameter, s));
         else
            select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> appModel().addArgument(stModel, stParameter, value));
         return;
      }

      if (stTemplatesWithInterface.size() > 1)
         selectAndRender(owner, stTemplatesWithInterface, (STTemplate::getName), stTemplatesWithInterface.iterator().next(), model -> appModel().addArgument(stModel, stParameter, model));
      else
         appModel().addArgument(stModel, stParameter, stTemplatesWithInterface.iterator().next());
   }

}