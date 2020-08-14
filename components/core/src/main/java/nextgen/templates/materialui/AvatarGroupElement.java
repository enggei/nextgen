package nextgen.templates.materialui;

public class AvatarGroupElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _id;
	private Object _max;
	private Object _spacing;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	AvatarGroupElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AvatarGroupElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("id", _id);
		st.add("max", _max);
		st.add("spacing", _spacing);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public AvatarGroupElement setClasses(Object value) {
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

	public AvatarGroupElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public AvatarGroupElement setClassName(Object value) {
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

	public AvatarGroupElement removeClassName() {
		this._className = null;
		return this;
	} 

	public AvatarGroupElement setId(Object value) {
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

	public AvatarGroupElement removeId() {
		this._id = null;
		return this;
	} 

	public AvatarGroupElement setMax(Object value) {
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

	public AvatarGroupElement removeMax() {
		this._max = null;
		return this;
	} 

	public AvatarGroupElement setSpacing(Object value) {
		this._spacing = value;
		return this;
	}

	public Object getSpacing() {
		return this._spacing;
	}

	public Object getSpacing(Object defaultValue) {
		return this._spacing == null ? defaultValue : this._spacing;
	}

	public boolean hasSpacing() {
		return this._spacing != null;
	}

	public AvatarGroupElement removeSpacing() {
		this._spacing = null;
		return this;
	} 

	public AvatarGroupElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public AvatarGroupElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AvatarGroupElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public AvatarGroupElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public AvatarGroupElement removeChildren(int index) {
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
		AvatarGroupElement that = (AvatarGroupElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AvatarGroupElement(classes,className,id,max,spacing,children) ::= <<<AvatarGroup~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(max)~\n" + 
				"	max=~max~~endif~~if(spacing)~\n" + 
				"	spacing=\"~spacing~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</AvatarGroup>~else~ />~endif~ >>";
}  