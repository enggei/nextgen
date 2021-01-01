package nextgen.templates.domain;

public class ToForm {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private String _name;
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	ToForm(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("toForm");
		st.add("packageName", _packageName);
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{name,decl,type}", map.get("name"), map.get("decl"), map.get("type"));
		return st.render().trim();
	}

	public ToForm setPackageName(Object value) {
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

	public ToForm removePackageName() {
		this._packageName = null;
		return this;
	} 

	public ToForm setName(String value) {
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

	public ToForm removeName() {
		this._name = null;
		return this;
	} 


	public ToForm setProperties(java.util.Collection<ToForm_Properties> values) {
			this._properties.clear();
			values.stream().map(ToForm_Properties::asMap).forEach(map -> _properties.add(map));
			return this;
		}

	public ToForm addProperties(Object _name, Object _decl, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("decl", _decl);
		map.put("type", _type);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public ToForm addProperties(ToForm_Properties value) {
		return addProperties(value._name, value._decl, value._type);
	}

	public java.util.stream.Stream<ToForm_Properties> streamProperties() {
		return this._properties.stream().map(ToForm_Properties::new);
	}

	public java.util.List<Object> getProperties_Name() {
		return streamProperties().map(ToForm_Properties::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Decl() {
		return streamProperties().map(ToForm_Properties::getDecl).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getProperties_Type() {
		return streamProperties().map(ToForm_Properties::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class ToForm_Properties {

		Object _name;
		Object _decl;
		Object _type;

		public ToForm_Properties(Object _name, Object _decl, Object _type) {
			this._name = _name;
			this._decl = _decl;
			this._type = _type;
		}

		private ToForm_Properties(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._decl = (Object) map.get("decl");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getDecl() {
			return this._decl;
		}

		public Object getType() {
			return this._type;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			map.put("decl", _decl);
			map.put("type", _type);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ToForm that = (ToForm) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "toForm(properties,packageName,name) ::= <<~if(packageName)~package ~packageName~;\n" + 
				"~endif~\n" + 
				"public class ~name~ extends javax.swing.JPanel {\n" + 
				"\n" + 
				"	~properties:{it|~if(it.decl)~~else~~it.type~ get~it.name;format=\"capitalize\"~();~endif~};separator=\"\\n\"~\n" + 
				"	~properties:{it|~if(it.decl)~\n" + 
				"\n" + 
				"~it.decl~~endif~};separator=\"\\n\"~\n" + 
				"} >>";
}  