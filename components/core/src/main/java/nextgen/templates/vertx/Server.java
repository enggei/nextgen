package nextgen.templates.vertx;

public class Server {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _startStatements = new java.util.ArrayList<>();

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
		for (Object o : _startStatements) st.add("startStatements", o);
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

	public Server addStartStatements(Object value) {
		this._startStatements.add(value);
		return this;
	}

	public Server setStartStatements(Object[] value) {
		this._startStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Server setStartStatements(java.util.Collection<Object> values) {
		this._startStatements.addAll(values);
		return this;
	}

	public Server removeStartStatements(Object value) {
		this._startStatements.remove(value);
		return this;
	}

	public Server removeStartStatements(int index) {
		this._startStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getStartStatements() {
		return this._startStatements;
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

	static final String st = "Server(packageName,imports,name,startStatements) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import io.vertx.core.DeploymentOptions;\n" + 
				"import io.vertx.core.Vertx;\n" + 
				"\n" + 
				"import java.io.IOException;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	protected static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	public ~name~(String configPath) throws IOException {\n" + 
				"		log.info(\"Starting server\");\n" + 
				"\n" + 
				"		final ServerDeploymentOptions serverDeployment = configPath == null\n" + 
				"				? new ServerDeploymentOptions(getClass().getResourceAsStream(\"/config.json\"))\n" + 
				"				: new ServerDeploymentOptions(new java.io.File(configPath));\n" + 
				"\n" + 
				"		final DeploymentOptions deploymentOptions = new DeploymentOptions().setConfig(serverDeployment.getJsonObject());\n" + 
				"		log.info(\"serverDeploymentOptions \" + serverDeployment.getJsonObject().encode());\n" + 
				"\n" + 
				"		final Vertx vertx = Vertx.vertx();\n" + 
				"\n" + 
				"		serverDeployment.getVerticles()\n" + 
				"				.forEach(verticleSettings -> {\n" + 
				"					log.info(\"deploying \" + verticleSettings.getName());\n" + 
				"					vertx.deployVerticle(verticleSettings.getClassName(), deploymentOptions, result -> {\n" + 
				"						if (result.failed())\n" + 
				"							log.error(\"deployment failed \" + result.cause().getMessage(), result.cause());\n" + 
				"						else\n" + 
				"							log.info(\"deployment success\");\n" + 
				"					});\n" + 
				"				});\n" + 
				"\n" + 
				"		~startStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void main(java.lang.String[] args) throws IOException {\n" + 
				"		new ~name~(args.length == 1 ? args[0] : null);\n" + 
				"	}\n" + 
				"} >>";
}  