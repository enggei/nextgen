package nextgen.templates.materialui;

public class AppBarElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _id;
	private Object _position;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	AppBarElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AppBarElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("id", _id);
		st.add("position", _position);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public AppBarElement setClasses(Object value) {
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

	public AppBarElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public AppBarElement setClassName(Object value) {
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

	public AppBarElement removeClassName() {
		this._className = null;
		return this;
	} 

	public AppBarElement setColor(Object value) {
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

	public AppBarElement removeColor() {
		this._color = null;
		return this;
	} 

	public AppBarElement setId(Object value) {
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

	public AppBarElement removeId() {
		this._id = null;
		return this;
	} 

	public AppBarElement setPosition(Object value) {
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

	public AppBarElement removePosition() {
		this._position = null;
		return this;
	} 

	public AppBarElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public AppBarElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AppBarElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public AppBarElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public AppBarElement removeChildren(int index) {
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
		AppBarElement that = (AppBarElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AppBarElement(classes,className,color,id,position,children) ::= <<<AppBar~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(position)~\n" + 
				"	position=\"~position~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</AppBar>~else~ />~endif~ >>";
}  