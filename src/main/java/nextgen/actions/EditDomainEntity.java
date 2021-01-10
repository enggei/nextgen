package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class EditDomainEntity extends nextgen.actions.TransactionAction {

   private final nextgen.model.DomainEntity domainEntity;
   private final JComponent owner;

	public EditDomainEntity(String name, nextgen.model.DomainEntity domainEntity, JComponent owner) {
      super(name);
      this.domainEntity = domainEntity;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("EditDomainEntity" + " domainEntity" + " owner");

      final java.util.List<JComponent> relationComponents = new java.util.ArrayList<>();
      for (int i = 0; i < 10; i++) {
         relationComponents.add(newTextField(30));
         relationComponents.add(newTextField(30));
         relationComponents.add(newComboBox(DomainRelationType.values(), DomainRelationType.ONE));
      }

      final JPanel relationPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(10, 3));
      relationPanel.add(newLabel("Relation"));
      relationPanel.add(newLabel("Type"));
      relationPanel.add(newLabel("Entity"));
      relationPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (JComponent component : relationComponents) relationPanel.add(component);

      showDialog(owner, relationPanel, "Edit DomainEntity", jDialog -> {

         for (int i = 0; i < relationComponents.size(); i += 3) {
            final JTextField txtRelationName = (JTextField) relationComponents.get(i);
            final JComboBox<DomainRelationType> cboType = (JComboBox<DomainRelationType>) relationComponents.get(i + 1);
            final JTextField txtEntityName = (JTextField) relationComponents.get(i + 2);


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