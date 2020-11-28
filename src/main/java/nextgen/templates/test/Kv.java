package nextgen.templates.test;

public class Kv implements TestInterface {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<java.util.Map<String, Object>> _value = new java.util.ArrayList<>();

	Kv(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("kv");
		for (java.util.Map<String, Object> map : _value) st.addAggr("value.{key,value}", map.get("key"), map.get("value"));
		return st.render().trim();
	}



	public Kv addValue(String _key, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("value", _value);
		this._value.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getValue() {
		return this._value;
	}

	public Kv addValue(Kv_Value value) {
		return addValue(value._key, value._value);
	}

	public java.util.stream.Stream<Kv_Value> streamValue() {
		return this._value.stream().map(Kv_Value::new);
	}

	public java.util.List<String> getValue_Key() {
		return streamValue().map(Kv_Value::getKey).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getValue_Value() {
		return streamValue().map(Kv_Value::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class Kv_Value {

		String _key;
		Object _value;

		public Kv_Value(String _key, Object _value) {
			this._key = _key;
			this._value = _value;
		}

		private Kv_Value(java.util.Map<String, Object> map) {
			this._key = (String) map.get("key");
			this._value = (Object) map.get("value");
		}

		public String getKey() {
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
		Kv that = (Kv) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "kv(value) ::= <<~value:{it|~it.key~ : ~it.value~};separator=\"\\n\"~ >>";
}  