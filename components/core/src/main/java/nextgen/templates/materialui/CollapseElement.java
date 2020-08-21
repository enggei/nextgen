package nextgen.templates.materialui;

public class CollapseElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _collapsedHeight;
	private Object _component;
	private Object _disableStrictModeCompat;
	private Object _id;
	private Object _in;
	private Object _style;
	private Object _timeout;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	CollapseElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CollapseElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("collapsedHeight", _collapsedHeight);
		st.add("component", _component);
		st.add("disableStrictModeCompat", _disableStrictModeCompat);
		st.add("id", _id);
		st.add("in", _in);
		st.add("style", _style);
		st.add("timeout", _timeout);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public CollapseElement setClasses(Object value) {
		this._classes = value;
		return this;
	}

	public Object getClasses() {
		return this._classes;
	}

	public Object getClasses(Object defaultValue) {
		return this._classes == null ? defaultValue : this._classes;
	}

	public boolean hasClasses() {
		return this._classes != null;
	}

	public CollapseElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public CollapseElement setClassName(Object value) {
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

	public CollapseElement removeClassName() {
		this._className = null;
		return this;
	} 

	public CollapseElement setCollapsedHeight(Object value) {
		this._collapsedHeight = value;
		return this;
	}

	public Object getCollapsedHeight() {
		return this._collapsedHeight;
	}

	public Object getCollapsedHeight(Object defaultValue) {
		return this._collapsedHeight == null ? defaultValue : this._collapsedHeight;
	}

	public boolean hasCollapsedHeight() {
		return this._collapsedHeight != null;
	}

	public CollapseElement removeCollapsedHeight() {
		this._collapsedHeight = null;
		return this;
	} 

	public CollapseElement setComponent(Object value) {
		this._component = value;
		return this;
	}

	public Object getComponent() {
		return this._component;
	}

	public Object getComponent(Object defaultValue) {
		return this._component == null ? defaultValue : this._component;
	}

	public boolean hasComponent() {
		return this._component != null;
	}

	public CollapseElement removeComponent() {
		this._component = null;
		return this;
	} 

	public CollapseElement setDisableStrictModeCompat(Object value) {
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

	public CollapseElement removeDisableStrictModeCompat() {
		this._disableStrictModeCompat = null;
		return this;
	} 

	public CollapseElement setId(Object value) {
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

	public CollapseElement removeId() {
		this._id = null;
		return this;
	} 

	public CollapseElement setIn(Object value) {
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

	public CollapseElement removeIn() {
		this._in = null;
		return this;
	} 

	public CollapseElement setStyle(Object value) {
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

	public CollapseElement removeStyle() {
		this._style = null;
		return this;
	} 

	public CollapseElement setTimeout(Object value) {
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

	public CollapseElement removeTimeout() {
		this._timeout = null;
		return this;
	} 

	public CollapseElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public CollapseElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CollapseElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public CollapseElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public CollapseElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public CollapseElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public CollapseElement addAttribute(CollapseElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<CollapseElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(CollapseElement_Attribute::new);
	}

	public static final class CollapseElement_Attribute {

		Object _name;
		Object _value;

		public CollapseElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private CollapseElement_Attribute(java.util.Map<String, Object> map) {
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
		CollapseElement that = (CollapseElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CollapseElement(classes,className,collapsedHeight,component,disableStrictModeCompat,id,in,style,timeout,attribute,children) ::= <<<Collapse~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(collapsedHeight)~\n" + 
				"	collapsedHeight=~collapsedHeight~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disableStrictModeCompat)~\n" + 
				"	disableStrictModeCompat~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(in)~\n" + 
				"	in~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(timeout)~\n" + 
				"	timeout=\"~timeout~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Collapse>~else~ />~endif~ >>";
}  