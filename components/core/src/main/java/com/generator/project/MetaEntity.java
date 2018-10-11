package com.generator.project;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public class MetaEntity extends JsonObject {

	public MetaEntity(Object object) {
		this((JsonObject)object);
	}

	public MetaEntity(JsonObject jsonObject) {
		mergeIn(jsonObject, true);
	}

	public MetaEntity(String name, String packageName) {
		put("name", name);
		put("packageName", packageName);
	}

	public MetaEntity setName(String value) {
		put("name", value);
		return this;
	}

	public String getName() {
		return getString("name");
	}

	public MetaEntity setPackageName(String value) {
		put("packageName", value);
		return this;
	}

	public String getPackageName() {
		return getString("packageName");
	}

	public MetaEntity addProperties(MetaProperty value) {
		JsonArray jsonArray = getJsonArray("properties");
		if (jsonArray == null) put("properties", jsonArray = new JsonArray());
		jsonArray.add(value);
		return this;
	}

	public MetaEntity setProperties(JsonArray value) {
		put("properties", value);
		return this;
	}

	public JsonArray getProperties() {
		return getJsonArray("properties", new JsonArray());
	}
}