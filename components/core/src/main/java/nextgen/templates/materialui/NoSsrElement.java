package nextgen.templates.materialui;

public class NoSsrElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _defer;
	private Object _fallback;
	private Object _id;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	NoSsrElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NoSsrElement");
		st.add("className", _className);
		st.add("defer", _defer);
		st.add("fallback", _fallback);
		st.add("id", _id);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public NoSsrElement setClassName(Object value) {
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

	public NoSsrElement removeClassName() {
		this._className = null;
		return this;
	} 

	public NoSsrElement setDefer(Object value) {
		this._defer = value;
		return this;
	}

	public Object getDefer() {
		return this._defer;
	}

	public Object getDefer(Object defaultValue) {
		return this._defer == null ? defaultValue : this._defer;
	}

	public boolean hasDefer() {
		return this._defer != null;
	}

	public NoSsrElement removeDefer() {
		this._defer = null;
		return this;
	} 

	public NoSsrElement setFallback(Object value) {
		this._fallback = value;
		return this;
	}

	public Object getFallback() {
		return this._fallback;
	}

	public Object getFallback(Object defaultValue) {
		return this._fallback == null ? defaultValue : this._fallback;
	}

	public boolean hasFallback() {
		return this._fallback != null;
	}

	public NoSsrElement removeFallback() {
		this._fallback = null;
		return this;
	} 

	public NoSsrElement setId(Object value) {
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

	public NoSsrElement removeId() {
		this._id = null;
		return this;
	} 

	public NoSsrElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public NoSsrElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NoSsrElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public NoSsrElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public NoSsrElement removeChildren(int index) {
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
		NoSsrElement that = (NoSsrElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NoSsrElement(className,defer,fallback,id,children) ::= <<<NoSsr~if(className)~\n" + 
				"	className=~className~~endif~~if(defer)~\n" + 
				"	defer~endif~~if(fallback)~\n" + 
				"	fallback=~fallback~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</NoSsr>~else~ />~endif~ >>";
}  