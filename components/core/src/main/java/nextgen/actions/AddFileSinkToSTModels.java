package nextgen.actions;

public class AddFileSinkToSTModels extends TransactionAction {

   private static final java.util.concurrent.atomic.AtomicInteger fileTypeIndex = new java.util.concurrent.atomic.AtomicInteger(0);
   private static final java.util.concurrent.atomic.AtomicInteger pathIndex = new java.util.concurrent.atomic.AtomicInteger(0);

   private final nextgen.st.domain.STTemplate stTemplate;
   private final java.util.List<nextgen.st.model.STModel> stModels;
   private final javax.swing.JComponent owner;

	public AddFileSinkToSTModels(nextgen.st.domain.STTemplate stTemplate, java.util.List<nextgen.st.model.STModel> stModels, javax.swing.JComponent owner) {
		super("Add File Sink");
		this.stTemplate = stTemplate;
		this.stModels = stModels;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String[] fileTypes = new String[]{"html", "java", "js", "xml"};

      final String[] pathTypes = appModel().db.findAllSTFile()
            .filter(stFile -> stFile.getPath() != null)
            .filter(stFile -> stFile.getPath().getValue() != null)
            .map(stFile -> stFile.getPath().getValue())
            .distinct()
            .toArray(String[]::new);

      final java.util.Map<String, nextgen.st.domain.STParameter> parameterMap = new java.util.LinkedHashMap<>();
      final java.util.List<String> nameOptions = stTemplate.getParameters()
            .filter(stParameter -> stParameter.getType().equals(nextgen.st.domain.STParameterType.SINGLE))
            .map(stParameter -> {
               parameterMap.put(stParameter.getName(), stParameter);
               return stParameter.getName();
            })
            .sorted(String::compareToIgnoreCase)
            .collect(java.util.stream.Collectors.toList());

      final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
      fieldMap.put("name", newTextField("", 15, nameOptions, 0));
      fieldMap.put("type", newTextField(15, fileTypes));
      fieldMap.put("path", newTextField(15, pathTypes));
      fieldMap.put("package", newTextField("", 15));

      final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));
      inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

      for (java.util.Map.Entry<String, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {
         inputPanel.add(newLabel(fieldEntry.getKey()));
         inputPanel.add(fieldEntry.getValue());
      }

      showDialog(owner, inputPanel, "New FileSink", jDialog -> {
         final nextgen.st.domain.STParameter stParameter = parameterMap.get(fieldMap.get("name").getText().trim());
         final String type = fieldMap.get("type").getText().trim();
         final String path = fieldMap.get("path").getText().trim();
         final String packageName = fieldMap.get("package").getText().trim();

         for (nextgen.st.model.STModel stModel : stModels) {
            stModel.getArguments()
                  .filter(stArgument -> stArgument.getStParameter().equals(stParameter.getUuid()))
                  .findFirst()
                  .ifPresent(stArgument -> {
                     final nextgen.st.model.STFile stFile = appModel().newSTFile(appModel().render(stArgument), type, path, packageName);
                     stModel.addFiles(stFile);
                     nextgen.events.NewFileSink.post(stModel, stFile);
                  });
         }
         javax.swing.SwingUtilities.invokeLater(jDialog::dispose);
      });
   }
}