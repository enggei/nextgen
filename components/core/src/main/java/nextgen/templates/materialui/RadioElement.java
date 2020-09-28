package nextgen.templates.materialui;

public class RadioElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _checked;
	private Object _checkedIcon;
	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _disabled;
	private Object _disableRipple;
	private Object _icon;
	private Object _id;
	private Object _inputProps;
	private Object _inputRef;
	private Object _key;
	private Object _name;
	private Object _onChange;
	private Object _required;
	private Object _size;
	private Object _style;
	private Object _value;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	RadioElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RadioElement");
		st.add("checked", _checked);
		st.add("checkedIcon", _checkedIcon);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("disabled", _disabled);
		st.add("disableRipple", _disableRipple);
		st.add("icon", _icon);
		st.add("id", _id);
		st.add("inputProps", _inputProps);
		st.add("inputRef", _inputRef);
		st.add("key", _key);
		st.add("name", _name);
		st.add("onChange", _onChange);
		st.add("required", _required);
		st.add("size", _size);
		st.add("style", _style);
		st.add("value", _value);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public RadioElement setChecked(Object value) {
		this._checked = value;
		return this;
	}

	public Object getChecked() {
		return this._checked;
	}

	public Object getChecked(Object defaultValue) {
		return this._checked == null ? defaultValue : this._checked;
	}

	public boolean hasChecked() {
		return this._checked != null;
	}

	public RadioElement removeChecked() {
		this._checked = null;
		return this;
	} 

	public RadioElement setCheckedIcon(Object value) {
		this._checkedIcon = value;
		return this;
	}

	public Object getCheckedIcon() {
		return this._checkedIcon;
	}

	public Object getCheckedIcon(Object defaultValue) {
		return this._checkedIcon == null ? defaultValue : this._checkedIcon;
	}

	public boolean hasCheckedIcon() {
		return this._checkedIcon != null;
	}

	public RadioElement removeCheckedIcon() {
		this._checkedIcon = null;
		return this;
	} 

	public RadioElement setClasses(Object value) {
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

	public RadioElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public RadioElement setClassName(Object value) {
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

	public RadioElement removeClassName() {
		this._className = null;
		return this;
	} 

	public RadioElement setColor(Object value) {
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

	public RadioElement removeColor() {
		this._color = null;
		return this;
	} 

	public RadioElement setDisabled(Object value) {
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

	public RadioElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public RadioElement setDisableRipple(Object value) {
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

	public RadioElement removeDisableRipple() {
		this._disableRipple = null;
		return this;
	} 

	public RadioElement setIcon(Object value) {
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

	public RadioElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public RadioElement setId(Object value) {
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

	public RadioElement removeId() {
		this._id = null;
		return this;
	} 

	public RadioElement setInputProps(Object value) {
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

	public RadioElement removeInputProps() {
		this._inputProps = null;
		return this;
	} 

	public RadioElement setInputRef(Object value) {
		this._inputRef = value;
		return this;
	}

	public Object getInputRef() {
		return this._inputRef;
	}

	public Object getInputRef(Object defaultValue) {
		return this._inputRef == null ? defaultValue : this._inputRef;
	}

	public boolean hasInputRef() {
		return this._inputRef != null;
	}

	public RadioElement removeInputRef() {
		this._inputRef = null;
		return this;
	} 

	public RadioElement setKey(Object value) {
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

	public RadioElement removeKey() {
		this._key = null;
		return this;
	} 

	public RadioElement setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public RadioElement removeName() {
		this._name = null;
		return this;
	} 

	public RadioElement setOnChange(Object value) {
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

	public RadioElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public RadioElement setRequired(Object value) {
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

	public RadioElement removeRequired() {
		this._required = null;
		return this;
	} 

	public RadioElement setSize(Object value) {
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

	public RadioElement removeSize() {
		this._size = null;
		return this;
	} 

	public RadioElement setStyle(Object value) {
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

	public RadioElement removeStyle() {
		this._style = null;
		return this;
	} 

	public RadioElement setValue(Object value) {
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

	public RadioElement removeValue() {
		this._value = null;
		return this;
	} 


	public RadioElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public RadioElement addAttribute(RadioElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<RadioElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(RadioElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(RadioElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(RadioElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class RadioElement_Attribute {

		Object _name;
		Object _value;

		public RadioElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private RadioElement_Attribute(java.util.Map<String, Object> map) {
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
		RadioElement that = (RadioElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RadioElement(checked,checkedIcon,classes,className,color,disabled,disableRipple,icon,id,inputProps,inputRef,key,name,onChange,required,size,style,value,attribute) ::= <<<Radio~if(checked)~\n" + 
				"	checked~endif~~if(checkedIcon)~\n" + 
				"	checkedIcon=~checkedIcon~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disableRipple)~\n" + 
				"	disableRipple~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(inputProps)~\n" + 
				"	inputProps=~inputProps~~endif~~if(inputRef)~\n" + 
				"	inputRef=~inputRef~~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(name)~\n" + 
				"	name=\"~name~\"~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(required)~\n" + 
				"	required~endif~~if(size)~\n" + 
				"	size=~size~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  