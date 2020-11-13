package nextgen.actions;

public class SetTemplateParameterTypes extends TransactionAction {


   private final nextgen.st.model.STGroupModel stGroup;
   private final nextgen.st.model.STTemplate stTemplate;
   private final javax.swing.JComponent owner;

	public SetTemplateParameterTypes(nextgen.st.model.STGroupModel stGroup, nextgen.st.model.STTemplate stTemplate, javax.swing.JComponent owner) {
		super("Set parameter types");
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final java.util.Map<String, javax.swing.JTextField> txtParameterMap = new java.util.TreeMap<>();
      stTemplate.getParameters().forEach(stParameter -> {

      	switch (stParameter.getType()) {

      		case SINGLE:
      		case LIST:
      			final String key = stParameter.getName();
      			txtParameterMap.put(key, newTextField(stParameter.getArgumentType("Object"), 15));
      			break;

      		case KVLIST:
      			stParameter.getKeys().forEach(stParameterKey -> {
      				final String kvListKey = stParameter.getName() + "." + stParameterKey.getName();
      				txtParameterMap.put(kvListKey, newTextField(stParameterKey.getArgumentType("Object"), 15));
      			});
      			break;
      	}
      });

      final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(txtParameterMap.size(), 2));
      contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
      txtParameterMap.forEach((key, value) -> {
      	contentPanel.add(newLabel(key));
      	contentPanel.add(value);
      });

      showDialog(owner, contentPanel, "Parameter Types", jDialog -> {
      	stTemplate.getParameters().forEach(stParameter -> {

      		switch (stParameter.getType()) {

      			case SINGLE:
      			case LIST:
      				final javax.swing.JTextField txtTypes = txtParameterMap.get(stParameter.getName());
      				final String types = txtTypes.getText().trim();
      				stParameter.setArgumentType(types.length() == 0 ? (stParameter.getName().startsWith("is") ? "Boolean" : "Object") : types);
      				break;

      			case KVLIST:
      				stParameter.getKeys().forEach(stParameterKey -> {
      					final javax.swing.JTextField txtKVTypes = txtParameterMap.get(stParameter.getName() + "." + stParameterKey.getName());
      					final String kvTypes = txtKVTypes.getText().trim();
      					stParameterKey.setArgumentType(kvTypes.length() == 0 ? (stParameterKey.getName().startsWith("is") ? "Boolean" : "Object") : kvTypes);
      				});
      				break;
      		}
      	});

      	appModel().save(stGroup);
      	nextgen.events.STTemplateParameterTypesChanged.post(stGroup, stTemplate);
      	javax.swing.SwingUtilities.invokeLater(jDialog::dispose);
      });
   }

}