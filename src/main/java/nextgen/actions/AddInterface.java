package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddInterface extends TransactionAction {

   private final java.util.Set<STTemplate> children;
   private final JComponent owner;

	public AddInterface(String name, java.util.Set<STTemplate> children, JComponent owner) {
      super(name);
      this.children = children;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddInterface" + " children" + " owner");

      final JTextField txtImplements = newTextField();
      final JPanel contentPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(1, 1));
      contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
      contentPanel.add(txtImplements);

      showDialog(owner, contentPanel, "Add interface", jDialog -> {
         final String interfaceName = txtImplements.getText().trim();
         if (interfaceName.length()==0) return;
         for (STTemplate child : children) {
            final java.util.Optional<String> optional = child.getImplements().filter(s -> s.equalsIgnoreCase(interfaceName)).findAny();
            if(optional.isPresent()) continue;
            child.addImplements(interfaceName);
         }
         close(jDialog);   
      });
   }

}