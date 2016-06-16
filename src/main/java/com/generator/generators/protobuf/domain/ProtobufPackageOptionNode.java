package com.generator.generators.protobuf.domain;

import org.neo4j.graphdb.Transaction;

/**
 * GENERATED
 * Represents a protobuf package option
 */
public class ProtobufPackageOptionNode extends ProtobufEntityNode implements ProtobufPackageOption {

   public ProtobufPackageOptionNode(org.neo4j.graphdb.Node node, org.neo4j.graphdb.GraphDatabaseService graphDb) {
      super(node, graphDb);
   }

   private String name;

   public String getName() {
      if (name == null)
         try (Transaction tx = graphDb.beginTx()) {
            name = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufPackageOption.name") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufPackageOption.name") : null;
            tx.success();
         }
      return name;
   }

   public ProtobufPackageOption setName(String value) {
      this.name = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufPackageOption.name", value);
         tx.success();
      }
      return this;
   }
   private String value;

   public String getValue() {
      if (value == null)
         try (Transaction tx = graphDb.beginTx()) {
            value = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufPackageOption.value") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufPackageOption.value") : null;
            tx.success();
         }
      return value;
   }

   public ProtobufPackageOption setValue(String value) {
      this.value = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufPackageOption.value", value);
         tx.success();
      }
      return this;
   }}