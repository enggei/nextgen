package nextgen.templates.materialui;

public class BoxElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _id;
	private Object _mt;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	BoxElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BoxElement");
		st.add("className", _className);
		st.add("id", _id);
		st.add("mt", _mt);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public BoxElement setClassName(Object value) {
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

	public BoxElement removeClassName() {
		this._className = null;
		return this;
	} 

	public BoxElement setId(Object value) {
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

	public BoxElement removeId() {
		this._id = null;
		return this;
	} 

	public BoxElement setMt(Object value) {
		this._mt = value;
		return this;
	}

	public Object getMt() {
		return this._mt;
	}

	public Object getMt(Object defaultValue) {
		return this._mt == null ? defaultValue : this._mt;
	}

	public boolean hasMt() {
		return this._mt != null;
	}

	public BoxElement removeMt() {
		this._mt = null;
		return this;
	} 

	public BoxElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public BoxElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BoxElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public BoxElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public BoxElement removeChildren(int index) {
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
		BoxElement that = (BoxElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BoxElement(className,id,mt,children) ::= <<<Box~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(mt)~\n" + 
				"	mt=\"~mt~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Box>~else~ />~endif~ >>";
}  