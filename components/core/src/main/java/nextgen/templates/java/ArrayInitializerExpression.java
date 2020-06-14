package nextgen.templates.java;

public class ArrayInitializerExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _values = new java.util.ArrayList<>();

	ArrayInitializerExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayInitializerExpression");
		for (Object o : _values) st.add("values", o);
		return st.render().trim();
	}


	public ArrayInitializerExpression addValues(Object value) {
		this._values.add(value);
		return this;
	}

	public ArrayInitializerExpression setValues(Object[] value) {
		this._values.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ArrayInitializerExpression setValues(java.util.Collection<Object> values) {
		this._values.addAll(values);
		return this;
	}

	public ArrayInitializerExpression removeValues(Object value) {
		this._values.remove(value);
		return this;
	}

	public ArrayInitializerExpression removeValues(int index) {
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
		ArrayInitializerExpression that = (ArrayInitializerExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ArrayInitializerExpression(values) ::= <<{\n" + 
				"	~values:{it|~it~};separator=\",\\n\"~\n" + 
				"} >>";
} 