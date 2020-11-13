package nextgen.st.model;

public class STGroupModel {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STGroupModel() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STGroupModel(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STGroupModel(java.io.File file) throws java.io.IOException {
		this(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public STGroupModel(java.io.InputStream inputStream) throws java.io.IOException {
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

	public STGroupModel removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STGroupModel other = (STGroupModel) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STGroupModel setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	public STGroupModel setDelimiter(String value) { 
		jsonObject.put("delimiter", value);
		return this;
	}

	public String getDelimiter() { 
		return jsonObject.getString("delimiter");
	}

	public String getDelimiter(String defaultValue) { 
		return jsonObject.getString("delimiter", defaultValue);
	}

	public STGroupModel setIcon(String value) { 
		jsonObject.put("icon", value);
		return this;
	}

	public String getIcon() { 
		return jsonObject.getString("icon");
	}

	public String getIcon(String defaultValue) { 
		return jsonObject.getString("icon", defaultValue);
	}

	public STGroupModel setTags(String value) { 
		jsonObject.put("tags", value);
		return this;
	}

	public String getTags() { 
		return jsonObject.getString("tags");
	}

	public String getTags(String defaultValue) { 
		return jsonObject.getString("tags", defaultValue);
	}

	public STGroupModel addTemplates(STTemplate value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("templates");
		if (jsonArray == null) jsonObject.put("templates", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STTemplate> getTemplates() { 
		return jsonObject.getJsonArray("templates", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STTemplate((io.vertx.core.json.JsonObject) o));
	}

	public STGroupModel removeTemplates(STTemplate value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("templates", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STGroupModel clearTemplates() { 
		jsonObject.put("templates", new io.vertx.core.json.JsonArray());
		return this;
	}

	public STGroupModel addInterfaces(STInterface value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("interfaces");
		if (jsonArray == null) jsonObject.put("interfaces", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STInterface> getInterfaces() { 
		return jsonObject.getJsonArray("interfaces", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STInterface((io.vertx.core.json.JsonObject) o));
	}

	public STGroupModel removeInterfaces(STInterface value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("interfaces", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STGroupModel clearInterfaces() { 
		jsonObject.put("interfaces", new io.vertx.core.json.JsonArray());
		return this;
	}

	public STGroupModel addEnums(STEnum value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("enums");
		if (jsonArray == null) jsonObject.put("enums", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STEnum> getEnums() { 
		return jsonObject.getJsonArray("enums", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STEnum((io.vertx.core.json.JsonObject) o));
	}

	public STGroupModel removeEnums(STEnum value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("enums", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STGroupModel clearEnums() { 
		jsonObject.put("enums", new io.vertx.core.json.JsonArray());
		return this;
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.getString("name");
	}
}