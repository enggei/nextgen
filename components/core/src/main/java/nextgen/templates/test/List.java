package nextgen.templates.test;

public class List {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Integer> _value = new java.util.ArrayList<>();

	List(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("list");
		for (Object o : _value) st.add("value", o);
		return st.render().trim();
	}

	public List addValue(Integer value) {
		this._value.add(value);
		return this;
	}

	public List removeValue(Integer value) {
		this._value.remove(value);
		return this;
	}

	public List removeValue(int index) {
		this._value.remove(index);
		return this;
	}

	public java.util.List<Integer> getValue() {
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

	static final String st = "list(value) ::= <<list : ~value:{it|~it~};separator=\", \"~>> ";
}  