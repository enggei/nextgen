package nextgen.templates.kotlin;

public class MutableListInitializer implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Expression> _expressions = new java.util.ArrayList<>();

	MutableListInitializer(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MutableListInitializer");
		for (Object o : _expressions) st.add("expressions", o);
		return st.render().trim();
	}


	public MutableListInitializer addExpressions(Expression value) {
		this._expressions.add(value);
		return this;
	}

	public MutableListInitializer setExpressions(Expression[] value) {
		this._expressions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MutableListInitializer setExpressions(java.util.Collection<Expression> values) {
		this._expressions.addAll(values);
		return this;
	}

	public MutableListInitializer removeExpressions(Expression value) {
		this._expressions.remove(value);
		return this;
	}

	public MutableListInitializer removeExpressions(int index) {
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
		MutableListInitializer that = (MutableListInitializer) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MutableListInitializer(expressions) ::= <<mutableListOf(~expressions:{it|~it~};separator=\", \"~) >>";
}  