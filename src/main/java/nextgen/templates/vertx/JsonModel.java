package nextgen.templates.vertx;

public class JsonModel {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _package;
	private String _name;
	private java.util.List<Object> _accessors = new java.util.ArrayList<>();

	JsonModel(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JsonModel");
		st.add("package", _package);
		st.add("name", _name);
		for (Object o : _accessors) st.add("accessors", o);
		return st.render().trim();
	}

	public JsonModel setPackage(Object value) {
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

	public JsonModel removePackage() {
		this._package = null;
		return this;
	} 

	public JsonModel setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public JsonModel removeName() {
		this._name = null;
		return this;
	} 

	public JsonModel addAccessors(Object value) {
		this._accessors.add(value);
		return this;
	}

	public JsonModel setAccessors(Object[] value) {
		this._accessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JsonModel setAccessors(java.util.Collection<Object> values) {
		this._accessors.addAll(values);
		return this;
	}

	public JsonModel removeAccessors(Object value) {
		this._accessors.remove(value);
		return this;
	}

	public JsonModel removeAccessors(int index) {
		this._accessors.remove(index);
		return this;
	}

	public java.util.List<Object> getAccessors() {
		return this._accessors;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JsonModel that = (JsonModel) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JsonModel(accessors,package,name) ::= <<package ~package~;\n" + 
				"\n" + 
				"import io.vertx.core.buffer.*;\n" + 
				"import io.vertx.core.json.*;\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ extends JsonObject {\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~() { \n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(Buffer buffer) {\n" + 
				"		super(buffer);\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(JsonObject jsonObject) {\n" + 
				"		super(jsonObject.getMap());\n" + 
				"	}\n" + 
				"	\n" + 
				"	~accessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	static JsonArray getJsonArray(JsonObject item, String key) {\n" + 
				"		return item.getJsonArray(key, new JsonArray());\n" + 
				"	}\n" + 
				"\n" + 
				"	static JsonArray getOrCreateJsonArray(JsonObject item, String key) {\n" + 
				"      final JsonArray jsonArray = item.getJsonArray(key);\n" + 
				"      if (jsonArray != null) return jsonArray;\n" + 
				"      item.put(key, new JsonArray());\n" + 
				"      return getJsonArray(item, key);\n" + 
				"   }\n" + 
				"   \n" + 
				"	static java.util.stream.Stream<JsonObject> stream(JsonObject js, String key) {\n" + 
				"		return getJsonArray(js, key).stream().map(o -> (JsonObject) o);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static ~name;format=\"capitalize\"~ read(java.io.InputStream inputStream) throws java.io.IOException {\n" + 
				"		if (inputStream == null) throw new java.io.IOException(\"inputStream is null\");\n" + 
				"		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();\n" + 
				"		int read;\n" + 
				"		byte[] data = new byte[2048];\n" + 
				"		while ((read = inputStream.read(data, 0, data.length)) != -1)\n" + 
				"			buffer.write(data, 0, read);\n" + 
				"		inputStream.close();\n" + 
				"		final byte[] content = buffer.toByteArray();\n" + 
				"		buffer.close();\n" + 
				"\n" + 
				"		return new ~name;format=\"capitalize\"~(Buffer.buffer(content));		\n" + 
				"	}\n" + 
				"} >>";
}  