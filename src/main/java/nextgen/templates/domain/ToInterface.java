package nextgen.templates.domain;

public class ToInterface {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	ToInterface(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("toInterface");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public ToInterface setName(String value) {
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

	public ToInterface removeName() {
		this._name = null;
		return this;
	} 


	public ToInterface setProperties(java.util.Collection<ToInterface_Properties> values) {
			this._properties.clear();
			values.stream().map(ToInterface_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public ToInterface addProperties(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public ToInterface addProperties(ToInterface_Properties value) {
		return addProperties(value._name, value._type);
	}

	public java.util.stream.Stream<ToInterface_Properties> streamProperties() {
		return this._properties.stream().map(ToInterface_Properties::new);
	}

	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(ToInterface_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(ToInterface_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class ToInterface_Properties {

		Object _name;
		Object _type;

		public ToInterface_Properties(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private ToInterface_Properties(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			map.put("type", _type);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ToInterface that = (ToInterface) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "toInterface(properties,name) ::= <<interface ~name~ {\n" + 
				"	\n" + 
				"	~properties:{it|~it.type~ ~it.name~();};separator=\"\\n\"~\n" + 
				"	\n" + 
				"} >>";
}  