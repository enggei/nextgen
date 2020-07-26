package nextgen.templates.materialui;

public class ContainerElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _disableGutters;
	private Object _fixed;
	private Object _maxWidth;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	ContainerElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ContainerElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("disableGutters", _disableGutters);
		st.add("fixed", _fixed);
		st.add("maxWidth", _maxWidth);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public ContainerElement setClasses(Object value) {
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

	public ContainerElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ContainerElement setClassName(Object value) {
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

	public ContainerElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ContainerElement setComponent(Object value) {
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

	public ContainerElement removeComponent() {
		this._component = null;
		return this;
	} 

	public ContainerElement setDisableGutters(Object value) {
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

	public ContainerElement removeDisableGutters() {
		this._disableGutters = null;
		return this;
	} 

	public ContainerElement setFixed(Object value) {
		this._fixed = value;
		return this;
	}

	public Object getFixed() {
		return this._fixed;
	}

	public Object getFixed(Object defaultValue) {
		return this._fixed == null ? defaultValue : this._fixed;
	}

	public boolean hasFixed() {
		return this._fixed != null;
	}

	public ContainerElement removeFixed() {
		this._fixed = null;
		return this;
	} 

	public ContainerElement setMaxWidth(Object value) {
		this._maxWidth = value;
		return this;
	}

	public Object getMaxWidth() {
		return this._maxWidth;
	}

	public Object getMaxWidth(Object defaultValue) {
		return this._maxWidth == null ? defaultValue : this._maxWidth;
	}

	public boolean hasMaxWidth() {
		return this._maxWidth != null;
	}

	public ContainerElement removeMaxWidth() {
		this._maxWidth = null;
		return this;
	} 

	public ContainerElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ContainerElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ContainerElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ContainerElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ContainerElement removeChildren(int index) {
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
		ContainerElement that = (ContainerElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ContainerElement(classes,className,component,disableGutters,fixed,maxWidth,children) ::= <<<Container~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disableGutters)~\n" + 
				"	disableGutters~endif~~if(fixed)~\n" + 
				"	fixed~endif~~if(maxWidth)~\n" + 
				"	maxWidth=\"~maxWidth~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Container>~else~ />~endif~ >>";
}  