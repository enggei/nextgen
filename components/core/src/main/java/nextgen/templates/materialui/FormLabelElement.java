package nextgen.templates.materialui;

public class FormLabelElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _disabled;
	private Object _error;
	private Object _filled;
	private Object _focused;
	private Object _required;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	FormLabelElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FormLabelElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("disabled", _disabled);
		st.add("error", _error);
		st.add("filled", _filled);
		st.add("focused", _focused);
		st.add("required", _required);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public FormLabelElement setClasses(Object value) {
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

	public FormLabelElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public FormLabelElement setClassName(Object value) {
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

	public FormLabelElement removeClassName() {
		this._className = null;
		return this;
	} 

	public FormLabelElement setColor(Object value) {
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

	public FormLabelElement removeColor() {
		this._color = null;
		return this;
	} 

	public FormLabelElement setComponent(Object value) {
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

	public FormLabelElement removeComponent() {
		this._component = null;
		return this;
	} 

	public FormLabelElement setDisabled(Object value) {
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

	public FormLabelElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public FormLabelElement setError(Object value) {
		this._error = value;
		return this;
	}

	public Object getError() {
		return this._error;
	}

	public Object getError(Object defaultValue) {
		return this._error == null ? defaultValue : this._error;
	}

	public boolean hasError() {
		return this._error != null;
	}

	public FormLabelElement removeError() {
		this._error = null;
		return this;
	} 

	public FormLabelElement setFilled(Object value) {
		this._filled = value;
		return this;
	}

	public Object getFilled() {
		return this._filled;
	}

	public Object getFilled(Object defaultValue) {
		return this._filled == null ? defaultValue : this._filled;
	}

	public boolean hasFilled() {
		return this._filled != null;
	}

	public FormLabelElement removeFilled() {
		this._filled = null;
		return this;
	} 

	public FormLabelElement setFocused(Object value) {
		this._focused = value;
		return this;
	}

	public Object getFocused() {
		return this._focused;
	}

	public Object getFocused(Object defaultValue) {
		return this._focused == null ? defaultValue : this._focused;
	}

	public boolean hasFocused() {
		return this._focused != null;
	}

	public FormLabelElement removeFocused() {
		this._focused = null;
		return this;
	} 

	public FormLabelElement setRequired(Object value) {
		this._required = value;
		return this;
	}

	public Object getRequired() {
		return this._required;
	}

	public Object getRequired(Object defaultValue) {
		return this._required == null ? defaultValue : this._required;
	}

	public boolean hasRequired() {
		return this._required != null;
	}

	public FormLabelElement removeRequired() {
		this._required = null;
		return this;
	} 

	public FormLabelElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public FormLabelElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FormLabelElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public FormLabelElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public FormLabelElement removeChildren(int index) {
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
		FormLabelElement that = (FormLabelElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FormLabelElement(classes,className,color,component,disabled,error,filled,focused,required,children) ::= <<<FormLabel~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(error)~\n" + 
				"	error~endif~~if(filled)~\n" + 
				"	filled~endif~~if(focused)~\n" + 
				"	focused~endif~~if(required)~\n" + 
				"	required~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</FormLabel>~else~ />~endif~ >>";
}  