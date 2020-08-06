package nextgen.templates.kotlin;

public class ComparisonExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _lhs;
	private ComparisonOperator _operator;
	private Expression _rhs;

	ComparisonExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ComparisonExpression");
		st.add("lhs", _lhs);
		st.add("operator", _operator);
		st.add("rhs", _rhs);
		return st.render().trim();
	}

	public ComparisonExpression setLhs(Expression value) {
		this._lhs = value;
		return this;
	}

	public Expression getLhs() {
		return this._lhs;
	}

	public Expression getLhs(Expression defaultValue) {
		return this._lhs == null ? defaultValue : this._lhs;
	}

	public boolean hasLhs() {
		return this._lhs != null;
	}

	public ComparisonExpression removeLhs() {
		this._lhs = null;
		return this;
	} 

	public ComparisonExpression setOperator(ComparisonOperator value) {
		this._operator = value;
		return this;
	}

	public ComparisonOperator getOperator() {
		return this._operator;
	}

	public ComparisonOperator getOperator(ComparisonOperator defaultValue) {
		return this._operator == null ? defaultValue : this._operator;
	}

	public boolean hasOperator() {
		return this._operator != null;
	}

	public ComparisonExpression removeOperator() {
		this._operator = null;
		return this;
	} 

	public ComparisonExpression setRhs(Expression value) {
		this._rhs = value;
		return this;
	}

	public Expression getRhs() {
		return this._rhs;
	}

	public Expression getRhs(Expression defaultValue) {
		return this._rhs == null ? defaultValue : this._rhs;
	}

	public boolean hasRhs() {
		return this._rhs != null;
	}

	public ComparisonExpression removeRhs() {
		this._rhs = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ComparisonExpression that = (ComparisonExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ComparisonExpression(lhs,operator,rhs) ::= <<~lhs~ ~operator~ ~rhs~ >>";
}  