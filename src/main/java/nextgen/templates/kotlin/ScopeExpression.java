package nextgen.templates.kotlin;

public class ScopeExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _scope;
	private Expression _expression;

	ScopeExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ScopeExpression");
		st.add("scope", _scope);
		st.add("expression", _expression);
		return st.render().trim();
	}

	public ScopeExpression setScope(String value) {
		this._scope = value;
		return this;
	}

	public String getScope() {
		return this._scope;
	}

	public String getScope(String defaultValue) {
		return this._scope == null ? defaultValue : this._scope;
	}

	public boolean hasScope() {
		return this._scope != null;
	}

	public ScopeExpression removeScope() {
		this._scope = null;
		return this;
	} 

	public ScopeExpression setExpression(Expression value) {
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

	public ScopeExpression removeExpression() {
		this._expression = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ScopeExpression that = (ScopeExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ScopeExpression(scope,expression) ::= <<~scope~.~expression~ >>";
}  