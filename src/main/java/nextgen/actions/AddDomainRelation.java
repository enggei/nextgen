package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddDomainRelation extends nextgen.actions.TransactionAction {

   private final nextgen.model.DomainEntity domainEntity;
   private final JComponent owner;

	public AddDomainRelation(nextgen.model.DomainEntity domainEntity, JComponent owner) {
		super("Add Relations");
		this.domainEntity = domainEntity;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddDomainRelation" + " domainEntity" + " owner");

      final java.util.List<JComponent> components = new java.util.ArrayList<>();
      for (int i = 0; i < 10; i++) {
         components.add(newTextField(30));
         components.add(newTextField(30));
         components.add(newComboBox(DomainRelationType.values(), DomainRelationType.ONE));
      }

      final JPanel inputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(10, 3));
      inputPanel.add(newLabel("Relation"));
      inputPanel.add(newLabel("Type"));
      inputPanel.add(newLabel("Entity"));
      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

      for (JComponent component : components) inputPanel.add(component);

      showDialog(owner, inputPanel, "Relations", jDialog -> {

         for (int i = 0; i < components.size(); i += 3) {
            final JTextField txtRelationName = (JTextField) components.get(i);
            final JComboBox<DomainRelationType> cboType = (JComboBox<DomainRelationType>) components.get(i + 1);
            final JTextField txtEntityName = (JTextField) components.get(i + 2);


            final String name = txtRelationName.getText().trim();
            if (name.length() == 0) continue;
            final String value = txtEntityName.getText().trim();
            if (value.length() == 0) continue;

            appModel().addDomainRelation(domainEntity, name, (DomainRelationType) cboType.getSelectedItem(), value);
         }

         close(jDialog);
      });
   }

}