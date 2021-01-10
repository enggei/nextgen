package tmp.neo4jembeddedvisitor;

import static nextgen.utils.SwingUtil.*;
import static nextgen.swing.ComponentFactory.*;
import nextgen.model.*;
import javax.swing.*;
import org.neo4j.graphdb.Transaction;
import java.awt.event.ActionEvent;

public class Neo4JEmbeddedVisitor extends nextgen.actions.TransactionAction {

   private final nextgen.model.Domain domain;
   private final javax.swing.JComponent owner;

	public Neo4JEmbeddedVisitor(nextgen.model.Domain domain, javax.swing.JComponent owner) {
		super("Neo4JEmbeddedVisitor");
		this.domain = domain;
		this.owner = owner;
	}

   @Override
   protected void actionPerformed(ActionEvent actionEvent, Transaction transaction) {
   	log.info("Neo4JEmbeddedVisitor" + " domain" + " owner");

      final java.util.List<DomainEntity> entities = domain.getEntitiesSorted().collect(java.util.stream.Collectors.toList());
      final java.util.List<DomainRelation> relations = domain.getRelationsSorted().collect(java.util.stream.Collectors.toList());

      onDomain(domain.getName());

      for (DomainEntity entity : entities)
      	onEntity(entity);

      for (DomainRelation relation : relations)
      	onRelation(relation);

      onComplete();
   }

   public void onDomain(String name) {
   	System.out.println("on domain " + name);
   }

   public void onEntity(DomainEntity entity) {
   	System.out.println("\ton entity " + entity.getName());
   }

   public void onRelation(DomainRelation relation) {
   	System.out.println("\ton relation " + relation.getName() + " " + relation.getSrc() + " " + relation.getType() + " " + relation.getDst());
   }

   public void onComplete() {
   	System.out.println();
   }
}