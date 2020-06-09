package nextgen.st.domain;

public class STEnum {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STEnum() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STEnum(io.vertx.core.json.JsonObject jsonObject) { 
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
		final STEnum other = (STEnum) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STEnum setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	public STEnum setValues(String value) { 
		jsonObject.put("values", value);
		return this;
	}

	public String getValues() { 
		return jsonObject.getString("values");
	}

	public String getValues(String defaultValue) { 
		return jsonObject.getString("values", defaultValue);
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.getString("name");
	}
}