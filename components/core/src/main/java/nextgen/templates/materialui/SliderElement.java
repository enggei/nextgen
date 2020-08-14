package nextgen.templates.materialui;

public class SliderElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _ariaLabel;
	private Object _ariaLabelledby;
	private Object _ariaValuetext;
	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _defaultValue;
	private Object _disabled;
	private Object _getAriaLabel;
	private Object _getAriaValueText;
	private Object _id;
	private Object _marks;
	private Object _max;
	private Object _min;
	private Object _name;
	private Object _onChange;
	private Object _onChangeCommitted;
	private Object _orientation;
	private Object _scale;
	private Object _step;
	private Object _ThumbComponent;
	private Object _track;
	private Object _value;
	private Object _ValueLabelComponent;
	private Object _valueLabelDisplay;
	private Object _valueLabelFormat;

	SliderElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SliderElement");
		st.add("ariaLabel", _ariaLabel);
		st.add("ariaLabelledby", _ariaLabelledby);
		st.add("ariaValuetext", _ariaValuetext);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("defaultValue", _defaultValue);
		st.add("disabled", _disabled);
		st.add("getAriaLabel", _getAriaLabel);
		st.add("getAriaValueText", _getAriaValueText);
		st.add("id", _id);
		st.add("marks", _marks);
		st.add("max", _max);
		st.add("min", _min);
		st.add("name", _name);
		st.add("onChange", _onChange);
		st.add("onChangeCommitted", _onChangeCommitted);
		st.add("orientation", _orientation);
		st.add("scale", _scale);
		st.add("step", _step);
		st.add("ThumbComponent", _ThumbComponent);
		st.add("track", _track);
		st.add("value", _value);
		st.add("ValueLabelComponent", _ValueLabelComponent);
		st.add("valueLabelDisplay", _valueLabelDisplay);
		st.add("valueLabelFormat", _valueLabelFormat);
		return st.render().trim();
	}

	public SliderElement setAriaLabel(Object value) {
		this._ariaLabel = value;
		return this;
	}

	public Object getAriaLabel() {
		return this._ariaLabel;
	}

	public Object getAriaLabel(Object defaultValue) {
		return this._ariaLabel == null ? defaultValue : this._ariaLabel;
	}

	public boolean hasAriaLabel() {
		return this._ariaLabel != null;
	}

	public SliderElement removeAriaLabel() {
		this._ariaLabel = null;
		return this;
	} 

	public SliderElement setAriaLabelledby(Object value) {
		this._ariaLabelledby = value;
		return this;
	}

	public Object getAriaLabelledby() {
		return this._ariaLabelledby;
	}

	public Object getAriaLabelledby(Object defaultValue) {
		return this._ariaLabelledby == null ? defaultValue : this._ariaLabelledby;
	}

	public boolean hasAriaLabelledby() {
		return this._ariaLabelledby != null;
	}

	public SliderElement removeAriaLabelledby() {
		this._ariaLabelledby = null;
		return this;
	} 

	public SliderElement setAriaValuetext(Object value) {
		this._ariaValuetext = value;
		return this;
	}

	public Object getAriaValuetext() {
		return this._ariaValuetext;
	}

	public Object getAriaValuetext(Object defaultValue) {
		return this._ariaValuetext == null ? defaultValue : this._ariaValuetext;
	}

	public boolean hasAriaValuetext() {
		return this._ariaValuetext != null;
	}

	public SliderElement removeAriaValuetext() {
		this._ariaValuetext = null;
		return this;
	} 

	public SliderElement setClasses(Object value) {
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

	public SliderElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SliderElement setClassName(Object value) {
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

	public SliderElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SliderElement setColor(Object value) {
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

	public SliderElement removeColor() {
		this._color = null;
		return this;
	} 

	public SliderElement setComponent(Object value) {
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

	public SliderElement removeComponent() {
		this._component = null;
		return this;
	} 

	public SliderElement setDefaultValue(Object value) {
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

	public SliderElement removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 

	public SliderElement setDisabled(Object value) {
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

	public SliderElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public SliderElement setGetAriaLabel(Object value) {
		this._getAriaLabel = value;
		return this;
	}

	public Object getGetAriaLabel() {
		return this._getAriaLabel;
	}

	public Object getGetAriaLabel(Object defaultValue) {
		return this._getAriaLabel == null ? defaultValue : this._getAriaLabel;
	}

	public boolean hasGetAriaLabel() {
		return this._getAriaLabel != null;
	}

	public SliderElement removeGetAriaLabel() {
		this._getAriaLabel = null;
		return this;
	} 

	public SliderElement setGetAriaValueText(Object value) {
		this._getAriaValueText = value;
		return this;
	}

	public Object getGetAriaValueText() {
		return this._getAriaValueText;
	}

	public Object getGetAriaValueText(Object defaultValue) {
		return this._getAriaValueText == null ? defaultValue : this._getAriaValueText;
	}

	public boolean hasGetAriaValueText() {
		return this._getAriaValueText != null;
	}

	public SliderElement removeGetAriaValueText() {
		this._getAriaValueText = null;
		return this;
	} 

	public SliderElement setId(Object value) {
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

	public SliderElement removeId() {
		this._id = null;
		return this;
	} 

	public SliderElement setMarks(Object value) {
		this._marks = value;
		return this;
	}

	public Object getMarks() {
		return this._marks;
	}

	public Object getMarks(Object defaultValue) {
		return this._marks == null ? defaultValue : this._marks;
	}

	public boolean hasMarks() {
		return this._marks != null;
	}

	public SliderElement removeMarks() {
		this._marks = null;
		return this;
	} 

	public SliderElement setMax(Object value) {
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

	public SliderElement removeMax() {
		this._max = null;
		return this;
	} 

	public SliderElement setMin(Object value) {
		this._min = value;
		return this;
	}

	public Object getMin() {
		return this._min;
	}

	public Object getMin(Object defaultValue) {
		return this._min == null ? defaultValue : this._min;
	}

	public boolean hasMin() {
		return this._min != null;
	}

	public SliderElement removeMin() {
		this._min = null;
		return this;
	} 

	public SliderElement setName(Object value) {
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

	public SliderElement removeName() {
		this._name = null;
		return this;
	} 

	public SliderElement setOnChange(Object value) {
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

	public SliderElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public SliderElement setOnChangeCommitted(Object value) {
		this._onChangeCommitted = value;
		return this;
	}

	public Object getOnChangeCommitted() {
		return this._onChangeCommitted;
	}

	public Object getOnChangeCommitted(Object defaultValue) {
		return this._onChangeCommitted == null ? defaultValue : this._onChangeCommitted;
	}

	public boolean hasOnChangeCommitted() {
		return this._onChangeCommitted != null;
	}

	public SliderElement removeOnChangeCommitted() {
		this._onChangeCommitted = null;
		return this;
	} 

	public SliderElement setOrientation(Object value) {
		this._orientation = value;
		return this;
	}

	public Object getOrientation() {
		return this._orientation;
	}

	public Object getOrientation(Object defaultValue) {
		return this._orientation == null ? defaultValue : this._orientation;
	}

	public boolean hasOrientation() {
		return this._orientation != null;
	}

	public SliderElement removeOrientation() {
		this._orientation = null;
		return this;
	} 

	public SliderElement setScale(Object value) {
		this._scale = value;
		return this;
	}

	public Object getScale() {
		return this._scale;
	}

	public Object getScale(Object defaultValue) {
		return this._scale == null ? defaultValue : this._scale;
	}

	public boolean hasScale() {
		return this._scale != null;
	}

	public SliderElement removeScale() {
		this._scale = null;
		return this;
	} 

	public SliderElement setStep(Object value) {
		this._step = value;
		return this;
	}

	public Object getStep() {
		return this._step;
	}

	public Object getStep(Object defaultValue) {
		return this._step == null ? defaultValue : this._step;
	}

	public boolean hasStep() {
		return this._step != null;
	}

	public SliderElement removeStep() {
		this._step = null;
		return this;
	} 

	public SliderElement setThumbComponent(Object value) {
		this._ThumbComponent = value;
		return this;
	}

	public Object getThumbComponent() {
		return this._ThumbComponent;
	}

	public Object getThumbComponent(Object defaultValue) {
		return this._ThumbComponent == null ? defaultValue : this._ThumbComponent;
	}

	public boolean hasThumbComponent() {
		return this._ThumbComponent != null;
	}

	public SliderElement removeThumbComponent() {
		this._ThumbComponent = null;
		return this;
	} 

	public SliderElement setTrack(Object value) {
		this._track = value;
		return this;
	}

	public Object getTrack() {
		return this._track;
	}

	public Object getTrack(Object defaultValue) {
		return this._track == null ? defaultValue : this._track;
	}

	public boolean hasTrack() {
		return this._track != null;
	}

	public SliderElement removeTrack() {
		this._track = null;
		return this;
	} 

	public SliderElement setValue(Object value) {
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

	public SliderElement removeValue() {
		this._value = null;
		return this;
	} 

	public SliderElement setValueLabelComponent(Object value) {
		this._ValueLabelComponent = value;
		return this;
	}

	public Object getValueLabelComponent() {
		return this._ValueLabelComponent;
	}

	public Object getValueLabelComponent(Object defaultValue) {
		return this._ValueLabelComponent == null ? defaultValue : this._ValueLabelComponent;
	}

	public boolean hasValueLabelComponent() {
		return this._ValueLabelComponent != null;
	}

	public SliderElement removeValueLabelComponent() {
		this._ValueLabelComponent = null;
		return this;
	} 

	public SliderElement setValueLabelDisplay(Object value) {
		this._valueLabelDisplay = value;
		return this;
	}

	public Object getValueLabelDisplay() {
		return this._valueLabelDisplay;
	}

	public Object getValueLabelDisplay(Object defaultValue) {
		return this._valueLabelDisplay == null ? defaultValue : this._valueLabelDisplay;
	}

	public boolean hasValueLabelDisplay() {
		return this._valueLabelDisplay != null;
	}

	public SliderElement removeValueLabelDisplay() {
		this._valueLabelDisplay = null;
		return this;
	} 

	public SliderElement setValueLabelFormat(Object value) {
		this._valueLabelFormat = value;
		return this;
	}

	public Object getValueLabelFormat() {
		return this._valueLabelFormat;
	}

	public Object getValueLabelFormat(Object defaultValue) {
		return this._valueLabelFormat == null ? defaultValue : this._valueLabelFormat;
	}

	public boolean hasValueLabelFormat() {
		return this._valueLabelFormat != null;
	}

	public SliderElement removeValueLabelFormat() {
		this._valueLabelFormat = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SliderElement that = (SliderElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SliderElement(ariaLabel,ariaLabelledby,ariaValuetext,classes,className,color,component,defaultValue,disabled,getAriaLabel,getAriaValueText,id,marks,max,min,name,onChange,onChangeCommitted,orientation,scale,step,ThumbComponent,track,value,ValueLabelComponent,valueLabelDisplay,valueLabelFormat) ::= <<<Slider~if(ariaLabel)~\n" + 
				"	ariaLabel=\"~ariaLabel~\"~endif~~if(ariaLabelledby)~\n" + 
				"	ariaLabelledby=\"~ariaLabelledby~\"~endif~~if(ariaValuetext)~\n" + 
				"	ariaValuetext=\"~ariaValuetext~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(defaultValue)~\n" + 
				"	defaultValue=~defaultValue~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(getAriaLabel)~\n" + 
				"	getAriaLabel=~getAriaLabel~~endif~~if(getAriaValueText)~\n" + 
				"	getAriaValueText=~getAriaValueText~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(marks)~\n" + 
				"	marks=~marks~~endif~~if(max)~\n" + 
				"	max=~max~~endif~~if(min)~\n" + 
				"	min=~min~~endif~~if(name)~\n" + 
				"	name=\"~name~\"~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(onChangeCommitted)~\n" + 
				"	onChangeCommitted=~onChangeCommitted~~endif~~if(orientation)~\n" + 
				"	orientation=\"~orientation~\"~endif~~if(scale)~\n" + 
				"	scale=~scale~~endif~~if(step)~\n" + 
				"	step=~step~~endif~~if(ThumbComponent)~\n" + 
				"	ThumbComponent=~ThumbComponent~~endif~~if(track)~\n" + 
				"	track=\"~track~\"~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(ValueLabelComponent)~\n" + 
				"	ValueLabelComponent=~ValueLabelComponent~~endif~~if(valueLabelDisplay)~\n" + 
				"	valueLabelDisplay=\"~valueLabelDisplay~\"~endif~~if(valueLabelFormat)~\n" + 
				"	valueLabelFormat=~valueLabelFormat~~endif~ /> >>";
}  