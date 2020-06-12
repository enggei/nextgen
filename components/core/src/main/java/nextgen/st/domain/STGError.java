package nextgen.st.domain;

public class STGError {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STGError() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STGError(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	public STGError removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STGError other = (STGError) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STGError setType(STGErrorType value) { 
		if (value == null) return this;
		jsonObject.put("type", value.name());
		return this;
	}

	public STGErrorType getType() { 
		return getType(null);
	}

	public STGErrorType getType(STGErrorType defaultValue) { 
		return jsonObject.getString("type") == null ? defaultValue : STGErrorType.valueOf(jsonObject.getString("type"));
	}

	public STGError setMessage(String value) { 
		jsonObject.put("message", value);
		return this;
	}

	public String getMessage() { 
		return jsonObject.getString("message");
	}

	public String getMessage(String defaultValue) { 
		return jsonObject.getString("message", defaultValue);
	}

	public STGError setLine(Integer value) { 
		jsonObject.put("line", value);
		return this;
	}

	public Integer getLine() { 
		return jsonObject.getInteger("line");
	}

	public Integer getLine(Integer defaultValue) { 
		return jsonObject.getInteger("line", defaultValue);
	}

	public STGError setCharPosition(Integer value) { 
		jsonObject.put("charPosition", value);
		return this;
	}

	public Integer getCharPosition() { 
		return jsonObject.getInteger("charPosition");
	}

	public Integer getCharPosition(Integer defaultValue) { 
		return jsonObject.getInteger("charPosition", defaultValue);
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}