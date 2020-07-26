package nextgen.templates.materialui;

public class ButtonGroupElement {

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
	private Object _fullWidth;
	private Object _orientation;
	private Object _size;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	ButtonGroupElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ButtonGroupElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("disabled", _disabled);
		st.add("disableElevation", _disableElevation);
		st.add("disableFocusRipple", _disableFocusRipple);
		st.add("disableRipple", _disableRipple);
		st.add("fullWidth", _fullWidth);
		st.add("orientation", _orientation);
		st.add("size", _size);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public ButtonGroupElement setClasses(Object value) {
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

	public ButtonGroupElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ButtonGroupElement setClassName(Object value) {
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

	public ButtonGroupElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ButtonGroupElement setColor(Object value) {
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

	public ButtonGroupElement removeColor() {
		this._color = null;
		return this;
	} 

	public ButtonGroupElement setComponent(Object value) {
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

	public ButtonGroupElement removeComponent() {
		this._component = null;
		return this;
	} 

	public ButtonGroupElement setDisabled(Object value) {
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

	public ButtonGroupElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public ButtonGroupElement setDisableElevation(Object value) {
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

	public ButtonGroupElement removeDisableElevation() {
		this._disableElevation = null;
		return this;
	} 

	public ButtonGroupElement setDisableFocusRipple(Object value) {
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

	public ButtonGroupElement removeDisableFocusRipple() {
		this._disableFocusRipple = null;
		return this;
	} 

	public ButtonGroupElement setDisableRipple(Object value) {
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

	public ButtonGroupElement removeDisableRipple() {
		this._disableRipple = null;
		return this;
	} 

	public ButtonGroupElement setFullWidth(Object value) {
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

	public ButtonGroupElement removeFullWidth() {
		this._fullWidth = null;
		return this;
	} 

	public ButtonGroupElement setOrientation(Object value) {
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

	public ButtonGroupElement removeOrientation() {
		this._orientation = null;
		return this;
	} 

	public ButtonGroupElement setSize(Object value) {
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

	public ButtonGroupElement removeSize() {
		this._size = null;
		return this;
	} 

	public ButtonGroupElement setVariant(Object value) {
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

	public ButtonGroupElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public ButtonGroupElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ButtonGroupElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ButtonGroupElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ButtonGroupElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ButtonGroupElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ButtonGroupElement that = (ButtonGroupElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ButtonGroupElement(classes,className,color,component,disabled,disableElevation,disableFocusRipple,disableRipple,fullWidth,orientation,size,variant,children) ::= <<<ButtonGroup~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disableElevation)~\n" + 
				"	disableElevation~endif~~if(disableFocusRipple)~\n" + 
				"	disableFocusRipple~endif~~if(disableRipple)~\n" + 
				"	disableRipple~endif~~if(fullWidth)~\n" + 
				"	fullWidth~endif~~if(orientation)~\n" + 
				"	orientation=\"~orientation~\"~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ButtonGroup>~else~ />~endif~ >>";
}  