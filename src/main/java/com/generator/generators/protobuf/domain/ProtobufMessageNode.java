package com.generator.generators.protobuf.domain;

import org.neo4j.graphdb.Transaction;

/**
 * GENERATED
 * Represents a protobuf message
 */
public class ProtobufMessageNode extends ProtobufDeliverableNode implements ProtobufMessage, ProtobufDeliverable {

   public ProtobufMessageNode(org.neo4j.graphdb.Node node, org.neo4j.graphdb.GraphDatabaseService graphDb) {
      super(node, graphDb);
   }

   private String name;

   public String getName() {
      if (name == null)
         try (Transaction tx = graphDb.beginTx()) {
            name = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufMessage.name") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufMessage.name") : null;
            tx.success();
         }
      return name;
   }

   public ProtobufMessage setName(String value) {
      this.name = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufMessage.name", value);
         tx.success();
      }
      return this;
   }
   private String comment;

   public String getComment() {
      if (comment == null)
         try (Transaction tx = graphDb.beginTx()) {
            comment = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufMessage.comment") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufMessage.comment") : null;
            tx.success();
         }
      return comment;
   }

   public ProtobufMessage setComment(String value) {
      this.comment = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufMessage.comment", value);
         tx.success();
      }
      return this;
   }
   public ProtobufMessage getParent() {
      try (Transaction tx = graphDb.beginTx()) {
         org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(ProtobufRelations.PARENT, org.neo4j.graphdb.Direction.OUTGOING);
         if (relationship == null) return null;
         return new ProtobufMessageNode(relationship.getEndNode(), graphDb);
      }
   }

   public ProtobufMessage setParent(ProtobufMessage value) {
      try (Transaction tx = graphDb.beginTx()) {
         node.createRelationshipTo(((ProtobufMessageNode)value).node, ProtobufRelations.PARENT);
         tx.success();
      }
      return this;
   }

   public java.util.List<ProtobufMessageField> getProperties() {
      final java.util.List<ProtobufMessageField> result = new java.util.LinkedList<>();
      try (Transaction tx = graphDb.beginTx()) {
         for (org.neo4j.graphdb.Relationship relationship : node.getRelationships(ProtobufRelations.PROTOBUFMESSAGEFIELD, org.neo4j.graphdb.Direction.OUTGOING))
            result.add(new ProtobufMessageFieldNode(relationship.getEndNode(), graphDb));
         }
      return java.util.Collections.unmodifiableList(result);
   }

   public ProtobufMessage addProperties(ProtobufMessageField value) {
      // todo: consider either checking for value instance of 'ProtobufMessageField' or 'new ProtobufMessageField'
      try (Transaction tx = graphDb.beginTx()) {
         final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(((ProtobufMessageFieldNode)value).node, ProtobufRelations.PROTOBUFMESSAGEFIELD);
         tx.success();
      }
      return this;
   }
}