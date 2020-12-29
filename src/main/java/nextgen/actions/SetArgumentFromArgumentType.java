package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;

public class SetArgumentFromArgumentType extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public SetArgumentFromArgumentType(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, javax.swing.JComponent owner) {
		super("SET");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("SetArgumentFromArgumentType" + " stModel" + " stParameter" + " owner");

      final String argumentType = stParameter.getArgumentType();

      final boolean argumentIsDefault = argumentType.equals("Object") || argumentType.equals("String");
      if (argumentIsDefault) {
      	final java.util.Optional<nextgen.model.STTemplate> stTemplate = appModel().findFirstTemplateInArguments(stModel, stParameter);
      	if (stTemplate.isPresent())
      		appModel().setArgument(stModel, stParameter, appModel().newSTValue(stTemplate.get()));
      	else
      		input(owner, "New value", s -> appModel().setArgument(stModel, stParameter, s));
      	return;
      }

      final nextgen.model.STGroupModel stGroupModel = appModel().getSTGroup(stModel);
      final java.util.Optional<nextgen.model.STTemplate> stTemplate = appModel().findSTTemplateFromArgumentType(argumentType, stGroupModel);
      if (stTemplate.isPresent()) {

      	final java.util.List<nextgen.model.STModel> stModelList = appModel().getModelsFor(stTemplate.get());
      	if (stModelList.isEmpty())
      		appModel().setArgument(stModel, stParameter, appModel().newSTValue(stTemplate.get()));
      	else
      		showEditor(owner, getSelectOrAddSTModelValue(stTemplate.get(), stModelList), (dialog, model) -> {
      			appModel().setArgument(stModel, stParameter, model);
      			dialog.dispose();
      		});
      	return;
      }

      final java.util.Set<nextgen.model.STTemplate> stTemplatesWithInterface = appModel().findSTTemplatesWithInterface(argumentType, stGroupModel);
      if (stTemplatesWithInterface.isEmpty()) {

      	final nextgen.model.STEnum stEnum = appModel().findSTEnumByName(argumentType, stGroupModel);
      	if (stEnum == null)
      		input(owner, "New value", s -> appModel().setArgument(stModel, stParameter, s));
      	else
      		select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> appModel().setArgument(stModel, stParameter, value));
      	return;
      }

      if (stTemplatesWithInterface.size() > 1)
      	selectAndRender(owner, stTemplatesWithInterface, (nextgen.model.STTemplate::getName), stTemplatesWithInterface.iterator().next(), model -> appModel().setArgument(stModel, stParameter, model));
      else
      	appModel().setArgument(stModel, stParameter, stTemplatesWithInterface.iterator().next());
   }

}