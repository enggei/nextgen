package nextgen.templates.materialui;

public class GrowElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _disableStrictModeCompat;
	private Object _id;
	private Object _in;
	private Object _timeout;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	GrowElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GrowElement");
		st.add("className", _className);
		st.add("disableStrictModeCompat", _disableStrictModeCompat);
		st.add("id", _id);
		st.add("in", _in);
		st.add("timeout", _timeout);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public GrowElement setClassName(Object value) {
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

	public GrowElement removeClassName() {
		this._className = null;
		return this;
	} 

	public GrowElement setDisableStrictModeCompat(Object value) {
		this._disableStrictModeCompat = value;
		return this;
	}

	public Object getDisableStrictModeCompat() {
		return this._disableStrictModeCompat;
	}

	public Object getDisableStrictModeCompat(Object defaultValue) {
		return this._disableStrictModeCompat == null ? defaultValue : this._disableStrictModeCompat;
	}

	public boolean hasDisableStrictModeCompat() {
		return this._disableStrictModeCompat != null;
	}

	public GrowElement removeDisableStrictModeCompat() {
		this._disableStrictModeCompat = null;
		return this;
	} 

	public GrowElement setId(Object value) {
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

	public GrowElement removeId() {
		this._id = null;
		return this;
	} 

	public GrowElement setIn(Object value) {
		this._in = value;
		return this;
	}

	public Object getIn() {
		return this._in;
	}

	public Object getIn(Object defaultValue) {
		return this._in == null ? defaultValue : this._in;
	}

	public boolean hasIn() {
		return this._in != null;
	}

	public GrowElement removeIn() {
		this._in = null;
		return this;
	} 

	public GrowElement setTimeout(Object value) {
		this._timeout = value;
		return this;
	}

	public Object getTimeout() {
		return this._timeout;
	}

	public Object getTimeout(Object defaultValue) {
		return this._timeout == null ? defaultValue : this._timeout;
	}

	public boolean hasTimeout() {
		return this._timeout != null;
	}

	public GrowElement removeTimeout() {
		this._timeout = null;
		return this;
	} 

	public GrowElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public GrowElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public GrowElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public GrowElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public GrowElement removeChildren(int index) {
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
		GrowElement that = (GrowElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "GrowElement(className,disableStrictModeCompat,id,in,timeout,children) ::= <<<Grow~if(className)~\n" + 
				"	className=~className~~endif~~if(disableStrictModeCompat)~\n" + 
				"	disableStrictModeCompat~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(in)~\n" + 
				"	in~endif~~if(timeout)~\n" + 
				"	timeout=\"~timeout~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Grow>~else~ />~endif~ >>";
}  