package com.generator.project;

import io.vertx.core.json.JsonObject;

public class MetaProperty extends JsonObject {

	public MetaProperty(Object object) {
		this((JsonObject)object);
	}

	public MetaProperty(JsonObject jsonObject) {
		mergeIn(jsonObject, true);
	}

	public MetaProperty(String name, String type) {
		put("name", name);
		put("type", type);
	}

	public MetaProperty setName(String value) {
		put("name", value);
		return this;
	}

	public String getName() {
		return getString("name");
	}

	public MetaProperty setType(String value) {
		put("type", value);
		return this;
	}

	public String getType() {
		return getString("type");
	}

	public MetaProperty setIsRequired(Boolean value) {
		put("isRequired", value);
		return this;
	}

	public Boolean getIsRequired() {
		return getBoolean("isRequired", false);
	}

	public MetaProperty setValueType(String value) {
		put("valueType", value);
		return this;
	}

	public String getValueType() {
		return getString("valueType");
	}
}