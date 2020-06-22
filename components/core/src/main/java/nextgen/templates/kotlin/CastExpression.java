package nextgen.templates.kotlin;

public class CastExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _expression;
	private TypeDeclaration _type;

	CastExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CastExpression");
		st.add("expression", _expression);
		st.add("type", _type);
		return st.render().trim();
	}

	public CastExpression setExpression(Expression value) {
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

	public CastExpression removeExpression() {
		this._expression = null;
		return this;
	} 

	public CastExpression setType(TypeDeclaration value) {
		this._type = value;
		return this;
	}

	public TypeDeclaration getType() {
		return this._type;
	}

	public TypeDeclaration getType(TypeDeclaration defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public CastExpression removeType() {
		this._type = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CastExpression that = (CastExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CastExpression(expression,type) ::= <<~expression~ as ~type~ >>";
} 