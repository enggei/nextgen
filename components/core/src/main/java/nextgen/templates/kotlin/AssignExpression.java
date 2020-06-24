package nextgen.templates.kotlin;

public class AssignExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _varExpression;
	private VarExpression _expression;

	AssignExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AssignExpression");
		st.add("varExpression", _varExpression);
		st.add("expression", _expression);
		return st.render().trim();
	}

	public AssignExpression setVarExpression(Expression value) {
		this._varExpression = value;
		return this;
	}

	public Expression getVarExpression() {
		return this._varExpression;
	}

	public Expression getVarExpression(Expression defaultValue) {
		return this._varExpression == null ? defaultValue : this._varExpression;
	}

	public boolean hasVarExpression() {
		return this._varExpression != null;
	}

	public AssignExpression removeVarExpression() {
		this._varExpression = null;
		return this;
	} 

	public AssignExpression setExpression(VarExpression value) {
		this._expression = value;
		return this;
	}

	public VarExpression getExpression() {
		return this._expression;
	}

	public VarExpression getExpression(VarExpression defaultValue) {
		return this._expression == null ? defaultValue : this._expression;
	}

	public boolean hasExpression() {
		return this._expression != null;
	}

	public AssignExpression removeExpression() {
		this._expression = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AssignExpression that = (AssignExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AssignExpression(varExpression,expression) ::= <<~varExpression~ = ~expression~ >>";
} 