package com.generator.generators.stringtemplate.domain;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static com.generator.generators.stringtemplate.domain.TemplateEntities.KEYVALUELISTPROPERTY;

/**
 * User: geirove
 * Date: 30.08.12
 * <p>
 */
public class KeyValueListProperty extends Property {

	private final String name;
	protected final List<PropertySet> elements = new LinkedList<>();

	public KeyValueListProperty(String name) {
		super(UUID.randomUUID(), KEYVALUELISTPROPERTY);
		this.name = name;
	}

	public KeyValueListProperty(UUID uuid, String name) {
		super(uuid, KEYVALUELISTPROPERTY);
		this.name = name;
	}

	public KeyValueListProperty(String propertyName, List<List<Property>> kvProperties) {
		super(UUID.randomUUID(), KEYVALUELISTPROPERTY);
		this.name = propertyName;
		for (List<Property> element : kvProperties) {
			final PropertySet propertySet = new PropertySet(element);
			this.elements.add(propertySet);
		}
	}

	public KeyValueListProperty(UUID uuid, String propertyName, List<List<Property>> elements) {
		this(uuid, propertyName);

		if (elements != null)
			for (List<Property> element : elements)
				this.elements.add(new PropertySet(element));
	}

	public KeyValueListProperty(KeyValueListProperty property) {
		super(KEYVALUELISTPROPERTY);
		this.name = property.getPropertyName();
		for (List<Property> kvSet : property.getElements()) {
			final List<Property> propertyList = new ArrayList<>(kvSet.size());
			for (Property kv : kvSet) {
				if (kv instanceof StringProperty) propertyList.add(new StringProperty((StringProperty) kv));
				else if (kv instanceof StatementProperty) propertyList.add(new StatementProperty((StatementProperty) kv));
				else if (kv instanceof ListProperty) propertyList.add(new ListProperty((ListProperty) kv));
				else if (kv instanceof KeyValueListProperty)
					propertyList.add(new KeyValueListProperty((KeyValueListProperty) kv));
			}
			final PropertySet propertySet = new PropertySet(propertyList);
			this.elements.add(propertySet);
		}
	}

	@Override
	public JsonObject toJson() {

		final JsonArray jsonElements = new JsonArray();
		for (PropertySet propertySet : elements)
			jsonElements.add(propertySet.toJson());

		return newJson().
			put("elements", jsonElements);
	}

	public void setElements(List<PropertySet> elements) {

		final List<PropertySet> old = new ArrayList<>(this.elements);
		this.elements.clear();
		for (PropertySet element : elements) {
			this.elements.add(element);
		}
	}

	public KeyValueListProperty addPropertySet(PropertySet propertySet) {
		if (elements.contains(propertySet)) return this;
		elements.add(propertySet);
		return this;
	}

	@Override
	public boolean removeProperty(UUID uuid) {
		boolean removed = false;
		for (PropertySet propertySet : elements) {
			final List<Property> propertyList = propertySet.getPropertyList();

			for (int i = propertyList.size() - 1; i >= 0; i--) {
				if (propertyList.get(i).getUuid().equals(uuid)) {
					propertySet.removeProperty(uuid);
					removed = true;
				}
			}
		}
		return removed;
	}

	public List<List<Property>> getElements() {
		final List<List<Property>> list = new ArrayList<>();
		for (PropertySet propertySet : elements)
			list.add(propertySet.getPropertyList());
		return list;
	}

	public List<PropertySet> asPropertySets() {
		return elements;
	}

	public void removePropertySet(UUID uuid) {
		for (int i = elements.size() - 1; i >= 0; i--) {
			if (elements.get(i).getUuid().equals(uuid)) {
				final PropertySet remove = elements.remove(i);
			}
		}
	}

	public boolean hasStatementName(String statementName) {
		for (PropertySet properties : elements) {
			for (Property property : properties.getPropertyList()) {
				if (property instanceof StatementProperty && ((StatementProperty) property).getStatement().hasStatementName(statementName))
					return true;
				if (property instanceof ListProperty && ((ListProperty) property).hasStatementName(statementName))
					return true;
				if (property instanceof KeyValueListProperty && ((KeyValueListProperty) property).hasStatementName(statementName))
					return true;
			}
		}
		return false;
	}

	@Override
	public void renameTemplateStatement(String oldName, String newName) {
		for (PropertySet properties : elements)
			properties.renameTemplateStatement(oldName, newName);
	}

	@Override
	public String getPropertyName() {
		return name;
	}

	@Override
	public Property copy() {
		final List<List<Property>> copiedElements = new ArrayList<>();
		for (PropertySet copiedElement : elements)
			copiedElements.add(copiedElement.copyElements());
		return new KeyValueListProperty(this.uuid, this.name, copiedElements);
	}

	@Override
	public String toString() {
		final StringBuilder out = new StringBuilder(getPropertyName()).append(":[");
		boolean firstKeyValueList = true;
		for (List<Property> keyValueList : getElements()) {
			if (keyValueList.size() == 0) continue;
			if (!firstKeyValueList) out.append(",");
			out.append("\n(");
			boolean first = true;
			for (Property prop : keyValueList) {
				if (!first) out.append(",");
				out.append(prop);
				first = false;
			}
			out.append(")");
			firstKeyValueList = false;
		}
		out.append("]");
		return out.toString().trim();
	}


}