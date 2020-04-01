package com.generator.generators.jsonschema;

import com.generator.generators.json.JsonGroup;

import java.util.ArrayList;
import java.util.List;

public class JsonSchema {

    public static JsonSchema newDraft7Schema(String id, String title, String description, Type type) {
        return new JsonSchema(id, SCHEMA_DRAFT_7, title, description, type);
    }

    public static final String SCHEMA_DRAFT_7 = "http://json-schema.org/draft-07/schema#";



    public enum Type {
        NULL, BOOLEAN, OBJECT, ARRAY, NUMBER, INTEGER, STRING, REFERENCE
    }

    private static final JsonGroup jsonGroup = new JsonGroup();

    private String id;
    private String schema;
    private String title;
    private String description;
    private Type type;

    private final List<Property> properties = new ArrayList<>();
    private final List<Property> definitions = new ArrayList<>();

    public JsonSchema() {
    }

    public JsonSchema(String id, String schema, String title, String description, Type type) {
        this.id = id;
        this.schema = schema;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public JsonSchema setId(String id) {
        this.id = id;
        return this;
    }

    public JsonSchema setSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public JsonSchema setTitle(String title) {
        this.title = title;
        return this;
    }

    public JsonSchema setDescription(String description) {
        this.description = description;
        return this;
    }

    public JsonSchema setType(Type type) {
        this.type = type;
        return this;
    }

    public JsonSchema add(Property property) {
        this.properties.add(property);
        return this;
    }

    public static StringProperty newStringProperty(String name, String description, boolean required) {
        return new StringProperty(name, description, required);
    }

    public JsonSchema addDefinition(Property property) {
        this.definitions.add(property);
        return this;
    }

    private static Object asString(Object value) {
        return jsonGroup.newprimitiveString().setValue(value);
    }

    @Override
    public String toString() {

        final JsonGroup.objectST doc = jsonGroup.newobject().addPairsValue("$id", asString(id)).
                addPairsValue("$schema", asString(schema)).
                addPairsValue("title", asString(title)).
                addPairsValue("description", asString(description)).
                addPairsValue("type", asString(map(type)));

        final JsonGroup.objectST propertiesJson = jsonGroup.newobject();
        final JsonGroup.arrayST requiredJson = jsonGroup.newarray();
        for (Property property : properties) {
            propertiesJson.addPairsValue(property.name, property.toST());
            if (property.required) requiredJson.addElementsValue(asString(property.name));
        }
        if (!properties.isEmpty()) doc.addPairsValue("properties", propertiesJson);
        if (!requiredJson.getElementsValues().isEmpty()) doc.addPairsValue("required", requiredJson);

        JsonGroup.objectST definitionsST = jsonGroup.newobject();
        for (Property definition : definitions) {
            definitionsST.addPairsValue(definition.name, definition.toST());
        }
        if (!definitions.isEmpty()) doc.addPairsValue("definitions", definitionsST);

        return jsonGroup.newdocument().addContentValue(doc).toString();
    }

    public static Type convert(String type) {
        switch (type) {
            case "null":
                return Type.NULL;
            case "boolean":
                return Type.BOOLEAN;
            case "object":
                return Type.OBJECT;
            case "array":
                return Type.ARRAY;
            case "number":
                return Type.NUMBER;
            case "integer":
                return Type.INTEGER;
            case "string":
                return Type.STRING;
        }
        throw new IllegalArgumentException("Unknown type " + type);
    }

    private static String map(Type type) {
        switch (type) {
            case NULL:
                return "null";
            case REFERENCE:
                return null;
            case BOOLEAN:
                return "boolean";
            case OBJECT:
                return "object";
            case ARRAY:
                return "array";
            case NUMBER:
                return "number";
            case INTEGER:
                return "integer";
            case STRING:
                return "string";
        }
        throw new IllegalArgumentException("Unknown type " + type);
    }

    public static abstract class Property<T extends Property<T>> {

        protected String name;
        protected String description;
        protected Boolean required;
        private Type type;

        protected Property(Type type) {
            this.type = type;
        }

        protected Property(Type type, String name, String description, boolean required) {
            this(type);
            this.name = name;
            this.description = description;
            this.required = required;
        }

        public T setName(String name) {
            this.name = name;
            return (T) this;
        }

        public T setDescription(String description) {
            this.description = description;
            return (T) this;
        }

        public T setRequired(Boolean required) {
            this.required = required;
            return (T) this;
        }

        protected JsonGroup.objectST toST() {
            final JsonGroup.objectST objectST = jsonGroup.newobject();
            objectST.addPairsValue("type", asString(map(type)));
            objectST.addPairsValue("description", asString(description));
            return objectST;
        }

        @Override
        public String toString() {
            return toST().toString();
        }

        public String reference() {
            return "#/definitions/" + name;
        }
    }

    public static class ReferenceProperty extends Property<ReferenceProperty> {

        private String reference;

        public ReferenceProperty() {
            super(Type.REFERENCE);
        }

        public ReferenceProperty(String name, String description, boolean required, String reference) {
            super(Type.REFERENCE, name, description, required);
            this.reference = reference;
        }

        public ReferenceProperty setReference(String reference) {
            this.reference = reference;
            return this;
        }

        @Override
        protected JsonGroup.objectST toST() {
            final JsonGroup.objectST objectST = jsonGroup.newobject();
            objectST.addPairsValue("description", asString(description));
            objectST.addPairsValue("$ref", asString(reference));
            return objectST;
        }
    }

    public static class NumericProperty extends Property<NumericProperty> {

        private Integer multipleOf;
        private Integer maximum;
        private Integer exclusiveMaximum;
        private Integer minimum;
        private Integer exclusiveMinimum;

        public NumericProperty() {
            super(Type.NUMBER);
        }

        public NumericProperty(String name, String description, boolean required) {
            super(Type.NUMBER, name, description, required);
        }

        public NumericProperty setMultipleOf(Integer multipleOf) {
            this.multipleOf = multipleOf;
            return this;
        }

        public NumericProperty setMaximum(Integer maximum) {
            this.maximum = maximum;
            return this;
        }

        public NumericProperty setExclusiveMaximum(Integer exclusiveMaximum) {
            this.exclusiveMaximum = exclusiveMaximum;
            return this;
        }

        public NumericProperty setMinimum(Integer minimum) {
            this.minimum = minimum;
            return this;
        }

        public NumericProperty setExclusiveMinimum(Integer exclusiveMinimum) {
            this.exclusiveMinimum = exclusiveMinimum;
            return this;
        }

        @Override
        protected JsonGroup.objectST toST() {
            final JsonGroup.objectST propertyST = super.toST();
            if (multipleOf != null)
                propertyST.addPairsValue("multipleOf", multipleOf);
            if (maximum != null)
                propertyST.addPairsValue("maximum", maximum);
            if (exclusiveMaximum != null)
                propertyST.addPairsValue("exclusiveMaximum", exclusiveMaximum);
            if (minimum != null)
                propertyST.addPairsValue("minimum", minimum);
            if (exclusiveMinimum != null)
                propertyST.addPairsValue("exclusiveMinimum", exclusiveMinimum);
            return propertyST;
        }
    }

    public static class IntegerProperty extends NumericProperty {

    }

    public static class StringProperty extends Property<StringProperty> {

        private Integer maxLength;
        private Integer minLength;
        private String pattern;

        public StringProperty() {
            super(Type.STRING);
        }

        public StringProperty(String name, String description, boolean required) {
            super(Type.STRING, name, description, required);
        }

        public StringProperty setMaxLength(Integer maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public StringProperty setMinLength(Integer minLength) {
            this.minLength = minLength;
            return this;
        }

        public StringProperty setPattern(String pattern) {
            this.pattern = pattern;
            return this;
        }

        @Override
        protected JsonGroup.objectST toST() {
            final JsonGroup.objectST propertyST = super.toST();
            if (maxLength != null) propertyST.addPairsValue("maxLength", maxLength);
            if (minLength != null) propertyST.addPairsValue("minLength", minLength);
            if (pattern != null) propertyST.addPairsValue("pattern", pattern);
            return propertyST;
        }
    }

    public static class BooleanProperty extends Property<BooleanProperty> {

        public BooleanProperty() {
            super(Type.BOOLEAN);
        }

        public BooleanProperty(String name, String description, boolean required) {
            super(Type.BOOLEAN, name, description, required);
        }
    }

    public static class ArrayProperty extends Property<ArrayProperty> {

        private ArrayItem items;
        private Integer maxItems;
        private Integer minItems;
        private Boolean uniqueItems;
        private JsonSchema contains;

        public ArrayProperty() {
            super(Type.ARRAY);
        }

        public ArrayProperty(String name, String description, boolean required) {
            super(Type.ARRAY, name, description, required);
        }

        public ArrayProperty setItems(ArrayItem items) {
            this.items = items;
            return this;
        }

        public ArrayProperty setMaxItems(Integer maxItems) {
            this.maxItems = maxItems;
            return this;
        }

        public ArrayProperty setMinItems(Integer minItems) {
            this.minItems = minItems;
            return this;
        }

        public ArrayProperty setUniqueItems(Boolean uniqueItems) {
            this.uniqueItems = uniqueItems;
            return this;
        }

        public ArrayProperty setContains(JsonSchema contains) {
            this.contains = contains;
            return this;
        }

        @Override
        protected JsonGroup.objectST toST() {
            final JsonGroup.objectST propertyST = super.toST();

            propertyST.addPairsValue("items", items.toST());

            if (maxItems != null) propertyST.addPairsValue("maxItems", maxItems);
            if (minItems != null) propertyST.addPairsValue("minItems", minItems);
            if (uniqueItems != null) propertyST.addPairsValue("uniqueItems", uniqueItems);
            return propertyST;
        }

        public static class ArrayItem {

            public JsonGroup.objectST toST() {
                return jsonGroup.newobject();
            }
        }

        public static class TypedArrayItem extends ArrayItem {

            private final Type type;

            public TypedArrayItem(Type type) {
                this.type = type;
            }

            @Override
            public JsonGroup.objectST toST() {
                return super.toST().addPairsValue("type", asString(map(type)));
            }
        }

        public static class ReferencedArrayItem extends ArrayItem {

            private final String reference;

            public ReferencedArrayItem(String reference) {
                this.reference = reference;
            }

            @Override
            public JsonGroup.objectST toST() {
                return super.toST().addPairsValue("$ref", asString(reference));
            }
        }
    }

    public static class ObjectProperty extends Property<ObjectProperty> {

        private Integer maxProperties;
        private Integer minProperties;
        private Boolean required;
        private final List<Property> properties = new ArrayList<>();
        private String patternProperties;
        private final List<Property> additionalProperties = new ArrayList<>();

        public ObjectProperty() {
            super(Type.OBJECT);
        }

        public ObjectProperty(String name, String description, boolean required) {
            super(Type.OBJECT, name, description, required);
        }

        public ObjectProperty add(Property property) {
            this.properties.add(property);
            return this;
        }

        @Override
        protected JsonGroup.objectST toST() {
            final JsonGroup.objectST propertyST = super.toST();

            final JsonGroup.objectST propertiesJson = jsonGroup.newobject();
            final JsonGroup.arrayST requiredJson = jsonGroup.newarray();
            for (Property property : properties) {
                propertiesJson.addPairsValue(property.name, property.toST());
                if (property.required) requiredJson.addElementsValue(asString(property.name));
            }
            if (!properties.isEmpty()) propertyST.addPairsValue("properties", propertiesJson);
            if (!requiredJson.getElementsValues().isEmpty()) propertyST.addPairsValue("required", requiredJson);
            return propertyST;
        }
    }
}