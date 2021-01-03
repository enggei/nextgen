package nextgen.templates.domain;

public class ToEnum {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	ToEnum(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("toEnum");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{name}", map.get("name"));
		return st.render().trim();
	}

	public ToEnum setName(String value) {
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

	public ToEnum removeName() {
		this._name = null;
		return this;
	} 


	public ToEnum setProperties(java.util.Collection<ToEnum_Properties> values) {
			this._properties.clear();
			values.stream().map(ToEnum_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public ToEnum addProperties(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public ToEnum addProperties(ToEnum_Properties value) {
		return addProperties(value._name);
	}

	public java.util.stream.Stream<ToEnum_Properties> streamProperties() {
		return this._properties.stream().map(ToEnum_Properties::new);
	}

	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(ToEnum_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class ToEnum_Properties {

		Object _name;

		public ToEnum_Properties(Object _name) {
			this._name = _name;
		}

		private ToEnum_Properties(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ToEnum that = (ToEnum) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "toEnum(properties,name) ::= <<enum ~name~ {\n" + 
				"	\n" + 
				"	~properties:{it|~it.name;format=\"capitalize\"~};separator=\",\\n\"~\n" + 
				"	\n" + 
				"} >>";
}  