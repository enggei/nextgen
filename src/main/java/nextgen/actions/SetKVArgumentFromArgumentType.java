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
      final String argumentType = stParameterKey.getArgumentType();
      final nextgen.model.STParameter stParameter = stArgument.getStParameter();

      if (argumentType.equals("Object") || argumentType.equals("String")) {

         final java.util.Optional<nextgen.model.STTemplate> stTemplate = stModel.getArguments()
               .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
               .map(nextgen.model.STArgument::getValue)
               .filter(nextgen.model.STValue::hasType)
               .filter(stValue -> stValue.getType() == nextgen.model.STValueType.STMODEL)
               .map(stValue -> stValue.getStModel().getStTemplate())
               .findFirst();

         if (stTemplate.isPresent()) {
            removeExisting();
            final nextgen.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(stTemplate.get());
            addValue(appModel().db.newSTValue(stTemplateModel));
         } else {
            input(owner, "New value", s -> {
               removeExisting();
               addValue(appModel().db.newSTValue(s));
            });
         }

      } else {

         final nextgen.model.STGroupModel stGroupModel = nextgen.utils.STModelUtil.getSTGroup(stModel.getStTemplate());
         final java.util.Optional<nextgen.model.STTemplate> stTemplate = nextgen.utils.STModelUtil
               .aggregateTemplates(stGroupModel)
               .filter(candidate -> candidate.getName().toLowerCase().equals(argumentType.toLowerCase()))
               .findAny();

         if (stTemplate.isPresent()) {

            final java.util.List<nextgen.model.STModel> stModelList = stTemplate.get().getIncomingStTemplateSTModel().collect(java.util.stream.Collectors.toList());
            if (!stModelList.isEmpty()) {

               final nextgen.swing.SelectOrAddNewModelPanel input = new nextgen.swing.SelectOrAddNewModelPanel(stModelList, stTemplate.get());
               showDialog(owner, input, "Add", jDialog -> {
                  removeExisting();
                  final nextgen.model.STValue stValue = input.getSTValue();
                  addValue(stValue);
                  jDialog.dispose();
               });

            } else {
               removeExisting();
               final nextgen.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(stTemplate.get());
               final nextgen.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
               addValue(stValue);
            }

         } else {
            final java.util.Set<nextgen.model.STTemplate> interfaces = nextgen.utils.STModelUtil.findSTTemplatesByInterface(argumentType, stGroupModel);
            if (!interfaces.isEmpty()) {
               if (interfaces.size() == 1) {
                  removeExisting();
                  final nextgen.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(interfaces.iterator().next());
                  addValue(appModel().db.newSTValue(stTemplateModel));
               } else {

               	final java.util.List<ListElement> selection = new java.util.ArrayList<>();
      				interfaces.forEach(stTemplate1 -> selection.add(new ListElement(stTemplate1)));
      				
                  select(owner, selection, value -> {
                     removeExisting();
                     final nextgen.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(value.stTemplate);
                     addValue(appModel().db.newSTValue(stTemplateModel));
                  });
               }

            } else {
               final nextgen.model.STEnum stEnum = nextgen.utils.STModelUtil.findSTEnumByName(argumentType, stGroupModel);
               if (stEnum != null) {
                  select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> {
                     removeExisting();
                     final nextgen.model.STValue stValue = appModel().db.newSTValue()
                           .setType(nextgen.model.STValueType.ENUM)
                           .setValue(value.getLexical() == null || value.getLexical().trim().length() == 0 ? value.getName() : value.getLexical());
                     addValue(stValue);
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

   private void addValue(nextgen.model.STValue stValue) {
      final nextgen.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV().setStParameterKey(stParameterKey).setValue(stValue);
      stArgument.addKeyValues(stArgumentKV);
      nextgen.events.NewKV.post(stModel, stArgument, stArgumentKV, stParameterKey, stValue);
   }

   private static final class ListElement {

      private final nextgen.model.STTemplate stTemplate;
      private final String text;

      public ListElement(nextgen.model.STTemplate stTemplate) {
         this.stTemplate = stTemplate;
         this.text = stTemplate.getName();
      }

      @Override
      public String toString() {
         return text;
      }
   }

   private void removeExisting() {
      stArgument.getKeyValues()
            .filter(existing -> existing.getStParameterKey().equals(stParameterKey))
            .findFirst()
            .ifPresent(existing -> {
               stArgument.removeKeyValues(existing);
               final String uuid = existing.getUuid();
               existing.delete();
               nextgen.events.KVDeleted.post(stModel, stArgument, uuid);
            });
   }
}