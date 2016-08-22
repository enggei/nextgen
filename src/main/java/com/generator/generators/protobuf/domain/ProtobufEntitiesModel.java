package com.generator.generators.protobuf.domain;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.helpers.collection.Iterators;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * GENERATED* http://docs.neo4j.org/chunked/stable/tutorials-java-embedded-new-index.html
 * http://docs.neo4j.org/chunked/milestone/tutorials-cypher-java.html
 * http://docs.neo4j.org/chunked/milestone/query-match.html
 */
public class ProtobufEntitiesModel {

   protected final GraphDatabaseService graphDb;
   private final Index<Node> uuids;

   public ProtobufEntitiesModel(GraphDatabaseService graphDb, String name) {
      this.graphDb = graphDb;

      try (Transaction tx = graphDb.beginTx()) {
         this.uuids = graphDb.index().forNodes("uuid");
         tx.success();
      }
   }

   public Transaction beginTx() {
      return graphDb.beginTx();
   }

   public ProtobufEntitiesModel delete(final UUID uuid) {

      if (getNode(uuid) == null) return this;

      try (Transaction tx = graphDb.beginTx()) {
         getNode(uuid).delete();
         tx.success();
      }

      return this;
   }


   public ProtobufEnum newProtobufEnum() {
      return new ProtobufEnumNode(newNode(ProtobufEntities.class.getName(), UUID.randomUUID(), ProtobufEntities.ProtobufEnum.name()), graphDb);
   }

   public Set<ProtobufEnum> getProtobufEnumSet() {
      final Set<ProtobufEnum> result = new LinkedHashSet<>();
      try (Transaction tx = graphDb.beginTx()) {
         final Result res = graphDb.execute("MATCH (entity:ProtobufEnum) RETURN entity");
         Iterator<Node> n_column = res.columnAs("entity");
         for (Node node : Iterators.asIterable(n_column))
            result.add(new ProtobufEnumNode(node, graphDb));
         tx.success();
      }
      return result;
   }

   public ProtobufEnum getProtobufEnumNode(final UUID uuid) {
//      try (Transaction tx = graphDb.beginTx()) {
//         final ResourceIterator<Node> it = graphDb.findNodesByLabelAndProperty(DynamicLabel.label(ProtobufEntities.ProtobufEnum.name()), "uuid", uuid.toString()).iterator();
//         final ProtobufEnumNode result = (it.hasNext()) ? new ProtobufEnumNode(it.next(), graphDb) : null;
//         it.close();
//         tx.success();
//         return result;
//      }
		return null;
   }

   public ProtobufEnumValue newProtobufEnumValue() {
      return new ProtobufEnumValueNode(newNode(ProtobufEntities.class.getName(), UUID.randomUUID(), ProtobufEntities.ProtobufEnumValue.name()), graphDb);
   }

   public Set<ProtobufEnumValue> getProtobufEnumValueSet() {
      final Set<ProtobufEnumValue> result = new LinkedHashSet<>();
      try (Transaction tx = graphDb.beginTx()) {
         final Result res = graphDb.execute("MATCH (entity:ProtobufEnumValue) RETURN entity");
         Iterator<Node> n_column = res.columnAs("entity");
         for (Node node : Iterators.asIterable(n_column))
            result.add(new ProtobufEnumValueNode(node, graphDb));
         tx.success();
      }
      return result;
   }

//   public ProtobufEnumValue getProtobufEnumValueNode(final UUID uuid) {
//      try (Transaction tx = graphDb.beginTx()) {
//         final ResourceIterator<Node> it = graphDb.findNodesByLabelAndProperty(DynamicLabel.label(ProtobufEntities.ProtobufEnumValue.name()), "uuid", uuid.toString()).iterator();
//         final ProtobufEnumValueNode result = (it.hasNext()) ? new ProtobufEnumValueNode(it.next(), graphDb) : null;
//         it.close();
//         tx.success();
//         return result;
//      }
//   }

   public ProtobufFieldConstraint newProtobufFieldConstraint() {
      return new ProtobufFieldConstraintNode(newNode(ProtobufEntities.class.getName(), UUID.randomUUID(), ProtobufEntities.ProtobufFieldConstraint.name()), graphDb);
   }

