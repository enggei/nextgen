package nextgen.actions;

public class SetArgumentFromArgumentType extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public SetArgumentFromArgumentType(nextgen.st.model.STModel stModel, nextgen.st.domain.STParameter stParameter, javax.swing.JComponent owner) {
		super("Set");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String argumentType = stParameter.getArgumentType();

      if (argumentType.equals("Object") || argumentType.equals("String")) {

         final java.util.Optional<nextgen.st.domain.STTemplate> stTemplate = stModel.getArguments()
               .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
               .map(nextgen.st.model.STArgument::getValue)
               .filter(nextgen.st.model.STValue::hasType)
               .filter(stValue -> stValue.getType() == nextgen.st.model.STValueType.STMODEL)
               .map(stValue -> appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()))
               .findFirst();

         if (stTemplate.isPresent()) {
            removeExisting();
            final nextgen.st.domain.STGroupModel stGroupModel = appModel().findSTGroupModel(stTemplate.get());
            final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, stTemplate.get());
            final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
            addValue(stValue);
         } else {
            input(owner, "New value", s -> {
               removeExisting();
               final nextgen.st.model.STValue stValue = appModel().db.newSTValue(s);
               addValue(stValue);
            });
         }

      } else {

         final nextgen.st.domain.STGroupModel stGroupModel = appModel().findSTGroupModelByTemplateUuid(stModel.getStTemplate());
         final java.util.Optional<nextgen.st.domain.STTemplate> stTemplate = appModel()
               .aggregateTemplates(stGroupModel)
               .filter(candidate -> candidate.getName().toLowerCase().equals(argumentType.toLowerCase()))
               .findAny();

         if (stTemplate.isPresent()) {
            removeExisting();
            final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, stTemplate.get());
            final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
            addValue(stValue);
         } else {
            final java.util.Set<nextgen.st.domain.STTemplate> interfaces = appModel().findSTTemplatesByInterface(argumentType, stGroupModel);
            if (!interfaces.isEmpty()) {
               if (interfaces.size() == 1) {
                  removeExisting();
                  final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, interfaces.iterator().next());
                  final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
                  addValue(stValue);
               } else {
                  select(owner, interfaces, value -> {
                     removeExisting();
                     final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel(stGroupModel, value);
                     final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
                     addValue(stValue);
                  });   
               }

            } else {
               final nextgen.st.domain.STEnum stEnum = nextgen.utils.STModelUtil.findSTEnumByName(argumentType, stGroupModel);
               if (stEnum != null) {
                  select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> {
                     removeExisting();
                     final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);
                     addValue(stValue);
                  });
               } else {
                  input(owner, "New value", s -> {
                     removeExisting();
                     final nextgen.st.model.STValue stValue = appModel().db.newSTValue(s);
                     addValue(stValue);
                  });
               }
            }
         }
      }
   }

   private void removeExisting() {
      stModel.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
            .findAny()
            .ifPresent(stArgument -> {
               final String uuid = stArgument.getUuid();
               stModel.removeArguments(stArgument);
               stArgument.getKeyValues().forEach(nextgen.st.model.STArgumentKV::delete);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(stModel, uuid);
            });
   }

   private void addValue(nextgen.st.model.STValue stValue) {
      final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }
}