package nextgen.templates.vertx;

public class NodeToJsonMapper {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	NodeToJsonMapper(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NodeToJsonMapper");
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{name}", map.get("name"));
		return st.render().trim();
	}



	public NodeToJsonMapper addProperties(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public NodeToJsonMapper addProperties(NodeToJsonMapper_Properties value) {
		return addProperties(value._name);
	}

	public java.util.stream.Stream<NodeToJsonMapper_Properties> streamProperties() {
		return this._properties.stream().map(NodeToJsonMapper_Properties::new);
	}

	public static final class NodeToJsonMapper_Properties {

		Object _name;

		public NodeToJsonMapper_Properties(Object _name) {
			this._name = _name;
		}

		private NodeToJsonMapper_Properties(java.util.Map<String, Object> map) {
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
		NodeToJsonMapper that = (NodeToJsonMapper) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NodeToJsonMapper(properties) ::= <<public static io.vertx.core.json.JsonObject map(org.neo4j.graphdb.Node node) {\n" + 
				"	io.vertx.core.json.JsonObject jsonObject = new io.vertx.core.json.JsonObject();\n" + 
				"	~properties:{it|if(node.hasProperty(\"~it.name~\")) jsonObject.put(\"~it.name~\", node.getProperty(\"~it.name~\"));};separator=\"\\n\"~\n" + 
				"	return jsonObject;\n" + 
				"} >>";
} 