package com.generator.generators.protobuf.domain;

/**
 * GENERATED
 * Represents a protobuf message
 */
public interface ProtobufMessage  extends ProtobufDeliverable {

   String getName();

   ProtobufMessage setName(String value);

   String getComment();

   ProtobufMessage setComment(String value);

   java.util.List<ProtobufMessageField> getProperties();

   ProtobufMessage addProperties(ProtobufMessageField value);
}