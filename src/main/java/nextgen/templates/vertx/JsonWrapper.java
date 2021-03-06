package nextgen.templates.vertx;

public class JsonWrapper {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _neoNodeMapper;
	private Object _lexical;
	private String _name;
	private String _package;
	private java.util.List<EntityAccessor> _accessors = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _externalFields = new java.util.ArrayList<>();

	JsonWrapper(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JsonWrapper");
		st.add("neoNodeMapper", _neoNodeMapper);
		st.add("lexical", _lexical);
		st.add("name", _name);
		st.add("package", _package);
		for (Object o : _accessors) st.add("accessors", o);
		for (java.util.Map<String, Object> map : _externalFields) st.addAggr("externalFields.{initializer,name,type}", map.get("initializer"), map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public JsonWrapper setNeoNodeMapper(Object value) {
		this._neoNodeMapper = value;
		return this;
	}

	public Object getNeoNodeMapper() {
		return this._neoNodeMapper;
	}

	public Object getNeoNodeMapper(Object defaultValue) {
		return this._neoNodeMapper == null ? defaultValue : this._neoNodeMapper;
	}

	public boolean hasNeoNodeMapper() {
		return this._neoNodeMapper != null;
	}

	public JsonWrapper removeNeoNodeMapper() {
		this._neoNodeMapper = null;
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

	public JsonWrapper addAccessors(EntityAccessor value) {
		this._accessors.add(value);
		return this;
	}

	public JsonWrapper setAccessors(EntityAccessor[] value) {
		this._accessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JsonWrapper setAccessors(java.util.Collection<EntityAccessor> values) {
		this._accessors.addAll(values);
		return this;
	}

	public JsonWrapper removeAccessors(EntityAccessor value) {
		this._accessors.remove(value);
		return this;
	}

	public JsonWrapper removeAccessors(int index) {
		this._accessors.remove(index);
		return this;
	}

	public java.util.List<EntityAccessor> getAccessors() {
		return this._accessors;
	} 

	public JsonWrapper setExternalFields(java.util.Collection<JsonWrapper_ExternalFields> values) {
			this._externalFields.clear();
			values.stream().map(JsonWrapper_ExternalFields::asMap).forEach(map -> _externalFields.add(map));
			return this;
		}

	public JsonWrapper addExternalFields(Object _initializer, String _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("initializer", _initializer);
		map.put("name", _name);
		map.put("type", _type);
		this._externalFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getExternalFields() {
		return this._externalFields;
	}

	public JsonWrapper addExternalFields(JsonWrapper_ExternalFields value) {
		return addExternalFields(value._initializer, value._name, value._type);
	}

	public java.util.stream.Stream<JsonWrapper_ExternalFields> streamExternalFields() {
		return this._externalFields.stream().map(JsonWrapper_ExternalFields::new);
	}

	public java.util.List<Object> getExternalFields_Initializer() {
		return streamExternalFields().map(JsonWrapper_ExternalFields::getInitializer).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getExternalFields_Name() {
		return streamExternalFields().map(JsonWrapper_ExternalFields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getExternalFields_Type() {
		return streamExternalFields().map(JsonWrapper_ExternalFields::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class JsonWrapper_ExternalFields {

		Object _initializer;
		String _name;
		Object _type;

		public JsonWrapper_ExternalFields(Object _initializer, String _name, Object _type) {
			this._initializer = _initializer;
			this._name = _name;
			this._type = _type;
		}

		private JsonWrapper_ExternalFields(java.util.Map<String, Object> map) {
			this._initializer = (Object) map.get("initializer");
			this._name = (String) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getInitializer() {
			return this._initializer;
		}

		public String getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("initializer", _initializer);
			map.put("name", _name);
			map.put("type", _type);
			return map;
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

	static final String st = "JsonWrapper(accessors,neoNodeMapper,lexical,externalFields,name,package) ::= <<package ~package~;\n" + 
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
				"	public ~name;format=\"capitalize\"~(java.io.File file) throws java.io.IOException {\n" + 
				"		this(new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(java.nio.file.Files.readAllBytes(file.toPath()))));\n" + 
				"	}\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(java.io.InputStream inputStream) throws java.io.IOException {\n" + 
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
				"		this.jsonObject = new io.vertx.core.json.JsonObject(io.vertx.core.buffer.Buffer.buffer(content));\n" + 
				"		java.lang.String uuidString = jsonObject.getString(\"uuid\");\n" + 
				"		if (uuidString == null) jsonObject.put(\"uuid\", java.util.UUID.randomUUID().toString());\n" + 
				"	}\n" + 
				"\n" + 
				"	public io.vertx.core.json.JsonObject getJsonObject() { \n" + 
				"		return this.jsonObject;\n" + 
				"	}\n" + 
				"\n" + 
				"	@Deprecated\n" + 
				"	public String uuid() {\n" + 
				"		return this.jsonObject.getString(\"uuid\");\n" + 
				"	}\n" + 
				"\n" + 
				"	public String getUuid() {\n" + 
				"		return this.jsonObject.getString(\"uuid\");\n" + 
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
				"	~neoNodeMapper~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public java.lang.String toString() { \n" + 
				"		return ~if(lexical)~jsonObject.getString(\"~lexical~\")~else~jsonObject.encode()~endif~;\n" + 
				"	}\n" + 
				"} >>";
}  