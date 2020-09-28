package nextgen.templates.javascript;

public class Element {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _singleAttributes = new java.util.ArrayList<>();
	private java.util.List<Object> _props = new java.util.ArrayList<>();
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attributes = new java.util.ArrayList<>();

	Element(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Element");
		st.add("name", _name);
		for (Object o : _singleAttributes) st.add("singleAttributes", o);
		for (Object o : _props) st.add("props", o);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attributes) st.addAggr("attributes.{key,value}", map.get("key"), map.get("value"));
		return st.render().trim();
	}

	public Element setName(Object value) {
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

	public Element removeName() {
		this._name = null;
		return this;
	} 

	public Element addSingleAttributes(Object value) {
		this._singleAttributes.add(value);
		return this;
	}

	public Element setSingleAttributes(Object[] value) {
		this._singleAttributes.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Element setSingleAttributes(java.util.Collection<Object> values) {
		this._singleAttributes.addAll(values);
		return this;
	}

	public Element removeSingleAttributes(Object value) {
		this._singleAttributes.remove(value);
		return this;
	}

	public Element removeSingleAttributes(int index) {
		this._singleAttributes.remove(index);
		return this;
	}

	public java.util.List<Object> getSingleAttributes() {
		return this._singleAttributes;
	} 

	public Element addProps(Object value) {
		this._props.add(value);
		return this;
	}

	public Element setProps(Object[] value) {
		this._props.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Element setProps(java.util.Collection<Object> values) {
		this._props.addAll(values);
		return this;
	}

	public Element removeProps(Object value) {
		this._props.remove(value);
		return this;
	}

	public Element removeProps(int index) {
		this._props.remove(index);
		return this;
	}

	public java.util.List<Object> getProps() {
		return this._props;
	} 

	public Element addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public Element setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Element setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public Element removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public Element removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public Element addAttributes(Object _key, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("value", _value);
		this._attributes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttributes() {
		return this._attributes;
	}

	public Element addAttributes(Element_Attributes value) {
		return addAttributes(value._key, value._value);
	}

	public java.util.stream.Stream<Element_Attributes> streamAttributes() {
		return this._attributes.stream().map(Element_Attributes::new);
	}

	public java.util.List<Object> getAttributes_Key() {
		return streamAttributes().map(Element_Attributes::getKey).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttributes_Value() {
		return streamAttributes().map(Element_Attributes::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class Element_Attributes {

		Object _key;
		Object _value;

		public Element_Attributes(Object _key, Object _value) {
			this._key = _key;
			this._value = _value;
		}

		private Element_Attributes(java.util.Map<String, Object> map) {
			this._key = (Object) map.get("key");
			this._value = (Object) map.get("value");
		}

		public Object getKey() {
			return this._key;
		}

		public Object getValue() {
			return this._value;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Element that = (Element) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Element(name,singleAttributes,attributes,props,children) ::= <<<~name~~if(singleAttributes)~ ~singleAttributes:{it|~it~};separator=\" \"~~endif~~if(attributes)~ ~attributes:{it|\n" + 
				"\n" + 
				"	~it.key~=~it.value~}~~endif~~if(props)~ ~props:{it|~it~};separator=\" \"~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</~name~>~else~ />~endif~ >>";
}  