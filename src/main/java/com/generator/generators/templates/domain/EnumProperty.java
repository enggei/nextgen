package com.generator.generators.templates.domain;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static com.generator.generators.templates.domain.TemplateEntities.ENUMPROPERTY;

/**
 * User: goe
 * Date: 27.09.13
 */
public class EnumProperty extends Property {

	private final Set<String> legalValues;
	private final String propertyName;
	private String value;

	public EnumProperty(UUID uuid, Set<String> legalValues, String propertyName, String value) {
		super(uuid, ENUMPROPERTY);
		this.legalValues = new LinkedHashSet<>(legalValues);
		this.propertyName = propertyName;
		this.value = value;
	}

	public EnumProperty(Set<String> legalValues, String propertyName, String value) {
		super(ENUMPROPERTY);
		this.legalValues = new LinkedHashSet<>(legalValues);
		this.propertyName = propertyName;
		this.value = value;
	}

	public EnumProperty(String propertyName, String value, Set<String> legalValues) {
		super(ENUMPROPERTY);
		this.legalValues = new LinkedHashSet<>(legalValues);
		this.propertyName = propertyName;
		this.value = value;
	}

	public String[] values() {
		return legalValues.toArray(new String[legalValues.size()]);
	}

	public void setValue(String value) {
		if (this.value != null && value != null && this.value.equals(value)) return;
		if (value != null && !legalValues.contains(value))
			throw new IllegalArgumentException("cannot assign '" + value + "' : must be one of : " + legalValues);
		this.value = value != null ? (value.trim().length() == 0 ? null : value.trim()) : value;
	}

	public String getValue() {
		return value;
	}


	@Override
	public JsonObject toJson() {

		final JsonArray jsonLegalValues = new JsonArray();
		for (String legalValue : legalValues)
			jsonLegalValues.add(legalValue);

		return newJson().
			put("legalValues", jsonLegalValues);
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
		return new EnumProperty(this.uuid, new LinkedHashSet<>(legalValues), this.propertyName, this.value);
	}

	@Override
	public String toString() {
		return propertyName;
	}
}