   public Set<ProtobufFieldConstraint> getProtobufFieldConstraintSet() {
      final Set<ProtobufFieldConstraint> result = new LinkedHashSet<>();
      try (Transaction tx = graphDb.beginTx()) {
         final Result res = graphDb.execute("MATCH (entity:ProtobufFieldConstraint) RETURN entity");
         Iterator<Node> n_column = res.columnAs("entity");
         for (Node node : Iterators.asIterable(n_column))
            result.add(new ProtobufFieldConstraintNode(node, graphDb));
         tx.success();
      }
      return result;
   }

//   public ProtobufFieldConstraint getProtobufFieldConstraintNode(final UUID uuid) {
//      try (Transaction tx = graphDb.beginTx()) {
//         final ResourceIterator<Node> it = graphDb.findNodesByLabelAndProperty(DynamicLabel.label(ProtobufEntities.ProtobufFieldConstraint.name()), "uuid", uuid.toString()).iterator();
//         final ProtobufFieldConstraintNode result = (it.hasNext()) ? new ProtobufFieldConstraintNode(it.next(), graphDb) : null;
//         it.close();
//         tx.success();
//         return result;
//      }
//   }

   public ProtobufFieldType newProtobufFieldType() {
      return new ProtobufFieldTypeNode(newNode(ProtobufEntities.class.getName(), UUID.randomUUID(), ProtobufEntities.ProtobufFieldType.name()), graphDb);
   }

   public Set<ProtobufFieldType> getProtobufFieldTypeSet() {
      final Set<ProtobufFieldType> result = new LinkedHashSet<>();
      try (Transaction tx = graphDb.beginTx()) {
         final Result res = graphDb.execute("MATCH (entity:ProtobufFieldType) RETURN entity");
         Iterator<Node> n_column = res.columnAs("entity");
         for (Node node : Iterators.asIterable(n_column))
            result.add(new ProtobufFieldTypeNode(node, graphDb));
         tx.success();
      }
      return result;
   }

//   public ProtobufFieldType getProtobufFieldTypeNode(final UUID uuid) {
//      try (Transaction tx = graphDb.beginTx()) {
//         final ResourceIterator<Node> it = graphDb.findNodesByLabelAndProperty(DynamicLabel.label(ProtobufEntities.ProtobufFieldType.name()), "uuid", uuid.toString()).iterator();
//         final ProtobufFieldTypeNode result = (it.hasNext()) ? new ProtobufFieldTypeNode(it.next(), graphDb) : null;
//         it.close();
//         tx.success();
//         return result;
//      }
//   }

   public ProtobufMessage newProtobufMessage() {
      return new ProtobufMessageNode(newNode(ProtobufEntities.class.getName(), UUID.randomUUID(), ProtobufEntities.ProtobufMessage.name()), graphDb);
   }

   public Set<ProtobufMessage> getProtobufMessageSet() {
      final Set<ProtobufMessage> result = new LinkedHashSet<>();
      try (Transaction tx = graphDb.beginTx()) {
         final Result res = graphDb.execute("MATCH (entity:ProtobufMessage) RETURN entity");
         Iterator<Node> n_column = res.columnAs("entity");
         for (Node node : Iterators.asIterable(n_column))
            result.add(new ProtobufMessageNode(node, graphDb));
         tx.success();
      }
      return result;
   }

//   public ProtobufMessage getProtobufMessageNode(final UUID uuid) {
//      try (Transaction tx = graphDb.beginTx()) {
//         final ResourceIterator<Node> it = graphDb.findNodesByLabelAndProperty(DynamicLabel.label(ProtobufEntities.ProtobufMessage.name()), "uuid", uuid.toString()).iterator();
//         final ProtobufMessageNode result = (it.hasNext()) ? new ProtobufMessageNode(it.next(), graphDb) : null;
//         it.close();
//         tx.success();
//         return result;
//      }
//   }

   public ProtobufMessageField newProtobufMessageField() {
      return new ProtobufMessageFieldNode(newNode(ProtobufEntities.class.getName(), UUID.randomUUID(), ProtobufEntities.ProtobufMessageField.name()), graphDb);
   }

   public Set<ProtobufMessageField> getProtobufMessageFieldSet() {
      final Set<ProtobufMessageField> result = new LinkedHashSet<>();
      try (Transaction tx = graphDb.beginTx()) {
         final Result res = graphDb.execute("MATCH (entity:ProtobufMessageField) RETURN entity");
         Iterator<Node> n_column = res.columnAs("entity");
         for (Node node : Iterators.asIterable(n_column))
            result.add(new ProtobufMessageFieldNode(node, graphDb));
         tx.success();
      }
      return result;
   }

//   public ProtobufMessageField getProtobufMessageFieldNode(final UUID uuid) {
//      try (Transaction tx = graphDb.beginTx()) {
//         final ResourceIterator<Node> it = graphDb.findNodesByLabelAndProperty(DynamicLabel.label(ProtobufEntities.ProtobufMessageField.name()), "uuid", uuid.toString()).iterator();
//         final ProtobufMessageFieldNode result = (it.hasNext()) ? new ProtobufMessageFieldNode(it.next(), graphDb) : null;
//         it.close();
//         tx.success();
//         return result;
//      }
//   }

