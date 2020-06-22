package nextgen.templates.kotlin;

public class ExpressionInitializer implements Initializer {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _expression;

	ExpressionInitializer(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExpressionInitializer");
		st.add("expression", _expression);
		return st.render().trim();
	}

	public ExpressionInitializer setExpression(Expression value) {
		this._expression = value;
		return this;
	}

	public Expression getExpression() {
		return this._expression;
	}

	public Expression getExpression(Expression defaultValue) {
		return this._expression == null ? defaultValue : this._expression;
	}

	public boolean hasExpression() {
		return this._expression != null;
	}

	public ExpressionInitializer removeExpression() {
		this._expression = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExpressionInitializer that = (ExpressionInitializer) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExpressionInitializer(expression) ::= <<~expression~ >>";
} 