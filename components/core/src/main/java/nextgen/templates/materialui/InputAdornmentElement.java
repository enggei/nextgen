package nextgen.templates.materialui;

public class InputAdornmentElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _disablePointerEvents;
	private Object _disableTypography;
	private Object _id;
	private Object _position;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	InputAdornmentElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("InputAdornmentElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("disablePointerEvents", _disablePointerEvents);
		st.add("disableTypography", _disableTypography);
		st.add("id", _id);
		st.add("position", _position);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public InputAdornmentElement setClasses(Object value) {
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

	public InputAdornmentElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public InputAdornmentElement setClassName(Object value) {
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

	public InputAdornmentElement removeClassName() {
		this._className = null;
		return this;
	} 

	public InputAdornmentElement setComponent(Object value) {
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

	public InputAdornmentElement removeComponent() {
		this._component = null;
		return this;
	} 

	public InputAdornmentElement setDisablePointerEvents(Object value) {
		this._disablePointerEvents = value;
		return this;
	}

	public Object getDisablePointerEvents() {
		return this._disablePointerEvents;
	}

	public Object getDisablePointerEvents(Object defaultValue) {
		return this._disablePointerEvents == null ? defaultValue : this._disablePointerEvents;
	}

	public boolean hasDisablePointerEvents() {
		return this._disablePointerEvents != null;
	}

	public InputAdornmentElement removeDisablePointerEvents() {
		this._disablePointerEvents = null;
		return this;
	} 

	public InputAdornmentElement setDisableTypography(Object value) {
		this._disableTypography = value;
		return this;
	}

	public Object getDisableTypography() {
		return this._disableTypography;
	}

	public Object getDisableTypography(Object defaultValue) {
		return this._disableTypography == null ? defaultValue : this._disableTypography;
	}

	public boolean hasDisableTypography() {
		return this._disableTypography != null;
	}

	public InputAdornmentElement removeDisableTypography() {
		this._disableTypography = null;
		return this;
	} 

	public InputAdornmentElement setId(Object value) {
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

	public InputAdornmentElement removeId() {
		this._id = null;
		return this;
	} 

	public InputAdornmentElement setPosition(Object value) {
		this._position = value;
		return this;
	}

	public Object getPosition() {
		return this._position;
	}

	public Object getPosition(Object defaultValue) {
		return this._position == null ? defaultValue : this._position;
	}

	public boolean hasPosition() {
		return this._position != null;
	}

	public InputAdornmentElement removePosition() {
		this._position = null;
		return this;
	} 

	public InputAdornmentElement setVariant(Object value) {
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

	public InputAdornmentElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public InputAdornmentElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public InputAdornmentElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public InputAdornmentElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public InputAdornmentElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public InputAdornmentElement removeChildren(int index) {
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
		InputAdornmentElement that = (InputAdornmentElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "InputAdornmentElement(classes,className,component,disablePointerEvents,disableTypography,id,position,variant,children) ::= <<<InputAdornment~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disablePointerEvents)~\n" + 
				"	disablePointerEvents~endif~~if(disableTypography)~\n" + 
				"	disableTypography~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(position)~\n" + 
				"	position=\"~position~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</InputAdornment>~else~ />~endif~ >>";
}  