package com.generator.generators.protobuf.domain;

/**
 * GENERATED
 * This is a common-parent for ProtobufMessages and ProtobufEnum
 */
abstract class ProtobufDeliverableNode extends ProtobufFieldTypeNode implements ProtobufDeliverable, ProtobufFieldType {

   public ProtobufDeliverableNode(org.neo4j.graphdb.Node node, org.neo4j.graphdb.GraphDatabaseService graphDb) {
      super(node, graphDb);
   }

}