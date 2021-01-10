package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetTemplateParameterTypes extends nextgen.actions.TransactionAction {

   private final STGroupModel stGroup;
   private final STTemplate stTemplate;
   private final JComponent owner;

	public SetTemplateParameterTypes(STGroupModel stGroup, STTemplate stTemplate, JComponent owner) {
		super("Set parameter types");
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetTemplateParameterTypes" + " stGroup" + " stTemplate" + " owner");

      final java.util.Map<String, JTextField> txtParameterMap = new java.util.TreeMap<>();
      final java.util.Map<String, JRadioButton> labelParameterMap = new java.util.TreeMap<>();
      final ButtonGroup labelParameterGroup = new ButtonGroup();

      stTemplate.getParametersSorted().forEach(stParameter -> {

         switch (stParameter.getType()) {

            case SINGLE:
               final JRadioButton radioButton = nextgen.swing.ComponentFactory.newJRadioButton("Set as Label");
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

      final JPanel contentPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(txtParameterMap.size(), 3));
      contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
      txtParameterMap.forEach((key, value) -> {
         contentPanel.add(newLabel(key));
         contentPanel.add(value);
         final JRadioButton jRadioButton = labelParameterMap.get(key);
         contentPanel.add(jRadioButton == null ? newLabel("") : jRadioButton);
      });

      showDialog(owner, contentPanel, "Parameter Types", jDialog -> {
         stTemplate.getParametersSorted().forEach(stParameter -> {

            switch (stParameter.getType()) {

               case SINGLE:
               case LIST:
                  final JTextField txtTypes = txtParameterMap.get(stParameter.getName());
                  final String types = txtTypes.getText().trim();
                  stParameter.setArgumentType(types.length() == 0 ? (stParameter.getName().startsWith("is") ? "Boolean" : "Object") : types);

                  final JRadioButton jRadioButton = labelParameterMap.get(stParameter.getName());
                  if (jRadioButton != null && jRadioButton.isSelected()) stTemplate.setLabelParameter(stParameter);
                  break;

               case KVLIST:
                  stParameter.getKeys().forEach(stParameterKey -> {
                     final JTextField txtKVTypes = txtParameterMap.get(stParameter.getName() + "." + stParameterKey.getName());
                     final String kvTypes = txtKVTypes.getText().trim();
                     stParameterKey.setArgumentType(kvTypes.length() == 0 ? (stParameterKey.getName().startsWith("is") ? "Boolean" : "Object") : kvTypes);
                  });
                  break;
            }
         });

         nextgen.events.STTemplateParameterTypesChanged.post(stGroup, stTemplate);
         SwingUtilities.invokeLater(jDialog::dispose);
      });
   }

}