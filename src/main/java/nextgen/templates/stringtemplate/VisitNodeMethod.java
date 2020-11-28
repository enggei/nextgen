package nextgen.templates.stringtemplate;

public class VisitNodeMethod {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _statements;
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _relations = new java.util.ArrayList<>();

	VisitNodeMethod(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("VisitNodeMethod");
		st.add("name", _name);
		st.add("statements", _statements);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{name,defaultValue}", map.get("name"), map.get("defaultValue"));
		for (java.util.Map<String, Object> map : _relations) st.addAggr("relations.{name}", map.get("name"));
		return st.render().trim();
	}

	public VisitNodeMethod setName(Object value) {
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

	public VisitNodeMethod removeName() {
		this._name = null;
		return this;
	} 

	public VisitNodeMethod setStatements(Object value) {
		this._statements = value;
		return this;
	}

	public Object getStatements() {
		return this._statements;
	}

	public Object getStatements(Object defaultValue) {
		return this._statements == null ? defaultValue : this._statements;
	}

	public boolean hasStatements() {
		return this._statements != null;
	}

	public VisitNodeMethod removeStatements() {
		this._statements = null;
		return this;
	} 


	public VisitNodeMethod addProperties(Object _name, Object _defaultValue) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("defaultValue", _defaultValue);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public VisitNodeMethod addProperties(VisitNodeMethod_Properties value) {
		return addProperties(value._name, value._defaultValue);
	}

	public java.util.stream.Stream<VisitNodeMethod_Properties> streamProperties() {
		return this._properties.stream().map(VisitNodeMethod_Properties::new);
	}

	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(VisitNodeMethod_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_DefaultValue() {
		return streamProperties().map(VisitNodeMethod_Properties::getDefaultValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class VisitNodeMethod_Properties {

		Object _name;
		Object _defaultValue;

		public VisitNodeMethod_Properties(Object _name, Object _defaultValue) {
			this._name = _name;
			this._defaultValue = _defaultValue;
		}

		private VisitNodeMethod_Properties(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._defaultValue = (Object) map.get("defaultValue");
		}

		public Object getName() {
			return this._name;
		}

		public Object getDefaultValue() {
			return this._defaultValue;
		}

	}  

	public VisitNodeMethod addRelations(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._relations.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRelations() {
		return this._relations;
	}

	public VisitNodeMethod addRelations(VisitNodeMethod_Relations value) {
		return addRelations(value._name);
	}

	public java.util.stream.Stream<VisitNodeMethod_Relations> streamRelations() {
		return this._relations.stream().map(VisitNodeMethod_Relations::new);
	}

	public java.util.List<Object> getRelations_Name() {
		return streamRelations().map(VisitNodeMethod_Relations::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class VisitNodeMethod_Relations {

		Object _name;

		public VisitNodeMethod_Relations(Object _name) {
			this._name = _name;
		}

		private VisitNodeMethod_Relations(java.util.Map<String, Object> map) {
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
		VisitNodeMethod that = (VisitNodeMethod) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "VisitNodeMethod(name,properties,statements,relations) ::= <<void visit~name;format=\"capitalize\"~(Node node) {\n" + 
				"	if (visitedNodes.contains(node)) return;\n" + 
				"	visitedNodes.add(node);\n" + 
				"	log.info(\"on node ~name;format=\"capitalize\"~\");\n" + 
				"	~properties:{it|final String ~it.name~ = getProperty(node, \"~it.name~\", ~if(it.defaultValue)~~it.defaultValue~~else~null~endif~);};separator=\"\\n\"~\n" + 
				"~if(statements)~\n" + 
				"	\n" + 
				"	~statements~\n" + 
				"	\n" + 
				"~endif~	\n" + 
				"	~relations:{it|get(node, \"~it.name~\").forEach(this::visit~it.name;format=\"capitalize\"~);};separator=\"\\n\"~\n" + 
				"} >>";
}  