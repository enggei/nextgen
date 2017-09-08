package com.generator.generators.stringtemplate.domain;


import io.vertx.core.json.JsonObject;

import java.util.UUID;

/**
 * Auto-generated
 */
public abstract class Property extends BaseEntity<TemplateEntities> {

	protected Property(UUID uuid, TemplateEntities type) {
		super(uuid, type);
	}

	protected Property(TemplateEntities type) {
		super(type);
	}

	public abstract String getPropertyName();

	public abstract boolean removeProperty(UUID uuid);

	public abstract void renameTemplateStatement(String oldName, String newName);

	public abstract Property copy();

	public abstract JsonObject toJson();

	protected JsonObject newJson() {
		final JsonObject jsonObject = new JsonObject();
		jsonObject.put("DomainType", getDomainType());
		jsonObject.put("propertyName", getPropertyName());
		return jsonObject;
	}
}