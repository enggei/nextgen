package nextgen.templates.materialui;

public class StepIconElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _active;
	private Object _classes;
	private Object _className;
	private Object _completed;
	private Object _error;
	private Object _icon;
	private Object _id;

	StepIconElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StepIconElement");
		st.add("active", _active);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("completed", _completed);
		st.add("error", _error);
		st.add("icon", _icon);
		st.add("id", _id);
		return st.render().trim();
	}

	public StepIconElement setActive(Object value) {
		this._active = value;
		return this;
	}

	public Object getActive() {
		return this._active;
	}

	public Object getActive(Object defaultValue) {
		return this._active == null ? defaultValue : this._active;
	}

	public boolean hasActive() {
		return this._active != null;
	}

	public StepIconElement removeActive() {
		this._active = null;
		return this;
	} 

	public StepIconElement setClasses(Object value) {
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

	public StepIconElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public StepIconElement setClassName(Object value) {
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

	public StepIconElement removeClassName() {
		this._className = null;
		return this;
	} 

	public StepIconElement setCompleted(Object value) {
		this._completed = value;
		return this;
	}

	public Object getCompleted() {
		return this._completed;
	}

	public Object getCompleted(Object defaultValue) {
		return this._completed == null ? defaultValue : this._completed;
	}

	public boolean hasCompleted() {
		return this._completed != null;
	}

	public StepIconElement removeCompleted() {
		this._completed = null;
		return this;
	} 

	public StepIconElement setError(Object value) {
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

	public StepIconElement removeError() {
		this._error = null;
		return this;
	} 

	public StepIconElement setIcon(Object value) {
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

	public StepIconElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public StepIconElement setId(Object value) {
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

	public StepIconElement removeId() {
		this._id = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StepIconElement that = (StepIconElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "StepIconElement(active,classes,className,completed,error,icon,id) ::= <<<StepIcon~if(active)~\n" + 
				"	active~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(completed)~\n" + 
				"	completed~endif~~if(error)~\n" + 
				"	error~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~ /> >>";
}  