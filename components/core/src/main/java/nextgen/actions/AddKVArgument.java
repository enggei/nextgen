package nextgen.actions;

public class AddKVArgument extends TransactionAction {


   private final nextgen.st.model.STModel stModel;
   private final nextgen.st.model.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public AddKVArgument(nextgen.st.model.STModel stModel, nextgen.st.model.STParameter stParameter, javax.swing.JComponent owner) {
		super("Add");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String[] selectedValues = appModel().getSelectedValues();
      final java.util.Map<nextgen.st.model.STParameterKey, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
      stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, newTextField(40, selectedValues)));

      final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));
      inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (java.util.Map.Entry<nextgen.st.model.STParameterKey, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {
         inputPanel.add(new javax.swing.JLabel(fieldEntry.getKey().getName()));
         inputPanel.add(fieldEntry.getValue());
      }

      showDialog(owner, inputPanel, stParameter.getName(), jDialog -> {
         java.util.Collection<nextgen.st.model.STArgumentKV> kvs = new java.util.ArrayList<>();
         for (java.util.Map.Entry<nextgen.st.model.STParameterKey, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {
            final String value = fieldEntry.getValue().getText().trim();
            if (value.length() == 0) continue;

            final nextgen.st.model.STValue stValue = appModel().db.newSTValue(value);
            final nextgen.st.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV(fieldEntry.getKey(), stValue);
            kvs.add(stArgumentKV);
         }

         final nextgen.st.model.STArgument stArgument = appModel().db.newSTArgument(stParameter, kvs);
         stModel.addArguments(stArgument);
         nextgen.events.NewSTKVArgument.post(stModel, stParameter, stArgument, kvs);

         close(jDialog);
      });
   }

}