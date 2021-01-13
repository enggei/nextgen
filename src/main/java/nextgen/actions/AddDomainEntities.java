package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddDomainEntities extends nextgen.actions.TransactionAction {

   private final nextgen.model.Domain domain;
   private final JComponent owner;

	public AddDomainEntities(nextgen.model.Domain domain, JComponent owner) {
		super("Add Entities");
		this.domain = domain;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddDomainEntities" + " domain" + " owner");

      final java.util.List<JComponent> components = new java.util.ArrayList<>();
      for (int i = 0; i < 10; i++) {
         components.add(newTextField(30));
         components.add(newComboBox(DomainEntityType.values(), nextgen.model.DomainEntityType.ENTITY));
         components.add(newTextField(30));
      }

      final JPanel inputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(10 + 1, 3));
      inputPanel.add(newLabel("Name"));
      inputPanel.add(newLabel("Type"));
      inputPanel.add(newLabel("EnumValues"));
      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

      for (JComponent component : components) inputPanel.add(component);

      showDialog(owner, inputPanel, "Entities", jDialog -> {

         for (int i = 0; i < components.size(); i += 3) {
            final JTextField txtName = (JTextField) components.get(i);
            final JComboBox<DomainEntityType> cboType = (JComboBox<DomainEntityType>) components.get(i + 1);
            final JTextField txtEnumValues = (JTextField) components.get(i + 2);

            final String name = txtName.getText().trim();
            if (name.length() == 0) continue;

            appModel().addDomainEntity(domain, name, (DomainEntityType) cboType.getSelectedItem(), txtEnumValues.getText().trim());
         }

         close(jDialog);
      });
   }

}