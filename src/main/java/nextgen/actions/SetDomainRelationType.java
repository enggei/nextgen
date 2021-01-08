package nextgen.actions;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class SetDomainRelationType extends TransactionAction {

   private final DomainRelation domainRelation;
   private final JComponent owner;

	public SetDomainRelationType(DomainRelation domainRelation, JComponent owner) {
		super("");
		setIcon("cb-get");
		this.domainRelation = domainRelation;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("SetDomainRelationType" + " domainRelation" + " owner");

      select(owner, java.util.Arrays.stream(DomainRelationType.values()).map(Enum::name).collect(java.util.stream.Collectors.toList()), domainRelation.getType().name(), selectedName -> {
         appModel().doLaterInTransaction(tx -> {
            domainRelation.setType(DomainRelationType.valueOf(selectedName));
            nextgen.events.DomainRelationChanged.post(domainRelation);
         });
      });
   }

}