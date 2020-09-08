package nextgen.st.stringtemplate;

public class VisitRelationMethod {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _statements;
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _dst = new java.util.ArrayList<>();

	VisitRelationMethod(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("VisitRelationMethod");
		st.add("name", _name);
		st.add("statements", _statements);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{name,defaultValue}", map.get("name"), map.get("defaultValue"));
		for (java.util.Map<String, Object> map : _dst) st.addAggr("dst.{name}", map.get("name"));
		return st.render().trim();
	}

	public VisitRelationMethod setName(Object value) {
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

	public VisitRelationMethod removeName() {
		this._name = null;
		return this;
	} 

	public VisitRelationMethod setStatements(Object value) {
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

	public VisitRelationMethod removeStatements() {
		this._statements = null;
		return this;
	} 


	public VisitRelationMethod addProperties(Object _name, Object _defaultValue) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("defaultValue", _defaultValue);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public VisitRelationMethod addProperties(VisitRelationMethod_Properties value) {
		return addProperties(value._name, value._defaultValue);
	}

	public java.util.stream.Stream<VisitRelationMethod_Properties> streamProperties() {
		return this._properties.stream().map(VisitRelationMethod_Properties::new);
	}

	public static final class VisitRelationMethod_Properties {

		Object _name;
		Object _defaultValue;

		public VisitRelationMethod_Properties(Object _name, Object _defaultValue) {
			this._name = _name;
			this._defaultValue = _defaultValue;
		}

		private VisitRelationMethod_Properties(java.util.Map<String, Object> map) {
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

	public VisitRelationMethod addDst(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._dst.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getDst() {
		return this._dst;
	}

	public VisitRelationMethod addDst(VisitRelationMethod_Dst value) {
		return addDst(value._name);
	}

	public java.util.stream.Stream<VisitRelationMethod_Dst> streamDst() {
		return this._dst.stream().map(VisitRelationMethod_Dst::new);
	}

	public static final class VisitRelationMethod_Dst {

		Object _name;

		public VisitRelationMethod_Dst(Object _name) {
			this._name = _name;
		}

		private VisitRelationMethod_Dst(java.util.Map<String, Object> map) {
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
		VisitRelationMethod that = (VisitRelationMethod) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "VisitRelationMethod(name,properties,statements,dst) ::= <<void visit~name;format=\"capitalize\"~(Relationship relationship) {\n" + 
				"	log.info(\"on relation ~name;format=\"capitalize\"~\");\n" + 
				"	~properties:{it|final String ~it.name~ = getProperty(relationship, \"~it.name~\", ~if(it.defaultValue)~~it.defaultValue~~else~null~endif~);};separator=\"\\n\"~\n" + 
				"~if(statements)~\n" + 
				"	\n" + 
				"	~statements~\n" + 
				"	\n" + 
				"~endif~\n" + 
				"	~dst:{it|visit~it.name;format=\"capitalize\"~(relationship.getEndNode());};separator=\"\\n\"~\n" + 
				"} >>";
}  