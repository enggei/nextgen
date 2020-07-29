package nextgen.templates.javaneo4jembedded;

public class NodeWrapper {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _package;
	private Object _name;
	private java.util.List<Object> _accessors = new java.util.ArrayList<>();
	private java.util.List<Object> _lexical = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _externalFields = new java.util.ArrayList<>();

	NodeWrapper(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NodeWrapper");
		st.add("package", _package);
		st.add("name", _name);
		for (Object o : _accessors) st.add("accessors", o);
		for (Object o : _lexical) st.add("lexical", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _externalFields) st.addAggr("externalFields.{type,name,initializer}", map.get("type"), map.get("name"), map.get("initializer"));
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

	public NodeWrapper setName(Object value) {
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

	public NodeWrapper removeName() {
		this._name = null;
		return this;
	} 

	public NodeWrapper addAccessors(Object value) {
		this._accessors.add(value);
		return this;
	}

	public NodeWrapper setAccessors(Object[] value) {
		this._accessors.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NodeWrapper setAccessors(java.util.Collection<Object> values) {
		this._accessors.addAll(values);
		return this;
	}

	public NodeWrapper removeAccessors(Object value) {
		this._accessors.remove(value);
		return this;
	}

	public NodeWrapper removeAccessors(int index) {
		this._accessors.remove(index);
		return this;
	}

	public java.util.List<Object> getAccessors() {
		return this._accessors;
	} 

	public NodeWrapper addLexical(Object value) {
		this._lexical.add(value);
		return this;
	}

	public NodeWrapper setLexical(Object[] value) {
		this._lexical.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NodeWrapper setLexical(java.util.Collection<Object> values) {
		this._lexical.addAll(values);
		return this;
	}

	public NodeWrapper removeLexical(Object value) {
		this._lexical.remove(value);
		return this;
	}

	public NodeWrapper removeLexical(int index) {
		this._lexical.remove(index);
		return this;
	}

	public java.util.List<Object> getLexical() {
		return this._lexical;
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

	public NodeWrapper addExternalFields(Object _type, Object _name, Object _initializer) {
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

	public NodeWrapper addExternalFields(NodeWrapper_ExternalFields value) {
		return addExternalFields(value._type, value._name, value._initializer);
	}

	public java.util.stream.Stream<NodeWrapper_ExternalFields> streamExternalFields() {
		return this._externalFields.stream().map(NodeWrapper_ExternalFields::new);
	}

	public static final class NodeWrapper_ExternalFields {

		Object _type;
		Object _name;
		Object _initializer;

		public NodeWrapper_ExternalFields(Object _type, Object _name, Object _initializer) {
			this._type = _type;
			this._name = _name;
			this._initializer = _initializer;
		}

		private NodeWrapper_ExternalFields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
			this._initializer = (Object) map.get("initializer");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
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
		NodeWrapper that = (NodeWrapper) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NodeWrapper(package,name,externalFields,accessors,lexical,methods) ::= <<package ~package~;\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	private final org.neo4j.graphdb.Node node;\n" + 
				"	~externalFields:{it|private ~it.type~ _~it.name~~if(it.initializer)~ = ~it.initializer~~endif~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(org.neo4j.graphdb.Node node) { \n" + 
				"		this.node = node;\n" + 
				"	}\n" + 
				"\n" + 
				"	public org.neo4j.graphdb.Node getNode() { \n" + 
				"		return this.node;\n" + 
				"	}\n" + 
				"\n" + 
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
				"\n" + 
				"	~accessors:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		return \"\"~if(lexical)~ + ~endif~~lexical:{it|node.getProperty(\"~it~\")};separator=\" + \\\" \\\" + \"~;\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  