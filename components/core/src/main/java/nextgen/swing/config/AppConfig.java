package nextgen.swing.config;

public class AppConfig {

	private final io.vertx.core.json.JsonObject jsonObject;

	public AppConfig() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public AppConfig(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public AppConfig(java.io.File file) throws java.io.IOException {
		this(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));
	}

	public AppConfig(java.io.InputStream inputStream) throws java.io.IOException {
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

	public AppConfig removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final AppConfig other = (AppConfig) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public AppConfig setNavigatorWidth(Integer value) { 
		jsonObject.put("navigatorWidth", value);
		return this;
	}

	public Integer getNavigatorWidth() { 
		return jsonObject.getInteger("navigatorWidth");
	}

	public Integer getNavigatorWidth(Integer defaultValue) { 
		return jsonObject.getInteger("navigatorWidth", defaultValue);
	}

	public AppConfig setAppHeight(Integer value) { 
		jsonObject.put("appHeight", value);
		return this;
	}

	public Integer getAppHeight() { 
		return jsonObject.getInteger("appHeight");
	}

	public Integer getAppHeight(Integer defaultValue) { 
		return jsonObject.getInteger("appHeight", defaultValue);
	}

	public AppConfig setAppWidth(Integer value) { 
		jsonObject.put("appWidth", value);
		return this;
	}

	public Integer getAppWidth() { 
		return jsonObject.getInteger("appWidth");
	}

	public Integer getAppWidth(Integer defaultValue) { 
		return jsonObject.getInteger("appWidth", defaultValue);
	}

	public AppConfig setNavigatorHeight(Integer value) { 
		jsonObject.put("navigatorHeight", value);
		return this;
	}

	public Integer getNavigatorHeight() { 
		return jsonObject.getInteger("navigatorHeight");
	}

	public Integer getNavigatorHeight(Integer defaultValue) { 
		return jsonObject.getInteger("navigatorHeight", defaultValue);
	}

	public AppConfig setWorkspaceWidth(Integer value) { 
		jsonObject.put("workspaceWidth", value);
		return this;
	}

	public Integer getWorkspaceWidth() { 
		return jsonObject.getInteger("workspaceWidth");
	}

	public Integer getWorkspaceWidth(Integer defaultValue) { 
		return jsonObject.getInteger("workspaceWidth", defaultValue);
	}

	public AppConfig setWorkspaceHeight(Integer value) { 
		jsonObject.put("workspaceHeight", value);
		return this;
	}

	public Integer getWorkspaceHeight() { 
		return jsonObject.getInteger("workspaceHeight");
	}

	public Integer getWorkspaceHeight(Integer defaultValue) { 
		return jsonObject.getInteger("workspaceHeight", defaultValue);
	}

	public AppConfig setEditorHeight(Integer value) { 
		jsonObject.put("editorHeight", value);
		return this;
	}

	public Integer getEditorHeight() { 
		return jsonObject.getInteger("editorHeight");
	}

	public Integer getEditorHeight(Integer defaultValue) { 
		return jsonObject.getInteger("editorHeight", defaultValue);
	}

	public AppConfig setEditorWidth(Integer value) { 
		jsonObject.put("editorWidth", value);
		return this;
	}

	public Integer getEditorWidth() { 
		return jsonObject.getInteger("editorWidth");
	}

	public Integer getEditorWidth(Integer defaultValue) { 
		return jsonObject.getInteger("editorWidth", defaultValue);
	}

	public AppConfig setRootDir(String value) { 
		jsonObject.put("rootDir", value);
		return this;
	}

	public String getRootDir() { 
		return jsonObject.getString("rootDir");
	}

	public String getRootDir(String defaultValue) { 
		return jsonObject.getString("rootDir", defaultValue);
	}

	public AppConfig setDbDir(String value) { 
		jsonObject.put("dbDir", value);
		return this;
	}

	public String getDbDir() { 
		return jsonObject.getString("dbDir");
	}

	public String getDbDir(String defaultValue) { 
		return jsonObject.getString("dbDir", defaultValue);
	}

	public AppConfig setOutputPackage(String value) { 
		jsonObject.put("outputPackage", value);
		return this;
	}

	public String getOutputPackage() { 
		return jsonObject.getString("outputPackage");
	}

	public String getOutputPackage(String defaultValue) { 
		return jsonObject.getString("outputPackage", defaultValue);
	}

	public AppConfig setOutputPath(String value) { 
		jsonObject.put("outputPath", value);
		return this;
	}

	public String getOutputPath() { 
		return jsonObject.getString("outputPath");
	}

	public String getOutputPath(String defaultValue) { 
		return jsonObject.getString("outputPath", defaultValue);
	}

	public AppConfig setTemplateDir(String value) { 
		jsonObject.put("templateDir", value);
		return this;
	}

	public String getTemplateDir() { 
		return jsonObject.getString("templateDir");
	}

	public String getTemplateDir(String defaultValue) { 
		return jsonObject.getString("templateDir", defaultValue);
	}

	public AppConfig setFontName(String value) { 
		jsonObject.put("fontName", value);
		return this;
	}

	public String getFontName() { 
		return jsonObject.getString("fontName");
	}

	public String getFontName(String defaultValue) { 
		return jsonObject.getString("fontName", defaultValue);
	}

	public AppConfig setFontSize(Integer value) { 
		jsonObject.put("fontSize", value);
		return this;
	}

	public Integer getFontSize() { 
		return jsonObject.getInteger("fontSize");
	}

	public Integer getFontSize(Integer defaultValue) { 
		return jsonObject.getInteger("fontSize", defaultValue);
	}

	public AppConfig setTitle(String value) { 
		jsonObject.put("title", value);
		return this;
	}

	public String getTitle() { 
		return jsonObject.getString("title");
	}

	public String getTitle(String defaultValue) { 
		return jsonObject.getString("title", defaultValue);
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}