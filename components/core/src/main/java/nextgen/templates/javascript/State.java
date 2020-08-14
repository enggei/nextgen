package nextgen.templates.javascript;

public class State {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<java.util.Map<String, Object>> _values = new java.util.ArrayList<>();

	State(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("State");
		for (java.util.Map<String, Object> map : _values) st.addAggr("values.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}



	public State addValues(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._values.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getValues() {
		return this._values;
	}

	public State addValues(State_Values value) {
		return addValues(value._name, value._value);
	}

	public java.util.stream.Stream<State_Values> streamValues() {
		return this._values.stream().map(State_Values::new);
	}

	public static final class State_Values {

		Object _name;
		Object _value;

		public State_Values(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private State_Values(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		State that = (State) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "State(values) ::= <<{\n" + 
				"	~values:{it|~it.name~: ~it.value~};separator=\",\\n\"~\n" + 
				"} >>";
}  