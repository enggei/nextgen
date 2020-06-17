package nextgen.templates.neo4j;

public class NodeToJsonObject {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _refs = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _refList = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _primitiveList = new java.util.ArrayList<>();

	NodeToJsonObject(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("nodeToJsonObject");
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{name}", map.get("name"));
		for (java.util.Map<String, Object> map : _refs) st.addAggr("refs.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _refList) st.addAggr("refList.{name}", map.get("name"));
		for (java.util.Map<String, Object> map : _primitiveList) st.addAggr("primitiveList.{name}", map.get("name"));
		return st.render().trim();
	}



	public NodeToJsonObject addProperties(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public NodeToJsonObject addProperties(NodeToJsonObject_Properties value) {
		return addProperties(value._name);
	}

	public java.util.stream.Stream<NodeToJsonObject_Properties> streamProperties() {
		return this._properties.stream().map(NodeToJsonObject_Properties::new);
	}

	public static final class NodeToJsonObject_Properties {

		Object _name;

		public NodeToJsonObject_Properties(Object _name) {
			this._name = _name;
		}

		private NodeToJsonObject_Properties(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	} 

	public NodeToJsonObject addRefs(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._refs.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRefs() {
		return this._refs;
	}

	public NodeToJsonObject addRefs(NodeToJsonObject_Refs value) {
		return addRefs(value._type, value._name);
	}

	public java.util.stream.Stream<NodeToJsonObject_Refs> streamRefs() {
		return this._refs.stream().map(NodeToJsonObject_Refs::new);
	}

	public static final class NodeToJsonObject_Refs {

		Object _type;
		Object _name;

		public NodeToJsonObject_Refs(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private NodeToJsonObject_Refs(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

	} 

	public NodeToJsonObject addRefList(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._refList.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRefList() {
		return this._refList;
	}

	public NodeToJsonObject addRefList(NodeToJsonObject_RefList value) {
		return addRefList(value._name);
	}

	public java.util.stream.Stream<NodeToJsonObject_RefList> streamRefList() {
		return this._refList.stream().map(NodeToJsonObject_RefList::new);
	}

	public static final class NodeToJsonObject_RefList {

		Object _name;

		public NodeToJsonObject_RefList(Object _name) {
			this._name = _name;
		}

		private NodeToJsonObject_RefList(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	} 

	public NodeToJsonObject addPrimitiveList(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._primitiveList.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getPrimitiveList() {
		return this._primitiveList;
	}

	public NodeToJsonObject addPrimitiveList(NodeToJsonObject_PrimitiveList value) {
		return addPrimitiveList(value._name);
	}

	public java.util.stream.Stream<NodeToJsonObject_PrimitiveList> streamPrimitiveList() {
		return this._primitiveList.stream().map(NodeToJsonObject_PrimitiveList::new);
	}

	public static final class NodeToJsonObject_PrimitiveList {

		Object _name;

		public NodeToJsonObject_PrimitiveList(Object _name) {
			this._name = _name;
		}

		private NodeToJsonObject_PrimitiveList(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NodeToJsonObject that = (NodeToJsonObject) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "nodeToJsonObject(properties,refs,refList,primitiveList) ::= <<public io.vertx.core.json.JsonObject toJsonObject() {\n" + 
				"	io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();\n" + 
				"	if (node.hasProperty(\"uuid\")) jsonObject.put(\"uuid\", node.getProperty(\"uuid\"));\n" + 
				"	~properties:{it|if (node.hasProperty(\"~it.name~\")) jsonObject.put(\"~it.name~\", node.getProperty(\"~it.name~\"));};separator=\"\\n\"~\n" + 
				"~refs:{it|\n" + 
				"	final ~it.type~ _~it.name~ = get~it.name;format=\"capitalize\"~();\n" + 
				"	if (_~it.name~ != null) jsonObject.put(\"~it.name~\", _~it.name~.toJsonObject());\n" + 
				"};separator=\"\\n\"~\n" + 
				"~refList:{it|\n" + 
				"	final io.vertx.core.json.JsonArray _~it.name~ = new io.vertx.core.json.JsonArray();\n" + 
				"	get~it.name;format=\"capitalize\"~().forEach(element -> _~it.name~.add(element.toJsonObject()));\n" + 
				"	if (!_~it.name~.isEmpty()) jsonObject.put(\"~it.name~\", _~it.name~);\n" + 
				"};separator=\"\\n\"~\n" + 
				"~primitiveList:{it|\n" + 
				"	final io.vertx.core.json.JsonArray _~it.name~ = new io.vertx.core.json.JsonArray();\n" + 
				"	get~it.name;format=\"capitalize\"~().forEach(_~it.name~::add);\n" + 
				"	if (!_~it.name~.isEmpty()) jsonObject.put(\"~it.name~\", _~it.name~);\n" + 
				"};separator=\"\\n\"~\n" + 
				"	return jsonObject;\n" + 
				"} >>";
} 