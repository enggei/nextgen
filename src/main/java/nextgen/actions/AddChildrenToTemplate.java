package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class AddChildrenToTemplate extends nextgen.actions.TransactionAction {

   private final STGroupModel stGroup;
   private final STTemplate stTemplate;
   private final java.util.Set<STTemplate> children;
   private final JComponent owner;

	public AddChildrenToTemplate(String name, STGroupModel stGroup, STTemplate stTemplate, java.util.Set<STTemplate> children, JComponent owner) {
      super(name);
      this.stGroup = stGroup;
      this.stTemplate = stTemplate;
      this.children = children;
      this.owner = owner;
   }

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("AddChildrenToTemplate" + " stGroup" + " stTemplate" + " children" + " owner");

      confirm(owner, "Sure ?", unused -> {
         appModel().aggregateTemplates(stGroup).forEach(stGroupTemplate -> {
            for (STTemplate child : children) {
               stGroupTemplate.removeChildren(child);
            }
         });

         for (STTemplate child : children)
            stTemplate.addChildren(child);

         nextgen.events.STTemplateChildrenAdded.post(stGroup, stTemplate, children);   
      });
   }

}