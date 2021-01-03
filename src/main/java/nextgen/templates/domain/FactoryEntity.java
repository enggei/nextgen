package nextgen.templates.domain;

public class FactoryEntity {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _type;
	private java.util.List<java.util.Map<String, Object>> _requiredProperties = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	FactoryEntity(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("factoryEntity");
		st.add("name", _name);
		st.add("type", _type);
		for (java.util.Map<String, Object> map : _requiredProperties) st.addAggr("requiredProperties.{name,type}", map.get("name"), map.get("type"));
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{methodName,type}", map.get("methodName"), map.get("type"));
		return st.render().trim();
	}

	public FactoryEntity setName(String value) {
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

	public FactoryEntity removeName() {
		this._name = null;
		return this;
	} 

	public FactoryEntity setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public FactoryEntity removeType() {
		this._type = null;
		return this;
	} 


	public FactoryEntity setRequiredProperties(java.util.Collection<FactoryEntity_RequiredProperties> values) {
			this._requiredProperties.clear();
			values.stream().map(FactoryEntity_RequiredProperties::asMap).forEach(map -> _requiredProperties.add(map));
			return this;
		}

	public FactoryEntity addRequiredProperties(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._requiredProperties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRequiredProperties() {
		return this._requiredProperties;
	}

	public FactoryEntity addRequiredProperties(FactoryEntity_RequiredProperties value) {
		return addRequiredProperties(value._name, value._type);
	}

	public java.util.stream.Stream<FactoryEntity_RequiredProperties> streamRequiredProperties() {
		return this._requiredProperties.stream().map(FactoryEntity_RequiredProperties::new);
	}

	public java.util.List<Object> getRequiredProperties_Name() {
		return streamRequiredProperties().map(FactoryEntity_RequiredProperties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getRequiredProperties_Type() {
		return streamRequiredProperties().map(FactoryEntity_RequiredProperties::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class FactoryEntity_RequiredProperties {

		Object _name;
		Object _type;

		public FactoryEntity_RequiredProperties(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private FactoryEntity_RequiredProperties(java.util.Map<String, Object> map) {
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

	public FactoryEntity setProperties(java.util.Collection<FactoryEntity_Properties> values) {
			this._properties.clear();
			values.stream().map(FactoryEntity_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public FactoryEntity addProperties(Object _methodName, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("methodName", _methodName);
		map.put("type", _type);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public FactoryEntity addProperties(FactoryEntity_Properties value) {
		return addProperties(value._methodName, value._type);
	}

	public java.util.stream.Stream<FactoryEntity_Properties> streamProperties() {
		return this._properties.stream().map(FactoryEntity_Properties::new);
	}

	public java.util.List<Object> getProperties_MethodName() {
		return streamProperties().map(FactoryEntity_Properties::getMethodName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(FactoryEntity_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class FactoryEntity_Properties {

		Object _methodName;
		Object _type;

		public FactoryEntity_Properties(Object _methodName, Object _type) {
			this._methodName = _methodName;
			this._type = _type;
		}

		private FactoryEntity_Properties(java.util.Map<String, Object> map) {
			this._methodName = (Object) map.get("methodName");
			this._type = (Object) map.get("type");
		}

		public Object getMethodName() {
			return this._methodName;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("methodName", _methodName);
			map.put("type", _type);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FactoryEntity that = (FactoryEntity) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "factoryEntity(requiredProperties,properties,name,type) ::= <<~type~Builder new~name;format=\"capitalize\"~(~requiredProperties:{it|~it.type~ ~it.name~};separator=\", \"~);\n" + 
				"\n" + 
				"interface ~type~Builder extends ~type~ {\n" + 
				"	~properties:{it|~type~Builder ~it.methodName~(~it.type~ element);};separator=\"\\n\"~\n" + 
				"} >>";
}  