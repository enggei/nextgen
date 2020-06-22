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

	public STParameterKey removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
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

	public STParameterKey setArgumentType(String value) { 
		jsonObject.put("argumentType", value);
		return this;
	}

	public String getArgumentType() { 
		return jsonObject.getString("argumentType");
	}

	public String getArgumentType(String defaultValue) { 
		return jsonObject.getString("argumentType", defaultValue);
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}