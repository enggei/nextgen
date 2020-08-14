package nextgen.templates.materialui;

public class StepButtonElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _icon;
	private Object _id;
	private Object _optional;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	StepButtonElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StepButtonElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("icon", _icon);
		st.add("id", _id);
		st.add("optional", _optional);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public StepButtonElement setClasses(Object value) {
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

	public StepButtonElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public StepButtonElement setClassName(Object value) {
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

	public StepButtonElement removeClassName() {
		this._className = null;
		return this;
	} 

	public StepButtonElement setIcon(Object value) {
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

	public StepButtonElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public StepButtonElement setId(Object value) {
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

	public StepButtonElement removeId() {
		this._id = null;
		return this;
	} 

	public StepButtonElement setOptional(Object value) {
		this._optional = value;
		return this;
	}

	public Object getOptional() {
		return this._optional;
	}

	public Object getOptional(Object defaultValue) {
		return this._optional == null ? defaultValue : this._optional;
	}

	public boolean hasOptional() {
		return this._optional != null;
	}

	public StepButtonElement removeOptional() {
		this._optional = null;
		return this;
	} 

	public StepButtonElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public StepButtonElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StepButtonElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public StepButtonElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public StepButtonElement removeChildren(int index) {
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
		StepButtonElement that = (StepButtonElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "StepButtonElement(classes,className,icon,id,optional,children) ::= <<<StepButton~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(optional)~\n" + 
				"	optional=~optional~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</StepButton>~else~ />~endif~ >>";
}  