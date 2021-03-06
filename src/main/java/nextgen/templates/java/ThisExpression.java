package nextgen.templates.java;

public class ThisExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _typeName;

	ThisExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ThisExpression");
		st.add("typeName", _typeName);
		return st.render().trim();
	}

	public ThisExpression setTypeName(Object value) {
		this._typeName = value;
		return this;
	}

	public Object getTypeName() {
		return this._typeName;
	}

	public Object getTypeName(Object defaultValue) {
		return this._typeName == null ? defaultValue : this._typeName;
	}

	public boolean hasTypeName() {
		return this._typeName != null;
	}

	public ThisExpression removeTypeName() {
		this._typeName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ThisExpression that = (ThisExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ThisExpression(typeName) ::= <<this~if(typeName)~.~endif~~typeName~ >>";
}  