package nextgen.templates.materialui;

public class StepperElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _activeStep;
	private Object _alternativeLabel;
	private Object _classes;
	private Object _className;
	private Object _connector;
	private Object _nonLinear;
	private Object _orientation;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	StepperElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
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
		st.add("nonLinear", _nonLinear);
		st.add("orientation", _orientation);
		for (Object o : _children) st.add("children", o);
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

	static final String st = "StepperElement(activeStep,alternativeLabel,classes,className,connector,nonLinear,orientation,children) ::= <<<Stepper~if(activeStep)~\n" + 
				"	activeStep=~activeStep~~endif~~if(alternativeLabel)~\n" + 
				"	alternativeLabel~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(connector)~\n" + 
				"	connector=~connector~~endif~~if(nonLinear)~\n" + 
				"	nonLinear~endif~~if(orientation)~\n" + 
				"	orientation=\"~orientation~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Stepper>~else~ />~endif~ >>";
}  