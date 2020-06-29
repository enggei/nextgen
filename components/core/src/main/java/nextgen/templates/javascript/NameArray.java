package nextgen.templates.javascript;

public class NameArray {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _values = new java.util.ArrayList<>();

	NameArray(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NameArray");
		st.add("name", _name);
		for (Object o : _values) st.add("values", o);
		return st.render().trim();
	}

	public NameArray setName(Object value) {
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

	public NameArray removeName() {
		this._name = null;
		return this;
	} 

	public NameArray addValues(Object value) {
		this._values.add(value);
		return this;
	}

	public NameArray setValues(Object[] value) {
		this._values.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NameArray setValues(java.util.Collection<Object> values) {
		this._values.addAll(values);
		return this;
	}

	public NameArray removeValues(Object value) {
		this._values.remove(value);
		return this;
	}

	public NameArray removeValues(int index) {
		this._values.remove(index);
		return this;
	}

	public java.util.List<Object> getValues() {
		return this._values;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NameArray that = (NameArray) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NameArray(values,name) ::= <<~name~ : [ ~values:{it|~it~};separator=\", \"~ ] >>";
}  