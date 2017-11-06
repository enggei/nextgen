package com.generator.app;

import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import com.generator.generators.domain.DomainVisitor;
import com.generator.neo.NeoModel;
import org.neo4j.graphdb.*;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.util.NeoUtil.*;

/**
 * Created 25.08.17.
 */
public class DomainMotif {

   // todo cleanup these methods

   public static String getName(NeoNode neoNode) {
      return getName(neoNode.getNode());
   }

   public static String getName(PropertyContainer node) {
      return getEntityProperty(node, AppMotif.Properties.name.name());
   }

   public static void setName(PropertyContainer node, String name) {
      node.setProperty(AppMotif.Properties.name.name(), name);
   }

   public static void setName(NeoNode neoNode, String name) {
      setName(neoNode.getNode(), name);
   }

   // Domain utility-methods
   public static Node newDomainEntity(NeoModel graph, Label label, Node domainNode) {

      final Set<Node> foundEntity = new LinkedHashSet<>();
      new DomainVisitor<Void>(true) {
         @Override
         public void visitEntity(Node node) {
            if (label.name().equals(get(node, AppMotif.Properties.name.name())))
               foundEntity.add(node);
            super.visitEntity(node);
         }
      }.visit(domainNode);

      if (foundEntity.isEmpty())
         foundEntity.add(graph.newNode(DomainPlugin.Entities.Entity, AppMotif.Properties.name.name(), label.name()));

      return foundEntity.iterator().next();
   }

   public static void newDomainEntityProperty(NeoModel graph, Node domainNode, Node srcEntity, String name) {

      final Set<Node> foundProperty = new LinkedHashSet<>();
      new DomainVisitor<Void>(false) {

         @Override
         public void visitProperty(Node node) {
            super.visitProperty(node);
            if(name.equals(getEntityProperty(node, AppMotif.Properties.name.name())))
               foundProperty.add(node);
         }
      }.visitDomain(domainNode);

      if(foundProperty.isEmpty()) {
         newDomainEntityRelation(graph, srcEntity, name, DomainPlugin.RelationCardinality.SINGLE, graph.newNode(DomainPlugin.Entities.Property, AppMotif.Properties.name.name(), name));
      } else {
         newDomainEntityRelation(graph, srcEntity, name, DomainPlugin.RelationCardinality.SINGLE, foundProperty.iterator().next());
      }
   }

   public static Node newDomainEntityRelation(NeoModel graph, Node srcEntity, String name, DomainPlugin.RelationCardinality relationCardinality, Node... dstEntities) {

      if (dstEntities.length == 0) throw new IllegalArgumentException("must have at least 1 dstEntity");

      // check if already related
      for (Relationship relationship : outgoing(srcEntity, DomainPlugin.Relations.SRC)) {
         final Node existingRelationNode = other(srcEntity, relationship);
         if (!name.equals(getString(existingRelationNode, AppMotif.Properties.name.name()))) continue;

         // same name on relation, merge any new dst to it
         final Set<Node> existingDst = new LinkedHashSet<>();
         for (Relationship dstRelation : outgoing(existingRelationNode, DomainPlugin.Relations.DST)) {
            final Node existingDstEntity = other(existingRelationNode, dstRelation);
            for (Node dstEntity : dstEntities) {
               final String existingName = getString(existingDstEntity, AppMotif.Properties.name.name());
               final String newName = getString(dstEntity, AppMotif.Properties.name.name());
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

   public static Node newValueNode(NeoModel graph, Object value) {
      return graph.newNode(DomainPlugin.Entities.Value, AppMotif.Properties.name.name(), value);
   }

   public static Node newInstanceNode(NeoModel graph, String label, Node referenceNode) {
      final Node newNode = graph.newNode(Label.label(label));
      referenceNode.createRelationshipTo(newNode, DomainPlugin.Relations.INSTANCE);
      return newNode;
   }

   public static <T> T getEntityProperty(PropertyContainer propertyContainer, String propertyName) {

      if (propertyContainer instanceof Relationship) return get(propertyContainer, propertyName);

      final T entityProperty = getEntityProperty(propertyContainer, propertyName, null);
      if (entityProperty == null)
         return get(propertyContainer, propertyName);
      return entityProperty;
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
      final Iterator<Relationship> incoming = incoming(existingProperty).iterator();
      if (!incoming.hasNext()) existingProperty.delete();
   }

   public static void setEntityProperty(NeoModel graph, PropertyContainer propertyContainer, String propertyName, Object value) {

      boolean isNullValue = value == null || value.toString().length() == 0;

      if (propertyContainer instanceof Relationship) {

         if (isNullValue && propertyContainer.hasProperty(propertyName)) {
            propertyContainer.removeProperty(propertyName);
            return;
         }

         propertyContainer.setProperty(propertyName, value);
         return;
      }

      final Node node = (Node) propertyContainer;
      final Relationship existingRelation = singleOutgoing(node, RelationshipType.withName(propertyName));

      // if new value is null and there is a relation, delete it and return
      if (isNullValue && existingRelation != null) {

         final Node existingProperty = other(node, existingRelation);
         existingRelation.delete();

         if (propertyContainer.hasProperty(propertyName)) propertyContainer.removeProperty(propertyName);

         // if existing property-node has other relations, keep it, if not - delete it
         final AtomicBoolean deletable = new AtomicBoolean(true);
         incoming(existingProperty).forEach(relationship -> {
            if (AppMotif.Relations._LAYOUT_MEMBER.name().equals(relationship.getType().name())) return;
            deletable.set(false);
         });

         if(deletable.get()) {
            incoming(existingProperty).forEach(Relationship::delete);
            existingProperty.delete();
         }

         return;
      }

      if (existingRelation != null) {

         // if same value, keep and return
         final Node existingProperty = other(node, existingRelation);
         if (value.equals(get(existingProperty, AppMotif.Properties.name.name()))) return;

         existingRelation.delete();

         // if existing property-node has other relations, keep it, if not - delete it
         final Iterator<Relationship> incoming = incoming(existingProperty).iterator();
         if (!incoming.hasNext()) existingProperty.delete();
      }

      // create new value-node and relate to entity
      relate(node, newValueNode(graph, value), RelationshipType.withName(propertyName));
   }
}