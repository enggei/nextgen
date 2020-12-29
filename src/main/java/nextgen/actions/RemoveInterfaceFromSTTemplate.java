package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class RemoveInterfaceFromSTTemplate extends TransactionAction {

   private final STGroupModel stGroup;
   private final STTemplate stTemplate;
   private final String interfaceName;
   private final JComponent owner;

	public RemoveInterfaceFromSTTemplate(String name, STGroupModel stGroup, STTemplate stTemplate, String interfaceName, JComponent owner) {
      super(name);
      this.stGroup = stGroup;
      this.stTemplate = stTemplate;
      this.interfaceName = interfaceName;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("RemoveInterfaceFromSTTemplate" + " stGroup" + " stTemplate" + " interfaceName" + " owner");

      confirm(owner, "Remove", unused -> {
         stTemplate.removeImplements(interfaceName);
         nextgen.events.STTemplateInterfaceRemoved.post(stGroup, stTemplate, interfaceName);
      });
   }

}