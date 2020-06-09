package nextgen.st.domain;

public class STGError {

	private final io.vertx.core.json.JsonObject jsonObject;
	private org.stringtemplate.v4.misc.STMessage _message;

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

	public STGError setMessage(org.stringtemplate.v4.misc.STMessage value) { 
		this._message = value;
		return this;
	}

	public org.stringtemplate.v4.misc.STMessage getMessage() { 
		return this._message;
	}

	public org.stringtemplate.v4.misc.STMessage getMessage(org.stringtemplate.v4.misc.STMessage defaultValue) { 
		return this._message == null ? defaultValue : this._message;
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}