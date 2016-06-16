package com.generator.editors.domain;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * User: goe
 * Date: 20.05.14
 * todo: should meta-property enforce nullable, ie. should the validate-method consider null, or is this solved by 'defaultValue' :
 */
public class MetaProperty {

    private String name;
    private String type;
    private final Set<String> legalValues = new TreeSet<>();
    private final String defaultValue;

    public MetaProperty(String name, String defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    public MetaProperty(String name) {
        this(name, "[]");
    }

    // todo: test this default-value setup (first value is default
    public MetaProperty(String name, String... legalValues) {
        this(name, legalValues.length > 0 ? legalValues[0] : "[]");
        Collections.addAll(this.legalValues, legalValues);
    }

    public MetaProperty setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name == null ? defaultValue : name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {

        if (this.legalValues.isEmpty()) {
            this.name = name;
            return;
        }

        if (this.legalValues.contains(name)) {
            this.name = name;
            return;
        }

        throw new IllegalArgumentException("'" + name + "' is not allowed. Must be one of " + this.legalValues + ".");
    }

    public Set<String> getLegalValues() {
        return Collections.unmodifiableSet(legalValues);
    }

    public boolean validate(String value) {
        return legalValues.isEmpty() || legalValues.contains(value);
    }

    @SuppressWarnings("unchecked")
    public <T> T valueIn(Node node) {
        return node.hasProperty(name) ? (T) node.getProperty(name) : (T) defaultValue;
    }

    @SuppressWarnings("unchecked")
    public <T> T valueIn(Relationship relationship) {
        return relationship.hasProperty(name) ? (T) relationship.getProperty(name) : (T) defaultValue;
    }

    public MetaProperty setValue(Node node, String value) {
        if (value == null || value.length() == 0 || "[]".equals(value)) node.removeProperty(name);
        else node.setProperty(name, value.trim());
        return this;
    }

    public MetaProperty setValue(Relationship relationship, String value) {
        if (value == null || value.length() == 0 || "[]".equals(value)) relationship.removeProperty(name);
        else relationship.setProperty(name, value.trim());
        return this;
    }

    @Override
    public String toString() {
        return name + " " + legalValues;
    }
}