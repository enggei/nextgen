package nextgen.templates.materialui;

public class ToolbarElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _disableGutters;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	ToolbarElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ToolbarElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("disableGutters", _disableGutters);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public ToolbarElement setClasses(Object value) {
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

	public ToolbarElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ToolbarElement setClassName(Object value) {
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

	public ToolbarElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ToolbarElement setComponent(Object value) {
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

	public ToolbarElement removeComponent() {
		this._component = null;
		return this;
	} 

	public ToolbarElement setDisableGutters(Object value) {
		this._disableGutters = value;
		return this;
	}

	public Object getDisableGutters() {
		return this._disableGutters;
	}

	public Object getDisableGutters(Object defaultValue) {
		return this._disableGutters == null ? defaultValue : this._disableGutters;
	}

	public boolean hasDisableGutters() {
		return this._disableGutters != null;
	}

	public ToolbarElement removeDisableGutters() {
		this._disableGutters = null;
		return this;
	} 

	public ToolbarElement setVariant(Object value) {
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

	public ToolbarElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public ToolbarElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ToolbarElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ToolbarElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ToolbarElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ToolbarElement removeChildren(int index) {
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
		ToolbarElement that = (ToolbarElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ToolbarElement(classes,className,component,disableGutters,variant,children) ::= <<<Toolbar~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disableGutters)~\n" + 
				"	disableGutters~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Toolbar>~else~ />~endif~ >>";
}  