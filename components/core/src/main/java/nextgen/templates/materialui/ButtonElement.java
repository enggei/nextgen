package nextgen.templates.materialui;

public class ButtonElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _disabled;
	private Object _disableElevation;
	private Object _disableFocusRipple;
	private Object _disableRipple;
	private Object _endIcon;
	private Object _fullWidth;
	private Object _href;
	private Object _id;
	private Object _size;
	private Object _startIcon;
	private Object _style;
	private Object _type;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	ButtonElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ButtonElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("disabled", _disabled);
		st.add("disableElevation", _disableElevation);
		st.add("disableFocusRipple", _disableFocusRipple);
		st.add("disableRipple", _disableRipple);
		st.add("endIcon", _endIcon);
		st.add("fullWidth", _fullWidth);
		st.add("href", _href);
		st.add("id", _id);
		st.add("size", _size);
		st.add("startIcon", _startIcon);
		st.add("style", _style);
		st.add("type", _type);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ButtonElement setClasses(Object value) {
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

	public ButtonElement removeClasses() {
		this._classes = null;
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

	public ButtonElement setDisabled(Object value) {
		this._disabled = value;
		return this;
	}

	public Object getDisabled() {
		return this._disabled;
	}

	public Object getDisabled(Object defaultValue) {
		return this._disabled == null ? defaultValue : this._disabled;
	}

	public boolean hasDisabled() {
		return this._disabled != null;
	}

	public ButtonElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public ButtonElement setDisableElevation(Object value) {
		this._disableElevation = value;
		return this;
	}

	public Object getDisableElevation() {
		return this._disableElevation;
	}

	public Object getDisableElevation(Object defaultValue) {
		return this._disableElevation == null ? defaultValue : this._disableElevation;
	}

	public boolean hasDisableElevation() {
		return this._disableElevation != null;
	}

	public ButtonElement removeDisableElevation() {
		this._disableElevation = null;
		return this;
	} 

	public ButtonElement setDisableFocusRipple(Object value) {
		this._disableFocusRipple = value;
		return this;
	}

	public Object getDisableFocusRipple() {
		return this._disableFocusRipple;
	}

	public Object getDisableFocusRipple(Object defaultValue) {
		return this._disableFocusRipple == null ? defaultValue : this._disableFocusRipple;
	}

	public boolean hasDisableFocusRipple() {
		return this._disableFocusRipple != null;
	}

	public ButtonElement removeDisableFocusRipple() {
		this._disableFocusRipple = null;
		return this;
	} 

	public ButtonElement setDisableRipple(Object value) {
		this._disableRipple = value;
		return this;
	}

	public Object getDisableRipple() {
		return this._disableRipple;
	}

	public Object getDisableRipple(Object defaultValue) {
		return this._disableRipple == null ? defaultValue : this._disableRipple;
	}

	public boolean hasDisableRipple() {
		return this._disableRipple != null;
	}

	public ButtonElement removeDisableRipple() {
		this._disableRipple = null;
		return this;
	} 

	public ButtonElement setEndIcon(Object value) {
		this._endIcon = value;
		return this;
	}

	public Object getEndIcon() {
		return this._endIcon;
	}

	public Object getEndIcon(Object defaultValue) {
		return this._endIcon == null ? defaultValue : this._endIcon;
	}

	public boolean hasEndIcon() {
		return this._endIcon != null;
	}

	public ButtonElement removeEndIcon() {
		this._endIcon = null;
		return this;
	} 

	public ButtonElement setFullWidth(Object value) {
		this._fullWidth = value;
		return this;
	}

	public Object getFullWidth() {
		return this._fullWidth;
	}

	public Object getFullWidth(Object defaultValue) {
		return this._fullWidth == null ? defaultValue : this._fullWidth;
	}

	public boolean hasFullWidth() {
		return this._fullWidth != null;
	}

	public ButtonElement removeFullWidth() {
		this._fullWidth = null;
		return this;
	} 

	public ButtonElement setHref(Object value) {
		this._href = value;
		return this;
	}

	public Object getHref() {
		return this._href;
	}

	public Object getHref(Object defaultValue) {
		return this._href == null ? defaultValue : this._href;
	}

	public boolean hasHref() {
		return this._href != null;
	}

	public ButtonElement removeHref() {
		this._href = null;
		return this;
	} 

	public ButtonElement setId(Object value) {
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

	public ButtonElement removeId() {
		this._id = null;
		return this;
	} 

	public ButtonElement setSize(Object value) {
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

	public ButtonElement removeSize() {
		this._size = null;
		return this;
	} 

	public ButtonElement setStartIcon(Object value) {
		this._startIcon = value;
		return this;
	}

	public Object getStartIcon() {
		return this._startIcon;
	}

	public Object getStartIcon(Object defaultValue) {
		return this._startIcon == null ? defaultValue : this._startIcon;
	}

	public boolean hasStartIcon() {
		return this._startIcon != null;
	}

	public ButtonElement removeStartIcon() {
		this._startIcon = null;
		return this;
	} 

	public ButtonElement setStyle(Object value) {
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

	public ButtonElement removeStyle() {
		this._style = null;
		return this;
	} 

	public ButtonElement setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public ButtonElement removeType() {
		this._type = null;
		return this;
	} 

	public ButtonElement setVariant(Object value) {
		this._variant = value;
		return this;
	}

	public Object getVariant() {
		return this._variant;
	}

	public Object getVariant(Object defaultValue) {
		return this._variant == null ? defaultValue : this._variant;
	}

	public boolean hasVariant() {
		return this._variant != null;
	}

	public ButtonElement removeVariant() {
		this._variant = null;
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

	public ButtonElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public ButtonElement addAttribute(ButtonElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<ButtonElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(ButtonElement_Attribute::new);
	}

	public static final class ButtonElement_Attribute {

		Object _name;
		Object _value;

		public ButtonElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ButtonElement_Attribute(java.util.Map<String, Object> map) {
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

	static final String st = "ButtonElement(classes,className,color,component,disabled,disableElevation,disableFocusRipple,disableRipple,endIcon,fullWidth,href,id,size,startIcon,style,type,variant,attribute,children) ::= <<<Button~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disableElevation)~\n" + 
				"	disableElevation~endif~~if(disableFocusRipple)~\n" + 
				"	disableFocusRipple~endif~~if(disableRipple)~\n" + 
				"	disableRipple~endif~~if(endIcon)~\n" + 
				"	endIcon=~endIcon~~endif~~if(fullWidth)~\n" + 
				"	fullWidth~endif~~if(href)~\n" + 
				"	href=\"~href~\"~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(startIcon)~\n" + 
				"	startIcon=~startIcon~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(type)~\n" + 
				"	type=\"~type~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Button>~else~ />~endif~ >>";
}  