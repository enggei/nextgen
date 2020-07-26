package nextgen.templates.materialui;

public class BottomNavigationElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _onChange;
	private Object _showLabels;
	private Object _value;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	BottomNavigationElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BottomNavigationElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("onChange", _onChange);
		st.add("showLabels", _showLabels);
		st.add("value", _value);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public BottomNavigationElement setClasses(Object value) {
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

	public BottomNavigationElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public BottomNavigationElement setClassName(Object value) {
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

	public BottomNavigationElement removeClassName() {
		this._className = null;
		return this;
	} 

	public BottomNavigationElement setComponent(Object value) {
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

	public BottomNavigationElement removeComponent() {
		this._component = null;
		return this;
	} 

	public BottomNavigationElement setOnChange(Object value) {
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

	public BottomNavigationElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public BottomNavigationElement setShowLabels(Object value) {
		this._showLabels = value;
		return this;
	}

	public Object getShowLabels() {
		return this._showLabels;
	}

	public Object getShowLabels(Object defaultValue) {
		return this._showLabels == null ? defaultValue : this._showLabels;
	}

	public boolean hasShowLabels() {
		return this._showLabels != null;
	}

	public BottomNavigationElement removeShowLabels() {
		this._showLabels = null;
		return this;
	} 

	public BottomNavigationElement setValue(Object value) {
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

	public BottomNavigationElement removeValue() {
		this._value = null;
		return this;
	} 

	public BottomNavigationElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public BottomNavigationElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BottomNavigationElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public BottomNavigationElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public BottomNavigationElement removeChildren(int index) {
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
		BottomNavigationElement that = (BottomNavigationElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BottomNavigationElement(classes,className,component,onChange,showLabels,value,children) ::= <<<BottomNavigation~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(showLabels)~\n" + 
				"	showLabels~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</BottomNavigation>~else~ />~endif~ >>";
}  