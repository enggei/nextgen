package nextgen.templates.materialui;

public class StepperElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _activeStep;
	private Object _alternativeLabel;
	private Object _classes;
	private Object _className;
	private Object _connector;
	private Object _id;
	private Object _key;
	private Object _nonLinear;
	private Object _orientation;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	StepperElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StepperElement");
		st.add("activeStep", _activeStep);
		st.add("alternativeLabel", _alternativeLabel);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("connector", _connector);
		st.add("id", _id);
		st.add("key", _key);
		st.add("nonLinear", _nonLinear);
		st.add("orientation", _orientation);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public StepperElement setActiveStep(Object value) {
		this._activeStep = value;
		return this;
	}

	public Object getActiveStep() {
		return this._activeStep;
	}

	public Object getActiveStep(Object defaultValue) {
		return this._activeStep == null ? defaultValue : this._activeStep;
	}

	public boolean hasActiveStep() {
		return this._activeStep != null;
	}

	public StepperElement removeActiveStep() {
		this._activeStep = null;
		return this;
	} 

	public StepperElement setAlternativeLabel(Object value) {
		this._alternativeLabel = value;
		return this;
	}

	public Object getAlternativeLabel() {
		return this._alternativeLabel;
	}

	public Object getAlternativeLabel(Object defaultValue) {
		return this._alternativeLabel == null ? defaultValue : this._alternativeLabel;
	}

	public boolean hasAlternativeLabel() {
		return this._alternativeLabel != null;
	}

	public StepperElement removeAlternativeLabel() {
		this._alternativeLabel = null;
		return this;
	} 

	public StepperElement setClasses(Object value) {
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

	public StepperElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public StepperElement setClassName(Object value) {
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

	public StepperElement removeClassName() {
		this._className = null;
		return this;
	} 

	public StepperElement setConnector(Object value) {
		this._connector = value;
		return this;
	}

	public Object getConnector() {
		return this._connector;
	}

	public Object getConnector(Object defaultValue) {
		return this._connector == null ? defaultValue : this._connector;
	}

	public boolean hasConnector() {
		return this._connector != null;
	}

	public StepperElement removeConnector() {
		this._connector = null;
		return this;
	} 

	public StepperElement setId(Object value) {
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

	public StepperElement removeId() {
		this._id = null;
		return this;
	} 

	public StepperElement setKey(Object value) {
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

	public StepperElement removeKey() {
		this._key = null;
		return this;
	} 

	public StepperElement setNonLinear(Object value) {
		this._nonLinear = value;
		return this;
	}

	public Object getNonLinear() {
		return this._nonLinear;
	}

	public Object getNonLinear(Object defaultValue) {
		return this._nonLinear == null ? defaultValue : this._nonLinear;
	}

	public boolean hasNonLinear() {
		return this._nonLinear != null;
	}

	public StepperElement removeNonLinear() {
		this._nonLinear = null;
		return this;
	} 

	public StepperElement setOrientation(Object value) {
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

	public StepperElement removeOrientation() {
		this._orientation = null;
		return this;
	} 

	public StepperElement setStyle(Object value) {
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

	public StepperElement removeStyle() {
		this._style = null;
		return this;
	} 

	public StepperElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public StepperElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StepperElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public StepperElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public StepperElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public StepperElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public StepperElement addAttribute(StepperElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<StepperElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(StepperElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(StepperElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(StepperElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class StepperElement_Attribute {

		Object _name;
		Object _value;

		public StepperElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private StepperElement_Attribute(java.util.Map<String, Object> map) {
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
		StepperElement that = (StepperElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "StepperElement(activeStep,alternativeLabel,classes,className,connector,id,key,nonLinear,orientation,style,attribute,children) ::= <<<Stepper~if(activeStep)~\n" + 
				"	activeStep=~activeStep~~endif~~if(alternativeLabel)~\n" + 
				"	alternativeLabel~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(connector)~\n" + 
				"	connector=~connector~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(nonLinear)~\n" + 
				"	nonLinear~endif~~if(orientation)~\n" + 
				"	orientation=~orientation~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Stepper>~else~ />~endif~ >>";
}  