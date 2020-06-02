package nextgen.st.domain;


public class STParameterKey {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STParameterKey() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STParameterKey(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STParameterKey other = (STParameterKey) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STParameterKey setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.getString("name");
	}

	public STParameterKey addArgumentTypes(String value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("argumentTypes");
		if (jsonArray == null) jsonObject.put("argumentTypes", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value);
		return this;
	}

	public java.util.stream.Stream<String> getArgumentTypes() { 
		return jsonObject.getJsonArray("argumentTypes", new io.vertx.core.json.JsonArray()).stream().map((o) -> (String) o);
	}

	public STParameterKey clearArgumentTypes() { 
		jsonObject.put("argumentTypes", new io.vertx.core.json.JsonArray());
		return this;
	}
}