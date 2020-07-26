package nextgen.templates.materialui;

public class FabElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _disabled;
	private Object _disableFocusRipple;
	private Object _disableRipple;
	private Object _href;
	private Object _size;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	FabElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FabElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("disabled", _disabled);
		st.add("disableFocusRipple", _disableFocusRipple);
		st.add("disableRipple", _disableRipple);
		st.add("href", _href);
		st.add("size", _size);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public FabElement setClasses(Object value) {
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

	public FabElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public FabElement setClassName(Object value) {
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

	public FabElement removeClassName() {
		this._className = null;
		return this;
	} 

	public FabElement setColor(Object value) {
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

	public FabElement removeColor() {
		this._color = null;
		return this;
	} 

	public FabElement setComponent(Object value) {
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

	public FabElement removeComponent() {
		this._component = null;
		return this;
	} 

	public FabElement setDisabled(Object value) {
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

	public FabElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public FabElement setDisableFocusRipple(Object value) {
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

	public FabElement removeDisableFocusRipple() {
		this._disableFocusRipple = null;
		return this;
	} 

	public FabElement setDisableRipple(Object value) {
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

	public FabElement removeDisableRipple() {
		this._disableRipple = null;
		return this;
	} 

	public FabElement setHref(Object value) {
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

	public FabElement removeHref() {
		this._href = null;
		return this;
	} 

	public FabElement setSize(Object value) {
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

	public FabElement removeSize() {
		this._size = null;
		return this;
	} 

	public FabElement setVariant(Object value) {
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

	public FabElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public FabElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public FabElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FabElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public FabElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public FabElement removeChildren(int index) {
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
		FabElement that = (FabElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FabElement(classes,className,color,component,disabled,disableFocusRipple,disableRipple,href,size,variant,children) ::= <<<Fab~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disableFocusRipple)~\n" + 
				"	disableFocusRipple~endif~~if(disableRipple)~\n" + 
				"	disableRipple~endif~~if(href)~\n" + 
				"	href=\"~href~\"~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Fab>~else~ />~endif~ >>";
}  