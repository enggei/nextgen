package nextgen.templates.materialui;

public class NativeSelectElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _IconComponent;
	private Object _id;
	private Object _input;
	private Object _inputProps;
	private Object _onChange;
	private Object _style;
	private Object _value;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	NativeSelectElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NativeSelectElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("IconComponent", _IconComponent);
		st.add("id", _id);
		st.add("input", _input);
		st.add("inputProps", _inputProps);
		st.add("onChange", _onChange);
		st.add("style", _style);
		st.add("value", _value);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public NativeSelectElement setClasses(Object value) {
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

	public NativeSelectElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public NativeSelectElement setClassName(Object value) {
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

	public NativeSelectElement removeClassName() {
		this._className = null;
		return this;
	} 

	public NativeSelectElement setIconComponent(Object value) {
		this._IconComponent = value;
		return this;
	}

	public Object getIconComponent() {
		return this._IconComponent;
	}

	public Object getIconComponent(Object defaultValue) {
		return this._IconComponent == null ? defaultValue : this._IconComponent;
	}

	public boolean hasIconComponent() {
		return this._IconComponent != null;
	}

	public NativeSelectElement removeIconComponent() {
		this._IconComponent = null;
		return this;
	} 

	public NativeSelectElement setId(Object value) {
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

	public NativeSelectElement removeId() {
		this._id = null;
		return this;
	} 

	public NativeSelectElement setInput(Object value) {
		this._input = value;
		return this;
	}

	public Object getInput() {
		return this._input;
	}

	public Object getInput(Object defaultValue) {
		return this._input == null ? defaultValue : this._input;
	}

	public boolean hasInput() {
		return this._input != null;
	}

	public NativeSelectElement removeInput() {
		this._input = null;
		return this;
	} 

	public NativeSelectElement setInputProps(Object value) {
		this._inputProps = value;
		return this;
	}

	public Object getInputProps() {
		return this._inputProps;
	}

	public Object getInputProps(Object defaultValue) {
		return this._inputProps == null ? defaultValue : this._inputProps;
	}

	public boolean hasInputProps() {
		return this._inputProps != null;
	}

	public NativeSelectElement removeInputProps() {
		this._inputProps = null;
		return this;
	} 

	public NativeSelectElement setOnChange(Object value) {
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

	public NativeSelectElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public NativeSelectElement setStyle(Object value) {
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

	public NativeSelectElement removeStyle() {
		this._style = null;
		return this;
	} 

	public NativeSelectElement setValue(Object value) {
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

	public NativeSelectElement removeValue() {
		this._value = null;
		return this;
	} 

	public NativeSelectElement setVariant(Object value) {
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

	public NativeSelectElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public NativeSelectElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public NativeSelectElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NativeSelectElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public NativeSelectElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public NativeSelectElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public NativeSelectElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public NativeSelectElement addAttribute(NativeSelectElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<NativeSelectElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(NativeSelectElement_Attribute::new);
	}

	public static final class NativeSelectElement_Attribute {

		Object _name;
		Object _value;

		public NativeSelectElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private NativeSelectElement_Attribute(java.util.Map<String, Object> map) {
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
		NativeSelectElement that = (NativeSelectElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NativeSelectElement(classes,className,IconComponent,id,input,inputProps,onChange,style,value,variant,attribute,children) ::= <<<NativeSelect~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(IconComponent)~\n" + 
				"	IconComponent=~IconComponent~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(input)~\n" + 
				"	input=~input~~endif~~if(inputProps)~\n" + 
				"	inputProps=~inputProps~~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</NativeSelect>~else~ />~endif~ >>";
}  