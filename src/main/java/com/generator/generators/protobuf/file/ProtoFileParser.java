package com.generator.generators.protobuf.file;

import com.generator.generators.protobuf.domain.*;
import com.generator.generators.protobuf.parser.ProtobufParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * User: goe
 * Date: 25.09.13
 */
public class ProtoFileParser extends ProtobufParser {

   private final File file;

   private String packageName;
   private String currentEnumName;
   private String currentEnumComment;
   private List<ProtobufEnumValue> currentEnumValues;
   private String currentMessageName;
   private String currentMessageComment;
   private List<ProtobufMessageField> currentFields;

   private final Map<String, ProtobufDeliverable> entities = new LinkedHashMap<>();
   private final List<ProtobufPackageOption> packageOptions = new LinkedList<>();
   private final List<ProtobufPackage> imports = new LinkedList<>();

   public ProtoFileParser(File file) throws IOException {
      super(createLexer(new FileReader(file)));
      this.file = file;
      this.file();
   }

   public ProtobufPackage getPackage() {

      final UUID uuid = UUID.randomUUID();
      final LinkedList<ProtobufDeliverable> deliverables = new LinkedList<>(entities.values());

      return new ProtobufPackage() {
         @Override
         public String getPackageName() {
            return packageName;
         }

         @Override
         public ProtobufPackage setPackageName(String value) {
            return this;
         }

         @Override
         public List<ProtobufPackageOption> getOptions() {
            return packageOptions;
         }

         @Override
         public ProtobufPackage addOptions(ProtobufPackageOption value) {
            return null;
         }

         @Override
         public List<ProtobufPackage> getImports() {
            return imports;
         }

         @Override
         public ProtobufPackage addImports(ProtobufPackage value) {
            return null;
         }

         @Override
         public List<ProtobufDeliverable> getDeliverables() {
            return deliverables;
         }

         @Override
         public ProtobufPackage addProtobufEnum(ProtobufEnum value) {
            return null;
         }

         @Override
         public ProtobufPackage addProtobufMessage(ProtobufMessage value) {
            return null;
         }


         @Override
         public UUID getUuid() {
            return uuid;
         }

         @Override
         public ProtobufEntities getDomainType() {
            return ProtobufEntities.ProtobufPackage;
         }
      };
   }

   public File getFile() {
      return file;
   }

   @Override
   public void packageName(String name) {
      this.packageName = name;
   }

   @Override
   public void option(final String name, final String value) {

      final UUID uuid = UUID.randomUUID();

      this.packageOptions.add(new ProtobufPackageOption() {
         @Override
         public String getName() {
            return name;
         }

         @Override
         public ProtobufPackageOption setName(String value) {
         return this;
         }

         @Override
         public String getValue() {
            return value;
         }

         @Override
         public ProtobufPackageOption setValue(String value) {
         return this;
         }

         @Override
         public UUID getUuid() {
            return uuid;
         }

         @Override
         public ProtobufEntities getDomainType() {
            return ProtobufEntities.ProtobufPackageOption;
         }
      });
   }

   @Override
   public void imports(String name) {
      try {
         // todo check this for importing rules from other directories...
         this.imports.add(new ProtoFileParser(new File(getFile().getParentFile(), name)).getPackage());
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void newMessage(final String name, final String comment) {
      this.currentMessageName = name;
      this.currentMessageComment = comment;
      this.currentFields = new LinkedList<>();
   }

   @Override
   public void newProperty(final FieldRules rule, final String propertyType, final String propertyName, Integer ordinal, final String comment, final String parent, final String defaultValue, final String packedValue) {

      final UUID uuid = UUID.randomUUID();

      this.currentFields.add(new ProtobufMessageField() {

         @Override
         public UUID getUuid() {
            return uuid;
         }

         @Override
         public ProtobufEntities getDomainType() {
            return ProtobufEntities.ProtobufMessageField;
         }

         @Override
         public ProtobufFieldConstraint getFieldConstraint() {
            return ProtobufEntitiesDefaults.defaultConstraints.get(rule.name());
         }

         @Override
         public ProtobufMessageField setFieldConstraint(ProtobufFieldConstraint value) {
            return null;
         }

         @Override
         public String getName() {
            return propertyName;
         }

         @Override
         public ProtobufMessageField setName(String value) {
         return this;}

         @Override
         public ProtobufFieldType getType() {
            final ProtobufFieldType scalarValue = ProtobufEntitiesDefaults.defaultScalarValues.get(propertyType);
            return scalarValue != null ? scalarValue : entities.get(propertyType);
         }

         @Override
         public ProtobufMessageField setType(ProtobufFieldType value) {
            return null;
         }

         @Override
         public String getComment() {
            return comment;
         }

         @Override
         public ProtobufMessageField setComment(String value) {
         return this;}

         @Override
         public String getDefaultValue() {
            return defaultValue;
         }

         @Override
         public String getPackedValue() {
            return packedValue;
         }

         @Override
         public ProtobufMessageField setDefaultValue(String value) {
            return this;
         }
      });
   }

   @Override
   public void endMessage() {

      final UUID uuid = UUID.randomUUID();
      final String name = currentMessageName;
      final String comment = currentMessageComment;
      final List<ProtobufMessageField> fields = new LinkedList<>(this.currentFields);

      this.entities.put(name, new ProtobufMessage() {

         @Override
         public ProtobufEntities getDomainType() {
            return ProtobufEntities.ProtobufMessage;
         }

         @Override
         public UUID getUuid() {
            return uuid;
         }

         @Override
         public String getName() {
            return name;
         }

         @Override
         public ProtobufMessage setName(String value) {
         return this;}

         @Override
         public String getComment() {
            return comment;
         }

         @Override
         public ProtobufMessage setComment(String value) {
         return this;}

         @Override
         public List<ProtobufMessageField> getProperties() {
            return fields;
         }

         @Override
         public ProtobufMessage addProperties(ProtobufMessageField value) {
            return this;
         }
      });
   }

   @Override
   public void newEnum(String name, String comment) {
      this.currentEnumName = name;
      this.currentEnumComment = comment;
      this.currentEnumValues = new LinkedList<>();
   }

   @Override
   public void newEnumValue(final String name, final Integer ordinal, String comments) {

      final UUID uuid = UUID.randomUUID();

      this.currentEnumValues.add(new ProtobufEnumValue() {

         @Override
         public ProtobufEntities getDomainType() {
            return ProtobufEntities.ProtobufEnumValue;
         }

         @Override
         public UUID getUuid() {
            return uuid;
         }

         @Override
         public String getName() {
            return name;
         }

         @Override
         public ProtobufEnumValue setName(String value) {
            return this;
         }
      });
   }

   @Override
   public void endEnum() {

      final UUID uuid = UUID.randomUUID();
      final String name = this.currentEnumName;
      final String comment = this.currentEnumComment;
      final List<ProtobufEnumValue> values = new LinkedList<>(this.currentEnumValues);

      this.entities.put(name, new ProtobufEnum() {

         @Override
         public ProtobufEntities getDomainType() {
            return ProtobufEntities.ProtobufEnum;
         }

         @Override
         public UUID getUuid() {
            return uuid;
         }

         @Override
         public String getName() {
            return name;
         }

         @Override
         public ProtobufEnum setName(String value) {
         return this;
         }

         @Override
         public String getComment() {
            return comment;
         }

         @Override
         public ProtobufEnum setComment(String value) {
            return this;
         }

         @Override
         public List<ProtobufEnumValue> getValues() {
            return values;
         }

         @Override
         public ProtobufEnum addValues(ProtobufEnumValue value) {
            return this;
         }
      });
   }
}