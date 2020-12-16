package nextgen.actions;

public class SetTemplateParameterTypes extends nextgen.actions.TransactionAction {

   private final nextgen.model.STGroupModel stGroup;
   private final nextgen.model.STTemplate stTemplate;
   private final javax.swing.JComponent owner;

	public SetTemplateParameterTypes(nextgen.model.STGroupModel stGroup, nextgen.model.STTemplate stTemplate, javax.swing.JComponent owner) {
		super("Set parameter types");
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final java.util.Map<String, javax.swing.JTextField> txtParameterMap = new java.util.TreeMap<>();
      final java.util.Map<String, javax.swing.JRadioButton> labelParameterMap = new java.util.TreeMap<>();
      final javax.swing.ButtonGroup labelParameterGroup = new javax.swing.ButtonGroup();

      stTemplate.getParametersSorted().forEach(stParameter -> {

         switch (stParameter.getType()) {

            case SINGLE:
               final javax.swing.JRadioButton radioButton = new javax.swing.JRadioButton("Set as Label");
               labelParameterMap.put(stParameter.getName(), radioButton);
               labelParameterGroup.add(radioButton);
               radioButton.setSelected(stTemplate.getLabelParameter() != null && stTemplate.getLabelParameter().equals(stParameter));

            case LIST:
               txtParameterMap.put(stParameter.getName(), newTextField(stParameter.getArgumentType("Object"), 15));
               break;

            case KVLIST:
               stParameter.getKeys().forEach(stParameterKey -> {
                  final String kvListKey = stParameter.getName() + "." + stParameterKey.getName();
                  txtParameterMap.put(kvListKey, newTextField(stParameterKey.getArgumentType("Object"), 15));
               });
               break;
         }
      });

      final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout(txtParameterMap.size(), 3));
      contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
      txtParameterMap.forEach((key, value) -> {
         contentPanel.add(newLabel(key));
         contentPanel.add(value);
         final javax.swing.JRadioButton jRadioButton = labelParameterMap.get(key);
         contentPanel.add(jRadioButton == null ? newLabel("") : jRadioButton);
      });

      showDialog(owner, contentPanel, "Parameter Types", jDialog -> {
         stTemplate.getParametersSorted().forEach(stParameter -> {

            switch (stParameter.getType()) {

               case SINGLE:
               case LIST:
                  final javax.swing.JTextField txtTypes = txtParameterMap.get(stParameter.getName());
                  final String types = txtTypes.getText().trim();
                  stParameter.setArgumentType(types.length() == 0 ? (stParameter.getName().startsWith("is") ? "Boolean" : "Object") : types);

                  final javax.swing.JRadioButton jRadioButton = labelParameterMap.get(stParameter.getName());
                  if (jRadioButton != null && jRadioButton.isSelected()) stTemplate.setLabelParameter(stParameter);
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

         nextgen.events.STTemplateParameterTypesChanged.post(stGroup, stTemplate);
         javax.swing.SwingUtilities.invokeLater(jDialog::dispose);
      });
   }

}