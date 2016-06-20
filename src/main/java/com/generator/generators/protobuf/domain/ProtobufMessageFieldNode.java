package com.generator.generators.protobuf.domain;

import org.neo4j.graphdb.Transaction;

/**
 * GENERATED
 * Represents a protobuf message field
 */
public class ProtobufMessageFieldNode extends ProtobufEntityNode implements ProtobufMessageField {

   public ProtobufMessageFieldNode(org.neo4j.graphdb.Node node, org.neo4j.graphdb.GraphDatabaseService graphDb) {
      super(node, graphDb);
   }

   public ProtobufFieldConstraint getFieldConstraint() {
      try (Transaction tx = graphDb.beginTx()) {
         org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(ProtobufRelations.PROTOBUFFIELDCONSTRAINT, org.neo4j.graphdb.Direction.OUTGOING);
         if (relationship == null) return null;
         return new ProtobufFieldConstraintNode(relationship.getEndNode(), graphDb);
      }
   }

   public ProtobufMessageField setFieldConstraint(ProtobufFieldConstraint value) {
      try (Transaction tx = graphDb.beginTx()) {
         node.createRelationshipTo(((ProtobufFieldConstraintNode)value).node, ProtobufRelations.PROTOBUFFIELDCONSTRAINT);
         tx.success();
      }
      return this;
   }
   private String name;

   public String getName() {
      if (name == null)
         try (Transaction tx = graphDb.beginTx()) {
            name = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.name") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.name") : null;
            tx.success();
         }
      return name;
   }

   public ProtobufMessageField setName(String value) {
      this.name = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.name", value);
         tx.success();
      }
      return this;
   }
   public ProtobufFieldType getType() {
      try (Transaction tx = graphDb.beginTx()) {
         org.neo4j.graphdb.Relationship relationship = node.getSingleRelationship(ProtobufRelations.PROTOBUFFIELDTYPE, org.neo4j.graphdb.Direction.OUTGOING);
         if (relationship == null) return null;
         return new ProtobufFieldTypeNode(relationship.getEndNode(), graphDb);
      }
   }

   public ProtobufMessageField setType(ProtobufFieldType value) {
      try (Transaction tx = graphDb.beginTx()) {
         node.createRelationshipTo(((ProtobufFieldTypeNode)value).node, ProtobufRelations.PROTOBUFFIELDTYPE);
         tx.success();
      }
      return this;
   }
   private String comment;

   public String getComment() {
      if (comment == null)
         try (Transaction tx = graphDb.beginTx()) {
            comment = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.comment") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.comment") : null;
            tx.success();
         }
      return comment;
   }

   public ProtobufMessageField setComment(String value) {
      this.comment = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.comment", value);
         tx.success();
      }
      return this;
   }
   private String defaultValue;

   public String getDefaultValue() {
      if (defaultValue == null)
         try (Transaction tx = graphDb.beginTx()) {
            defaultValue = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.defaultValue") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.defaultValue") : null;
            tx.success();
         }
      return defaultValue;
   }
   private String packedValue;

   public String getPackedValue() {
      if (packedValue == null)
         try (Transaction tx = graphDb.beginTx()) {
            packedValue = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.packedValue") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.packedValue") : null;
            tx.success();
         }
      return packedValue;
   }

   public ProtobufMessageField setDefaultValue(String value) {
      this.defaultValue = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufMessageField.defaultValue", value);
         tx.success();
      }
      return this;
   }}