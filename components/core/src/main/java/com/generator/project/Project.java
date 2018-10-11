package com.generator.project;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.io.IOException;

public class Project {

    private final JsonObject generator = new JsonObject();
    private final JsonArray metaEntities = new JsonArray();
    private final JsonArray metaEnums = new JsonArray();

    protected Project generator(String name, String packageName) {
        this.generator.put("name", name);
        this.generator.put("packageName", packageName);
        return this;
    }

    protected MetaEntity entity(String name, String packageName) {
        final MetaEntity metaEntity = new MetaEntity(name, packageName);
        metaEntities.add(metaEntity);
        return metaEntity;
    }

    protected MetaEnum newEnum(String name, String packageName, String values) {
        final MetaEnum metaEnum = new MetaEnum(name, packageName, values);
        metaEnums.add(metaEnum);
        return metaEnum;
    }

    protected MetaProperty property(String name, String type, Boolean isRequired) {
        return new MetaProperty(name, type).setIsRequired(isRequired);
    }

    protected MetaProperty property(String name, String type) {
        return property(name, type, false);
    }

    protected MetaProperty stringProperty(String name) {
        return stringProperty(name, false);
    }

    protected MetaProperty stringProperty(String name, Boolean isRequired) {
        return property(name, "String", isRequired);
    }

    protected MetaProperty booleanProperty(String name) {
        return booleanProperty(name, false);
    }

    protected MetaProperty booleanProperty(String name, Boolean isRequired) {
        return property(name, "Boolean", isRequired);
    }

    protected MetaProperty enumProperty(String name, String enumName) {
        return enumProperty(name, enumName, false);
    }

    protected MetaProperty enumProperty(String name, String enumName, Boolean isRequired) {
        return property(name, "Enum", isRequired).setValueType(enumName);
    }

    protected MetaProperty objectProperty(String name, String valueType) {
        return property(name, "JsonObject").setValueType(valueType);
    }

    protected MetaProperty objectProperty(String name, String valueType, Boolean isRequired) {
        return property(name, "JsonObject", isRequired).setValueType(valueType);
    }

    protected MetaProperty listProperty(String name, String valueType) {
        return property(name, "JsonArray").setValueType(valueType);
    }

    protected MetaProperty listProperty(String name, String valueType, Boolean isRequired) {
        return property(name, "JsonArray", isRequired).setValueType(valueType);
    }

    protected void generate(String src) throws IOException {

        final JsonModelGroupGenerator generator = new JsonModelGroupGenerator();

        final MetaEntity[] entities = new MetaEntity[metaEntities.size()];
        int index = 0;
        for (Object metaEntity : metaEntities) {
            generator.generateEntity((MetaEntity) metaEntity, src);
            entities[index++] = (MetaEntity) metaEntity;
        }

        for (Object metaEnum : metaEnums)
            generator.generateEnum((MetaEnum) metaEnum, src);

        if (this.generator.getString("name", null) != null)
            generator.generateGenerator(this.generator.getString("name"), this.generator.getString("packageName"), src, entities);
    }
}