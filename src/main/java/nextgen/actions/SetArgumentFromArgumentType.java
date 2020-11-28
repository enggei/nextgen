package nextgen.actions;

public class SetArgumentFromArgumentType extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.model.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public SetArgumentFromArgumentType(nextgen.st.model.STModel stModel, nextgen.st.model.STParameter stParameter, javax.swing.JComponent owner) {
		super("Set");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String argumentType = stParameter.getArgumentType();

      if (argumentType.equals("Object") || argumentType.equals("String")) {

      	final java.util.Optional<nextgen.st.model.STTemplate> stTemplate = stModel.getArguments()
      			.filter(stArgument -> stArgument.getStParameter().equals(stParameter))
      			.map(nextgen.st.model.STArgument::getValue)
      			.filter(nextgen.st.model.STValue::hasType)
      			.filter(stValue -> stValue.getType() == nextgen.st.model.STValueType.STMODEL)
      			.map(stValue -> stValue.getStModel().getStTemplate())
      			.findFirst();

      	if (stTemplate.isPresent()) {
      		removeExisting();
      		final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(stTemplate.get());
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

      	final nextgen.st.model.STGroupModel stGroupModel = appModel().findSTGroup(stModel.getStTemplate());
      	final java.util.Optional<nextgen.st.model.STTemplate> stTemplate = nextgen.utils.STModelUtil
      			.aggregateTemplates(stGroupModel)
      			.filter(candidate -> candidate.getName().toLowerCase().equals(argumentType.toLowerCase()))
      			.findAny();

      	if (stTemplate.isPresent()) {

      		final java.util.List<nextgen.st.model.STModel> stModelList = stTemplate.get().getIncomingStTemplateSTModel().collect(java.util.stream.Collectors.toList());
      		if (!stModelList.isEmpty()) {

      			final nextgen.swing.SelectOrAddNewModelPanel input = new nextgen.swing.SelectOrAddNewModelPanel(stModelList, stTemplate.get());
      			showDialog(owner, input, "Add", jDialog -> {
      				removeExisting();
      				final nextgen.st.model.STValue stValue = input.getSTValue();
      				addValue(stValue);
      				jDialog.dispose();
      			});

      		} else {
      			removeExisting();
      			final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(stTemplate.get());
      			final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
      			addValue(stValue);
      		}

      	} else {
      		final java.util.Set<nextgen.st.model.STTemplate> interfaces = nextgen.utils.STModelUtil.findSTTemplatesByInterface(argumentType, stGroupModel);
      		if (!interfaces.isEmpty()) {
      			if (interfaces.size() == 1) {
      				removeExisting();
      				final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(interfaces.iterator().next());
      				final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
      				addValue(stValue);
      			} else {

      				final java.util.List<ListElement> selection = new java.util.ArrayList<>();
      				interfaces.forEach(stTemplate1 -> selection.add(new ListElement(stTemplate1)));

      				select(owner, selection, value -> {
      					removeExisting();
      					final nextgen.st.model.STModel stTemplateModel = appModel().db.newSTModel().setStTemplate(value.stTemplate);
      					final nextgen.st.model.STValue stValue = appModel().db.newSTValue(stTemplateModel);
      					addValue(stValue);
      				});
      			}

      		} else {
      			final nextgen.st.model.STEnum stEnum = nextgen.utils.STModelUtil.findSTEnumByName(argumentType, stGroupModel);
      			if (stEnum != null) {
      				select(owner, stEnum.getValues().collect(java.util.stream.Collectors.toSet()), value -> {
      					removeExisting();
      					final nextgen.st.model.STValue stValue = appModel().db.newSTValue()
      							.setType(nextgen.st.model.STValueType.ENUM)
      							.setValue(value.getLexical() == null || value.getLexical().trim().length() == 0 ? value.getName() : value.getLexical());
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

   private static final class ListElement {

      private final nextgen.st.model.STTemplate stTemplate;
      private final String text;

      public ListElement(nextgen.st.model.STTemplate stTemplate) {
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