package nextgen.st.domain;

public class STGParseResult {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STGParseResult() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STGParseResult(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STGParseResult(java.io.File file) throws java.io.IOException {
		this(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public STGParseResult(java.io.InputStream inputStream) throws java.io.IOException {
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

	public STGParseResult removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STGParseResult other = (STGParseResult) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STGParseResult setParsed(STGroupModel value) { 
		jsonObject.put("parsed", value.getJsonObject());
		return this;
	}

	public STGroupModel getParsed() { 
		return jsonObject.getJsonObject("parsed") == null ? null : new STGroupModel(jsonObject.getJsonObject("parsed"));
	}

	public STGParseResult addErrors(STGError value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("errors");
		if (jsonArray == null) jsonObject.put("errors", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STGError> getErrors() { 
		return jsonObject.getJsonArray("errors", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STGError((io.vertx.core.json.JsonObject) o));
	}

	public STGParseResult removeErrors(STGError value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("errors", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STGParseResult clearErrors() { 
		jsonObject.put("errors", new io.vertx.core.json.JsonArray());
		return this;
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}