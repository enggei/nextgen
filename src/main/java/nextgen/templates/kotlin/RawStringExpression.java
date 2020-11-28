package nextgen.templates.kotlin;

public class RawStringExpression implements Expression, StringExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _rawString;

	RawStringExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RawStringExpression");
		st.add("rawString", _rawString);
		return st.render().trim();
	}

	public RawStringExpression setRawString(Object value) {
		this._rawString = value;
		return this;
	}

	public Object getRawString() {
		return this._rawString;
	}

	public Object getRawString(Object defaultValue) {
		return this._rawString == null ? defaultValue : this._rawString;
	}

	public boolean hasRawString() {
		return this._rawString != null;
	}

	public RawStringExpression removeRawString() {
		this._rawString = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RawStringExpression that = (RawStringExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RawStringExpression(rawString) ::= <<\"\"\"~rawString~\"\"\" >>";
}  