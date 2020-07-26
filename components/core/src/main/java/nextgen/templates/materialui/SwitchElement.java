package nextgen.templates.materialui;

public class SwitchElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _checked;
	private Object _checkedIcon;
	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _disabled;
	private Object _disableRipple;
	private Object _edge;
	private Object _icon;
	private Object _id;
	private Object _inputProps;
	private Object _inputRef;
	private Object _onChange;
	private Object _required;
	private Object _size;
	private Object _value;

	SwitchElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SwitchElement");
		st.add("checked", _checked);
		st.add("checkedIcon", _checkedIcon);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("disabled", _disabled);
		st.add("disableRipple", _disableRipple);
		st.add("edge", _edge);
		st.add("icon", _icon);
		st.add("id", _id);
		st.add("inputProps", _inputProps);
		st.add("inputRef", _inputRef);
		st.add("onChange", _onChange);
		st.add("required", _required);
		st.add("size", _size);
		st.add("value", _value);
		return st.render().trim();
	}

	public SwitchElement setChecked(Object value) {
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

	public SwitchElement removeChecked() {
		this._checked = null;
		return this;
	} 

	public SwitchElement setCheckedIcon(Object value) {
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

	public SwitchElement removeCheckedIcon() {
		this._checkedIcon = null;
		return this;
	} 

	public SwitchElement setClasses(Object value) {
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

	public SwitchElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SwitchElement setClassName(Object value) {
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

	public SwitchElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SwitchElement setColor(Object value) {
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

	public SwitchElement removeColor() {
		this._color = null;
		return this;
	} 

	public SwitchElement setDisabled(Object value) {
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

	public SwitchElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public SwitchElement setDisableRipple(Object value) {
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

	public SwitchElement removeDisableRipple() {
		this._disableRipple = null;
		return this;
	} 

	public SwitchElement setEdge(Object value) {
		this._edge = value;
		return this;
	}

	public Object getEdge() {
		return this._edge;
	}

	public Object getEdge(Object defaultValue) {
		return this._edge == null ? defaultValue : this._edge;
	}

	public boolean hasEdge() {
		return this._edge != null;
	}

	public SwitchElement removeEdge() {
		this._edge = null;
		return this;
	} 

	public SwitchElement setIcon(Object value) {
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

	public SwitchElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public SwitchElement setId(Object value) {
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

	public SwitchElement removeId() {
		this._id = null;
		return this;
	} 

	public SwitchElement setInputProps(Object value) {
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

	public SwitchElement removeInputProps() {
		this._inputProps = null;
		return this;
	} 

	public SwitchElement setInputRef(Object value) {
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

	public SwitchElement removeInputRef() {
		this._inputRef = null;
		return this;
	} 

	public SwitchElement setOnChange(Object value) {
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

	public SwitchElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public SwitchElement setRequired(Object value) {
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

	public SwitchElement removeRequired() {
		this._required = null;
		return this;
	} 

	public SwitchElement setSize(Object value) {
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

	public SwitchElement removeSize() {
		this._size = null;
		return this;
	} 

	public SwitchElement setValue(Object value) {
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

	public SwitchElement removeValue() {
		this._value = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SwitchElement that = (SwitchElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SwitchElement(checked,checkedIcon,classes,className,color,disabled,disableRipple,edge,icon,id,inputProps,inputRef,onChange,required,size,value) ::= <<<Switch~if(checked)~\n" + 
				"	checked~endif~~if(checkedIcon)~\n" + 
				"	checkedIcon=~checkedIcon~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disableRipple)~\n" + 
				"	disableRipple~endif~~if(edge)~\n" + 
				"	edge=\"~edge~\"~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(inputProps)~\n" + 
				"	inputProps=~inputProps~~endif~~if(inputRef)~\n" + 
				"	inputRef=~inputRef~~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(required)~\n" + 
				"	required~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(value)~\n" + 
				"	value=~value~~endif~ /> >>";
}  