package nextgen.templates.domain;

public class DomainDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<Object> _entities = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	DomainDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainDeclaration");
		st.add("name", _name);
		for (Object o : _entities) st.add("entities", o);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{quantifier,type,name,typeDeclaration}", map.get("quantifier"), map.get("type"), map.get("name"), map.get("typeDeclaration"));
		return st.render().trim();
	}

	public DomainDeclaration setName(String value) {
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

	public DomainDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public DomainDeclaration addEntities(Object value) {
		this._entities.add(value);
		return this;
	}

	public DomainDeclaration setEntities(Object[] value) {
		this._entities.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DomainDeclaration setEntities(java.util.Collection<Object> values) {
		this._entities.addAll(values);
		return this;
	}

	public DomainDeclaration removeEntities(Object value) {
		this._entities.remove(value);
		return this;
	}

	public DomainDeclaration removeEntities(int index) {
		this._entities.remove(index);
		return this;
	}

	public java.util.List<Object> getEntities() {
		return this._entities;
	} 

	public DomainDeclaration setProperties(java.util.Collection<DomainDeclaration_Properties> values) {
			this._properties.clear();
			values.stream().map(DomainDeclaration_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public DomainDeclaration addProperties(Object _quantifier, Object _type, Object _name, Object _typeDeclaration) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("quantifier", _quantifier);
		map.put("type", _type);
		map.put("name", _name);
		map.put("typeDeclaration", _typeDeclaration);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public DomainDeclaration addProperties(DomainDeclaration_Properties value) {
		return addProperties(value._quantifier, value._type, value._name, value._typeDeclaration);
	}

	public java.util.stream.Stream<DomainDeclaration_Properties> streamProperties() {
		return this._properties.stream().map(DomainDeclaration_Properties::new);
	}

	public java.util.List<Object> getProperties_Quantifier() {
		return streamProperties().map(DomainDeclaration_Properties::getQuantifier).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(DomainDeclaration_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(DomainDeclaration_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_TypeDeclaration() {
		return streamProperties().map(DomainDeclaration_Properties::getTypeDeclaration).collect(java.util.stream.Collectors.toList());
	}


	public static final class DomainDeclaration_Properties {

		Object _quantifier;
		Object _type;
		Object _name;
		Object _typeDeclaration;

		public DomainDeclaration_Properties(Object _quantifier, Object _type, Object _name, Object _typeDeclaration) {
			this._quantifier = _quantifier;
			this._type = _type;
			this._name = _name;
			this._typeDeclaration = _typeDeclaration;
		}

		private DomainDeclaration_Properties(java.util.Map<String, Object> map) {
			this._quantifier = (Object) map.get("quantifier");
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
			this._typeDeclaration = (Object) map.get("typeDeclaration");
		}

		public Object getQuantifier() {
			return this._quantifier;
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

		public Object getTypeDeclaration() {
			return this._typeDeclaration;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("quantifier", _quantifier);
			map.put("type", _type);
			map.put("name", _name);
			map.put("typeDeclaration", _typeDeclaration);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainDeclaration that = (DomainDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainDeclaration(entities,properties,name) ::= <<private static MetaDomain new~name;format=\"capitalize\"~() {\n" + 
				"\n" + 
				"	final MetaDomainFactory domain = new MetaDomainFactoryImpl();\n" + 
				"	domain.setname(\"~name;format=\"capitalize\"~\");\n" + 
				"	\n" + 
				"	~entities:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~properties:{it|domain.addproperties(~it.quantifier~(domain, \"~it.name~\"~if(it.type)~, \"~it.type~\"~if(it.typeDeclaration)~, ~it.typeDeclaration~~endif~~endif~));};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	return domain;\n" + 
				"} >>";
}  