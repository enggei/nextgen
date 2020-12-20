package nextgen.templates.brain;

public class CombinationImpl {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _expression;
	private Object _type;
	private String _name;
	private java.util.List<java.util.Map<String, Object>> _parameters = new java.util.ArrayList<>();

	CombinationImpl(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CombinationImpl");
		st.add("expression", _expression);
		st.add("type", _type);
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _parameters) st.addAggr("parameters.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public CombinationImpl setExpression(Object value) {
		this._expression = value;
		return this;
	}

	public Object getExpression() {
		return this._expression;
	}

	public Object getExpression(Object defaultValue) {
		return this._expression == null ? defaultValue : this._expression;
	}

	public boolean hasExpression() {
		return this._expression != null;
	}

	public CombinationImpl removeExpression() {
		this._expression = null;
		return this;
	} 

	public CombinationImpl setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public CombinationImpl removeType() {
		this._type = null;
		return this;
	} 

	public CombinationImpl setName(String value) {
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

	public CombinationImpl removeName() {
		this._name = null;
		return this;
	} 


	public CombinationImpl addParameters(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._parameters.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParameters() {
		return this._parameters;
	}

	public CombinationImpl addParameters(CombinationImpl_Parameters value) {
		return addParameters(value._name, value._type);
	}

	public java.util.stream.Stream<CombinationImpl_Parameters> streamParameters() {
		return this._parameters.stream().map(CombinationImpl_Parameters::new);
	}

	public java.util.List<Object> getParameters_Name() {
		return streamParameters().map(CombinationImpl_Parameters::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getParameters_Type() {
		return streamParameters().map(CombinationImpl_Parameters::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class CombinationImpl_Parameters {

		Object _name;
		Object _type;

		public CombinationImpl_Parameters(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private CombinationImpl_Parameters(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CombinationImpl that = (CombinationImpl) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CombinationImpl(expression,type,parameters,name) ::= <<@Override\n" + 
				"~type~ ~name~(~parameters:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"	~expression~\n" + 
				"} >>";
}  