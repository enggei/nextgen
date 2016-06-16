package com.generator.generators.protobuf.domain;

/**
 * GENERATED
 * Represents a protobuf package
 */
public interface ProtobufPackage  extends ProtobufEntity {

   String getPackageName();

   ProtobufPackage setPackageName(String value);

   java.util.List<ProtobufPackageOption> getOptions();

   ProtobufPackage addOptions(ProtobufPackageOption value);

   java.util.List<ProtobufPackage> getImports();

   ProtobufPackage addImports(ProtobufPackage value);

   java.util.List<ProtobufDeliverable> getDeliverables();

   ProtobufPackage addProtobufEnum(ProtobufEnum value);

   ProtobufPackage addProtobufMessage(ProtobufMessage value);

}