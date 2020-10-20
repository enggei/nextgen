package nextgen.actions;

public class EditEnum extends TransactionAction {

   private final nextgen.st.domain.STEnum stEnum;
   private final javax.swing.JComponent owner;

	public EditEnum(nextgen.st.domain.STEnum stEnum, javax.swing.JComponent owner) {
		super("Edit");
		this.stEnum = stEnum;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {
      final int newFields = 5;

      final javax.swing.JPanel contentPanel = new javax.swing.JPanel(new java.awt.GridLayout((int) stEnum.getValues().count() + newFields + 1, 2));
      contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
      contentPanel.add(new javax.swing.JLabel("Name"));
      contentPanel.add(new javax.swing.JLabel("Lexical"));

      // existing values:
      final java.util.Map<nextgen.st.domain.STEnumValue, javax.swing.JTextField> txtEnumValuesName = new java.util.LinkedHashMap<>();
      final java.util.Map<nextgen.st.domain.STEnumValue, javax.swing.JTextField> txtEnumLexical = new java.util.LinkedHashMap<>();
      stEnum.getValues().forEach(stEnumValue -> {
      	txtEnumValuesName.put(stEnumValue, nextgen.utils.SwingUtil.newTextField(stEnumValue.getName(), 10));
      	txtEnumLexical.put(stEnumValue, nextgen.utils.SwingUtil.newTextField(stEnumValue.getLexical(), 10));
      	contentPanel.add(txtEnumValuesName.get(stEnumValue));
      	contentPanel.add(txtEnumLexical.get(stEnumValue));
      });

      // allow adding new values:
      final java.util.Map<Integer, javax.swing.JTextField> newTxtEnumValuesName = new java.util.LinkedHashMap<>();
      final java.util.Map<Integer, javax.swing.JTextField> newTxtEnumLexical = new java.util.LinkedHashMap<>();
      for (int i = 0; i < newFields; i++) {
      	newTxtEnumValuesName.put(i, nextgen.utils.SwingUtil.newTextField("", 10));
      	newTxtEnumLexical.put(i, nextgen.utils.SwingUtil.newTextField("", 10));

      	contentPanel.add(newTxtEnumValuesName.get(i));
      	contentPanel.add(newTxtEnumLexical.get(i));
      }

      final javax.swing.JDialog dialog = new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities.getAncestorOfClass(javax.swing.JFrame.class, owner), "Edit Enum", true);
      dialog.add(contentPanel, java.awt.BorderLayout.CENTER);

      final javax.swing.JButton btnSave = new javax.swing.JButton(nextgen.st.STAppPresentationModel.newAction("Save", actionEvent1 -> {

      	for (nextgen.st.domain.STEnumValue stEnumValue : txtEnumValuesName.keySet()) {
      		final String txtEnumValueName = txtEnumValuesName.get(stEnumValue).getText().trim();
      		final String txtEnumValueLexical = txtEnumLexical.get(stEnumValue).getText().trim();

      		stEnumValue.setName(txtEnumValueName);
      		stEnumValue.setLexical(txtEnumValueLexical.length() == 0 ? null : txtEnumValueLexical);
      	}

      	for (int i = 0; i < newFields; i++) {
      		final String newEnumValue = newTxtEnumValuesName.get(i).getText().trim();
      		final String newEnumLexical = newTxtEnumLexical.get(i).getText().trim();
      		if (newEnumValue.length() == 0) continue;

      		stEnum.addValues(nextgen.st.domain.STJsonFactory.newSTEnumValue()
      																			.setName(newEnumValue)
      																			.setLexical(newEnumLexical.length() == 0 ? null : newEnumLexical));
      	}

      	appModel().update(stEnum);
      	javax.swing.SwingUtilities.invokeLater(dialog::dispose);
      }));

      nextgen.utils.SwingUtil.showDialog(owner, dialog, btnSave);
   }
}