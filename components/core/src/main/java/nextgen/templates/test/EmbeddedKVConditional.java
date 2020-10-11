package nextgen.templates.test;

public class EmbeddedKVConditional {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _PROP = new java.util.ArrayList<>();

	EmbeddedKVConditional(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("embeddedKVConditional");
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _PROP) st.addAggr("PROP.{initializer}", map.get("initializer"));
		return st.render().trim();
	}



	public EmbeddedKVConditional addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public EmbeddedKVConditional addFields(EmbeddedKVConditional_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<EmbeddedKVConditional_Fields> streamFields() {
		return this._fields.stream().map(EmbeddedKVConditional_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(EmbeddedKVConditional_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(EmbeddedKVConditional_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class EmbeddedKVConditional_Fields {

		Object _type;
		Object _name;

		public EmbeddedKVConditional_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private EmbeddedKVConditional_Fields(java.util.Map<String, Object> map) {
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

	public EmbeddedKVConditional addPROP(Object _initializer) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("initializer", _initializer);
		this._PROP.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getPROP() {
		return this._PROP;
	}

	public EmbeddedKVConditional addPROP(EmbeddedKVConditional_PROP value) {
		return addPROP(value._initializer);
	}

	public java.util.stream.Stream<EmbeddedKVConditional_PROP> streamPROP() {
		return this._PROP.stream().map(EmbeddedKVConditional_PROP::new);
	}

	public java.util.List<Object> getPROP_Initializer() {
		return streamPROP().map(EmbeddedKVConditional_PROP::getInitializer).collect(java.util.stream.Collectors.toList());
	}


	public static final class EmbeddedKVConditional_PROP {

		Object _initializer;

		public EmbeddedKVConditional_PROP(Object _initializer) {
			this._initializer = _initializer;
		}

		private EmbeddedKVConditional_PROP(java.util.Map<String, Object> map) {
			this._initializer = (Object) map.get("initializer");
		}

		public Object getInitializer() {
			return this._initializer;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EmbeddedKVConditional that = (EmbeddedKVConditional) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "embeddedKVConditional(fields,PROP) ::= <<~fields:{it|private ~it.type~ _~it.name~~if(it.initializer)~ = ~it.initializer~~endif~;};separator=\"\\n\"~ >>";
}  