package com.generator.generators.protobuf.domain;

import org.neo4j.graphdb.Transaction;

/**
 * GENERATED
 * Represents a protobuf field constraint
 */
public class ProtobufFieldConstraintNode extends ProtobufEntityNode implements ProtobufFieldConstraint {

   public ProtobufFieldConstraintNode(org.neo4j.graphdb.Node node, org.neo4j.graphdb.GraphDatabaseService graphDb) {
      super(node, graphDb);
   }

   private String name;

   public String getName() {
      if (name == null)
         try (Transaction tx = graphDb.beginTx()) {
            name = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufFieldConstraint.name") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufFieldConstraint.name") : null;
            tx.success();
         }
      return name;
   }

   public ProtobufFieldConstraint setName(String value) {
      this.name = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufFieldConstraint.name", value);
         tx.success();
      }
      return this;
   }}