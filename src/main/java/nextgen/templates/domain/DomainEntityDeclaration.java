package nextgen.templates.domain;

public class DomainEntityDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	DomainEntityDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DomainEntityDeclaration");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{typeDeclaration,type,name,quantifier}", map.get("typeDeclaration"), map.get("type"), map.get("name"), map.get("quantifier"));
		return st.render().trim();
	}

	public DomainEntityDeclaration setName(String value) {
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

	public DomainEntityDeclaration removeName() {
		this._name = null;
		return this;
	} 


	public DomainEntityDeclaration setProperties(java.util.Collection<DomainEntityDeclaration_Properties> values) {
			this._properties.clear();
			values.stream().map(DomainEntityDeclaration_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public DomainEntityDeclaration addProperties(Object _typeDeclaration, Object _type, Object _name, Object _quantifier) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("typeDeclaration", _typeDeclaration);
		map.put("type", _type);
		map.put("name", _name);
		map.put("quantifier", _quantifier);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public DomainEntityDeclaration addProperties(DomainEntityDeclaration_Properties value) {
		return addProperties(value._typeDeclaration, value._type, value._name, value._quantifier);
	}

	public java.util.stream.Stream<DomainEntityDeclaration_Properties> streamProperties() {
		return this._properties.stream().map(DomainEntityDeclaration_Properties::new);
	}

	public java.util.List<Object> getProperties_TypeDeclaration() {
		return streamProperties().map(DomainEntityDeclaration_Properties::getTypeDeclaration).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(DomainEntityDeclaration_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(DomainEntityDeclaration_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Quantifier() {
		return streamProperties().map(DomainEntityDeclaration_Properties::getQuantifier).collect(java.util.stream.Collectors.toList());
	}


	public static final class DomainEntityDeclaration_Properties {

		Object _typeDeclaration;
		Object _type;
		Object _name;
		Object _quantifier;

		public DomainEntityDeclaration_Properties(Object _typeDeclaration, Object _type, Object _name, Object _quantifier) {
			this._typeDeclaration = _typeDeclaration;
			this._type = _type;
			this._name = _name;
			this._quantifier = _quantifier;
		}

		private DomainEntityDeclaration_Properties(java.util.Map<String, Object> map) {
			this._typeDeclaration = (Object) map.get("typeDeclaration");
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
			this._quantifier = (Object) map.get("quantifier");
		}

		public Object getTypeDeclaration() {
			return this._typeDeclaration;
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

		public Object getQuantifier() {
			return this._quantifier;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("typeDeclaration", _typeDeclaration);
			map.put("type", _type);
			map.put("name", _name);
			map.put("quantifier", _quantifier);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DomainEntityDeclaration that = (DomainEntityDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DomainEntityDeclaration(properties,name) ::= <<final MetaDomainFactory ~name~ = newDomain(\"~name~\")\n" + 
				"	~properties:{it|.addproperties(~it.quantifier~(domain, \"~it.name~\"~if(it.type)~, \"~it.type~\"~if(it.typeDeclaration)~, ~it.typeDeclaration~~endif~~endif~));};separator=\"\\n\"~\n" + 
				"; >>";
}  