   public ProtobufPackage newProtobufPackage() {
      return new ProtobufPackageNode(newNode(ProtobufEntities.class.getName(), UUID.randomUUID(), ProtobufEntities.ProtobufPackage.name()), graphDb);
   }

   public Set<ProtobufPackage> getProtobufPackageSet() {
      final Set<ProtobufPackage> result = new LinkedHashSet<>();
      try (Transaction tx = graphDb.beginTx()) {
         final Result res = graphDb.execute("MATCH (entity:ProtobufPackage) RETURN entity");
         Iterator<Node> n_column = res.columnAs("entity");
         for (Node node : Iterators.asIterable(n_column))
            result.add(new ProtobufPackageNode(node, graphDb));
         tx.success();
      }
      return result;
   }

//   public ProtobufPackage getProtobufPackageNode(final UUID uuid) {
//      try (Transaction tx = graphDb.beginTx()) {
//         final ResourceIterator<Node> it = graphDb.findNodesByLabelAndProperty(DynamicLabel.label(ProtobufEntities.ProtobufPackage.name()), "uuid", uuid.toString()).iterator();
//         final ProtobufPackageNode result = (it.hasNext()) ? new ProtobufPackageNode(it.next(), graphDb) : null;
//         it.close();
//         tx.success();
//         return result;
//      }
//   }

   public ProtobufPackageOption newProtobufPackageOption() {
      return new ProtobufPackageOptionNode(newNode(ProtobufEntities.class.getName(), UUID.randomUUID(), ProtobufEntities.ProtobufPackageOption.name()), graphDb);
   }

   public Set<ProtobufPackageOption> getProtobufPackageOptionSet() {
      final Set<ProtobufPackageOption> result = new LinkedHashSet<>();
      try (Transaction tx = graphDb.beginTx()) {
         final Result res = graphDb.execute("MATCH (entity:ProtobufPackageOption) RETURN entity");
         Iterator<Node> n_column = res.columnAs("entity");
         for (Node node : Iterators.asIterable(n_column))
            result.add(new ProtobufPackageOptionNode(node, graphDb));
         tx.success();
      }
      return result;
   }

//   public ProtobufPackageOption getProtobufPackageOptionNode(final UUID uuid) {
//      try (Transaction tx = graphDb.beginTx()) {
//         final ResourceIterator<Node> it = graphDb.findNodesByLabelAndProperty(DynamicLabel.label(ProtobufEntities.ProtobufPackageOption.name()), "uuid", uuid.toString()).iterator();
//         final ProtobufPackageOptionNode result = (it.hasNext()) ? new ProtobufPackageOptionNode(it.next(), graphDb) : null;
//         it.close();
//         tx.success();
//         return result;
//      }
//   }

   public java.util.List<ProtobufPackage> getProtobufPackage() {
      return new java.util.LinkedList<>(getProtobufPackageSet());
   }

   public <T extends Visitor> T traverse(T visitor) {
      for (ProtobufPackage root : getProtobufPackageSet())
         visitor.visit(root);
      return visitor;
   }

   public interface Visitor {
      void visit(ProtobufPackage entity);
   }



   protected Node getNode(final UUID uuid) {
      try (Transaction tx = graphDb.beginTx()) {
         final IndexHits<Node> indexHits = uuids.get(ProtobufEntities.class.getName(), uuid);
         final Node node = indexHits.size() == 0 ? null : indexHits.getSingle();
         tx.success();
         return node;
      }
   }

   protected Node newNode(final String domain, final UUID uuid, final String domainType) {
      try (Transaction tx = graphDb.beginTx()) {
         final Node newNode = graphDb.createNode(DynamicLabel.label(domain), DynamicLabel.label(domainType));
         newNode.setProperty("uuid", uuid.toString());
         newNode.setProperty(domain, domainType);
         uuids.add(newNode, ProtobufEntities.class.getName(), uuid.toString());
         tx.success();
         return newNode;
      }
   }
}