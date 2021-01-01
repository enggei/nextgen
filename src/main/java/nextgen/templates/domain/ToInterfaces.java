package nextgen.templates.domain;

public class ToInterfaces {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _packageName;
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
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{name,type,decl}", map.get("name"), map.get("type"), map.get("decl"));
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


	public ToInterfaces setProperties(java.util.Collection<ToInterfaces_Properties> values) {
			this._properties.clear();
			values.stream().map(ToInterfaces_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public ToInterfaces addProperties(Object _name, Object _type, Object _decl) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		map.put("decl", _decl);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public ToInterfaces addProperties(ToInterfaces_Properties value) {
		return addProperties(value._name, value._type, value._decl);
	}

	public java.util.stream.Stream<ToInterfaces_Properties> streamProperties() {
		return this._properties.stream().map(ToInterfaces_Properties::new);
	}

	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(ToInterfaces_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(ToInterfaces_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Decl() {
		return streamProperties().map(ToInterfaces_Properties::getDecl).collect(java.util.stream.Collectors.toList());
	}


	public static final class ToInterfaces_Properties {

		Object _name;
		Object _type;
		Object _decl;

		public ToInterfaces_Properties(Object _name, Object _type, Object _decl) {
			this._name = _name;
			this._type = _type;
			this._decl = _decl;
		}

		private ToInterfaces_Properties(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
			this._decl = (Object) map.get("decl");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

		public Object getDecl() {
			return this._decl;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			map.put("type", _type);
			map.put("decl", _decl);
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

	static final String st = "toInterfaces(name,packageName,properties) ::= <<~if(packageName)~package ~packageName~;\n" + 
				"~endif~\n" + 
				"public interface ~name~ {\n" + 
				"\n" + 
				"	~properties:{it|~if(it.decl)~~else~~it.type~ get~it.name;format=\"capitalize\"~();~endif~};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~properties:{it|~if(it.decl)~~it.decl~~endif~};separator=\"\\n\"~\n" + 
				"} >>";
}  