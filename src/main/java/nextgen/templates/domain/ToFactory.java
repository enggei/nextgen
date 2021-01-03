package nextgen.templates.domain;

public class ToFactory {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _domain;
	private String _name;
	private Object _packageName;
	private java.util.List<Object> _entities = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	ToFactory(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("toFactory");
		st.add("domain", _domain);
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _entities) st.add("entities", o);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public ToFactory setDomain(Object value) {
		this._domain = value;
		return this;
	}

	public Object getDomain() {
		return this._domain;
	}

	public Object getDomain(Object defaultValue) {
		return this._domain == null ? defaultValue : this._domain;
	}

	public boolean hasDomain() {
		return this._domain != null;
	}

	public ToFactory removeDomain() {
		this._domain = null;
		return this;
	} 

	public ToFactory setName(String value) {
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

	public ToFactory removeName() {
		this._name = null;
		return this;
	} 

	public ToFactory setPackageName(Object value) {
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

	public ToFactory removePackageName() {
		this._packageName = null;
		return this;
	} 

	public ToFactory addEntities(Object value) {
		this._entities.add(value);
		return this;
	}

	public ToFactory setEntities(Object[] value) {
		this._entities.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ToFactory setEntities(java.util.Collection<Object> values) {
		this._entities.addAll(values);
		return this;
	}

	public ToFactory removeEntities(Object value) {
		this._entities.remove(value);
		return this;
	}

	public ToFactory removeEntities(int index) {
		this._entities.remove(index);
		return this;
	}

	public java.util.List<Object> getEntities() {
		return this._entities;
	} 

	public ToFactory setProperties(java.util.Collection<ToFactory_Properties> values) {
			this._properties.clear();
			values.stream().map(ToFactory_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public ToFactory addProperties(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public ToFactory addProperties(ToFactory_Properties value) {
		return addProperties(value._type, value._name);
	}

	public java.util.stream.Stream<ToFactory_Properties> streamProperties() {
		return this._properties.stream().map(ToFactory_Properties::new);
	}

	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(ToFactory_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(ToFactory_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class ToFactory_Properties {

		Object _type;
		Object _name;

		public ToFactory_Properties(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private ToFactory_Properties(java.util.Map<String, Object> map) {
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
		ToFactory that = (ToFactory) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "toFactory(domain,properties,entities,name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public interface ~name~ extends ~domain~ {\n" + 
				"	\n" + 
				"	~properties:{it|~name~ ~it.name~(~it.type~ value);};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~entities:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	\n" + 
				"} >>";
}  