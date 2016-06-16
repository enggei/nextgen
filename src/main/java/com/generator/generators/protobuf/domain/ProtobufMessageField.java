package com.generator.generators.protobuf.domain;

/**
 * GENERATED
 * Represents a protobuf message field
 */
public interface ProtobufMessageField  extends ProtobufEntity {

   ProtobufFieldConstraint getFieldConstraint();

   ProtobufMessageField setFieldConstraint(ProtobufFieldConstraint value);

   String getName();

   ProtobufMessageField setName(String value);

   ProtobufFieldType getType();

   ProtobufMessageField setType(ProtobufFieldType value);

   String getComment();

   ProtobufMessageField setComment(String value);

   String getDefaultValue();

   ProtobufMessageField setDefaultValue(String value);
}