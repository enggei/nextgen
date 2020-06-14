package nextgen.templates.javascript;

public class DestructorProp {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _child;
	private java.util.List<Object> _prop = new java.util.ArrayList<>();

	DestructorProp(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DestructorProp");
		st.add("child", _child);
		for (Object o : _prop) st.add("prop", o);
		return st.render().trim();
	}

	public DestructorProp setChild(Object value) {
		this._child = value;
		return this;
	}

	public Object getChild() {
		return this._child;
	}

	public Object getChild(Object defaultValue) {
		return this._child == null ? defaultValue : this._child;
	}

	public boolean hasChild() {
		return this._child != null;
	}

	public DestructorProp removeChild() {
		this._child = null;
		return this;
	} 

	public DestructorProp addProp(Object value) {
		this._prop.add(value);
		return this;
	}

	public DestructorProp setProp(Object[] value) {
		this._prop.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DestructorProp setProp(java.util.Collection<Object> values) {
		this._prop.addAll(values);
		return this;
	}

	public DestructorProp removeProp(Object value) {
		this._prop.remove(value);
		return this;
	}

	public DestructorProp removeProp(int index) {
		this._prop.remove(index);
		return this;
	}

	public java.util.List<Object> getProp() {
		return this._prop;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DestructorProp that = (DestructorProp) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DestructorProp(child,prop) ::= <<const { ~prop:{it|~it~};separator=\", \"~ } = this.props~if(child)~.~child~~endif~; >>";
} 