package nextgen.actions;

public class AddKVArgument extends TransactionAction {


   private final nextgen.model.STModel stModel;
   private final nextgen.model.STParameter stParameter;
   private final javax.swing.JComponent owner;

	public AddKVArgument(nextgen.model.STModel stModel, nextgen.model.STParameter stParameter, javax.swing.JComponent owner) {
		super("Add");
		this.stModel = stModel;
		this.stParameter = stParameter;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final String[] selectedValues = appModel().getSelectedValues();
      final java.util.Map<nextgen.model.STParameterKey, javax.swing.JTextField> fieldMap = new java.util.LinkedHashMap<>();
      stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, newTextField(40, selectedValues)));

      final javax.swing.JPanel inputPanel = new javax.swing.JPanel(new java.awt.GridLayout(fieldMap.size(), 2));
      inputPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (java.util.Map.Entry<nextgen.model.STParameterKey, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {
      	inputPanel.add(new javax.swing.JLabel(fieldEntry.getKey().getName()));
      	inputPanel.add(fieldEntry.getValue());
      }

      showDialog(owner, inputPanel, stParameter.getName(), jDialog -> {
      	java.util.Collection<nextgen.model.STArgumentKV> kvs = new java.util.ArrayList<>();
      	for (java.util.Map.Entry<nextgen.model.STParameterKey, javax.swing.JTextField> fieldEntry : fieldMap.entrySet()) {
      		final String value = fieldEntry.getValue().getText().trim();
      		if (value.length() == 0) continue;

      		final nextgen.model.STValue stValue = appModel().db.newSTValue(value);
      		final nextgen.model.STArgumentKV stArgumentKV = appModel().db.newSTArgumentKV().setStParameterKey(fieldEntry.getKey()).setValue(stValue);
      		kvs.add(stArgumentKV);
      	}

      	final nextgen.model.STArgument stArgument = appModel().db.newSTArgument().setStParameter(stParameter);
      	for (nextgen.model.STArgumentKV kv : kvs) stArgument.addKeyValues(kv);
      	stModel.addArguments(stArgument);
      	nextgen.events.NewSTKVArgument.post(stModel, stParameter, stArgument, kvs);

      	close(jDialog);
      });
   }

}