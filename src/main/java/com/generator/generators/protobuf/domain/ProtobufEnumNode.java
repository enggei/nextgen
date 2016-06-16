package com.generator.generators.protobuf.domain;

import org.neo4j.graphdb.Transaction;

/**
 * GENERATED
 * Represents a protobuf enum
 */
public class ProtobufEnumNode extends ProtobufDeliverableNode implements ProtobufEnum, ProtobufDeliverable {

   public ProtobufEnumNode(org.neo4j.graphdb.Node node, org.neo4j.graphdb.GraphDatabaseService graphDb) {
      super(node, graphDb);
   }

   private String name;

   public String getName() {
      if (name == null)
         try (Transaction tx = graphDb.beginTx()) {
            name = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufEnum.name") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufEnum.name") : null;
            tx.success();
         }
      return name;
   }

   public ProtobufEnum setName(String value) {
      this.name = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufEnum.name", value);
         tx.success();
      }
      return this;
   }
   private String comment;

   public String getComment() {
      if (comment == null)
         try (Transaction tx = graphDb.beginTx()) {
            comment = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufEnum.comment") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufEnum.comment") : null;
            tx.success();
         }
      return comment;
   }

   public ProtobufEnum setComment(String value) {
      this.comment = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufEnum.comment", value);
         tx.success();
      }
      return this;
   }

   public java.util.List<ProtobufEnumValue> getValues() {
      final java.util.List<ProtobufEnumValue> result = new java.util.LinkedList<>();
      try (Transaction tx = graphDb.beginTx()) {
         for (org.neo4j.graphdb.Relationship relationship : node.getRelationships(ProtobufRelations.PROTOBUFENUMVALUE, org.neo4j.graphdb.Direction.OUTGOING))
            result.add(new ProtobufEnumValueNode(relationship.getEndNode(), graphDb));
         }
      return java.util.Collections.unmodifiableList(result);
   }

   public ProtobufEnum addValues(ProtobufEnumValue value) {
      // todo: consider either checking for value instance of 'ProtobufEnumValue' or 'new ProtobufEnumValue'
      try (Transaction tx = graphDb.beginTx()) {
         final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(((ProtobufEnumValueNode)value).node, ProtobufRelations.PROTOBUFENUMVALUE);
         tx.success();
      }
      return this;
   }
}