package nextgen.templates.javascript;

public class Style {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	Style(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Style");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{key,value}", map.get("key"), map.get("value"));
		return st.render().trim();
	}

	public Style setName(Object value) {
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

	public Style removeName() {
		this._name = null;
		return this;
	}


	public Style addProperties(Object _key, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("value", _value);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public Style addProperties(Style_Properties value) {
		return addProperties(value._key, value._value);
	}

	public java.util.stream.Stream<Style_Properties> streamProperties() {
		return this._properties.stream().map(Style_Properties::new);
	}

	public static final class Style_Properties {

		Object _key;
		Object _value;

		public Style_Properties(Object _key, Object _value) {
			this._key = _key;
			this._value = _value;
		}

		private Style_Properties(java.util.Map<String, Object> map) {
			this._key = (Object) map.get("key");
			this._value = (Object) map.get("value");
		}

		public Object getKey() {
			return this._key;
		}

		public Object getValue() {
			return this._value;
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Style that = (Style) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Style(name,properties) ::= <<~name~: {\n" + 
				"	~properties:{it|~it.key~: ~it.value~};separator=\",\\n\"~\n" + 
				"}>>";
}