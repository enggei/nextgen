package nextgen.templates.kotlin;

public class EqualsExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _lhs;
	private Expression _rhs;

	EqualsExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EqualsExpression");
		st.add("lhs", _lhs);
		st.add("rhs", _rhs);
		return st.render().trim();
	}

	public EqualsExpression setLhs(Expression value) {
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

	public EqualsExpression removeLhs() {
		this._lhs = null;
		return this;
	} 

	public EqualsExpression setRhs(Expression value) {
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

	public EqualsExpression removeRhs() {
		this._rhs = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EqualsExpression that = (EqualsExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EqualsExpression(lhs,rhs) ::= <<~lhs~ == ~rhs~ >>";
}  