package com.generator.generators.protobuf.domain;

import org.neo4j.graphdb.Transaction;

/**
 * GENERATED
 * Represents a protobuf field type
 */
public class ProtobufFieldTypeNode extends ProtobufEntityNode implements ProtobufFieldType {

   public ProtobufFieldTypeNode(org.neo4j.graphdb.Node node, org.neo4j.graphdb.GraphDatabaseService graphDb) {
      super(node, graphDb);
   }

   private String name;

   public String getName() {
      if (name == null)
         try (Transaction tx = graphDb.beginTx()) {
            name = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufFieldType.name") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufFieldType.name") : null;
            tx.success();
         }
      return name;
   }

   public ProtobufFieldType setName(String value) {
      this.name = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufFieldType.name", value);
         tx.success();
      }
      return this;
   }}