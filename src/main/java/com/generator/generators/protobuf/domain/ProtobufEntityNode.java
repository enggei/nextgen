package com.generator.generators.protobuf.domain;

import org.neo4j.graphdb.Transaction;

/**
 * GENERATED
 * This is the parent entity for all protobuf entities
 */
abstract class ProtobufEntityNode implements ProtobufEntity {

   protected final org.neo4j.graphdb.Node node;
   protected final org.neo4j.graphdb.GraphDatabaseService graphDb;

   private final java.util.UUID uuid;
   private final ProtobufEntities domainType;

   protected ProtobufEntityNode(org.neo4j.graphdb.Node node, org.neo4j.graphdb.GraphDatabaseService graphDb) {
      this.node = node;
      this.graphDb = graphDb;

      try (Transaction tx = graphDb.beginTx()) {
         this.uuid = java.util.UUID.fromString((String) node.getProperty("_uuid"));
         this.domainType = ProtobufEntities.valueOf((String) node.getProperty(ProtobufEntities.class.getName()));
         tx.success();
      }
   }

   @Override
   public ProtobufEntities getDomainType() {
      return domainType;
   }

   @Override
   public java.util.UUID getUuid() {
      return uuid;
   }
}