package nextgen.templates.materialui;

public class TabElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _disabled;
	private Object _disableFocusRipple;
	private Object _disableRipple;
	private Object _icon;
	private Object _id;
	private Object _label;
	private Object _value;
	private Object _wrapped;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	TabElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TabElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("disabled", _disabled);
		st.add("disableFocusRipple", _disableFocusRipple);
		st.add("disableRipple", _disableRipple);
		st.add("icon", _icon);
		st.add("id", _id);
		st.add("label", _label);
		st.add("value", _value);
		st.add("wrapped", _wrapped);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public TabElement setClasses(Object value) {
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

	public TabElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TabElement setClassName(Object value) {
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

	public TabElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TabElement setDisabled(Object value) {
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

	public TabElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public TabElement setDisableFocusRipple(Object value) {
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

	public TabElement removeDisableFocusRipple() {
		this._disableFocusRipple = null;
		return this;
	} 

	public TabElement setDisableRipple(Object value) {
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

	public TabElement removeDisableRipple() {
		this._disableRipple = null;
		return this;
	} 

	public TabElement setIcon(Object value) {
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

	public TabElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public TabElement setId(Object value) {
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

	public TabElement removeId() {
		this._id = null;
		return this;
	} 

	public TabElement setLabel(Object value) {
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

	public TabElement removeLabel() {
		this._label = null;
		return this;
	} 

	public TabElement setValue(Object value) {
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

	public TabElement removeValue() {
		this._value = null;
		return this;
	} 

	public TabElement setWrapped(Object value) {
		this._wrapped = value;
		return this;
	}

	public Object getWrapped() {
		return this._wrapped;
	}

	public Object getWrapped(Object defaultValue) {
		return this._wrapped == null ? defaultValue : this._wrapped;
	}

	public boolean hasWrapped() {
		return this._wrapped != null;
	}

	public TabElement removeWrapped() {
		this._wrapped = null;
		return this;
	} 

	public TabElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TabElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TabElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TabElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TabElement removeChildren(int index) {
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
		TabElement that = (TabElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TabElement(classes,className,disabled,disableFocusRipple,disableRipple,icon,id,label,value,wrapped,children) ::= <<<Tab~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disableFocusRipple)~\n" + 
				"	disableFocusRipple~endif~~if(disableRipple)~\n" + 
				"	disableRipple~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(label)~\n" + 
				"	label=~label~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(wrapped)~\n" + 
				"	wrapped~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Tab>~else~ />~endif~ >>";
}  