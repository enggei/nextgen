package nextgen.actions;

public class AddKVArguments extends nextgen.actions.TransactionAction {

   private final nextgen.model.STParameter stParameter;
   private final nextgen.model.STModel stModel;
   private final javax.swing.JComponent owner;

	public AddKVArguments(nextgen.model.STParameter stParameter, nextgen.model.STModel stModel, javax.swing.JComponent owner) {
		super("Add");
		this.stParameter = stParameter;
		this.stModel = stModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
   	log.info("AddKVArguments" + " stParameter" + " stModel" + " owner");

      final java.util.List<java.util.Map<nextgen.model.STParameterKey, javax.swing.JTextField>> maps = java.util.Arrays.asList(
            getStParameterKeyJTextFieldMap(),
            getStParameterKeyJTextFieldMap(),
            getStParameterKeyJTextFieldMap()
      );

      final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(maps.size(), 1));

      maps.forEach(fieldMap -> {
         final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));
         inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
         for (java.util.Map.Entry<nextgen.model.STParameterKey, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {
            inputPanel.add(newLabel(fieldEntry.getKey().getName()));
            inputPanel.add(fieldEntry.getValue());
         }
         contentPanel.add(inputPanel);
      });

      showDialog(owner, contentPanel, stParameter.getName(), jDialog -> {
         for (java.util.Map<nextgen.model.STParameterKey, javax.swing.JTextField> map : maps)
            addSTArgument(map);
         close(jDialog);
      });
   }

   private java.util.Map<nextgen.model.STParameterKey, javax.swing.JTextField> getStParameterKeyJTextFieldMap() {
      final java.util.Map<nextgen.model.STParameterKey, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
      stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, newTextField(30)));
      return fieldMap;
   }

   private void addSTArgument(java.util.Map<nextgen.model.STParameterKey, javax.swing.JTextField> fieldMap) {

      if (fieldMap.values().stream().noneMatch(jTextField -> jTextField.getText().trim().length() > 0)) return;

      java.util.List<nextgen.model.STArgumentKV> kvs = new java.util.ArrayList<>();
      for (java.util.Map.Entry<nextgen.model.STParameterKey, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {
         final String value = fieldEntry.getValue().getText().trim();
         if (value.length() == 0) continue;
         appModel().addArgument(kvs, fieldEntry.getKey(), value);
      }

      appModel().addArgument(stModel, stParameter, kvs);
   }
}