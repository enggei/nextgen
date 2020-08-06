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

	@Deprecated
	public String uuid() {
		return this.jsonObject.getString("uuid");
	}

	public String getUuid() {
		return this.jsonObject.getString("uuid");
	}

	public STEnum removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
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

	public STEnum addValues(STEnumValue value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("values");
		if (jsonArray == null) jsonObject.put("values", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STEnumValue> getValues() { 
		return jsonObject.getJsonArray("values", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STEnumValue((io.vertx.core.json.JsonObject) o));
	}

	public STEnum removeValues(STEnumValue value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("values", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STEnum clearValues() { 
		jsonObject.put("values", new io.vertx.core.json.JsonArray());
		return this;
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.getString("name");
	}
}