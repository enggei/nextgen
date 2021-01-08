package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddDomainPropertyToEntity extends TransactionAction {

   private final nextgen.model.DomainEntity domainEntity;
   private final JComponent owner;

	public AddDomainPropertyToEntity(nextgen.model.DomainEntity domainEntity, JComponent owner) {
		super("Add Properties");
		this.domainEntity = domainEntity;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddDomainPropertyToEntity" + " domainEntity" + " owner");

      final java.util.List<JTextField> fields = new java.util.ArrayList<>();
      for (int i = 0; i < 10; i++) {
         fields.add(newTextField(30));
         fields.add(newTextField(30));
      }

      final JPanel inputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(fields.size() + 1, 2));
      inputPanel.add(newLabel("Name"));
      inputPanel.add(newLabel("Value"));
      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (JTextField field : fields) {
         inputPanel.add(field);
      }

      showDialog(owner, inputPanel, "Entities", jDialog -> {

         for (int i = 0; i < fields.size(); i += 2) {
            JTextField txtName = fields.get(i);
            JTextField txtValue = fields.get(i);

            final String name = txtName.getText().trim();
            if (name.length() == 0) continue;
            final String value = txtValue.getText().trim();
            if (value.length() == 0) continue;

            appModel().addEntityProperty(domainEntity, name, value);
         }

         close(jDialog);
      });
   }

}