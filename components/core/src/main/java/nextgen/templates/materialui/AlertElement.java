package nextgen.templates.materialui;

public class AlertElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _action;
	private Object _classes;
	private Object _className;
	private Object _closeText;
	private Object _color;
	private Object _icon;
	private Object _iconMapping;
	private Object _id;
	private Object _onClose;
	private Object _role;
	private Object _severity;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	AlertElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AlertElement");
		st.add("action", _action);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("closeText", _closeText);
		st.add("color", _color);
		st.add("icon", _icon);
		st.add("iconMapping", _iconMapping);
		st.add("id", _id);
		st.add("onClose", _onClose);
		st.add("role", _role);
		st.add("severity", _severity);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public AlertElement setAction(Object value) {
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

	public AlertElement removeAction() {
		this._action = null;
		return this;
	} 

	public AlertElement setClasses(Object value) {
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

	public AlertElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public AlertElement setClassName(Object value) {
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

	public AlertElement removeClassName() {
		this._className = null;
		return this;
	} 

	public AlertElement setCloseText(Object value) {
		this._closeText = value;
		return this;
	}

	public Object getCloseText() {
		return this._closeText;
	}

	public Object getCloseText(Object defaultValue) {
		return this._closeText == null ? defaultValue : this._closeText;
	}

	public boolean hasCloseText() {
		return this._closeText != null;
	}

	public AlertElement removeCloseText() {
		this._closeText = null;
		return this;
	} 

	public AlertElement setColor(Object value) {
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

	public AlertElement removeColor() {
		this._color = null;
		return this;
	} 

	public AlertElement setIcon(Object value) {
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

	public AlertElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public AlertElement setIconMapping(Object value) {
		this._iconMapping = value;
		return this;
	}

	public Object getIconMapping() {
		return this._iconMapping;
	}

	public Object getIconMapping(Object defaultValue) {
		return this._iconMapping == null ? defaultValue : this._iconMapping;
	}

	public boolean hasIconMapping() {
		return this._iconMapping != null;
	}

	public AlertElement removeIconMapping() {
		this._iconMapping = null;
		return this;
	} 

	public AlertElement setId(Object value) {
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

	public AlertElement removeId() {
		this._id = null;
		return this;
	} 

	public AlertElement setOnClose(Object value) {
		this._onClose = value;
		return this;
	}

	public Object getOnClose() {
		return this._onClose;
	}

	public Object getOnClose(Object defaultValue) {
		return this._onClose == null ? defaultValue : this._onClose;
	}

	public boolean hasOnClose() {
		return this._onClose != null;
	}

	public AlertElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public AlertElement setRole(Object value) {
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

	public AlertElement removeRole() {
		this._role = null;
		return this;
	} 

	public AlertElement setSeverity(Object value) {
		this._severity = value;
		return this;
	}

	public Object getSeverity() {
		return this._severity;
	}

	public Object getSeverity(Object defaultValue) {
		return this._severity == null ? defaultValue : this._severity;
	}

	public boolean hasSeverity() {
		return this._severity != null;
	}

	public AlertElement removeSeverity() {
		this._severity = null;
		return this;
	} 

	public AlertElement setVariant(Object value) {
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

	public AlertElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public AlertElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public AlertElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AlertElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public AlertElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public AlertElement removeChildren(int index) {
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
		AlertElement that = (AlertElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AlertElement(action,classes,className,closeText,color,icon,iconMapping,id,onClose,role,severity,variant,children) ::= <<<Alert~if(action)~\n" + 
				"	action=~action~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(closeText)~\n" + 
				"	closeText=\"~closeText~\"~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(iconMapping)~\n" + 
				"	iconMapping=~iconMapping~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(role)~\n" + 
				"	role=\"~role~\"~endif~~if(severity)~\n" + 
				"	severity=\"~severity~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Alert>~else~ />~endif~ >>";
}  