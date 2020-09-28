package nextgen.templates.materialui;

public class InputBaseElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _autoComplete;
	private Object _autoFocus;
	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _defaultValue;
	private Object _disabled;
	private Object _endAdornment;
	private Object _error;
	private Object _fullWidth;
	private Object _id;
	private Object _inputComponent;
	private Object _inputProps;
	private Object _inputRef;
	private Object _key;
	private Object _margin;
	private Object _multiline;
	private Object _name;
	private Object _onBlur;
	private Object _onChange;
	private Object _placeholder;
	private Object _readOnly;
	private Object _required;
	private Object _rows;
	private Object _rowsMax;
	private Object _rowsMin;
	private Object _startAdornment;
	private Object _style;
	private Object _type;
	private Object _value;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	InputBaseElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("InputBaseElement");
		st.add("autoComplete", _autoComplete);
		st.add("autoFocus", _autoFocus);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("defaultValue", _defaultValue);
		st.add("disabled", _disabled);
		st.add("endAdornment", _endAdornment);
		st.add("error", _error);
		st.add("fullWidth", _fullWidth);
		st.add("id", _id);
		st.add("inputComponent", _inputComponent);
		st.add("inputProps", _inputProps);
		st.add("inputRef", _inputRef);
		st.add("key", _key);
		st.add("margin", _margin);
		st.add("multiline", _multiline);
		st.add("name", _name);
		st.add("onBlur", _onBlur);
		st.add("onChange", _onChange);
		st.add("placeholder", _placeholder);
		st.add("readOnly", _readOnly);
		st.add("required", _required);
		st.add("rows", _rows);
		st.add("rowsMax", _rowsMax);
		st.add("rowsMin", _rowsMin);
		st.add("startAdornment", _startAdornment);
		st.add("style", _style);
		st.add("type", _type);
		st.add("value", _value);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public InputBaseElement setAutoComplete(Object value) {
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

	public InputBaseElement removeAutoComplete() {
		this._autoComplete = null;
		return this;
	} 

	public InputBaseElement setAutoFocus(Object value) {
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

	public InputBaseElement removeAutoFocus() {
		this._autoFocus = null;
		return this;
	} 

	public InputBaseElement setClasses(Object value) {
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

	public InputBaseElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public InputBaseElement setClassName(Object value) {
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

	public InputBaseElement removeClassName() {
		this._className = null;
		return this;
	} 

	public InputBaseElement setColor(Object value) {
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

	public InputBaseElement removeColor() {
		this._color = null;
		return this;
	} 

	public InputBaseElement setDefaultValue(Object value) {
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

	public InputBaseElement removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 

	public InputBaseElement setDisabled(Object value) {
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

	public InputBaseElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public InputBaseElement setEndAdornment(Object value) {
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

	public InputBaseElement removeEndAdornment() {
		this._endAdornment = null;
		return this;
	} 

	public InputBaseElement setError(Object value) {
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

	public InputBaseElement removeError() {
		this._error = null;
		return this;
	} 

	public InputBaseElement setFullWidth(Object value) {
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

	public InputBaseElement removeFullWidth() {
		this._fullWidth = null;
		return this;
	} 

	public InputBaseElement setId(Object value) {
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

	public InputBaseElement removeId() {
		this._id = null;
		return this;
	} 

	public InputBaseElement setInputComponent(Object value) {
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

	public InputBaseElement removeInputComponent() {
		this._inputComponent = null;
		return this;
	} 

	public InputBaseElement setInputProps(Object value) {
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

	public InputBaseElement removeInputProps() {
		this._inputProps = null;
		return this;
	} 

	public InputBaseElement setInputRef(Object value) {
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

	public InputBaseElement removeInputRef() {
		this._inputRef = null;
		return this;
	} 

	public InputBaseElement setKey(Object value) {
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

	public InputBaseElement removeKey() {
		this._key = null;
		return this;
	} 

	public InputBaseElement setMargin(Object value) {
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

	public InputBaseElement removeMargin() {
		this._margin = null;
		return this;
	} 

	public InputBaseElement setMultiline(Object value) {
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

	public InputBaseElement removeMultiline() {
		this._multiline = null;
		return this;
	} 

	public InputBaseElement setName(Object value) {
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

	public InputBaseElement removeName() {
		this._name = null;
		return this;
	} 

	public InputBaseElement setOnBlur(Object value) {
		this._onBlur = value;
		return this;
	}

	public Object getOnBlur() {
		return this._onBlur;
	}

	public Object getOnBlur(Object defaultValue) {
		return this._onBlur == null ? defaultValue : this._onBlur;
	}

	public boolean hasOnBlur() {
		return this._onBlur != null;
	}

	public InputBaseElement removeOnBlur() {
		this._onBlur = null;
		return this;
	} 

	public InputBaseElement setOnChange(Object value) {
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

	public InputBaseElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public InputBaseElement setPlaceholder(Object value) {
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

	public InputBaseElement removePlaceholder() {
		this._placeholder = null;
		return this;
	} 

	public InputBaseElement setReadOnly(Object value) {
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

	public InputBaseElement removeReadOnly() {
		this._readOnly = null;
		return this;
	} 

	public InputBaseElement setRequired(Object value) {
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

	public InputBaseElement removeRequired() {
		this._required = null;
		return this;
	} 

	public InputBaseElement setRows(Object value) {
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

	public InputBaseElement removeRows() {
		this._rows = null;
		return this;
	} 

	public InputBaseElement setRowsMax(Object value) {
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

	public InputBaseElement removeRowsMax() {
		this._rowsMax = null;
		return this;
	} 

	public InputBaseElement setRowsMin(Object value) {
		this._rowsMin = value;
		return this;
	}

	public Object getRowsMin() {
		return this._rowsMin;
	}

	public Object getRowsMin(Object defaultValue) {
		return this._rowsMin == null ? defaultValue : this._rowsMin;
	}

	public boolean hasRowsMin() {
		return this._rowsMin != null;
	}

	public InputBaseElement removeRowsMin() {
		this._rowsMin = null;
		return this;
	} 

	public InputBaseElement setStartAdornment(Object value) {
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

	public InputBaseElement removeStartAdornment() {
		this._startAdornment = null;
		return this;
	} 

	public InputBaseElement setStyle(Object value) {
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

	public InputBaseElement removeStyle() {
		this._style = null;
		return this;
	} 

	public InputBaseElement setType(Object value) {
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

	public InputBaseElement removeType() {
		this._type = null;
		return this;
	} 

	public InputBaseElement setValue(Object value) {
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

	public InputBaseElement removeValue() {
		this._value = null;
		return this;
	} 


	public InputBaseElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public InputBaseElement addAttribute(InputBaseElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<InputBaseElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(InputBaseElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(InputBaseElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(InputBaseElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class InputBaseElement_Attribute {

		Object _name;
		Object _value;

		public InputBaseElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private InputBaseElement_Attribute(java.util.Map<String, Object> map) {
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
		InputBaseElement that = (InputBaseElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "InputBaseElement(autoComplete,autoFocus,classes,className,color,defaultValue,disabled,endAdornment,error,fullWidth,id,inputComponent,inputProps,inputRef,key,margin,multiline,name,onBlur,onChange,placeholder,readOnly,required,rows,rowsMax,rowsMin,startAdornment,style,type,value,attribute) ::= <<<InputBase~if(autoComplete)~\n" + 
				"	autoComplete=\"~autoComplete~\"~endif~~if(autoFocus)~\n" + 
				"	autoFocus~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(defaultValue)~\n" + 
				"	defaultValue=~defaultValue~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(endAdornment)~\n" + 
				"	endAdornment=~endAdornment~~endif~~if(error)~\n" + 
				"	error~endif~~if(fullWidth)~\n" + 
				"	fullWidth~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(inputComponent)~\n" + 
				"	inputComponent=~inputComponent~~endif~~if(inputProps)~\n" + 
				"	inputProps=~inputProps~~endif~~if(inputRef)~\n" + 
				"	inputRef=~inputRef~~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(margin)~\n" + 
				"	margin=\"~margin~\"~endif~~if(multiline)~\n" + 
				"	multiline~endif~~if(name)~\n" + 
				"	name=\"~name~\"~endif~~if(onBlur)~\n" + 
				"	onBlur=~onBlur~~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(placeholder)~\n" + 
				"	placeholder=\"~placeholder~\"~endif~~if(readOnly)~\n" + 
				"	readOnly~endif~~if(required)~\n" + 
				"	required~endif~~if(rows)~\n" + 
				"	rows=~rows~~endif~~if(rowsMax)~\n" + 
				"	rowsMax=~rowsMax~~endif~~if(rowsMin)~\n" + 
				"	rowsMin=~rowsMin~~endif~~if(startAdornment)~\n" + 
				"	startAdornment=~startAdornment~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(type)~\n" + 
				"	type=\"~type~\"~endif~~if(value)~\n" + 
				"	value=~value~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  