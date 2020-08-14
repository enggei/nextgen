package nextgen.templates.materialui;

public class InputElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _autoComplete;
	private Object _autoFocus;
	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _defaultValue;
	private Object _disabled;
	private Object _disableUnderline;
	private Object _endAdornment;
	private Object _error;
	private Object _fullWidth;
	private Object _id;
	private Object _inputComponent;
	private Object _inputProps;
	private Object _inputRef;
	private Object _margin;
	private Object _multiline;
	private Object _name;
	private Object _onChange;
	private Object _placeholder;
	private Object _readOnly;
	private Object _required;
	private Object _rows;
	private Object _rowsMax;
	private Object _startAdornment;
	private Object _type;
	private Object _value;

	InputElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("InputElement");
		st.add("autoComplete", _autoComplete);
		st.add("autoFocus", _autoFocus);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("defaultValue", _defaultValue);
		st.add("disabled", _disabled);
		st.add("disableUnderline", _disableUnderline);
		st.add("endAdornment", _endAdornment);
		st.add("error", _error);
		st.add("fullWidth", _fullWidth);
		st.add("id", _id);
		st.add("inputComponent", _inputComponent);
		st.add("inputProps", _inputProps);
		st.add("inputRef", _inputRef);
		st.add("margin", _margin);
		st.add("multiline", _multiline);
		st.add("name", _name);
		st.add("onChange", _onChange);
		st.add("placeholder", _placeholder);
		st.add("readOnly", _readOnly);
		st.add("required", _required);
		st.add("rows", _rows);
		st.add("rowsMax", _rowsMax);
		st.add("startAdornment", _startAdornment);
		st.add("type", _type);
		st.add("value", _value);
		return st.render().trim();
	}

	public InputElement setAutoComplete(Object value) {
		this._autoComplete = value;
		return this;
	}

	public Object getAutoComplete() {
		return this._autoComplete;
	}

	public Object getAutoComplete(Object defaultValue) {
		return this._autoComplete == null ? defaultValue : this._autoComplete;
	}

	public boolean hasAutoComplete() {
		return this._autoComplete != null;
	}

	public InputElement removeAutoComplete() {
		this._autoComplete = null;
		return this;
	} 

	public InputElement setAutoFocus(Object value) {
		this._autoFocus = value;
		return this;
	}

	public Object getAutoFocus() {
		return this._autoFocus;
	}

	public Object getAutoFocus(Object defaultValue) {
		return this._autoFocus == null ? defaultValue : this._autoFocus;
	}

	public boolean hasAutoFocus() {
		return this._autoFocus != null;
	}

	public InputElement removeAutoFocus() {
		this._autoFocus = null;
		return this;
	} 

	public InputElement setClasses(Object value) {
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

	public InputElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public InputElement setClassName(Object value) {
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

	public InputElement removeClassName() {
		this._className = null;
		return this;
	} 

	public InputElement setColor(Object value) {
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

	public InputElement removeColor() {
		this._color = null;
		return this;
	} 

	public InputElement setDefaultValue(Object value) {
		this._defaultValue = value;
		return this;
	}

	public Object getDefaultValue() {
		return this._defaultValue;
	}

	public Object getDefaultValue(Object defaultValue) {
		return this._defaultValue == null ? defaultValue : this._defaultValue;
	}

	public boolean hasDefaultValue() {
		return this._defaultValue != null;
	}

	public InputElement removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 

	public InputElement setDisabled(Object value) {
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

	public InputElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public InputElement setDisableUnderline(Object value) {
		this._disableUnderline = value;
		return this;
	}

	public Object getDisableUnderline() {
		return this._disableUnderline;
	}

	public Object getDisableUnderline(Object defaultValue) {
		return this._disableUnderline == null ? defaultValue : this._disableUnderline;
	}

	public boolean hasDisableUnderline() {
		return this._disableUnderline != null;
	}

	public InputElement removeDisableUnderline() {
		this._disableUnderline = null;
		return this;
	} 

	public InputElement setEndAdornment(Object value) {
		this._endAdornment = value;
		return this;
	}

	public Object getEndAdornment() {
		return this._endAdornment;
	}

	public Object getEndAdornment(Object defaultValue) {
		return this._endAdornment == null ? defaultValue : this._endAdornment;
	}

	public boolean hasEndAdornment() {
		return this._endAdornment != null;
	}

	public InputElement removeEndAdornment() {
		this._endAdornment = null;
		return this;
	} 

	public InputElement setError(Object value) {
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

	public InputElement removeError() {
		this._error = null;
		return this;
	} 

	public InputElement setFullWidth(Object value) {
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

	public InputElement removeFullWidth() {
		this._fullWidth = null;
		return this;
	} 

	public InputElement setId(Object value) {
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

	public InputElement removeId() {
		this._id = null;
		return this;
	} 

	public InputElement setInputComponent(Object value) {
		this._inputComponent = value;
		return this;
	}

	public Object getInputComponent() {
		return this._inputComponent;
	}

	public Object getInputComponent(Object defaultValue) {
		return this._inputComponent == null ? defaultValue : this._inputComponent;
	}

	public boolean hasInputComponent() {
		return this._inputComponent != null;
	}

	public InputElement removeInputComponent() {
		this._inputComponent = null;
		return this;
	} 

	public InputElement setInputProps(Object value) {
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

	public InputElement removeInputProps() {
		this._inputProps = null;
		return this;
	} 

	public InputElement setInputRef(Object value) {
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

	public InputElement removeInputRef() {
		this._inputRef = null;
		return this;
	} 

	public InputElement setMargin(Object value) {
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

	public InputElement removeMargin() {
		this._margin = null;
		return this;
	} 

	public InputElement setMultiline(Object value) {
		this._multiline = value;
		return this;
	}

	public Object getMultiline() {
		return this._multiline;
	}

	public Object getMultiline(Object defaultValue) {
		return this._multiline == null ? defaultValue : this._multiline;
	}

	public boolean hasMultiline() {
		return this._multiline != null;
	}

	public InputElement removeMultiline() {
		this._multiline = null;
		return this;
	} 

	public InputElement setName(Object value) {
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

	public InputElement removeName() {
		this._name = null;
		return this;
	} 

	public InputElement setOnChange(Object value) {
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

	public InputElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public InputElement setPlaceholder(Object value) {
		this._placeholder = value;
		return this;
	}

	public Object getPlaceholder() {
		return this._placeholder;
	}

	public Object getPlaceholder(Object defaultValue) {
		return this._placeholder == null ? defaultValue : this._placeholder;
	}

	public boolean hasPlaceholder() {
		return this._placeholder != null;
	}

	public InputElement removePlaceholder() {
		this._placeholder = null;
		return this;
	} 

	public InputElement setReadOnly(Object value) {
		this._readOnly = value;
		return this;
	}

	public Object getReadOnly() {
		return this._readOnly;
	}

	public Object getReadOnly(Object defaultValue) {
		return this._readOnly == null ? defaultValue : this._readOnly;
	}

	public boolean hasReadOnly() {
		return this._readOnly != null;
	}

	public InputElement removeReadOnly() {
		this._readOnly = null;
		return this;
	} 

	public InputElement setRequired(Object value) {
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

	public InputElement removeRequired() {
		this._required = null;
		return this;
	} 

	public InputElement setRows(Object value) {
		this._rows = value;
		return this;
	}

	public Object getRows() {
		return this._rows;
	}

	public Object getRows(Object defaultValue) {
		return this._rows == null ? defaultValue : this._rows;
	}

	public boolean hasRows() {
		return this._rows != null;
	}

	public InputElement removeRows() {
		this._rows = null;
		return this;
	} 

	public InputElement setRowsMax(Object value) {
		this._rowsMax = value;
		return this;
	}

	public Object getRowsMax() {
		return this._rowsMax;
	}

	public Object getRowsMax(Object defaultValue) {
		return this._rowsMax == null ? defaultValue : this._rowsMax;
	}

	public boolean hasRowsMax() {
		return this._rowsMax != null;
	}

	public InputElement removeRowsMax() {
		this._rowsMax = null;
		return this;
	} 

	public InputElement setStartAdornment(Object value) {
		this._startAdornment = value;
		return this;
	}

	public Object getStartAdornment() {
		return this._startAdornment;
	}

	public Object getStartAdornment(Object defaultValue) {
		return this._startAdornment == null ? defaultValue : this._startAdornment;
	}

	public boolean hasStartAdornment() {
		return this._startAdornment != null;
	}

	public InputElement removeStartAdornment() {
		this._startAdornment = null;
		return this;
	} 

	public InputElement setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public InputElement removeType() {
		this._type = null;
		return this;
	} 

	public InputElement setValue(Object value) {
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

	public InputElement removeValue() {
		this._value = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InputElement that = (InputElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "InputElement(autoComplete,autoFocus,classes,className,color,defaultValue,disabled,disableUnderline,endAdornment,error,fullWidth,id,inputComponent,inputProps,inputRef,margin,multiline,name,onChange,placeholder,readOnly,required,rows,rowsMax,startAdornment,type,value) ::= <<<Input~if(autoComplete)~\n" + 
				"	autoComplete=\"~autoComplete~\"~endif~~if(autoFocus)~\n" + 
				"	autoFocus~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(defaultValue)~\n" + 
				"	defaultValue=~defaultValue~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disableUnderline)~\n" + 
				"	disableUnderline~endif~~if(endAdornment)~\n" + 
				"	endAdornment=~endAdornment~~endif~~if(error)~\n" + 
				"	error~endif~~if(fullWidth)~\n" + 
				"	fullWidth~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(inputComponent)~\n" + 
				"	inputComponent=~inputComponent~~endif~~if(inputProps)~\n" + 
				"	inputProps=~inputProps~~endif~~if(inputRef)~\n" + 
				"	inputRef=~inputRef~~endif~~if(margin)~\n" + 
				"	margin=\"~margin~\"~endif~~if(multiline)~\n" + 
				"	multiline~endif~~if(name)~\n" + 
				"	name=\"~name~\"~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(placeholder)~\n" + 
				"	placeholder=\"~placeholder~\"~endif~~if(readOnly)~\n" + 
				"	readOnly~endif~~if(required)~\n" + 
				"	required~endif~~if(rows)~\n" + 
				"	rows=~rows~~endif~~if(rowsMax)~\n" + 
				"	rowsMax=~rowsMax~~endif~~if(startAdornment)~\n" + 
				"	startAdornment=~startAdornment~~endif~~if(type)~\n" + 
				"	type=\"~type~\"~endif~~if(value)~\n" + 
				"	value=~value~~endif~ /> >>";
}  