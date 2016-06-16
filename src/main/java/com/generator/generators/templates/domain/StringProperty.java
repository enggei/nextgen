package com.generator.generators.templates.domain;

import io.vertx.core.json.JsonObject;

import java.util.UUID;

import static com.generator.generators.templates.domain.TemplateEntities.STRINGPROPERTY;

/**
 * User: geirove
 * Date: 30.08.12
 */
public class StringProperty extends Property {

	private final String propertyName;
	private String value;

	public StringProperty(UUID uuid, String propertyName, String value) {
		super(uuid, STRINGPROPERTY);
		this.propertyName = propertyName;
		this.value = value;
	}

	public StringProperty(String propertyName, String value) {
		super(STRINGPROPERTY);
		this.propertyName = propertyName;
		this.value = value;
	}

	public StringProperty(StringProperty property) {
		super(STRINGPROPERTY);
		this.propertyName = property.getPropertyName();
		this.value = property.getValue();
	}

	public StringProperty(String value) {
		super(UUID.randomUUID(), STRINGPROPERTY);
		this.propertyName = null;
		this.value = value;
	}

	public StringProperty(String propertyName, int value) {
		this(UUID.randomUUID(), propertyName, value + "");
	}

	public void setValue(String value) {
		if (this.value != null && value != null && this.value.equals(value)) return;
		this.value = value != null ? (value.trim().length() == 0 ? null : value.trim()) : value;
	}

	public JsonObject toJson() {
		return newJson().
			put(propertyName==null ? "null" : propertyName, value);
	}

	public String getValue() {
		return value;
	}

	@Override
	public String getPropertyName() {
		return propertyName;
	}

	@Override
	public boolean removeProperty(UUID uuid) {
		return false;
	}

	@Override
	public void renameTemplateStatement(String oldName, String newName) {
	}

	@Override
	public Property copy() {
		return new StringProperty(this.uuid, this.propertyName, this.value);
	}

	@Override
	public String toString() {
		if (getValue() == null) return "";
		return (getPropertyName() == null ? "" : (getPropertyName() + ":")) + "\"" + getValue() + "\"";
	}
}