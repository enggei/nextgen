package nextgen.actions;

public class EditEnum extends TransactionAction {


   private final nextgen.st.model.STEnum stEnum;
   private final javax.swing.JComponent owner;

	public EditEnum(nextgen.st.model.STEnum stEnum, javax.swing.JComponent owner) {
		super("Edit");
		this.stEnum = stEnum;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final int newFields = 5;
      final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout((int) stEnum.getValues().count() + newFields + 1, 2));
      contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
      contentPanel.add(newLabel("Name"));
      contentPanel.add(newLabel("Lexical"));

      // existing values:
      final java.util.Map<nextgen.st.model.STEnumValue, javax.swing.JTextField> txtEnumValuesName = new java.util.LinkedHashMap<>();
      final java.util.Map<nextgen.st.model.STEnumValue, javax.swing.JTextField> txtEnumLexical = new java.util.LinkedHashMap<>();
      stEnum.getValues().forEach(stEnumValue -> {
      	txtEnumValuesName.put(stEnumValue, newTextField(stEnumValue.getName(), 10));
      	txtEnumLexical.put(stEnumValue, newTextField(stEnumValue.getLexical(), 10));
      	contentPanel.add(txtEnumValuesName.get(stEnumValue));
      	contentPanel.add(txtEnumLexical.get(stEnumValue));
      });

      // allow adding new values:
      final java.util.Map<Integer, javax.swing.JTextField> newTxtEnumValuesName = new java.util.LinkedHashMap<>();
      final java.util.Map<Integer, javax.swing.JTextField> newTxtEnumLexical = new java.util.LinkedHashMap<>();
      for (int i = 0; i < newFields; i++) {
      	newTxtEnumValuesName.put(i, newTextField("", 10));
      	newTxtEnumLexical.put(i, newTextField("", 10));
      	contentPanel.add(newTxtEnumValuesName.get(i));
      	contentPanel.add(newTxtEnumLexical.get(i));
      }

      showDialog(owner, contentPanel, "Edit Enum", jDialog -> {
      	for (nextgen.st.model.STEnumValue stEnumValue : txtEnumValuesName.keySet()) {
      		final String txtEnumValueName = txtEnumValuesName.get(stEnumValue).getText().trim();
      		final String txtEnumValueLexical = txtEnumLexical.get(stEnumValue).getText().trim();

      		stEnumValue.setName(txtEnumValueName);
      		stEnumValue.setLexical(txtEnumValueLexical.length() == 0 ? null : txtEnumValueLexical);
      	}

      	for (int i = 0; i < newFields; i++) {
      		final String newEnumValue = newTxtEnumValuesName.get(i).getText().trim();
      		final String newEnumLexical = newTxtEnumLexical.get(i).getText().trim();
      		if (newEnumValue.length() == 0) continue;

      		stEnum.addValues(appModel().newSTEnumValue()
      				.setName(newEnumValue)
      				.setLexical(newEnumLexical.length() == 0 ? null : newEnumLexical));
      	}

      	nextgen.events.STEnumChanged.post(stEnum);
      });
   }

}