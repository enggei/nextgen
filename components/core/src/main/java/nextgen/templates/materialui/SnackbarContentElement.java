package nextgen.templates.materialui;

public class SnackbarContentElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _action;
	private Object _classes;
	private Object _className;
	private Object _id;
	private Object _message;
	private Object _role;

	SnackbarContentElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SnackbarContentElement");
		st.add("action", _action);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("id", _id);
		st.add("message", _message);
		st.add("role", _role);
		return st.render().trim();
	}

	public SnackbarContentElement setAction(Object value) {
		this._action = value;
		return this;
	}

	public Object getAction() {
		return this._action;
	}

	public Object getAction(Object defaultValue) {
		return this._action == null ? defaultValue : this._action;
	}

	public boolean hasAction() {
		return this._action != null;
	}

	public SnackbarContentElement removeAction() {
		this._action = null;
		return this;
	} 

	public SnackbarContentElement setClasses(Object value) {
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

	public SnackbarContentElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SnackbarContentElement setClassName(Object value) {
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

	public SnackbarContentElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SnackbarContentElement setId(Object value) {
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

	public SnackbarContentElement removeId() {
		this._id = null;
		return this;
	} 

	public SnackbarContentElement setMessage(Object value) {
		this._message = value;
		return this;
	}

	public Object getMessage() {
		return this._message;
	}

	public Object getMessage(Object defaultValue) {
		return this._message == null ? defaultValue : this._message;
	}

	public boolean hasMessage() {
		return this._message != null;
	}

	public SnackbarContentElement removeMessage() {
		this._message = null;
		return this;
	} 

	public SnackbarContentElement setRole(Object value) {
		this._role = value;
		return this;
	}

	public Object getRole() {
		return this._role;
	}

	public Object getRole(Object defaultValue) {
		return this._role == null ? defaultValue : this._role;
	}

	public boolean hasRole() {
		return this._role != null;
	}

	public SnackbarContentElement removeRole() {
		this._role = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SnackbarContentElement that = (SnackbarContentElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SnackbarContentElement(action,classes,className,id,message,role) ::= <<<SnackbarContent~if(action)~\n" + 
				"	action=~action~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(message)~\n" + 
				"	message=~message~~endif~~if(role)~\n" + 
				"	role=\"~role~\"~endif~ /> >>";
}  