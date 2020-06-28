package nextgen.templates.kotlin;

public class ArrayInitializer implements Initializer, Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Expression> _expressions = new java.util.ArrayList<>();

	ArrayInitializer(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayInitializer");
		for (Object o : _expressions) st.add("expressions", o);
		return st.render().trim();
	}


	public ArrayInitializer addExpressions(Expression value) {
		this._expressions.add(value);
		return this;
	}

	public ArrayInitializer setExpressions(Expression[] value) {
		this._expressions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ArrayInitializer setExpressions(java.util.Collection<Expression> values) {
		this._expressions.addAll(values);
		return this;
	}

	public ArrayInitializer removeExpressions(Expression value) {
		this._expressions.remove(value);
		return this;
	}

	public ArrayInitializer removeExpressions(int index) {
		this._expressions.remove(index);
		return this;
	}

	public java.util.List<Expression> getExpressions() {
		return this._expressions;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArrayInitializer that = (ArrayInitializer) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ArrayInitializer(expressions) ::= <<arrayOf(~expressions:{it|~it~};separator=\", \"~) >>";
}  