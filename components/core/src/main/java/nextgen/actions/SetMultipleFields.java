package nextgen.actions;

public class SetMultipleFields extends TransactionAction {


   private final nextgen.st.domain.STTemplate stTemplate;
   private final nextgen.st.model.STModel stModel;
   private final javax.swing.JComponent owner;

	public SetMultipleFields(nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STModel stModel, javax.swing.JComponent owner) {
		super("Set Fields");
		this.stTemplate = stTemplate;
		this.stModel = stModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final java.util.concurrent.atomic.AtomicInteger modelIndex = new java.util.concurrent.atomic.AtomicInteger(0);
      final nextgen.st.model.STModel[] existingSTModels = appModel().db.findAllSTModelByStTemplate(stTemplate.getUuid()).distinct().toArray(nextgen.st.model.STModel[]::new);

      final java.util.Map<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
      final java.util.Map<String, nextgen.st.domain.STParameter> parameterMap = new java.util.LinkedHashMap<>();
      final java.util.Map<String, nextgen.st.model.STArgument> argumentMap = new java.util.LinkedHashMap<>();
      final java.util.Map<String, java.util.List<String>> valuesMap = new java.util.LinkedHashMap<>();

      stTemplate
            .getParameters()
            .filter(stParameter -> stParameter.getType().equals(nextgen.st.domain.STParameterType.SINGLE))
            .forEach(stParameter -> {

               final java.util.Optional<nextgen.st.model.STArgument> argument = stModel.getArguments()
                     .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                     .findFirst();
               final String content = argument.isPresent() ? appModel().render(argument.get()) : "";
               fieldMap.put(stParameter.getName(), newTextField(content, 40));
               parameterMap.put(stParameter.getName(), stParameter);
               argument.ifPresent(stArgument -> argumentMap.put(stParameter.getName(), stArgument));

               for (nextgen.st.model.STModel existingSTModel : existingSTModels) {
                  existingSTModel
                        .getArguments()
                        .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                        .filter(stArgument -> stArgument.getValue() != null)
                        .findFirst()
                        .ifPresent(stArgument -> {
                           valuesMap.putIfAbsent(stParameter.getName(), new java.util.ArrayList<>());
                           valuesMap.get(stParameter.getName()).add(appModel().render(stArgument));
                        });
               }

            });

      final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));
      inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (java.util.Map.Entry<String, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {
         inputPanel.add(newLabel(fieldEntry.getKey()));
         inputPanel.add(fieldEntry.getValue());

         if (!valuesMap.isEmpty())
            fieldEntry.getValue().addMouseListener(new java.awt.event.MouseAdapter() {
               @Override
               public void mouseClicked(java.awt.event.MouseEvent e) {
                  fieldEntry.getValue().setText(valuesMap.get(fieldEntry.getKey()).get(modelIndex.incrementAndGet() % valuesMap.get(fieldEntry.getKey()).size()));
               }
            });
      }

      showDialog(owner, inputPanel, "Set Multiple", jDialog -> {
         for (java.util.Map.Entry<String, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {

            final String name = fieldEntry.getKey();
            final String value = fieldEntry.getValue().getText().trim();
            final nextgen.st.model.STArgument stArgument = argumentMap.get(name);
            final nextgen.st.domain.STParameter stParameter = parameterMap.get(name);

            if (value.length() == 0 && stArgument != null) {
               final String uuid = stArgument.getUuid();
               stModel.removeArguments(stArgument);
               stArgument.delete();
               nextgen.events.STArgumentDeleted.post(stModel, uuid);
            } else if (value.length() != 0 && stArgument != null) {
               final String existingValue = appModel().render(stArgument.getValue());
               if (!value.equals(existingValue)) {
                  stArgument.removeValue();
                  stArgument.setValue(appModel().db.newSTValue(value));
                  nextgen.events.STArgumentChanged.post(stModel, stArgument);
               }
            } else if (value.length() != 0) {
               final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);
               final nextgen.st.model.STArgument newSTArgument = appModel().newSTArgument(stModel, stParameter, stValue);
               nextgen.events.NewSTArgument.post(newSTArgument, stModel, stParameter, stValue);
            }
         }
      });
   }
}