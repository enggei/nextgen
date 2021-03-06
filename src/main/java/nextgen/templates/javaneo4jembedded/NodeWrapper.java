package nextgen.templates.javaneo4jembedded;

public class NodeWrapper {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _package;
	private String _name;
	private Object _useUuid;
	private java.util.List<Accessor> _accessors = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _externalFields = new java.util.ArrayList<>();

	NodeWrapper(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NodeWrapper");
		st.add("package", _package);
		st.add("name", _name);
		st.add("useUuid", _useUuid);
		for (Object o : _accessors) st.add("accessors", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _externalFields) st.addAggr("externalFields.{name,initializer,type}", map.get("name"), map.get("initializer"), map.get("type"));
		return st.render().trim();
	}

	public NodeWrapper setPackage(Object value) {
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

	public NodeWrapper removePackage() {
		this._package = null;
		return this;
	} 

	public NodeWrapper setName(String value) {
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

	public NodeWrapper removeName() {
		this._name = null;
		return this;
	} 

	public NodeWrapper setUseUuid(Object value) {
		this._useUuid = value;
		return this;
	}

	public Object getUseUuid() {
		return this._useUuid;
	}

	public Object getUseUuid(Object defaultValue) {
		return this._useUuid == null ? defaultValue : this._useUuid;
	}

	public boolean hasUseUuid() {
		return this._useUuid != null;
	}

	public NodeWrapper removeUseUuid() {
		this._useUuid = null;
		return this;
	} 

	public NodeWrapper addAccessors(Accessor value) {
		this._accessors.add(value);
		return this;
	}

	public NodeWrapper setAccessors(Accessor[] value) {
		this._accessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NodeWrapper setAccessors(java.util.Collection<Accessor> values) {
		this._accessors.addAll(values);
		return this;
	}

	public NodeWrapper removeAccessors(Accessor value) {
		this._accessors.remove(value);
		return this;
	}

	public NodeWrapper removeAccessors(int index) {
		this._accessors.remove(index);
		return this;
	}

	public java.util.List<Accessor> getAccessors() {
		return this._accessors;
	} 

	public NodeWrapper addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public NodeWrapper setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NodeWrapper setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public NodeWrapper removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public NodeWrapper removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public NodeWrapper setExternalFields(java.util.Collection<NodeWrapper_ExternalFields> values) {
			this._externalFields.clear();
			values.stream().map(NodeWrapper_ExternalFields::asMap).forEach(map -> _externalFields.add(map));
			return this;
		}

	public NodeWrapper addExternalFields(Object _name, Object _initializer, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("initializer", _initializer);
		map.put("type", _type);
		this._externalFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getExternalFields() {
		return this._externalFields;
	}

	public NodeWrapper addExternalFields(NodeWrapper_ExternalFields value) {
		return addExternalFields(value._name, value._initializer, value._type);
	}

	public java.util.stream.Stream<NodeWrapper_ExternalFields> streamExternalFields() {
		return this._externalFields.stream().map(NodeWrapper_ExternalFields::new);
	}

	public java.util.List<Object> getExternalFields_Name() {
		return streamExternalFields().map(NodeWrapper_ExternalFields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getExternalFields_Initializer() {
		return streamExternalFields().map(NodeWrapper_ExternalFields::getInitializer).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getExternalFields_Type() {
		return streamExternalFields().map(NodeWrapper_ExternalFields::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class NodeWrapper_ExternalFields {

		Object _name;
		Object _initializer;
		Object _type;

		public NodeWrapper_ExternalFields(Object _name, Object _initializer, Object _type) {
			this._name = _name;
			this._initializer = _initializer;
			this._type = _type;
		}

		private NodeWrapper_ExternalFields(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._initializer = (Object) map.get("initializer");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getInitializer() {
			return this._initializer;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			map.put("initializer", _initializer);
			map.put("type", _type);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NodeWrapper that = (NodeWrapper) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NodeWrapper(package,name,externalFields,accessors,useUuid,methods) ::= <<package ~package~;\n" + 
				"\n" + 
				"~comments:{it|// ~it~};separator=\"\\n\"~\n" + 
				"public class ~name;format=\"capitalize\"~ {\n" + 
				"	\n" + 
				"	private final org.neo4j.graphdb.Node node;\n" + 
				"	~if(useUuid)~private final String uuid;~endif~\n" + 
				"	~externalFields:{it|private ~it.type~ _~it.name~~if(it.initializer)~ = ~it.initializer~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(org.neo4j.graphdb.Node node) { \n" + 
				"		this.node = node;\n" + 
				"		~if(useUuid)~if (!node.hasProperty(\"uuid\")) this.node.setProperty(\"uuid\", this.uuid = java.util.UUID.randomUUID().toString());\n" + 
				"else this.uuid = node.getProperty(\"uuid\").toString();~endif~\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.neo4j.graphdb.Node getNode() { \n" + 
				"		return this.node;\n" + 
				"	}\n" + 
				"\n" + 
				"~if(useUuid)~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public boolean equals(java.lang.Object o) { \n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"		final ~name~ other = (~name~) o;\n" + 
				"		return uuid.equals(other.uuid);\n" + 
				"	}\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public int hashCode() { \n" + 
				"		return uuid.hashCode();\n" + 
				"	}\n" + 
				"	\n" + 
				"	private static final String _uuid = \"uuid\";\n" + 
				"	\n" + 
				"	public ~name;format=\"capitalize\"~ setUuid(String value) { \n" + 
				"		if (value == null) {\n" + 
				"			removeUuid(); \n" + 
				"		} else {\n" + 
				"			node.setProperty(_uuid, value);\n" + 
				"		}\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public String getUuid() { \n" + 
				"		if (node.hasProperty(_uuid)) return (String) node.getProperty(_uuid);\n" + 
				"		return null;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public String getUuid(String defaultValue) { \n" + 
				"		if (node.hasProperty(_uuid)) return (String) node.getProperty(_uuid);\n" + 
				"		return defaultValue;\n" + 
				"	}\n" + 
				"	\n" + 
				"	public boolean hasUuid() { \n" + 
				"		return node.hasProperty(_uuid);\n" + 
				"	}\n" + 
				"	\n" + 
				"	public ~name;format=\"capitalize\"~ removeUuid() { \n" + 
				"		node.removeProperty(_uuid);\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"~else~\n" + 
				"	@Override\n" + 
				"	public boolean equals(java.lang.Object o) { \n" + 
				"		if (this == o) return true;\n" + 
				"		if (o == null || getClass() != o.getClass()) return false;\n" + 
				"		final ~name;format=\"capitalize\"~ other = (~name;format=\"capitalize\"~) o;\n" + 
				"		return node.equals(other.node);\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public int hashCode() { \n" + 
				"		return java.util.Objects.hash(node);\n" + 
				"	}\n" + 
				"~endif~\n" + 
				"\n" + 
				"	~accessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		final StringBuilder out = new StringBuilder();\n" + 
				"		out.append(\"Node : \").append(node.getId()).append(\" \");\n" + 
				"		node.getLabels().forEach(label -> out.append(label.name()).append(\" \"));\n" + 
				"		out.append(\"(\");\n" + 
				"		node.getPropertyKeys().forEach(s -> out.append(\" \").append(s).append(\":\").append(node.getProperty(s)));\n" + 
				"		out.append(\")\");\n" + 
				"		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(relationship -> {\n" + 
				"			out.append(\"\\n\\t -> \").append(relationship.getType()).append(\" (\");\n" + 
				"			relationship.getPropertyKeys().forEach(s -> out.append(\" \").append(s).append(\":\").append(relationship.getProperty(s)));\n" + 
				"			out.append(\")\");\n" + 
				"		});\n" + 
				"		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship -> {\n" + 
				"			out.append(\"\\n\\t <- \").append(relationship.getType()).append(\" (\");\n" + 
				"			relationship.getPropertyKeys().forEach(s -> out.append(\" \").append(s).append(\":\").append(relationship.getProperty(s)));\n" + 
				"			out.append(\")\");\n" + 
				"		});\n" + 
				"		return out.toString().trim();\n" + 
				"	}\n" + 
				"\n" + 
				"	public void delete() {\n" + 
				"		node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(org.neo4j.graphdb.Relationship::delete);\n" + 
				"		node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(org.neo4j.graphdb.Relationship::delete);\n" + 
				"		node.delete();	\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"} >>";
}  