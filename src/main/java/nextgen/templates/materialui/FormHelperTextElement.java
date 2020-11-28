package nextgen.templates.materialui;

public class FormHelperTextElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _disabled;
	private Object _error;
	private Object _filled;
	private Object _focused;
	private Object _id;
	private Object _key;
	private Object _margin;
	private Object _required;
	private Object _style;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	FormHelperTextElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FormHelperTextElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("disabled", _disabled);
		st.add("error", _error);
		st.add("filled", _filled);
		st.add("focused", _focused);
		st.add("id", _id);
		st.add("key", _key);
		st.add("margin", _margin);
		st.add("required", _required);
		st.add("style", _style);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public FormHelperTextElement setClasses(Object value) {
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

	public FormHelperTextElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public FormHelperTextElement setClassName(Object value) {
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

	public FormHelperTextElement removeClassName() {
		this._className = null;
		return this;
	} 

	public FormHelperTextElement setComponent(Object value) {
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

	public FormHelperTextElement removeComponent() {
		this._component = null;
		return this;
	} 

	public FormHelperTextElement setDisabled(Object value) {
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

	public FormHelperTextElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public FormHelperTextElement setError(Object value) {
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

	public FormHelperTextElement removeError() {
		this._error = null;
		return this;
	} 

	public FormHelperTextElement setFilled(Object value) {
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

	public FormHelperTextElement removeFilled() {
		this._filled = null;
		return this;
	} 

	public FormHelperTextElement setFocused(Object value) {
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

	public FormHelperTextElement removeFocused() {
		this._focused = null;
		return this;
	} 

	public FormHelperTextElement setId(Object value) {
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

	public FormHelperTextElement removeId() {
		this._id = null;
		return this;
	} 

	public FormHelperTextElement setKey(Object value) {
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

	public FormHelperTextElement removeKey() {
		this._key = null;
		return this;
	} 

	public FormHelperTextElement setMargin(Object value) {
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

	public FormHelperTextElement removeMargin() {
		this._margin = null;
		return this;
	} 

	public FormHelperTextElement setRequired(Object value) {
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

	public FormHelperTextElement removeRequired() {
		this._required = null;
		return this;
	} 

	public FormHelperTextElement setStyle(Object value) {
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

	public FormHelperTextElement removeStyle() {
		this._style = null;
		return this;
	} 

	public FormHelperTextElement setVariant(Object value) {
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

	public FormHelperTextElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public FormHelperTextElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public FormHelperTextElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FormHelperTextElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public FormHelperTextElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public FormHelperTextElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public FormHelperTextElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public FormHelperTextElement addAttribute(FormHelperTextElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<FormHelperTextElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(FormHelperTextElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(FormHelperTextElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(FormHelperTextElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class FormHelperTextElement_Attribute {

		Object _name;
		Object _value;

		public FormHelperTextElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private FormHelperTextElement_Attribute(java.util.Map<String, Object> map) {
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
		FormHelperTextElement that = (FormHelperTextElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FormHelperTextElement(classes,className,component,disabled,error,filled,focused,id,key,margin,required,style,variant,attribute,children) ::= <<<FormHelperText~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(error)~\n" + 
				"	error~endif~~if(filled)~\n" + 
				"	filled~endif~~if(focused)~\n" + 
				"	focused~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(margin)~\n" + 
				"	margin=\"~margin~\"~endif~~if(required)~\n" + 
				"	required~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</FormHelperText>~else~ />~endif~ >>";
}  