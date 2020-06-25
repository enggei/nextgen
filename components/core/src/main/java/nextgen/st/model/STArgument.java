package nextgen.st.model;

public class STArgument {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STArgument() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STArgument(io.vertx.core.json.JsonObject jsonObject) { 
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

	public STArgument removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STArgument other = (STArgument) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STArgument setStParameter(String value) { 
		jsonObject.put("stParameter", value);
		return this;
	}

	public String getStParameter() { 
		return jsonObject.getString("stParameter");
	}

	public String getStParameter(String defaultValue) { 
		return jsonObject.getString("stParameter", defaultValue);
	}

	public STArgument setValue(STValue value) { 
		jsonObject.put("value", value.getJsonObject());
		return this;
	}

	public STValue getValue() { 
		return jsonObject.getJsonObject("value") == null ? null : new STValue(jsonObject.getJsonObject("value"));
	}

	public STArgument addKeyValues(STArgumentKV value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("keyValues");
		if (jsonArray == null) jsonObject.put("keyValues", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STArgumentKV> getKeyValues() { 
		return jsonObject.getJsonArray("keyValues", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STArgumentKV((io.vertx.core.json.JsonObject) o));
	}

	public STArgument removeKeyValues(STArgumentKV value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("keyValues", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STArgument clearKeyValues() { 
		jsonObject.put("keyValues", new io.vertx.core.json.JsonArray());
		return this;
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}