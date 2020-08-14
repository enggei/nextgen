package nextgen.templates.javascript;

public class Ul {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attributes = new java.util.ArrayList<>();

	Ul(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ul");
		st.add("className", _className);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attributes) st.addAggr("attributes.{name,value}", map.get("name"), map.get("value"));
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

	public Ul addAttributes(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attributes.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttributes() {
		return this._attributes;
	}

	public Ul addAttributes(Ul_Attributes value) {
		return addAttributes(value._name, value._value);
	}

	public java.util.stream.Stream<Ul_Attributes> streamAttributes() {
		return this._attributes.stream().map(Ul_Attributes::new);
	}

	public static final class Ul_Attributes {

		Object _name;
		Object _value;

		public Ul_Attributes(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private Ul_Attributes(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

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

	static final String st = "ul(className,attributes,children) ::= <<<ul ~if(className)~className=~className~~endif~~attributes:{it|~it.name~=~it.value~};separator=\" \"~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ul>~else~ />~endif~ >>";
}  