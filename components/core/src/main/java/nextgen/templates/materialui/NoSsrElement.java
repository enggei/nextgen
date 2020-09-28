package nextgen.templates.materialui;

public class NoSsrElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _defer;
	private Object _fallback;
	private Object _id;
	private Object _key;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	NoSsrElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NoSsrElement");
		st.add("className", _className);
		st.add("defer", _defer);
		st.add("fallback", _fallback);
		st.add("id", _id);
		st.add("key", _key);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public NoSsrElement setClassName(Object value) {
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

	public NoSsrElement removeClassName() {
		this._className = null;
		return this;
	} 

	public NoSsrElement setDefer(Object value) {
		this._defer = value;
		return this;
	}

	public Object getDefer() {
		return this._defer;
	}

	public Object getDefer(Object defaultValue) {
		return this._defer == null ? defaultValue : this._defer;
	}

	public boolean hasDefer() {
		return this._defer != null;
	}

	public NoSsrElement removeDefer() {
		this._defer = null;
		return this;
	} 

	public NoSsrElement setFallback(Object value) {
		this._fallback = value;
		return this;
	}

	public Object getFallback() {
		return this._fallback;
	}

	public Object getFallback(Object defaultValue) {
		return this._fallback == null ? defaultValue : this._fallback;
	}

	public boolean hasFallback() {
		return this._fallback != null;
	}

	public NoSsrElement removeFallback() {
		this._fallback = null;
		return this;
	} 

	public NoSsrElement setId(Object value) {
		this._id = value;
		return this;
	}

	public Object getId() {
		return this._id;
	}

	public Object getId(Object defaultValue) {
		return this._id == null ? defaultValue : this._id;
	}

	public boolean hasId() {
		return this._id != null;
	}

	public NoSsrElement removeId() {
		this._id = null;
		return this;
	} 

	public NoSsrElement setKey(Object value) {
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

	public NoSsrElement removeKey() {
		this._key = null;
		return this;
	} 

	public NoSsrElement setStyle(Object value) {
		this._style = value;
		return this;
	}

	public Object getStyle() {
		return this._style;
	}

	public Object getStyle(Object defaultValue) {
		return this._style == null ? defaultValue : this._style;
	}

	public boolean hasStyle() {
		return this._style != null;
	}

	public NoSsrElement removeStyle() {
		this._style = null;
		return this;
	} 

	public NoSsrElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public NoSsrElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NoSsrElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public NoSsrElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public NoSsrElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public NoSsrElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public NoSsrElement addAttribute(NoSsrElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<NoSsrElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(NoSsrElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(NoSsrElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(NoSsrElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class NoSsrElement_Attribute {

		Object _name;
		Object _value;

		public NoSsrElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private NoSsrElement_Attribute(java.util.Map<String, Object> map) {
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
		NoSsrElement that = (NoSsrElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NoSsrElement(className,defer,fallback,id,key,style,attribute,children) ::= <<<NoSsr~if(className)~\n" + 
				"	className=~className~~endif~~if(defer)~\n" + 
				"	defer~endif~~if(fallback)~\n" + 
				"	fallback=~fallback~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</NoSsr>~else~ />~endif~ >>";
}  