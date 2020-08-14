package nextgen.templates.materialui;

public class StepElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _active;
	private Object _classes;
	private Object _className;
	private Object _completed;
	private Object _disabled;
	private Object _expanded;
	private Object _id;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	StepElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StepElement");
		st.add("active", _active);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("completed", _completed);
		st.add("disabled", _disabled);
		st.add("expanded", _expanded);
		st.add("id", _id);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public StepElement setActive(Object value) {
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

	public StepElement removeActive() {
		this._active = null;
		return this;
	} 

	public StepElement setClasses(Object value) {
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

	public StepElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public StepElement setClassName(Object value) {
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

	public StepElement removeClassName() {
		this._className = null;
		return this;
	} 

	public StepElement setCompleted(Object value) {
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

	public StepElement removeCompleted() {
		this._completed = null;
		return this;
	} 

	public StepElement setDisabled(Object value) {
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

	public StepElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public StepElement setExpanded(Object value) {
		this._expanded = value;
		return this;
	}

	public Object getExpanded() {
		return this._expanded;
	}

	public Object getExpanded(Object defaultValue) {
		return this._expanded == null ? defaultValue : this._expanded;
	}

	public boolean hasExpanded() {
		return this._expanded != null;
	}

	public StepElement removeExpanded() {
		this._expanded = null;
		return this;
	} 

	public StepElement setId(Object value) {
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

	public StepElement removeId() {
		this._id = null;
		return this;
	} 

	public StepElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public StepElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StepElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public StepElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public StepElement removeChildren(int index) {
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
		StepElement that = (StepElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "StepElement(active,classes,className,completed,disabled,expanded,id,children) ::= <<<Step~if(active)~\n" + 
				"	active~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(completed)~\n" + 
				"	completed~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(expanded)~\n" + 
				"	expanded~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Step>~else~ />~endif~ >>";
}  