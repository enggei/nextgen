package nextgen.st.domain;

public class STAppModel {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STAppModel() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STAppModel(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	public String uuid() {
		return this.jsonObject.getString("uuid");
	}

	public STAppModel removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STAppModel other = (STAppModel) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STAppModel setModelDb(String value) { 
		jsonObject.put("modelDb", value);
		return this;
	}

	public String getModelDb() { 
		return jsonObject.getString("modelDb");
	}

	public String getModelDb(String defaultValue) { 
		return jsonObject.getString("modelDb", defaultValue);
	}

	public STAppModel setRootDir(String value) { 
		jsonObject.put("rootDir", value);
		return this;
	}

	public String getRootDir() { 
		return jsonObject.getString("rootDir");
	}

	public String getRootDir(String defaultValue) { 
		return jsonObject.getString("rootDir", defaultValue);
	}

	public STAppModel setEditorFontSize(Integer value) { 
		jsonObject.put("editorFontSize", value);
		return this;
	}

	public Integer getEditorFontSize() { 
		return jsonObject.getInteger("editorFontSize");
	}

	public Integer getEditorFontSize(Integer defaultValue) { 
		return jsonObject.getInteger("editorFontSize", defaultValue);
	}

	public STAppModel setGeneratorRoot(String value) { 
		jsonObject.put("generatorRoot", value);
		return this;
	}

	public String getGeneratorRoot() { 
		return jsonObject.getString("generatorRoot");
	}

	public String getGeneratorRoot(String defaultValue) { 
		return jsonObject.getString("generatorRoot", defaultValue);
	}

	public STAppModel setGeneratorPackage(String value) { 
		jsonObject.put("generatorPackage", value);
		return this;
	}

	public String getGeneratorPackage() { 
		return jsonObject.getString("generatorPackage");
	}

	public String getGeneratorPackage(String defaultValue) { 
		return jsonObject.getString("generatorPackage", defaultValue);
	}

	public STAppModel setGeneratorName(String value) { 
		jsonObject.put("generatorName", value);
		return this;
	}

	public String getGeneratorName() { 
		return jsonObject.getString("generatorName");
	}

	public String getGeneratorName(String defaultValue) { 
		return jsonObject.getString("generatorName", defaultValue);
	}

	public STAppModel addDirectories(STGDirectory value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("directories");
		if (jsonArray == null) jsonObject.put("directories", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STGDirectory> getDirectories() { 
		return jsonObject.getJsonArray("directories", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STGDirectory((io.vertx.core.json.JsonObject) o));
	}

	public STAppModel removeDirectories(STGDirectory value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("directories", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STAppModel clearDirectories() { 
		jsonObject.put("directories", new io.vertx.core.json.JsonArray());
		return this;
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}