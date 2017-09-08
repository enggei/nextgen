package com.generator.generators.stringtemplate.domain;

import java.util.*;

import static com.generator.generators.stringtemplate.domain.TemplateEntities.STATEMENT;

/**
 * User: geirove
 * Date: 30.08.12
 * //todo: add property change and vetoable change listener, using UUID as source ...
 * // todo: make all properties use uuid
 */
public class Statement extends BaseEntity<TemplateEntities> {

    private String name;
    protected final List<Property> properties = new LinkedList<>();

    public Statement(String name) {
        super(UUID.randomUUID(), STATEMENT);
        this.name = name;
    }

    public Statement(UUID uuid, String name) {
        super(uuid, STATEMENT);
        this.name = name;
    }

    public Statement(UUID uuid, String name, List<Property> properties) {
        super(uuid, STATEMENT);
        this.name = name;
        for (Property property : properties)
            add(property);
    }

    public Statement(String name, List<Property> properties) {
        super(UUID.randomUUID(), STATEMENT);
        this.name = name;
        this.properties.addAll(properties);
    }

    public Statement(Statement statement) {
        super(STATEMENT);
        this.name = statement.getStatementName();
        for (Property property : statement.getProperties()) {
            Property newProperty;
            if (property instanceof StringProperty)
                this.properties.add(newProperty = new StringProperty((StringProperty) property));
            else if (property instanceof BooleanProperty)
                this.properties.add(newProperty = new BooleanProperty((BooleanProperty) property));
            else if (property instanceof StatementProperty)
                this.properties.add(newProperty = new StatementProperty((StatementProperty) property));
            else if (property instanceof ListProperty)
                this.properties.add(newProperty = new ListProperty((ListProperty) property));
            else if (property instanceof KeyValueListProperty)
                this.properties.add(newProperty = new KeyValueListProperty((KeyValueListProperty) property));
            else throw new IllegalArgumentException("what is this ? " + property.getClass());
        }
    }


    public String getStatementName() {
        return name;
    }

    public Statement setStatementName(String name) {
        this.name = name;
        return this;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void add(int index, Property property) {
        this.properties.add(index, property);
    }

    public Statement add(Property property) {
        if (this.properties.contains(property)) return this;
        this.properties.add(property);
        return this;
    }

    public Statement addStringProperty(String name, String value) {
        return add(new StringProperty(name,value));
    }

    public Statement addStatementProperty(String name, String value) {
        return add(new StringProperty(name,value));
    }

    public void removeProperty(int index) {
        this.properties.remove(index);
    }

    public StringProperty getStringProperty(String propertyName) {
        for (Property property : properties)
            if (propertyName.equals(property.getPropertyName()) && (property instanceof StringProperty))
                return ((StringProperty) property);
        return null;
    }

    public ListProperty getListProperty(String propertyName) {
        for (Property property : properties)
            if (propertyName.endsWith(property.getPropertyName()) && (property instanceof ListProperty))
                return ((ListProperty) property);
        return null;
    }

    public KeyValueListProperty getKeyValueListProperty(String propertyName) {
        for (Property property : properties)
            if (propertyName.endsWith(property.getPropertyName()) && (property instanceof KeyValueListProperty))
                return ((KeyValueListProperty) property);
        return null;
    }

    public String getStringPropertyValue(String propertyName) {
        final StringProperty stringProperty = getStringProperty(propertyName);
        return stringProperty == null ? null : stringProperty.getValue();
    }

    public String getStringPropertyValue(String propertyName, String defaultValue) {
        final StringProperty stringProperty = getStringProperty(propertyName);
        return (stringProperty == null) ? defaultValue : stringProperty.getValue();
    }

    public String getUpdateStringPropertyValue(String propertyName, String defaultValue) {
        final StringProperty stringProperty = getStringProperty(propertyName);
        if (stringProperty == null) setStringPropertyValue(propertyName, defaultValue);
        return getStringPropertyValue(propertyName);
    }

    public void setStringPropertyValue(String propertyName, String value) {
        StringProperty stringProperty = getStringProperty(propertyName);
        if (stringProperty == null) properties.add(new StringProperty(UUID.randomUUID(), propertyName, value));
        else stringProperty.setValue(value);
    }

    public void setProperties(List<Property> properties) {
        final List<Property> oldProperties = new ArrayList<>(this.properties);
        this.properties.clear();
        this.properties.addAll(properties);
    }

    public boolean hasStatementName(String statementName) {
        if (getStatementName().equals(statementName)) return true;
        for (Property property : properties) {
            if (property instanceof StatementProperty && ((StatementProperty) property).getStatement().hasStatementName(statementName))
                return true;
            if (property instanceof ListProperty && ((ListProperty) property).hasStatementName(statementName))
                return true;
            if (property instanceof KeyValueListProperty && ((KeyValueListProperty) property).hasStatementName(statementName))
                return true;
        }
        return false;
    }

    public void renameTemplateStatement(String oldName, String newName) {
        if (this.name.equals(oldName)) setStatementName(newName);
        for (Property property : properties) {
            property.renameTemplateStatement(oldName, newName);
        }
    }

    public void setStringPropertyValue(UUID uuid, String value) {
        for (Property property : properties) {
            if (property.getUuid().equals(uuid)) {
                ((StringProperty) property).setValue(value);
            }
        }
    }

    public boolean removeProperty(UUID uuid) {
        boolean removed = false;
        for (int i = properties.size() - 1; i >= 0; i--) {
            if (properties.get(i).getUuid().equals(uuid)) {
                properties.remove(i);
                removed = true;
            } else {
                if (properties.get(i).removeProperty(uuid))
                    removed = true;
            }
        }
        return removed;
    }

    @Override
    public String toString() {
		 final StringBuilder out = new StringBuilder((getStatementName() == null ? "" : getStatementName())).append("(");
		 boolean first = true;
		 for (Property property : getProperties()) {
			 // todo : test this
			 final String s = property.toString();
			 if (s.length() == 0) continue;

			 if (!first) out.append(",");
			 out.append(property);
			 first = false;
		 }
		 out.append(")");
		 return out.toString().trim();
    }

    public Property getProperty(UUID uuid) {
        for (Property property : properties) if (property.getUuid().equals(uuid)) return property;
        return null;
    }

    public static Set<UUID> getAllMissingInRight(Statement left, Statement right) {
        final Set<UUID> newParameters = new LinkedHashSet<>();
        for (Property committedParameter : left.getProperties()) {
            boolean found = false;
            for (Property oldParameter : right.getProperties()) {
                if (committedParameter.equals(oldParameter)) {
                    found = true;
                    break;
                }
            }
            if (!found) newParameters.add(committedParameter.getUuid());
        }
        return newParameters;
    }

    public Statement copy() {
        final List<Property> copiedProperties = new ArrayList<>();
        for (Property property : properties)
            copiedProperties.add(property.copy());
        return new Statement(this.uuid, this.name, copiedProperties);
    }

    public boolean hasBooleanProperty(String name) {
        for (Property property : properties)
            if (property instanceof BooleanProperty && property.getPropertyName().equals(name)) return true;
        return false;
    }
}