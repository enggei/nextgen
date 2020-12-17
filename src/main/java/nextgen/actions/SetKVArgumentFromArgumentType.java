package nextgen.actions;

public class SetKVArgumentFromArgumentType extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STArgument stArgument;
   private final nextgen.model.STParameterKey stParameterKey;
   private final javax.swing.JComponent owner;

	public SetKVArgumentFromArgumentType(nextgen.model.STModel stModel, nextgen.model.STArgument stArgument, nextgen.model.STParameterKey stParameterKey, javax.swing.JComponent owner) {
		super("Set " + stParameterKey.getName());
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("SetKVArgumentFromArgumentType" + " stModel" + " stArgument" + " stParameterKey" + " owner");

      final String argumentType = stParameterKey.getArgumentType();
      final nextgen.model.STParameter stParameter = stArgument.getStParameter();

      final boolean argumentIsDefault = argumentType.equals("Object") || argumentType.equals("String");
      if (argumentIsDefault) {
         final java.util.Optional<nextgen.model.STTemplate> stTemplate = appModel().findFirstTemplateInArguments(stModel, stParameter);
         if (stTemplate.isPresent())
            appModel().setArgumentKV(stModel, stArgument, stParameterKey, appModel().newSTValue(stTemplate.get()));
         else
            input(owner, "New value", s -> appModel().setArgumentKV(stModel, stArgument, stParameterKey, s));
         return;
      }

      final nextgen.model.STGroupModel stGroupModel = appModel().getSTGroup(stModel);
      final java.util.Optional<nextgen.model.STTemplate> stTemplate = appModel().findSTTemplateFromArgumentType(argumentType, stGroupModel);
      if (stTemplate.isPresent()) {

         final nextgen.model.ModelTypes.STModelList stModelList = appModel().getModelsFor(stTemplate.get());
         if (stModelList.isEmpty())
            appModel().setArgumentKV(stModel, stArgument, stParameterKey, appModel().newSTValue(stTemplate.get()));
         else
            showEditor(owner, getSelectOrAddSTModelValue(stTemplate.get(), stModelList), (dialog, model) -> {
               appModel().setArgumentKV(stModel, stArgument, stParameterKey, model);
               dialog.dispose();
            });
         return;
      }

      final nextgen.model.ModelTypes.STTemplateSet stTemplatesWithInterface = appModel().findSTTemplatesWithInterface(argumentType, stGroupModel);
      if (stTemplatesWithInterface.isEmpty()) {

         final nextgen.model.STEnum stEnum = appModel().findSTEnumByName(argumentType, stGroupModel);
         if (stEnum == null)
            input(owner, "New value", s -> appModel().setArgumentKV(stModel, stArgument, stParameterKey, s));
         else
            select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> appModel().setArgumentKV(stModel, stArgument, stParameterKey, value));
         return;
      }

      if (stTemplatesWithInterface.size() > 1)
         selectAndRender(owner, stTemplatesWithInterface, (nextgen.model.STTemplate::getName), stTemplatesWithInterface.iterator().next(), model -> appModel().setArgumentKV(stModel, stArgument, stParameterKey, model));
      else
         appModel().setArgumentKV(stModel, stArgument, stParameterKey, stTemplatesWithInterface.iterator().next());
   }

}