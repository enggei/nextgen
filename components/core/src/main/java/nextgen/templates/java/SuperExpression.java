package nextgen.templates.java;

public class SuperExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _typeName;

	SuperExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SuperExpression that = (SuperExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SuperExpression");
		st.add("typeName", _typeName);
		return st.render().trim();
	}

	public SuperExpression setTypeName(Object value) {
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

	public SuperExpression removeTypeName() {
		this._typeName = null;
		return this;
	} 

	static final String st = "SuperExpression(typeName) ::= <<super~if(typeName)~.~endif~~typeName~>> ";
} 