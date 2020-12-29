package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddKVArguments extends TransactionAction {

   private final STParameter stParameter;
   private final STModel stModel;
   private final JComponent owner;

	public AddKVArguments(STParameter stParameter, STModel stModel, JComponent owner) {
		super("ADD");
		this.stParameter = stParameter;
		this.stModel = stModel;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddKVArguments" + " stParameter" + " stModel" + " owner");

      final java.util.List<java.util.Map<STParameterKey, JTextField>> maps = java.util.Arrays.asList(
            getStParameterKeyJTextFieldMap(),
            getStParameterKeyJTextFieldMap(),
            getStParameterKeyJTextFieldMap()
      );

      final JPanel contentPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(maps.size(), 1));

      maps.forEach(fieldMap -> {
         final JPanel inputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(fieldMap.size(), 2));
         inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
         for (java.util.Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {
            inputPanel.add(newLabel(fieldEntry.getKey().getName()));
            inputPanel.add(fieldEntry.getValue());
         }
         contentPanel.add(inputPanel);
      });

      showDialog(owner, contentPanel, stParameter.getName(), jDialog -> {
         for (java.util.Map<STParameterKey, JTextField> map : maps)
            addSTArgument(map);
         close(jDialog);
      });
   }

   private java.util.Map<STParameterKey, JTextField> getStParameterKeyJTextFieldMap() {
      final java.util.Map<STParameterKey, JTextField> fieldMap = new java.util.LinkedHashMap<>();
      stParameter.getKeys().forEach(stParameterKey -> fieldMap.put(stParameterKey, newTextField(30)));
      return fieldMap;
   }

   private void addSTArgument(java.util.Map<STParameterKey, JTextField> fieldMap) {

      if (fieldMap.values().stream().noneMatch(jTextField -> jTextField.getText().trim().length() > 0)) return;

      java.util.List<STArgumentKV> kvs = new java.util.ArrayList<>();
      for (java.util.Map.Entry<STParameterKey, JTextField> fieldEntry : fieldMap.entrySet()) {
         final String value = fieldEntry.getValue().getText().trim();
         if (value.length() == 0) continue;
         kvs.add(appModel().newSTArgumentKV(fieldEntry.getKey(), appModel().newSTValue(value)));
      }

      appModel().addArgument(stModel, stParameter, kvs);
   }
}