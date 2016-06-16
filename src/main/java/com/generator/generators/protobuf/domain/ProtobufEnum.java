package com.generator.generators.protobuf.domain;

/**
 * GENERATED
 * Represents a protobuf enum
 */
public interface ProtobufEnum  extends ProtobufDeliverable {

   String getName();

   ProtobufEnum setName(String value);

   String getComment();

   ProtobufEnum setComment(String value);

   java.util.List<ProtobufEnumValue> getValues();

   ProtobufEnum addValues(ProtobufEnumValue value);
}