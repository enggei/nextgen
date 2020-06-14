package nextgen.templates.vertx;

public class JsonFactory {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _package;
	private Object _name;
	private java.util.List<Object> _entities = new java.util.ArrayList<>();

	JsonFactory(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JsonFactory");
		st.add("package", _package);
		st.add("name", _name);
		for (Object o : _entities) st.add("entities", o);
		return st.render().trim();
	}

	public JsonFactory setPackage(Object value) {
		this._package = value;
		return this;
	}

	public Object getPackage() {
		return this._package;
	}

	public Object getPackage(Object defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public JsonFactory removePackage() {
		this._package = null;
		return this;
	}

	public JsonFactory setName(Object value) {
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

	public JsonFactory removeName() {
		this._name = null;
		return this;
	}

	public JsonFactory addEntities(Object value) {
		this._entities.add(value);
		return this;
	}

	public JsonFactory setEntities(Object[] value) {
		this._entities.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JsonFactory setEntities(java.util.Collection<Object> values) {
		this._entities.addAll(values);
		return this;
	}

	public JsonFactory removeEntities(Object value) {
		this._entities.remove(value);
		return this;
	}

	public JsonFactory removeEntities(int index) {
		this._entities.remove(index);
		return this;
	}

	public java.util.List<Object> getEntities() {
		return this._entities;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JsonFactory that = (JsonFactory) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JsonFactory(package,name,entities) ::= <<package ~package~;\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	public static void save(io.vertx.core.json.JsonObject jsonObject, java.io.File file) throws java.io.IOException {\n" + 
				"\n" + 
				"		if (!file.getParentFile().exists() && !file.getParentFile().mkdirs())\n" + 
				"			throw new IllegalStateException(\"could not create \" + file.getParentFile().getAbsolutePath());\n" + 
				"\n" + 
				"		if (!file.exists() && !file.createNewFile())\n" + 
				"			throw new IllegalStateException(\"could not create \" + file.getAbsolutePath());\n" + 
				"\n" + 
				"		java.nio.file.Files.write(file.toPath(), jsonObject.toBuffer().getBytes());\n" + 
				"	}\n" + 
				"	\n" + 
				"~entities:{it|\n" + 
				"	public static ~it~ new~it~() { \n" + 
				"		return new ~it~();\n" + 
				"	\\}\n" + 
				"	\n" + 
				"	public static ~it~ new~it~NoUuid() { \n" + 
				"		return new ~it~().removeUuid();\n" + 
				"	\\}\n" + 
				"	\n" + 
				"	public static ~it~ new~it~(io.vertx.core.json.JsonObject jsonObject) { \n" + 
				"		return new ~it~(jsonObject);\n" + 
				"	\\}\n" + 
				"\n" + 
				"	public static ~it~ new~it~(java.io.File file) throws java.io.IOException { \n" + 
				"		return new ~it~(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));\n" + 
				"	\\}\n" + 
				"};separator=\"\\n\"~\n" + 
				"}>>";
}