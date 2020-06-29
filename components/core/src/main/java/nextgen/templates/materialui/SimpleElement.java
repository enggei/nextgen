package nextgen.templates.materialui;

public class SimpleElement implements Element {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _key;
	private Object _className;
	private Object _const;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attributes = new java.util.ArrayList<>();

	SimpleElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SimpleElement");
		st.add("name", _name);
		st.add("key", _key);
		st.add("className", _className);
		st.add("const", _const);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attributes) st.addAggr("attributes.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public SimpleElement setName(Object value) {
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

	public SimpleElement removeName() {
		this._name = null;
		return this;
	} 

	public SimpleElement setKey(Object value) {
		this._key = value;
		return this;
	}

	public Object getKey() {
		return this._key;
	}

	public Object getKey(Object defaultValue) {
		return this._key == null ? defaultValue : this._key;
	}

	public boolean hasKey() {
		return this._key != null;
	}

	public SimpleElement removeKey() {
		this._key = null;
		return this;
	} 

	public SimpleElement setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public Object getClassName(Object defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public SimpleElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SimpleElement setConst(Object value) {
		this._const = value;
		return this;
	}

	public Object getConst() {
		return this._const;
	}

	public Object getConst(Object defaultValue) {
		return this._const == null ? defaultValue : this._const;
	}

	public boolean hasConst() {
		return this._const != null;
	}

	public SimpleElement removeConst() {
		this._const = null;
		return this;
	} 

	public SimpleElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public SimpleElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SimpleElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public SimpleElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public SimpleElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public SimpleElement addAttributes(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attributes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttributes() {
		return this._attributes;
	}

	public SimpleElement addAttributes(SimpleElement_Attributes value) {
		return addAttributes(value._name, value._value);
	}

	public java.util.stream.Stream<SimpleElement_Attributes> streamAttributes() {
		return this._attributes.stream().map(SimpleElement_Attributes::new);
	}

	public static final class SimpleElement_Attributes {

		Object _name;
		Object _value;

		public SimpleElement_Attributes(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private SimpleElement_Attributes(java.util.Map<String, Object> map) {
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
		SimpleElement that = (SimpleElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SimpleElement(name,key,className,attributes,const,children) ::= <<<~name~~if(key)~ key=~key~~endif~~if(className)~ className={classes.~className~}~endif~~if(attributes)~ ~endif~~attributes:{it|~it.name~~if(it.value)~=~it.value~~endif~};separator=\" \"~~if(const)~ ~const~ ~endif~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</~name~> >>";
}  