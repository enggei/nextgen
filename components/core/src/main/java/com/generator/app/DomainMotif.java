package com.generator.app;

import com.generator.generators.domain.DomainDomainPlugin;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.domain.DomainVisitor;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.util.NeoUtil.*;

/**
 * Created 25.08.17.
 */
public class DomainMotif {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainMotif.class);

   // Domain utility-methods

   public static Node newDomainNode(NeoModel graph, String name) {

      final Set<Node> foundDomain = new LinkedHashSet<>();
      graph.getAll(DomainPlugin.Entities.Domain.name()).forEach(domainNode -> {
         if (name.equals(getEntityProperty(domainNode, AppMotif.Properties.name.name())))
            foundDomain.add(domainNode);
      });

      if (foundDomain.isEmpty()) {
         log.info("new DomainNode " + name);
         return graph.newNode(DomainPlugin.Entities.Domain.name(), AppMotif.Properties.name.name(), name);
      }

      return foundDomain.iterator().next();
   }

   public static Node newDomainEntity(NeoModel graph, Label label, Node domainNode) {

      final Set<Node> foundEntity = new LinkedHashSet<>();
      new DomainVisitor<Void>(false) {
         @Override
         public void visitEntity(Node node) {
            if (label.name().equals(getEntityProperty(node, AppMotif.Properties.name.name())))
               foundEntity.add(node);
            super.visitEntity(node);
         }
      }.visit(domainNode);

      if (foundEntity.isEmpty()) {
         log.info("new EntityNode " + label.name());
         foundEntity.add(graph.newNode(DomainPlugin.Entities.Entity, AppMotif.Properties.name.name(), label.name()));
      }

      return foundEntity.iterator().next();
   }

   public static void newDomainEntityProperty(NeoModel graph, Node domainNode, Node srcEntity, String name) {

      final Set<Node> foundProperty = new LinkedHashSet<>();
      new DomainVisitor<Void>(false) {

         @Override
         public void visitProperty(Node node) {
            super.visitProperty(node);
            if (name.equals(getEntityProperty(node, AppMotif.Properties.name.name())))
               foundProperty.add(node);
         }
      }.visitDomain(domainNode);

      if (foundProperty.isEmpty()) {
         newDomainEntityRelation(graph, srcEntity, name, DomainDomainPlugin.RelationCardinality.SINGLE, graph.newNode(DomainPlugin.Entities.Property, AppMotif.Properties.name.name(), name));
      } else {
         newDomainEntityRelation(graph, srcEntity, name, DomainDomainPlugin.RelationCardinality.SINGLE, foundProperty.iterator().next());
      }
   }

   public static Node newDomainEntityRelation(NeoModel graph, Node srcEntity, String name, DomainDomainPlugin.RelationCardinality relationCardinality, Node... dstEntities) {

      if (dstEntities.length == 0) throw new IllegalArgumentException("must have at least 1 dstEntity");

      // check if already related
      for (Relationship relationship : outgoing(srcEntity, DomainPlugin.Relations.SRC)) {
         final Node existingRelationNode = other(srcEntity, relationship);
         if (!name.equals(getName(existingRelationNode))) continue;

         // same name on relation, merge any new dst to it
         final Set<Node> existingDst = new LinkedHashSet<>();
         for (Relationship dstRelation : outgoing(existingRelationNode, DomainPlugin.Relations.DST)) {
            final Node existingDstEntity = other(existingRelationNode, dstRelation);
            for (Node dstEntity : dstEntities) {
               final String existingName = getName(existingDstEntity);
               final String newName = getName(dstEntity);
               if (existingName == null || newName == null) continue;
               if (existingName.equals(newName)) existingDst.add(dstEntity);
            }
         }

         // set relation
         existingRelationNode.setProperty(DomainPlugin.Properties.relationCardinality.name(), relationCardinality.name());

         // add any new dstEntities
         for (Node dstEntity : dstEntities) {
            if (existingDst.contains(dstEntity)) continue;
            existingRelationNode.createRelationshipTo(dstEntity, DomainPlugin.Relations.DST);
         }

         return existingRelationNode;
      }

      // not related, create new
      final Node newRelationNode = graph.newNode(DomainPlugin.Entities.Relation,
            AppMotif.Properties.name.name(), name,
            DomainPlugin.Properties.relationCardinality.name(), relationCardinality.name());
      srcEntity.createRelationshipTo(newRelationNode, DomainPlugin.Relations.SRC);

      for (Node dstEntity : dstEntities) newRelationNode.createRelationshipTo(dstEntity, DomainPlugin.Relations.DST);

      return newRelationNode;
   }

   // specific domain utilities

   public static String getName(Node node) {
      return getEntityProperty(node, AppMotif.Properties.name.name());
   }

   public static Node newValueNode(NeoModel graph, Object value) {
      return graph.newNode(DomainPlugin.Entities.Value, AppMotif.Properties.name.name(), value);
   }

   public static Node findOrCreateInstanceNode(NeoModel graph, String name, Node referenceNode) {

      final Set<Node> found = new LinkedHashSet<>();
      DomainPlugin.outgoingINSTANCE(referenceNode, (relationship, instanceNode) -> {
         if (name.equals(getName(instanceNode)))
            found.add(instanceNode);
      });

      if (found.isEmpty()) {
         final Node newInstanceNode = newInstanceNode(graph, referenceNode);
         setEntityProperty(graph, newInstanceNode, AppMotif.Properties.name.name(), name);
         found.add(newInstanceNode);
      }

      return found.iterator().next();
   }

   @Deprecated
   public static Node newInstanceNode(NeoModel graph, String label, Node referenceNode) {
      final Node newNode = graph.newNode(label);
      referenceNode.createRelationshipTo(newNode, DomainPlugin.Relations.INSTANCE);
      return newNode;
   }

   public static Node newInstanceNode(NeoModel graph, Label label, Node referenceNode) {
      final Node newNode = graph.newNode(label);
      referenceNode.createRelationshipTo(newNode, DomainPlugin.Relations.INSTANCE);
      return newNode;
   }

   public static Node newInstanceNode(NeoModel graph, Node referenceNode) {
      final Node newInstanceNode = graph.newNode(Label.label(getName(referenceNode)));
      referenceNode.createRelationshipTo(newInstanceNode, DomainPlugin.Relations.INSTANCE);
      return newInstanceNode;
   }

   public static <T> T getEntityProperty(PropertyContainer propertyContainer, String propertyName) {
      return getEntityProperty(propertyContainer, propertyName, null);
   }

   public static <T> T getEntityProperty(PropertyContainer propertyContainer, String propertyName, T defaultValue) {

      if (propertyContainer instanceof Relationship) return get(propertyContainer, propertyName, defaultValue);

      final Node node = (Node) propertyContainer;
      final Relationship valueRelation = singleOutgoing(node, RelationshipType.withName(propertyName));
      if (valueRelation == null)
         return get(node, propertyName, defaultValue);
      return get(other(node, valueRelation), AppMotif.Properties.name.name(), defaultValue);
   }

   public static boolean hasEntityProperty(PropertyContainer propertyContainer, String propertyName) {

      if (propertyContainer instanceof Relationship) return has(propertyContainer, propertyName);

      final Node node = (Node) propertyContainer;
      final boolean hasOutgoing = hasOutgoing(node, RelationshipType.withName(propertyName));
      return hasOutgoing || has(node, propertyName);
   }

   public static void removeEntityProperty(PropertyContainer propertyContainer, String propertyName) {

      if (propertyContainer instanceof Relationship) {
         if (propertyContainer.hasProperty(propertyName)) propertyContainer.removeProperty(propertyName);
         return;
      }

      final Node node = (Node) propertyContainer;
      final Relationship existingRelation = singleOutgoing(node, RelationshipType.withName(propertyName));
      if (existingRelation == null) {
         if (node.hasProperty(propertyName)) node.removeProperty(propertyName);
         return;
      }

      final Node existingProperty = other(node, existingRelation);
      existingRelation.delete();

      // if existing property-node has other relations, keep it, if not - delete it
      tryToDeleteNode(existingProperty, false);
   }

   public static Set<Node> tryToDeleteNode(Node node, boolean force) {

      final Set<Node> deletedNodes = new LinkedHashSet<>();

      // check node-dependencies (incoming relations)
      final AtomicBoolean deletable = new AtomicBoolean(true);
      incoming(node).forEach(relationship -> {
         if (AppMotif.Relations._LAYOUT_MEMBER.name().equals(relationship.getType().name())) return;
         if (DomainPlugin.Relations.INSTANCE.name().equals(relationship.getType().name())) return;
         deletable.set(false);   // has incoming relation which is not system-specific, not deletable (unless force=true)
      });

      // if existing node has other relations, keep it, if not - delete it (unless force=true)
      if (force || deletable.get()) {
         incoming(node).forEach(Relationship::delete);

         // follow all outgoing relations for this node, and try to delete these as well
         outgoing(node).forEach(relationship -> {
            deletedNodes.addAll(tryToDeleteNode(other(node, relationship), false));
            try {
               relationship.delete();
            } catch (NotFoundException e) {
               log.warn("relationship is already deleted.");
            }
         });

         deletedNodes.add(node);
         node.delete();
      }

      return deletedNodes;
   }

   public static void setEntityProperty(NeoModel graph, PropertyContainer propertyContainer, String propertyName, Object value) {

      boolean isNullValue = value == null || value.toString().length() == 0 || "false".equals(value.toString().toLowerCase());

      if (propertyContainer instanceof Relationship) {

         if (isNullValue && propertyContainer.hasProperty(propertyName)) {
            propertyContainer.removeProperty(propertyName);
            return;
         }
         if (isNullValue) return;

         propertyContainer.setProperty(propertyName, "true".equals(value.toString().toLowerCase()) ? true : value);
         return;
      }

      final Node node = (Node) propertyContainer;
      final Relationship existingRelation = singleOutgoing(node, RelationshipType.withName(propertyName));

      // if new value is null and there is a relation, delete it and return
      if (isNullValue && existingRelation != null) {

         final Node existingProperty = other(node, existingRelation);
         existingRelation.delete();

         if (propertyContainer.hasProperty(propertyName)) propertyContainer.removeProperty(propertyName);

         tryToDeleteNode(existingProperty, false);
         return;
      }

      if (existingRelation != null) {

         // if same value, keep and return
         final Node existingProperty = other(node, existingRelation);
         if (value.equals(get(existingProperty, AppMotif.Properties.name.name()))) return;

         existingRelation.delete();

         tryToDeleteNode(existingProperty, false);
      }

      if (isNullValue) return;

      // create new value-node and relate to entity
      relate(node, newValueNode(graph, "true".equals(value.toString().toLowerCase()) ? true : value), RelationshipType.withName(propertyName));
   }
}