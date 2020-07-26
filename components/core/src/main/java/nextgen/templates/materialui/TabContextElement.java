package nextgen.templates.materialui;

public class TabContextElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _value;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	TabContextElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TabContextElement");
		st.add("className", _className);
		st.add("value", _value);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public TabContextElement setClassName(Object value) {
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

	public TabContextElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TabContextElement setValue(Object value) {
		this._value = value;
		return this;
	}

	public Object getValue() {
		return this._value;
	}

	public Object getValue(Object defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public TabContextElement removeValue() {
		this._value = null;
		return this;
	} 

	public TabContextElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TabContextElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TabContextElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TabContextElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TabContextElement removeChildren(int index) {
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
		TabContextElement that = (TabContextElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TabContextElement(className,value,children) ::= <<<TabContext~if(className)~\n" + 
				"	className=~className~~endif~\n" + 
				"	value=\"~value~\"~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TabContext>~else~ />~endif~ >>";
}  