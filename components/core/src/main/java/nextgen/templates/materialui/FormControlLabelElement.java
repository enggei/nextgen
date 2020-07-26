package nextgen.templates.materialui;

public class FormControlLabelElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _checked;
	private Object _classes;
	private Object _className;
	private Object _control;
	private Object _disabled;
	private Object _inputRef;
	private Object _label;
	private Object _labelPlacement;
	private Object _onChange;
	private Object _value;

	FormControlLabelElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
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
		st.add("inputRef", _inputRef);
		st.add("label", _label);
		st.add("labelPlacement", _labelPlacement);
		st.add("onChange", _onChange);
		st.add("value", _value);
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

	static final String st = "FormControlLabelElement(checked,classes,className,control,disabled,inputRef,label,labelPlacement,onChange,value) ::= <<<FormControlLabel~if(checked)~\n" + 
				"	checked~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~\n" + 
				"	control=~control~~if(disabled)~\n" + 
				"	disabled~endif~~if(inputRef)~\n" + 
				"	inputRef=~inputRef~~endif~~if(label)~\n" + 
				"	label=~label~~endif~~if(labelPlacement)~\n" + 
				"	labelPlacement=\"~labelPlacement~\"~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(value)~\n" + 
				"	value=~value~~endif~ /> >>";
}  