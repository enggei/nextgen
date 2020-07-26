package nextgen.templates.jsx;

public class Ul {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	Ul(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ul");
		st.add("className", _className);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public Ul setClassName(Object value) {
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

	public Ul removeClassName() {
		this._className = null;
		return this;
	} 

	public Ul addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public Ul setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Ul setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public Ul removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public Ul removeChildren(int index) {
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
		Ul that = (Ul) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ul(className,children) ::= <<<ul ~if(className)~className=~className~~endif~>\n" + 
				"	~children:{it|};separator=\"\\n\"~\n" + 
				"</ul> >>";
}  