package nextgen.templates.vertx;

public class JsonWrapper {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _package;
	private String _name;
	private Object _lexical;
	private java.util.List<Object> _accessors = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _externalFields = new java.util.ArrayList<>();

	JsonWrapper(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JsonWrapper");
		st.add("package", _package);
		st.add("name", _name);
		st.add("lexical", _lexical);
		for (Object o : _accessors) st.add("accessors", o);
		for (java.util.Map<String, Object> map : _externalFields) st.addAggr("externalFields.{type,name,initializer}", map.get("type"), map.get("name"), map.get("initializer"));
		return st.render().trim();
	}

	public JsonWrapper setPackage(String value) {
		this._package = value;
		return this;
	}

	public String getPackage() {
		return this._package;
	}

	public String getPackage(String defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public JsonWrapper removePackage() {
		this._package = null;
		return this;
	} 

	public JsonWrapper setName(String value) {
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

	public JsonWrapper removeName() {
		this._name = null;
		return this;
	} 

	public JsonWrapper setLexical(Object value) {
		this._lexical = value;
		return this;
	}

	public Object getLexical() {
		return this._lexical;
	}

	public Object getLexical(Object defaultValue) {
		return this._lexical == null ? defaultValue : this._lexical;
	}

	public boolean hasLexical() {
		return this._lexical != null;
	}

	public JsonWrapper removeLexical() {
		this._lexical = null;
		return this;
	} 

	public JsonWrapper addAccessors(Object value) {
		this._accessors.add(value);
		return this;
	}

	public JsonWrapper setAccessors(Object[] value) {
		this._accessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JsonWrapper setAccessors(java.util.Collection<Object> values) {
		this._accessors.addAll(values);
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

	public JsonWrapper addExternalFields(Object _type, String _name, Object _initializer) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		map.put("initializer", _initializer);
		this._externalFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getExternalFields() {
		return this._externalFields;
	}

	public JsonWrapper addExternalFields(JsonWrapper_ExternalFields value) {
		return addExternalFields(value._type, value._name, value._initializer);
	}

	public java.util.stream.Stream<JsonWrapper_ExternalFields> streamExternalFields() {
		return this._externalFields.stream().map(JsonWrapper_ExternalFields::new);
	}

	public static final class JsonWrapper_ExternalFields {

		Object _type;
		String _name;
		Object _initializer;

		public JsonWrapper_ExternalFields(Object _type, String _name, Object _initializer) {
			this._type = _type;
			this._name = _name;
			this._initializer = _initializer;
		}

		private JsonWrapper_ExternalFields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (String) map.get("name");
			this._initializer = (Object) map.get("initializer");
		}

		public Object getType() {
			return this._type;
		}

		public String getName() {
			return this._name;
		}

		public Object getInitializer() {
			return this._initializer;
		}

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

	static final String st = "JsonWrapper(package,name,externalFields,accessors,lexical) ::= <<package ~package~;\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	private final io.vertx.core.json.JsonObject jsonObject;\n" + 
				"	~externalFields:{it|private ~it.type~ _~it.name~~if(it.initializer)~ = ~it.initializer~~endif~;};separator=\"\\n\"~\n" + 
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
				"	public ~name;format=\"capitalize\"~ removeUuid() {\n" + 
				"		this.jsonObject.remove(\"uuid\");\n" + 
				"		return this;\n" + 
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
				"	~accessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public java.lang.String toString() { \n" + 
				"		return ~if(lexical)~jsonObject.getString(\"~lexical~\")~else~jsonObject.encode()~endif~;\n" + 
				"	}\n" + 
				"} >>";
} 