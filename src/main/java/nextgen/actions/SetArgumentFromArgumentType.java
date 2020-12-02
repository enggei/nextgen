package nextgen.actions;

public class SetArgumentFromArgumentType extends nextgen.actions.TransactionAction {

   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public SetArgumentFromArgumentType(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, javax.swing.JComponent owner) {
		super("Set");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String argumentType = stParameter.getArgumentType();

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
      		final nextgen.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
      		addValue(stValue);
      	} else {
      		input(owner, "New value", s -> {
      			removeExisting();
      			final nextgen.model.STValue stValue = appModel().db.newSTValue(s);
      			addValue(stValue);
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
      				final nextgen.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
      				addValue(stValue);
      			} else {

      				final java.util.List<ListElement> selection = new java.util.ArrayList<>();
      				interfaces.forEach(stTemplate1 -> selection.add(new ListElement(stTemplate1)));

      				select(owner, selection, value -> {
      					removeExisting();
      					final nextgen.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(value.stTemplate);
      					final nextgen.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
      					addValue(stValue);
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
      					final nextgen.model.STValue stValue = appModel().db.newSTValue(s);
      					addValue(stValue);
      				});
      			}
      		}
      	}
      }
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
      stModel.getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(stParameter))
            .findAny()
            .ifPresent(stArgument -> {
               final String uuid = stArgument.getUuid();
               stModel.removeArguments(stArgument);
               stArgument.getKeyValues().forEach(nextgen.model.STArgumentKV::delete);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(stModel, uuid);
            });
   }

   private void addValue(nextgen.model.STValue stValue) {
      final nextgen.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, stValue);
      stModel.addArguments(stArgument);
      nextgen.events.NewSTArgument.post(stArgument, stModel, stParameter, stValue);
   }
}