package nextgen.templates.typescript;

public class Interface {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _properties = new java.util.ArrayList<>();

	Interface(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("interface");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _properties) st.addAggr("properties.{isReadOnly,name,isOptional,type}", map.get("isReadOnly"), map.get("name"), map.get("isOptional"), map.get("type"));
		return st.render().trim();
	}

	public Interface setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Interface removeName() {
		this._name = null;
		return this;
	} 


	public Interface addProperties(Object _isReadOnly, Object _name, Object _isOptional, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("isReadOnly", _isReadOnly);
		map.put("name", _name);
		map.put("isOptional", _isOptional);
		map.put("type", _type);
		this._properties.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getProperties() {
		return this._properties;
	}

	public Interface addProperties(Interface_Properties value) {
		return addProperties(value._isReadOnly, value._name, value._isOptional, value._type);
	}

	public java.util.stream.Stream<Interface_Properties> streamProperties() {
		return this._properties.stream().map(Interface_Properties::new);
	}

	public static final class Interface_Properties {

		Object _isReadOnly;
		Object _name;
		Object _isOptional;
		Object _type;

		public Interface_Properties(Object _isReadOnly, Object _name, Object _isOptional, Object _type) {
			this._isReadOnly = _isReadOnly;
			this._name = _name;
			this._isOptional = _isOptional;
			this._type = _type;
		}

		private Interface_Properties(java.util.Map<String, Object> map) {
			this._isReadOnly = (Object) map.get("isReadOnly");
			this._name = (Object) map.get("name");
			this._isOptional = (Object) map.get("isOptional");
			this._type = (Object) map.get("type");
		}

		public Object getIsReadOnly() {
			return this._isReadOnly;
		}

		public Object getName() {
			return this._name;
		}

		public Object getIsOptional() {
			return this._isOptional;
		}

		public Object getType() {
			return this._type;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Interface that = (Interface) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "interface(name,properties) ::= <<interface ~name~ {\n" + 
				"    ~properties:{it|~if(it.isReadOnly)~readonly ~endif~~it.name~~if(it.isReadOnly)~~elseif(it.isOptional)~?~endif~ : ~it.type~;};separator=\"\\n\"~\n" + 
				"} >>";
} 