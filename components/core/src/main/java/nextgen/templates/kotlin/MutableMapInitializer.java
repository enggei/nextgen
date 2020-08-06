package nextgen.templates.kotlin;

public class MutableMapInitializer implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<java.util.Map<String, Object>> _kvpairs = new java.util.ArrayList<>();

	MutableMapInitializer(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MutableMapInitializer");
		for (java.util.Map<String, Object> map : _kvpairs) st.addAggr("kvpairs.{key,value}", map.get("key"), map.get("value"));
		return st.render().trim();
	}



	public MutableMapInitializer addKvpairs(Expression _key, Expression _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("value", _value);
		this._kvpairs.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getKvpairs() {
		return this._kvpairs;
	}

	public MutableMapInitializer addKvpairs(MutableMapInitializer_Kvpairs value) {
		return addKvpairs(value._key, value._value);
	}

	public java.util.stream.Stream<MutableMapInitializer_Kvpairs> streamKvpairs() {
		return this._kvpairs.stream().map(MutableMapInitializer_Kvpairs::new);
	}

	public static final class MutableMapInitializer_Kvpairs {

		Expression _key;
		Expression _value;

		public MutableMapInitializer_Kvpairs(Expression _key, Expression _value) {
			this._key = _key;
			this._value = _value;
		}

		private MutableMapInitializer_Kvpairs(java.util.Map<String, Object> map) {
			this._key = (Expression) map.get("key");
			this._value = (Expression) map.get("value");
		}

		public Expression getKey() {
			return this._key;
		}

		public Expression getValue() {
			return this._value;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MutableMapInitializer that = (MutableMapInitializer) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MutableMapInitializer(kvpairs) ::= <<mutableMapOf(~kvpairs:{it|~it.key~ to ~it.value~};separator=\", \"~) >>";
}  