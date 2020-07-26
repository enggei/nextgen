package nextgen.templates.materialui;

public class TextFieldElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _autoComplete;
	private Object _autoFocus;
	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _defaultValue;
	private Object _disabled;
	private Object _error;
	private Object _FormHelperTextProps;
	private Object _fullWidth;
	private Object _helperText;
	private Object _id;
	private Object _InputLabelProps;
	private Object _inputProps;
	private Object _inputRef;
	private Object _label;
	private Object _margin;
	private Object _multiline;
	private Object _name;
	private Object _onChange;
	private Object _placeholder;
	private Object _required;
	private Object _rows;
	private Object _rowsMax;
	private Object _select;
	private Object _SelectProps;
	private Object _size;
	private Object _type;
	private Object _value;
	private Object _variant;

	TextFieldElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TextFieldElement");
		st.add("autoComplete", _autoComplete);
		st.add("autoFocus", _autoFocus);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("defaultValue", _defaultValue);
		st.add("disabled", _disabled);
		st.add("error", _error);
		st.add("FormHelperTextProps", _FormHelperTextProps);
		st.add("fullWidth", _fullWidth);
		st.add("helperText", _helperText);
		st.add("id", _id);
		st.add("InputLabelProps", _InputLabelProps);
		st.add("inputProps", _inputProps);
		st.add("inputRef", _inputRef);
		st.add("label", _label);
		st.add("margin", _margin);
		st.add("multiline", _multiline);
		st.add("name", _name);
		st.add("onChange", _onChange);
		st.add("placeholder", _placeholder);
		st.add("required", _required);
		st.add("rows", _rows);
		st.add("rowsMax", _rowsMax);
		st.add("select", _select);
		st.add("SelectProps", _SelectProps);
		st.add("size", _size);
		st.add("type", _type);
		st.add("value", _value);
		st.add("variant", _variant);
		return st.render().trim();
	}

	public TextFieldElement setAutoComplete(Object value) {
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

	public TextFieldElement removeAutoComplete() {
		this._autoComplete = null;
		return this;
	} 

	public TextFieldElement setAutoFocus(Object value) {
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

	public TextFieldElement removeAutoFocus() {
		this._autoFocus = null;
		return this;
	} 

	public TextFieldElement setClasses(Object value) {
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

	public TextFieldElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TextFieldElement setClassName(Object value) {
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

	public TextFieldElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TextFieldElement setColor(Object value) {
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

	public TextFieldElement removeColor() {
		this._color = null;
		return this;
	} 

	public TextFieldElement setDefaultValue(Object value) {
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

	public TextFieldElement removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 

	public TextFieldElement setDisabled(Object value) {
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

	public TextFieldElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public TextFieldElement setError(Object value) {
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

	public TextFieldElement removeError() {
		this._error = null;
		return this;
	} 

	public TextFieldElement setFormHelperTextProps(Object value) {
		this._FormHelperTextProps = value;
		return this;
	}

	public Object getFormHelperTextProps() {
		return this._FormHelperTextProps;
	}

	public Object getFormHelperTextProps(Object defaultValue) {
		return this._FormHelperTextProps == null ? defaultValue : this._FormHelperTextProps;
	}

	public boolean hasFormHelperTextProps() {
		return this._FormHelperTextProps != null;
	}

	public TextFieldElement removeFormHelperTextProps() {
		this._FormHelperTextProps = null;
		return this;
	} 

	public TextFieldElement setFullWidth(Object value) {
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

	public TextFieldElement removeFullWidth() {
		this._fullWidth = null;
		return this;
	} 

	public TextFieldElement setHelperText(Object value) {
		this._helperText = value;
		return this;
	}

	public Object getHelperText() {
		return this._helperText;
	}

	public Object getHelperText(Object defaultValue) {
		return this._helperText == null ? defaultValue : this._helperText;
	}

	public boolean hasHelperText() {
		return this._helperText != null;
	}

	public TextFieldElement removeHelperText() {
		this._helperText = null;
		return this;
	} 

	public TextFieldElement setId(Object value) {
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

	public TextFieldElement removeId() {
		this._id = null;
		return this;
	} 

	public TextFieldElement setInputLabelProps(Object value) {
		this._InputLabelProps = value;
		return this;
	}

	public Object getInputLabelProps() {
		return this._InputLabelProps;
	}

	public Object getInputLabelProps(Object defaultValue) {
		return this._InputLabelProps == null ? defaultValue : this._InputLabelProps;
	}

	public boolean hasInputLabelProps() {
		return this._InputLabelProps != null;
	}

	public TextFieldElement removeInputLabelProps() {
		this._InputLabelProps = null;
		return this;
	} 

	public TextFieldElement setInputProps(Object value) {
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

	public TextFieldElement removeInputProps() {
		this._inputProps = null;
		return this;
	} 

	public TextFieldElement setInputRef(Object value) {
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

	public TextFieldElement removeInputRef() {
		this._inputRef = null;
		return this;
	} 

	public TextFieldElement setLabel(Object value) {
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

	public TextFieldElement removeLabel() {
		this._label = null;
		return this;
	} 

	public TextFieldElement setMargin(Object value) {
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

	public TextFieldElement removeMargin() {
		this._margin = null;
		return this;
	} 

	public TextFieldElement setMultiline(Object value) {
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

	public TextFieldElement removeMultiline() {
		this._multiline = null;
		return this;
	} 

	public TextFieldElement setName(Object value) {
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

	public TextFieldElement removeName() {
		this._name = null;
		return this;
	} 

	public TextFieldElement setOnChange(Object value) {
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

	public TextFieldElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public TextFieldElement setPlaceholder(Object value) {
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

	public TextFieldElement removePlaceholder() {
		this._placeholder = null;
		return this;
	} 

	public TextFieldElement setRequired(Object value) {
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

	public TextFieldElement removeRequired() {
		this._required = null;
		return this;
	} 

	public TextFieldElement setRows(Object value) {
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

	public TextFieldElement removeRows() {
		this._rows = null;
		return this;
	} 

	public TextFieldElement setRowsMax(Object value) {
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

	public TextFieldElement removeRowsMax() {
		this._rowsMax = null;
		return this;
	} 

	public TextFieldElement setSelect(Object value) {
		this._select = value;
		return this;
	}

	public Object getSelect() {
		return this._select;
	}

	public Object getSelect(Object defaultValue) {
		return this._select == null ? defaultValue : this._select;
	}

	public boolean hasSelect() {
		return this._select != null;
	}

	public TextFieldElement removeSelect() {
		this._select = null;
		return this;
	} 

	public TextFieldElement setSelectProps(Object value) {
		this._SelectProps = value;
		return this;
	}

	public Object getSelectProps() {
		return this._SelectProps;
	}

	public Object getSelectProps(Object defaultValue) {
		return this._SelectProps == null ? defaultValue : this._SelectProps;
	}

	public boolean hasSelectProps() {
		return this._SelectProps != null;
	}

	public TextFieldElement removeSelectProps() {
		this._SelectProps = null;
		return this;
	} 

	public TextFieldElement setSize(Object value) {
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

	public TextFieldElement removeSize() {
		this._size = null;
		return this;
	} 

	public TextFieldElement setType(Object value) {
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

	public TextFieldElement removeType() {
		this._type = null;
		return this;
	} 

	public TextFieldElement setValue(Object value) {
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

	public TextFieldElement removeValue() {
		this._value = null;
		return this;
	} 

	public TextFieldElement setVariant(Object value) {
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

	public TextFieldElement removeVariant() {
		this._variant = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TextFieldElement that = (TextFieldElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TextFieldElement(autoComplete,autoFocus,classes,className,color,defaultValue,disabled,error,FormHelperTextProps,fullWidth,helperText,id,InputLabelProps,inputProps,inputRef,label,margin,multiline,name,onChange,placeholder,required,rows,rowsMax,select,SelectProps,size,type,value,variant) ::= <<<TextField~if(autoComplete)~\n" + 
				"	autoComplete=\"~autoComplete~\"~endif~~if(autoFocus)~\n" + 
				"	autoFocus~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(defaultValue)~\n" + 
				"	defaultValue=~defaultValue~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(error)~\n" + 
				"	error~endif~~if(FormHelperTextProps)~\n" + 
				"	FormHelperTextProps=~FormHelperTextProps~~endif~~if(fullWidth)~\n" + 
				"	fullWidth~endif~~if(helperText)~\n" + 
				"	helperText=~helperText~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(InputLabelProps)~\n" + 
				"	InputLabelProps=~InputLabelProps~~endif~~if(inputProps)~\n" + 
				"	inputProps=~inputProps~~endif~~if(inputRef)~\n" + 
				"	inputRef=~inputRef~~endif~~if(label)~\n" + 
				"	label=~label~~endif~~if(margin)~\n" + 
				"	margin=\"~margin~\"~endif~~if(multiline)~\n" + 
				"	multiline~endif~~if(name)~\n" + 
				"	name=\"~name~\"~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(placeholder)~\n" + 
				"	placeholder=\"~placeholder~\"~endif~~if(required)~\n" + 
				"	required~endif~~if(rows)~\n" + 
				"	rows=~rows~~endif~~if(rowsMax)~\n" + 
				"	rowsMax=~rowsMax~~endif~~if(select)~\n" + 
				"	select~endif~~if(SelectProps)~\n" + 
				"	SelectProps=~SelectProps~~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(type)~\n" + 
				"	type=\"~type~\"~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~ /> >>";
}  