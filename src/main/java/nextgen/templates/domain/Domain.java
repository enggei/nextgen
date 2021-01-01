package nextgen.templates.domain;

public class Domain {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	Domain(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Domain");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{decl,quantifier,type,name}", map.get("decl"), map.get("quantifier"), map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public Domain setName(String value) {
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

	public Domain removeName() {
		this._name = null;
		return this;
	} 


	public Domain setProperties(java.util.Collection<Domain_Properties> values) {
			this._properties.clear();
			values.stream().map(Domain_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public Domain addProperties(Domain _decl, String _quantifier, String _type, String _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("decl", _decl);
		map.put("quantifier", _quantifier);
		map.put("type", _type);
		map.put("name", _name);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public Domain addProperties(Domain_Properties value) {
		return addProperties(value._decl, value._quantifier, value._type, value._name);
	}

	public java.util.stream.Stream<Domain_Properties> streamProperties() {
		return this._properties.stream().map(Domain_Properties::new);
	}

	public java.util.List<Domain> getProperties_Decl() {
		return streamProperties().map(Domain_Properties::getDecl).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getProperties_Quantifier() {
		return streamProperties().map(Domain_Properties::getQuantifier).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getProperties_Type() {
		return streamProperties().map(Domain_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getProperties_Name() {
		return streamProperties().map(Domain_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class Domain_Properties {

		Domain _decl;
		String _quantifier;
		String _type;
		String _name;

		public Domain_Properties(Domain _decl, String _quantifier, String _type, String _name) {
			this._decl = _decl;
			this._quantifier = _quantifier;
			this._type = _type;
			this._name = _name;
		}

		private Domain_Properties(java.util.Map<String, Object> map) {
			this._decl = (Domain) map.get("decl");
			this._quantifier = (String) map.get("quantifier");
			this._type = (String) map.get("type");
			this._name = (String) map.get("name");
		}

		public Domain getDecl() {
			return this._decl;
		}

		public String getQuantifier() {
			return this._quantifier;
		}

		public String getType() {
			return this._type;
		}

		public String getName() {
			return this._name;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("decl", _decl);
			map.put("quantifier", _quantifier);
			map.put("type", _type);
			map.put("name", _name);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Domain that = (Domain) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Domain(properties,name) ::= <<~name~\n" + 
				"    ~properties:{it|~it.name~	~it.quantifier~	~it.type~~if(it.decl)~\n" + 
				"    \n" + 
				"~it.decl~\n" + 
				"~endif~};separator=\"\\n\"~ >>";
}  