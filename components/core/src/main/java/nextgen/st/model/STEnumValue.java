package nextgen.st.model;

public class STEnumValue {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STEnumValue() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STEnumValue(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STEnumValue(java.io.File file) throws java.io.IOException {
		this(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public STEnumValue(java.io.InputStream inputStream) throws java.io.IOException {
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

	public STEnumValue removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STEnumValue other = (STEnumValue) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STEnumValue setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	public STEnumValue setLexical(String value) { 
		jsonObject.put("lexical", value);
		return this;
	}

	public String getLexical() { 
		return jsonObject.getString("lexical");
	}

	public String getLexical(String defaultValue) { 
		return jsonObject.getString("lexical", defaultValue);
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.getString("name");
	}
}