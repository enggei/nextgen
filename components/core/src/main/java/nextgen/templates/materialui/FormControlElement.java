package nextgen.templates.materialui;

public class FormControlElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _disabled;
	private Object _error;
	private Object _focused;
	private Object _fullWidth;
	private Object _hiddenLabel;
	private Object _id;
	private Object _key;
	private Object _margin;
	private Object _required;
	private Object _size;
	private Object _style;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	FormControlElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FormControlElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("disabled", _disabled);
		st.add("error", _error);
		st.add("focused", _focused);
		st.add("fullWidth", _fullWidth);
		st.add("hiddenLabel", _hiddenLabel);
		st.add("id", _id);
		st.add("key", _key);
		st.add("margin", _margin);
		st.add("required", _required);
		st.add("size", _size);
		st.add("style", _style);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public FormControlElement setClasses(Object value) {
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

	public FormControlElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public FormControlElement setClassName(Object value) {
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

	public FormControlElement removeClassName() {
		this._className = null;
		return this;
	} 

	public FormControlElement setColor(Object value) {
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

	public FormControlElement removeColor() {
		this._color = null;
		return this;
	} 

	public FormControlElement setComponent(Object value) {
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

	public FormControlElement removeComponent() {
		this._component = null;
		return this;
	} 

	public FormControlElement setDisabled(Object value) {
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

	public FormControlElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public FormControlElement setError(Object value) {
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

	public FormControlElement removeError() {
		this._error = null;
		return this;
	} 

	public FormControlElement setFocused(Object value) {
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

	public FormControlElement removeFocused() {
		this._focused = null;
		return this;
	} 

	public FormControlElement setFullWidth(Object value) {
		this._fullWidth = value;
		return this;
	}

	public Object getFullWidth() {
		return this._fullWidth;
	}

	public Object getFullWidth(Object defaultValue) {
		return this._fullWidth == null ? defaultValue : this._fullWidth;
	}

	public boolean hasFullWidth() {
		return this._fullWidth != null;
	}

	public FormControlElement removeFullWidth() {
		this._fullWidth = null;
		return this;
	} 

	public FormControlElement setHiddenLabel(Object value) {
		this._hiddenLabel = value;
		return this;
	}

	public Object getHiddenLabel() {
		return this._hiddenLabel;
	}

	public Object getHiddenLabel(Object defaultValue) {
		return this._hiddenLabel == null ? defaultValue : this._hiddenLabel;
	}

	public boolean hasHiddenLabel() {
		return this._hiddenLabel != null;
	}

	public FormControlElement removeHiddenLabel() {
		this._hiddenLabel = null;
		return this;
	} 

	public FormControlElement setId(Object value) {
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

	public FormControlElement removeId() {
		this._id = null;
		return this;
	} 

	public FormControlElement setKey(Object value) {
		this._key = value;
		return this;
	}

	public Object getKey() {
		return this._key;
	}

	public Object getKey(Object defaultValue) {
		return this._key == null ? defaultValue : this._key;
	}

	public boolean hasKey() {
		return this._key != null;
	}

	public FormControlElement removeKey() {
		this._key = null;
		return this;
	} 

	public FormControlElement setMargin(Object value) {
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

	public FormControlElement removeMargin() {
		this._margin = null;
		return this;
	} 

	public FormControlElement setRequired(Object value) {
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

	public FormControlElement removeRequired() {
		this._required = null;
		return this;
	} 

	public FormControlElement setSize(Object value) {
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

	public FormControlElement removeSize() {
		this._size = null;
		return this;
	} 

	public FormControlElement setStyle(Object value) {
		this._style = value;
		return this;
	}

	public Object getStyle() {
		return this._style;
	}

	public Object getStyle(Object defaultValue) {
		return this._style == null ? defaultValue : this._style;
	}

	public boolean hasStyle() {
		return this._style != null;
	}

	public FormControlElement removeStyle() {
		this._style = null;
		return this;
	} 

	public FormControlElement setVariant(Object value) {
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

	public FormControlElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public FormControlElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public FormControlElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FormControlElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public FormControlElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public FormControlElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public FormControlElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public FormControlElement addAttribute(FormControlElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<FormControlElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(FormControlElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(FormControlElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(FormControlElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class FormControlElement_Attribute {

		Object _name;
		Object _value;

		public FormControlElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private FormControlElement_Attribute(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FormControlElement that = (FormControlElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FormControlElement(classes,className,color,component,disabled,error,focused,fullWidth,hiddenLabel,id,key,margin,required,size,style,variant,attribute,children) ::= <<<FormControl~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(error)~\n" + 
				"	error~endif~~if(focused)~\n" + 
				"	focused~endif~~if(fullWidth)~\n" + 
				"	fullWidth~endif~~if(hiddenLabel)~\n" + 
				"	hiddenLabel~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(margin)~\n" + 
				"	margin=\"~margin~\"~endif~~if(required)~\n" + 
				"	required~endif~~if(size)~\n" + 
				"	size=~size~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</FormControl>~else~ />~endif~ >>";
}  