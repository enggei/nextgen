package nextgen.templates.materialui;

public class ToggleButtonGroupElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _exclusive;
	private Object _id;
	private Object _onChange;
	private Object _orientation;
	private Object _size;
	private Object _style;
	private Object _value;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	ToggleButtonGroupElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ToggleButtonGroupElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("exclusive", _exclusive);
		st.add("id", _id);
		st.add("onChange", _onChange);
		st.add("orientation", _orientation);
		st.add("size", _size);
		st.add("style", _style);
		st.add("value", _value);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ToggleButtonGroupElement setClasses(Object value) {
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

	public ToggleButtonGroupElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ToggleButtonGroupElement setClassName(Object value) {
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

	public ToggleButtonGroupElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ToggleButtonGroupElement setExclusive(Object value) {
		this._exclusive = value;
		return this;
	}

	public Object getExclusive() {
		return this._exclusive;
	}

	public Object getExclusive(Object defaultValue) {
		return this._exclusive == null ? defaultValue : this._exclusive;
	}

	public boolean hasExclusive() {
		return this._exclusive != null;
	}

	public ToggleButtonGroupElement removeExclusive() {
		this._exclusive = null;
		return this;
	} 

	public ToggleButtonGroupElement setId(Object value) {
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

	public ToggleButtonGroupElement removeId() {
		this._id = null;
		return this;
	} 

	public ToggleButtonGroupElement setOnChange(Object value) {
		this._onChange = value;
		return this;
	}

	public Object getOnChange() {
		return this._onChange;
	}

	public Object getOnChange(Object defaultValue) {
		return this._onChange == null ? defaultValue : this._onChange;
	}

	public boolean hasOnChange() {
		return this._onChange != null;
	}

	public ToggleButtonGroupElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public ToggleButtonGroupElement setOrientation(Object value) {
		this._orientation = value;
		return this;
	}

	public Object getOrientation() {
		return this._orientation;
	}

	public Object getOrientation(Object defaultValue) {
		return this._orientation == null ? defaultValue : this._orientation;
	}

	public boolean hasOrientation() {
		return this._orientation != null;
	}

	public ToggleButtonGroupElement removeOrientation() {
		this._orientation = null;
		return this;
	} 

	public ToggleButtonGroupElement setSize(Object value) {
		this._size = value;
		return this;
	}

	public Object getSize() {
		return this._size;
	}

	public Object getSize(Object defaultValue) {
		return this._size == null ? defaultValue : this._size;
	}

	public boolean hasSize() {
		return this._size != null;
	}

	public ToggleButtonGroupElement removeSize() {
		this._size = null;
		return this;
	} 

	public ToggleButtonGroupElement setStyle(Object value) {
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

	public ToggleButtonGroupElement removeStyle() {
		this._style = null;
		return this;
	} 

	public ToggleButtonGroupElement setValue(Object value) {
		this._value = value;
		return this;
	}

	public Object getValue() {
		return this._value;
	}

	public Object getValue(Object defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public ToggleButtonGroupElement removeValue() {
		this._value = null;
		return this;
	} 

	public ToggleButtonGroupElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ToggleButtonGroupElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ToggleButtonGroupElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ToggleButtonGroupElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ToggleButtonGroupElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public ToggleButtonGroupElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public ToggleButtonGroupElement addAttribute(ToggleButtonGroupElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<ToggleButtonGroupElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(ToggleButtonGroupElement_Attribute::new);
	}

	public static final class ToggleButtonGroupElement_Attribute {

		Object _name;
		Object _value;

		public ToggleButtonGroupElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ToggleButtonGroupElement_Attribute(java.util.Map<String, Object> map) {
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
		ToggleButtonGroupElement that = (ToggleButtonGroupElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ToggleButtonGroupElement(classes,className,exclusive,id,onChange,orientation,size,style,value,attribute,children) ::= <<<ToggleButtonGroup~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(exclusive)~\n" + 
				"	exclusive~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(orientation)~\n" + 
				"	orientation=\"~orientation~\"~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ToggleButtonGroup>~else~ />~endif~ >>";
}  