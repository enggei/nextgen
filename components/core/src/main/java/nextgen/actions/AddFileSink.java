package nextgen.actions;

public class AddFileSink extends TransactionAction {

   private static final java.util.concurrent.atomic.AtomicInteger fileTypeIndex = new java.util.concurrent.atomic.AtomicInteger(0);
   private static final java.util.concurrent.atomic.AtomicInteger pathIndex = new java.util.concurrent.atomic.AtomicInteger(0);

   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.domain.STTemplate stTemplate;
   private final javax.swing.JComponent owner;

	public AddFileSink(String name, nextgen.st.model.STModel stModel, nextgen.st.domain.STTemplate stTemplate, javax.swing.JComponent owner) {
      super(name);
      this.stModel = stModel;
      this.stTemplate = stTemplate;
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

      final java.util.LinkedHashMap<String, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
      fieldMap.put("name", newTextField(appModel().getSTModelName(stModel, ""), 15));
      fieldMap.put("type", newTextField(15, fileTypes));
      fieldMap.put("path", newTextField(15, pathTypes));
      fieldMap.put("package", newTextField(appModel().getSTModelPackage(stModel, ""), 15));

      final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));
      inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));

      for (java.util.Map.Entry<String, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {
         inputPanel.add(newLabel(fieldEntry.getKey()));
         inputPanel.add(fieldEntry.getValue());
      }

      showDialog(owner, inputPanel, "New FileSink", jDialog -> {
         final String name = fieldMap.get("name").getText().trim();
         final String type = fieldMap.get("type").getText().trim();
         final String path = fieldMap.get("path").getText().trim();
         final String packageName = fieldMap.get("package").getText().trim();
         final nextgen.st.model.STFile stFile = appModel().newSTFile(name, type, path, packageName);
         stModel.addFiles(stFile);
         //nextgen.events.NewFileSink.post(stModel, stFile);
      });
   }
}