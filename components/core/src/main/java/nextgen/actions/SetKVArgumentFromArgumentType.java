package nextgen.actions;

public class SetKVArgumentFromArgumentType extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.model.STArgument stArgument;
   private final nextgen.st.model.STParameterKey stParameterKey;
   private final javax.swing.JComponent owner;

	public SetKVArgumentFromArgumentType(nextgen.st.model.STModel stModel, nextgen.st.model.STArgument stArgument, nextgen.st.model.STParameterKey stParameterKey, javax.swing.JComponent owner) {
		super("Set " + stParameterKey.getName());
		this.stModel = stModel;
		this.stArgument = stArgument;
		this.stParameterKey = stParameterKey;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String argumentType = stParameterKey.getArgumentType();

      if (argumentType.equals("Object") || argumentType.equals("String")) {

         final java.util.Optional<nextgen.st.model.STTemplate> stTemplate = stModel.getArguments()
               .filter(stArgument -> stArgument.getStParameter().equals(stParameterKey.getUuid()))
               .map(nextgen.st.model.STArgument::getValue)
               .filter(nextgen.st.model.STValue::hasType)
               .filter(stValue -> stValue.getType() == nextgen.st.model.STValueType.STMODEL)
               .map(stValue -> appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()))
               .findFirst();

         if (stTemplate.isPresent()) {
            removeExisting();
            final nextgen.st.model.STGroupModel stGroupModel = appModel().findSTGroupModel(stTemplate.get());
            final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, stTemplate.get());
            addValue(appModel().db.newSTValue(stTemplateModel));
         } else {
            input(owner, "New value", s -> {
               removeExisting();
               addValue(appModel().db.newSTValue(s));
            });
         }

      } else {

         final nextgen.st.model.STGroupModel stGroupModel = appModel().findSTGroupModelByTemplateUuid(stModel.getStTemplate());
         final java.util.Optional<nextgen.st.model.STTemplate> stTemplate = appModel()
               .aggregateTemplates(stGroupModel)
               .filter(candidate -> candidate.getName().toLowerCase().equals(argumentType.toLowerCase()))
               .findAny();

         if (stTemplate.isPresent()) {
            removeExisting();
            final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, stTemplate.get());
            addValue(appModel().db.newSTValue(stTemplateModel));
         } else {
            final java.util.Set<nextgen.st.model.STTemplate> interfaces = appModel().findSTTemplatesByInterface(argumentType, stGroupModel);
            if (!interfaces.isEmpty()) {
               if (interfaces.size() == 1) {
                  removeExisting();
                  final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, interfaces.iterator().next());
                  addValue(appModel().db.newSTValue(stTemplateModel));
               } else {
                  select(owner, interfaces, value -> {
                     removeExisting();
                     final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, value);
                     addValue(appModel().db.newSTValue(stTemplateModel));
                  });   
               }

            } else {
               final nextgen.st.model.STEnum stEnum = nextgen.utils.STModelUtil.findSTEnumByName(argumentType, stGroupModel);
               if (stEnum != null) {
                  select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> {
                     removeExisting();
                     addValue(appModel().db.newSTValue(value));
                  });
               } else {
                  input(owner, "New value", s -> {
                     removeExisting();
                     addValue(appModel().db.newSTValue(s));
                  });
               }
            }
         }
      }
   }

   private void removeExisting() {
      stArgument.getKeyValues()
            .filter(existing -> existing.getStParameterKey().equals(stParameterKey.getUuid()))
            .findFirst()
            .ifPresent(existing -> {
               stArgument.removeKeyValues(existing);
               final String uuid = existing.getUuid();
               existing.delete();
               nextgen.events.KVDeleted.post(stModel, stArgument, uuid);
            });
   }

   private void addValue(nextgen.st.model.STValue stValue) {
      final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV(stParameterKey, stValue);
      stArgument.addKeyValues(stArgumentKV);

      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
   }
}