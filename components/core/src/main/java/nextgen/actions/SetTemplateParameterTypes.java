package nextgen.actions;

public class SetTemplateParameterTypes extends TransactionAction {

   private final nextgen.st.domain.STTemplate stTemplate;
   private final javax.swing.JComponent owner;

	public SetTemplateParameterTypes(nextgen.st.domain.STTemplate stTemplate, javax.swing.JComponent owner) {
		super("Set parameter types");
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
      			txtParameterMap.put(key, nextgen.utils.SwingUtil.newTextField(stParameter.getArgumentType("Object"), 15));

      			break;
      		case KVLIST:
      			stParameter.getKeys().forEach(stParameterKey -> {
      				final String kvListKey = stParameter.getName() + "." + stParameterKey.getName();
      				txtParameterMap.put(kvListKey, nextgen.utils.SwingUtil.newTextField(stParameterKey.getArgumentType("Object"), 15));
      			});
      			break;
      	}
      });

      final javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities
      		.getAncestorOfClass(javax.swing.JFrame.class, owner), "Set Parameter types", true);
      final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(txtParameterMap.size(), 2));
      contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
      txtParameterMap.forEach((key, value) -> {
      	contentPanel.add(new javax.swing.JLabel(key));
      	contentPanel.add(value);
      });
      dialog.add(contentPanel, java.awt.BorderLayout.CENTER);

      final javax.swing.JButton btnSave = new javax.swing.JButton(nextgen.st.STAppPresentationModel.newAction("Save", actionEvent1 -> {
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

      	appModel().setParameterTypes(stTemplate);

      	javax.swing.SwingUtilities.invokeLater(dialog::dispose);
      }));

      nextgen.utils.SwingUtil.showDialog(owner, dialog, btnSave);
   }
}