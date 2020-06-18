package nextgen.templates.javascript;

public class Element {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _props = new java.util.ArrayList<>();
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	Element(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Element");
		st.add("name", _name);
		for (Object o : _props) st.add("props", o);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public Element setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Element removeName() {
		this._name = null;
		return this;
	} 

	public Element addProps(Object value) {
		this._props.add(value);
		return this;
	}

	public Element setProps(Object[] value) {
		this._props.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Element setProps(java.util.Collection<Object> values) {
		this._props.addAll(values);
		return this;
	}

	public Element removeProps(Object value) {
		this._props.remove(value);
		return this;
	}

	public Element removeProps(int index) {
		this._props.remove(index);
		return this;
	}

	public java.util.List<Object> getProps() {
		return this._props;
	} 

	public Element addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public Element setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Element setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public Element removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public Element removeChildren(int index) {
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
		Element that = (Element) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Element(name,props,children) ::= <<<~name~~if(props)~ ~props:{it|~it~};separator=\" \"~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</~name~>~else~ />~endif~ >>";
} 