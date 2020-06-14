package nextgen.templates.kotlin;

public class Extending {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private java.util.List<java.util.Map<String, Object>> _params = new java.util.ArrayList<>();

	Extending(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Extending");
		st.add("className", _className);
		for (java.util.Map<String, Object> map : _params) st.addAggr("params.{name}", map.get("name"));
		return st.render().trim();
	}

	public Extending setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public Object getClassName(Object defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public Extending removeClassName() {
		this._className = null;
		return this;
	}


	public Extending addParams(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._params.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParams() {
		return this._params;
	}

	public Extending addParams(Extending_Params value) {
		return addParams(value._name);
	}

	public java.util.stream.Stream<Extending_Params> streamParams() {
		return this._params.stream().map(Extending_Params::new);
	}

	public static final class Extending_Params {

		Object _name;

		public Extending_Params(Object _name) {
			this._name = _name;
		}

		private Extending_Params(java.util.Map<String, Object> map) {
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
		Extending that = (Extending) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Extending(className,params) ::= <<~className~(~params:{it|~it.name~};separator=\", \"~)>>";
}