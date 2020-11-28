package nextgen.templates.materialui;

public class StyleClass {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _attributes = new java.util.ArrayList<>();

	StyleClass(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StyleClass");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _attributes) st.addAggr("attributes.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public StyleClass setName(Object value) {
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

	public StyleClass removeName() {
		this._name = null;
		return this;
	} 


	public StyleClass addAttributes(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attributes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttributes() {
		return this._attributes;
	}

	public StyleClass addAttributes(StyleClass_Attributes value) {
		return addAttributes(value._name, value._value);
	}

	public java.util.stream.Stream<StyleClass_Attributes> streamAttributes() {
		return this._attributes.stream().map(StyleClass_Attributes::new);
	}

	public java.util.List<Object> getAttributes_Name() {
		return streamAttributes().map(StyleClass_Attributes::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttributes_Value() {
		return streamAttributes().map(StyleClass_Attributes::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class StyleClass_Attributes {

		Object _name;
		Object _value;

		public StyleClass_Attributes(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private StyleClass_Attributes(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StyleClass that = (StyleClass) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "StyleClass(name,attributes) ::= <<~name~: {\n" + 
				"	~attributes:{it|~it.name~: ~it.value~};separator=\",\\n\"~\n" + 
				"} >>";
}  