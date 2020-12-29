package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetInterfaces extends TransactionAction {

   private final STGroupModel stGroup;
   private final STTemplate stTemplate;
   private final JComponent owner;

	public SetInterfaces(STGroupModel stGroup, STTemplate stTemplate, JComponent owner) {
		super("Set interfaces");
		this.stGroup = stGroup;
		this.stTemplate = stTemplate;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetInterfaces" + " stGroup" + " stTemplate" + " owner");

      final java.util.List<JTextField> txtImplements = new java.util.ArrayList<>();
      stTemplate.getImplements().forEach(implement -> {
         final JTextField textField = newTextField(implement, 15);
         txtImplements.add(textField);
      });
      txtImplements.add(newTextField("", 15));
      txtImplements.add(newTextField("", 15));

      final JPanel contentPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(txtImplements.size(), 1));
      contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
      for (JTextField txtImplement : txtImplements)
         contentPanel.add(txtImplement);

      showDialog(owner, contentPanel, "Edit", jDialog -> {
         stTemplate.removeAllImplements();
         for (JTextField txtImplement : txtImplements) {
            final String trim = txtImplement.getText().trim();
            if (trim.length() == 0) continue;
            stTemplate.addImplements(trim);
         }

         nextgen.events.STTemplateInterfacesChanged.post(stGroup, stTemplate);
         SwingUtilities.invokeLater(jDialog::dispose);
      });
   }

}