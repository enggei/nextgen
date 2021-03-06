package nextgen.templates.domain;

public class ToInterfaces {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _packageName;
	private java.util.List<Object> _domains = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	ToInterfaces(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("toInterfaces");
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _domains) st.add("domains", o);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public ToInterfaces setName(String value) {
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

	public ToInterfaces removeName() {
		this._name = null;
		return this;
	} 

	public ToInterfaces setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public ToInterfaces removePackageName() {
		this._packageName = null;
		return this;
	} 

	public ToInterfaces addDomains(Object value) {
		this._domains.add(value);
		return this;
	}

	public ToInterfaces setDomains(Object[] value) {
		this._domains.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ToInterfaces setDomains(java.util.Collection<Object> values) {
		this._domains.addAll(values);
		return this;
	}

	public ToInterfaces removeDomains(Object value) {
		this._domains.remove(value);
		return this;
	}

	public ToInterfaces removeDomains(int index) {
		this._domains.remove(index);
		return this;
	}

	public java.util.List<Object> getDomains() {
		return this._domains;
	} 

	public ToInterfaces setProperties(java.util.Collection<ToInterfaces_Properties> values) {
			this._properties.clear();
			values.stream().map(ToInterfaces_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public ToInterfaces addProperties(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public ToInterfaces addProperties(ToInterfaces_Properties value) {
		return addProperties(value._type, value._name);
	}

	public java.util.stream.Stream<ToInterfaces_Properties> streamProperties() {
		return this._properties.stream().map(ToInterfaces_Properties::new);
	}

	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(ToInterfaces_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(ToInterfaces_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class ToInterfaces_Properties {

		Object _type;
		Object _name;

		public ToInterfaces_Properties(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private ToInterfaces_Properties(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("type", _type);
			map.put("name", _name);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ToInterfaces that = (ToInterfaces) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "toInterfaces(properties,domains,name,packageName) ::= <<~if(packageName)~package ~packageName~;\n" + 
				"\n" + 
				"public ~endif~interface ~name~ {\n" + 
				"\n" + 
				"	~properties:{it|~it.type~ ~it.name~();};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~domains:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  