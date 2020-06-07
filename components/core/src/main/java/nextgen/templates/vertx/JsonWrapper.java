package nextgen.templates.vertx;

public class JsonWrapper {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _package;
	private Object _name;
	private java.util.List<Object> _accessors = new java.util.ArrayList<>();

	JsonWrapper(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JsonWrapper that = (JsonWrapper) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JsonWrapper");
		st.add("package" ,_package);
		st.add("name" ,_name);
		for (Object o : _accessors) st.add("accessors", o);
		return st.render().trim();
	}

	public JsonWrapper setPackage(Object value) {
		this._package = value;
		return this;
	}

	public Object getPackage() {
		return this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public JsonWrapper removePackage() {
		this._package = null;
		return this;
	} 

	public JsonWrapper setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public JsonWrapper removeName() {
		this._name = null;
		return this;
	} 
	public JsonWrapper addAccessors(Object value) {
		this._accessors.add(value);
		return this;
	}

	public JsonWrapper removeAccessors(Object value) {
		this._accessors.remove(value);
		return this;
	}

	public JsonWrapper removeAccessors(int index) {
		this._accessors.remove(index);
		return this;
	}

	public java.util.List<Object> getAccessors() {
		return this._accessors;
	} 

	static final String st = "JsonWrapper(package,name,accessors) ::= <<~package~\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	private final io.vertx.core.json.JsonObject jsonObject;\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~() { \n" + 
				"		this.jsonObject = new io.vertx.core.json.JsonObject();\n" + 
				"		jsonObject.put(\"uuid\", java.util.UUID.randomUUID().toString());\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(io.vertx.core.json.JsonObject jsonObject) { \n" + 
				"		this.jsonObject = jsonObject;\n" + 
				"		java.lang.String uuidString = jsonObject.getString(\"uuid\");\n" + 
				"		if (uuidString == null) jsonObject.put(\"uuid\", java.util.UUID.randomUUID().toString());\n" + 
				"	}\n" + 
				"\n" + 
				"	public io.vertx.core.json.JsonObject getJsonObject() { \n" + 
				"		return this.jsonObject;\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(java.lang.Object o) { \n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"		final ~name;format=\"capitalize\"~ other = (~name;format=\"capitalize\"~) o;\n" + 
				"		return jsonObject.getString(\"uuid\").equals(other.getJsonObject().getString(\"uuid\"));\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int hashCode() { \n" + 
				"		return java.util.Objects.hash(jsonObject.getString(\"uuid\"));\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public java.lang.String toString() { \n" + 
				"		return jsonObject.encode();\n" + 
				"	}\n" + 
				"	\n" + 
				"	~accessors:{it|~it~};separator=\"\\n\\n\"~	\n" + 
				"}>> ";
} 