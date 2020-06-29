package nextgen.templates.kotlin;

public class StringLiteralExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _literal;

	StringLiteralExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StringLiteralExpression");
		st.add("literal", _literal);
		return st.render().trim();
	}

	public StringLiteralExpression setLiteral(Object value) {
		this._literal = value;
		return this;
	}

	public Object getLiteral() {
		return this._literal;
	}

	public Object getLiteral(Object defaultValue) {
		return this._literal == null ? defaultValue : this._literal;
	}

	public boolean hasLiteral() {
		return this._literal != null;
	}

	public StringLiteralExpression removeLiteral() {
		this._literal = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StringLiteralExpression that = (StringLiteralExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "StringLiteralExpression(literal) ::= <<\"~literal~\" >>";
}  