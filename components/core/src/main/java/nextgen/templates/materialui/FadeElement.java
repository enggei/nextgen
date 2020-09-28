package nextgen.templates.materialui;

public class FadeElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _disableStrictModeCompat;
	private Object _id;
	private Object _in;
	private Object _key;
	private Object _style;
	private Object _timeout;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	FadeElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FadeElement");
		st.add("className", _className);
		st.add("disableStrictModeCompat", _disableStrictModeCompat);
		st.add("id", _id);
		st.add("in", _in);
		st.add("key", _key);
		st.add("style", _style);
		st.add("timeout", _timeout);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public FadeElement setClassName(Object value) {
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

	public FadeElement removeClassName() {
		this._className = null;
		return this;
	} 

	public FadeElement setDisableStrictModeCompat(Object value) {
		this._disableStrictModeCompat = value;
		return this;
	}

	public Object getDisableStrictModeCompat() {
		return this._disableStrictModeCompat;
	}

	public Object getDisableStrictModeCompat(Object defaultValue) {
		return this._disableStrictModeCompat == null ? defaultValue : this._disableStrictModeCompat;
	}

	public boolean hasDisableStrictModeCompat() {
		return this._disableStrictModeCompat != null;
	}

	public FadeElement removeDisableStrictModeCompat() {
		this._disableStrictModeCompat = null;
		return this;
	} 

	public FadeElement setId(Object value) {
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

	public FadeElement removeId() {
		this._id = null;
		return this;
	} 

	public FadeElement setIn(Object value) {
		this._in = value;
		return this;
	}

	public Object getIn() {
		return this._in;
	}

	public Object getIn(Object defaultValue) {
		return this._in == null ? defaultValue : this._in;
	}

	public boolean hasIn() {
		return this._in != null;
	}

	public FadeElement removeIn() {
		this._in = null;
		return this;
	} 

	public FadeElement setKey(Object value) {
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

	public FadeElement removeKey() {
		this._key = null;
		return this;
	} 

	public FadeElement setStyle(Object value) {
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

	public FadeElement removeStyle() {
		this._style = null;
		return this;
	} 

	public FadeElement setTimeout(Object value) {
		this._timeout = value;
		return this;
	}

	public Object getTimeout() {
		return this._timeout;
	}

	public Object getTimeout(Object defaultValue) {
		return this._timeout == null ? defaultValue : this._timeout;
	}

	public boolean hasTimeout() {
		return this._timeout != null;
	}

	public FadeElement removeTimeout() {
		this._timeout = null;
		return this;
	} 

	public FadeElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public FadeElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FadeElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public FadeElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public FadeElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public FadeElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public FadeElement addAttribute(FadeElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<FadeElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(FadeElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(FadeElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(FadeElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class FadeElement_Attribute {

		Object _name;
		Object _value;

		public FadeElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private FadeElement_Attribute(java.util.Map<String, Object> map) {
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
		FadeElement that = (FadeElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FadeElement(className,disableStrictModeCompat,id,in,key,style,timeout,attribute,children) ::= <<<Fade~if(className)~\n" + 
				"	className=~className~~endif~~if(disableStrictModeCompat)~\n" + 
				"	disableStrictModeCompat~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(in)~\n" + 
				"	in~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(timeout)~\n" + 
				"	timeout=~timeout~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Fade>~else~ />~endif~ >>";
}  