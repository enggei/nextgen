package nextgen.templates.materialui;

public class InputLabelElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _disableAnimation;
	private Object _disabled;
	private Object _error;
	private Object _focused;
	private Object _margin;
	private Object _required;
	private Object _shrink;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	InputLabelElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("InputLabelElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("disableAnimation", _disableAnimation);
		st.add("disabled", _disabled);
		st.add("error", _error);
		st.add("focused", _focused);
		st.add("margin", _margin);
		st.add("required", _required);
		st.add("shrink", _shrink);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public InputLabelElement setClasses(Object value) {
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

	public InputLabelElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public InputLabelElement setClassName(Object value) {
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

	public InputLabelElement removeClassName() {
		this._className = null;
		return this;
	} 

	public InputLabelElement setColor(Object value) {
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

	public InputLabelElement removeColor() {
		this._color = null;
		return this;
	} 

	public InputLabelElement setDisableAnimation(Object value) {
		this._disableAnimation = value;
		return this;
	}

	public Object getDisableAnimation() {
		return this._disableAnimation;
	}

	public Object getDisableAnimation(Object defaultValue) {
		return this._disableAnimation == null ? defaultValue : this._disableAnimation;
	}

	public boolean hasDisableAnimation() {
		return this._disableAnimation != null;
	}

	public InputLabelElement removeDisableAnimation() {
		this._disableAnimation = null;
		return this;
	} 

	public InputLabelElement setDisabled(Object value) {
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

	public InputLabelElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public InputLabelElement setError(Object value) {
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

	public InputLabelElement removeError() {
		this._error = null;
		return this;
	} 

	public InputLabelElement setFocused(Object value) {
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

	public InputLabelElement removeFocused() {
		this._focused = null;
		return this;
	} 

	public InputLabelElement setMargin(Object value) {
		this._margin = value;
		return this;
	}

	public Object getMargin() {
		return this._margin;
	}

	public Object getMargin(Object defaultValue) {
		return this._margin == null ? defaultValue : this._margin;
	}

	public boolean hasMargin() {
		return this._margin != null;
	}

	public InputLabelElement removeMargin() {
		this._margin = null;
		return this;
	} 

	public InputLabelElement setRequired(Object value) {
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

	public InputLabelElement removeRequired() {
		this._required = null;
		return this;
	} 

	public InputLabelElement setShrink(Object value) {
		this._shrink = value;
		return this;
	}

	public Object getShrink() {
		return this._shrink;
	}

	public Object getShrink(Object defaultValue) {
		return this._shrink == null ? defaultValue : this._shrink;
	}

	public boolean hasShrink() {
		return this._shrink != null;
	}

	public InputLabelElement removeShrink() {
		this._shrink = null;
		return this;
	} 

	public InputLabelElement setVariant(Object value) {
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

	public InputLabelElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public InputLabelElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public InputLabelElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public InputLabelElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public InputLabelElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public InputLabelElement removeChildren(int index) {
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
		InputLabelElement that = (InputLabelElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "InputLabelElement(classes,className,color,disableAnimation,disabled,error,focused,margin,required,shrink,variant,children) ::= <<<InputLabel~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(disableAnimation)~\n" + 
				"	disableAnimation~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(error)~\n" + 
				"	error~endif~~if(focused)~\n" + 
				"	focused~endif~~if(margin)~\n" + 
				"	margin=\"~margin~\"~endif~~if(required)~\n" + 
				"	required~endif~~if(shrink)~\n" + 
				"	shrink~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</InputLabel>~else~ />~endif~ >>";
}  