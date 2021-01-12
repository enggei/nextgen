package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;

import org.stringtemplate.v4.*;

public class SetEntityType extends nextgen.actions.TransactionAction {

   private final nextgen.model.DomainEntity domainEntity;
   private final JComponent owner;

	public SetEntityType(nextgen.model.DomainEntity domainEntity, JComponent owner) {
		super("Edit");
		this.domainEntity = domainEntity;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetEntityType" + " domainEntity" + " owner");

      final java.util.List<JComponent> components = new java.util.ArrayList<>();
      for (int i = 0; i < 1; i++) {
         components.add(newTextField(domainEntity.getName(),30));
         components.add(newComboBox(DomainEntityType.values(), domainEntity.getType()));
         components.add(newTextField(domainEntity.getEnums(""),30));
      }

      final JPanel inputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(components.size() + 1, 3));
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
            
            domainEntity.setName(name);
            domainEntity.setType((nextgen.model.DomainEntityType) cboType.getSelectedItem());
            domainEntity.setEnums(txtEnumValues.getText().trim());
            
            nextgen.events.DomainEntityChanged.post(domainEntity);
         }

         close(jDialog);
      });
   }

}