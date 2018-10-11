package com.generator.project;

import com.nextgen.core.GeneratedFile;

import java.io.IOException;

public class JsonModelGroupGenerator {

    private final JsonModelGroup group = new JsonModelGroup();

    public JsonModelGroupGenerator() {
    }

    public JsonModelGroupGenerator generateEntity(MetaEntity model, String src) throws IOException {
        final JsonModelGroup.entityST entityST = newEntityST(model);
        GeneratedFile.newJavaFile(src, entityST.getPackageName(), entityST.getName()).write(entityST);
        return this;
    }

    public JsonModelGroupGenerator generateEnum(MetaEnum metaEnum, String src) throws IOException {
        final JsonModelGroup.enumST enumST = newEnumST(metaEnum);
        GeneratedFile.newJavaFile(src, enumST.getPackageName(), enumST.getName()).write(enumST);
        return this;
    }

    public JsonModelGroupGenerator generateGenerator(String name, String packageName, String src, MetaEntity... entities) throws IOException {

        final JsonModelGroup.GeneratorST generatorST = group.newGenerator();
        generatorST.setName(name);
        generatorST.setPackageName(packageName);

        for (MetaEntity entity : entities)
            generatorST.addEntitiesValue(entity.getName());

        GeneratedFile.newJavaFile(src, generatorST.getPackageName(), generatorST.getName()).write(generatorST);
        return this;
    }

    private JsonModelGroup.entityST newEntityST(MetaEntity model) {

        final JsonModelGroup.entityST entityST = group.newentity();
        entityST.setName(model.getName());
        entityST.setPackageName(model.getPackageName());

        for (Object p : model.getProperties()) {
            final MetaProperty property = new MetaProperty(p);

            if (property.getIsRequired())
                entityST.addRequiredPropertiesValue(property.getType().equals("Enum") ? property.getValueType() : property.getType(), property.getName());

            final JsonModelGroup.propertiesST propertiesST = group.newproperties();
            switch (property.getType()) {

                case "Boolean":

                    final JsonModelGroup.setBooleanST setBooleanST = group.newsetBoolean();
                    setBooleanST.setEntity(model.getName());
                    setBooleanST.setName(property.getName());
                    propertiesST.addSettersValue(setBooleanST);

                    final JsonModelGroup.getBooleanST getBooleanST = group.newgetBoolean();
                    getBooleanST.setName(property.getName());
                    propertiesST.addGettersValue(getBooleanST);

                    break;

                case "String":

                    final JsonModelGroup.setStringST setStringST = group.newsetString();
                    setStringST.setEntity(model.getName());
                    setStringST.setName(property.getName());
                    propertiesST.addSettersValue(setStringST);

                    final JsonModelGroup.getStringST getStringST = group.newgetString();
                    getStringST.setName(property.getName());
                    propertiesST.addGettersValue(getStringST);

                    break;

                case "Enum":

                    final JsonModelGroup.setEnumST setEnumST = group.newsetEnum();
                    setEnumST.setEntity(model.getName());
                    setEnumST.setName(property.getName());
                    setEnumST.setType(property.getValueType());
                    propertiesST.addSettersValue(setEnumST);

                    final JsonModelGroup.getEnumST getEnumST = group.newgetEnum();
                    getEnumST.setName(property.getName());
                    getEnumST.setType(property.getValueType());
                    propertiesST.addGettersValue(getEnumST);

                    break;

                case "JsonObject":

                    final JsonModelGroup.setJsonObjectST setJsonObjectST = group.newsetJsonObject();
                    setJsonObjectST.setEntity(model.getName());
                    setJsonObjectST.setName(property.getName());
                    setJsonObjectST.setType(property.getValueType());
                    propertiesST.addSettersValue(setJsonObjectST);

                    final JsonModelGroup.getJsonObjectST getJsonObjectST = group.newgetJsonObject();
                    getJsonObjectST.setName(property.getName());
                    getJsonObjectST.setType(property.getValueType());
                    propertiesST.addGettersValue(getJsonObjectST);

                    break;

                case "JsonArray":

                    final JsonModelGroup.addTypeST addTypeST = group.newaddType();
                    addTypeST.setEntity(model.getName());
                    addTypeST.setName(property.getName());
                    addTypeST.setValueType(property.getValueType());
                    propertiesST.addSettersValue(addTypeST);

                    final JsonModelGroup.setJsonArrayST setJsonArrayST = group.newsetJsonArray();
                    setJsonArrayST.setEntity(model.getName());
                    setJsonArrayST.setName(property.getName());
                    propertiesST.addSettersValue(setJsonArrayST);

                    final JsonModelGroup.getJsonArrayST getJsonArrayST = group.newgetJsonArray();
                    getJsonArrayST.setName(property.getName());
                    propertiesST.addGettersValue(getJsonArrayST);

                    break;
            }

            entityST.addPropertiesValue(propertiesST);
        }

        return entityST;

    }

    private JsonModelGroup.enumST newEnumST(MetaEnum model) {

        final JsonModelGroup.enumST enumST = group.newenum();
        enumST.setName(model.getName());
        enumST.setPackageName(model.getPackageName());

        for (String v : model.getValues().split("[ ]"))
            enumST.addValuesValue(v);

        return enumST;
    }
}