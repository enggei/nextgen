package nextgen.templates.domain;

public class NamedEntityMethod {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private Object _name;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _parameters = new java.util.ArrayList<>();

	NamedEntityMethod(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NamedEntityMethod");
		st.add("type", _type);
		st.add("name", _name);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _parameters) st.addAggr("parameters.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public NamedEntityMethod setType(Object value) {
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

	public NamedEntityMethod removeType() {
		this._type = null;
		return this;
	} 

	public NamedEntityMethod setName(Object value) {
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

	public NamedEntityMethod removeName() {
		this._name = null;
		return this;
	} 

	public NamedEntityMethod addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public NamedEntityMethod setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NamedEntityMethod setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public NamedEntityMethod removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public NamedEntityMethod removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public NamedEntityMethod addParameters(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._parameters.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParameters() {
		return this._parameters;
	}

	public NamedEntityMethod addParameters(NamedEntityMethod_Parameters value) {
		return addParameters(value._type, value._name);
	}

	public java.util.stream.Stream<NamedEntityMethod_Parameters> streamParameters() {
		return this._parameters.stream().map(NamedEntityMethod_Parameters::new);
	}

	public static final class NamedEntityMethod_Parameters {

		Object _type;
		Object _name;

		public NamedEntityMethod_Parameters(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private NamedEntityMethod_Parameters(java.util.Map<String, Object> map) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NamedEntityMethod that = (NamedEntityMethod) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NamedEntityMethod(type,name,parameters,statements) ::= <<~type~ ~name~(~parameters:{it|~it.type~, ~it.name~};separator=\",\"~) {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  