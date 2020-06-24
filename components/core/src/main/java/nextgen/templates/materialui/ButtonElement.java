package nextgen.templates.materialui;

public class ButtonElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _key;
	private Object _className;
	private Object _color;
	private Object _component;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attributes = new java.util.ArrayList<>();

	ButtonElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ButtonElement");
		st.add("key", _key);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attributes) st.addAggr("attributes.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ButtonElement setKey(Object value) {
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

	public ButtonElement removeKey() {
		this._key = null;
		return this;
	} 

	public ButtonElement setClassName(Object value) {
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

	public ButtonElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ButtonElement setColor(Object value) {
		this._color = value;
		return this;
	}

	public Object getColor() {
		return this._color;
	}

	public Object getColor(Object defaultValue) {
		return this._color == null ? defaultValue : this._color;
	}

	public boolean hasColor() {
		return this._color != null;
	}

	public ButtonElement removeColor() {
		this._color = null;
		return this;
	} 

	public ButtonElement setComponent(Object value) {
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

	public ButtonElement removeComponent() {
		this._component = null;
		return this;
	} 

	public ButtonElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ButtonElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ButtonElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ButtonElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ButtonElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public ButtonElement addAttributes(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attributes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttributes() {
		return this._attributes;
	}

	public ButtonElement addAttributes(ButtonElement_Attributes value) {
		return addAttributes(value._name, value._value);
	}

	public java.util.stream.Stream<ButtonElement_Attributes> streamAttributes() {
		return this._attributes.stream().map(ButtonElement_Attributes::new);
	}

	public static final class ButtonElement_Attributes {

		Object _name;
		Object _value;

		public ButtonElement_Attributes(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ButtonElement_Attributes(java.util.Map<String, Object> map) {
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
		ButtonElement that = (ButtonElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ButtonElement(key,className,color,component,attributes,children) ::= <<<Button~if(key)~ key=~key~~endif~~if(className)~ className={classes.~className~}~endif~~if(color)~ color=\"~color~\"~endif~~if(component)~ component=~component~~endif~~if(attributes)~ ~endif~~attributes:{it|~it.name~~if(it.value)~=~it.value~~endif~};separator=\" \"~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Button> >>";
} 