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

      final java.util.List<JTextField> fields = new java.util.ArrayList<>();
      for (int i = 0; i < 10; i++) {
         fields.add(newTextField(30));
      }

      final JPanel inputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(fields.size(), 1));
      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (JTextField field : fields) {
         inputPanel.add(field);
      }

      showDialog(owner, inputPanel, "Entities", jDialog -> {

         for (JTextField field : fields) {
            final String value = field.getText().trim();
            if (value.length() == 0) continue;
            appModel().addDomainEntity(domain, value);
         }

         close(jDialog);
      });
   }

}