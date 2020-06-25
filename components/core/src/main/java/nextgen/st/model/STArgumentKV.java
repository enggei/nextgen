package nextgen.st.model;

public class STArgumentKV {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STArgumentKV() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STArgumentKV(io.vertx.core.json.JsonObject jsonObject) { 
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

	public STArgumentKV removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STArgumentKV other = (STArgumentKV) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STArgumentKV setKey(String value) { 
		jsonObject.put("key", value);
		return this;
	}

	public String getKey() { 
		return jsonObject.getString("key");
	}

	public String getKey(String defaultValue) { 
		return jsonObject.getString("key", defaultValue);
	}

	public STArgumentKV setValue(STValue value) { 
		jsonObject.put("value", value.getJsonObject());
		return this;
	}

	public STValue getValue() { 
		return jsonObject.getJsonObject("value") == null ? null : new STValue(jsonObject.getJsonObject("value"));
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}