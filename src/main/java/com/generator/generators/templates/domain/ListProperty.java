package com.generator.generators.templates.domain;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static com.generator.generators.templates.domain.TemplateEntities.LISTPROPERTY;

public class ListProperty extends Property {

	private final String propertyName;
	protected final List<Property> properties = new LinkedList<>();

	public ListProperty(String propertyName) {
		super(UUID.randomUUID(), LISTPROPERTY);
		this.propertyName = propertyName;
	}

	public ListProperty(String propertyName, List<Property> properties) {
		super(UUID.randomUUID(), LISTPROPERTY);
		this.propertyName = propertyName;
		this.properties.addAll(properties);
	}

	public ListProperty(UUID uuid, String propertyName) {
		super(uuid, LISTPROPERTY);
		this.propertyName = propertyName;
	}

	public ListProperty(UUID uuid, String propertyName, List<Property> properties) {
		super(uuid, LISTPROPERTY);
		this.propertyName = propertyName;
		if (properties != null) this.properties.addAll(properties);
	}

	public ListProperty(ListProperty property) {
		super(LISTPROPERTY);
		this.propertyName = property.getPropertyName();
		for (Property element : property.getElements()) {

			switch (element.getDomainType()) {
				case STRINGPROPERTY:
					this.properties.add(new StringProperty((StringProperty) element));
					break;
				case LISTPROPERTY:
					this.properties.add(new ListProperty((ListProperty) element));
					break;
				case KEYVALUELISTPROPERTY:
					this.properties.add(new KeyValueListProperty((KeyValueListProperty) element));
					break;
				case STATEMENTPROPERTY:
					this.properties.add(new StatementProperty((StatementProperty) element));
					break;
			}
		}
	}

	public ListProperty add(int index, Property property) {
		this.properties.add(index, property);
		return this;
	}

	public ListProperty add(Property property) {
		if (properties.contains(property)) return this;
		this.properties.add(property);
		return this;
	}

	public void remove(int index) {
		properties.remove(index);
	}

	@Override
	public JsonObject toJson() {
		final JsonArray jsonElements = new JsonArray();
		for (Property element : properties)
			jsonElements.add(element.toJson());

		return newJson().
			put("properties", jsonElements);
	}

	@Override
	public boolean removeProperty(UUID uuid) {
		boolean removed = false;
		for (int i = properties.size() - 1; i >= 0; i--) {
			if (properties.get(i).getUuid().equals(uuid)) {
				properties.remove(i);
				removed = true;
			}
		}
		return removed;
	}

	public List<Property> getElements() {
		return new ArrayList<>(properties);
	}

	public boolean hasStatementName(String statementName) {
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

	@Override
	public String getPropertyName() {
		return propertyName;
	}

	@Override
	public void renameTemplateStatement(String oldName, String newName) {
		for (Property property : properties)
			property.renameTemplateStatement(oldName, newName);
	}

	@Override
	public Property copy() {
		final List<Property> copiedProperties = new ArrayList<>();
		for (Property property : properties)
			copiedProperties.add(property.copy());
		return new ListProperty(this.uuid, this.propertyName, copiedProperties);
	}

	@Override
	public String toString() {
		if (getElements().isEmpty()) return "";

		final StringBuilder out = new StringBuilder(getPropertyName()).append(":[");
		boolean first = true;
		for (Property prop : getElements()) {
			if (!first) out.append(",");

			switch (prop.getDomainType()) {

				case STRINGPROPERTY:
					out.append("\"").append(((StringProperty) prop).getValue()).append("\"");
					break;

				case STATEMENTPROPERTY:
					out.append(((StatementProperty) prop).getStatement());
					break;
			}

//         out.append(prop);
			first = false;
		}
		out.append("]");
		return out.toString().trim();
	}

	public void setElements(List<Property> properties) {
		this.properties.clear();
		this.properties.addAll(properties);
	}
}