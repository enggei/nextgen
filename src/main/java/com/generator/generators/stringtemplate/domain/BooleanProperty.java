package com.generator.generators.stringtemplate.domain;

import io.vertx.core.json.JsonObject;

import java.util.UUID;

import static com.generator.generators.stringtemplate.domain.TemplateEntities.BOOLEANPROPERTY;

/**
 * User: geirove
 * Date: 30.08.12
 */
public class BooleanProperty extends Property {

	private final String propertyName;
	private Boolean value;

	public BooleanProperty(UUID uuid, String propertyName, Boolean value) {
		super(uuid, BOOLEANPROPERTY);
		this.propertyName = propertyName;
		this.value = value;
	}

	public BooleanProperty(UUID uuid, String propertyName) {
		super(uuid, BOOLEANPROPERTY);
		this.propertyName = propertyName;
		this.value = true;
	}

	/**
	 * copy-constructor
	 *
	 * @param property the object to copy values ONLY from (not same UUID)
	 */
	public BooleanProperty(BooleanProperty property) {
		super(BOOLEANPROPERTY);
		this.propertyName = property.getPropertyName();
		this.value = property.getValue();
	}

	public BooleanProperty(String propertyName, Boolean value) {
		super(BOOLEANPROPERTY);
		this.propertyName = propertyName;
		this.value = value;
	}

	public BooleanProperty(String name) {
		super(UUID.randomUUID(), BOOLEANPROPERTY);
		this.propertyName = name;
		this.value = true;
	}

	public void setValue(Boolean value) {
		this.value = value == null || !value ? null : value;
	}

	public Boolean getValue() {
		return value;
	}

	@Override
	public JsonObject toJson() {
		return newJson().
			put("value", value);
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
		return new BooleanProperty(this.uuid, this.propertyName, this.value);
	}

	@Override
	public String toString() {
		return (getValue() == null || !getValue()) ? "" : getPropertyName();
	}
}