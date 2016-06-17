package com.generator.generators.protobuf;

import com.generator.editors.domain.NeoModel;
import com.generator.editors.domain.*;

import org.neo4j.graphdb.*;

import static com.generator.editors.domain.MetaRelation.Cardinality.*;
import static com.generator.editors.domain.MetaRelation.Direction.*;

import java.util.*;

import static com.generator.generators.protobuf.ProtobufDomain.ENTITIES.*;
import static com.generator.generators.protobuf.ProtobufDomain.RELATIONS.*;

/**
 * 
 */
public class ProtobufDomain extends MetaDomain<ProtobufDomain.ENTITIES, ProtobufDomain.RELATIONS> {

    public enum ENTITIES {
        Property, FieldRule, FieldType, EnumValue, Enum, Extensions, Extend, Message, Import, Option, Package, File
    }

    public enum RELATIONS implements RelationshipType {
        PACKAGE, ENUMVALUE, MESSAGE, OPTIONS, FIELD, IMPORT, FIELDTYPE, FIELDRULE
    }

    private final java.util.Map<String, Node> defaultFieldRule = new java.util.LinkedHashMap<>();
    private final java.util.Map<String, Node> defaultFieldType = new java.util.LinkedHashMap<>();

    public Map<String, Node> defaultFieldRule() { return defaultFieldRule; }
    public Map<String, Node> defaultFieldType() { return defaultFieldType; }

