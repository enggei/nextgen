package nextgen.templates.javascript;

public class ExpressionStmt {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _expression;

	ExpressionStmt(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExpressionStmt");
		st.add("expression", _expression);
		return st.render().trim();
	}

	public ExpressionStmt setExpression(Object value) {
		this._expression = value;
		return this;
	}

	public Object getExpression() {
		return this._expression;
	}

	public Object getExpression(Object defaultValue) {
		return this._expression == null ? defaultValue : this._expression;
	}

	public boolean hasExpression() {
		return this._expression != null;
	}

	public ExpressionStmt removeExpression() {
		this._expression = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExpressionStmt that = (ExpressionStmt) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExpressionStmt(expression) ::= <<~expression~; >>";
} 