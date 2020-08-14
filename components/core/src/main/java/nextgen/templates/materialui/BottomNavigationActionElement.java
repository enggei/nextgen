package nextgen.templates.materialui;

public class BottomNavigationActionElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _icon;
	private Object _id;
	private Object _label;
	private Object _showLabel;
	private Object _value;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	BottomNavigationActionElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BottomNavigationActionElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("icon", _icon);
		st.add("id", _id);
		st.add("label", _label);
		st.add("showLabel", _showLabel);
		st.add("value", _value);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public BottomNavigationActionElement setClasses(Object value) {
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

	public BottomNavigationActionElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public BottomNavigationActionElement setClassName(Object value) {
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

	public BottomNavigationActionElement removeClassName() {
		this._className = null;
		return this;
	} 

	public BottomNavigationActionElement setIcon(Object value) {
		this._icon = value;
		return this;
	}

	public Object getIcon() {
		return this._icon;
	}

	public Object getIcon(Object defaultValue) {
		return this._icon == null ? defaultValue : this._icon;
	}

	public boolean hasIcon() {
		return this._icon != null;
	}

	public BottomNavigationActionElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public BottomNavigationActionElement setId(Object value) {
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

	public BottomNavigationActionElement removeId() {
		this._id = null;
		return this;
	} 

	public BottomNavigationActionElement setLabel(Object value) {
		this._label = value;
		return this;
	}

	public Object getLabel() {
		return this._label;
	}

	public Object getLabel(Object defaultValue) {
		return this._label == null ? defaultValue : this._label;
	}

	public boolean hasLabel() {
		return this._label != null;
	}

	public BottomNavigationActionElement removeLabel() {
		this._label = null;
		return this;
	} 

	public BottomNavigationActionElement setShowLabel(Object value) {
		this._showLabel = value;
		return this;
	}

	public Object getShowLabel() {
		return this._showLabel;
	}

	public Object getShowLabel(Object defaultValue) {
		return this._showLabel == null ? defaultValue : this._showLabel;
	}

	public boolean hasShowLabel() {
		return this._showLabel != null;
	}

	public BottomNavigationActionElement removeShowLabel() {
		this._showLabel = null;
		return this;
	} 

	public BottomNavigationActionElement setValue(Object value) {
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

	public BottomNavigationActionElement removeValue() {
		this._value = null;
		return this;
	} 

	public BottomNavigationActionElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public BottomNavigationActionElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BottomNavigationActionElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public BottomNavigationActionElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public BottomNavigationActionElement removeChildren(int index) {
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
		BottomNavigationActionElement that = (BottomNavigationActionElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BottomNavigationActionElement(classes,className,icon,id,label,showLabel,value,children) ::= <<<BottomNavigationAction~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(label)~\n" + 
				"	label=~label~~endif~~if(showLabel)~\n" + 
				"	showLabel~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</BottomNavigationAction>~else~ />~endif~ >>";
}  