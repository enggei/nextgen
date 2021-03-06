package nextgen.templates.vertx;

public class Server {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();

	Server(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Server");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (Object o : _imports) st.add("imports", o);
		return st.render().trim();
	}

	public Server setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public Server removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Server setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Server removeName() {
		this._name = null;
		return this;
	} 

	public Server addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public Server setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Server setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public Server removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public Server removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Server that = (Server) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Server(packageName,imports,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	protected static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	public ~name~(String configPath) throws java.io.IOException {\n" + 
				"		log.info(\"Starting server\");\n" + 
				"\n" + 
				"		final io.vertx.core.json.JsonObject serverDeployment = configPath == null\n" + 
				"				? new io.vertx.core.json.JsonObject(read(getClass().getResourceAsStream(\"/config.json\")))\n" + 
				"				: new io.vertx.core.json.JsonObject(read(new java.io.FileInputStream(configPath)));\n" + 
				"\n" + 
				"		final io.vertx.core.DeploymentOptions deploymentOptions = new io.vertx.core.DeploymentOptions().setConfig(serverDeployment);\n" + 
				"		log.info(\"serverDeploymentOptions \" + serverDeployment.encode());\n" + 
				"\n" + 
				"		final io.vertx.core.Vertx vertx = io.vertx.core.Vertx.vertx();\n" + 
				"\n" + 
				"\n" + 
				"		serverDeployment.getJsonArray(\"verticles\")\n" + 
				"				.stream()\n" + 
				"				.map(o -> (io.vertx.core.json.JsonObject)o)\n" + 
				"				.forEach(verticleSettings -> {\n" + 
				"					log.info(\"verticle settings \" + verticleSettings.encodePrettily());\n" + 
				"					vertx.deployVerticle(verticleSettings.getString(\"className\"), deploymentOptions, result -> {\n" + 
				"						if (result.failed())\n" + 
				"							log.error(\"deployment failed \" + result.cause().getMessage(), result.cause());\n" + 
				"						else\n" + 
				"							log.info(\"deployment success\");\n" + 
				"					});\n" + 
				"				});\n" + 
				"	}\n" + 
				"\n" + 
				"	public static io.vertx.core.buffer.Buffer read(java.io.InputStream inputStream) throws java.io.IOException {\n" + 
				"		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();\n" + 
				"		int read;\n" + 
				"		byte[] data = new byte[2048];\n" + 
				"		while ((read = inputStream.read(data, 0, data.length)) != -1)\n" + 
				"			buffer.write(data, 0, read);\n" + 
				"		inputStream.close();\n" + 
				"		final byte[] content = buffer.toByteArray();\n" + 
				"		buffer.close();\n" + 
				"		return io.vertx.core.buffer.Buffer.buffer(content);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void main(java.lang.String[] args) throws java.io.IOException {\n" + 
				"		System.setProperty(\"io.netty.tryReflectionSetAccessible\", \"true\");\n" + 
				"		new ~name~(args.length == 1 ? args[0] : null);\n" + 
				"	}\n" + 
				"} >>";
}  