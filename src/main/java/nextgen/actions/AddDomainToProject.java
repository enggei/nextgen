package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddDomainToProject extends TransactionAction {

   private final STProject project;
   private final JComponent owner;

	public AddDomainToProject(STProject project, JComponent owner) {
		super("Add Domain");
		this.project = project;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddDomainToProject" + " project" + " owner");

      final java.util.List<JTextField> fields = new java.util.ArrayList<>();
      for (int i = 0; i < 1; i++) {
         fields.add(newTextField(30));
      }

      final JPanel inputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(fields.size(), 1));
      inputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (JTextField field : fields) {
         inputPanel.add(field);
      }

      showDialog(owner, inputPanel, "Values", jDialog -> {

         for (JTextField field : fields) {
            final String value = field.getText().trim();
            if(value.length()==0) continue;
            appModel().addDomain(project, value);
         }

         close(jDialog);
      });
   }

}