package com.generator.generators.protobuf.domain;

import org.neo4j.graphdb.Transaction;

/**
 * GENERATED
 * Represents a protobuf package
 */
public class ProtobufPackageNode extends ProtobufEntityNode implements ProtobufPackage {

   public ProtobufPackageNode(org.neo4j.graphdb.Node node, org.neo4j.graphdb.GraphDatabaseService graphDb) {
      super(node, graphDb);
   }

   private String packageName;

   public String getPackageName() {
      if (packageName == null)
         try (Transaction tx = graphDb.beginTx()) {
            packageName = node.hasProperty("com.generator.generators.protobuf.domain.ProtobufPackage.packageName") ? (String) node.getProperty("com.generator.generators.protobuf.domain.ProtobufPackage.packageName") : null;
            tx.success();
         }
      return packageName;
   }

   public ProtobufPackage setPackageName(String value) {
      this.packageName = null;
      try (Transaction tx = graphDb.beginTx()) {
         node.setProperty("com.generator.generators.protobuf.domain.ProtobufPackage.packageName", value);
         tx.success();
      }
      return this;
   }

   public java.util.List<ProtobufPackageOption> getOptions() {
      final java.util.List<ProtobufPackageOption> result = new java.util.LinkedList<>();
      try (Transaction tx = graphDb.beginTx()) {
         for (org.neo4j.graphdb.Relationship relationship : node.getRelationships(ProtobufRelations.PROTOBUFOPTION, org.neo4j.graphdb.Direction.OUTGOING))
            result.add(new ProtobufPackageOptionNode(relationship.getEndNode(), graphDb));
         }
      return java.util.Collections.unmodifiableList(result);
   }

   public ProtobufPackage addOptions(ProtobufPackageOption value) {
      // todo: consider either checking for value instance of 'ProtobufPackageOption' or 'new ProtobufPackageOption'
      try (Transaction tx = graphDb.beginTx()) {
         final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(((ProtobufPackageOptionNode)value).node, ProtobufRelations.PROTOBUFOPTION);
         tx.success();
      }
      return this;
   }


   public java.util.List<ProtobufPackage> getImports() {
      final java.util.List<ProtobufPackage> result = new java.util.LinkedList<>();
      try (Transaction tx = graphDb.beginTx()) {
         for (org.neo4j.graphdb.Relationship relationship : node.getRelationships(ProtobufRelations.PROTOBUFIMPORT, org.neo4j.graphdb.Direction.OUTGOING))
            result.add(new ProtobufPackageNode(relationship.getEndNode(), graphDb));
         }
      return java.util.Collections.unmodifiableList(result);
   }

   public ProtobufPackage addImports(ProtobufPackage value) {
      // todo: consider either checking for value instance of 'ProtobufPackage' or 'new ProtobufPackage'
      try (Transaction tx = graphDb.beginTx()) {
         final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(((ProtobufPackageNode)value).node, ProtobufRelations.PROTOBUFIMPORT);
         tx.success();
      }
      return this;
   }


   public java.util.List<ProtobufDeliverable> getDeliverables() {
      final java.util.List<ProtobufDeliverable> result = new java.util.LinkedList<>();
      try (Transaction tx = graphDb.beginTx()) {
         for (org.neo4j.graphdb.Relationship relationship : node.getRelationships(ProtobufRelations.PROTOBUFDELIVERABLE, org.neo4j.graphdb.Direction.OUTGOING))
            switch (ProtobufEntities.valueOf((String) relationship.getProperty(ProtobufRelations.PROTOBUFDELIVERABLE.name()))) {
               case ProtobufEnum:
                     result.add(new ProtobufEnumNode(relationship.getOtherNode(node), graphDb));
                     break;
               case ProtobufMessage:
                     result.add(new ProtobufMessageNode(relationship.getOtherNode(node), graphDb));
                     break;
          }
      }
      return java.util.Collections.unmodifiableList(result);
   }

   public ProtobufPackage addProtobufEnum(ProtobufEnum value) {
      try (Transaction tx = graphDb.beginTx()) {
         final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(((ProtobufDeliverableNode)value).node, ProtobufRelations.PROTOBUFDELIVERABLE);
         relationship.setProperty(ProtobufRelations.PROTOBUFDELIVERABLE.name(), ProtobufEntities.ProtobufEnum.name());
         tx.success();
      }
      return this;
   }

   public ProtobufPackage addProtobufMessage(ProtobufMessage value) {
      try (Transaction tx = graphDb.beginTx()) {
         final org.neo4j.graphdb.Relationship relationship = node.createRelationshipTo(((ProtobufDeliverableNode)value).node, ProtobufRelations.PROTOBUFDELIVERABLE);
         relationship.setProperty(ProtobufRelations.PROTOBUFDELIVERABLE.name(), ProtobufEntities.ProtobufMessage.name());
         tx.success();
      }
      return this;
   }
}