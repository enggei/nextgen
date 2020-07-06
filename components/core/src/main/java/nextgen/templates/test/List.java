package nextgen.templates.test;

public class List implements TestInterface {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _value = new java.util.ArrayList<>();

	List(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("list");
		for (Object o : _value) st.add("value", o);
		return st.render().trim();
	}


	public List addValue(Object value) {
		this._value.add(value);
		return this;
	}

	public List setValue(Object[] value) {
		this._value.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public List setValue(java.util.Collection<Object> values) {
		this._value.addAll(values);
		return this;
	}

	public List removeValue(Object value) {
		this._value.remove(value);
		return this;
	}

	public List removeValue(int index) {
		this._value.remove(index);
		return this;
	}

	public java.util.List<Object> getValue() {
		return this._value;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		List that = (List) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "list(value) ::= <<list : \n" + 
				"	~value:{it|~it~};separator=\"\\n\"~ >>";
}  