    public ProtobufDomain(final NeoModel model) {
        super(model, "ProtobufDomain");

        try (Transaction tx = model.beginTx()) {

            addMetaNode(ENTITIES.Property, UUID.randomUUID())
                    .addProperty(new MetaProperty("propertyType").setType("String"))
                    .addProperty(new MetaProperty("defaultValue").setType("String"))
                    .addProperty(new MetaProperty("parent").setType("String"))
                    .addProperty(new MetaProperty("comment").setType("String"))
                    .addProperty(new MetaProperty("ordinal").setType("String"))
                    .addProperty(new MetaProperty("name").setType("String"))
                    .addProperty(new MetaProperty("packedValue").setType("String"));
            addMetaNode(ENTITIES.FieldRule, UUID.randomUUID())
                    .addProperty(new MetaProperty("name","required", "optional", "repeated").setType("String"));
            addMetaNode(ENTITIES.FieldType, UUID.randomUUID())
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.EnumValue, UUID.randomUUID())
                    .addProperty(new MetaProperty("comment").setType("String"))
                    .addProperty(new MetaProperty("ordinal").setType("String"))
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.Enum, UUID.randomUUID())
                    .addProperty(new MetaProperty("comment").setType("String"))
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.Extensions, UUID.randomUUID())
                    .addProperty(new MetaProperty("min").setType("String"))
                    .addProperty(new MetaProperty("max").setType("String"));
            addMetaNode(ENTITIES.Extend, UUID.randomUUID())
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.Message, UUID.randomUUID())
                    .addProperty(new MetaProperty("comment").setType("String"))
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.Import, UUID.randomUUID())
                    .addProperty(new MetaProperty("package").setType("String"));
            addMetaNode(ENTITIES.Option, UUID.randomUUID())
                    .addProperty(new MetaProperty("java_package").setType("String"))
                    .addProperty(new MetaProperty("optimize_for","SPEED", "CODE_SIZE", "LITE_RUNTIME").setType("String"));
            addMetaNode(ENTITIES.Package, UUID.randomUUID())
                    .addProperty(new MetaProperty("name").setType("String"));
            addMetaNode(ENTITIES.File, UUID.randomUUID())
                    .addProperty(new MetaProperty("name").setType("String"));

            addMetaRelation(PACKAGE, newNodeSet(File), newNodeSet(Package), OneToOne, OneWay);
            addMetaRelation(ENUMVALUE, newNodeSet(Enum), newNodeSet(EnumValue), OneToMany, OneWay);
            addMetaRelation(MESSAGE, newNodeSet(Message,Package), newNodeSet(Message,Extend,Enum), OneToMany, OneWay);
            addMetaRelation(OPTIONS, newNodeSet(Package), newNodeSet(Option), OneToMany, OneWay);
            addMetaRelation(FIELD, newNodeSet(Message,Extend), newNodeSet(Property,Extensions,Message,Enum), OneToMany, OneWay);
            addMetaRelation(IMPORT, newNodeSet(Package), newNodeSet(Import), OneToMany, OneWay);
            addMetaRelation(FIELDTYPE, newNodeSet(Property), newNodeSet(FieldType,Message,Enum), OneToMany, OneWay);
            addMetaRelation(FIELDRULE, newNodeSet(Property), newNodeSet(FieldRule), OneToMany, OneWay);

            validate();

            defaultFieldRule.put("required", newNode(ENTITIES.FieldRule, UUID.fromString("4c329001-a9d7-4eaf-bf74-25587e44311a"), "name", "required"));
            defaultFieldRule.put("repeated", newNode(ENTITIES.FieldRule, UUID.fromString("c2591cbe-c451-4ec0-ae9e-4dc75622193f"), "name", "repeated"));
            defaultFieldRule.put("optional", newNode(ENTITIES.FieldRule, UUID.fromString("f59b0ac0-805e-49dd-9089-ecac6fc8a5b6"), "name", "optional"));

            defaultFieldType.put("bytes", newNode(ENTITIES.FieldType, UUID.fromString("e35cac04-c9e7-4272-aac0-8b70ae7f2378"), "name", "bytes"));
            defaultFieldType.put("string", newNode(ENTITIES.FieldType, UUID.fromString("ea9c49e2-1253-44cc-a5bb-c80d420ccb42"), "name", "string"));
            defaultFieldType.put("bool", newNode(ENTITIES.FieldType, UUID.fromString("2822039d-ed0f-4350-99e1-307606d64918"), "name", "bool"));
            defaultFieldType.put("sfixed64", newNode(ENTITIES.FieldType, UUID.fromString("b021acf0-d322-4cb6-a2db-32e9013dffd2"), "name", "sfixed64"));
            defaultFieldType.put("sfixed32", newNode(ENTITIES.FieldType, UUID.fromString("33c40ab5-20be-4914-9b81-95d80e205db8"), "name", "sfixed32"));
            defaultFieldType.put("fixed64", newNode(ENTITIES.FieldType, UUID.fromString("7d1360b7-e8f3-4bd9-9f66-d30f3dac644c"), "name", "fixed64"));
            defaultFieldType.put("fixed32", newNode(ENTITIES.FieldType, UUID.fromString("f2669773-7f67-44f5-aae5-f8755a888103"), "name", "fixed32"));
            defaultFieldType.put("sint64", newNode(ENTITIES.FieldType, UUID.fromString("c09d0008-036d-47ec-a696-d8dbd6e53dca"), "name", "sint64"));
            defaultFieldType.put("sint32", newNode(ENTITIES.FieldType, UUID.fromString("c5f850e8-6f78-45eb-89d2-6edc22296edc"), "name", "sint32"));
            defaultFieldType.put("uint64", newNode(ENTITIES.FieldType, UUID.fromString("c1efe027-f80f-45ad-b8f9-39463f29d30e"), "name", "uint64"));
            defaultFieldType.put("uin32", newNode(ENTITIES.FieldType, UUID.fromString("625d39f3-8c0a-4eb1-bc35-b8937ffd9fe0"), "name", "uin32"));
            defaultFieldType.put("int64", newNode(ENTITIES.FieldType, UUID.fromString("133d71e6-7bb2-44d2-8ffa-600aaec5b250"), "name", "int64"));
            defaultFieldType.put("int32", newNode(ENTITIES.FieldType, UUID.fromString("4c6abed5-38bd-4c7d-8f45-d6c2b4138662"), "name", "int32"));
            defaultFieldType.put("float", newNode(ENTITIES.FieldType, UUID.fromString("55e24fae-a255-4576-ab93-2992c7b3d226"), "name", "float"));
            defaultFieldType.put("double", newNode(ENTITIES.FieldType, UUID.fromString("d54691af-b3d9-4000-abc8-2a6fd97e7b1e"), "name", "double"));


            tx.success();
        }
    }

    @Override
    protected final ENTITIES entity(String s) {
        return ENTITIES.valueOf(s);
    }

    @Override
    protected final RELATIONS relation(String s) {
        return RELATIONS.valueOf(s);
    }

    @Override
    public final MetaNode<ENTITIES> getRootNode() {
        return getNode(File);
    }

    @Override
    public final boolean isConstrained(Node node) {
        for (Node defaultFieldRuleNode : defaultFieldRule.values())
            if (defaultFieldRuleNode.equals(node)) return true;

        for (Node defaultFieldTypeNode : defaultFieldType.values())
            if (defaultFieldTypeNode.equals(node)) return true;


        return super.isConstrained(node);
    }
    public Node addProperty(UUID uuid, String _propertyType, String _defaultValue, String _parent, String _comment, String _ordinal, String _name, String _packedValue) {
        return newNode(ENTITIES.Property, uuid, "propertyType", (_propertyType == null || _propertyType.trim().length()==0) ? "[]" : _propertyType, "defaultValue", (_defaultValue == null || _defaultValue.trim().length()==0) ? "[]" : _defaultValue, "parent", (_parent == null || _parent.trim().length()==0) ? "[]" : _parent, "comment", (_comment == null || _comment.trim().length()==0) ? "[]" : _comment, "ordinal", (_ordinal == null || _ordinal.trim().length()==0) ? "[]" : _ordinal, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name, "packedValue", (_packedValue == null || _packedValue.trim().length()==0) ? "[]" : _packedValue);
    }
    public Node addFieldRule(UUID uuid) {
        return newNode(ENTITIES.FieldRule, uuid);
    }
    public Node addFieldType(UUID uuid, String _name) {
        return newNode(ENTITIES.FieldType, uuid, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }
    public Node addEnumValue(UUID uuid, String _comment, String _ordinal, String _name) {
        return newNode(ENTITIES.EnumValue, uuid, "comment", (_comment == null || _comment.trim().length()==0) ? "[]" : _comment, "ordinal", (_ordinal == null || _ordinal.trim().length()==0) ? "[]" : _ordinal, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }
    public Node addEnum(UUID uuid, String _comment, String _name) {
        return newNode(ENTITIES.Enum, uuid, "comment", (_comment == null || _comment.trim().length()==0) ? "[]" : _comment, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }
    public Node addExtensions(UUID uuid, String _min, String _max) {
        return newNode(ENTITIES.Extensions, uuid, "min", (_min == null || _min.trim().length()==0) ? "[]" : _min, "max", (_max == null || _max.trim().length()==0) ? "[]" : _max);
    }
    public Node addExtend(UUID uuid, String _name) {
        return newNode(ENTITIES.Extend, uuid, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }
    public Node addMessage(UUID uuid, String _comment, String _name) {
        return newNode(ENTITIES.Message, uuid, "comment", (_comment == null || _comment.trim().length()==0) ? "[]" : _comment, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }
    public Node addImport(UUID uuid, String _package) {
        return newNode(ENTITIES.Import, uuid, "package", (_package == null || _package.trim().length()==0) ? "[]" : _package);
    }
    public Node addOption(UUID uuid, String _java_package) {
        return newNode(ENTITIES.Option, uuid, "java_package", (_java_package == null || _java_package.trim().length()==0) ? "[]" : _java_package);
    }
    public Node addPackage(UUID uuid, String _name) {
        return newNode(ENTITIES.Package, uuid, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }
    public Node addFile(UUID uuid, String _name) {
        return newNode(ENTITIES.File, uuid, "name", (_name == null || _name.trim().length()==0) ? "[]" : _name);
    }


    public ProtobufDomain relateFile_Package_Package(Node fileSrc, Node packageDst) {
        relate(RELATIONS.PACKAGE, fileSrc, packageDst);
        return this;
    } 



    public ProtobufDomain relateEnum_EnumValue_EnumValue(Node enumSrc, Node enumvalueDst) {
        relate(RELATIONS.ENUMVALUE, enumSrc, enumvalueDst);
        return this;
    } 



    public ProtobufDomain relateMessage_Message_Enum(Node messageSrc, Node enumDst) {
        relate(RELATIONS.MESSAGE, messageSrc, enumDst);
        return this;
    } 


    public ProtobufDomain relateMessage_Message_Extend(Node messageSrc, Node extendDst) {
        relate(RELATIONS.MESSAGE, messageSrc, extendDst);
        return this;
    } 


    public ProtobufDomain relateMessage_Message_Message(Node messageSrc, Node messageDst) {
        relate(RELATIONS.MESSAGE, messageSrc, messageDst);
        return this;
    } 


    public ProtobufDomain relatePackage_Message_Enum(Node packageSrc, Node enumDst) {
        relate(RELATIONS.MESSAGE, packageSrc, enumDst);
        return this;
    } 


    public ProtobufDomain relatePackage_Message_Extend(Node packageSrc, Node extendDst) {
        relate(RELATIONS.MESSAGE, packageSrc, extendDst);
        return this;
    } 


    public ProtobufDomain relatePackage_Message_Message(Node packageSrc, Node messageDst) {
        relate(RELATIONS.MESSAGE, packageSrc, messageDst);
        return this;
    } 



    public ProtobufDomain relatePackage_Options_Option(Node packageSrc, Node optionDst) {
        relate(RELATIONS.OPTIONS, packageSrc, optionDst);
        return this;
    } 



    public ProtobufDomain relateExtend_Field_Enum(Node extendSrc, Node enumDst) {
        relate(RELATIONS.FIELD, extendSrc, enumDst);
        return this;
    } 


    public ProtobufDomain relateExtend_Field_Extensions(Node extendSrc, Node extensionsDst) {
        relate(RELATIONS.FIELD, extendSrc, extensionsDst);
        return this;
    } 


    public ProtobufDomain relateExtend_Field_Message(Node extendSrc, Node messageDst) {
        relate(RELATIONS.FIELD, extendSrc, messageDst);
        return this;
    } 


    public ProtobufDomain relateExtend_Field_Property(Node extendSrc, Node propertyDst) {
        relate(RELATIONS.FIELD, extendSrc, propertyDst);
        return this;
    } 


    public ProtobufDomain relateMessage_Field_Enum(Node messageSrc, Node enumDst) {
        relate(RELATIONS.FIELD, messageSrc, enumDst);
        return this;
    } 


    public ProtobufDomain relateMessage_Field_Extensions(Node messageSrc, Node extensionsDst) {
        relate(RELATIONS.FIELD, messageSrc, extensionsDst);
        return this;
    } 


    public ProtobufDomain relateMessage_Field_Message(Node messageSrc, Node messageDst) {
        relate(RELATIONS.FIELD, messageSrc, messageDst);
        return this;
    } 


    public ProtobufDomain relateMessage_Field_Property(Node messageSrc, Node propertyDst) {
        relate(RELATIONS.FIELD, messageSrc, propertyDst);
        return this;
    } 



    public ProtobufDomain relatePackage_Import_Import(Node packageSrc, Node importDst) {
        relate(RELATIONS.IMPORT, packageSrc, importDst);
        return this;
    } 



    public ProtobufDomain relateProperty_Fieldtype_Enum(Node propertySrc, Node enumDst) {
        relate(RELATIONS.FIELDTYPE, propertySrc, enumDst);
        return this;
    } 


    public ProtobufDomain relateProperty_Fieldtype_FieldType(Node propertySrc, Node fieldtypeDst) {
        relate(RELATIONS.FIELDTYPE, propertySrc, fieldtypeDst);
        return this;
    } 


    public ProtobufDomain relateProperty_Fieldtype_Message(Node propertySrc, Node messageDst) {
        relate(RELATIONS.FIELDTYPE, propertySrc, messageDst);
        return this;
    } 



    public ProtobufDomain relateProperty_FieldRule_FieldRule(Node propertySrc, Node fieldruleDst) {
        relate(RELATIONS.FIELDRULE, propertySrc, fieldruleDst);
        return this;
    } 

}