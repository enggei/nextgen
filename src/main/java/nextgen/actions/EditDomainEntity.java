package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;
import java.util.stream.Collectors;

import org.stringtemplate.v4.*;

public class EditDomainEntity extends nextgen.actions.TransactionAction {

   private final nextgen.model.DomainEntity domainEntity;
   private final JComponent owner;

	public EditDomainEntity(nextgen.model.DomainEntity domainEntity, JComponent owner) {
		super("Edit");
		this.domainEntity = domainEntity;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("EditDomainEntity" + " domainEntity" + " owner");

      final java.util.List<JComponent> entityComponents = new java.util.ArrayList<>();
      entityComponents.add(newTextField(domainEntity.getName(), 30));
      entityComponents.add(newComboBox(DomainEntityType.values(), domainEntity.getType()));
      entityComponents.add(newTextField(domainEntity.getEnums(""), 30));

      final JPanel entityInputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(2, 3));
      entityInputPanel.add(newLabel("Name"));
      entityInputPanel.add(newLabel("Type"));
      entityInputPanel.add(newLabel("EnumValues"));
      entityInputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (JComponent component : entityComponents) entityInputPanel.add(component);

      final java.util.List<JComponent> relationsComponents = new java.util.ArrayList<>();
      final java.util.Map<javax.swing.JTextField, nextgen.model.DomainRelation> fieldDomainRelationMap = new java.util.LinkedHashMap<>();
      domainEntity.getIncomingEntitiesDomain().findFirst().get().getRelations()
            .filter(domainRelation -> domainRelation.getSrc().equals(domainEntity))
            .forEach(domainRelation -> {
               final javax.swing.JTextField textField = newTextField(domainRelation.getName(), 30);
               fieldDomainRelationMap.put(textField, domainRelation);
               relationsComponents.add(textField);
               relationsComponents.add(newComboBox(DomainRelationType.values(), domainRelation.getType()));
               relationsComponents.add(newTextField(domainRelation.getDst().getName(), 30));        
            });

      for (int i = 0; i < 5; i++) {
         relationsComponents.add(newTextField(30));
         relationsComponents.add(newComboBox(DomainRelationType.values(), DomainRelationType.ONE));
         relationsComponents.add(newTextField(30));
      }

      final JPanel relationInputPanel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.GridLayout(fieldDomainRelationMap.size() + 6, 3));
      relationInputPanel.add(newLabel("Name"));
      relationInputPanel.add(newLabel("Type"));
      relationInputPanel.add(newLabel("Dst"));
      relationInputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
      for (JComponent component : relationsComponents) relationInputPanel.add(component);

      final JPanel contentPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
      contentPanel.add(entityInputPanel, java.awt.BorderLayout.NORTH);
      contentPanel.add(relationInputPanel, java.awt.BorderLayout.CENTER);

      showDialog(owner, contentPanel, "Domain Entity", jDialog -> {

         final JTextField entityName = (JTextField) entityComponents.get(0);
         final JComboBox<DomainEntityType> entityType = (JComboBox<DomainEntityType>) entityComponents.get(1);
         final JTextField enumValues = (JTextField) entityComponents.get(2);

         domainEntity.setName(entityName.getText().trim());
         domainEntity.setType((nextgen.model.DomainEntityType) entityType.getSelectedItem());
         domainEntity.setEnums(enumValues.getText().trim());
         nextgen.events.DomainEntityChanged.post(domainEntity);

         for (int i = 0; i < relationsComponents.size(); i += 3) {
            final JTextField relationName = (JTextField) relationsComponents.get(i);
            final JComboBox<DomainRelationType> relationType = (JComboBox<DomainRelationType>) relationsComponents.get(i + 1);
            final JTextField relationEntityName = (JTextField) relationsComponents.get(i + 2);

            if (relationName.getText().trim().length() == 0) continue;

            nextgen.model.DomainRelation domainRelation = fieldDomainRelationMap.get(relationName);
            if (domainRelation == null)
               domainRelation = appModel().addDomainRelation(domainEntity, relationName.getText().trim(), (nextgen.model.DomainRelationType) relationType.getSelectedItem(), relationEntityName.getText().trim());
            else
               domainRelation.setName(relationName.getText().trim())
                  .setType((nextgen.model.DomainRelationType) relationType.getSelectedItem());

            if (!domainRelation.getDst().getName().equals(relationEntityName.getText().trim()))
               domainRelation.setDst(appModel().addDomainEntity(domainEntity.getIncomingEntitiesDomain().findFirst().get(), relationEntityName.getText().trim(), nextgen.model.DomainEntityType.ENTITY, ""));

            nextgen.events.DomainRelationChanged.post(domainRelation);
         }

         close(jDialog);
      });
   }

}