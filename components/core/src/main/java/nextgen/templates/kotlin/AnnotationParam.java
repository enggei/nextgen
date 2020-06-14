package nextgen.templates.kotlin;

public class AnnotationParam {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<java.util.Map<String, Object>> _param = new java.util.ArrayList<>();

	AnnotationParam(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AnnotationParam");
		for (java.util.Map<String, Object> map : _param) st.addAggr("param.{key,value}", map.get("key"), map.get("value"));
		return st.render().trim();
	}



	public AnnotationParam addParam(Object _key, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("value", _value);
		this._param.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParam() {
		return this._param;
	}

	public AnnotationParam addParam(AnnotationParam_Param value) {
		return addParam(value._key, value._value);
	}

	public java.util.stream.Stream<AnnotationParam_Param> streamParam() {
		return this._param.stream().map(AnnotationParam_Param::new);
	}

	public static final class AnnotationParam_Param {

		Object _key;
		Object _value;

		public AnnotationParam_Param(Object _key, Object _value) {
			this._key = _key;
			this._value = _value;
		}

		private AnnotationParam_Param(java.util.Map<String, Object> map) {
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
		AnnotationParam that = (AnnotationParam) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AnnotationParam(param) ::= <<~param:{it|~it.key~ = ~it.value~};separator=\", \"~>>";
}