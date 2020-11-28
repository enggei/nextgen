package nextgen.templates.kotlin;

public class StringValueExpression implements Expression, StringExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _literal;

	StringValueExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StringValueExpression");
		st.add("literal", _literal);
		return st.render().trim();
	}

	public StringValueExpression setLiteral(Object value) {
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

	public StringValueExpression removeLiteral() {
		this._literal = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		StringValueExpression that = (StringValueExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "StringValueExpression(literal) ::= <<\"~literal~\" >>";
}  