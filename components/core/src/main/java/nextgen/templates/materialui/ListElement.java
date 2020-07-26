package nextgen.templates.materialui;

public class ListElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _dense;
	private Object _disablePadding;
	private Object _subheader;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	ListElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ListElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("dense", _dense);
		st.add("disablePadding", _disablePadding);
		st.add("subheader", _subheader);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public ListElement setClasses(Object value) {
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

	public ListElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ListElement setClassName(Object value) {
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

	public ListElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ListElement setComponent(Object value) {
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

	public ListElement removeComponent() {
		this._component = null;
		return this;
	} 

	public ListElement setDense(Object value) {
		this._dense = value;
		return this;
	}

	public Object getDense() {
		return this._dense;
	}

	public Object getDense(Object defaultValue) {
		return this._dense == null ? defaultValue : this._dense;
	}

	public boolean hasDense() {
		return this._dense != null;
	}

	public ListElement removeDense() {
		this._dense = null;
		return this;
	} 

	public ListElement setDisablePadding(Object value) {
		this._disablePadding = value;
		return this;
	}

	public Object getDisablePadding() {
		return this._disablePadding;
	}

	public Object getDisablePadding(Object defaultValue) {
		return this._disablePadding == null ? defaultValue : this._disablePadding;
	}

	public boolean hasDisablePadding() {
		return this._disablePadding != null;
	}

	public ListElement removeDisablePadding() {
		this._disablePadding = null;
		return this;
	} 

	public ListElement setSubheader(Object value) {
		this._subheader = value;
		return this;
	}

	public Object getSubheader() {
		return this._subheader;
	}

	public Object getSubheader(Object defaultValue) {
		return this._subheader == null ? defaultValue : this._subheader;
	}

	public boolean hasSubheader() {
		return this._subheader != null;
	}

	public ListElement removeSubheader() {
		this._subheader = null;
		return this;
	} 

	public ListElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ListElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ListElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ListElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ListElement removeChildren(int index) {
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
		ListElement that = (ListElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ListElement(classes,className,component,dense,disablePadding,subheader,children) ::= <<<List~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(dense)~\n" + 
				"	dense~endif~~if(disablePadding)~\n" + 
				"	disablePadding~endif~~if(subheader)~\n" + 
				"	subheader=~subheader~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</List>~else~ />~endif~ >>";
}  