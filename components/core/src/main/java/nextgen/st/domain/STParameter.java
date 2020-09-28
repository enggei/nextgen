package nextgen.st.domain;

public class STParameter {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STParameter() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STParameter(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STParameter(java.io.File file) throws java.io.IOException {
		this(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public STParameter(java.io.InputStream inputStream) throws java.io.IOException {
		if (inputStream == null) throw new java.io.IOException("inputStream is null");
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		int read;
		byte[] data = new byte[2048];
		while ((read = inputStream.read(data, 0, data.length)) != -1)
			buffer.write(data, 0, read);
		inputStream.close();
		final byte[] content = buffer.toByteArray();
		buffer.close();

		this.jsonObject = new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(content));
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

	public STParameter removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STParameter other = (STParameter) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STParameter setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	public STParameter setType(STParameterType value) { 
		if (value == null) return this;
		jsonObject.put("type", value.name());
		return this;
	}

	public STParameterType getType() { 
		return getType(null);
	}

	public STParameterType getType(STParameterType defaultValue) { 
		return jsonObject.getString("type") == null ? defaultValue : STParameterType.valueOf(jsonObject.getString("type"));
	}

	public STParameter addKeys(STParameterKey value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("keys");
		if (jsonArray == null) jsonObject.put("keys", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STParameterKey> getKeys() { 
		return jsonObject.getJsonArray("keys", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STParameterKey((io.vertx.core.json.JsonObject) o));
	}

	public STParameter removeKeys(STParameterKey value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("keys", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STParameter clearKeys() { 
		jsonObject.put("keys", new io.vertx.core.json.JsonArray());
		return this;
	}

	public STParameter setArgumentType(String value) { 
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
		return jsonObject.getString("name");
	}
}