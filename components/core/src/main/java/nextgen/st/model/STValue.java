package nextgen.st.model;

public class STValue {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STValue() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STValue(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	public String uuid() {
		return this.jsonObject.getString("uuid");
	}

	public STValue removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STValue other = (STValue) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STValue setType(STValueType value) { 
		if (value == null) return this;
		jsonObject.put("type", value.name());
		return this;
	}

	public STValueType getType() { 
		return getType(null);
	}

	public STValueType getType(STValueType defaultValue) { 
		return jsonObject.getString("type") == null ? defaultValue : STValueType.valueOf(jsonObject.getString("type"));
	}

	public STValue setValue(String value) { 
		jsonObject.put("value", value);
		return this;
	}

	public String getValue() { 
		return jsonObject.getString("value");
	}

	public String getValue(String defaultValue) { 
		return jsonObject.getString("value", defaultValue);
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}