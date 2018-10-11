package com.generator.project;

import io.vertx.core.json.JsonObject;

public class MetaEnum extends JsonObject {

	public MetaEnum(Object object) {
		this((JsonObject)object);
	}

	public MetaEnum(JsonObject jsonObject) {
		mergeIn(jsonObject, true);
	}

	public MetaEnum(String name, String packageName, String values) {
		put("name", name);
		put("packageName", packageName);
		put("values", values);
	}

	public MetaEnum setName(String value) {
		put("name", value);
		return this;
	}

	public String getName() {
		return getString("name");
	}

	public MetaEnum setPackageName(String value) {
		put("packageName", value);
		return this;
	}

	public String getPackageName() {
		return getString("packageName");
	}

	public MetaEnum setValues(String value) {
		put("values", value);
		return this;
	}

	public String getValues() {
		return getString("values");
	}
}