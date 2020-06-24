package nextgen.templates.kotlin;

public class AssignExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _varName;
	private Expression _expression;

	AssignExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AssignExpression");
		st.add("varName", _varName);
		st.add("expression", _expression);
		return st.render().trim();
	}

	public AssignExpression setVarName(Expression value) {
		this._varName = value;
		return this;
	}

	public Expression getVarName() {
		return this._varName;
	}

	public Expression getVarName(Expression defaultValue) {
		return this._varName == null ? defaultValue : this._varName;
	}

	public boolean hasVarName() {
		return this._varName != null;
	}

	public AssignExpression removeVarName() {
		this._varName = null;
		return this;
	} 

	public AssignExpression setExpression(Expression value) {
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

	static final String st = "AssignExpression(varName,expression) ::= <<~varName~ = ~expression~ >>";
} 