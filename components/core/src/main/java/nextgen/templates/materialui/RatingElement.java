package nextgen.templates.materialui;

public class RatingElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _defaultValue;
	private Object _disabled;
	private Object _emptyIcon;
	private Object _emptyLabelText;
	private Object _getLabelText;
	private Object _icon;
	private Object _IconContainerComponent;
	private Object _max;
	private Object _name;
	private Object _onChange;
	private Object _onChangeActive;
	private Object _precision;
	private Object _readOnly;
	private Object _size;
	private Object _value;

	RatingElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RatingElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("defaultValue", _defaultValue);
		st.add("disabled", _disabled);
		st.add("emptyIcon", _emptyIcon);
		st.add("emptyLabelText", _emptyLabelText);
		st.add("getLabelText", _getLabelText);
		st.add("icon", _icon);
		st.add("IconContainerComponent", _IconContainerComponent);
		st.add("max", _max);
		st.add("name", _name);
		st.add("onChange", _onChange);
		st.add("onChangeActive", _onChangeActive);
		st.add("precision", _precision);
		st.add("readOnly", _readOnly);
		st.add("size", _size);
		st.add("value", _value);
		return st.render().trim();
	}

	public RatingElement setClasses(Object value) {
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

	public RatingElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public RatingElement setClassName(Object value) {
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

	public RatingElement removeClassName() {
		this._className = null;
		return this;
	} 

	public RatingElement setDefaultValue(Object value) {
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

	public RatingElement removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 

	public RatingElement setDisabled(Object value) {
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

	public RatingElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public RatingElement setEmptyIcon(Object value) {
		this._emptyIcon = value;
		return this;
	}

	public Object getEmptyIcon() {
		return this._emptyIcon;
	}

	public Object getEmptyIcon(Object defaultValue) {
		return this._emptyIcon == null ? defaultValue : this._emptyIcon;
	}

	public boolean hasEmptyIcon() {
		return this._emptyIcon != null;
	}

	public RatingElement removeEmptyIcon() {
		this._emptyIcon = null;
		return this;
	} 

	public RatingElement setEmptyLabelText(Object value) {
		this._emptyLabelText = value;
		return this;
	}

	public Object getEmptyLabelText() {
		return this._emptyLabelText;
	}

	public Object getEmptyLabelText(Object defaultValue) {
		return this._emptyLabelText == null ? defaultValue : this._emptyLabelText;
	}

	public boolean hasEmptyLabelText() {
		return this._emptyLabelText != null;
	}

	public RatingElement removeEmptyLabelText() {
		this._emptyLabelText = null;
		return this;
	} 

	public RatingElement setGetLabelText(Object value) {
		this._getLabelText = value;
		return this;
	}

	public Object getGetLabelText() {
		return this._getLabelText;
	}

	public Object getGetLabelText(Object defaultValue) {
		return this._getLabelText == null ? defaultValue : this._getLabelText;
	}

	public boolean hasGetLabelText() {
		return this._getLabelText != null;
	}

	public RatingElement removeGetLabelText() {
		this._getLabelText = null;
		return this;
	} 

	public RatingElement setIcon(Object value) {
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

	public RatingElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public RatingElement setIconContainerComponent(Object value) {
		this._IconContainerComponent = value;
		return this;
	}

	public Object getIconContainerComponent() {
		return this._IconContainerComponent;
	}

	public Object getIconContainerComponent(Object defaultValue) {
		return this._IconContainerComponent == null ? defaultValue : this._IconContainerComponent;
	}

	public boolean hasIconContainerComponent() {
		return this._IconContainerComponent != null;
	}

	public RatingElement removeIconContainerComponent() {
		this._IconContainerComponent = null;
		return this;
	} 

	public RatingElement setMax(Object value) {
		this._max = value;
		return this;
	}

	public Object getMax() {
		return this._max;
	}

	public Object getMax(Object defaultValue) {
		return this._max == null ? defaultValue : this._max;
	}

	public boolean hasMax() {
		return this._max != null;
	}

	public RatingElement removeMax() {
		this._max = null;
		return this;
	} 

	public RatingElement setName(Object value) {
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

	public RatingElement removeName() {
		this._name = null;
		return this;
	} 

	public RatingElement setOnChange(Object value) {
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

	public RatingElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public RatingElement setOnChangeActive(Object value) {
		this._onChangeActive = value;
		return this;
	}

	public Object getOnChangeActive() {
		return this._onChangeActive;
	}

	public Object getOnChangeActive(Object defaultValue) {
		return this._onChangeActive == null ? defaultValue : this._onChangeActive;
	}

	public boolean hasOnChangeActive() {
		return this._onChangeActive != null;
	}

	public RatingElement removeOnChangeActive() {
		this._onChangeActive = null;
		return this;
	} 

	public RatingElement setPrecision(Object value) {
		this._precision = value;
		return this;
	}

	public Object getPrecision() {
		return this._precision;
	}

	public Object getPrecision(Object defaultValue) {
		return this._precision == null ? defaultValue : this._precision;
	}

	public boolean hasPrecision() {
		return this._precision != null;
	}

	public RatingElement removePrecision() {
		this._precision = null;
		return this;
	} 

	public RatingElement setReadOnly(Object value) {
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

	public RatingElement removeReadOnly() {
		this._readOnly = null;
		return this;
	} 

	public RatingElement setSize(Object value) {
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

	public RatingElement removeSize() {
		this._size = null;
		return this;
	} 

	public RatingElement setValue(Object value) {
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

	public RatingElement removeValue() {
		this._value = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RatingElement that = (RatingElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RatingElement(classes,className,defaultValue,disabled,emptyIcon,emptyLabelText,getLabelText,icon,IconContainerComponent,max,name,onChange,onChangeActive,precision,readOnly,size,value) ::= <<<Rating~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(defaultValue)~\n" + 
				"	defaultValue=~defaultValue~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(emptyIcon)~\n" + 
				"	emptyIcon=~emptyIcon~~endif~~if(emptyLabelText)~\n" + 
				"	emptyLabelText=~emptyLabelText~~endif~~if(getLabelText)~\n" + 
				"	getLabelText=~getLabelText~~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(IconContainerComponent)~\n" + 
				"	IconContainerComponent=~IconContainerComponent~~endif~~if(max)~\n" + 
				"	max=~max~~endif~~if(name)~\n" + 
				"	name=\"~name~\"~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(onChangeActive)~\n" + 
				"	onChangeActive=~onChangeActive~~endif~~if(precision)~\n" + 
				"	precision=~precision~~endif~~if(readOnly)~\n" + 
				"	readOnly~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(value)~\n" + 
				"	value=~value~~endif~ /> >>";
}  