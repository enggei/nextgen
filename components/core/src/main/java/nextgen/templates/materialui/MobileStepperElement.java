package nextgen.templates.materialui;

public class MobileStepperElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _activeStep;
	private Object _backButton;
	private Object _classes;
	private Object _className;
	private Object _LinearProgressProps;
	private Object _nextButton;
	private Object _position;
	private Object _steps;
	private Object _variant;

	MobileStepperElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MobileStepperElement");
		st.add("activeStep", _activeStep);
		st.add("backButton", _backButton);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("LinearProgressProps", _LinearProgressProps);
		st.add("nextButton", _nextButton);
		st.add("position", _position);
		st.add("steps", _steps);
		st.add("variant", _variant);
		return st.render().trim();
	}

	public MobileStepperElement setActiveStep(Object value) {
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

	public MobileStepperElement removeActiveStep() {
		this._activeStep = null;
		return this;
	} 

	public MobileStepperElement setBackButton(Object value) {
		this._backButton = value;
		return this;
	}

	public Object getBackButton() {
		return this._backButton;
	}

	public Object getBackButton(Object defaultValue) {
		return this._backButton == null ? defaultValue : this._backButton;
	}

	public boolean hasBackButton() {
		return this._backButton != null;
	}

	public MobileStepperElement removeBackButton() {
		this._backButton = null;
		return this;
	} 

	public MobileStepperElement setClasses(Object value) {
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

	public MobileStepperElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public MobileStepperElement setClassName(Object value) {
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

	public MobileStepperElement removeClassName() {
		this._className = null;
		return this;
	} 

	public MobileStepperElement setLinearProgressProps(Object value) {
		this._LinearProgressProps = value;
		return this;
	}

	public Object getLinearProgressProps() {
		return this._LinearProgressProps;
	}

	public Object getLinearProgressProps(Object defaultValue) {
		return this._LinearProgressProps == null ? defaultValue : this._LinearProgressProps;
	}

	public boolean hasLinearProgressProps() {
		return this._LinearProgressProps != null;
	}

	public MobileStepperElement removeLinearProgressProps() {
		this._LinearProgressProps = null;
		return this;
	} 

	public MobileStepperElement setNextButton(Object value) {
		this._nextButton = value;
		return this;
	}

	public Object getNextButton() {
		return this._nextButton;
	}

	public Object getNextButton(Object defaultValue) {
		return this._nextButton == null ? defaultValue : this._nextButton;
	}

	public boolean hasNextButton() {
		return this._nextButton != null;
	}

	public MobileStepperElement removeNextButton() {
		this._nextButton = null;
		return this;
	} 

	public MobileStepperElement setPosition(Object value) {
		this._position = value;
		return this;
	}

	public Object getPosition() {
		return this._position;
	}

	public Object getPosition(Object defaultValue) {
		return this._position == null ? defaultValue : this._position;
	}

	public boolean hasPosition() {
		return this._position != null;
	}

	public MobileStepperElement removePosition() {
		this._position = null;
		return this;
	} 

	public MobileStepperElement setSteps(Object value) {
		this._steps = value;
		return this;
	}

	public Object getSteps() {
		return this._steps;
	}

	public Object getSteps(Object defaultValue) {
		return this._steps == null ? defaultValue : this._steps;
	}

	public boolean hasSteps() {
		return this._steps != null;
	}

	public MobileStepperElement removeSteps() {
		this._steps = null;
		return this;
	} 

	public MobileStepperElement setVariant(Object value) {
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

	public MobileStepperElement removeVariant() {
		this._variant = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MobileStepperElement that = (MobileStepperElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MobileStepperElement(activeStep,backButton,classes,className,LinearProgressProps,nextButton,position,steps,variant) ::= <<<MobileStepper~if(activeStep)~\n" + 
				"	activeStep=~activeStep~~endif~~if(backButton)~\n" + 
				"	backButton=~backButton~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(LinearProgressProps)~\n" + 
				"	LinearProgressProps=~LinearProgressProps~~endif~~if(nextButton)~\n" + 
				"	nextButton=~nextButton~~endif~~if(position)~\n" + 
				"	position=\"~position~\"~endif~\n" + 
				"	steps=~steps~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~ /> >>";
}  