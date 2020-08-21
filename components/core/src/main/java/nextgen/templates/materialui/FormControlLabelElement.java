package nextgen.templates.materialui;

public class FormControlLabelElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _checked;
	private Object _classes;
	private Object _className;
	private Object _control;
	private Object _disabled;
	private Object _id;
	private Object _inputRef;
	private Object _label;
	private Object _labelPlacement;
	private Object _onChange;
	private Object _style;
	private Object _value;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	FormControlLabelElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FormControlLabelElement");
		st.add("checked", _checked);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("control", _control);
		st.add("disabled", _disabled);
		st.add("id", _id);
		st.add("inputRef", _inputRef);
		st.add("label", _label);
		st.add("labelPlacement", _labelPlacement);
		st.add("onChange", _onChange);
		st.add("style", _style);
		st.add("value", _value);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public FormControlLabelElement setChecked(Object value) {
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

	public FormControlLabelElement removeChecked() {
		this._checked = null;
		return this;
	} 

	public FormControlLabelElement setClasses(Object value) {
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

	public FormControlLabelElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public FormControlLabelElement setClassName(Object value) {
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

	public FormControlLabelElement removeClassName() {
		this._className = null;
		return this;
	} 

	public FormControlLabelElement setControl(Object value) {
		this._control = value;
		return this;
	}

	public Object getControl() {
		return this._control;
	}

	public Object getControl(Object defaultValue) {
		return this._control == null ? defaultValue : this._control;
	}

	public boolean hasControl() {
		return this._control != null;
	}

	public FormControlLabelElement removeControl() {
		this._control = null;
		return this;
	} 

	public FormControlLabelElement setDisabled(Object value) {
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

	public FormControlLabelElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public FormControlLabelElement setId(Object value) {
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

	public FormControlLabelElement removeId() {
		this._id = null;
		return this;
	} 

	public FormControlLabelElement setInputRef(Object value) {
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

	public FormControlLabelElement removeInputRef() {
		this._inputRef = null;
		return this;
	} 

	public FormControlLabelElement setLabel(Object value) {
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

	public FormControlLabelElement removeLabel() {
		this._label = null;
		return this;
	} 

	public FormControlLabelElement setLabelPlacement(Object value) {
		this._labelPlacement = value;
		return this;
	}

	public Object getLabelPlacement() {
		return this._labelPlacement;
	}

	public Object getLabelPlacement(Object defaultValue) {
		return this._labelPlacement == null ? defaultValue : this._labelPlacement;
	}

	public boolean hasLabelPlacement() {
		return this._labelPlacement != null;
	}

	public FormControlLabelElement removeLabelPlacement() {
		this._labelPlacement = null;
		return this;
	} 

	public FormControlLabelElement setOnChange(Object value) {
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

	public FormControlLabelElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public FormControlLabelElement setStyle(Object value) {
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

	public FormControlLabelElement removeStyle() {
		this._style = null;
		return this;
	} 

	public FormControlLabelElement setValue(Object value) {
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

	public FormControlLabelElement removeValue() {
		this._value = null;
		return this;
	} 


	public FormControlLabelElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public FormControlLabelElement addAttribute(FormControlLabelElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<FormControlLabelElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(FormControlLabelElement_Attribute::new);
	}

	public static final class FormControlLabelElement_Attribute {

		Object _name;
		Object _value;

		public FormControlLabelElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private FormControlLabelElement_Attribute(java.util.Map<String, Object> map) {
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
		FormControlLabelElement that = (FormControlLabelElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FormControlLabelElement(checked,classes,className,control,disabled,id,inputRef,label,labelPlacement,onChange,style,value,attribute) ::= <<<FormControlLabel~if(checked)~\n" + 
				"	checked~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~\n" + 
				"	control=~control~~if(disabled)~\n" + 
				"	disabled~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(inputRef)~\n" + 
				"	inputRef=~inputRef~~endif~~if(label)~\n" + 
				"	label=~label~~endif~~if(labelPlacement)~\n" + 
				"	labelPlacement=\"~labelPlacement~\"~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  