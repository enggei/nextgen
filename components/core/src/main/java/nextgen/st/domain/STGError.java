package nextgen.st.domain;


public class STGError {

	private final io.vertx.core.json.JsonObject jsonObject;
	private org.stringtemplate.v4.misc.STMessage message;

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
		jsonObject.put("type", value.name());
		return this;
	}

	public STGErrorType getType() { 
		return jsonObject.getString("type") == null ? null : STGErrorType.valueOf(jsonObject.getString("type"));
	}

	public STGError setMessage(org.stringtemplate.v4.misc.STMessage message) { 
		this.message = message;
		return this;
	}

	public org.stringtemplate.v4.misc.STMessage getMessage() { 
		return this.message;
	}

	public boolean hasMessage() { 
		return message != null;
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}